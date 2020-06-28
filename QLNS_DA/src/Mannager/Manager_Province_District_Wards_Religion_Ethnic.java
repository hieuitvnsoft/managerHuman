/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Connect.ConnectData;
import Entity.District;
import Entity.Ethnic;
import Entity.Province;
import Entity.Religion;
import Entity.Wards;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author THUY
 */
public class Manager_Province_District_Wards_Religion_Ethnic {

    Connection connect;
    ConnectData cnn = new ConnectData();

    public Vector<Province> getAllProvince() throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("{call getProvince}");
        ResultSet rs = Cstt.executeQuery();
        Vector<Province> lstProvince = new Vector<>();
        while (rs.next()) {
            Province proc = new Province(rs.getString("idCity"), rs.getString("name"), rs.getString("type"));
            lstProvince.add(proc);
        }
        return lstProvince;
    }

    public Vector<District> getAllDistrict(String n) throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("exec getDistrict ?");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<District> lstDistrict = new Vector<>();
        while (rs.next()) {
            District dis = new District(rs.getString("IdDistrict"), rs.getString("Name"), rs.getString("Type"), rs.getString("IdCity"));
            lstDistrict.add(dis);
        }
        return lstDistrict;
    }

    public Vector<District> getDistrictDF(String n) throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("exec sp_District ?");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<District> lstDistrict = new Vector<>();
        while (rs.next()) {
            District dis = new District(rs.getString("IdDistrict"), rs.getString("Name"), rs.getString("Type"), rs.getString("IdCity"));
            lstDistrict.add(dis);
        }
        return lstDistrict;
    }

    public Vector<Wards> getWardsDF(String n) throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("exec sp_Wards ?");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<Wards> lstWards = new Vector<>();
        while (rs.next()) {
            Wards ward = new Wards(rs.getString("IdWard"), rs.getString("Name"), rs.getString("Type"), rs.getString("IdDistrict"));
            lstWards.add(ward);
        }
        return lstWards;
    }

    public Vector<District> getAllDistrictDF() throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("exec getDistrict ?");
        Cstt.setString(1, "01");
        ResultSet rs = Cstt.executeQuery();
        Vector<District> lstDistrict = new Vector<>();
        while (rs.next()) {
            District dis = new District(rs.getString("IdDistrict"), rs.getString("Name"), rs.getString("Type"), rs.getString("idCity"));
            lstDistrict.add(dis);
        }
        return lstDistrict;
    }

    public Vector<Wards> getAllWardsDF() throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("exec getWards ?");
        Cstt.setString(1, "001");
        ResultSet rs = Cstt.executeQuery();
        Vector<Wards> lstWards = new Vector<>();
        while (rs.next()) {
            Wards ward = new Wards(rs.getString("IdWard"), rs.getString("Name"), rs.getString("Type"), rs.getString("IdDistrict"));
            lstWards.add(ward);
        }
        return lstWards;
    }

    public Vector<Wards> getAllWards(String n) throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("exec getWards ?");
        Cstt.setString(1, n);
        ResultSet rs = Cstt.executeQuery();
        Vector<Wards> lstWards = new Vector<>();
        while (rs.next()) {
            Wards ward = new Wards(rs.getString("IdWard"), rs.getString("Name"), rs.getString("Type"), rs.getString("IdDistrict"));
            lstWards.add(ward);
        }
        return lstWards;
    }

    public Vector<Religion> getAllReligion() throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("{call getReligion}");
        ResultSet rs = Cstt.executeQuery();
        Vector<Religion> lstReligion = new Vector<>();
        while (rs.next()) {
            Religion reli = new Religion(rs.getString("idReligion"), rs.getString("name"));
            lstReligion.add(reli);
        }
        return lstReligion;
    }

    public Vector<Ethnic> getAllEthnic() throws SQLException {
        connect = cnn.ConnectData();
        CallableStatement Cstt = connect.prepareCall("{ call getEthnic}");
        ResultSet rs = Cstt.executeQuery();
        Vector<Ethnic> lstEthnic = new Vector<>();
        while (rs.next()) {
            Ethnic eth = new Ethnic(rs.getString("idEthnic"), rs.getString("name"));
            lstEthnic.add(eth);
        }
        return lstEthnic;
    }
}
