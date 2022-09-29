package poo.trabalho1.fun;
import java.util.Random;
import java.io.Serializable;

public class Roda implements Serializable{
    private boolean CalibragemPneu;
	private Random rand = new Random();
	
	public Roda(){
		this.CalibragemPneu = rand.nextBoolean();
		this.rand = null;
	}
	
	public boolean getCalibragem(){
		return CalibragemPneu;
	}
	
	public boolean setCalibragem(boolean vari){
		if(CalibragemPneu != vari){
			CalibragemPneu = vari;
			return true;
		}

		else
			return false;
	}		
}