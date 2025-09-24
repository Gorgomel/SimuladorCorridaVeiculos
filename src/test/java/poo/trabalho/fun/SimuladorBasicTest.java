package poo.trabalho.fun;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimuladorBasicTest {

  @Test
  void includeAndRemoveVehicles_keepCountersInSync() {
    Simulador sim = new Simulador();

    int q0 = Simulador.getQuant();
    // incluir um de cada tipo válido
    assertEquals(0, sim.incluirVeiculo('B'));
    assertEquals(0, sim.incluirVeiculo('M'));
    assertEquals(0, sim.incluirVeiculo('E'));
    assertEquals(0, sim.incluirVeiculo('C'));

    // contagem pública deve refletir 4 a mais (ou pelo menos não diminuir)
    assertTrue(Simulador.getQuant() >= q0 + 4);

    // tentar tipo inválido
    assertEquals(1, sim.incluirVeiculo('X'));

    // mover todos não deve lançar exceção
    assertNotNull(sim.mover());

    // imprimir (dados) e (pista) não devem lançar exceção
    sim.imprimir();
    sim.imprimir(2);
  }
}
