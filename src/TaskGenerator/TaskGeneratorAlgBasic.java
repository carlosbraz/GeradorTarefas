/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskGenerator;

import ParamTaskGenerator.ParamTaskGeneratorAlgBasic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T
 */
public class TaskGeneratorAlgBasic implements TaskGeneratorAlg{

    private ParamTaskGeneratorAlgBasic paramTask = null;
    private ArrayList<TaskAlg> tasks;
    private TaskAlgBasic task;
    private TaskSet taskSet;
    
    @Override
    public void gerarTaskSet() {
        int totalTaskSet = Integer.parseInt(this.paramTask.getAmount());
        int totalTask = Integer.parseInt(this.paramTask.getMaxAmountTask());
        
        for (int i = 1; i <= totalTaskSet; i++) {
            this.tasks = new ArrayList();
            for (int j = 1; j <= totalTask; j++) {
                this.task = new TaskAlgBasic();
                this.task.setID(j);
                this.task.setPeriod(000);
                this.task.setWCET(000);
                this.tasks.add(task);
            }
            addTaskSet(this.tasks);
        }
    }

    @Override
    public void obterParamTaskGenerator(ParamTaskGeneratorAlgBasic param) {
        this.paramTask = param;
    }
    
    public void addTaskSet(ArrayList<TaskAlg> task){
        this.taskSet.addTaskSet(task);
    }
    
    @Override
    public void obterTaskSet(TaskSet taskSet) {
        this.taskSet = taskSet;
    }
 
}
