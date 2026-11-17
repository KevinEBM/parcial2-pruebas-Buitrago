package bikeparq;

public class Recargo {

    public static int aplicarRecargoNocturno(int tarifa, int horaEntrada) {
        if (horaEntrada < 0 || horaEntrada > 23) {
            throw new IllegalArgumentException("Hora no valida");
        }
        if (tarifa == 0) {
            return 0;
        }
        if (horaEntrada >= 20 || horaEntrada <= 5) {
            return tarifa + 2000;
        }
        return tarifa;
    }
}
