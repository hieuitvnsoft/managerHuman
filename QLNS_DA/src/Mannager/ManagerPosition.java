/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Messager;
import Entity.Position;
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
public class ManagerPosition {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public Vector<Position> getAllPosition() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call getPosition}");
        ResultSet rs = cStt.executeQuery();
        Vector<Position> lstPos = new Vector<>();
        while (rs.next()) {
            Position pos = new Position(rs.getString("idPosition"), rs.getString("namePosition"));
            lstPos.add(pos);
        }
        return lstPos;
    }

    public void insertPosition(Position ps) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement cStt = con.prepareStatement("Insert into tblPosition values (?,?)");
        cStt.setString(1, ps.getIdPosition());
        cStt.setString(2, ps.getNamePosition());
        int k = cStt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }
    }

    public void updatePosition(Position ps) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement cStt = con.prepareStatement("Update tblPosition set namePosition =? where idPosition=?");
        cStt.setString(1, ps.getNamePosition());
        cStt.setString(2, ps.getIdPosition());
        int k = cStt.executeUpdate();
        if (k > 0) {
           Messager ms = new Messager();
            ms.upshowSuccess();
        }
    }

    public void deletePosition(String n) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement cStt = con.prepareStatement("Delete tblPosition where idPosition = ?");
        cStt.setString(1, n);
        int k = cStt.executeUpdate();
        if (k > 0) {
           Messager ms = new Messager();
            ms.deleteshowSuccess();
        }
    }

    public int checkinsert(String n) throws SQLException {
        con = cnn.ConnectData();
        int check;
        PreparedStatement cStt = con.prepareStatement("SELECT * from tblPosition where IdPosition = ?");
        cStt.setString(1, n);
        ResultSet rs = cStt.executeQuery();
        if (!rs.next()) {
            check = 0;
        } else {
            check = 1;
        }
        return check;
    }
}
