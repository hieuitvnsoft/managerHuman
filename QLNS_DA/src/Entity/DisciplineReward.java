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
public class DisciplineReward {
    String Id;
    String NameDis;
    boolean StatusDisciplineReward;

    public DisciplineReward() {
    }

    public DisciplineReward(String Id, String NameDis, boolean StatusDisciplineReward) {
        this.Id = Id;
        this.NameDis = NameDis;
        this.StatusDisciplineReward = StatusDisciplineReward;
    }

    @Override
    public String toString() {
        return this.NameDis; 
        
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNameDis() {
        return NameDis;
    }

    public void setNameDis(String NameDis) {
        this.NameDis = NameDis;
    }

    public boolean isStatusDisciplineReward() {
        return StatusDisciplineReward;
    }

    public void setStatusDisciplineReward(boolean StatusDisciplineReward) {
        this.StatusDisciplineReward = StatusDisciplineReward;
    }
    
    
}
