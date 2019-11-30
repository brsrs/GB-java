public class Principal
{
    public static void main (String[] args){
        System.out.println("------------------------------ Sorteio da Tele-Sena 2019 ------------------------------" + "\n");
        try {
            Thread.sleep(2500);
        } catch (Exception e) {}
        
        int qntTS = 0; // quantidade de TS comprada por cada pessoa
        ControleTeleSena cT = new ControleTeleSena();
        
        //Cria pessoas e telesenas aleatórias
        for (int i = 0; i < 25; i++){
            Pessoa p = new Pessoa(sorteiaNome());
            qntTS = (int)(Math.random() * 15 + 1);
            cT.adicionaPessoa(p);
            for (int j = 0; j < qntTS; j++){
                TeleSena ts = new TeleSena();
                p.compraTeleSena(ts);
            }
            
        }
           
        int[] numSorteados = cT.sorteioTeleSena();
        cT.checaAcertos(numSorteados);
        cT.imprimeInfosFinais();
        
        System.out.println("-------------------------- Fim do Sorteio da Tele-Sena 2019 ---------------------------" + "\n");
    }

    // função que cria nomes aleatórios para as pessoas
    public static String sorteiaNome(){
        String[] pre = {"Pe","Bru","Ro","Gui","Leo","Car","Fe","Fer","Ana","Ane","Ju","Juli","Jef"};
        String nome = "";
        String[] fim = {"dro","no","drigo","rigo","lherme","los","lipe","nando","nanda","na","lia","lara","ana","erson","lota","olina","sana"};
        int numPre = 0;
        int numFim = 0;
        for (int i = 0; i < 1; i++){
            numPre = (int)(Math.random() * 12 + 0); //gera um número aleatório de 0 a 12 correspondente ao início do nome
            numFim = (int)(Math.random() * 16 + 0); //gera um número aleatório de 0 a 16 correspondente ao fim do nome
            nome += pre[numPre] + fim[numFim];
        }
        return nome;
    }

}
