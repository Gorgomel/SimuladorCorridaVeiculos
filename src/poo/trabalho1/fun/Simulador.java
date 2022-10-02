package poo.trabalho1.fun;
import java.io.Serializable;

/** Classe para conter e gerenciar todos os veículos adicionados e suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public class Simulador implements Serializable {
    private Veiculo[] veic = new Veiculo[20];
    private static int quantVeic = 0;
	
	public Simulador(){	
		for(int i = 0 ; i < 20 ; i++)
			this.veic[i] = null;
	}

	/** Método para encontrar, caso houver, um índice vazio no array de veículos
	 * @return int - Índice vazio null ou -1 caso não haja */
	private int indiceVazio(){
		int i;
		for(i = 0 ; (i < 20) && (this.veic[i] != null) ; i++);
		
		return (i < 20) ? i : -1;
	}

	/**	Método privado para encontrar o índice de um ID específico
	 * @return int - Índice do ID ou -1 caso o ID não pertença ao array*/
	private int encontraIndice(int id){
		int i;
		for(i = 0 ; i < 20 ; i++){
			if(this.veic[i] != null) //Para evitar maiores problemas, é feito a validação do índice antes da verificação
				if(this.veic[i].getId() == id)	
					return i;
		}

		return -1;
	}
	
	/** Método para remover um ID do array 
	 *  Após a remoção o índice se torna vazio
	 * @param id int - ID do veículo a ser removido do array
	 * @return int - 0 Caso remoção bem sucedida
	 * @return int - 1 Caso o ID não pertença ou já tenha sido removido */
	public int removerVeic(int id){
		int i;
		if((i = encontraIndice(id)) >= 0){//Caso o id pertença ao array será recebido um valor maior ou igual a zero,
			this.veic[i] = null;
			return 0;
		}

		else
			return 1;
	}
	
	/** Método para adicionar um novo ID no array
	 * @param id int - Novo ID a ser inserido no array
	 * @return int - 0 Caso inserção bem sucedida
	 * @return int - 1 Caso o array esteja cheio
	 * @return int - -1 O ID já existe no array */
	public int incluirVeiculo(int id){
		int i = indiceVazio(); //Recebe o índice a ser adicionado o novo ID

		if(encontraIndice(id) == -1){//Caso o valor seja diferente de -1, o ID já existe e a operação é finalizada

			if(i >= 0){//Caso i for menor que zero, não há mais espaço no array
				this.veic[i] = new Veiculo(id);
				return 0;
			}

			else
				return 1;
		}

		else
			return -1;
	}

	/** Método para adicionar combustível ao veículo
	 * @param id int - ID do veículo a ser abastecido
	 * @param quant int - Quantidade de combústivel adicionada ao veículo
	 * @return int - 0 Caso operação bem sucedida
	 * @return int - 1 Caso o valor de combustível seja invalido
	 * @return int - -1 Caso o ID não pertença ao array */
	public int abastecerVeiculo(int id, int quant){
		int i = encontraIndice(id); 

		if(i >= 0){// Se o id pertencer ao array

			if(quant > 0){
				this.veic[i].abastecerVeiculo(quant);
				return 0;
			}

			return 1;
		}

		return -1;
	}
	
	/** Método para alterar o valor de calibragem de um veículo específico, em uma roda específica
	 * @param id int - ID do veículo
	 * @param roda int - Roda para ser calibrada ou esvaziada
	 * @param acao String - Se deverá ser calibrado ou esvaziado
	 * @return int - -1 Caso a operação bem sucedida
	 * @return int - 0 Caso o valor da roda não precise ser alterado
	 * @return int - 1 Caso o ID não pertença ao array
	 * @return int - 2 Caso o valor para a roda seja invalido
	 * @return int - 3 Caso a ação especificada seja invalida (Diferente de Esvaziar ou Calibrar) */
	public int calibragem(int id, int roda, String acao){
		int i;

		if((i = encontraIndice(id)) > 0){
			if(roda < 1 || roda > 4){
				return 2;
			}

			else{
				if(acao.charAt(0) != 'e' && acao.charAt(0) != 'c')
					return 3;

				else{
					if((this.veic[i].calibragem(roda, acao)) == true)
						return -1;

					else
						return 0;
				}
			}
		}
		else
			return 1;
	}

	/** Método para alterar o valor de calibragem em todas as rodas de um veículo específico
	 * @param id int - ID do veículo
	 * @param acao String - Se deverá ser calibrado ou esvaziado
	 * @return String - "Valor Invalido" Caso a ação especificada seja invalida
	 * @return String - "ID Invalido" Caso o id não pertença ao array */
	public String calibragem(int id, String acao){
		int i = encontraIndice(id);

		if(i >= 0){
			if(acao.charAt(0) == 'e'){
				
				return this.veic[i].calibragem(false);
			}

			else if(acao.charAt(0) == 'c'){
				
				return this.veic[i].calibragem(true);
			}

			else
				return "Valor Invalido";
		}

		else
			return "ID Invalido";
	}

	/** Método para mover todos os veículos no array
	 * O veículo não irá se mover caso: 
	 * - Não tenha combustível suficiente (0,55 litros ou mais)
	 * - Não esteja com o IPVA em dia (valor true)
	 * - Não esteja com todos as rodas calibradas
	*/
	public void mover(){
		int i;
		for(i = 0 ; i < 20 ; i++)
			if(this.veic[i] != null)
				this.veic[i].mover();
	}

	/** Método para mover um veículo específico
	 * O veículo não irá se mover caso: 
	 * - Não tenha combustível suficiente (0,55 litros ou mais)
	 * - Não esteja com o IPVA em dia (valor true)
	 * - Não esteja com todos as rodas calibradas
	 * @param id int - ID do veículo a ser movido
	 * @return boolean - true Caso o veículo tenha sido movido
	 * @return boolean - false Caso o veíuclo não tenha sido movido */
	public boolean mover(int id){
		int i = encontraIndice(id);

		if(i >= 0){
			if(this.veic[i].mover() == true)
				return true;

			else
				return false;
		}

		return false;
	}

	/** Método específico para atualizar a quantidade de veículos no array após o carregamento do arquivo
	 * @param b boolean - Parâmetro simbólico apenas para diferenciar os métodos*/
	public void getVeic(boolean b){
		for(int i = 0 ; i < 20 ; i++){
			if(this.veic[i] != null)
				Simulador.setQuant(1);
		}
	}

	/** Método para obter todas as informações de todos os veículos dentro do array
	 */
	public void getVeic(){
		int i;
		
		for(i = 0 ; i < 20 ; i++){
			if(this.veic[i] != null){
				System.out.println("Id do Veiculo: " + this.veic[i].getId());
				System.out.println("Distancia Percorrida: " + this.veic[i].getDistanciaPercorrida());
				System.out.println("Combustivel: " + this.veic[i].getCombustivel());
				System.out.println("IPVA Status: " + this.veic[i].getIpva());
				System.out.println(this.veic[i].getRoda() + "\n");
			}	
		}
	}

	/** Método para obter todas as informações de um veículo específico
	 * @param it int - ID do veículo
	 */
	public void getVeic(int id){
		int i;

		if((i = encontraIndice(id)) >= 0)
		{
			System.out.println("Id do Veiculo: " + this.veic[i].getId());
			System.out.println("Distancia Percorrida: " + this.veic[i].getDistanciaPercorrida());
			System.out.println("Combustivel: " + this.veic[i].getCombustivel());
			System.out.println("IPVA Status: " + this.veic[i].getIpva());
			System.out.println("Roda Status:\n" + this.veic[i].getRoda());
		}
	}

	/** Método para obter a quantidade de veículos no array
	 * @return int - Retorna a variavel estática quantVeic;
	 */
	public static int getQuant(){
		return Simulador.quantVeic;
	}

	/** Método para diminuir 1 veículo do total
	 * Para diminuir, o método deve ser chamado sem parâmetros
	*/
	public static void setQuant(){
		Simulador.quantVeic -= 1; 
	}

	/** Método para adicionar um veículo no total
	 * @param i int - Parâmetro simbólico para adicionar um veículo na contagem total
	 */
	public static void setQuant(int i){
		Simulador.quantVeic += 1; 
	}

	/** Método para imprimir todos os veículos do array em uma pista
	*/
	public void imprimirPista(){
		for(int i = 0 ; i < 20 ; i++)
			if(this.veic[i] != null)
				System.out.print(this.veic[i].desenhaVeiculoPista());
	}
}