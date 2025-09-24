package poo.trabalho.fun;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.Test;

public class SimuladorPersistenceTest {

    @Test
    void saveAndLoad_roundTrip_keepsVehicleCount() throws Exception {
        Simulador sim = new Simulador();

        // inclui alguns veículos (qualquer tipo)
        assertEquals(0, sim.incluirVeiculo('B'));
        assertEquals(0, sim.incluirVeiculo('M'));
        assertEquals(0, sim.incluirVeiculo('C'));

        // arquivo temporário (não usa a pasta saves/)
        File tmp = File.createTempFile("simulador", ".dat");
        tmp.deleteOnExit();

        // salvar e ler em outro objeto
        sim.salvarEmArquivo(tmp);

        Simulador sim2 = new Simulador();
        sim2.lerDeArquivo(tmp);

        // verifica quantidade após leitura
        assertEquals(Simulador.getQuant(), sim2.contaVeiculos(),
            "Quantidade lida deve bater com a salva");

        // sanity: mover() não deve lançar
        assertNotNull(sim2.mover());
    }
}
