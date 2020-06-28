/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Contracts;
import Entity.Messager;
import Entity.StatusContract;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhHieu
 */
public class MannagerContracts {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public Vector<ListContract> search(String idContract) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement search = con.prepareCall("exec searchContractByID ? ");
        search.setString(1, idContract);
        ResultSet rs = search.executeQuery();
        Vector<ListContract> lct = new Vector<>();
        while (rs.next()) {
            ListContract ct = new ListContract(rs.getString("Id"), rs.getString("DateSign"), rs.getString("DateExpied"), rs.getString("ContenContract"), rs.getString("StatusContract"), rs.getString("IdEmp"), rs.getString("NameEmp"));
            lct.add(ct);
        }
        return lct;
    }

    public Vector<ListContract> getListContract(int n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call sp_getContract (?)}");
        cStt.setInt(1, n);
        ResultSet rs = cStt.executeQuery();
        Vector<ListContract> lstPos = new Vector<>();
        while (rs.next()) {
            ListContract pos = new ListContract(rs.getString("Id"), rs.getString("DateSign"), rs.getString("DateExpied"), rs.getString("ContenContract"), rs.getString("StatusContractName"), rs.getString("IdEmp"), rs.getString("NameEmp"));
            lstPos.add(pos);
        }
        return lstPos;
    }

    public Contracts getContract(String n) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement cStt = con.prepareStatement("select *from tblContracts where Id =?");
        cStt.setString(1, n);
        ResultSet rs = cStt.executeQuery();
        Contracts pos = null;
        while (rs.next()) {
            pos = new Contracts(rs.getString("Id"), rs.getDate("DateSign"), rs.getDate("DateExpied"), rs.getString("ContenContract"), rs.getInt("StatusContract"));

        }
        return pos;
    }

    public int checkInsert(String id) throws SQLException {
        int check;
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("SELECT * from tblContracts where Id= ?");
        pstt.setString(1, id);
        ResultSet rs = pstt.executeQuery();
        if (!rs.next()) {
            check = 0;
        } else {
            check = 1;
        }
        System.out.println(check);
        return check;
    }

    public void insertContract(Contracts ct) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement cStt = con.prepareStatement("insert into tblContracts values (?,?,?,?,?)");
        cStt.setString(1, ct.getId());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateb = df.format(ct.getDateSign());
        cStt.setString(2, dateb);
        String datee = df.format(ct.getDateExpied());
        cStt.setString(3, datee);
        cStt.setString(4, ct.getContenContract());
        cStt.setInt(5, ct.getStatusContract());
        int k = cStt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }

    }

    public void updateContract(Contracts ct) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement cStt = con.prepareStatement("{call updateContract (?,?,?,?,?)}");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateb = df.format(ct.getDateSign());
        cStt.setString(1, dateb);
        String datee = df.format(ct.getDateExpied());
        cStt.setString(2, datee);
        cStt.setString(3, ct.getContenContract());
        cStt.setInt(4, ct.getStatusContract());
        cStt.setString(5, ct.getId());
        int k = cStt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        }

    }

    public Vector<StatusContract> loadStt() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call sp_getStatusContract}");
        ResultSet rs = cStt.executeQuery();
        Vector<StatusContract> lstPos = new Vector<>();
        while (rs.next()) {
            StatusContract pos = new StatusContract(rs.getInt("Id"), rs.getString("StatusContractName"));
            lstPos.add(pos);
        }
        return lstPos;
    }

    public int checkDelete(String id) throws SQLException {
        int check;
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("SELECT * from tblEmployee where IdContract = ?");
        pstt.setString(1, id);
        ResultSet rs = pstt.executeQuery();
        if (!rs.next()) {
            check = 0;
        } else {
            check = 1;
        }
        return check;
    }

    public void DeleteContract(String n) throws SQLException {
        con = cnn.ConnectData();
        PreparedStatement pstt = con.prepareStatement("DELETE FROM tblContracts WHERE Id = ?");
        pstt.setString(1, n);
        int k = pstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        }
    }

    public class Contracx {

        String Id;
        String dateSign;
        String dateEnd;
        String Content;
        int Status;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getDateSign() {
            return dateSign;
        }

        public void setDateSign(String dateSign) {
            this.dateSign = dateSign;
        }

        public String getDateEnd() {
            return dateEnd;
        }

        public void setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public Contracx() {
        }

        public Contracx(String Id, String dateSign, String dateEnd, String Content, int Status) {
            this.Id = Id;
            this.dateSign = dateSign;
            this.dateEnd = dateEnd;
            this.Content = Content;
            this.Status = Status;
        }
    }

    public class ListContract {

        String Id;
        String dateSign;
        String dateEnd;
        String Content;
        String Status;
        String IdEmp;
        String NameEmp;

        public ListContract() {
        }

        public ListContract(String Id, String dateSign, String dateEnd, String Content, String Status, String IdEmp, String NameEmp) {
            this.Id = Id;
            this.dateSign = dateSign;
            this.dateEnd = dateEnd;
            this.Content = Content;
            this.Status = Status;
            this.IdEmp = IdEmp;
            this.NameEmp = NameEmp;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getDateSign() {
            return dateSign;
        }

        public void setDateSign(String dateSign) {
            this.dateSign = dateSign;
        }

        public String getDateEnd() {
            return dateEnd;
        }

        public void setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getIdEmp() {
            return IdEmp;
        }

        public void setIdEmp(String IdEmp) {
            this.IdEmp = IdEmp;
        }

        public String getNameEmp() {
            return NameEmp;
        }

        public void setNameEmp(String NameEmp) {
            this.NameEmp = NameEmp;
        }

    }
}
