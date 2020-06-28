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
public class Project {

    String Id;
    String NamePro;
    String ContentPro;
    Date DateSign;
    Date DateDeadline;
    float ValPro;

    public Project() {
    }

    public Project(String Id, String NamePro, String ContentPro, Date DateSign, Date DateDeadline, float ValPro) {
        this.Id = Id;
        this.NamePro = NamePro;
        this.ContentPro = ContentPro;
        this.DateSign = DateSign;
        this.DateDeadline = DateDeadline;
        this.ValPro = ValPro;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNamePro() {
        return NamePro;
    }

    public void setNamePro(String NamePro) {
        this.NamePro = NamePro;
    }

    public String getContentPro() {
        return ContentPro;
    }

    public void setContentPro(String ContentPro) {
        this.ContentPro = ContentPro;
    }

    public Date getDateSign() {
        return DateSign;
    }

    public void setDateSign(Date DateSign) {
        this.DateSign = DateSign;
    }

    public Date getDateDeadline() {
        return DateDeadline;
    }

    public void setDateDeadline(Date DateDeadline) {
        this.DateDeadline = DateDeadline;
    }

    public float getValPro() {
        return ValPro;
    }

    public void setValPro(float ValPro) {
        this.ValPro = ValPro;
    }

    @Override
    public String toString() {
        return this.Id;
    }

}
