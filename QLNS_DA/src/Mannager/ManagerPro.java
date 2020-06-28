/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.EmpPro;
import Entity.Messager;
import Entity.Project;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class ManagerPro {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public Vector<Emp> getEmpforPro(String n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{ call sp_GetEmpforPro (?) }");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<Emp> lstDep = new Vector<>();
        while (rs.next()) {
            Emp dep = new Emp(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NamePosition"));
            lstDep.add(dep);
        }
        return lstDep;
    }

    public Vector<Project> getPro() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{ call sp_getPro }");
        ResultSet rs = Cstt.executeQuery();
        Vector<Project> lstDep = new Vector<>();
        while (rs.next()) {
            Project dep = new Project(rs.getString("Id"), rs.getString("NamePro"), rs.getString("ContentPro"), rs.getDate("DateSign"), rs.getDate("DateDeadline"), rs.getFloat("ValPro"));
            lstDep.add(dep);
        }
        return lstDep;
    }

    public Vector<EmpPro> getEmpPro(String n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{ call sp_GetAllEmpPro (?) }");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<EmpPro> lstDep = new Vector<>();
        while (rs.next()) {
            EmpPro dep = new EmpPro(rs.getString("IdEmp"), rs.getString("IdPro"), rs.getDate("dateJoin"), rs.getString("Status"), rs.getInt("Roles"));
            lstDep.add(dep);
        }
        return lstDep;
    }

    public void InsertPro(Project n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{call sp_InsertPro (?,?,?,?,?,?)} ");
        Cstt.setString(1, n.getId());
        Cstt.setString(2, n.getNamePro());
        Cstt.setString(3, n.getContentPro());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Cstt.setString(4, df.format(n.getDateSign()));
        Cstt.setString(5, df.format(n.getDateDeadline()));
        Cstt.setFloat(6, n.getValPro());
        int k = Cstt.executeUpdate();
        if (k > 0) {
           Messager ms = new Messager();
            ms.insertshowSuccess();
        } 

    }

    public void InsertEmpPro(EmpPro n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{call sp_InsertEmpPro (?,?,?,?,?)}");
        Cstt.setString(1, n.getIdEmp());
        Cstt.setString(2, n.getIdPro());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Cstt.setString(3, df.format(n.getDateJoin()));
        Cstt.setString(4, n.getContent());
        Cstt.setFloat(5, n.getStatus());
        int k = Cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }

    }

    public void UpdatePro(Project n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{call sp_UpdatePro (?,?,?,?,?,?)} ");

        Cstt.setString(1, n.getNamePro());
        Cstt.setString(2, n.getContentPro());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Cstt.setString(3, df.format(n.getDateSign()));
        Cstt.setString(4, df.format(n.getDateDeadline()));
        Cstt.setFloat(5, n.getValPro());
        Cstt.setString(6, n.getId());
        int k = Cstt.executeUpdate();
        if (k > 0) {
           Messager ms = new Messager();
            ms.upshowSuccess();
        } 

    }

    public void UpdateEmpPro(EmpPro n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("{call updateEmpPro (?,?,?,?,?)} ");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Cstt.setString(1, df.format(n.getDateJoin()));
        Cstt.setString(2, n.getContent());
        Cstt.setFloat(3, n.getStatus());
        Cstt.setString(4, n.getIdEmp());
        Cstt.setString(5, n.getIdPro());
        int k = Cstt.executeUpdate();
        if (k > 0) {
           Messager ms = new Messager();
            ms.upshowSuccess();
        } 

    }

    public void DeleteEmpPro(String n, String idpro) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("Delete tblEmpPro where IdEmp =? and IdPro=?");

        Cstt.setString(1, n);
        Cstt.setString(2, idpro);
        int k = Cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        } 

    }

    public void DeletePro(String n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("Delete tblProject where Id =?");

        Cstt.setString(1, n);
        int k = Cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        } 

    }

    public int checkDeletePro(String n) throws SQLException {
        con = cnn.ConnectData();
        int check;
        CallableStatement Cstt = con.prepareCall("Select * from  tblEmpPro where IdPro =?");

        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        if (!rs.next()) {
            check = 0;
        } else {
            check = 1;
        }
        return check;
    }

    public int checkinsertPro(String n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("select * from tblProject where Id= ? ");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();

        int check;
        if (!rs.next()) {
            check = 0;
        } else {
            check = 1;
        }
        return check;
    }

    public int checkinsertEmpPro(String n, String id) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement Cstt = con.prepareCall("select * from tblEmpPro where IdEmp= ? and IdPro=? ");
        Cstt.setString(1, n);
        Cstt.setString(2, id);
        ResultSet rs = Cstt.executeQuery();

        int check;
        if (!rs.next()) {
            check = 0;
        } else {
            check = 1;
        }
        return check;
    }

    public class Emp {

        String id;
        String name;
        String cv;

        public Emp(String id, String name, String cv) {
            this.id = id;
            this.name = name;
            this.cv = cv;
        }

        public Emp() {
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

        @Override
        public String toString() {
            return this.id;
        }

    }
}
