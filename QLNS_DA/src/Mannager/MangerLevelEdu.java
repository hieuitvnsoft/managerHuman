/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.LevelEdu;
import Entity.Messager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author THUY
 */
public class MangerLevelEdu {

    Connection cnn;
    Connect.ConnectData con = new ConnectData();

    public Vector<LevelEdu> getAllEdu() throws SQLException {
        cnn = con.ConnectData();
        CallableStatement Cstt = cnn.prepareCall("{call getLevelEdu}");
        ResultSet rs = Cstt.executeQuery();
        Vector<LevelEdu> lstEdu = new Vector<>();
        while (rs.next()) {
            LevelEdu edu = new LevelEdu(rs.getInt("Id"), rs.getString("NameEdu"));
            lstEdu.add(edu);
        }
        return lstEdu;
    }

    public void InsertEdu(String name) throws SQLException {
        cnn = con.ConnectData();
        PreparedStatement pstt = cnn.prepareCall("Insert into tblLevelEdu values ?");
        pstt.setString(1, name);
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }
    }

    public void UpdateEdu(LevelEdu lv) throws SQLException {
        cnn = con.ConnectData();
        PreparedStatement pstt = cnn.prepareCall("Update table tblLevelEdu set  NameEdu= ? where Id =?");
        pstt.setString(1, lv.getName());
        pstt.setInt(2, lv.getId());
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        }
    }

    public void DeleteEdu(int id) throws SQLException {
        cnn = con.ConnectData();
        PreparedStatement pstt = cnn.prepareCall("DELETE FROM tblLevelEdu where Id =?");
        pstt.setInt(1, id);
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        }
    }

}
