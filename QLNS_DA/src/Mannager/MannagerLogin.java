/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Role;
import Entity.UserLogin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author AnhHieu
 */
public class MannagerLogin {

    Connection cnn;
    Connect.ConnectData con = new ConnectData();

    public Vector<UserLogin> checkLogin(String id) throws SQLException {
        cnn = con.ConnectData();
        CallableStatement Cstt = cnn.prepareCall("{call sp_checkLogin (?)}");
        Cstt.setString(1, id);
        ResultSet rs = Cstt.executeQuery();
        Vector<UserLogin> lstRole = new Vector<>();
        while (rs.next()) {
            UserLogin rl = new UserLogin(rs.getString("IdEmp"), rs.getString("NameEmp"),rs.getString("Username"),rs.getString("Pass"),rs.getInt("IdRole"));
            lstRole.add(rl);
        }
        return lstRole;
    }
}
