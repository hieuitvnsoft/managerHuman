/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.Payroll;
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
 * @author AnhHieu
 */
public class MannagerPayroll {

    Connection con;
    Connect.ConnectData cnn = new ConnectData();

    public void insertPayroll(Vector<Payroll> ls) throws SQLException {
        con = cnn.ConnectData();
        con.setAutoCommit(false);
        PreparedStatement pstt = con.prepareStatement("{call insertPayroll(?,?,?,?,?,?)}");
        for (int i = 0; i < ls.size(); i++) {
            Object elementAt = ls.elementAt(i);
            pstt.setString(1, ls.get(i).getIdemp());
            System.out.println(ls.get(i).getIdemp());
            pstt.setString(2, ls.get(i).getMonth());
            pstt.setInt(3, ls.get(i).getCount());
            pstt.setFloat(4, ls.get(i).getRank());
            pstt.setFloat(5, ls.get(i).getSalary());
            pstt.setFloat(6, ls.get(i).getTotal());
            pstt.addBatch();
        }
        int r[] = pstt.executeBatch();
        con.commit();
        if (r.length > 0) {
            JOptionPane.showMessageDialog(null, "Đã lưu" + r.length + "", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public Vector<String> getMonth() throws SQLException {
        Vector<String> ls = new Vector<>();
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call getMoth}");
        ResultSet rs = cStt.executeQuery();
        while (rs.next()) {
            String month = rs.getString("MonthPay");
            ls.add(month);
        }
        return ls;
    }

    public Vector<Payrolls> getAll(String n, String c) throws SQLException {
        Vector<Payrolls> ls = new Vector<>();
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call getAllPayroll(?,?)}");
        cStt.setString(1, n);
        cStt.setString(2, c);
        ResultSet rs = cStt.executeQuery();
        while (rs.next()) {
            Payrolls pr = new Payrolls(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getInt("CountTime"), rs.getFloat("RankSalary"), rs.getFloat("SalaryBasic"), rs.getFloat("TotalSalary"));
            ls.add(pr);
        }
        return ls;
    }
     public Vector<Payrolls> getEmp(String n, String c,String Idemp) throws SQLException {
        Vector<Payrolls> ls = new Vector<>();
        con = cnn.ConnectData();
        CallableStatement cStt = con.prepareCall("{call getEmpd(?,?,?)}");
        cStt.setString(1, n);
        cStt.setString(2, c);
        cStt.setString(3, Idemp);
        ResultSet rs = cStt.executeQuery();
        while (rs.next()) {
            Payrolls pr = new Payrolls(rs.getString("IdEmp"), rs.getString("NameEmp"), rs.getInt("CountTime"), rs.getFloat("RankSalary"), rs.getFloat("SalaryBasic"), rs.getFloat("TotalSalary"));
            ls.add(pr);
        }
        return ls;
    }

    public class Payrolls {

        String IdEmp;

        String name;
        int count;
        float rank;
        float salary;
        float total;

        public Payrolls(String IdEmp, String name, int count, float rank, float salary, float total) {
            this.IdEmp = IdEmp;
            this.name = name;
            this.count = count;
            this.rank = rank;
            this.salary = salary;
            this.total = total;
        }

        public Payrolls() {
        }

        public String getIdEmp() {
            return IdEmp;
        }

        public void setIdEmp(String IdEmp) {
            this.IdEmp = IdEmp;
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

        public float getRank() {
            return rank;
        }

        public void setRank(float rank) {
            this.rank = rank;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }

        public float getTotal() {
            return total;
        }

        public void setTotal(float total) {
            this.total = total;
        }

    }
}
