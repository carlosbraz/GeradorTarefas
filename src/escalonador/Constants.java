/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;



/**
 *
 * @author T
 */
public class Constants {
    public static final int taskGeneratorAlgBasic = 1;

    public static int getTaskGeneratorAlg(String nomeTask) {
        if(nomeTask == "TaskGeneratorAlgBasic"){
            return taskGeneratorAlgBasic;
        }
        
        return -1;
    }
    
    
}
