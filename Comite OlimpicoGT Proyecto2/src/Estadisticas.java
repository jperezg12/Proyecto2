import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Estadisticas {
    private int idAtleta;
    private double promedioRendimiento;
    private double mejorMarca;
    private List<Entrenamiento> historialOrdenado = new ArrayList<>();
    private double promedioNacional;
    private double promedioInternacional;

    public Estadisticas() {}

    public Estadisticas(int idAtleta) {
        this.idAtleta = idAtleta;
    }

    public void calcular(List<Entrenamiento> entrenamientos) {
        if (entrenamientos == null || entrenamientos.isEmpty()) {
            promedioRendimiento = 0;
            mejorMarca = 0;
            historialOrdenado.clear();
            promedioNacional = 0;
            promedioInternacional = 0;
            return;
        }
        historialOrdenado = entrenamientos.stream()
                .sorted(Comparator.comparing(Entrenamiento::getFecha))
                .collect(Collectors.toList());

        promedioRendimiento = historialOrdenado.stream()
                .mapToDouble(Entrenamiento::getValorRendimiento)
                .average().orElse(0);

        mejorMarca = historialOrdenado.stream()
                .mapToDouble(Entrenamiento::getValorRendimiento)
                .max().orElse(0);

        List<Entrenamiento> nacionales = historialOrdenado.stream()
                .filter(e -> "Nacional".equalsIgnoreCase(e.getUbicacion()))
                .collect(Collectors.toList());
        List<Entrenamiento> internacionales = historialOrdenado.stream()
                .filter(e -> "Internacional".equalsIgnoreCase(e.getUbicacion()))
                .collect(Collectors.toList());

        promedioNacional = nacionales.stream()
                .mapToDouble(Entrenamiento::getValorRendimiento).average().orElse(0);
        promedioInternacional = internacionales.stream()
                .mapToDouble(Entrenamiento::getValorRendimiento).average().orElse(0);
    }

    // getters
    public double getPromedioRendimiento() { return promedioRendimiento; }
    public double getMejorMarca() { return mejorMarca; }
    public List<Entrenamiento> getHistorialOrdenado() { return historialOrdenado; }
    public double getPromedioNacional() { return promedioNacional; }
    public double getPromedioInternacional() { return promedioInternacional; }
}
