package poo.trabalho.fun.veiculos;
import poo.trabalho.fun.Veiculo;

public class Bicicleta extends Veiculo{
    private String []desenho = new String[3];

    public Bicicleta(int nid) {
        super(Integer.parseInt("1" + nid), 2);

        this.desenho[0] = "     __o\n";
        this.desenho[1] = +super.getId()+" _`\\<,_\n";
        this.desenho[2] = "  (*)/ (*)\n\n";
    }

    
    /** 
     * @param acao
     */
    public void calibragem(boolean acao){
        for(int i = 0 ; i < super.getQuantidadeRodas() ; i++){
            super.setCalibragem(acao, i);
        }  
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean mover(){
        if(super.getRodas() == 2){
            String giro = "  ";
            super.setDistanciaPercorrida(2);

            for(int i = 0 ; i < this.desenho.length ; i++)
                this.desenho[i] = giro + this.desenho[i];

            return true;
        }

        else 
            return false;
    } 

    
    /** 
     * @return String
     */
    @Override
    public String desenhar(){
        return this.desenho[0] + this.desenho[1] + this.desenho[2];
    }
}
