/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.DREmp;
import Entity.DisciplineReward;
import Entity.Messager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.tools.Diagnostic;

/**
 *
 * @author THUY
 */
public class ManagerDisciplineReward {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public Vector<DisciplineReward> getAllDisRe() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call  getDisciplineReward }");
        ResultSet rs = cStt.executeQuery();
        Vector<DisciplineReward> lstDR = new Vector<>();
        while (rs.next()) {
            DisciplineReward dw = new DisciplineReward(rs.getString("Id"), rs.getString("NameDis"), rs.getBoolean("StatusDisciplineReward"));
            lstDR.add(dw);
        }
        return lstDR;
    }

    public Vector<Empxx> getEmp(String id) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call  getEmp (?) }");
        cStt.setString(1, id);
        ResultSet rs = cStt.executeQuery();
        Vector<Empxx> lstDR = new Vector<>();
        while (rs.next()) {
            Empxx dw = new Empxx(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NamePosition"));
            lstDR.add(dw);
        }
        return lstDR;
    }

    public void InsertDR(DisciplineReward dr) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("Insert into tblDisciplineReward values (?,?,?)");
        pstt.setString(1, dr.getId());
        pstt.setString(2, dr.getNameDis());
        pstt.setBoolean(3, dr.isStatusDisciplineReward());
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }

    }

    public void InsertDREmp(DREmp dr) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("{call insertEmpDR (?,?,?,?,?)}");
        pstt.setString(1, dr.getIdEmp());
        pstt.setString(2, dr.getIdDR());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        pstt.setString(3, df.format(dr.getDateDR()));
        pstt.setString(4, dr.getReson());
        pstt.setString(5, dr.getContent());
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }

    }

    public void UpdateDR(DisciplineReward dr) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("Update tblDisciplineReward set [NameDis] =?,[StatusDisciplineReward] =? where Id=?");
        pstt.setString(1, dr.getNameDis());
        pstt.setBoolean(2, dr.isStatusDisciplineReward());
        pstt.setString(3, dr.getId());
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        }
    }

    public void DelDR(String d) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("Delete from tblDisciplineReward where Id=?");
        pstt.setString(1, d);
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        }
    }

    public Vector<EmpDR> getEmpDR(String id) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call  getEmpDR (?) }");
        cStt.setString(1, id);
        ResultSet rs = cStt.executeQuery();
        Vector<EmpDR> lstDR = new Vector<>();
        while (rs.next()) {
            EmpDR dw = new EmpDR(rs.getString("IdEmp"), rs.getString("Id"), rs.getString("NameEmp"), rs.getString("NamePosition"), rs.getString("DateDR"), rs.getString("Reson"), rs.getString("Content"));
            lstDR.add(dw);
        }
        return lstDR;

    }

    public class EmpDR {

        String idemp;
        String id;
        String name;
        String cv;
        String date;
        String reson;
        String content;

        public String getIdemp() {
            return idemp;
        }

        public void setIdemp(String idemp) {
            this.idemp = idemp;
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

        public String getCv() {
            return cv;
        }

        public void setCv(String cv) {
            this.cv = cv;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getReson() {
            return reson;
        }

        public void setReson(String reson) {
            this.reson = reson;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public EmpDR() {
        }

        public EmpDR(String idemp, String id, String name, String cv, String date, String reson, String content) {
            this.idemp = idemp;
            this.id = id;
            this.name = name;
            this.cv = cv;
            this.date = date;
            this.reson = reson;
            this.content = content;
        }
    }

    public class Empxx {

        String Id;
        String Name;
        String cv;

        public Empxx(String Id, String Name, String cv) {
            this.Id = Id;
            this.Name = Name;
            this.cv = cv;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getCv() {
            return cv;
        }

        public void setCv(String cv) {
            this.cv = cv;
        }

        public Empxx() {
        }

        @Override
        public String toString() {
            return this.Id;
        }

    }

}
