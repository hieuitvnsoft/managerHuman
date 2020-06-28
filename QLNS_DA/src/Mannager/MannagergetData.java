/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Department;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author AnhHieu
 */
public class MannagergetData {

    Connection conn;
    ConnectData kn = new ConnectData();

    public Vector getDepart() throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call getDeparment}");
        ResultSet rs = cstt.executeQuery();
        Vector<Department> lstDepartment = new Vector<>();
        while (rs.next()) {
            Department dp = new Department(rs.getString("IdDepartment"), rs.getString("NameDepartment"), rs.getString("PhoneDep"));
            lstDepartment.add(dp);
        }

        return lstDepartment;

    }

    public Vector getEmpTimekeeping(String n) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("exec sp_getEmpTimekeeping ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, n);
        ResultSet rs = cstt.executeQuery();
        Vector<TimeKeep> lstEmp = new Vector<>();
        while (rs.next()) {
            TimeKeep tk = new TimeKeep(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NameDepartment"), rs.getString("NamePosition"));
            lstEmp.add(tk);
        }

        return lstEmp;

    }

    public class TimeKeep {

        String id;
        String name;
        String dep;
        String pos;

        public TimeKeep(String id, String name, String dep, String pos) {
            this.id = id;
            this.name = name;
            this.dep = dep;
            this.pos = pos;
        }

        public TimeKeep() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDep() {
            return dep;
        }

        public void setDep(String dep) {
            this.dep = dep;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

    }

}
