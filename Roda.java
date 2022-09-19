import java.util.Random;

public class Roda {
    private boolean CalibragemPneu;
	Random rand = new Random();
	
	public Roda(){
		CalibragemPneu = rand.nextBoolean();
	}
	
	public boolean getCalibragem(){
		return CalibragemPneu;
	}
	
	public void setCalibragem(boolean vari){
		if(CalibragemPneu != vari)
			CalibragemPneu = vari;
	}
		
}
