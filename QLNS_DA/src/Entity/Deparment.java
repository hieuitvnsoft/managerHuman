/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author THUY
 */
public class Deparment {
   String IdDepartment;
   String NameDepartment;
   String PhoneDep;

    public Deparment() {
    }

    public Deparment(String IdDepartment, String NameDepartment, String PhoneDep) {
        this.IdDepartment = IdDepartment;
        this.NameDepartment = NameDepartment;
        this.PhoneDep = PhoneDep;
    }

    @Override
    public String toString() {
        return this.NameDepartment; //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdDepartment() {
        return IdDepartment;
    }

    public void setIdDepartment(String IdDepartment) {
        this.IdDepartment = IdDepartment;
    }

    public String getNameDepartment() {
        return NameDepartment;
    }

    public void setNameDepartment(String NameDepartment) {
        this.NameDepartment = NameDepartment;
    }

    public String getPhoneDep() {
        return PhoneDep;
    }

    public void setPhoneDep(String PhoneDep) {
        this.PhoneDep = PhoneDep;
    }
   
}
