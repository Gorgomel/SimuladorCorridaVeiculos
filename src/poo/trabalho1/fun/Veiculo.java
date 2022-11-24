package poo.trabalho1.fun;
import java.util.Random;
import java.io.Serializable;

/** Classe representando um veículo e todas suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public abstract class Veiculo implements Serializable{
    private int id;
    private int distanciaPercorrida;
    private int quantidadeRodas;
    Roda[] rodas = new Roda[4];

    public Veiculo() {
        this.distanciaPercorrida = 0;
        this.id = id;
        this.quantidadeRodas = 0;
		
        for(int i = 0 ; i < this.rodas.length ; i++){
            this.rodas[i] = new Roda();
            
            if(this.rodas[i].getCalibragem() == true)
                this.quantidadeRodas += 1;
        }
    }

    public abstract boolean mover();
    public abstract String desenhar();

    /** Método para obter o id de um veículo
     * @return int - id do veículo
    */
	public int getId(){
		return this.id;
	}

    public void setId(int id){
        this.id = id;
    }

    /** Método para obter a distancia percorrida por um veículo
     * @return int - Distancia total percorrida pelo veículo 
    */
    public int getDistanciaPercorrida(){
        return this.distanciaPercorrida;
    }

    /** Método para obter o status de cada pneu do veículo
     * @return String - A quantidade de rodas calibradas e a listagem de cada uma
    */
    public String getRoda(){
        return "Rodas Calibradas: " + this.quantidadeRodas + "\nRoda 1: " + this.rodas[0].getCalibragem()+ "\nRoda 2: " + 
        this.rodas[1].getCalibragem() + "\nRoda 3: " + this.rodas[2].getCalibragem() + "\nRoda 4: " + this.rodas[3].getCalibragem();
    }

    /** Método para alterar o valor de uma roda específica
     * @param roda int - Qual roda deverá ser alterada
     * @param acao String - Se deverá ser calibrada ou esvaziada
     * @return boolean - true Caso tenha tido o valor alterado
     * @return boolean - false Caso não tenha sido necessário uma alteração
     */
    public boolean calibragem(int roda, String acao){
        if(acao.charAt(0) == 'e'){
            if((this.rodas[roda-1].setCalibragem(false)) == true){
                this.quantidadeRodas -= 1;
                return true;
            }
            
            else
                return false;
        }

        else{
            if((this.rodas[roda-1].setCalibragem(true)) == true){
                this.quantidadeRodas += 1;
                return true;
            }

            else 
                return false;
        }
    }

    /** Método para alterar o valor de todas as rodas do veículo
     * @param acao boolean - Se as rodas deverão ser calibradas ou esvaziadas
     * @return String - rodas que tiveram valor alterado + "foram calibradas" ou "foram esvaziadas"
     * @return String - "Nenhuma acao realizada" Caso nenhuma roda tenha seu valor alterado
     */
	public String calibragem(boolean acao){
        String str = "Roda(s): ";
        boolean flag = false;

        for(int i = 0 ; i < 4 ; i++){ 
            if((this.rodas[i].setCalibragem(acao)) == true){ //Se o paramêtro de ação for diferente do status da roda, ela terá seu valor alterado. ex(acao = true ; roda = false) 
                if(acao == true)
                    this.quantidadeRodas += 1;

                else
                    this.quantidadeRodas -= 1;


                str += (i+1) + " "; //É adicionado a string qual roda foi alterada
                flag = true;
            }
        }

        if(flag){
            if(acao == true)
                return str += "foram calibradas";

            else
                return str += "foram esvaziadas";
        }

        else 
            return "Nenhuma acao realizada";
    }

    /** Método privado para obter o status de calibragem das rodas do veículo
     * @param []rodas Roda - array de 4 índices representando 4 rodas
     * @return boolean - true Se todas as rodas estão calibradas
     * @return boolean - false Se uma ou mais rodas estão vazias 
     */
    private boolean confereCalibragem(){
        int i;
        for(i = 0 ; (i < 4) && (this.rodas[i].getCalibragem() == true) ; i++);

        return (i < 4) ? false : true;
    }

}