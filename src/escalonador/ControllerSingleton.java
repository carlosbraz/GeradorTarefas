/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import InputFile.InputFileAlg;
import InputFile.InputFileAlgXML;
import InputFile.SimpleInputFileFactory;
import OutputFile.AbstractOutputFile;
import OutputFile.SimpleOutputFileFactory;
import ParamTaskGenerator.ParamTaskGeneratorAlg;
import ParamTaskGenerator.ParamTaskGeneratorAlgBasic;
import ParamTaskGenerator.SimpleParamTaskGeneratorFactory;
import TaskGenerator.SimpleTaskGeneratorFactory;
import TaskGenerator.TaskGeneratorAlg;
import TaskGenerator.TaskSet;
import java.io.File;
import java.io.IOException;

/**
 * Classe controller que gerência toda a aplicação
 *
 * @author T
 */
public class ControllerSingleton {

    private String nomeInputFile;  //nome do arquivo com as configurações iniciais
    private String nomeTaskGenerator;  // nome do TaskGenerator que será utilizado nessa interação
    private String nomeOutputFile;

    private ControllerSingleton() {
    }

    public static ControllerSingleton getInstance() {
        return ControllerSingletonHolder.INSTANCE;
    }

    private static class ControllerSingletonHolder {

        private static final ControllerSingleton INSTANCE = new ControllerSingleton();
    }

    public void iniciarGerador() throws IOException {
        InputFileAlg inp = ativarInput();
        ParamTaskGeneratorAlg param = ativarParamTask();
        TaskGeneratorAlg task = ativarTaskGenerator();
        TaskSet tSet = new TaskSet();
        AbstractOutputFile output = ativarOutputFile();

        inp.readValues(this.nomeInputFile);
        inp.normalizeValues();
        param.readValues(inp.paramTaskGenerator());
        task.obterParamTaskGenerator((ParamTaskGeneratorAlgBasic) param.returnParam());
        task.obterTaskSet(tSet);
        task.gerarTaskSet();
        //até essa parte os taskSets ja foram gerados, agora falta passar para o outputFile
        output.setListOutput(tSet.getTaskAlgs());
        output.gerarOutputXML();
        output.escreverArquivo(this.nomeOutputFile);
    }

    public InputFileAlg ativarInput() {
        SimpleInputFileFactory sInput = new SimpleInputFileFactory();
        InputFileAlg inp = sInput.createInputFile(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return inp;
    }

    public ParamTaskGeneratorAlg ativarParamTask() {
        SimpleParamTaskGeneratorFactory simParam = new SimpleParamTaskGeneratorFactory();
        ParamTaskGeneratorAlg param = simParam.createParamTaskGenerator(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return param;
    }

    public TaskGeneratorAlg ativarTaskGenerator() {
        SimpleTaskGeneratorFactory sTask = new SimpleTaskGeneratorFactory();
        TaskGeneratorAlg task = sTask.createParamTaskGenerator(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return task;
    }

    public AbstractOutputFile ativarOutputFile() {
        SimpleOutputFileFactory sOutput = new SimpleOutputFileFactory();
        AbstractOutputFile out = sOutput.createParamTaskGenerator(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return out;
    }

    public boolean testaParametrosIniciais(String inputFile, String taskGenerator) {//testa o arquivo inicial e descobre se ele existe, tambem testa o TaskGenerator
        if (escalonador.Constants.getTaskGeneratorAlg(taskGenerator) <= 0) { 
            return false;
        } else { 
            File file = new File(inputFile);
            if (!file.exists()){
                return false;
            }
            return true;
        }
    }
    
    public void iniciarPrograma() throws IOException{
        UserInterface user = new UserInterface();
        
        user.recebeParametrosIniciais();
        if(testaParametrosIniciais(user.getInput(), user.getTaskGenerator())){
            this.nomeInputFile = user.getInput();
            this.nomeOutputFile = user.getOutput();
            this.nomeTaskGenerator = user.getTaskGenerator();
            iniciarGerador();
        }else{
            //Exibir mensagem de erro!!
        }
    }
}
