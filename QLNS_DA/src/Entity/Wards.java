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
public class Wards {
    String idWard;
    String name;
    String type;
    String idDistrict;

    public Wards() {
    }

    public Wards(String idWard, String name, String type, String idDistrict) {
        this.idWard = idWard;
        this.name = name;
        this.type = type;
        this.idDistrict = idDistrict;
    }

    
    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdWard() {
        return idWard;
    }

    public void setIdWard(String idWard) {
        this.idWard = idWard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }
    
}
