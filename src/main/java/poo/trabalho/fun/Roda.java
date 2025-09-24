package poo.trabalho.fun;

import java.util.Random;
import java.io.Serializable;

/** Classe representando uma roda e todas suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public final class Roda implements Serializable{
    private boolean CalibragemPneu;
	
	/** MÃ©todo construtor onde Ã© sorteado um valor boolean aleÃ¡torio para a roda
	 * onde true = calibrada e false = vazia
	 */
	public Roda(){
		Random rand = new Random();
		this.CalibragemPneu = rand.nextBoolean();
	}
	
	/** MÃ©todo para obter o status de calibragem da roda
	 */
	public boolean getCalibragem(){
		return this.CalibragemPneu;
	}
	
	/** MÃ©todo para alterar o status de calibragem da roda
	 * @param vari boolean - Se deverÃ¡ ser calibrada ou esvaziada
	 * @return boolean - true Caso o parÃ¢metro seja diferente do status da roda, e alteraÃ§Ã£o tenha sido realizada
	 * @return boolean - false Caso o parÃ¢metro seja igual ao status da roda. Nenhuma alteraÃ§Ã£o Ã© realizada
	 */
	public boolean setCalibragem(boolean vari){
		if(this.CalibragemPneu != vari){
			this.CalibragemPneu = vari;
			return true;
		}

		else
			return false;
	}		
}
