/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author AnhHieu
 */
public class DREmp {

    String idEmp;
    String idDR;
    Date DateDR;
    String Reson;
    String Content;

    public DREmp() {
    }

    public DREmp(String idEmp, String idDR, Date DateDR, String Reson, String Content) {
        this.idEmp = idEmp;
        this.idDR = idDR;
        this.DateDR = DateDR;
        this.Reson = Reson;
        this.Content = Content;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getIdDR() {
        return idDR;
    }

    public void setIdDR(String idDR) {
        this.idDR = idDR;
    }

    public Date getDateDR() {
        return DateDR;
    }

    public void setDateDR(Date DateDR) {
        this.DateDR = DateDR;
    }

    public String getReson() {
        return Reson;
    }

    public void setReson(String Reson) {
        this.Reson = Reson;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
}
