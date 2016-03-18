/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFile;


import java.util.Map;

/**
 *
 * @author T
 */
public interface InputFileAlg {

    /**
     * Lê todo o arquivo e retira os dados que estão dentro dele
     * @param name
     */
    public void readValues(String name);

    /**
     * Pega os valores obtidos do arquivo de entrada e transfoma em dados
     * que podem ser lidos pelo resto do programa
     */
    public void normalizeValues();

    /**
     * Este metodo retorna um collection de valores lidos no arquivo de entrada,
     * para isto o metodo readValues deve ser chamado antes para poder obter 
     * estes valores do arquivo de entrada
     * @return Collections
     */
    public Map paramTaskGenerator();

    /**
     * Retorna o nome do TaskGenerator que irá utilizar os valores deste arquivo
     * @return String
     */
    public String taskGeneratorID();
    
    
}
