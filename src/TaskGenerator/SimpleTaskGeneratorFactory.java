/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskGenerator;

import escalonador.Constants;

/**
 * classe utiliza o padrao de projeto Simple Factory para determinar qual
 * classe que implementa a interface TaskAlg que deve ser instanciada
 * @author Carlos Ramon
 */
public class SimpleTaskGeneratorFactory {
    /**
     * Metodo para instanciar o tipo correto de TaskAlg 
     * de acordo com o TaskGenerator informado
     * @param paramTaskGeneratorName
     * @return instancia da classe TaskAlg
     */
    public TaskGeneratorAlg createParamTaskGenerator(int paramTaskGeneratorName) {
        TaskGeneratorAlg task = null;
        if (paramTaskGeneratorName == Constants.taskGeneratorAlgBasic) {
            task = new TaskGeneratorAlgBasic();
        }
        return task;
    }
}
