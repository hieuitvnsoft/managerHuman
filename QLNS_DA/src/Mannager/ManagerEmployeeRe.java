/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.EmployeeRe;
import Entity.Messager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author THUY
 */
public class ManagerEmployeeRe {

    Connection con;
    ConnectData conn = new ConnectData();

    public Vector<EmployeeRe> getEmpRe() throws SQLException {
        con = conn.ConnectData();
        CallableStatement cStt = con.prepareCall("exec getEmployeeRe '1'");
        ResultSet rs = cStt.executeQuery();
        Vector<EmployeeRe> lstEmpRe = new Vector<>();
        while (rs.next()) {
            EmployeeRe empRe = new EmployeeRe(rs.getString("IdEmpRe"),
                    rs.getString("NameEmp"), rs.getDate("BirthdayEmp"), rs.getBoolean("Sex"), rs.getInt("StatusMarriage"),
                    rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdentityEmp"), rs.getString("IdProvince"),
                    rs.getString("IdDistrict"), rs.getString("IdWard"), rs.getString("IdReligion"), rs.getString("IdEthnic"),
                    rs.getString("IdDepartment"),
                    rs.getString("IdPosition"),rs.getString("IdContract"), rs.getInt("LevelEdu"),
                    rs.getString("LanguageMaster"), rs.getString("NoteEmp"), rs.getString("Avarta"), rs.getBoolean("StatusEmp"));
            lstEmpRe.add(empRe);
        }
        return lstEmpRe;
    }

