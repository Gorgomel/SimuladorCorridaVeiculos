package poo.trabalho.fun;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import poo.trabalho.fun.veiculos.Bicicleta;
import poo.trabalho.fun.veiculos.VeiculoMotorizado;
import poo.trabalho.fun.veiculos.motorizados.CarroPasseio;
import poo.trabalho.fun.veiculos.motorizados.Esportivo;
import poo.trabalho.fun.veiculos.motorizados.Motocicleta;

/**
 * Fachada do simulador usada pelo menu de console.
 * Mantém compatibilidade de assinaturas com a versão legada.
 *
 * Armazenamento interno migrado para List/Map (capacidade 20 preservada).
 * IDs: 1=Bicicleta, 2=Motocicleta, 3=Esportivo, 4=CarroPasseio, seguidos de nid crescente.
 */
public class Simulador implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Capacidade lógica preservada do legado. */
    private static final int CAPACITY = 20;

    /** Contador público usado pelo menu (compatibilidade). */
    private static int quantVeic = 0;

    /** Novo armazenamento. */
    private final List<Veiculo> vehicles = new ArrayList<>();
    private final Map<Integer, Veiculo> byId = new HashMap<>();

    /** Semente para IDs (comportamento antigo: começa em 1). */
    private int nid;

    public Simulador() {
        this.nid = 1;
    }

    // ===== Compat: getters/setters usados pelo menu =====

    public static int getQuant() {
        return quantVeic;
    }

    /** Overload compatível com o legado: recalcula a contagem a partir da lista. */
    public static void setQuant() {
        // valor real será atualizado por instâncias; aqui mantemos comportamento seguro.
        // Dica: como quantVeic é atualizado nas operações, este método serve para "forçar" sincronização.
        // Em contexto estático não temos acesso à instância; manteremos como no-arg para compat.
        // Chamadores normalmente invocam após operações que já sincronizam. Então, não faz nada aqui.
        // Se necessário, pode-se redefinir como no-op. Para compatibilidade prática, deixo no-op.
    }

    /** Compat: setter com int (mantido). */
    public static void setQuant(int i) {
        quantVeic = i;
    }

    /** Quantidade atual de veículos. */
    public int contaVeiculos() {
        return vehicles.size();
    }

    // ===== Helpers internos =====

    private boolean atCapacity() {
        return vehicles.size() >= CAPACITY;
    }

    private Veiculo findById(int id) {
        return byId.get(id);
    }

    /** Dígito líder do ID (1/2/3/4). */
    private static int leadingDigit(int id) {
        int j = Math.abs(id);
        while (j / 10 > 0) j /= 10;
        return j;
    }

    /** Mapeia tipo textual para dígito líder. */
    private int verificaTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) return -1;
        char t = Character.toUpperCase(tipo.charAt(0));
        return switch (t) {
            case 'B' -> 1; // Bicicleta
            case 'M' -> 2; // Motocicleta
            case 'E' -> 3; // Esportivo
            case 'C' -> 4; // CarroPasseio
            default  -> -1;
        };
    }

    // ===== API pública (mantida) =====

    /**
     * Incluir veículo.
     * @param tipo 'B'/'M'/'E'/'C'
     * @return 0 ok; 1 tipo inválido; 2 capacidade cheia
     */
    public int incluirVeiculo(char tipo) {
        if (atCapacity()) return 2;

        char t = Character.toUpperCase(tipo);
        int createdId;
        Veiculo v;

        switch (t) {
            case 'B':
                createdId = Integer.parseInt("1" + nid);
                v = new Bicicleta(nid);
                break;
            case 'M':
                createdId = Integer.parseInt("2" + nid);
                v = new Motocicleta(nid);
                break;
            case 'E':
                createdId = Integer.parseInt("3" + nid);
                v = new Esportivo(nid);
                break;
            case 'C':
                createdId = Integer.parseInt("4" + nid);
                v = new CarroPasseio(nid);
                break;
            default:
                return 1;
        }

        vehicles.add(v);
        byId.put(createdId, v);
        nid++;
        quantVeic = vehicles.size();
        return 0;
    }

    /**
     * Remover veículo por ID.
     * @return 0 ok; 1 não encontrado
     */
    public int removerVeiculo(int id) {
        Veiculo v = findById(id);
        if (v == null) return 1;
        vehicles.remove(v);
        byId.remove(id);
        quantVeic = vehicles.size();
        return 0;
    }

    /**
     * Abastecer veículo motorizado.
     * @return 0 ok; 1 não encontrado; 2 quantidade inválida; 3 não motorizado
     */
    public int abastecerVeiculo(int id, int quant) {
        Veiculo v = findById(id);
        if (v == null) return 1;
        if (quant <= 0) return 2;
        if (!(v instanceof VeiculoMotorizado)) return 3;
        ((VeiculoMotorizado) v).abastecer(quant);
        return 0;
    }

    /**
     * Calibra/esvazia pneu específico.
     * @param acao "calibrar"/"esvaziar" (aceita "c"/"e")
     * @return 0 ok; 1 id não encontrado; 2 roda inválida; 3 ação inválida; 4 nada mudou
     */
    public int calibragem(int id, int roda, String acao) {
        Veiculo v = findById(id);
        if (v == null) return 1;
        if (roda < 1 || roda > v.getQuantidadeRodas()) return 2;

        if (acao == null) return 3;
        String a = acao.trim().toLowerCase(Locale.ROOT);
        boolean target;
        if (a.startsWith("c")) target = true;
        else if (a.startsWith("e")) target = false;
        else return 3;

        return v.calibragem(roda, target ? "calibrar" : "esvaziar") ? 0 : 4;
    }

    /** Calibrar/esvaziar todos os pneus por tipo. */
    public void calibragem(String tipo, boolean acao) {
        int val = verificaTipo(tipo);
        if (val < 0) return;
        for (Veiculo v : vehicles) {
            if (leadingDigit(v.getId()) == val) v.calibragem(acao);
        }
    }

    /** Move um veículo por ID. */
    public boolean mover(int id) {
        Veiculo v = findById(id);
        if (v == null) return false;
        return v.mover();
    }

    /** Move por tipo e retorna um resumo textual. */
    public String mover(String tipo) {
        int val = verificaTipo(tipo);
        if (val < 0) return "Tipo invalido";
        int moved = 0, tried = 0;
        for (Veiculo v : vehicles) {
            if (leadingDigit(v.getId()) == val) {
                tried++;
                if (v.mover()) moved++;
            }
        }
        return "Movidos " + moved + " de " + tried + " do tipo " + tipo.toUpperCase(Locale.ROOT);
    }

    /** Move todos e retorna um resumo textual. */
    public String mover() {
        int moved = 0;
        for (Veiculo v : vehicles) if (v.mover()) moved++;
        return "Movidos " + moved + " de " + vehicles.size() + " veiculos";
    }

    // ===== Impressão =====

    /** Overload compatível com UsaSimulador: imprimir dados. */
    public void imprimir() {
        imprimir(1);
    }

    /**
     * imprimir(int a)
     * a == 1 -> imprime dados
     * a == 2 -> imprime "pista" (ASCII)
     */
    public void imprimir(int a) {
        if (a == 2) {
            for (Veiculo v : vehicles) {
                System.out.print(v.desenhar());
            }
        } else {
            for (Veiculo v : vehicles) {
                // Dados básicos; ajuste livre conforme seu Veiculo
                System.out.println(v.toString());
            }
        }
    }

    /** imprimir por tipo ("B","M","E","C"). */
    public void imprimir(String tipo) {
        int val = verificaTipo(tipo);
        if (val < 0) {
            System.out.println("Tipo invalido");
            return;
        }
        for (Veiculo v : vehicles) {
            if (leadingDigit(v.getId()) == val) {
                System.out.println(v.toString());
            }
        }
    }

    // ===== Acesso seguro (útil para GUI futura) =====

    public List<Veiculo> getAllVehiclesView() {
        return Collections.unmodifiableList(vehicles);
    }
}
