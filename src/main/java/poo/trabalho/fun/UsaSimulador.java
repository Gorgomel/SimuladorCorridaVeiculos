package poo.trabalho.fun;

import java.io.File;

/**
 * Aplicação de console do simulador.
 * Mantém o menu original, porém com leitura robusta e mensagens claras.
 */
public class UsaSimulador {
    private static final String DEFAULT_SAVE_DIR  = "saves";
    private static final String DEFAULT_SAVE_PATH = DEFAULT_SAVE_DIR + File.separator + "simulador.dat";

    private static final Leitor in = new Leitor();

    public static void main(String[] args) {
        Simulador sim = new Simulador();
        loopMenu(sim);
    }

    private static void loopMenu(Simulador sim) {
        while (true) {
            mostrarMenu(sim);
            int opc = in.lerInt("Escolha uma opção: ", 1, 15);

            switch (opc) {
                case 1 -> opcIncluir(sim);
                case 2 -> opcRemover(sim);
                case 3 -> opcAbastecer(sim);
                case 4 -> opcMoverUm(sim);
                case 5 -> opcMoverPorTipo(sim);
                case 6 -> opcMoverTodos(sim);
                case 7 -> opcImprimirTodos(sim);
                case 8 -> opcImprimirPorTipo(sim);
                case 9 -> opcPneuEspecifico(sim);
                case 10 -> opcCalibrarPorTipo(sim, true);
                case 11 -> opcCalibrarPorTipo(sim, false);
                case 12 -> opcImprimirPista(sim);
                case 13 -> opcGravar(sim);
                case 14 -> opcLer(sim);
                case 15 -> { System.out.println("Saindo..."); return; }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void mostrarMenu(Simulador sim) {
        System.out.println();
        System.out.println("MENU     Quantidade de Veiculos: " + Simulador.getQuant());
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
    }

    // ===== Opções =====

    private static void opcIncluir(Simulador sim) {
        System.out.println("\nINCLUIR VEICULO");
        char t = in.lerChar("Informe o tipo de veiculo (B, M, C, E): ", 'B','M','C','E');
        int rc = sim.incluirVeiculo(t);
        switch (rc) {
            case 0 -> System.out.println("Veiculo incluído.");
            case 1 -> System.out.println("Tipo inválido.");
            case 2 -> System.out.println("Capacidade cheia (máx 20).");
            default -> System.out.println("Falha desconhecida.");
        }
    }

    private static void opcRemover(Simulador sim) {
        System.out.println("\nREMOVER VEICULO");
        int id = in.lerInt("Informe o ID do veiculo: ");
        int rc = sim.removerVeiculo(id);
        System.out.println(rc == 0 ? "Removido." : "ID não encontrado.");
    }

    private static void opcAbastecer(Simulador sim) {
        System.out.println("\nABASTECER VEICULO");
        int id = in.lerInt("Informe o ID do veiculo: ");
        int litros = in.lerInt("Quantidade de litros: ", 1, 1_000_000);
        int rc = sim.abastecerVeiculo(id, litros);
        switch (rc) {
            case 0 -> System.out.println("Abastecido.");
            case 1 -> System.out.println("ID não encontrado.");
            case 2 -> System.out.println("Quantidade inválida.");
            case 3 -> System.out.println("Veiculo não é motorizado.");
            default -> System.out.println("Falha desconhecida.");
        }
    }

    private static void opcMoverUm(Simulador sim) {
        System.out.println("\nMOVER VEICULO ESPECIFICO");
        int id = in.lerInt("Informe o ID do veiculo: ");
        boolean moved = sim.mover(id);
        System.out.println(moved ? "Veiculo moveu." : "Não foi possível mover (pneu/fuel/IPVA).");
    }

    private static void opcMoverPorTipo(Simulador sim) {
        System.out.println("\nMOVER POR TIPO");
        char t = in.lerChar("Tipo (B, M, C, E): ", 'B','M','C','E');
        String out = sim.mover(String.valueOf(t));
        System.out.println(out);
    }

    private static void opcMoverTodos(Simulador sim) {
        System.out.println("\nMOVER TODOS");
        String out = sim.mover();
        System.out.println(out);
    }

    private static void opcImprimirTodos(Simulador sim) {
        System.out.println("\nIMPRIMIR DADOS (TODOS)");
        sim.imprimir(); // overload sem argumentos
    }

    private static void opcImprimirPorTipo(Simulador sim) {
        System.out.println("\nIMPRIMIR POR TIPO");
        char t = in.lerChar("Tipo (B, M, C, E): ", 'B','M','C','E');
        sim.imprimir(String.valueOf(t));
    }

    private static void opcPneuEspecifico(Simulador sim) {
        System.out.println("\nPNEU ESPECIFICO");
        int id = in.lerInt("ID do veiculo: ");
        int roda = in.lerInt("Qual roda (1..4): ", 1, 4);
        char ac = in.lerChar("Ação (C=calibrar, E=esvaziar): ", 'C','E');
        int rc = sim.calibragem(id, roda, ac == 'C' ? "calibrar" : "esvaziar");
        switch (rc) {
            case 0 -> System.out.println("Ok.");
            case 1 -> System.out.println("ID não encontrado.");
            case 2 -> System.out.println("Roda inválida.");
            case 3 -> System.out.println("Ação inválida.");
            case 4 -> System.out.println("Nada mudou (já estava nesse estado).");
            default -> System.out.println("Falha desconhecida.");
        }
    }

    private static void opcCalibrarPorTipo(Simulador sim, boolean calibrar) {
        System.out.println(calibrar ? "\nCALIBRAR POR TIPO" : "\nESVAZIAR POR TIPO");
        char t = in.lerChar("Tipo (B, M, C, E): ", 'B','M','C','E');
        sim.calibragem(String.valueOf(t), calibrar);
        System.out.println("OK.");
    }

    private static void opcImprimirPista(Simulador sim) {
        System.out.println("\nPISTA DE CORRIDA");
        sim.imprimir(2);
    }

    private static void opcGravar(Simulador sim) {
        System.out.println("\nGravando arquivo");
        try {
            ensureSaveDir();
            sim.salvarEmArquivo(DEFAULT_SAVE_PATH);
            System.out.println("Salvo em: " + DEFAULT_SAVE_PATH);
        } catch (Throwable t) {
            System.out.println("erro " + t);
        }
    }

    private static void opcLer(Simulador sim) {
        System.out.println("\nLendo arquivo");
        try {
            File f = new File(DEFAULT_SAVE_PATH);
            if (!f.exists()) {
                System.out.println("Arquivo não encontrado: " + DEFAULT_SAVE_PATH);
                return;
            }
            sim.lerDeArquivo(DEFAULT_SAVE_PATH);
            System.out.println("Carregado de: " + DEFAULT_SAVE_PATH);
        } catch (Throwable t) {
            System.out.println("erro " + t);
        }
    }

    // ===== util =====
    private static void ensureSaveDir() {
        File dir = new File(DEFAULT_SAVE_DIR);
        if (!dir.exists()) dir.mkdirs();
    }
}
