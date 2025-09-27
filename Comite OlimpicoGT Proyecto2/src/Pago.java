public class Pago {
    private int idPago;
    private int idAtleta;
    private int mes; // 1-12
    private int anio;
    private double pagoBase;
    private double bonificacionExtranjero;
    private double bonificacionMejorMarca;
    private double totalPago;

    public Pago() {}

    public Pago(int idPago, int idAtleta, int mes, int anio, double pagoBase,
                double bonificacionExtranjero, double bonificacionMejorMarca) {
        this.idPago = idPago;
        this.idAtleta = idAtleta;
        this.mes = mes;
        this.anio = anio;
        this.pagoBase = pagoBase;
        this.bonificacionExtranjero = bonificacionExtranjero;
        this.bonificacionMejorMarca = bonificacionMejorMarca;
        this.totalPago = pagoBase + bonificacionExtranjero + bonificacionMejorMarca;
    }


    public int getIdPago() {
        return idPago; }

    public void setIdPago(int idPago) {
        this.idPago = idPago; }

    public int getIdAtleta() {
        return idAtleta; }

    public void setIdAtleta(int idAtleta) {
        this.idAtleta = idAtleta; }

    public int getMes() {
        return mes; }

    public void setMes(int mes) {
        this.mes = mes; }

    public int getAnio() {
        return anio; }

    public void setAnio(int anio) {
        this.anio = anio; }

    public double getPagoBase() {
        return pagoBase; }

    public void setPagoBase(double pagoBase) {
        this.pagoBase = pagoBase; }

    public double getBonificacionExtranjero() {
        return bonificacionExtranjero; }

    public void setBonificacionExtranjero(double bonificacionExtranjero) {
        this.bonificacionExtranjero = bonificacionExtranjero; }

    public double getBonificacionMejorMarca() {
        return bonificacionMejorMarca; }

    public void setBonificacionMejorMarca(double bonificacionMejorMarca) {
        this.bonificacionMejorMarca = bonificacionMejorMarca; }

    public double getTotalPago() {
        return totalPago; }

    public void calcularTotal() {
        this.totalPago = pagoBase + bonificacionExtranjero + bonificacionMejorMarca; }

    @Override
    public String toString() {
        return "\n" +
                "IdPago=" + idPago +
                ", IdAtleta=" + idAtleta +
                ", Mes=" + mes +
                ", Año=" + anio +
                ", PagoBase=" + pagoBase +
                ", BonificacionExtranjero=" + bonificacionExtranjero +
                ", BonificacionMejorMarca=" + bonificacionMejorMarca +
                ", TotalPago=" + totalPago +
                ' ';
    }
}
