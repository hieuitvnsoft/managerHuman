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
public class District {
    String idDistrict;
    String name;
    String type;
    String idCity;

    public District() {
    }

    public District(String idDistrict, String name, String type, String idCity) {
        this.idDistrict = idDistrict;
        this.name = name;
        this.type = type;
        this.idCity = idCity;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
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

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

   
    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
