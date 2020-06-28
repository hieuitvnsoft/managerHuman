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
public class UserLogin {

    String IdEmp;
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public UserLogin(String IdEmp, String Name, String username, String password, int Role) {
        this.IdEmp = IdEmp;
        this.Name = Name;
        this.username = username;
        this.password = password;
        this.Role = Role;
    }
    String username;
    String password;
    int Role;

    public UserLogin() {
    }

    public UserLogin(String IdEmp, String username, String password, int Role) {
        this.IdEmp = IdEmp;
        this.username = username;
        this.password = password;
        this.Role = Role;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return this.Name;
    }

}
