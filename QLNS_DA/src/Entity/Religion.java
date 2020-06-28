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
public class Religion {

    String idReligion;
    String name;

    public String getIdReligion() {
        return idReligion;
    }

    public void setIdReligion(String idReligion) {
        this.idReligion = idReligion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Religion() {
    }

    public Religion(String idReligion, String name) {
        this.idReligion = idReligion;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }

}
