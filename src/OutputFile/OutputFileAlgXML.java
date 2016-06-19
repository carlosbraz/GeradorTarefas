/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutputFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom.output.XMLOutputter;

/**
 * Classe que grava o arquivo xml
 * @author Carlos Ramon
 */
public class OutputFileAlgXML extends AbstractOutputFile{
    /**
     * Metodo que cria um arquivo xml utilizando o nome informado pelo usuario
     * e o Element criado na execução
     * @param nome nome do arquivo xml que será gravado 
     */
    @Override
    public void escreverArquivo(String nome){
        XMLOutputter xout = new XMLOutputter();    //Classe responsável para imprimir / gerar o XML
        try {
            FileWriter arquivo = new FileWriter(new File(nome));   //esse nome de arquivo precisa ser pego do controller
            xout.output(super.getOutputXML(), arquivo);             //Imprimindo o XML no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
