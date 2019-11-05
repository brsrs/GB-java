public class ControleTeleSena
{
    private Pessoa[] pessoas;
    private int qtTSVendida;
    private double valorVendasTS;
    private int posPessoa;
    
    public ControleTeleSena(){
        this.pessoas = new Pessoa[3];
        this.qtTSVendida = 0;
        this.posPessoa = 0;
    }
    
    public void adicionaPessoa(Pessoa p){
        this.pessoas[posPessoa] = p;
        posPessoa++;
    }
    
    public void gerenciaVendaTS(){
       for (int i = 0; i < posPessoa; i++){
           qtTSVendida += pessoas[i].getQtTS();
           valorVendasTS += pessoas[i].getValorVenda();
       }    
       
       System.out.println(qtTSVendida);
       System.out.println(valorVendasTS);
    }
    
    public int[] sorteioTeleSena(){
        int[] numSorteados = new int[25];
        for (int i = 0; i < numSorteados.length; i++){
            //cria o número aleatório de 1 a 60
            int aux = (int)(Math.random() * 60 + 1);
            boolean checa = false;
            /* laço para checar se o número existe dentro do array 
            até a posição que já foi preenchida */
            for (int j = 0; j < i; j++){
                if(numSorteados[j] == aux){
                    checa = true;
                    break; // se o número existe ele sai do laço
                }else{
                    checa = false;
                }
            }

            if (checa == false){
                numSorteados[i] = aux;
            }else{
                i--; // se true ele decrementa o contador no laço
            }
        }
        return numSorteados;
    }
}
