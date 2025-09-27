import java.time.LocalDate;

public class Entrenamiento {
    private int idEntrenamiento;
    private LocalDate fecha;
    private String tipo; // Tiempo, Velocidad, Distancia
    private double valorRendimiento;
    private String ubicacion; // Nacional / Internacional
    private String pais; // si es internacional
    private int idAtleta;

    public Entrenamiento() {}

    public Entrenamiento(int idEntrenamiento, LocalDate fecha, String tipo, double valorRendimiento,
                         String ubicacion, String pais, int idAtleta) {
        this.idEntrenamiento = idEntrenamiento;
        this.fecha = fecha;
        this.tipo = tipo;
        this.valorRendimiento = valorRendimiento;
        this.ubicacion = ubicacion;
        this.pais = pais;
        this.idAtleta = idAtleta;
    }


    public int getIdEntrenamiento() {
        return idEntrenamiento; }

    public void setIdEntrenamiento(int idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento; }

    public LocalDate getFecha() {
        return fecha; }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha; }

    public String getTipo() {
        return tipo; }

    public void setTipo(String tipo) {
        this.tipo = tipo; }

    public double getValorRendimiento() {
        return valorRendimiento; }

    public void setValorRendimiento(double valorRendimiento) {
        this.valorRendimiento = valorRendimiento; }

    public String getUbicacion() {
        return ubicacion; }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion; }

    public String getPais() {
        return pais; }

    public void setPais(String pais) {
        this.pais = pais; }

    public int getIdAtleta() {
        return idAtleta; }

    public void setIdAtleta(int idAtleta) {
        this.idAtleta = idAtleta; }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id=" + idEntrenamiento +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valorRendimiento +
                ", ubicacion='" + ubicacion + '\'' +
                (pais != null && !pais.isEmpty() ? ", pais='" + pais + '\'' : "") +
                ", idAtleta=" + idAtleta +
                '}';
    }
}
