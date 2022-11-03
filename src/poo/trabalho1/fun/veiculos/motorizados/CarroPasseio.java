package poo.trabalho1.fun.veiculos.motorizados;
import poo.trabalho1.fun.veiculos.VeiculoMotorizado;

public class CarroPasseio extends VeiculoMotorizado implements Ipva{
    
    public CarroPasseio(String id){
        super((("2" + id)), (valor_Base*cte_Passeio));

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
