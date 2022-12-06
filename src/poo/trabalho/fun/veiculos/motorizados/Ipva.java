package poo.trabalho.fun.veiculos.motorizados;

public interface Ipva {

    public static final double cte_Passeio = 1.3;
    public static final double cte_Motocicleta = 0.75;
    public static final double cte_Esportivo = 3.15;
    public static final double valor_Base = 500;

    public double calcularIpva(); 
    
}
