/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Employee;
import Entity.Role;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author THUY
 */
public class ManagerRole {

    Connection cnn;
    Connect.ConnectData con = new ConnectData();

    public Vector<Role> getAllRole() throws SQLException {
        cnn = con.ConnectData();
        CallableStatement Cstt = cnn.prepareCall("{call getRole}");
        ResultSet rs = Cstt.executeQuery();
        Vector<Role> lstRole = new Vector<>();
        while (rs.next()) {
            Role rl = new Role(rs.getInt("Id"), rs.getString("NameAccess"));
            lstRole.add(rl);
        }
        return lstRole;
    }

    public Vector<Rolle> checkRole(String n) throws SQLException {
        cnn = con.ConnectData();
        CallableStatement Cstt = cnn.prepareCall("{call sp_setRole (?)}");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<Rolle> lstRole = new Vector<>();
        while (rs.next()) {
            Rolle rl = new Rolle(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("Username"), rs.getString("Pass"), rs.getInt("Id"));
            lstRole.add(rl);
        }
        return lstRole;
    }

    public Vector<Employee> ValuePass(String n) throws SQLException {
        cnn = con.ConnectData();
        CallableStatement Cstt = cnn.prepareCall("{call sp_setRole (?)}");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<Employee> lstRole = new Vector<>();
        while (rs.next()) {
            Employee rl = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"), rs.getString("NameEmp"));
            lstRole.add(rl);
        }
        return lstRole;
    }

    public void UpdatePass(String n, String id) throws SQLException {
        cnn = con.ConnectData();
        CallableStatement Cstt = cnn.prepareCall("Update tblEmployee set Pass = ? where IdEmp=?");

        Cstt.setString(1, n);
        Cstt.setString(2, id);
        int k = Cstt.executeUpdate();
        if (k>0) {
            JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công", "Thông báo", JOptionPane.OK_OPTION,new ImageIcon("src/image/ss.png"));
        }
    }

    public class Rolle {

        String id;
        String name;
        String user;
        String pass;
        int role;

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

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public Rolle() {
        }

        public Rolle(String id, String name, String user, String pass, int role) {
            this.id = id;
            this.name = name;
            this.user = user;
            this.pass = pass;
            this.role = role;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }
}
