package poo.trabalho.fun;
import java.io.Serializable;

public abstract class Veiculo implements Serializable{
    private int id;
    private int distanciaPercorrida;
    private final int quantidadeRodas; 
    private Roda []rodas = new Roda[4];

    public Veiculo(int id, int quantidadeRodas){
        this.id = id;
        this.distanciaPercorrida = 0;
        this.quantidadeRodas = quantidadeRodas;

        for(int i = 0 ; i < quantidadeRodas ; i++)
            this.rodas[i] = new Roda();
    }

    
    /** 
     * @return int
     */
    public int getId(){
        return this.id;
    }

    
    /** 
     * @return int
     */
    public int getRodas(){
        int j = 0;
        for(int i = 0 ; i < quantidadeRodas ; i++)
            if(this.rodas[i].getCalibragem() == true)
                j++;
        
        return j;
    }    

    
    /** 
     * @param a
     * @return String
     */
    public String getRodas(String a){
        for(int i = 0 ; i < quantidadeRodas ; i++)
            a += this.rodas[i].getCalibragem() + " "; 
        
        return a;
    }   

    
    /** 
     * @param acao
     * @param i
     * @return boolean
     */
    public boolean setCalibragem(boolean acao, int i){
        return this.rodas[i].setCalibragem(acao);
    }

    
    /** 
     * @return int
     */
    public int getQuantidadeRodas(){
        return this.quantidadeRodas;
    }

    
    /** 
     * @return int
     */
    public int getDistanciaPercorrida(){
        return this.distanciaPercorrida;
    }

    
    /** 
     * @param i
     */
    public void setDistanciaPercorrida(int i){
        this.distanciaPercorrida += i;
    }

    public void calibragem(boolean acao){}

    
    /** 
     * @param roda
     * @param acao
     * @return boolean
     */
    public boolean calibragem(int roda, String acao){
        if(acao.charAt(0) == 'e'){
            if((this.rodas[roda-1].setCalibragem(false)) == true){
                return true;
            }
            
            else
                return false;
        }

        else{
            if((this.rodas[roda-1].setCalibragem(true)) == true){
                return true;
            }

            else 
                return false;
        }
    }
    public abstract boolean mover();

    public abstract String desenhar();
    
}
