package poo.trabalho1.fun;
import java.util.Random;
import java.io.Serializable;

/** Classe representando um veículo e todas suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public class Veiculo  implements Serializable{
    //private float combustivel;
    private int id;
    private int distanciaPercorrida;
    private int quantidadeRodas;
    //final private boolean ipva;
    //private String [] desenho = new String[4];
    Roda[] rodas = new Roda[4];
    //private Random rand = new Random();

    public Veiculo() {
       // this.ipva = rand.nextBoolean();
    }

    /** Método construtor de um veículo, onde para o ipva é sorteado um valor boolean aleatório e imutável
     *  Para o combustível é declarado um valor padrão de 2,5 litros
     *  É definido a arte do veículo identificado pelo seu id
     *  Para cada um dos pneus é sorteado um valor boolean aleatório onde true = Calibrado e false = Vazio
     *  Para cada novo veículo, é adicionado +1 no contador geral 
     *  Para os demais valores é definido 0
     * @param id int - ID do novo veículo */
    public Veiculo(int id) {
       // this.ipva = rand.nextBoolean();
        this.distanciaPercorrida = 0;
        this.id = id;
       // this.combustivel = 2.5f;
        this.quantidadeRodas = 0;
       /*  this.desenho[0] = "    ____\n";
        this.desenho[1] = " __/  |_ \\_\n";
        this.desenho[2] = "|  _  "+id+"  _``-.\n";
        this.desenho[3] =  "'-(_)---(_)--'\n\n\n";*/
		
        for(int i = 0 ; i < 4 ; i++){
            this.rodas[i] = new Roda();
            
            if(this.rodas[i].getCalibragem() == true)
                this.quantidadeRodas += 1;
        }
    }

    /** Método para obter o id de um veículo
     * @return int - id do veículo
    */
	public int getId(){
		return this.id;
	}

    /** Método para obter a distancia percorrida por um veículo
     * @return int - Distancia total percorrida pelo veículo 
    */
    public int getDistanciaPercorrida(){
        return this.distanciaPercorrida;
    }

    /** Método para obter o id de um veículo
     * @return float - Combustível restante no veículo
    */
    /*public float getCombustivel(){
        return this.combustivel;
    }*/

    /** Método para obter o status do IPVA de um veículo
     * @return boolean - true para IPVA pago e false para IPVA atrasado
    */
    /*public boolean getIpva(){
        return this.ipva;
    }*/

    /** Método para obter o status de cada pneu do veículo
     * @return String - A quantidade de rodas calibradas e a listagem de cada uma
    */
    public String getRoda(){
        return "Rodas Calibradas: " + this.quantidadeRodas + "\nRoda 1: " + this.rodas[0].getCalibragem()+ "\nRoda 2: " + 
        this.rodas[1].getCalibragem() + "\nRoda 3: " + this.rodas[2].getCalibragem() + "\nRoda 4: " + this.rodas[3].getCalibragem();
    }

    /** Método para obter o desenho de um veículo
     * @return String - Retorna o array contendo a forma do veículo 
    */
    /*public String getDesenho(int i){
        return this.desenho[i];
    }*/

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

    /** Método para abastecer um veículo
     * @param quant int - Quantidade a ser adicionado
     */
    /*public void abastecerVeiculo(int quant) {
        combustivel += quant;
    }*/

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

    /** Método para atualizar os valores de um veículo que tenha sido movido 
     * @return boolean - true Caso as exigências tenham sido atendidas 
     * @return boolean - false Caso o veículo não possa ser movido por alguma razão
    */
    /*public boolean mover(){
        if(this.combustivel >= 0.55 && confereCalibragem() == true && this.ipva == true){
            String giroCar = "     "; //Para cada unidade movida

            this.combustivel -= 0.55;
            this.distanciaPercorrida += 5;

            for(int i = 0 ; i < this.desenho.length ; i++)
                    this.desenho[i] = giroCar + this.desenho[i];

            return true;
        }

        else
            return false;
    }*/

    /** Método para obter o desenho atualizado de um carro
     */
    /*public String desenhaVeiculoPista(){
        return this.desenho[0] + this.desenho[1] + this.desenho[2] + this.desenho[3];
    }*/

    
}