package poo.trabalho.fun;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MotorVehicleMoveTest {

    @Test
    void doesNotMoveWithFlatTire_orWithoutFuel() {
        // Pelo build, há CarroPasseio, Esportivo e Motocicleta.
        CarroPasseio car = new CarroPasseio(123); // se o ctor for diferente, ajuste após rodar o teste

        // 1) Com pneu(s) vazio(s) -> não anda
        try {
            // alguns projetos têm algo como calibrarTodosPneus(false) ou setCalibragem(false) em cascata
            car.calibrarTodosPneus(false); // se não existir, comentaremos após o 1º run
        } catch (Throwable t) {
            // ex.: car.setCalibragemRoda(0, false);
        }

        double before = car.getDistanciaPercorrida(); // se o getter tiver outro nome, ajusto no próximo passo
        car.mover();
        assertEquals(before, car.getDistanciaPercorrida(), 0.0001,
            "Should not move with any flat tire");

        // 2) Pneus calibrados, porém sem combustível -> não anda
        try {
            car.calibrarTodosPneus(true);
        } catch (Throwable t) {
            // fallback se necessário
        }

        // zera combustível:
        try {
            car.abastecer(-9999); 
        } catch (Throwable t) {
            // fallback se necessário
        }

        before = car.getDistanciaPercorrida();
        car.mover();
        assertEquals(before, car.getDistanciaPercorrida(), 0.0001,
            "Should not move without fuel");
    }
}
