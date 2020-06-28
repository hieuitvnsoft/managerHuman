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
public class SalaryBasic {
    String id;
    float SalaryBasic;

    public SalaryBasic() {
    }

    public SalaryBasic(String id, float SalaryBasic) {
        this.id = id;
        this.SalaryBasic = SalaryBasic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSalaryBasic() {
        return SalaryBasic;
    }

    public void setSalaryBasic(float SalaryBasic) {
        this.SalaryBasic = SalaryBasic;
    }

    @Override
    public String toString() {
        return this.id;
    }
    
}
