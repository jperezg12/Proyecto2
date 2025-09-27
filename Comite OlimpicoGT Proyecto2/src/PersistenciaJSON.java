import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaJSON implements IPersistencia {
    private Gson gson;

    public PersistenciaJSON() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void guardarAtletas(List<Atleta> atletas, String ruta) throws IOException {
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(atletas, writer);
        }
    }

    @Override
    public List<Atleta> cargarAtletas(String ruta) throws IOException {
        try (Reader reader = new FileReader(ruta)) {
            Type tipo = new TypeToken<List<Atleta>>() {}.getType();
            return gson.fromJson(reader, tipo);
        }
    }

    @Override
    public void guardarEntrenamientos(List<Entrenamiento> entrenamientos, String ruta) throws IOException {
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(entrenamientos, writer);
        }
    }

    @Override
    public List<Entrenamiento> cargarEntrenamientos(String ruta) throws IOException {
        try (Reader reader = new FileReader(ruta)) {
            Type tipo = new TypeToken<List<Entrenamiento>>() {}.getType();
            return gson.fromJson(reader, tipo);
        }
    }
}
