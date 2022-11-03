package poo.trabalho1.fun.veiculos;
import poo.trabalho1.fun.Veiculo;

public class Bicicleta extends Veiculo{

    public Bicicleta(String id){
       
        super((""+4+id));
        
    }

    public boolean mover(){
        return false;
    }

    public String desenhar(){
        return " ";
    }
}
