/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.CountTimekeeping;
import Entity.EmpSalary;
import Entity.Messager;
import Entity.RankSalary;
import Entity.SalaryBasic;
import Entity.Specialized;
import Entity.Timekeeping;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhHieu
 */
public class MannagerSalary {

    Connection conn;
    ConnectData kn = new ConnectData();

    public Vector<Specialized> getSpecialized() throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_getSpecialized}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = cstt.executeQuery();
        Vector<Specialized> lstSp = new Vector<>();
        while (rs.next()) {
            Specialized d = new Specialized(rs.getInt("Id"), rs.getString("NameSpecial"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public Vector<RankSalary> getRank(int id) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_getNameRank (?)}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setInt(1, id);
        ResultSet rs = cstt.executeQuery();
        Vector<RankSalary> lstSp = new Vector<>();
        while (rs.next()) {
            RankSalary d = new RankSalary(rs.getInt("Id"), rs.getString("NameRank"), rs.getFloat("Coefficient"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public Vector<SalaryBasic> getSalaryBasic() throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_getSalaryBasic}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = cstt.executeQuery();
        Vector<SalaryBasic> lstSp = new Vector<>();
        while (rs.next()) {
            SalaryBasic d = new SalaryBasic(rs.getString("Id"), rs.getFloat("SalaryBasic"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public Vector<EmpSalary> getEmp(String n) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_getEmpsetSalary (?)}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, n);
        ResultSet rs = cstt.executeQuery();
        Vector<EmpSalary> lstSp = new Vector<>();
        while (rs.next()) {
            EmpSalary d = new EmpSalary(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NamePosition"), rs.getString("NameRank"), rs.getFloat("Coefficient"), rs.getString("NameSpecial"), rs.getString("Id"), rs.getFloat("SalaryBasic"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public Vector<EmpSalary> searchEmp(String n, String id) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_SearchEmpSalary (?,?)}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setString(1, n);
        cstt.setString(2, id);
        ResultSet rs = cstt.executeQuery();
        Vector<EmpSalary> lstSp = new Vector<>();
        while (rs.next()) {
            EmpSalary d = new EmpSalary(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NamePosition"), rs.getString("NameRank"), rs.getFloat("Coefficient"), rs.getString("NameSpecial"), rs.getString("Id"), rs.getFloat("SalaryBasic"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public Vector<RankSalary> Rank(int n) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_loadRank (?)}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        cstt.setInt(1, n);
        ResultSet rs = cstt.executeQuery();
        Vector<RankSalary> lstSp = new Vector<>();
        while (rs.next()) {
            RankSalary d = new RankSalary(rs.getInt("Id"), rs.getString("NameRank"), rs.getFloat("Coefficient"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public Vector<SalaryBasic> Salarybs() throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_loadRankSalarybasic}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = cstt.executeQuery();
        Vector<SalaryBasic> lstSp = new Vector<>();
        while (rs.next()) {
            SalaryBasic d = new SalaryBasic(rs.getString("Id"), rs.getFloat("SalaryBasic"));
            lstSp.add(d);
        }
        return lstSp;
    }

    public void updateSalaryEmp(SalaryEmp ls) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("Update tblEmployee set IdRankSalary = ?,IdSalaryBasic =? where IdEmp=?");
        cstt.setInt(1, ls.getIdRank());
        cstt.setString(2, ls.getIdSalarybasic());
        cstt.setString(3, ls.getIdEmp());
        int r = cstt.executeUpdate();
        if (r > 0) {
            JOptionPane.showMessageDialog(null, "Update thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/ss.png"));
        }

    }

    public void updateRankSalaryBasic(SalaryBasic sb) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("Update tblRankSalaryBasic set SalaryBasic = ? where Id =?");
        cstt.setFloat(1, sb.getSalaryBasic());
        cstt.setString(2, sb.getId());

        cstt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Update thành công");

    }

    public void insertRankSalaryBasic(SalaryBasic sb) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("Insert into tblRankSalaryBasic values (?,?)");

        cstt.setString(1, sb.getId());
        cstt.setFloat(2, sb.getSalaryBasic());
        cstt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Thêm mới thành công");

    }

    public void insertRank(RankSalary sb) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("Insert into tblRankSalaryBasic values (?,?,?)");

        cstt.setInt(1, sb.getIdSpecial());
        cstt.setString(2, sb.getNamerank());
        cstt.setFloat(3, sb.getCoeffcient());
        cstt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Thêm mới thành công");

    }

    public void deleteRankSalary(String id) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("delete from tblRankSalaryBasic where Id = ?");
        cstt.setString(1, id);
        cstt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Xóa thành công");

    }

    public void updateRank(RankSalary sb) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("{call sp_updateRank (?,?,?,?)}");
        cstt.setInt(1, sb.getIdSpecial());
        cstt.setString(2, sb.getNamerank());
        cstt.setFloat(2, sb.getCoeffcient());
        cstt.setInt(4, sb.getId());
        int k = cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        }

    }

    public void insetSp(Specialized sp) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("insert into tblSpecialized values ?");
        cstt.setString(1, sp.getSpecialized());
        int k = cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.insertshowSuccess();
        }
    }

    public void updateSP(Specialized sb) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("Update tblSpecialized set NameSpecial = ? where Id = ?");
        cstt.setString(1, sb.getSpecialized());
        cstt.setInt(2, sb.getId());
        int k = cstt.executeUpdate();
        if (k > 0) {
            Messager ms = new Messager();
            ms.upshowSuccess();
        }

    }

    public void deleteSp(int id) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("delete from tblSpecialized  where Id = ?");
        cstt.setInt(1, id);
        boolean k = cstt.execute();

        if (k == true) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        }

    }

    public void deleteRank(int id) throws SQLException {
        conn = kn.ConnectData();
        PreparedStatement cstt = conn.prepareStatement("delete from tblRankSalary  where Id = ?");
        cstt.setInt(1, id);
        boolean k = cstt.execute();

        if (k == true) {
            Messager ms = new Messager();
            ms.deleteshowSuccess();
        }

    }

    public Vector<CountTimekeeping> CalculatorSalary(String b, String e, String id) throws SQLException {
        conn = kn.ConnectData();
        CallableStatement cstt = conn.prepareCall("{call sp_CountTime (?,?,?)}");
        cstt.setString(1, b);
        cstt.setString(2, e);
        cstt.setString(3, id);
        ResultSet rs = cstt.executeQuery();

        Vector<CountTimekeeping> ct = new Vector<>();
        while (rs.next()) {
            CountTimekeeping d = new CountTimekeeping(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getString("NamePosition"), rs.getFloat("SalaryBasic"), rs.getFloat("Coefficient"), rs.getInt("DL"));
            ct.add(d);
        }
        return ct;

    }

    public class SalaryEmp {

        String idEmp;
        int idRank;
        String idSalarybasic;

        public SalaryEmp(String idEmp, int idRank, String idSalarybasic) {
            this.idEmp = idEmp;
            this.idRank = idRank;
            this.idSalarybasic = idSalarybasic;
        }

        public SalaryEmp() {
        }

        public String getIdEmp() {
            return idEmp;
        }

        public void setIdEmp(String idEmp) {
            this.idEmp = idEmp;
        }

        public int getIdRank() {
            return idRank;
        }

        public void setIdRank(int idRank) {
            this.idRank = idRank;
        }

        public String getIdSalarybasic() {
            return idSalarybasic;
        }

        public void setIdSalarybasic(String idSalarybasic) {
            this.idSalarybasic = idSalarybasic;
        }

    }
}
