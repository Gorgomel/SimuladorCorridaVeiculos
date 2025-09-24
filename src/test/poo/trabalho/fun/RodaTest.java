package poo.trabalho.fun;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RodaTest {

    @Test
    void setCalibragem_respectsSemantics() {
        Roda wheel = new Roda();
        boolean initial = wheel.getCalibragem();

        // Ao setar o MESMO valor, deve indicar que NADA mudou (esperado: false)
        boolean changedSame = wheel.setCalibragem(initial);
        assertFalse(changedSame, "Setting same value should not report change");
        assertEquals(initial, wheel.getCalibragem(), "State should remain the same");

        // Ao setar valor DIFERENTE, deve indicar que mudou (esperado: true)
        boolean changedOther = wheel.setCalibragem(!initial);
        assertTrue(changedOther, "Setting different value should report change");
        assertEquals(!initial, wheel.getCalibragem(), "State should flip");
    }
}
