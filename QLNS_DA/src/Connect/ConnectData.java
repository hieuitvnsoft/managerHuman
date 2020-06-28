/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhHieu
 */
public class ConnectData {
    final static String host="jdbc:sqlserver://localhost\\COACH-HIEU\\SQLEXPRESS:1433;databaseName=ManagerHR";
    final static String username="sa";
    final static String pass ="1234$";
    Connection conn;
    public Connection ConnectData() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(host, username, pass);
          
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi đạo đức");
            Logger.getLogger(ConnectData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Mời import JDBC");
            Logger.getLogger(ConnectData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        
    }
}
