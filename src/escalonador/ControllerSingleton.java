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
 * @author Carlos Ramon
 */
public class ControllerSingleton {

    private String nomeInputFile;
    private String nomeTaskGenerator;
    private String nomeOutputFile;

    private ControllerSingleton() {
    }

    public static ControllerSingleton getInstance() {
        return ControllerSingletonHolder.INSTANCE;
    }

    private static class ControllerSingletonHolder {

        private static final ControllerSingleton INSTANCE = new ControllerSingleton();
    }

    /**
     * Metodo que inicia a aplicação e chama todos os outros metodos em suas classes 
     * na ordem certa para a aplicação funcionar corretamente
     * @throws java.io.IOException
     */
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
        output.alteraLinha("&lt;", "<");
        output.alteraLinha("&gt;", ">");
    }

    /**
     * Ativa a Classe InputFile correspondente ao TaskGenerator digitado pelo usuário
     * @return InputFile
     */
    public InputFileAlg ativarInput() {
        SimpleInputFileFactory sInput = new SimpleInputFileFactory();
        InputFileAlg inp = sInput.createInputFile(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return inp;
    }

    /**
     * Ativa a Classe ParamTaskGenerator correspondente ao TaskGenerator digitado pelo usuário
     * @return ParamTaskGenerator
     */
    public ParamTaskGeneratorAlg ativarParamTask() {
        SimpleParamTaskGeneratorFactory simParam = new SimpleParamTaskGeneratorFactory();
        ParamTaskGeneratorAlg param = simParam.createParamTaskGenerator(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return param;
    }

    /**
     * Ativa a Classe TaskGenerator correspondente ao TaskGenerator digitado pelo usuário
     * @return TaskGeneratorAlg
     */
    public TaskGeneratorAlg ativarTaskGenerator() {
        SimpleTaskGeneratorFactory sTask = new SimpleTaskGeneratorFactory();
        TaskGeneratorAlg task = sTask.createParamTaskGenerator(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return task;
    }

    /**
     * Ativa a Classe OutputFile correspondente ao TaskGenerator digitado pelo usuário
     * @return AbstractOutputFile
     */
    public AbstractOutputFile ativarOutputFile() {
        SimpleOutputFileFactory sOutput = new SimpleOutputFileFactory();
        AbstractOutputFile out = sOutput.createParamTaskGenerator(Constants.getTaskGeneratorAlg(this.nomeTaskGenerator));

        return out;
    }

    /**
     * Testa se os parametros digitados pelo usuario são válidos
     * @param inputFile
     * @param taskGenerator
     * @return TRUE se os parametros são validos ou FALSE se os parametros são invalidos 
     */
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
    
    
    /**
     * Metodo que inicia a interação com o usuário recebendo os parametros iniciais
     * Utiliza a classe UserInterface para isso e no final chama o metodo iniciarGerador()
     * @throws IOException 
     */
    public void iniciarPrograma() throws IOException{
        UserInterface user = new UserInterface();
        
        user.recebeParametrosIniciais();
        if(testaParametrosIniciais(user.getInput(), user.getTaskGenerator())){
            this.nomeInputFile = user.getInput();
            this.nomeOutputFile = user.getOutput();
            this.nomeTaskGenerator = user.getTaskGenerator();
            iniciarGerador();
        }else{
            System.out.println("Erro! Arquivo de entrada ou TaskGenerator invalido");
            iniciarPrograma();
        }
    }
}
