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
public class Role {
    int Id;
    String nameAccess;

    public Role() {
    }

    public Role(int Id, String nameAccess) {
        this.Id = Id;
        this.nameAccess = nameAccess;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameAccess() {
        return nameAccess;
    }

    public void setNameAccess(String nameAccess) {
        this.nameAccess = nameAccess;
    }

    @Override
    public String toString() {
        return this.nameAccess; //To change body of generated methods, choose Tools | Templates.
    }
    
}
