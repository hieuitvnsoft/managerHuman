/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author AnhHieu
 */
public class ManagerReport {
    Connection con;
    Connect.ConnectData cnn = new ConnectData();
     public Vector<LevelRP> getEmpforPro(String n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{ call getcountLv (?) }");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<LevelRP> lstDep = new Vector<>();
        while (rs.next()) {
            LevelRP dep = new LevelRP(rs.getString("NameEdu"), rs.getInt("Count"));
            lstDep.add(dep);
        }
        return lstDep;
    }
    public class LevelRP{
    String name;
    int count;

        public LevelRP(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public LevelRP() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    
    
    }
}
