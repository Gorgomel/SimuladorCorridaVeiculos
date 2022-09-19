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

    public Veiculo() {
        ipva = rand.nextBoolean();
        id = 1;
        DistanciaPercorrida = 0;
        combustivel = 2;

		for(int i = 0 ; i < 4 ; i++)
            rodas[i] = new Roda();
    }

    public Veiculo(int iD) {
        ipva = rand.nextBoolean();
        DistanciaPercorrida = 0;
        id = iD + 1;
        combustivel = 2;
		
        for(int i = 0 ; i < 4 ; i++)
            rodas[i] = new Roda();
    }

	public int getId(){
		return id;
	}
		
	public void removerVeic(int iD){
		ipva = false;
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
        if(rodas[id].getCalibragem() != ac)
            for(int i = 0 ; i < 4 ; i++)
                rodas[i].setCalibragem(ac);
    }

    public void mover(){
        
    }
}
