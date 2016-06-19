/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.util.Scanner;

/**
 * Classe que gerencia a interação com o usuário
 * @author Carlos Ramon
 */
public class UserInterface {
    private String input = "InputFile.xml";
    private String output = "OutputFile.xml";
    private String taskGenerator = "TaskGeneratorAlgBasic";
        
    public void recebeParametrosIniciais(){//este metodo iniciara as strings acima
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite o nome do arquivo de entrada: ");//com a extensao 
        this.input = teclado.next();
        System.out.println("Digite o nome do arquivo de saida: ");//com a extensao 
        this.output = teclado.next();
        System.out.println("Digite o TaskGenerator que deseja utilizar: ");
        this.taskGenerator = teclado.next();
    }
    
    

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getTaskGenerator() {
        return taskGenerator;
    }

    public void setTaskGenerator(String taskGenerator) {
        this.taskGenerator = taskGenerator;
    }
    
    
}
