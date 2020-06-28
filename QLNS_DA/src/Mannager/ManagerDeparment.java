/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Entity.Deparment;
import Connect.ConnectData;
import Entity.Deparment;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author THUY
 */
public class ManagerDeparment {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public Vector<Deparment> getAllDeparment() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{ call getDeparment }");
        ResultSet rs = Cstt.executeQuery();
        Vector<Deparment> lstDep = new Vector<>();
        while (rs.next()) {
            Deparment dep = new Deparment(rs.getString("IdDepartment"), rs.getString("NameDepartment"), rs.getString("PhoneDep"));
            lstDep.add(dep);
        }
        return lstDep;
    }
}
