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
import java.io.File;
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
 *
 * @author T
 */
public abstract class AbstractOutputFile {
    private ArrayList<ArrayList<TaskAlg>> listOutput = null;
    private Document outputXML = new Document();
    private Element outputXML1 = new Element("OutputFile");
    private XStream stream = new XStream(new DomDriver());
    private Element aux;
    
    public void gerarOutputXML() throws IOException{ //tera que ser pego cada list individualmente e gerado um element com atributo id
        int i = 1;                                   //todos esses list serao add no document outputXML
        this.stream.alias("Task", TaskAlgBasic.class);
        
        for (Iterator<ArrayList<TaskAlg>> iterator = listOutput.iterator(); iterator.hasNext();) {
            ArrayList<TaskAlg> next = iterator.next();
            this.aux = new Element("TaskSet");
            StringBuffer aux3 = new StringBuffer();
            for (int j = 0; j < next.size(); j++) {
                aux3.append(this.stream.toXML(next.get(j)));
            }
            String aux2 = aux3.toString();
            this.aux.setAttribute("id",Integer.toString(i));
            this.aux.setText(aux2);
            this.outputXML1.addContent(this.aux);
            i++;
        }
        this.outputXML.setRootElement(this.outputXML1);
    }

    public Document getOutputXML() {
        return outputXML;
    }

    public void setListOutput(ArrayList<ArrayList<TaskAlg>> listOutput) {
        this.listOutput = listOutput;
    }
    
    public void showDocument(){
        //this.outputXML.setDocType(.Element);
        System.out.println(" Este é o document gerado" + this.outputXML);
    }
    
    public void escreverArquivo(String nome){ 
       //System.out.println(" Nao era pra entrar aqui!! "); 
    }
    
    public void outputFileXMLAlgBasic(ArrayList<TaskAlgBasic> array){  //esse metodo deve colocar todos os list em elements
        Element taskSet = new Element("TaskSet");                          // enviara um element que recebera um ID do lado de fora 
        Element aux;
        Element task;
        for (Iterator<TaskAlgBasic> iterator = array.iterator(); iterator.hasNext();) {
            TaskAlgBasic next = iterator.next();
            
            task = new Element("task");
                aux = new Element("ID");
                aux.setText(Integer.toString(next.getId()));
                task.addContent(aux);

                aux = new Element("period");
                aux.setText("000");
                task.addContent(aux);

                aux = new Element("WCET");
                aux.setText("000");
                task.addContent(aux);

                taskSet.addContent(task);
            //aux.addContent();
        }
    }
}
