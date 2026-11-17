package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RecargoTest {

    @Test
    void entradaALas22SumaRecargoNocturno() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 22);

        assertEquals(5000, resultado);
    }

    @Test
    void entradaALas20QueEsElInicioDeLaNocheSumaRecargo() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 20);

        assertEquals(5000, resultado);
    }

    @Test
    void entradaALas5QueEsElFinDeLaNocheSumaRecargo() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 5);

        assertEquals(5000, resultado);
    }

    @Test
    void entradaALas10DeDiaNoCambiaLaTarifa() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 10);

        assertEquals(3000, resultado);
    }

    @Test
    void entradaALas19QueEsElFinDelDiaNoCambiaLaTarifa() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 19);

        assertEquals(3000, resultado);
    }

    @Test
    void entradaALas6QueEsElInicioDelDiaNoCambiaLaTarifa() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 6);

        assertEquals(3000, resultado);
    }

    @Test
    void tarifaCeroDeNocheNoTieneRecargo() {
        int resultado = Recargo.aplicarRecargoNocturno(0, 23);

        assertEquals(0, resultado);
    }

    @Test
    void horaFueraDeRangoLanzaError() {
        assertThrows(IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, 24));
    }
}
