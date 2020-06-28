/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author AnhHieu
 */
public class EmpSalary {
    String IdEmp;
    String Name;
    String NamePs;
    String NameRank;
    float coefficient;
     String NameSpce;
    String NameSalary;
    float salary;

    public EmpSalary() {
    }

    public EmpSalary(String IdEmp, String Name, String NamePs, String NameRank, float coefficient, String NameSpce, String NameSalary, float salary) {
        this.IdEmp = IdEmp;
        this.Name = Name;
        this.NamePs = NamePs;
        this.NameRank = NameRank;
        this.coefficient = coefficient;
        this.NameSpce = NameSpce;
        this.NameSalary = NameSalary;
        this.salary = salary;
    }

    

   

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNamePs() {
        return NamePs;
    }

    public void setNamePs(String NamePs) {
        this.NamePs = NamePs;
    }

    public String getNameSpce() {
        return NameSpce;
    }

    public void setNameSpce(String NameSpce) {
        this.NameSpce = NameSpce;
    }

    public String getNameRank() {
        return NameRank;
    }

    public void setNameRank(String NameRank) {
        this.NameRank = NameRank;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public String getNameSalary() {
        return NameSalary;
    }

    public void setNameSalary(String NameSalary) {
        this.NameSalary = NameSalary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
     
}
