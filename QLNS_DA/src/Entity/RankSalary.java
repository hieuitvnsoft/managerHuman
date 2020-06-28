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
public class RankSalary {
    int id;
    int idSpecial;
    String namerank;
    float Coeffcient;

    @Override
    public String toString() {
        return this.namerank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RankSalary(int id, String namerank, float Coeffcient) {
        this.id = id;
        this.namerank = namerank;
        this.Coeffcient = Coeffcient;
    }

    public int getIdSpecial() {
        return idSpecial;
    }

    public void setIdSpecial(int idSpecial) {
        this.idSpecial = idSpecial;
    }

    public String getNamerank() {
        return namerank;
    }

    public void setNamerank(String namerank) {
        this.namerank = namerank;
    }

    public float getCoeffcient() {
        return Coeffcient;
    }

    public void setCoeffcient(float Coeffcient) {
        this.Coeffcient = Coeffcient;
    }

    public RankSalary(int id, int idSpecial, String namerank, float Coeffcient) {
        this.id = id;
        this.idSpecial = idSpecial;
        this.namerank = namerank;
        this.Coeffcient = Coeffcient;
    }

    public RankSalary() {
    }
}
