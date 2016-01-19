/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskGenerator;

import ParamTaskGenerator.ParamTaskGeneratorAlgBasic;

/**
 *
 * @author T
 */
public interface TaskGeneratorAlg {
    
    /**
     * metodo que irá gerar todos os task necessarios 
     * com os parametros que estao na classe
     * ParamTaskGenerator
     */
    public void gerarTaskSet();
    
    /**
     * este metodo receberá a classe ParamTaskGeneratorAlg correspondente 
     * @param param
     */
    public void obterParamTaskGenerator(ParamTaskGeneratorAlgBasic param);
    
    public void obterTaskSet(TaskSet taskSet);
}
