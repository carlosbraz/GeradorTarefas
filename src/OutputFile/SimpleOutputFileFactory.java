/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutputFile;

import escalonador.Constants;

/**
 *
 * @author T
 */
public class SimpleOutputFileFactory {
     public AbstractOutputFile createParamTaskGenerator(int outputFileType){
        AbstractOutputFile out = null;
        if(outputFileType == Constants.taskGeneratorAlgBasic){
            out = new OutputFileAlgXML();
        }
        return out;
    }
}
