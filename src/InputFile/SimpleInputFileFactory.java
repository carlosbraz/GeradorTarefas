/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFile;

import escalonador.Constants;

/**
 * classe utiliza o padrao de projeto Simple Factory para determinar qual
 * classe que implementa a interface InputFileAlg que deve ser instanciada
 * @author Carlos Ramon
 */
public class SimpleInputFileFactory {

    /**
     * Metodo para instanciar o tipo correto de InputFile 
     * de acordo com o TaskGenerator informado
     * @param inputFileName nome do Input file que deve ser instanciado
     * @return instancia da classe InputFileAlg
     */
    public InputFileAlg createInputFile(int inputFileName) {
        InputFileAlg input = null;
        if (inputFileName == Constants.taskGeneratorAlgBasic) {
            input = new InputFileAlgXML();
        }
        return input;
    }

}
