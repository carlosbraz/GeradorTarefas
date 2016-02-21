/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import InputFile.InputFileAlg;
import InputFile.SimpleInputFileFactory;
import OutputFile.AbstractOutputFile;
import TaskGenerator.TaskSet;
import static escalonador.ControllerSingleton.getInstance;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author T
 */
public class Escalonador {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ControllerSingleton cont = getInstance() ;
        
        cont.iniciarPrograma();
    }
    
}
