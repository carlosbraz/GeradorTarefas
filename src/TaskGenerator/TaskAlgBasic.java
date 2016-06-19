/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskGenerator;

/**
 * Classe que determina o tipo do TaskAlgBasic
 * @author Carlos Ramon
 */
public class TaskAlgBasic implements TaskAlg{

    private int ID;
    private int period;
    private int WCET;
    
    @Override
    public int getId() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getWCET() {
        return WCET;
    }

    public void setWCET(int WCET) {
        this.WCET = WCET;
    }
    
    
    
}
