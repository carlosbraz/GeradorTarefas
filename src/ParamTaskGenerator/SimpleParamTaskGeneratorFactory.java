/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParamTaskGenerator;

import escalonador.Constants;

/**
 * classe utiliza o padrao de projeto Simple Factory para determinar qual classe
 * que implementa a interface ParamTaskGeneratorAlg que deve ser instanciada
 * @author Carlos Ramon
 */
public class SimpleParamTaskGeneratorFactory {
    /**
     * Metodo para instanciar o tipo correto de ParamTaskGeneratorAlg
     * de acordo com o TaskGenerator informado
     * @param paramTaskGeneratorName
     * @return instancia da classe ParamTaskGeneratorAlg
     */
    public ParamTaskGeneratorAlg createParamTaskGenerator(int paramTaskGeneratorName){
        ParamTaskGeneratorAlg param = null;
        if(paramTaskGeneratorName == Constants.taskGeneratorAlgBasic){
            param = new ParamTaskGeneratorAlgBasic();
        }
        return param;
    }
    
}
