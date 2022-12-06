package poo.trabalho.fun;

import java.io.Serializable;
import poo.trabalho.fun.veiculos.*;
import poo.trabalho.fun.veiculos.motorizados.*;

public class Simulador implements Serializable {
    private static int quantVeic = 0;
    private Veiculo[] veic = new Veiculo[20];
    private int nid;// Veiculos que já foram inseridos, não se repetem

    public Simulador() {
        this.nid = 1;

        for (int i = 0; i < this.veic.length; i++)
            this.veic[i] = null;
    }

    
    /** 
     * @return int
     */
    private int getIndice() {
        int i;

        for (i = 0; (i < this.veic.length) && (this.veic[i] != null); i++)
            ;

        return (i < this.veic.length) ? i : -1;
    }

    
    /** 
     * @param id
     * @return int
     */
    private int encontraIndice(int id) {
        int i;
        for (i = 0; i < this.veic.length; i++) {
            if (this.veic[i] != null) // Para evitar maiores problemas, é feito a validação do índice antes da
                if (this.veic[i].getId() == id)
                    return i;
        }

        return -1;
    }

    
    /** 
     * @return int
     */
    public static int getQuant() {
        return Simulador.quantVeic;
    }

    
    /** 
     * @param i
     */
    public static void setQuant(int i) {
        Simulador.quantVeic += i;
    }

    public static void setQuant(){
        Simulador.quantVeic = 0;
    }

    
    /** 
     * @return int
     */
    public int contaVeiculos(){
        int conta = 0;

        for(int i = 0 ; i < this.veic.length ; i++)
            if(this.veic[i] != null)
                conta++;

        return conta;
    }

    
    /** 
     * @param tipo
     * @return int
     */
    // Incluir Veiculo
    public int incluirVeiculo(char tipo) {
        int j = getIndice();

        if (j > -1) {
            if (tipo == 'B' || tipo == 'b')
                this.veic[j] = (Veiculo) new Bicicleta(nid);

            else if (tipo == 'M' || tipo == 'm')
                this.veic[j] = (Veiculo) new Motocicleta(nid);

            else if (tipo == 'C' || tipo == 'c')
                this.veic[j] = (Veiculo) new CarroPasseio(nid);

            else if (tipo == 'E' || tipo == 'e')
                this.veic[j] = (Veiculo) new Esportivo(nid);

            this.nid++;

            return 1;
        }

        return 0;
    }

    
    /** 
     * @param id
     * @return int
     */
    public int removerVeiculo(int id) {
        int i;

        if ((i = encontraIndice(id)) >= 0) {
            this.veic[i] = null;
            return 0;
        }

        else
            return 1;
    }

    
    /** 
     * @param id
     * @param roda
     * @param acao
     * @return int
     */
    //Calibrar pneu especifico
    public int calibragem(int id, int roda, String acao){
        int i;

		if((i = encontraIndice(id)) > -1){
			if(roda < 0 || roda > this.veic[i].getQuantidadeRodas()){
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

    
    /** 
     * @param tipo
     * @param acao
     */
    //Calibrar por tipo
    public void calibragem(String tipo, boolean acao){
        int j, val = verificaTipo(tipo);

        for (int i = 0; i < this.veic.length; i++) {
            if (this.veic[i] != null) {
                j = this.veic[i].getId();

                while (j / 10 > 0)
                    j /= 10;

                if (j == val){
                        ((Veiculo) this.veic[i]).calibragem(acao);                    
                }
            }
        }

    }

    
    /** 
     * @param id
     * @param quant
     * @return int
     */
    public int abastecerVeiculo(int id, int quant) {
        if (quant > 0) {
            int i = encontraIndice(id);

            if (i >= 0) {
                if (this.veic[i] instanceof VeiculoMotorizado) {
                    ((VeiculoMotorizado) this.veic[i]).abastecer(quant);
                    return 0;
                }

                else
                    return 2;
            }

            else
                return -1;
        } else
            return 1;
    }

    
    /** 
     * @param id
     * @return boolean
     */
    // Movimentar um veiculo especifico
    public boolean mover(int id) {
        int i = encontraIndice(id);

        if (i >= 0) {
            if (this.veic[i].mover())
                return true;

            else
                return false;
        }

        return false;
    }

    
    /** 
     * @param tipo
     * @return int
     */
    private int verificaTipo(String tipo) {
        int val = -1;

        if (tipo.charAt(0) == 'B' || tipo.charAt(0) == 'b')
            val = 1;

        else if (tipo.charAt(0) == 'M' || tipo.charAt(0) == 'm')
            val = 2;

        else if (tipo.charAt(0) == 'E' || tipo.charAt(0) == 'e')
            val = 3;

        else if (tipo.charAt(0) == 'C' || tipo.charAt(0) == 'c')
            val = 4;

        return val;
    }

    
    /** 
     * @param tipo
     * @return String
     */
    // Movimentar veiculos por tipo
    public String mover(String tipo) {
        int j, x = 0, y = 0;

        int val = verificaTipo(tipo);

        for (int i = 0; i < this.veic.length; i++) {
            if (this.veic[i] != null) {
                j = this.veic[i].getId();

                while (j / 10 > 0)
                    j /= 10;

                if (j == val) {
                    x++;
                    if (this.veic[i].mover())
                        y++;
                }
            }
        }

        return tipo += x + "/" + y + " Veiculos movidos";
    }

    
    /** 
     * @return String
     */
    // Movimentar todos os veiculos
    public String mover() {
        int y = 0;

        for (int i = 0; i < this.veic.length; i++) {
            if (this.veic[i] != null) {
                if (this.veic[i].mover())
                    y++;
            }
        }

        return y + "/" + Simulador.getQuant() + " Veiculos Movidos";
    }

    
    /** 
     * @param i
     */
    private void usaImprimir(int i) {
        System.out.println("Id do Veiculo: " + this.veic[i].getId());

        if (this.veic[i] instanceof VeiculoMotorizado){
            System.out.println(((VeiculoMotorizado) this.veic[i]).getCombustivel());

            System.out.print("O IPVA no valor de: "+((VeiculoMotorizado) this.veic[i]).getsValorIpva());

            if(((VeiculoMotorizado) this.veic[i]).getStatusIpva())
                System.out.println(" Esta pago");

            else
                System.out.println(" Nao Esta pago");
        }

        System.out.println("Distancia Percorrida: " + this.veic[i].getDistanciaPercorrida());
        System.out.println("Roda Status:  " + this.veic[i].getRodas("")+"\n");
    }

    public void imprimir() {
        int i;

        for (i = 0; i < 20; i++) {
            if (this.veic[i] != null) {
                usaImprimir(i);
            }
        }
    }

    
    /** 
     * @param a
     */
    // Imprimir Pista
    public void imprimir(int a) {
        for (int i = 0; i < 20; i++)
            if (this.veic[i] != null)
                System.out.print(this.veic[i].desenhar());
    }

    
    /** 
     * @param tipo
     */
    // Imprimir dados de veiculos por tipo
    public void imprimir(String tipo) {
        int j, val = verificaTipo(tipo);

        for (int i = 0; i < this.veic.length; i++) {
            if (this.veic[i] != null) {
                j = this.veic[i].getId();

                while (j / 10 > 0)
                    j /= 10;

                if (j == val) 
                    usaImprimir(i);
            }
        }
    }



}