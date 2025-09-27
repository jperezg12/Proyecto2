import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Atleta {
    private int idAtleta;
    private String nombreCompleto;
    private int edad;
    private String disciplina;
    private String departamento;
    private String nacionalidad;
    private LocalDate fechaIngreso;
    private List<Entrenamiento> listaEntrenamientos = new ArrayList<>();

    public Atleta() {}

    public Atleta(int idAtleta, String nombreCompleto, int edad, String disciplina,
                  String departamento, String nacionalidad, LocalDate fechaIngreso) {
        this.idAtleta = idAtleta;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.disciplina = disciplina;
        this.departamento = departamento;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
    }


    public int getIdAtleta() {
        return idAtleta; }

    public void setIdAtleta(int idAtleta) {
        this.idAtleta = idAtleta; }

    public String getNombreCompleto() {
        return nombreCompleto; }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto; }

    public int getEdad() {
        return edad; }

    public void setEdad(int edad) {
        this.edad = edad; }

    public String getDisciplina() {
        return disciplina; }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina; }

    public String getDepartamento() {
        return departamento; }

    public void setDepartamento(String departamento) {
        this.departamento = departamento; }

    public String getNacionalidad() {
        return nacionalidad; }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad; }

    public LocalDate getFechaIngreso() {
        return fechaIngreso; }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso; }

    public List<Entrenamiento> getListaEntrenamientos() {
        return listaEntrenamientos; }

    public void agregarEntrenamiento(Entrenamiento e) {
        listaEntrenamientos.add(e);
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "idAtleta=" + idAtleta +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", disciplina='" + disciplina + '\'' +
                ", departamento='" + departamento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", entrenamientos=" + listaEntrenamientos.size() +
                '}';
    }
}
