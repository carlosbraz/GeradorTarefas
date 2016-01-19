/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParamTaskGenerator;

import escalonador.Constants;

/**
 *
 * @author T
 */
public class SimpleParamTaskGeneratorFactory {
    
    public ParamTaskGeneratorAlg createParamTaskGenerator(int paramTaskGeneratorName){
        ParamTaskGeneratorAlg param = null;
        if(paramTaskGeneratorName == Constants.taskGeneratorAlgBasic){
            param = new ParamTaskGeneratorAlgBasic();
        }
        return param;
    }
    
}
