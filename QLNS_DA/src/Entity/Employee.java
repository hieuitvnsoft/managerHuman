/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author THUY
 */
public class Employee {

    String IdEmp;
    String Username;
    String Pass;

    public Employee(String IdEmp, String Username, String Pass, String NameEmp) {
        this.IdEmp = IdEmp;
        this.Username = Username;
        this.Pass = Pass;
        this.NameEmp = NameEmp;
    }

    public Employee(String IdEmp, String Username, String Pass) {
        this.IdEmp = IdEmp;
        this.Username = Username;
        this.Pass = Pass;
    }

    String NameEmp;
    Date BirthdayEmp;
    boolean Sex;
    int StatusMarriage;
    String PhoneEmp;
    String AddressEmp;
    String IdentityEmp;
    String IdProvince;
    String IdDistrict;
    String IdWard;
    String IdReligion;
    String IdEthnic;
    String IdRankSalary;
    String IdSalaryBasic;
    String IdContract;
    int IdRole;
    boolean Insurance;
    String IdDeparment;
    String IdPosition;
    int LevelEdu;
    String LanguageMaster;
    int DayOff;
    String NoteEmp;
    String Avarta;
    boolean StatusEmp;

    public Employee() {
    }

    public Employee(String IdEmp, String Username, String Pass, String NameEmp, Date BirthdayEmp, boolean Sex, int StatusMarriage, String PhoneEmp, String AddressEmp, String IdentityEmp, String IdProvince, String IdDistrict, String IdWard, String IdReligion, String IdEthnic, String IdRankSalary, String IdSalaryBasic, String IdContract, int IdRole, boolean Insurance, String IdDeparment, String IdPosition, int LevelEdu, String LanguageMaster, int DayOff, String NoteEmp, String Avarta, boolean StatusEmp) {
        this.IdEmp = IdEmp;
        this.Username = Username;
        this.Pass = Pass;
        this.NameEmp = NameEmp;
        this.BirthdayEmp = BirthdayEmp;
        this.Sex = Sex;
        this.StatusMarriage = StatusMarriage;
        this.PhoneEmp = PhoneEmp;
        this.AddressEmp = AddressEmp;
        this.IdentityEmp = IdentityEmp;
        this.IdProvince = IdProvince;
        this.IdDistrict = IdDistrict;
        this.IdWard = IdWard;
        this.IdReligion = IdReligion;
        this.IdEthnic = IdEthnic;
        this.IdRankSalary = IdRankSalary;
        this.IdSalaryBasic = IdSalaryBasic;
        this.IdContract = IdContract;
        this.IdRole = IdRole;
        this.Insurance = Insurance;
        this.IdDeparment = IdDeparment;
        this.IdPosition = IdPosition;
        this.LevelEdu = LevelEdu;
        this.LanguageMaster = LanguageMaster;
        this.DayOff = DayOff;
        this.NoteEmp = NoteEmp;
        this.Avarta = Avarta;
        this.StatusEmp = StatusEmp;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getNameEmp() {
        return NameEmp;
    }

    public void setNameEmp(String NameEmp) {
        this.NameEmp = NameEmp;
    }

    public Date getBirthdayEmp() {
        return BirthdayEmp;
    }

    public void setBirthdayEmp(Date BirthdayEmp) {
        this.BirthdayEmp = BirthdayEmp;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public int getStatusMarriage() {
        return StatusMarriage;
    }

    public void setStatusMarriage(int StatusMarriage) {
        this.StatusMarriage = StatusMarriage;
    }

    public String getPhoneEmp() {
        return PhoneEmp;
    }

    public void setPhoneEmp(String PhoneEmp) {
        this.PhoneEmp = PhoneEmp;
    }

    public String getAddressEmp() {
        return AddressEmp;
    }

    public void setAddressEmp(String AddressEmp) {
        this.AddressEmp = AddressEmp;
    }

    public String getIdentityEmp() {
        return IdentityEmp;
    }

    public void setIdentityEmp(String IdentityEmp) {
        this.IdentityEmp = IdentityEmp;
    }

    public String getIdProvince() {
        return IdProvince;
    }

    public void setIdProvince(String IdProvince) {
        this.IdProvince = IdProvince;
    }

    public String getIdDistrict() {
        return IdDistrict;
    }

    public void setIdDistrict(String IdDistrict) {
        this.IdDistrict = IdDistrict;
    }

    public String getIdWard() {
        return IdWard;
    }

    public void setIdWard(String IdWard) {
        this.IdWard = IdWard;
    }

    public String getIdReligion() {
        return IdReligion;
    }

    public void setIdReligion(String IdReligion) {
        this.IdReligion = IdReligion;
    }

    public String getIdEthnic() {
        return IdEthnic;
    }

    public void setIdEthnic(String IdEthnic) {
        this.IdEthnic = IdEthnic;
    }

    public String getIdRankSalary() {
        return IdRankSalary;
    }

    public void setIdRankSalary(String IdRankSalary) {
        this.IdRankSalary = IdRankSalary;
    }

    public String getIdSalaryBasic() {
        return IdSalaryBasic;
    }

    public void setIdSalaryBasic(String IdSalaryBasic) {
        this.IdSalaryBasic = IdSalaryBasic;
    }

    public String getIdContract() {
        return IdContract;
    }

    public void setIdContract(String IdContract) {
        this.IdContract = IdContract;
    }

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int IdRole) {
        this.IdRole = IdRole;
    }

    public boolean isInsurance() {
        return Insurance;
    }

    public void setInsurance(boolean Insurance) {
        this.Insurance = Insurance;
    }

    public String getIdDeparment() {
        return IdDeparment;
    }

    public void setIdDeparment(String IdDeparment) {
        this.IdDeparment = IdDeparment;
    }

    public String getIdPosition() {
        return IdPosition;
    }

    public void setIdPosition(String IdPosition) {
        this.IdPosition = IdPosition;
    }

    public int getLevelEdu() {
        return LevelEdu;
    }

    public void setLevelEdu(int LevelEdu) {
        this.LevelEdu = LevelEdu;
    }

    public String getLanguageMaster() {
        return LanguageMaster;
    }

    public void setLanguageMaster(String LanguageMaster) {
        this.LanguageMaster = LanguageMaster;
    }

    public int getDayOff() {
        return DayOff;
    }

    public void setDayOff(int DayOff) {
        this.DayOff = DayOff;
    }

    public String getNoteEmp() {
        return NoteEmp;
    }

    public void setNoteEmp(String NoteEmp) {
        this.NoteEmp = NoteEmp;
    }

    public String getAvarta() {
        return Avarta;
    }

    public void setAvarta(String Avarta) {
        this.Avarta = Avarta;
    }

    public boolean isStatusEmp() {
        return StatusEmp;
    }

    public void setStatusEmp(boolean StatusEmp) {
        this.StatusEmp = StatusEmp;
    }

    @Override
    public String toString() {
        return this.IdEmp;
    }

}
