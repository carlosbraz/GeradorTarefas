/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFile;

import escalonador.Constants;




/**
 *
 * @author T
 */
public class SimpleInputFileFactory {
    public InputFileAlg createInputFile(int inputFileName){
        InputFileAlg input = null;
        if(inputFileName == Constants.taskGeneratorAlgBasic){
            input = new InputFileAlgXML();
        }
        return input;
    }
    
}
