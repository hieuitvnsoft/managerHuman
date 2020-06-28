/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author THUY
 */
public class Contracts {
    String Id;
    Date DateSign;
    Date DateExpied;
    String ContenContract;
    int StatusContract;

    public Contracts() {
    }

    public Contracts(String Id, Date DateSign, Date DateExpied, String ContenContract, int StatusContract) {
        this.Id = Id;
        this.DateSign = DateSign;
        this.DateExpied = DateExpied;
        this.ContenContract = ContenContract;
        this.StatusContract = StatusContract;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Date getDateSign() {
        return DateSign;
    }

    public void setDateSign(Date DateSign) {
        this.DateSign = DateSign;
    }

    public Date getDateExpied() {
        return DateExpied;
    }

    public void setDateExpied(Date DateExpied) {
        this.DateExpied = DateExpied;
    }

    public String getContenContract() {
        return ContenContract;
    }

    public void setContenContract(String ContenContract) {
        this.ContenContract = ContenContract;
    }

    public int getStatusContract() {
        return StatusContract;
    }

    public void setStatusContract(int StatusContract) {
        this.StatusContract = StatusContract;
    }

    @Override
    public String toString() {
        return this.ContenContract;
    }

}
