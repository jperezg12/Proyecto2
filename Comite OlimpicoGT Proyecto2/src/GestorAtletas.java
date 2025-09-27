import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorAtletas {
    private List<Atleta> listaAtletas = new ArrayList<>();
    private int siguienteId = 1;

    public Atleta registrarAtleta(String nombreCompleto, int edad, String disciplina,
                                  String departamento, String nacionalidad, java.time.LocalDate fechaIngreso) {
        Atleta a = new Atleta(siguienteId++, nombreCompleto, edad, disciplina, departamento, nacionalidad, fechaIngreso);
        listaAtletas.add(a);
        return a;
    }

    public Optional<Atleta> buscarPorId(int id) {
        return listaAtletas.stream().filter(a -> a.getIdAtleta() == id).findFirst();
    }

    public List<Atleta> buscarPorNombre(String nombre) {
        String lower = nombre.toLowerCase();
        return listaAtletas.stream()
                .filter(a -> a.getNombreCompleto().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    public boolean eliminarAtleta(int id) {
        return listaAtletas.removeIf(a -> a.getIdAtleta() == id);
    }

    public List<Atleta> getListaAtletas() { return listaAtletas; }

    public void setListaAtletas(List<Atleta> atletas) {
        this.listaAtletas = atletas;
        // ajustar siguienteId
        int max = atletas.stream().mapToInt(Atleta::getIdAtleta).max().orElse(0);
        this.siguienteId = max + 1;
    }
}
