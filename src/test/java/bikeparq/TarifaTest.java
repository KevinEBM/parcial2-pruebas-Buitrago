package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TarifaTest {

    // PUNTO 1: escriba aquí las pruebas CP-01, CP-02 y CP-03 del enunciado.

    @Test
    void cp01CarroQuePermaneceSesentaMinutosPagaTresMil() {
        int minutos = 60;
        String tipo = "carro";

        int resultado = Tarifa.calcularTarifa(minutos, tipo);

        assertEquals(3000, resultado);
    }

    @Test
    void cp02MotoQuePermaneceDiezMinutosNoPagaPorTiempoDeGracia() {
        int minutos = 10;
        String tipo = "moto";

        int resultado = Tarifa.calcularTarifa(minutos, tipo);

        assertEquals(0, resultado);
    }

    @Test
    void cp03BicicletaNoEsUnTipoValidoYLanzaError() {
        int minutos = 60;
        String tipo = "bicicleta";

        assertThrows(IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(minutos, tipo));
    }
}
