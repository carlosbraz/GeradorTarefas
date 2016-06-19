/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;



/**
 * Classe de constantes para identificar os Task Generator
 * cada um recebe um valor unico para ser utilizado no codigo 
 * @author Carlos Ramon
 */
public class Constants {
    public static final int taskGeneratorAlgBasic = 1;

    public static int getTaskGeneratorAlg(String nomeTask) {
        if(nomeTask.equals("TaskGeneratorAlgBasic")){
            return taskGeneratorAlgBasic;
        }
        
        return -1;
    }
    
    
}
