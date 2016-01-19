/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que armazena todos os Task que forem criados na aplicação
 * independente do tipo do Task
 * @author T
 */
public class TaskSet {
    private ArrayList<ArrayList<TaskAlg>> taskAlgs = new ArrayList();
    
    public void addTaskSet(ArrayList<TaskAlg> list){
        this.taskAlgs.add(list);
    }
    
    public List<TaskAlg> returnTaskSet(int indice){
        return this.taskAlgs.get(indice);
    }

    public ArrayList<ArrayList<TaskAlg>> getTaskAlgs() {
        return taskAlgs;
    }
    
    public TaskSet returnClassTaskSet(){
        return this;
    }
}
