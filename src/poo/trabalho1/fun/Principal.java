package poo.trabalho1.fun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Classe principal contendo um menu de interação para usar as funcionalidades
 * de um veículo
 * 
 * @author Leonardo Brunno Sink Lopes
 */

public class Principal {
    Simulador sim = new Simulador();
    Scanner scan = new Scanner(System.in);

    File arquivo = new File("saves\\simulador.dat");

    Button btnInfo = new Button();
    Button btnErro = new Button();
    Button btnAviso = new Button();

    public Principal() {
        sim = new Simulador();
    }

    // (1) Incluir ve´ıculo
    public void incluirVeiculo() {
        if (Simulador.getQuant() <= 20) { // Limite de 20 veículos

            Label nameLabel = new Label("Digite o ID ");
            GridPane.setConstraints(nameLabel, 0, 0);

            int i = 0;
            //int i = sim.incluirVeiculo(i);

            switch (i) {
                case 0:
                    System.out.println("Inserido com Sucesso!");
                    Simulador.setQuant(1);
                    break;

                case -1:
                    System.out.println("Invalido. ID já existe");
                    break;

                case 1:
                    System.out.println("Nao ha vagas para novos veiculos");
                    break;
            }
        }
    }

    // (2) Remover ve´ıculo
    public void removerVeiculo() {
        System.out.println("\nREMOVER VEICULO");

        if (Simulador.getQuant() > 0) {
            System.out.println("Digite o iD a ser removido: ");

            if ((sim.removerVeic(scan.nextInt())) == 0) {
                Simulador.setQuant();
                System.out.println("Removido com Sucesso");
            }

            else
                System.out.println("Falha ao Remover. ID Inexistente");
        }

        else
            System.out.println("Nao há veiculos inseridos");
    }

    // (3) Abastecer ve´ıculo
    public void abastecerVeiculo() {
        System.out.println("\nABASTECER VEICULO");

        if (Simulador.getQuant() > 0) {
            int i, id, quant;

            System.out.println("Informe o Veiculo a ser abastecido: ");
            id = scan.nextInt();

            System.out.println("Informe a quantia a ser abastecido: ");
            quant = scan.nextInt();

            i = sim.abastecerVeiculo(id, quant);

            switch (i) {
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
    }

    // (4) Movimentar um ve´ıculo
    public void movimentarVeiculo(int a) {
        System.out.println("\nMOVIMENTAR UM VEICULO");
        if (Simulador.getQuant() > 0) {
            System.out.println("Digite o iD a ser movido: ");

            if (sim.mover(scan.nextInt()))
                System.out.println("Movido com sucesso");

            else
                System.out.println("Falha ao mover");
        }
    }

    // (5) Movimentar todos os ve´ıculos.
    public void movimentarVeiculo() {
        System.out.println("\nMOVIMENTAR TODOS OS VEICULOS");

        if (Simulador.getQuant() > 0) {
            sim.mover();
        }
    }

    // (6) Imprimir todos os dados de um ve´ıculo
    public void imprimirDados(int a) {
        System.out.println("\nIMPRIMIR TODOS OS DADOS DE UM VEICULO");
        if (Simulador.getQuant() > 0) {
            System.out.println("Qual veiculo devera ser impresso: ");
            int i = scan.nextInt();
            sim.getVeic(i);
        }
    }

    // (7) Imprimir todos os dados de todos os ve´ıculos
    public void imprimirDados() {
        System.out.println("\nIMPRIMIR TODOS OS DADOS DE TODOS OS VEICULOS");
        if (Simulador.getQuant() > 0) {
            sim.getVeic();
        }
    }

    // (8) Esvaziar/calibrar um pneu espec´ıfico
    public void calibrar(int a) {
        System.out.println("\nESVAZIAR/ CALIBRAR UM PNEU ESPECIFICO");
        if (Simulador.getQuant() > 0) {
            int i, id, roda;
            String acao;

            do {
                System.out.println("Insira o id: ");
                id = scan.nextInt();

                System.out.println("Insira o Pneu (1 a 4): ");
                roda = scan.nextInt();

                System.out.println("Esvaziar ou calibrar? ('e' ou 'c'): ");
                acao = scan.next();

                i = sim.calibragem(id, roda, acao);

                if (i >= 0) {
                    switch (i) {

                        case 0:
                            System.out.println("Acao ja Realizada");
                            break;

                        case 1:
                            System.out.println("Erro " + i + ": ID Invalido");
                            break;

                        case 2:
                            System.out.println("Erro " + i + ": Valor para o Pneu invalido");
                            break;

                        case 3:
                            System.out.println("Erro " + i + ": Valor para Acao invalido");
                            break;
                    }
                }

                else
                    System.out.println("Acao realizada com sucesso");
            } while (i > 0);
        }
    }

    // (9) Esvaziar/calibrar todos os pneus de um ve´ıculo espec´ıfico
    public void calibrar() {
        System.out.println("\nESVAZIAR/ CALIBRAR TODOS OS PNEUS DE UM VEICULO ESPECIFICO");
        if (Simulador.getQuant() > 0) {
            int id;
            String acao;

            // do{
            System.out.println("Insira o id: ");
            id = scan.nextInt();

            System.out.println("Esvaziar ou calibrar? ('e' ou 'c'): ");
            acao = scan.next();

            System.out.println(sim.calibragem(id, acao));
        }
    }

    // (10) Imprimir pista de corrida
    public void imprimir() {
        System.out.println("\nIMPRIMIR PISTA DE CORRIDA");
        if (Simulador.getQuant() > 0)
            sim.imprimirPista();
    }

    // (11) Gravar ve´ıculos em arquivo
    public void gravar() {
        if (Simulador.getQuant() > 0) {
            System.out.println("Gravando arquivo");

            try {
                FileOutputStream fout = new FileOutputStream(arquivo);
                ObjectOutputStream oos = new ObjectOutputStream(fout);

                oos.writeObject(sim);

                oos.flush();
                oos.close();
                fout.close();
            } catch (Exception ex) {
                System.err.println("erro " + ex.toString());
            }
        }

        else
            System.out.println("Acao Invalida");

    }

    public void ler() {
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            Simulador simArq = (Simulador) oin.readObject();
            sim = simArq;
            oin.close();
            fin.close();

            sim.getVeic(true);
            System.out.println(" Quantidade de Veiculos " + Simulador.getQuant() +
                    "\nCarregamento bem sucessido");

        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }

}
