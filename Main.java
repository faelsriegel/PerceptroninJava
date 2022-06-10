 import java.util.Scanner;

/*Rede Neural Perceptron: recebe inputs, que são as amostras (entradas), cada entrada é multiplicada por um peso (sinaptico) e todos os resultados são somados, o valor dessa soma passa por uma função de ativação(sigmoide, tangente hiperbolica, gausiana), depois gera um valor output (saida do perceptron) que é comparada com o valor desejado, não sendo o esperado, os pesos serão reajustados para uma nova iteracao, esse processo de reajuste é realizado varias vezes até que a rede apresente o resultado desejado, e assim, essa rede neural estará treinada.)*/ 

public class Main{

public static void menu(){
  System.out.println("\n========= Perceptron =========\n");
  System.out.println("====== 1 - Lógica do OR  ======");
  System.out.println("====== 2 - Lógica do AND ======");
  System.out.println("====== 3 - Lógica do NOT ======\n");
  System.out.print("Selecione a Opcao desejada:");

    System.out.print("\n\n");
}
  public static void logicaOR(){//função da logica OU
  // Lógica do OR
        double[][] inputs = { //entradas do OU
            new double[]{0, 0}, // entradas e saida desejada: 0
            new double[]{0, 1}, // entradas e saida desejada: 1
            new double[]{1, 0}, // entradas e saida desejada: 1
            new double[]{1, 1}  // entradas e saida desejada: 1
        };
        double[] desired = { 0, 1, 1, 1 };//valor desejado
RedeNeural net = new RedeNeural(inputs, 10);
net.practice(desired);

        for(int i = 0; i < inputs.length; i++) {
System.out.println();
            String output = (net.run(inputs[i]) < 0.5)? "0" : "1";//condição para achar o valor desejado
System.out.println("\n========= Output Perceptron =========\n");
            System.out.println("Valor de Saida do Perceptron:\t"+(output));
        }}
public static void logicaAND(){ //função da logica E
            // Lógica do AND
        double[][] inputs2 = { //entradas do E
            new double[]{0, 0}, //entradas e saida desejada: 0 
            new double[]{0, 1}, //entradas e saida desejada: 0
            new double[]{1, 0}, //entradas e saida desejada: 0
            new double[]{1, 1}  //entradas e saida desejada: 1
        };
        
        double[] desired2 = { 0, 0, 0, 1 };//valor desejado
RedeNeural net2 = new RedeNeural(inputs2, 10);//tentativa
net2.practice(desired2);

        for(int i = 0; i < inputs2.length; i++) {
            String output = (net2.run(inputs2[i]) < 0.5)? "0" : "1"; //condição para achar o valor desejado

             System.out.println("\n========= Output Perceptron =========\n");
            System.out.println("Valor de Saida do Perceptron:\t"+(output));

        }}

        public static void logicaNOT(){ //função da logica NAO
            // Lógica do NOT
        double[][] inputs3 = { //entradas do NOT
            new double[]{0}, //entrada e saida desejada: 1 
            new double[]{1}, //entrada e saida desejada: 0
            
        };
        
        double[] desired3 = { 1, 0};//valor desejado
RedeNeural net3 = new RedeNeural(inputs3, 10);//tentativa
net3.practice(desired3);

        for(int i = 0; i < inputs3.length; i++) {
            String output = (net3.run(inputs3[i]) < 0.5)? "0" : "1"; //condição para achar o valor desejado

             System.out.println("\n========= Output Perceptron =========\n");
            System.out.println("Valor de Saida do Perceptron:\t"+(output));

        }}

//=================== MENU ========================

    public static void main(String[] args) {
  
    int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                logicaOR();
                break;
                
            case 2:
                logicaAND();
                break;

            case 3:
               logicaNOT();
                break;


              default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
        
    
}

