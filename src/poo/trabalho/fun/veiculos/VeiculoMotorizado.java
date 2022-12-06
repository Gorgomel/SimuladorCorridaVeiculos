package poo.trabalho.fun.veiculos;
import java.util.Random;

import poo.trabalho.fun.Veiculo;

public abstract class VeiculoMotorizado extends Veiculo{
    private final static double gastoMotocicleta = 0.25f;
    private final static double gastoPasseio = 0.75;
    private final static double gastoEsportivo = 2.3;
    private double combustivel;
    private double valorIpva;
    private boolean statusIpva;

    public VeiculoMotorizado(int nid, double valorIpva, int quantidadeRodas){
        super(nid, quantidadeRodas);
        this.combustivel = 2.5;
        this.valorIpva = valorIpva;

        Random rand = new Random();
        this.statusIpva = rand.nextBoolean();
    }

    
    /** 
     * @param quant
     */
    public void abastecer(double quant){
        this.combustivel += quant;
    }

    
    /** 
     * @return double
     */
    public double getCombustivel(){
        return this.combustivel;
    }

    
    /** 
     * @return boolean
     */
    public boolean getStatusIpva(){
        return this.statusIpva;
    }

    
    /** 
     * @return double
     */
    public double getsValorIpva(){
        return this.valorIpva;
    }

    
    /** 
     * @return double
     */
    public static double getGastoMotocicleta(){
        return VeiculoMotorizado.gastoMotocicleta;
    }

    
    /** 
     * @return double
     */
    public static double getGastoPasseio(){
        return VeiculoMotorizado.gastoPasseio;
    }

    
    /** 
     * @return double
     */
    public static double getGastoEsportivo(){
        return VeiculoMotorizado.gastoEsportivo;
    }
}
