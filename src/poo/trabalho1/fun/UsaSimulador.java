package poo.trabalho1.fun;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/** Classe principal contendo um menu de interação para usar as funcionalidades de um veículo
 *  @author Leonardo Brunno Sink Lopes
 */

public class UsaSimulador {
    public static void main(String[] args){
        Simulador sim = new Simulador();
        Scanner scan = new Scanner(System.in);
        int n;

        File arquivo = new File("saves\\simulador.dat");

        do{
            System.out.println("\nMENU");
            System.out.println("(1) Incluir veiculo");
            System.out.println("(2) Remover veiculo");
            System.out.println("(3) Abastecer veiculo");
            System.out.println("(4) Movimentar um veiculo especifico");
            System.out.println("(5) Movimentar veiculos por tipo");
            System.out.println("(6) Movimentar todos os veiculos");
            System.out.println("(7) Imprimir todos os dados de todos os veiculos");
            System.out.println("(8) Imprimir dados de veiculos por tipo");
            System.out.println("(9) Esvaziar/calibrar um pneu especifico");
            System.out.println("(10) Calibrar todos os pneus de veiculos por tipo");
            System.out.println("(11) Esvaziar todos os pneus de veiculos por tipo");
            System.out.println("(12) Imprimir pista de corrida");
            System.out.println("(13) Gravar veiculos em arquivo");
            System.out.println("(14) Ler veiculos do arquivo");
            System.out.println("(15) Sair da aplicacao");   

            do{// Validando a entrada correta de valores para o menu
                n = scan.nextInt(); 
                if(n < 1 || n > 13)
                    System.out.println("Invalido");

            }while(n < 1 || n > 13);

            switch(n){
                //(1) Incluir ve´ıculo
                case 1:
                    System.out.println("\nINCLUIR VEICULO");

                    if(Simulador.getQuant() <= 20){ // Limite de 20 veículos 
                        String tipo;
                        //informe o tipo
                        do{
                            System.out.println("Informe o tipo de veiculo (B, M, C, E): ");
                            tipo = scan.next();
                            
                            if(tipo.charAt(0) != 'B' || tipo.charAt(0) != 'b' || 
                            tipo.charAt(0) != 'M' || tipo.charAt(0) != 'm' ||
                            tipo.charAt(0) != 'C' || tipo.charAt(0) != 'c' ||
                            tipo.charAt(0) != 'E' || tipo.charAt(0) != 'e'){

                                System.out.println("Invalido");
                            }

                        }while(tipo.charAt(0) != 'B' && tipo.charAt(0) != 'b' && 
                        tipo.charAt(0) != 'M' && tipo.charAt(0) != 'm' &&
                        tipo.charAt(0) != 'C' && tipo.charAt(0) != 'c' &&
                        tipo.charAt(0) != 'E' && tipo.charAt(0) != 'e');


                        System.out.println("Tipo eh: "+tipo.charAt(0));
                        int i = sim.incluirVeiculo(tipo.charAt(0));

                        switch(i){
                            case 0:
                                System.out.println("Nao ha vagas para novos veiculos");
                                break;

                            case 1:
                                System.out.println("Veiculo Inserido com Sucesso");
                                Simulador.setQuant(1);
                                break;
                        }
                    }
                    break;
                
                /*//(2) Remover ve´ıculo
                case 2:
                    System.out.println("\nREMOVER VEICULO");

                    if(Simulador.getQuant() > 0 ){ 
                        System.out.println("Digite o iD a ser removido: ");
                    
                        if((sim.removerVeic(scan.nextInt())) == 0){
                            Simulador.setQuant();
                            System.out.println("Removido com Sucesso");
                        }

                        else
                            System.out.println("Falha ao Remover. ID Inexistente");
                    }

                    else
                        System.out.println("Nao há veiculos inseridos");
                    break;

                //(3) Abastecer ve´ıculo
                case 3:
                    System.out.println("\nABASTECER VEICULO");

                    if(Simulador.getQuant() > 0 ){
                        int i, id, quant;

                        System.out.println("Informe o Veiculo a ser abastecido: ");
                        id = scan.nextInt();

                        System.out.println("Informe a quantia a ser abastecido: ");
                        quant = scan.nextInt();

                        i = sim.abastecerVeiculo(id, quant);

                        switch(i){
                            case -1:
                                System.out.println("ID Invalido");
                                break;

                            case 0:
                                System.out.println("Abastecido com sucesso");
                                break;

                            case 1:
                                System.out.println("Quantia de combustivel invalido");
                                break;
                        }
                    }

                    else
                        System.out.println("Nao há veiculos inseridos");
                    break;

                //(4) Movimentar um ve´ıculo
                case 4:
                    System.out.println("\nMOVIMENTAR UM VEICULO");
                    if(Simulador.getQuant() > 0 ){
                        System.out.println("Digite o iD a ser movido: ");
                
                        if(sim.mover(scan.nextInt()))
                            System.out.println("Movido com sucesso");

                        else
                           System.out.println("Falha ao mover");
                    }
                break;

                //(5) Movimentar todos os ve´ıculos.
                case 5:
                    System.out.println("\nMOVIMENTAR TODOS OS VEICULOS");
        
                    if(Simulador.getQuant() > 0 ){
                        sim.mover();
                    }
                    break;

                //(6) Imprimir todos os dados de um ve´ıculo
                case 6:
                    System.out.println("\nIMPRIMIR TODOS OS DADOS DE UM VEICULO");
                    if(Simulador.getQuant() > 0){
                        System.out.println("Qual veiculo devera ser impresso: ");
                        int i = scan.nextInt();
                        sim.getVeic(i);
                    }
                    break;

                //(7) Imprimir todos os dados de todos os ve´ıculos
                case 7:
                    System.out.println("\nIMPRIMIR TODOS OS DADOS DE TODOS OS VEICULOS");
                    if(Simulador.getQuant() > 0){
                        sim.getVeic();
                    }
                    break;

                //(8) Esvaziar/calibrar um pneu espec´ıfico
                case 8:
                    System.out.println("\nESVAZIAR/ CALIBRAR UM PNEU ESPECIFICO");
                    if(Simulador.getQuant() > 0){
                        int i, id, roda;
                        String acao;
                        
                        do{
                            System.out.println("Insira o id: ");
                            id = scan.nextInt();

                            System.out.println("Insira o Pneu (1 a 4): ");
                            roda = scan.nextInt();

                            System.out.println("Esvaziar ou calibrar? ('e' ou 'c'): ");
                            acao = scan.next();

                            i = sim.calibragem(id, roda, acao);

                           if(i >= 0){
                                switch(i){

                                    case 0:
                                        System.out.println("Acao ja Realizada");
                                        break;

                                    case 1: 
                                        System.out.println("Erro "+i+": ID Invalido");
                                        break;

                                    case 2:
                                        System.out.println("Erro "+i+": Valor para o Pneu invalido");
                                        break;

                                    case 3:
                                        System.out.println("Erro "+i+": Valor para Acao invalido");
                                        break;
                                }
                            }
                            
                            else
                            System.out.println("Acao realizada com sucesso");
                        }while(i > 0);
                    }
                    break;

                //(9) Esvaziar/calibrar todos os pneus de um ve´ıculo espec´ıfico
                case 9:
                    System.out.println("\nESVAZIAR/ CALIBRAR TODOS OS PNEUS DE UM VEICULO ESPECIFICO");
                    if(Simulador.getQuant() > 0){
                        int id;
                        String acao;
                        
                        //do{
                            System.out.println("Insira o id: ");
                            id = scan.nextInt();

                            System.out.println("Esvaziar ou calibrar? ('e' ou 'c'): ");
                            acao = scan.next();

                            System.out.println(sim.calibragem(id, acao));   
                    }
                    break;
                
                //(10) Imprimir pista de corrida
                case 10:
                    System.out.println("\nIMPRIMIR PISTA DE CORRIDA");
                    if(Simulador.getQuant() > 0)
                        sim.imprimirPista();
                    break;

                //(11) Gravar ve´ıculos em arquivo
                case 11:
                if(Simulador.getQuant() > 0){
                    System.out.println("Gravando arquivo");

                    try{
                        FileOutputStream fout = new FileOutputStream(arquivo);
                        ObjectOutputStream oos = new ObjectOutputStream(fout);

                        oos.writeObject(sim);

                        oos.flush();
                        oos.close();
                        fout.close();
                    }catch (Exception ex){
                        System.err.println("erro "+ ex.toString());
                    }
                }

                else
                    System.out.println("Acao Invalida");
        
                break;

                case 12:    
                    try{
                        FileInputStream fin = new FileInputStream(arquivo);
                        ObjectInputStream oin = new ObjectInputStream(fin);

                        Simulador simArq = (Simulador) oin.readObject();
                        sim = simArq;
                        oin.close();
                        fin.close();

                        sim.getVeic(true);
                        System.out.println(" Quantidade de Veiculos "+Simulador.getQuant()+
                        "\nCarregamento bem sucessido");
            
                    }catch(Exception ex){
                        System.err.println("erro: "+ ex.toString());
                    }
                

                break;*/
        }
    }while(n != 13);

    scan.close();
}
}
