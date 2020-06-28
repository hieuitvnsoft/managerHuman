/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Contracts;
import Entity.Employee;
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

/**
 *
 * @author THUY
 */
public class ManagerEmployee {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public Vector<Employee> getAllEmp() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall(" exec getEmployee '1'");
        ResultSet rs = cStt.executeQuery();
        Vector<Employee> lstEmp = new Vector<>();
        while (rs.next()) {
            Employee emp = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"),
                    rs.getString("NameEmp"), rs.getDate("BirthdayEmp"), rs.getBoolean("Sex"), rs.getInt("StatusMarriage"),
                    rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdentityEmp"),
                    rs.getString("IdProvince"), rs.getString("IdDistrict"), rs.getString("IdWard"), rs.getString("IdReligion"),
                    rs.getString("IdEthnic"), rs.getString("IdRankSalary"), rs.getString("IdSalaryBasic"),
                    rs.getString("IdContract"), rs.getInt("IdRole"), rs.getBoolean("Insurance"), rs.getString("IdDepartment"),
                    rs.getString("IdPosition"), rs.getInt("LevelEdu"), rs.getString("LanguageMaster"), rs.getInt("DayOff"),
                    rs.getString("NoteEmp"), rs.getString("Avarta"),rs.getBoolean("StatusEmp"));
            lstEmp.add(emp);
        }
        return lstEmp;
    }

    public Employee getEmpbyId(String n) throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call sp_EmpbyID(?)}");
        cStt.setString(1, n);
        ResultSet rs = cStt.executeQuery();
        Employee emp = null;
        while (rs.next()) {
            emp = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"),
                    rs.getString("NameEmp"), rs.getDate("BirthdayEmp"), rs.getBoolean("Sex"), rs.getInt("StatusMarriage"),
                    rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdentityEmp"),
                    rs.getString("IdProvince"), rs.getString("IdDistrict"), rs.getString("IdWard"), rs.getString("IdReligion"),
                    rs.getString("IdEthnic"), rs.getString("IdRankSalary"), rs.getString("IdSalaryBasic"),
                    rs.getString("IdContract"), rs.getInt("IdRole"), rs.getBoolean("Insurance"), rs.getString("IdDepartment"),
                    rs.getString("IdPosition"), rs.getInt("LevelEdu"), rs.getString("LanguageMaster"), rs.getInt("DayOff"),
                    rs.getString("NoteEmp"), rs.getString("Avarta"),rs.getBoolean("StatusEmp"));
        }
        return emp;
    }

    public void Add(Employee add) throws SQLException {
        con = cnn.ConnectData();
        String sql = "exec sp_insertEmp ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
        CallableStatement cStt = con.prepareCall(sql);
        cStt.setString(1, add.getIdEmp());
        cStt.setString(2, add.getUsername());
        cStt.setString(3, add.getPass());
        cStt.setString(4, add.getNameEmp());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String bd = df.format(add.getBirthdayEmp());
        cStt.setString(5, bd);
        cStt.setBoolean(6, add.isSex());
        cStt.setInt(7, add.getStatusMarriage());
        cStt.setString(8, add.getPhoneEmp());
        cStt.setString(9, add.getAddressEmp());
        cStt.setString(10, add.getIdentityEmp());
        cStt.setString(11, add.getIdProvince());
        cStt.setString(12, add.getIdDistrict());
        cStt.setString(13, add.getIdWard());
        cStt.setString(14, add.getIdReligion());
        cStt.setString(15, add.getIdEthnic());
        cStt.setString(16, add.getIdRankSalary());
        cStt.setString(17, add.getIdSalaryBasic());
        cStt.setString(18, add.getIdContract());
        cStt.setInt(19, add.getIdRole());
        cStt.setBoolean(20, add.isInsurance());
        cStt.setString(21, add.getIdDeparment());
        cStt.setString(22, add.getIdPosition());
        cStt.setInt(23, add.getLevelEdu());
        cStt.setString(24, add.getLanguageMaster());
        cStt.setInt(25, add.getDayOff());
        cStt.setString(26, add.getNoteEmp());
        cStt.setString(27, add.getAvarta());
        cStt.setBoolean(28, add.isStatusEmp());
        int r = cStt.executeUpdate();
        if (r > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }
    }

    public void UpdateEmp(Employee upd) throws SQLException {

        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("exec update_Employee ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
        cStt.setString(1, upd.getUsername());
        cStt.setString(2, upd.getPass());
        cStt.setString(3, upd.getNameEmp());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String bd = df.format(upd.getBirthdayEmp());
        cStt.setString(4, bd);
        cStt.setInt(5, upd.isSex()==true?1:0);
        cStt.setInt(6, upd.getStatusMarriage());
        cStt.setString(7, upd.getPhoneEmp());
        cStt.setString(8, upd.getAddressEmp());
        cStt.setString(9, upd.getIdentityEmp());
        cStt.setString(10, upd.getIdProvince());
        cStt.setString(11, upd.getIdDistrict());
        cStt.setString(12, upd.getIdWard());
        cStt.setString(13, upd.getIdReligion());
        cStt.setString(14, upd.getIdEthnic());
        cStt.setString(15, upd.getIdRankSalary());
        cStt.setString(16, upd.getIdSalaryBasic());
        cStt.setString(17, upd.getIdContract());
        cStt.setInt(18, upd.getIdRole());
        cStt.setInt(19, upd.isInsurance()==true?1:0);
        cStt.setString(20, upd.getIdDeparment());
        cStt.setString(21, upd.getIdPosition());
        cStt.setInt(22, upd.getLevelEdu());
        cStt.setString(23, upd.getLanguageMaster());
        cStt.setInt(24, upd.getDayOff());
        cStt.setString(25, upd.getNoteEmp());
        cStt.setString(26, upd.getAvarta());
        cStt.setInt(27, upd.isStatusEmp()==true?1:0);
         cStt.setString(28, upd.getIdEmp());
        int r = cStt.executeUpdate();
        if (r >= 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        } 
    }
public Vector<Empx> search(String nameEmp, String idDeparment) throws SQLException{
    con = cnn.ConnectData();
    CallableStatement search = con.prepareCall("exec sp_searchEmp ?,?");
    search.setString(1, nameEmp);
    search.setString(2, idDeparment);
    ResultSet rs = search.executeQuery();
    Vector<Empx> lstemp = new Vector<>();
    while (rs.next()) {
         Empx emp = new Empx(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getBoolean("Sex"),rs.getString("PhoneEmp"), rs.getString("AddressEmp") , rs.getString("NameDepartment"), rs.getString("NamePosition"),rs.getString("NoteEmp"));
        lstemp.add(emp);
    }
   return lstemp;
}
public Vector<Empx> searchDepar( String idDeparment) throws SQLException{
    con = cnn.ConnectData();
    CallableStatement search = con.prepareCall("sp_searchEmpByidDepar ?");
    search.setString(1, idDeparment);
    ResultSet rs = search.executeQuery();
    Vector<Empx> lstemp = new Vector<>();
    while (rs.next()) {
        Empx emp = new Empx(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getBoolean("Sex"),rs.getString("PhoneEmp"), rs.getString("AddressEmp") , rs.getString("IdDepartment"), rs.getString("IdPosition"),rs.getString("NoteEmp"));
        lstemp.add(emp);
    }
   return lstemp;
}
    public Vector<Employee> checkIdEmp(String IdEmp) throws SQLException {
        con = cnn.ConnectData();
        int i = 0;
        PreparedStatement die = con.prepareStatement("exec sp_EmpbyId ? ");
        die.setString(1, IdEmp);
        ResultSet rs = die.executeQuery();
        Vector<Employee> ls = new Vector<>();
        while (rs.next()) {
            Employee lst = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"));
            ls.add(lst);
        }
        return ls;
    }

    public Vector<Contracts> checkContracts(String Id) throws SQLException {
        con = cnn.ConnectData();
        int i = 0;
        PreparedStatement die = con.prepareStatement("exec sp_ConById ? ");
        die.setString(1, Id);
        ResultSet rs = die.executeQuery();
        Vector<Contracts> lstCt = new Vector<>();
        while (rs.next()) {
            Contracts ct = new Contracts(rs.getString("Id"), rs.getDate("DateSign"), rs.getDate("DateExpied"), rs.getString("ContenContract"), rs.getInt("StatusContract"));
            lstCt.add(ct);
        }
        return lstCt;
    }

    public Vector<Employee> checkContractsEmp(String Id) throws SQLException {
        con = cnn.ConnectData();
        int i = 0;
        PreparedStatement die = con.prepareStatement("exec sp_EmpbyIdContract ? ");
        die.setString(1, Id);
        ResultSet rs = die.executeQuery();
        Vector<Employee> emp = new Vector<>();
        while (rs.next()) {
            Employee lstEp = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"));
            emp.add(lstEp);
        }
        return emp;
    }

    public Vector<Employee> checkUsernameEmp(String user) throws SQLException {
        con = cnn.ConnectData();
        int i = 0;
        PreparedStatement die = con.prepareStatement(" exec sp_EmpByUser ? ");
        die.setString(1, user);
        ResultSet rs = die.executeQuery();
        Vector<Employee> lemp = new Vector<>();
        while (rs.next()) {
            Employee lstEmp = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"));
            lemp.add(lstEmp);
        }
        return lemp;
    }
    public Vector<Employee> getStatusEmp() throws SQLException {
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("exec getEmpbyStatus '0' ");
        ResultSet rs = cStt.executeQuery();
        Vector<Employee> lstEmp = new Vector<>();
        while (rs.next()) {
            Employee emp = new Employee(rs.getString("IdEmp"), rs.getString("Username"), rs.getString("Pass"),
                    rs.getString("NameEmp"), rs.getDate("BirthdayEmp"), rs.getBoolean("Sex"), rs.getInt("StatusMarriage"),
                    rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdentityEmp"),
                    rs.getString("IdProvince"), rs.getString("IdDistrict"), rs.getString("IdWard"), rs.getString("IdReligion"),
                    rs.getString("IdEthnic"), rs.getString("IdRankSalary"), rs.getString("IdSalaryBasic"),
                    rs.getString("IdContract"), rs.getInt("IdRole"), rs.getBoolean("Insurance"), rs.getString("IdDepartment"),
                    rs.getString("IdPosition"), rs.getInt("LevelEdu"), rs.getString("LanguageMaster"), rs.getInt("DayOff"),
                    rs.getString("NoteEmp"), rs.getString("Avarta"),rs.getBoolean("StatusEmp"));
            lstEmp.add(emp);
        }
        return lstEmp;
    }
public class Empx{
   String id;
   String name;
   boolean sex;
   String phone;
   String address;
   String depar;
   String pos;
   String note;

        public Empx(String id, String name, boolean sex, String phone, String address, String depar, String pos, String note) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.phone = phone;
            this.address = address;
            this.depar = depar;
            this.pos = pos;
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

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDepar() {
            return depar;
        }

        public void setDepar(String depar) {
            this.depar = depar;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
   
   }
}
