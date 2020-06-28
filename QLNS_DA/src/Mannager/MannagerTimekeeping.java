/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Timekeeping;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhHieu
 */
public class MannagerTimekeeping {

    Connection conn;
    ConnectData kn = new ConnectData();

    public void insertTimekeep(Vector<Timekeeping> ls) throws SQLException {
        conn = kn.ConnectData();

        PreparedStatement cstt = conn.prepareStatement("INSERT INTO tblTimekeeping VALUES (?,?,?,?)");
        for (int i = 0; i < ls.size(); i++) {

            cstt.setString(1, ls.get(i).getId());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dates = df.format(ls.get(i).getDate());
            cstt.setString(2, dates); // 'yyyy-MM-dd hh:mm:ss' => 2018-01-19 16:29:59
            cstt.setBoolean(3, ls.get(i).isStt());
            cstt.setString(4, ls.get(i).getNote());
            cstt.addBatch();
        }

        int[] k = cstt.executeBatch();
        if (k.length>0) {
              JOptionPane.showMessageDialog(null, "Chấm công thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/ss.png"));
        }

    }

    public void updateTimekeep(Vector<Timekeeping> ls) throws SQLException {
        conn = kn.ConnectData();

        PreparedStatement cstt = conn.prepareStatement("Update tblTimekeeping set Status = ?,Note =? where IdEmp=? and DateTimekeeping = ?");
        for (int i = 0; i < ls.size(); i++) {
            cstt.setBoolean(1, ls.get(i).isStt());
            cstt.setString(2, ls.get(i).getNote());
            cstt.setString(3, ls.get(i).getId());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dates = df.format(ls.get(i).getDate());
            cstt.setString(4, dates); // 'yyyy-MM-dd hh:mm:ss' => 2018-01-19 16:29:59

            cstt.addBatch();
        }

         int[] k = cstt.executeBatch();
        if (k.length>0) {
              JOptionPane.showMessageDialog(null, "Sửa Chấm công thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/ss.png"));
        }

    }

    public Vector<edTimekeep> editTimekeep(String n, String d) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("exec sp_editTimekeep ?,?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, n);
        cstt.setString(2, d);
        ResultSet rs = cstt.executeQuery();
        Vector<edTimekeep> lstEmp = new Vector<>();
        while (rs.next()) {
            edTimekeep tk = new edTimekeep(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NameDepartment"), rs.getString("NamePosition"), rs.getBoolean("Status"), rs.getString("Note"));
            lstEmp.add(tk);
        }

        return lstEmp;

    }

    public int checkDateoff(String id) throws SQLException {
        int dayoff = 0;
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("exec sp_getNumDayoff ?");
        cstt.setString(1, id);
        ResultSet rs = cstt.executeQuery();
        while(rs.next()){
        dayoff=rs.getInt("DayOff");
        }
       
        return dayoff;

    }

    public void updateDateoffEmp(int k, String n) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareCall("update tblEmployee set tblEmployee.DayOff =? where IdEmp = ?");
        cstt.setInt(1, k);
        cstt.setString(2, n);
        cstt.executeUpdate();
    }

    public class edTimekeep {

        String id;
        String name;
        String pb;
        String cv;
        boolean stt;
        String note;

        public edTimekeep(String id, String name, String pb, String cv, boolean stt, String note) {
            this.id = id;
            this.name = name;
            this.pb = pb;
            this.cv = cv;
            this.stt = stt;
            this.note = note;
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

        public String getPb() {
            return pb;
        }

        public void setPb(String pb) {
            this.pb = pb;
        }

        public String getCv() {
            return cv;
        }

        public void setCv(String cv) {
            this.cv = cv;
        }

        public boolean isStt() {
            return stt;
        }

        public void setStt(boolean stt) {
            this.stt = stt;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public edTimekeep() {
        }

    }
}
