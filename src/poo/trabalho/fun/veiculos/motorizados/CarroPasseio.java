package poo.trabalho.fun.veiculos.motorizados;
import poo.trabalho.fun.veiculos.VeiculoMotorizado;

public class CarroPasseio extends VeiculoMotorizado implements Ipva{
    private String []desenho = new String[4];

    public CarroPasseio(int nid){
        super(Integer.parseInt("4" + nid), valor_Base * cte_Esportivo, 4);

        this.desenho[0] = "    ____\n";
        this.desenho[1] = " __/  |_ \\_\n";
        this.desenho[2] = "|  _  "+super.getId()+"  _``-.\n";
        this.desenho[3] =  "'-(_)---(_)--'\n\n\n";
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
        return this.desenho[0] + this.desenho[1] + this.desenho[2] + this.desenho[3];
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean mover(){
        if(super.getRodas() == 4 && super.getCombustivel() >= VeiculoMotorizado.getGastoPasseio() && super.getStatusIpva() == true){
            String giro = "     ";

            super.setDistanciaPercorrida(5);
            super.abastecer(-VeiculoMotorizado.getGastoPasseio());

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
