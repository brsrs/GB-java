public class Pessoa
{
    private String nome;
    private TeleSena[] tSena;
    private double vPremio;
    private int qtTS;
    private int acerto1;
    private int acerto2;

    public Pessoa(String n){
        this.nome = n;
        this.tSena = new TeleSena[15];
        this.qtTS = 0;
        this.acerto1 = 0;
        this.acerto2 = 0;        
    }

    public String getNome(){
        return this.nome;
    }

    public void compraTeleSena(TeleSena t){
        if(qtTS <= 15){
            this.tSena[qtTS] = t;
            qtTS++;
        }else{
            System.out.println("Limite de compra de Tele Sena excedido para " + this.nome);            
        }    
    }

    public TeleSena[] getTSena(){
        return this.tSena;
    }

    public double getValorVenda(){
        double valorVenda = 0;
        for (int i = 0; i < qtTS; i++){
            valorVenda += tSena[i].getValorVenda();
        }
        return valorVenda;
    }

    public double getVPremio(){
        return this.vPremio;
    }

    public void setVPremio(double p){
        this.vPremio = p;
    }

    public int getQtTS(){
        return this.qtTS;
    }
}
