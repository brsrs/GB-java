public class TeleSena
{
    private double valorVenda;
    private int[] numC1;
    private int[] numC2;
        
    public TeleSena(){
        //inicia o valor com 10 pois é sempre o mesmo
        this.valorVenda = 10;
        //instancia o tamanho dos arrays de números
        this.numC1 = new int[25];
        this.numC2 = new int[25];
        //preenche os arrays de 1 a 60 sem repetir com a funcão
        this.numC1 = criaNumTeleSena();
        this.numC2 = criaNumTeleSena();
    }

    public int[] criaNumTeleSena(){
        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++){
            //cria o número aleatório de 1 a 60
            int aux = (int)(Math.random() * 60 + 1);
            boolean checa = false;
            /* laço para checar se o número existe dentro do array 
            até a posição que já foi preenchida */
            for (int j = 0; j < i; j++){
                if(arr[j] == aux){
                    checa = true;
                    break; // se o número existe ele sai do laço
                }else{
                    checa = false;
                }
            }

            if (checa == false){
                arr[i] = aux;
            }else{
                i--; // se true ele decrementa o contador no laço
            }
        }
        return arr;
    }
    
    public double getValorVenda(){
        return this.valorVenda;
    }
    
    //método que retorna a telesena de acordo com o parâmetro passado (1 ou 2)
    public int[] getTelesena(int n){
        if (n == 1){
            return this.numC1;
        }else{
            return this.numC2;
        }
    }    
    
    // método para teste
    public void imprimeTeleSena(){
        for (int i = 0; i < this.numC1.length; i++){
            System.out.print(this.numC1[i]);
            if (i < this.numC1.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("\n");

        for (int i = 0; i < this.numC2.length; i++){
            System.out.print(this.numC2[i]);
            if (i < this.numC2.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }
}
