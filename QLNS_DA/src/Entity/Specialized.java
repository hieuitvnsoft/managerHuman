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
public class Specialized {
    int id;
    String Specialized;

    public Specialized(int id, String Specialized) {
        this.id = id;
        this.Specialized = Specialized;
    }

    public Specialized() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialized() {
        return Specialized;
    }

    public void setSpecialized(String Specialized) {
        this.Specialized = Specialized;
    }

    @Override
    public String toString() {
        return this.Specialized;
    }
    
}
