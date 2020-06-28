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
public class CountTimekeeping {
    String IdEmp;
    String Name;
    String Position;
    float salary;
    float coefficient;
    int Count;

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

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public CountTimekeeping(String IdEmp, String Name, String Position, float salary, float coefficient, int Count) {
        this.IdEmp = IdEmp;
        this.Name = Name;
        this.Position = Position;
        this.salary = salary;
        this.coefficient = coefficient;
        this.Count = Count;
    }

    public CountTimekeeping() {
    }
}
