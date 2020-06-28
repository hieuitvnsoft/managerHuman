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
public class EmpPro {

    String IdEmp;
    String IdPro;

    Date dateJoin;
    String content;
    int Status;

    public EmpPro() {
    }

    public EmpPro(String IdEmp, String IdPro, Date dateJoin, String content, int Status) {
        this.IdEmp = IdEmp;
        this.IdPro = IdPro;
        this.dateJoin = dateJoin;
        this.content = content;
        this.Status = Status;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }

    public String getIdPro() {
        return IdPro;
    }

    public void setIdPro(String IdPro) {
        this.IdPro = IdPro;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Date getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(Date dateJoin) {
        this.dateJoin = dateJoin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
