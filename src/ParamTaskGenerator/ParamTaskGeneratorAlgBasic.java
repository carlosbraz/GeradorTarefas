/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParamTaskGenerator;

import InputFile.InputFileAlgXML;
import escalonador.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que contém todos os parametros retirados do arquivo de entrada
 * do tipo AlgBasic
 * @author Carlos Ramon
 */
public class ParamTaskGeneratorAlgBasic implements ParamTaskGeneratorAlg{    
    private String maxAmountTask;
    private String minAmountTask;
    private String amount;
    private String utilMax;
    private String utilMin;
    
    @Override
    public void readValues(Map<String,String> value) {
        
        this.amount = value.get("amount");
        this.maxAmountTask = value.get("maxAmountTask");
        this.minAmountTask = value.get("minAmountTask");
        this.utilMax = value.get("utilMax");
        this.utilMin = value.get("utilMin");
    }

    @Override
    public int infoTaskGeneratorAlg() {    
        return Constants.taskGeneratorAlgBasic;
    }

    @Override
    public ParamTaskGeneratorAlg returnParam() {    
        return this;
    }

    public String getMaxAmountTask() {
        return maxAmountTask;
    }

    public String getMinAmountTask() {
        return minAmountTask;
    }

    public String getAmount() {
        return amount;
    }

    public String getUtilMax() {
        return utilMax;
    }

    public String getUtilMin() {
        return utilMin;
    }

    
}
