package poo.trabalho1.fun;
import java.io.Serializable;
import java.util.Random;
import src.*;
//import poo.trabalho1.fun.veiculos.motorizados.*;

/** Classe para conter e gerenciar todos os veículos adicionados e suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public class Simulador implements Serializable {
    private static int quantVeic = 0;
	private Veiculo[] veic = new Veiculo[20];
    static Random rand = new Random();
    private int nid = 1;

    public Simulador(){	
		for(int i = 0 ; i < this.veic.length ; i++)
			this.veic[i] = null;
	}

    private int getIndice(){
        int i;

        for(i = 0 ; (i < this.veic.length) && (this.veic[i] != null) ; i++);

        return (i < this.veic.length) ? i : -1;
    }

    //Incluir Veiculo
    public int incluirVeiculo(char tipo){
        int id, j;

        if(Simulador.getQuant() < 20){
            j = getIndice();
            if(j > -1 ){
                if(tipo == 'B' || tipo == 'b')
                    this.veic[j] = new Bicicleta(nid);

                else if(tipo == 'M' || tipo == 'm')
                    this.veic[j] = new Motocicleta(nid);

                else if(tipo == 'C' || tipo == 'c')
                    this.veic[j] = new CarroPasseio(nid);

                else if(tipo == 'E' || tipo == 'e')
                    this.veic[j] = new Esportivo(nid);
                
                Simulador.setQuant(1);
                this.nid++;

                return 1;
            }

            else
                return -1;
        }
}

    public static int getQuant(){
        return Simulador.quantVeic;
    }

	public static void setQuant(int i){
        Simulador.quantVeic += 1;
    }
}