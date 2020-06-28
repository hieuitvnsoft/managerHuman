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
public class Ethnic {
    String idEthnic;
    String name;

    public Ethnic() {
    }

    public Ethnic(String idEthnic, String name) {
        this.idEthnic = idEthnic;
        this.name = name;
    }

    public String getIdEthnic() {
        return idEthnic;
    }

    public void setIdEthnic(String idEthnic) {
        this.idEthnic = idEthnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
    
}
