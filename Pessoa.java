public class Pessoa
{
    private String nome;
    private TeleSena[] tSena;
    private double vPremio;
    private int qtTS;

    public Pessoa(String n){
        this.nome = n;
        this.tSena = new TeleSena[15];
        this.qtTS = 0;
    }

    public String getNome(){
        return this.nome;
    }

    public void compraTeleSena(TeleSena t){
        if(qtTS !=15){
            this.tSena[qtTS] = t;
            qtTS++;
        }else{
            System.out.println(this.nome + ": " + "Limite de compra de Tele Sena excedido");            
        }    
    }

    public double getValorVenda(){
        double valorVenda = 0;
        for (int i = 0; i < qtTS; i++){
            valorVenda += tSena[i].getValorVenda();
        }
        return valorVenda;
    }

    public int getQtTS(){
        return this.qtTS;
    }
    
    // método para teste
    public void imprime(){
        for(int i = 0; i < qtTS; i++){
            System.out.println("Telesena " + (i+1) + " de " + this.nome);
            tSena[i].imprimeTeleSena();
        }       
    }
}
