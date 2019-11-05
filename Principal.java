public class Principal
{
    public static void main (String[] args){
        int qntTS = 0;
        ControleTeleSena cT = new ControleTeleSena();
        //testando com 3 pessoas a compra de telesena e impressão de total de venda e valortotal na classe de controle
        for (int i = 0; i <= 2; i++){
            Pessoa p = new Pessoa(sorteiaNome());
            qntTS = (int)(Math.random() * 3 + 1);
            cT.adicionaPessoa(p);
            for (int j = 0; j < qntTS; j++){
                TeleSena ts = new TeleSena();
                p.compraTeleSena(ts);                
            }
            p.imprime();
        }
        
        cT.gerenciaVendaTS();        
        
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
