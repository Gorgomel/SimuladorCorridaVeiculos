iport javac.util.Scanner;

public class Simulador {
    private Veiculo[] veic = new Veiculo[20];
    static int QuantidadeVeic;
	Scanner scan = new Scanner(System.in);

	private boolean verifica(int id){
		return (id >= 1 && id <= 21) ? true : false;
	}
	
	private char sca(){
		return sca.next();
	}

	public Simulador(){
		for(int i = 0 ; i < 20 ; i++)
			veic[i] = new Veiculo();
	}
	
	public void RemoverVeic(int id){
		if(verifica(id)
			if(veic[id-1].getId() > 0)
			{
				System.out.println("Removendo Veiculo. Confirmar Operaçao? (s ou n): ");
				
				if(sca() == 'S' || sca() == 's')
					veic[id].removerVeic(id);
			}
			
		else
			System.out.println("Valor Invalido");
	}
	
	public void IncluirVeiculo(int id){
		if(verifica(id))
			if(veic[id-1].getId() < 1){
				System.out.println("Ja existe um veiculo no local, deseja continuar? (s ou n): ");
				
				if(sca() == 'S' || sca() == 's')
				{
					RemoverVeic(id);
					veic[id-1] = new Veiculo(id);	
				}
			}
			
		else
			System.out.println("Valor Invalido");
	}
	
	public void AbastecerVeiculo(int id, int quant){
		System.out.println("Quantos litros deseja Abastecer: ");
		veic[id-1].abastecerVeiculo(quant);
	}
	
}
