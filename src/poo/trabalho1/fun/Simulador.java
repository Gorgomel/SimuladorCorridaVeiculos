package poo.trabalho1.fun;
import java.io.Serializable;

public class Simulador implements Serializable {
    private Veiculo[] veic = new Veiculo[20];
    private static int quantVeic = 0;
	
	public Simulador(){	
		for(int i = 0 ; i < 20 ; i++)
			veic[i] = null;
	}

	//Método para encontrar, caso houver, um indice vazio
	private int indiceVazio(){
		int i;
		for(i = 0 ; (i < 20) && (veic[i] != null) ; i++);
		
		return (i < 20) ? i : -1;
	}

	private int encontraIndice(int id){
		int i;
		for(i = 0 ; i < 20 ; i++){
			if(veic[i] != null)
				if(veic[i].getId() == id)	
					return i;
		}

		return -1;
	}
	
	public int removerVeic(int id){
		int i;
		if((i = encontraIndice(id)) >= 0){
			if(veic[i] != null){
				veic[i] = null;
				return 0;
			}
			
			else
				return 1;
		}

		else
			return 1;
	}
	
	public int incluirVeiculo(int id){
		int i = indiceVazio();

		if(encontraIndice(id) == -1){

			if(i >= 0){
				veic[i] = new Veiculo(id);
				return 0;
			}

			else
				return 1;
		}

		else
			return -1;
	}

	public int abastecerVeiculo(int id, int quant){
		int i = encontraIndice(id);

		if(i >= 0){
			if(quant > 0){
				veic[i].abastecerVeiculo(quant);
				return 0;
			}

			return 1;
		}

		return -1;
	}
	
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
					if((veic[i].calibragem(roda, acao)) == true)
						return -1;

					else
						return 0;
				}
			}

		}

		else
			return 1;
	}

	public int calibragem(int id, String acao){
		int i = encontraIndice(id);

		if(i >= 0){
			if(acao.charAt(0) == 'e'){
				veic[i].calibragem(false);
				return -1;
			}

			else if(acao.charAt(0) == 'c'){
				veic[i].calibragem(true);
				return -1;
			}

			else
				return 2;
		}

		else
			return 1;
	}

	public void mover(){
		int i;
		for(i = 0 ; i < 20 ; i++)
			if(veic[i] != null)
				veic[i].mover();
	}

	public boolean mover(int id){
		int i = encontraIndice(id);
		if(i >= 0){
			if(veic[i].mover() == true)
				return true;

			else
				return false;
		}

		return false;
	}


	public void getVeic(boolean b){
		for(int i = 0 ; i < 20 ; i++){
			if(veic[i] != null)
				Simulador.setQuant(1);
		}
	}
	public void getVeic(){
		int i;
		
		for(i = 0 ; i < 20 ; i++){
			if(veic[i] != null){
				System.out.println("Id do Veiculo: " + veic[i].getId());
				System.out.println("Distancia Percorrida: " + veic[i].getDistanciaPercorrida());
				System.out.println("Combustivel: " + veic[i].getCombustivel());
				System.out.println("IPVA Status: " + veic[i].getIpva());
				System.out.println(veic[i].getRoda());
				System.out.printf("\n");
			}	
		}
	}

	public void getVeic(int id){
		int i;

		if((i = encontraIndice(id)) >= 0)
		{
			System.out.println("Id do Veiculo: " + veic[i].getId());
			System.out.println("Distancia Percorrida: " + veic[i].getDistanciaPercorrida());
			System.out.println("Combustivel: " + veic[i].getCombustivel());
			System.out.println("IPVA Status: " + veic[i].getIpva());
			System.out.println("Roda Status:\n" + veic[i].getRoda());
		}
	}

	public static int getQuant(){
		return Simulador.quantVeic;
	}

	public static void setQuant(){
		Simulador.quantVeic -= 1; 
	}

	public static void setQuant(int i){
		Simulador.quantVeic += i; 
	}

	public void imprimirPista(){
		for(int i = 0 ; i < 20 ; i++){
			if(veic[i] != null){
				veic[i].desenhaVeiculoPista();
				System.out.print(veic[i].getDesenho(0));
				System.out.print(veic[i].getDesenho(1));
				System.out.print(veic[i].getDesenho(2));
				System.out.print(veic[i].getDesenho(3));
			}		
		}
	}
}