    public void AddRe(EmployeeRe add) throws SQLException {
        con = conn.ConnectData();
        CallableStatement cStt = con.prepareCall("exec sp_insertEmpRe ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
        cStt.setString(1, add.getIdEmpRe());
        cStt.setString(2, add.getNameEmpRe());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String bd = df.format(add.getBirthdayEmpRe());
        cStt.setString(3, bd);
        cStt.setBoolean(4, add.isSexRe());
        cStt.setInt(5, add.getStatusMarriageRe());
        cStt.setString(6, add.getPhoneEmpRe());
        cStt.setString(7, add.getAddressEmpRe());
        cStt.setString(8, add.getIdentityEmpRe());
        cStt.setString(9, add.getIdProvinceRe());
        cStt.setString(10, add.getIdDistrictRe());
        cStt.setString(11, add.getIdWardRe());
        cStt.setString(12, add.getIdReligionRe());
        cStt.setString(13, add.getIdEthnicRe());
        cStt.setString(14, add.getIdDepartmentRe());
        cStt.setString(15, add.getIdPositionRe());
         cStt.setString(16, add.getIdContract());
        cStt.setInt(17, add.getLevelEduRe());
        cStt.setString(18, add.getLanguageMasterRe());
        cStt.setString(19, add.getNoteEmpRe());
        cStt.setString(20, add.getAvataRe());
        cStt.setBoolean(21, add.isStatusEmp());
        int r = cStt.executeUpdate();
        if (r > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        } 
    }

    public void updateEmpRe(EmployeeRe update) throws SQLException {
        con = conn.ConnectData();
        CallableStatement Update = con.prepareCall("exec sp_updateEmpRe ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
        Update.setString(1, update.getNameEmpRe());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String bd = df.format(update.getBirthdayEmpRe());
        Update.setString(2, bd);
        Update.setBoolean(3, update.isSexRe());
        Update.setInt(4, update.getStatusMarriageRe());
        Update.setString(5, update.getPhoneEmpRe());
        Update.setString(6, update.getAddressEmpRe());
        Update.setString(7, update.getIdentityEmpRe());
        Update.setString(8, update.getIdProvinceRe());
        Update.setString(9, update.getIdDistrictRe());
        Update.setString(10, update.getIdWardRe());
        Update.setString(11, update.getIdReligionRe());
        Update.setString(12, update.getIdEthnicRe());
        Update.setString(13, update.getIdDepartmentRe());
        Update.setString(14, update.getIdPositionRe());
        Update.setString(15, update.getIdContract());
        Update.setInt(16, update.getLevelEduRe());
        Update.setString(17, update.getLanguageMasterRe());
        Update.setString(18, update.getNoteEmpRe());
        Update.setString(19, update.getAvataRe());
        Update.setBoolean(20, update.isStatusEmp());
        Update.setString(21, update.getIdEmpRe());
        int r = Update.executeUpdate();
        if (r >= 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        } 
    }

    public Vector<EmployeeRe> checkIdEmpRe(String IdEmpRe) throws SQLException {
        con = conn.ConnectData();
        int i = 0;
        PreparedStatement ckRe = con.prepareStatement("exec sp_EmpRebyId ? ");
        ckRe.setString(1, IdEmpRe);
        ResultSet rs = ckRe.executeQuery();
        Vector<EmployeeRe> ls = new Vector<>();
        while (rs.next()) {
            EmployeeRe lst = new EmployeeRe(rs.getString("IdEmp"));
            ls.add(lst);
        }
        return ls;
    }
public Vector<Empx> search(String nameEmp, String idDeparment) throws SQLException{
    con = conn.ConnectData();
    CallableStatement search = con.prepareCall("sp_searchEmpRe N'?',?");
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
    public Vector<Empx> searchDeparRe(String idDeparment) throws SQLException {
        con = conn.ConnectData();
        CallableStatement search = con.prepareCall("sp_searchEmpReByidDepar ?");
        search.setString(1, idDeparment);
        ResultSet rs = search.executeQuery();
        Vector<Empx> lstemp = new Vector<>();
        while (rs.next()) {
            Empx emp = new Empx(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getBoolean("Sex"), rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdDepartment"), rs.getString("IdPosition"), rs.getString("NoteEmp"));
            lstemp.add(emp);
        }
        return lstemp;
    }

    public EmployeeRe getEmpRebyId(String n) throws SQLException {
        con = conn.ConnectData();
        CallableStatement cStt = con.prepareCall("exec getEmpRebyID ?");
        cStt.setString(1, n);
        ResultSet rs = cStt.executeQuery();
        EmployeeRe empRe = null;
        while (rs.next()) {
            empRe = new EmployeeRe(rs.getString("IdEmpRe"),
                    rs.getString("NameEmp"), rs.getDate("BirthdayEmp"), rs.getBoolean("Sex"), rs.getInt("StatusMarriage"),
                    rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdentityEmp"), rs.getString("IdProvince"),
                    rs.getString("IdDistrict"), rs.getString("IdWard"), rs.getString("IdReligion"), rs.getString("IdEthnic"),
                    rs.getString("IdDepartment"),
                    rs.getString("IdPosition"),rs.getString("IdContract"), rs.getInt("LevelEdu"),
                    rs.getString("LanguageMaster"), rs.getString("NoteEmp"), rs.getString("Avarta"), rs.getBoolean("StatusEmp"));

        }
        return empRe;
    }

    public Vector<EmployeeRe> getStatusEmpRe() throws SQLException {
        con = conn.ConnectData();
        CallableStatement cStt = con.prepareCall("exec getEmpRebyStatus '0'");
        ResultSet rs = cStt.executeQuery();
        Vector<EmployeeRe> lstEmpRe = new Vector<>();
        while (rs.next()) {
            EmployeeRe empRe = new EmployeeRe(rs.getString("IdEmpRe"),
                    rs.getString("NameEmp"), rs.getDate("BirthdayEmp"), rs.getBoolean("Sex"), rs.getInt("StatusMarriage"),
                    rs.getString("PhoneEmp"), rs.getString("AddressEmp"), rs.getString("IdentityEmp"), rs.getString("IdProvince"),
                    rs.getString("IdDistrict"), rs.getString("IdWard"), rs.getString("IdReligion"), rs.getString("IdEthnic"),
                    rs.getString("IdDepartment"),
                    rs.getString("IdPosition"),rs.getString("IdContract"), rs.getInt("LevelEdu"),
                    rs.getString("LanguageMaster"), rs.getString("NoteEmp"), rs.getString("Avarta"), rs.getBoolean("StatusEmp"));
            lstEmpRe.add(empRe);
        }
        return lstEmpRe;
    }

    public class Empx {

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
