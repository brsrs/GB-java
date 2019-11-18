public class ControleTeleSena
{
    private Pessoa[] pessoas;
    private int qtTSVendida;
    private double valorVendasTS;
    private int posPessoa;
    
    
    public ControleTeleSena(){
        this.pessoas = new Pessoa[2];
        this.qtTSVendida = 0;
        this.posPessoa = 0;        
    }
    
    public void adicionaPessoa(Pessoa p){
        this.pessoas[posPessoa] = p; //adiciona a pessoa na posição posPessoa
        posPessoa++; // acresce +1 na posPessoa
    }
      
    public void gerenciaQtVendaTS(){
       // percorre o array pessoas até o índice posPessoa e salva os valores de qt vendida e valor de vendas 
       for (int i = 0; i < posPessoa; i++){
           qtTSVendida += pessoas[i].getQtTS();
           valorVendasTS += pessoas[i].getValorVenda();
       }       
       System.out.println(qtTSVendida);
       System.out.println(valorVendasTS);
    }
    
    public void sorteioTeleSena(){
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
        checaGanhadores(numSorteados);
    }
    
    public void checaGanhadores(int[] numSorteio){
        TeleSena[] telePessoa;
        String[] nomes = new String[2];
        int[] numTSena = new int[25];
        int countGanhadores = 0;
        for(int i=0; i < pessoas.length; i++){
            telePessoa = pessoas[i].getTSena();
            for(int k=0; k < telePessoa.length; k++){
                if(telePessoa[k] != null){
                    numTSena = telePessoa[k].getTelesena(1);
                    for (int j = 0; j < numSorteio.length; j++){
                        if(numTSena[j] == numSorteio[j]){
                            pessoas[i].acertoC1();
                        }
                        if(pessoas[i].getAcertoC1()==25){
                            nomes[i] = pessoas[i].getNome();
                            countGanhadores++;
                        }
                    }
                }
                
            }
            
            
        }
        System.out.println("Número sorteado TS1");
        for(int j = 0; j < numSorteio.length; j++){
            System.out.print(numSorteio[j]);
            if (j < numSorteio.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n" + "Ganhadores: ");
        for(int j = 0; j < countGanhadores; j++){
            System.out.print(nomes[j]);
            if (j < nomes.length-1){
                System.out.print(", ");
            }
        }
    }
}
