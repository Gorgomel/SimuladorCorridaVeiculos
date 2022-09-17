import java.util.Random;

public class Veiculo {
    private float combustivel;
    private int id;
    private int DistanciaPercorrida;
    private int QuantidadeRodas;
    private boolean ipva;
    private String desenho;
    private Roda[] rodas = new Roda[4];
    private Random rand = new Random();

    public int Veiculo() {
        ipva = rand.nextboolean();
        id = 1;
        DistanciaPercorrida = 0;
        combustivel = 2.5;
		
		for(int i = 0 ; i < 4 ; i++)
			Roda[i] = new Roda();
    }

    public int Veiculo(int iD) {
        ipva = rand.nextboolean();
        DistanciaPercorrida = 0;
        id = iD + 1;
        combustivel = 2.5;
			
		for(int i = 0 ; i < 4 ; i++)
			Roda[i] = new Roda();
    }

	public int getId(){
		return id;
	}
		
	public void removerVeic(int iD){
		ipva = null;
        DistanciaPercorrida = 0;
        id = -1;
        combustivel = 0;
			
	}

    public void abastecerVeiculo(int quant) {
        combustivel += quant;
    }

    public void calibragemEspec(boolean ac, int pneu){
        if(rodas[pneu].getCalibragem() != ac)
            rodas[pneu].setCalibragem(ac);
    }
	
	public void calibragemGeral(boolean ac){
        if(rodas[pneu].getCalibragem() != ac)
            rodas[pneu].setCalibragem(ac);
    }
}
