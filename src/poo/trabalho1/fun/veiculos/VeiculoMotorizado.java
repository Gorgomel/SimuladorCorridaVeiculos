package poo.trabalho1.fun.veiculos;
import poo.trabalho1.fun.Veiculo;

public abstract class VeiculoMotorizado extends Veiculo{
    private static int gastoMotocicleta;
    private static int gastoPasseio;
    private static int gastoEsportivo;
    private float combustivel;
    private float valorIpva;

    public VeiculoMotorizado(){
        VeiculoMotorizado.gastoMotocicleta = 0;
        VeiculoMotorizado.gastoPasseio = 0;
        VeiculoMotorizado.gastoEsportivo = 0;
        this.combustivel = 2.5f;
        this.valorIpva = 500;
    }

    public void abastecer(){

    }

    public String toString(){
        return " ";
    }
}
