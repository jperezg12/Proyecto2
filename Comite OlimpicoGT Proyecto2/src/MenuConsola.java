import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuConsola {
    private GestorAtletas gestorAtletas = new GestorAtletas();
    private GestorEntrenamientos gestorEntrenamientos = new GestorEntrenamientos();
    private GestorFinanciero gestorFinanciero = new GestorFinanciero();
    private PersistenciaJSON persistenciaJSON = new PersistenciaJSON();
    private PersistenciaCSV persistenciaCSV = new PersistenciaCSV();


    private Scanner scanner = new Scanner(System.in);

    public MenuConsola() {}



    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Comité Olímpico Guatemalteco ---");
            System.out.println("1) Registrar Atleta");
            System.out.println("2) Registrar Entrenamiento");
            System.out.println("3) Mostrar Estadísticas de Atleta");
            System.out.println("4) Generar Reporte CSV");
            System.out.println("5) Guardar Reporte JSON");
            System.out.println("6) Pago Planilla");
            System.out.println("0) Salir");
            System.out.print("Seleccione opción: ");
            String opt = scanner.nextLine();
            try {
                switch (opt) {
                    case "1": opcionRegistrarAtleta(); break;
                    case "2": opcionRegistrarEntrenamiento(); break;
                    case "3": opcionMostrarEstadisticas(); break;
                    case "4": opcionGenerarCSV(); break;
                    case "5": opcionGuardarCargarJSON(); break;
                    case "6": opcionProcesarPago(); break;
                    case "0": System.out.println("Adiós!"); return;
                    default: System.out.println("Opción inválida.");
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private void opcionRegistrarAtleta() {
        System.out.println("Registro de Atleta:");
        System.out.print("Nombre completo: "); String nombre = scanner.nextLine();
        System.out.print("Edad: "); int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Disciplina: "); String disciplina = scanner.nextLine();
        System.out.print("Departamento: "); String departamento = scanner.nextLine();
        System.out.print("Nacionalidad: "); String nacionalidad = scanner.nextLine();
        System.out.print("Fecha ingreso (YYYY-MM-DD): "); LocalDate fecha = LocalDate.parse(scanner.nextLine());
        Atleta a = gestorAtletas.registrarAtleta(nombre, edad, disciplina, departamento, nacionalidad, fecha);
        System.out.println("Atleta Registrado con Exito " );
    }

    private void opcionRegistrarEntrenamiento() {
        System.out.println("Registro de Entrenamiento:");
        System.out.print("ID atleta: "); int idAtleta = Integer.parseInt(scanner.nextLine());
        Atleta atleta = gestorAtletas.buscarPorId(idAtleta).orElse(null);
        if (atleta == null) { System.out.println("Atleta no encontrado."); return; }
        System.out.print("Fecha (YYYY-MM-DD): "); LocalDate fecha = LocalDate.parse(scanner.nextLine());
        System.out.print("Tipo: "); String tipo = scanner.nextLine();
        System.out.print("Valor Rendimiento: "); double valor = Double.parseDouble(scanner.nextLine());
        System.out.print("Ubicacion (Nacional/Internacional): "); String ubicacion = scanner.nextLine();
        String pais = "";
        if ("Internacional".equalsIgnoreCase(ubicacion)) {
            System.out.print("Pais: "); pais = scanner.nextLine();
        }
        Entrenamiento e = gestorEntrenamientos.registrarEntrenamiento(fecha, tipo, valor, ubicacion, pais, idAtleta);
        atleta.agregarEntrenamiento(e);
        System.out.println("Entrenamiento Registrado con Exito");
    }

    private void opcionMostrarEstadisticas() {
        System.out.print("ID atleta: "); int id = Integer.parseInt(scanner.nextLine());
        Atleta atleta = gestorAtletas.buscarPorId(id).orElse(null);
        if (atleta == null) { System.out.println("Atleta no encontrado."); return; }
        List<Entrenamiento> entrenamientos = gestorEntrenamientos.obtenerPorAtleta(id);
        Estadisticas est = new Estadisticas(id);
        est.calcular(entrenamientos);
        System.out.println("Atleta: " + atleta.getNombreCompleto());
        System.out.println("Promedio: " + est.getPromedioRendimiento());
        System.out.println("Mejor marca: " + est.getMejorMarca());
        System.out.println("Promedio Nacional: " + est.getPromedioNacional());
        System.out.println("Promedio Internacional: " + est.getPromedioInternacional());
        System.out.println("Historial ordenado:");
        est.getHistorialOrdenado().forEach(System.out::println);
    }

    private void opcionGenerarCSV() throws Exception {
        System.out.print("Ruta para guardar entrenamientos CSV: "); String rutaE = scanner.nextLine();
        persistenciaCSV.exportarEntrenamientosCSV(gestorEntrenamientos.getListaEntrenamientos(), rutaE);
        System.out.print("Ruta para guardar atletas CSV: "); String rutaA = scanner.nextLine();
        persistenciaCSV.exportarAtletasCSV(gestorAtletas.getListaAtletas(), rutaA);
        System.out.println("CSV generados.");
    }

    private void opcionGuardarCargarJSON() throws Exception {
            System.out.print("Ruta Entrenamientos JSON: "); String rE = scanner.nextLine();
            persistenciaJSON.guardarEntrenamientos(gestorEntrenamientos.getListaEntrenamientos(), rE);
            System.out.println("Guardado en JSON.");
    }

    private void opcionProcesarPago() {
        System.out.print("ID atleta: "); int id = Integer.parseInt(scanner.nextLine());
        Atleta atleta = gestorAtletas.buscarPorId(id).orElse(null);
        if (atleta == null) { System.out.println("Atleta no encontrado."); return; }
        System.out.print("Mes: "); int mes = Integer.parseInt(scanner.nextLine());
        System.out.print("Año: "); int anio = Integer.parseInt(scanner.nextLine());
        List<Entrenamiento> delMes = atleta.getListaEntrenamientos().stream()
                .filter(e -> e.getFecha().getMonthValue() == mes && e.getFecha().getYear() == anio)
                .toList();
        Pago pago = gestorFinanciero.procesarPago(atleta, delMes);
        System.out.println("Pago Procesado: " + pago);
    }
}
