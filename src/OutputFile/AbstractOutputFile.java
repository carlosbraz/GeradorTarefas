/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutputFile;

import TaskGenerator.TaskAlg;
import TaskGenerator.TaskAlgBasic;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * Classe Abstract que efetua a criação do xml
 * que poderá ser utilizado para gerar outros arquivos
 * @author Carlos Ramon
 */
public abstract class AbstractOutputFile {
    //Array com todos os List de TaskAlg 
    private ArrayList<ArrayList<TaskAlg>> listOutput = null;
    //Atributo aonde sera gravado todos os Task para criar o arquivo final 
    private Document outputXML = new Document();
    //Elemento raiz do arquivo XML final
    private Element auxOutputXML = new Element("OutputFile");
    //Atributo da biblioteca XStream que sera utilizado para manipular XML
    private XStream stream = new XStream(new DomDriver());
    private Element aux;

    /**
     * Metodo que cria o Element com todos os Task 
     * que será inserido no arquivo xml
     * @throws IOException 
     */
    public void gerarOutputXML() throws IOException {
        int i = 1;
        this.stream.alias("Task", TaskAlgBasic.class);

        for (Iterator<ArrayList<TaskAlg>> iterator = listOutput.iterator(); iterator.hasNext();) {
            ArrayList<TaskAlg> next = iterator.next();
            this.aux = new Element("TaskSet");
            StringBuffer aux3 = new StringBuffer();
            for (int j = 0; j < next.size(); j++) {
                aux3.append(this.stream.toXML(next.get(j)));
            }
            String aux2 = aux3.toString();
            this.aux.setAttribute("id", Integer.toString(i));
            this.aux.setText(aux2);
            this.auxOutputXML.addContent(this.aux);
            i++;
        }
        this.outputXML.setRootElement(this.auxOutputXML);
    }

    /**
    * Metodo que concerta uma erro da biblioteca de XML
    * altera simbolos expecificos uma linha por vez
    * @param palavraAntiga palavra que será substituida
    * @param palavraNova palavra que será inserida
    * @throws java.io.IOException
    */
    public void alteraLinha(String palavraAntiga, String palavraNova) throws IOException {
        String arquivo = "OutputFile.xml";
        
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));

        String linha;
        String XmlCompleto = " ";
        String concatAux = " ";
        while ((linha = reader.readLine()) != null) {
            if (linha.contains(palavraAntiga)) {
                linha = linha.replace(palavraAntiga, palavraNova);
            }
            XmlCompleto += concatAux.concat(linha + "\n");
            
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
        writer.write(XmlCompleto);
        writer.close();

    }

    public Document getOutputXML() {
        return outputXML;
    }

    public void setListOutput(ArrayList<ArrayList<TaskAlg>> listOutput) {
        this.listOutput = listOutput;
    }

    public void showDocument() {
        //this.outputXML.setDocType(.Element);
        System.out.println(" Este é o document gerado" + this.outputXML);
    }

    public void escreverArquivo(String nome) { 
    }

    
}
