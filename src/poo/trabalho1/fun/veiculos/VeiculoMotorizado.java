package poo.trabalho1.fun.veiculos;
import poo.trabalho1.fun.Veiculo;

public abstract class VeiculoMotorizado extends Veiculo{
    private static final double gastoMotocicleta = 0.25f;
    private static final double gastoPasseio = 0.75f;
    private static final double gastoEsportivo = 2.3f;
    private double combustivel;
    private double valorIpva;

    public VeiculoMotorizado(String string, double valorIpva){
        super(string);
        this.combustivel = combustivel;
        this.valorIpva = valorIpva;
    }

    public void abastecer(){

    }

    public String toString(){
        return " ";
    }
}
