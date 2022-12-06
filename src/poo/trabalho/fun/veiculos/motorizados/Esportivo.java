package poo.trabalho.fun.veiculos.motorizados;
import poo.trabalho.fun.veiculos.VeiculoMotorizado;

public class Esportivo extends VeiculoMotorizado implements Ipva{
    private String []desenho = new String[6];

    public Esportivo(int nid){
        super(Integer.parseInt("3" + nid), valor_Base * cte_Esportivo, 4);

        this.desenho[0] = "        __         \n";
        this.desenho[1] = "      ~( @\\ \\   \n";
        this.desenho[2] = "   _____]_[_/_>__   \n";
        this.desenho[3] = "  / __ \\  "+super.getId()+" |  __ \\      \n";
        this.desenho[4] = "=\\_/__\\_\\__|_/__\\_D\n";
        this.desenho[5] = "   (__)      (__)    \n";
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
     * @return String
     */
    @Override
    public String desenhar(){
        return this.desenho[0] + this.desenho[1] + this.desenho[2] + this.desenho[3] + this.desenho[4] + this.desenho[5];
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean mover(){
        if(super.getRodas() == 4 && super.getCombustivel() >= VeiculoMotorizado.getGastoEsportivo() && super.getStatusIpva() == true){
            String giro = "          ";

            super.setDistanciaPercorrida(10);
            super.abastecer(-VeiculoMotorizado.getGastoEsportivo());

            for(int i = 0 ; i < this.desenho.length ; i++)
                this.desenho[i] = giro + this.desenho[i];

            return true;
        }

        else
            return false;
    }

    
    /** 
     * @return double
     */
    public double calcularIpva(){
        return 2.5;
    }
}
