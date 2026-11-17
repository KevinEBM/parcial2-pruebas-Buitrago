package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas del recargo nocturno")
class RecargoTest {

    @Test
    @DisplayName("R1 (borde): entrar a las 20 horas, inicio de la noche, suma 2000 de recargo")
    void entradaALas20QueEsElInicioDeLaNocheSumaRecargo() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 20);

        assertEquals(5000, resultado);
    }

    @Test
    @DisplayName("R2 (borde): entrar a las 19 horas, fin del día, no cambia la tarifa")
    void entradaALas19QueEsElFinDelDiaNoCambiaLaTarifa() {
        int resultado = Recargo.aplicarRecargoNocturno(3000, 19);

        assertEquals(3000, resultado);
    }

    @Test
    @DisplayName("R3: una tarifa de 0 de noche no tiene recargo")
    void tarifaCeroDeNocheNoTieneRecargo() {
        int resultado = Recargo.aplicarRecargoNocturno(0, 23);

        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("R4: una hora fuera de 0 a 23 lanza error")
    void horaFueraDeRangoLanzaError() {
        assertThrows(IllegalArgumentException.class,
                () -> Recargo.aplicarRecargoNocturno(3000, 24));
    }
}
