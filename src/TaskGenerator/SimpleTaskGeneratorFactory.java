/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskGenerator;

import escalonador.Constants;

/**
 *
 * @author T
 */
public class SimpleTaskGeneratorFactory {
    
        public TaskGeneratorAlg createParamTaskGenerator(int paramTaskGeneratorName){
        TaskGeneratorAlg task = null;
        if(paramTaskGeneratorName == Constants.taskGeneratorAlgBasic){
            task = new TaskGeneratorAlgBasic();
        }
        return task;
    }
    
}
