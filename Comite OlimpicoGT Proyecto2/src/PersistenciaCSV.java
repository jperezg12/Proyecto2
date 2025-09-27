import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersistenciaCSV {
    // Exportar reporte de entrenamientos a CSV
    public void exportarEntrenamientosCSV(List<Entrenamiento> entrenamientos, String ruta) throws IOException {
        try (FileWriter writer = new FileWriter(ruta)) {
            writer.append("id,fecha,tipo,valor,ubicacion,pais,idAtleta\n");
            for (Entrenamiento e : entrenamientos) {
                writer.append(String.valueOf(e.getIdEntrenamiento())).append(",");
                writer.append(e.getFecha().toString()).append(",");
                writer.append(escape(e.getTipo())).append(",");
                writer.append(String.valueOf(e.getValorRendimiento())).append(",");
                writer.append(escape(e.getUbicacion())).append(",");
                writer.append(escape(e.getPais() == null ? "" : e.getPais())).append(",");
                writer.append(String.valueOf(e.getIdAtleta())).append("\n");
            }
        }
    }

    public void exportarAtletasCSV(List<Atleta> atletas, String ruta) throws IOException {
        try (FileWriter writer = new FileWriter(ruta)) {
            writer.append("id,nombre,edad,disciplina,departamento,nacionalidad,fechaIngreso\n");
            for (Atleta a : atletas) {
                writer.append(String.valueOf(a.getIdAtleta())).append(",");
                writer.append(escape(a.getNombreCompleto())).append(",");
                writer.append(String.valueOf(a.getEdad())).append(",");
                writer.append(escape(a.getDisciplina())).append(",");
                writer.append(escape(a.getDepartamento())).append(",");
                writer.append(escape(a.getNacionalidad())).append(",");
                writer.append(a.getFechaIngreso() == null ? "" : a.getFechaIngreso().toString()).append("\n");
            }
        }
    }

    private String escape(String s) {
        if (s == null) return "";
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}
