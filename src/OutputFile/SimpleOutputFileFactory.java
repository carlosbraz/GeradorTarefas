/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutputFile;

import escalonador.Constants;

/**
 * classe utiliza o padrao de projeto Simple Factory para determinar qual classe
 * que implementa a interface OutputFileAlg que deve ser instanciada
 * @author Carlos Ramon
 */
public class SimpleOutputFileFactory {

    /**
     * Metodo para instanciar o tipo correto de OutputFile
     * de acordo com o TaskGenerator informado
     * @param outputFileName
     * @return instancia da classe OutputFileAlg
     */
    public AbstractOutputFile createParamTaskGenerator(int outputFileName) {
        AbstractOutputFile out = null;
        if (outputFileName == Constants.taskGeneratorAlgBasic) {
            out = new OutputFileAlgXML();
        }
        return out;
    }
}
