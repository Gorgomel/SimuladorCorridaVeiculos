package poo.trabalho1.fun;
import java.io.Serializable;
import java.util.Random;

import poo.trabalho1.fun.veiculos.motorizados.CarroPasseio;
import poo.trabalho1.fun.veiculos.motorizados.Esportivo;

/** Classe para conter e gerenciar todos os veículos adicionados e suas funcionalidades
 * @author Leonardo Brunno Sink Lopes
 */

public class Simulador implements Serializable {
    private static int quantVeic = 0;
	private Veiculo[] veic = new Veiculo[20];
    static Random rand = new Random();

    public Simulador(){	
		for(int i = 0 ; i < this.veic.length ; i++)
			this.veic[i] = null;
	}

    private int bubbleSort(int indice){
        if(this.veic != null){
            if(Simulador.getQuant() > 1){
            int i, j;
            boolean troca = true;
            Veiculo x;

            for(i = indice ; (i < this.veic.length -1) && (troca) ; i++){
                troca = false;

                for(j = indice; j < this.veic.length - i - 1 ; j++){
                    if(this.veic[j].getId().compareTo(this.veic[j + 1].getId()) < 0){
                        x = this.veic[j];
                        this.veic[j] = this.veic[j + 1];
                        this.veic[j + 1] = x;
                        troca = true;
                    }
                }
            }
        }
            return 1;
        }

        return -1;
    }


    private int insert(){
        if(this.veic != null){
            int i = 0;
            for(i = i ; (i < this.veic.length) && (this.veic[i] != null) ; i++);

            if((i < this.veic.length) && (this.veic[i+1] == null))
                return i;
        }

        return -1;
    }
    
    //Gera o id do Veiculo
    private String geradorId(int tipo){
        if(this.veic != null){
            int i, x;

            for(i = 0 ; (i < (this.veic.length)) ; i++){
                if(this.veic[i] != null){
                    x = this.veic[i].getId().charAt(0) - '0';

                    System.out.println("xxx:   "+ x + "  tipp : " + tipo + "\n");

                    if(x > tipo){//Caso o identificador do indice seja maior
                        System.out.println("xxxxxxxxxxxx222: "+ (x) + "\n");
                        x = (this.veic[i-1].getId().charAt(0)) - '0';

                        System.out.println("xxxxxxxxxxxx222: "+ (x) + "\n");
                        if(x == tipo){//Caso nao seja o primeiro tipo no vetor
                            x = (this.veic[i-1].getId().charAt(2)) - '0';

                            System.out.println("iiiiiiiiiiiiiiii:  "+ (i-1) + "\n");
                            x = x+ 1;

                            if(x > 9){
                               
                                return "0" + x + i;
                            }

                            else{
                                return "" + "0" + x + i;
                            }
                        }  
                    }
                    
                }

                else
                    return "0" + i;
            }
        }

        return "-1";
    }

    //Incluir Veiculo
    public int incluirVeiculo(char tipo){
        String id;

        if(Simulador.getQuant() < 20){
        //Tipo Esportivo
        if(tipo == 'E'){
            if(Simulador.getQuant() == 0){//Significa que é o primeiro elemento do vetor
                this.veic[0] = new Esportivo("00");
                Simulador.setQuant(1);
                return 1;
            }    

            id = geradorId(1);
            int k = insert();
            this.veic[k] = new Esportivo(id);
            Simulador.setQuant(1);
        }

        //Tipo Esportivo
        if(tipo == 'P'){
            if(Simulador.getQuant() == 0){//Significa que é o primeiro elemento do vetor
                this.veic[0] = new Esportivo("00");
                Simulador.setQuant(1);
                return 1;
            }    

            id = geradorId(2);
            int k = insert();
            this.veic[k] = new Esportivo(id);
            Simulador.setQuant(1);
        }

        //Tipo Passeio
       /*  if(tipo == 'P'){
            if(Simulador.getQuant() == 0){//Significa que é o primeiro elemento do vetor
                this.veic[0] = new CarroPasseio("0");
                Simulador.setQuant(1);
                return 1;
            }
            
            id = geradorId(2);
            int k = insert();
            veic[k] = new Esportivo(id);
            Simulador.setQuant(1);
        }

        //Tipo Esportivo
        if(tipo == 'M'){
            if(Simulador.getQuant() == 0){//Significa que é o primeiro elemento do vetor
                this.veic[0] = new Esportivo("0");
                Simulador.setQuant(1);
                return 1;
            }
            
            id = geradorId(3);
            int k = insert();
            veic[k] = new Esportivo(id);
            Simulador.setQuant(1);
        }

        //Tipo Bicicleta
        if(tipo == 'B'){
            if(Simulador.getQuant() == 0){//Significa que é o primeiro elemento do vetor
                this.veic[0] = new Esportivo("0");
                Simulador.setQuant(1);
                return 1;
            }
            
            id = geradorId(4);
            int k = insert();
            veic[k] = new Esportivo(id);
            Simulador.setQuant(1);
        }*/

        for(int i = 0 ; (i < this.veic.length) && (this.veic[i] != null) ; i++){
            System.out.println("indice i: " + i + "\tid: "+ this.veic[i].getId() + "\n");
        }
    }
    return 2;
    }

    
}

    public static int getQuant(){
        return Simulador.quantVeic;
    }

	public static void setQuant(int i){
        Simulador.quantVeic += 1;
    }
}