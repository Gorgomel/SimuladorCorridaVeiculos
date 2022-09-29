package poo.trabalho1.fun;
import java.util.Random;

import java.io.Serializable;

public class Veiculo  implements Serializable{
    private float combustivel;
    private int id;
    private int distanciaPercorrida;
    private int quantidadeRodas;
    private boolean ipva;
    private String [] desenho = new String[4];
    Roda[] rodas = new Roda[4];
    private Random rand = new Random();

    public Veiculo() {
        
    }

    public Veiculo(int id) {
        ipva = rand.nextBoolean();
        distanciaPercorrida = 0;
        this.id = id;
        combustivel = 2.5f;
        quantidadeRodas = 0;
        desenho[0] = "    ____\n";
        desenho[1] = " __/  |_ \\_\n";
        desenho[2] = "|  _     _``-.\n";
        desenho[3] =  "'-(_)---(_)--'\n\n\n";
		
        for(int i = 0 ; i < 4 ; i++){
            rodas[i] = new Roda();
            
            if(rodas[i].getCalibragem() == true)
                quantidadeRodas += 1;
        }
    }

	public int getId(){
		return this.id;
	}

    public int getDistanciaPercorrida(){
        return this.distanciaPercorrida;
    }

    public float getCombustivel(){
        return this.combustivel;
    }

    public boolean getIpva(){
        return this.ipva;
    }

    public String getRoda(){
        return "Rodas Calibradas: " + quantidadeRodas + "\nRoda 1: " + rodas[0].getCalibragem()+ "\nRoda 2: " + rodas[1].getCalibragem()
        + "\nRoda 3: " + rodas[2].getCalibragem() + "\nRoda 4: " + rodas[3].getCalibragem();
    }

    public String getDesenho(int i){
        return this.desenho[i];
    }

    public boolean calibragem(int roda, String acao){
        if(acao.charAt(0) == 'e'){
            if((rodas[roda-1].setCalibragem(false)) == true)
                return true;
            
            else
                return false;
        }

        else{
            if((rodas[roda-1].setCalibragem(true)) == true)
                return true;

            else 
                return false;
        }
    }

	public void calibragem(boolean acao){
            for(int i = 0 ; i < 4 ; i++)
                rodas[i].setCalibragem(acao);
    }

    public void abastecerVeiculo(int quant) {
        combustivel += quant;
    }

    private boolean confereCalibragem(Roda []rodas){
        int i;
        for(i = 0 ; (i < 4) && (rodas[i].getCalibragem() == true) ; i++);

        return (i < 4) ? false : true;
    }

    public void desenhaVeiculoPista(){
        String giroCar = " ";
        for(int i = 0 ; i < this.desenho.length ; i++)
        for(int j = 0 ; j < this.distanciaPercorrida ; j++){
	            this.desenho[i] = giroCar + this.desenho[i];
        } 
    }

    public boolean mover(){
        if(combustivel >= 0.55 && confereCalibragem(rodas) == true && ipva == true)
        {
            combustivel -= 0.55;
            distanciaPercorrida += 5;
            return true;
        }

        else
            return false;
    }
}