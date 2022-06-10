public class RedeNeural {
/*Rede Neural Perceptron: recebe inputs, que são as amostras (entradas), cada entrada é multiplicada por um peso (sinaptico) e todos os resultados são somados, o valor dessa soma passa por uma função de ativação(sigmoide, tangente hiperbolica, gausiana), depois gera um valor output (saida do perceptron) que é comparada com o valor desejado, não sendo o esperado, os pesos serão reajustados para uma nova iteracao, esse processo de reajuste é realizado varias vezes até que a rede apresente o resultado desejado, e assim, essa rede neural estará treinada.)*/ 

//Declarar variaveis
 int iterations; //iteracoes
 private double[][] training_sets; // dataset - matriz
 private double[] weights; //pesos sinapticos - vetor
 private double bias; // termo constante

    public RedeNeural(double[][] training_sets, int iterations) {//instaciar funcao

        this.training_sets = training_sets; //instaciar o material por meio do qual o computador "aprende" como processar informações das entradas

        this.iterations = iterations; //instaciar iteracoes

        this.weights = new double[training_sets[0].length]; //instaciar pesos, associando o training_sets comecando por zero e seu tamanho

        this.initWeights(); //instaciar funcao para iniciar os pesos

    }

    private void initWeights() { //funcao para iniciar os pesos

        for(int i = 0; i < this.weights.length; i++) {//laço de repeticao para associar dados ao vetor

            this.weights[i] = Math.random();// associar dado matematico randomico a cada posição do vetor (posição do vetor peso recebe dado matematico(numeros)randomicos)
            System.out.println("Peso Sinaptico(Randomico): " + this.weights[i]);// imprimir pesos de cada posição do vetor

        }

        this.bias = Math.random();// associar dado matematico randomico a bias, valor constante
        System.out.println("Bias(Constante)(Randomico): " + this.bias);// imprimir bias 
    
    }

    public double sigmoid(double x) { //função sigmoid

        return 1 / (1 + Math.exp(-x));//funcao em si

    }

    public double run(double[] inputs) { //rodar as entradas e multiplicas pelo pesos, 

        double sum = 0.0;

        for(int i = 0; i < this.weights.length; i++) {

            sum += (inputs[i] * this.weights[i]);//entradas multiplicas pelo pesos e somar tudo

        }

        sum += this.bias;// somar bias

        return this.sigmoid(sum); //retornar resultado 

    }

    public boolean practice(double[] desired) {//tentativas a fim de treinar o algoritmo e obter o valor desejado 

        int count = 0; //declarar contador e iniciar em 0
        do {//fazer
System.out.print("---------------------------------\n");
            System.out.println("Tentativa " + (count + 1));// printar o numero da "tentativa"(iteracao)
            
            for(int i = 0; i < this.training_sets.length; i++) {

                double y = this.run(this.training_sets[i]);

                // correção dos pesos
                for(int j = 0; j < this.weights.length; j++) {

                    this.weights[j] += (desired[i] - y) * this.training_sets[i][j];//pesos recebe e soma o valor desejado multiplicado pelos valores obtidos das tentivas

                }
                this.bias += (desired[i] - y);//recebe e soma o valor desejado com o bias

                System.out.printf("Valor obtida da funçao: %.10f -> Desejado: %.1f\n", this.run(this.training_sets[i]), desired[i]);//imprimir valor da tentativa comparado com o valor desejado
           
            }

            count++;//incrementa o contador 
        } while(count < this.iterations);//enquanto o contador for menor que as iteracoes

        return true;//retorna verdade

    }

}
