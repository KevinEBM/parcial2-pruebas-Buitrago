package bikeparq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas de la tarifa del parqueadero")
class TarifaTest {

    // PUNTO 1: escriba aquí las pruebas CP-01, CP-02 y CP-03 del enunciado.

    @Test
    @DisplayName("CP-01: un carro que permanece 60 minutos paga 3000 pesos")
    void cp01CarroQuePermaneceSesentaMinutosPagaTresMil() {
        int minutos = 60;
        String tipo = "carro";

        int resultado = Tarifa.calcularTarifa(minutos, tipo);

        assertEquals(3000, resultado);
    }

    @Test
    @DisplayName("CP-02: una moto que permanece 10 minutos no paga por el tiempo de gracia")
    void cp02MotoQuePermaneceDiezMinutosNoPagaPorTiempoDeGracia() {
        int minutos = 10;
        String tipo = "moto";

        int resultado = Tarifa.calcularTarifa(minutos, tipo);

        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("CP-03: una bicicleta no es un tipo válido y lanza error")
    void cp03BicicletaNoEsUnTipoValidoYLanzaError() {
        int minutos = 60;
        String tipo = "bicicleta";

        assertThrows(IllegalArgumentException.class,
                () -> Tarifa.calcularTarifa(minutos, tipo));
    }
}
