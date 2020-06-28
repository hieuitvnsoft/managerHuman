/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Department;
import Entity.Messager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhHieu
 */
public class ManagerDep {

    Connection conn;
    ConnectData kn = new ConnectData();

    public Vector<iforDep> getDep() throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_iforDep}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = cstt.executeQuery();
        Vector<iforDep> lstDep = new Vector<>();
        while (rs.next()) {
            iforDep d = new iforDep(rs.getString("IdDepartment"), rs.getString("NameDepartment"), rs.getString("PhoneDep"), rs.getString("TP"), rs.getString("PP"));
            lstDep.add(d);
        }

        return lstDep;

    }

    public void insertDp(Department dp) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareCall("insert into tblDeparment values(?,?,?) ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, dp.getId());
        cstt.setString(2, dp.getName());
        cstt.setString(3, dp.getPhone());
        int k = cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }
    }

    public void updateDp(Department dp) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareCall("Update tblDeparment set NameDepartment=?,PhoneDep=? where IdDepartment = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, dp.getName());
        cstt.setString(2, dp.getPhone());
        cstt.setString(3, dp.getId());
        int k = cstt.executeUpdate();
        if (k > 0) {
           Messager ms = new Messager();
            ms.upshowSuccess();
        }
    }

    public void deleteDp(String dp) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareCall("Delete from  tblDeparment where IdDepartment = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, dp);
        int k = cstt.executeUpdate();
        if (k > 0) {
            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.OK_OPTION,new ImageIcon("src/image/ss.png"));
        }
        
    }

    public class iforDep {

        String id;
        String name;
        String phone;
        String tp;
        String pp;

        public iforDep() {
        }

        public iforDep(String id, String name, String phone, String tp, String pp) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.tp = tp;
            this.pp = pp;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getTp() {
            return tp;
        }

        public void setTp(String tp) {
            this.tp = tp;
        }

        public String getPp() {
            return pp;
        }

        public void setPp(String pp) {
            this.pp = pp;
        }

    }
}
