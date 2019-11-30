public class ControleTeleSena
{
    private Pessoa[] pessoas;
    private int qtTSVendida;
    private double valorVendasTS;
    private int posPessoa;
    private int countGanhadores = 0;
    private int countNumSorteio = 25;
    private boolean checaGanhadores = false;
    private Pessoa[] ganhadores;
    private int[] numSorteados;

    public ControleTeleSena(){
        this.pessoas = new Pessoa[25];
        this.qtTSVendida = 0;
        this.posPessoa = 0;
        this.ganhadores = new Pessoa[25];
        this.numSorteados = new int[60];
    }

    public void adicionaPessoa(Pessoa p){
        this.pessoas[posPessoa] = p; //adiciona a pessoa na posição posPessoa
        posPessoa++; // acresce +1 na posPessoa
    }

    public int gerenciaQtVendaTS(){
        // percorre o array pessoas até o índice posPessoa e salva os valores de qt vendida e valor de vendas 
        for (int i = 0; i < posPessoa; i++){
            qtTSVendida += pessoas[i].getQtTS();            
        }
        return qtTSVendida;
    }

    public double gerenciaValorVendaTS(){
        // percorre o array pessoas até o índice posPessoa e salva os valores de qt vendida e valor de vendas 
        for (int i = 0; i < posPessoa; i++){
            valorVendasTS += pessoas[i].getValorVenda();
        }
        return valorVendasTS;
    }

    public int[] sorteioTeleSena(){
        //sorteia os primeiros 25 números

        //SORTEIO DOS PRIMEIROS 25 NÚMEROS
        for (int i = 0; i < countNumSorteio; i++){
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

            if (!checa){
                numSorteados[i] = aux;
            }else{
                i--; // se true ele decrementa o contador no laço
            }
        }
        return numSorteados;        
    }

    public void checaAcertos(int[] numSorteio){
        //array para armazenas as TS de cada pessoa
        TeleSena[] telePessoa; 
        //array para armazenar os números de cada TS
        int[] numTSena = new int[25];         
        //                                    CHECA OS PRIMEIROS 25 NÚMEROS PARA SABER SE HÁ VENCEDOR
        //laço percorre o array de pessoas da classe
        for(int i=0; i < pessoas.length; i++){
            //coloca o array de TS da pessoa i dentro do array telePessoa
            telePessoa = pessoas[i].getTSena();

            //verifica os números da Telesena 1 de cada pessoa
            for(int k=0; k < telePessoa.length; k++){
                // se o índice não for nulo(pessoa não comprou 15 ts)                
                if(telePessoa[k] != null){
                    // adiciona os números do conjunto 1 da TS no array
                    numTSena = telePessoa[k].getTelesena(1);
                    for (int j = 0; j < numTSena.length; j++){
                        for (int l = 0; l < countNumSorteio; l++){
                            if(numTSena[j] == numSorteio[l]){
                                telePessoa[k].acertoC1();                            
                            }                        
                        }                            
                    }
                    // adiciona os números do conjunto 2 da TS no array
                    numTSena = telePessoa[k].getTelesena(2);
                    for (int j = 0; j < numTSena.length; j++){
                        for (int l = 0; l < countNumSorteio; l++){
                            if(numTSena[j] == numSorteio[l]){
                                telePessoa[k].acertoC2();                            
                            }                        
                        }                            
                    }
                }
            }

        }                
        //checa se há ganhadores, senão segue para a segunda parte do sorteio
        if(!checaGanhadores()){            
            sorteioTeleSena2(numSorteio);            
        }
    }

    public void sorteioTeleSena2(int[] numSorteio){
        int[] numSorteados = numSorteio;

        //cria o número aleatório de 1 a 60
        int aux = (int)(Math.random() * 60 + 1);

        /* laço para checar se o número existe dentro do array 
        até a posição que já foi preenchida */        

        for (int i = 0; i < countNumSorteio; i++){
            if(numSorteados[i] == aux){
                aux = (int)(Math.random() * 60 + 1);
                i=0;
            }else{
                numSorteados[countNumSorteio] = aux;
            }            
        }
        checaAcertos2(numSorteados);
    }

    public void checaAcertos2(int[] numSorteio){
        //array para armazenas as TS de cada pessoa
        TeleSena[] telePessoa; 
        //array para armazenar os números de cada TS
        int[] numTSena = new int[25];        
        // vai percorrer o array comparando apenas o próximo número sorteado
        for(int i=0; i < pessoas.length; i++){
            //coloca o array de TS da pessoa i dentro do array telePessoa
            telePessoa = pessoas[i].getTSena();
            //verifica os números da Telesena 1 de cada pessoa
            for(int k=0; k < telePessoa.length; k++){
                // se o índice não for nulo(pessoa não comprou 15 ts)
                if(telePessoa[k] != null){
                    // adiciona os números do conjunto 1 da TS no array
                    numTSena = telePessoa[k].getTelesena(1);
                    for (int j = 0; j < numTSena.length; j++){
                        if(numTSena[j] == numSorteio[countNumSorteio]){
                            telePessoa[k].acertoC1();                            
                        }
                    }

                    numTSena = telePessoa[k].getTelesena(2);
                    for (int j = 0; j < numTSena.length; j++){
                        if(numTSena[j] == numSorteio[countNumSorteio]){
                            telePessoa[k].acertoC2();                            
                        }
                    }
                }
            }
        }

        //checa de há vencedores, senão continua sorteio
        if(!checaGanhadores()){
            countNumSorteio++;            
            sorteioTeleSena2(numSorteio);        
        }
    }

    public boolean checaGanhadores(){
        TeleSena[] telePessoa;        

        for(int i=0; i < pessoas.length; i++){
            telePessoa = pessoas[i].getTSena();
            //verifica os acertos das TS de cada pessoa
            for(int k=0; k < telePessoa.length; k++){
                if(telePessoa[k] != null){
                    if(telePessoa[k].getAcertoC1()==25 || telePessoa[k].getAcertoC2()==25){
                        ganhadores[countGanhadores] = pessoas[i];
                        countGanhadores++;                        
                    }                    
                }
            }                   
        }

        if(countGanhadores > 0){
            checaGanhadores = true;
        }   
        return checaGanhadores;
    }

    public void imprimeGanhadores(Pessoa[] ganhadores){
        System.out.println("------------------------------------- Ganhadores --------------------------------------" + "\n");            
        for(int i = 0; i < countGanhadores; i++){
            if(ganhadores != null){
                System.out.print(ganhadores[i].getNome());
                if(i < countGanhadores-1){
                    System.out.print(", ");
                }
            }                                
        }
        System.out.println("\n");
    }

    public void imprimeSorteio(int[] numSorteio){
        System.out.println("---------------------- Resultado Final do Sorteio da Tele-Sena  -----------------------" + "\n");        
        for(int i = 0; i < countNumSorteio; i++){
            System.out.print(numSorteio[i]);
            if(i < countNumSorteio-1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    public void imprimeInfosFinais(){
        imprimeSorteio(numSorteados);
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        int qtTSVendida = gerenciaQtVendaTS();
        double valorVendasTS = gerenciaValorVendaTS();
        System.out.println("------------------------- Quantidade de Tele-Senas Vendidas  --------------------------" + "\n");
        System.out.println(qtTSVendida + " Tele-Senas" + "\n");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        System.out.println("--------------------------------- Total de ganhadores  --------------------------------" + "\n");
        System.out.println(countGanhadores + " ganhador(es)" + "\n");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        imprimeGanhadores(ganhadores);        
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        System.out.println("-------------------------- Valor do prêmio de cada ganhador  --------------------------" + "\n");
        double valorPremio = calculaPremio(valorVendasTS);
        System.out.println("Cada ganhador faturou: R$ " + valorPremio + "\n");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        System.out.println("------------------------ Valor total de Tele-Senas Vendidas  --------------------------" + "\n");
        System.out.println("R$ " + valorVendasTS + "\n");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        System.out.println("------------------- Lucro Obtido pelo Silvio Santos com a Tele-Sena -------------------" + "\n");
        double lucro = valorVendasTS - valorPremio;
        System.out.println("R$ " + lucro + "\n");        
    }

    public double calculaPremio(double valorVendas){
        double valorPremio = (valorVendas * 0.8) / countGanhadores;
        return valorPremio;
    }
}