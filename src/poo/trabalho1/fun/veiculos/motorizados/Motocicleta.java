package poo.trabalho1.fun.veiculos.motorizados;
import poo.trabalho1.fun.veiculos.VeiculoMotorizado;

public class Motocicleta extends VeiculoMotorizado implements Ipva{

    public Motocicleta(String id){
        super((( "3"+ id)), (valor_Base * cte_Motocicleta));

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
