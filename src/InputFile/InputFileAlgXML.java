/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author T
 */
public class InputFileAlgXML implements InputFileAlg{
    
    private Element elemento;
    private Element task;
    private Element taskSet;
    private Element utilization;
    private String maxAmountTask;
    private String minAmountTask;
    private String amount;
    private String utilMax;
    private String utilMin;
    private File arquivo;

    @Override
    public void readValues(String name) {
        try {
            this.arquivo = new File(name);
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(arquivo);
            this.elemento = (Element) doc.getRootElement();
        } catch (JDOMException ex) {
            Logger.getLogger(InputFileAlgXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InputFileAlgXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void normalizeValues() { 
        this.taskSet = this.elemento.getChild("TaskSet");
        this.task = this.taskSet.getChild("Task");
        this.utilization = this.taskSet.getChild("Utilization");
        this.maxAmountTask = this.task.getChildText("MaxAmount");
        this.minAmountTask = this.task.getChildText("MinAmount");
        this.amount = this.taskSet.getChildText("Amount");
        this.utilMax = this.utilization.getChildText("Max");    
        this.utilMin = this.utilization.getChildText("Min");
    }

    @Override
    public Map paramTaskGenerator() {
        Map<String,String> value = new HashMap<>();
        
        value.put("maxAmountTask", this.maxAmountTask);
        value.put("minAmountTask", this.minAmountTask);
        value.put("amount", this.amount);
        value.put("utilMax", this.utilMax);
        value.put("utilMin", this.utilMin);
        
        return value;
    }

    @Override
    public String taskGeneratorID() { 
        return "TaskGeneratorAlgBasic";
    }

    @Override
    public boolean textValues() {//aqui será testado se o arquivo existe
        return this.arquivo.exists();
    }
    
}
