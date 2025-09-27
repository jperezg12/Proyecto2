import java.util.ArrayList;
import java.util.List;

public class GestorFinanciero {
    private List<Pago> listaPagos = new ArrayList<>();
    private int siguienteIdPago = 1;


    private double pagoBasePorAtleta = 3000.0;
    private double bonoPorEntrenamiento = 50.0;
    private double bonoExtranjeroPorEntrenamiento = 60.0;
    private double bonoSuperarMejorMarca = 100.0;

    public Pago procesarPago(Atleta atleta, List<Entrenamiento> entrenamientosDelMes) {
        int mes = entrenamientosDelMes.isEmpty() ? java.time.LocalDate.now().getMonthValue() :
                entrenamientosDelMes.get(0).getFecha().getMonthValue();
        int anio = entrenamientosDelMes.isEmpty() ? java.time.LocalDate.now().getYear() :
                entrenamientosDelMes.get(0).getFecha().getYear();

        double pagoBase = pagoBasePorAtleta;
        double bonificacionEntrenamientos = entrenamientosDelMes.size() * bonoPorEntrenamiento;
        long countExtranjero = entrenamientosDelMes.stream()
                .filter(e -> "Internacional".equalsIgnoreCase(e.getUbicacion())).count();
        double bonificacionExtranjero = countExtranjero * bonoExtranjeroPorEntrenamiento;


        double mejorHistorico = atleta.getListaEntrenamientos().stream()
                .mapToDouble(Entrenamiento::getValorRendimiento).max().orElse(Double.MIN_VALUE);
        double mejorEnMes = entrenamientosDelMes.stream()
                .mapToDouble(Entrenamiento::getValorRendimiento).max().orElse(Double.MIN_VALUE);

        double bonificacionMejorMarca = 0;
        if (mejorEnMes > mejorHistorico && mejorHistorico != Double.MIN_VALUE) {
            bonificacionMejorMarca = bonoSuperarMejorMarca;
        }

        double total = pagoBase + bonificacionEntrenamientos + bonificacionExtranjero + bonificacionMejorMarca;
        Pago pago = new Pago(siguienteIdPago++, atleta.getIdAtleta(), mes, anio, pagoBase, bonificacionExtranjero, bonificacionMejorMarca);

        pago.setPagoBase(pagoBase + bonificacionEntrenamientos);
        pago.calcularTotal();
        listaPagos.add(pago);
        return pago;
    }

    public List<Pago> getListaPagos() { return listaPagos; }
}
