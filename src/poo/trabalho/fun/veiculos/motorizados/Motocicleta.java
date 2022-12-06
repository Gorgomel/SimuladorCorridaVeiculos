package poo.trabalho.fun.veiculos.motorizados;
import poo.trabalho.fun.veiculos.VeiculoMotorizado;

public class Motocicleta extends VeiculoMotorizado implements Ipva {
    private String []desenho = new String[3];

    public Motocicleta(int nid){
        super(Integer.parseInt("2" + nid), valor_Base * cte_Motocicleta, 2);

        this.desenho[0] = +super.getId()+"    ,_oo\n";
        this.desenho[1] = "  .-/c-//::\n";
        this.desenho[2] = "  (_)'==(_)\n";
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
        return this.desenho[0] + this.desenho[1] + this.desenho[2];
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean mover(){
        if(super.getRodas() == 2 && super.getCombustivel() >= VeiculoMotorizado.getGastoMotocicleta() && super.getStatusIpva() == true){
            String giro = "   ";

            System.out.println(VeiculoMotorizado.getGastoMotocicleta());
            super.setDistanciaPercorrida(3);
            super.abastecer(-VeiculoMotorizado.getGastoMotocicleta());

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
