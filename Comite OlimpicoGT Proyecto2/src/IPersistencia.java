import java.util.List;

public interface IPersistencia {
    void guardarAtletas(List<Atleta> atletas, String ruta) throws Exception;
    List<Atleta> cargarAtletas(String ruta) throws Exception;

    void guardarEntrenamientos(List<Entrenamiento> entrenamientos, String ruta) throws Exception;
    List<Entrenamiento> cargarEntrenamientos(String ruta) throws Exception;
}
