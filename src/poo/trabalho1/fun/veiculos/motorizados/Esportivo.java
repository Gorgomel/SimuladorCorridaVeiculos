package poo.trabalho1.fun.veiculos.motorizados;
import poo.trabalho1.fun.veiculos.VeiculoMotorizado;

public class Esportivo extends VeiculoMotorizado implements Ipva{

    public Esportivo(){
        super(valor_Base * cte_Esportivo);

    }

    public void abastecer(){

    }

    public String toString(){
        return " ";
    }
    
    public String desenhar(){
        return " ";
    }

    public boolean mover(){
        return false;
    }

    public double calcularIpva(){
        return 2.5;
    }
}
