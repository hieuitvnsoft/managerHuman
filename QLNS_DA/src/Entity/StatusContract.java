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
public class StatusContract {

    int Id;
    String NameStatus;

    public StatusContract(int Id, String NameStatus) {
        this.Id = Id;
        this.NameStatus = NameStatus;
    }

    public StatusContract() {
    }

    @Override
    public String toString() {
        return this.NameStatus;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameStatus() {
        return NameStatus;
    }

    public void setNameStatus(String NameStatus) {
        this.NameStatus = NameStatus;
    }

}
