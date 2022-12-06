import java.util.Random;
import java.io.Serializable;

/** Classe representando uma roda e todas suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public final class Roda implements Serializable{
    private boolean CalibragemPneu;
	
	/** Método construtor onde é sorteado um valor boolean aleátorio para a roda
	 * onde true = calibrada e false = vazia
	 */
	public Roda(){
		Random rand = new Random();
		this.CalibragemPneu = rand.nextBoolean();
	}
	
	/** Método para obter o status de calibragem da roda
	 */
	public boolean getCalibragem(){
		return this.CalibragemPneu;
	}
	
	/** Método para alterar o status de calibragem da roda
	 * @param vari boolean - Se deverá ser calibrada ou esvaziada
	 * @return boolean - true Caso o parâmetro seja diferente do status da roda, e alteração tenha sido realizada
	 * @return boolean - false Caso o parâmetro seja igual ao status da roda. Nenhuma alteração é realizada
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