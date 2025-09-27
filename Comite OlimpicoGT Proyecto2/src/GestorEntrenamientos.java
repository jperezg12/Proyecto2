import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorEntrenamientos {
    private List<Entrenamiento> listaEntrenamientos = new ArrayList<>();
    private int siguienteId = 1;

    public Entrenamiento registrarEntrenamiento(java.time.LocalDate fecha, String tipo, double valor,
                                                String ubicacion, String pais, int idAtleta) {
        Entrenamiento e = new Entrenamiento(siguienteId++, fecha, tipo, valor, ubicacion, pais, idAtleta);
        listaEntrenamientos.add(e);
        return e;
    }

    public List<Entrenamiento> obtenerPorAtleta(int idAtleta) {
        return listaEntrenamientos.stream()
                .filter(e -> e.getIdAtleta() == idAtleta)
                .collect(Collectors.toList());
    }

    public List<Entrenamiento> filtrarPorUbicacion(int idAtleta, String ubicacion) {
        return listaEntrenamientos.stream()
                .filter(e -> e.getIdAtleta() == idAtleta && ubicacion.equalsIgnoreCase(e.getUbicacion()))
                .collect(Collectors.toList());
    }

    public Optional<Entrenamiento> buscarPorId(int id) {
        return listaEntrenamientos.stream().filter(e -> e.getIdEntrenamiento() == id).findFirst();
    }

    public void setListaEntrenamientos(List<Entrenamiento> lista) {
        this.listaEntrenamientos = lista;
        int max = lista.stream().mapToInt(Entrenamiento::getIdEntrenamiento).max().orElse(0);
        this.siguienteId = max + 1;
    }

    public List<Entrenamiento> getListaEntrenamientos() { return listaEntrenamientos; }
}
