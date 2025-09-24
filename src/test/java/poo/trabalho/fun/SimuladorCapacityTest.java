package poo.trabalho.fun;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimuladorCapacityTest {

  @Test
  void cannotExceedTwentyVehicles() {
    Simulador sim = new Simulador();

    int ok = 0;
    for (int i = 0; i < 25; i++) {
      int r = sim.incluirVeiculo('B'); // qualquer tipo serve
      if (r == 0) ok++;
      else {
        // quando exceder, deve retornar 2 (capacidade cheia)
        assertEquals(2, r);
        break;
      }
    }
    assertTrue(ok <= 20, "Não pode passar de 20 veículos");
  }
}
