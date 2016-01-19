/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParamTaskGenerator;

import java.util.Map;

/**
 *
 * @author T
 */
public interface ParamTaskGeneratorAlg {
    
    /**
     * metodo que le todos os valores da classe InputFile 
     * e coloca os valores nos seus atributos
     * @param value Map<String,String> value
     */
    public void readValues(Map<String,String> value);
    
    /**
     * metodo que informa ao controller qual a classe TaskGenerator
     * que usará esses parametros ou a qual classe esses parametros pertencem
     * @return int/constante que representa o TaskGenerator
     */
    public int infoTaskGeneratorAlg();
    
    /**
     * Retorna todos os parametros obtidos da classe de input
     * @return 
     */
    public ParamTaskGeneratorAlg returnParam();
}
