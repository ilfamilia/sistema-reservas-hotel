package hotel.consola;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Clase de apoyo para leer datos desde consola de forma ordenada.
 */
public class EntradaConsola {

    private final Scanner scanner;

    /**
     * Constructor de la clase.
     */
    public EntradaConsola() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Lee un texto desde consola.
     *
     * @param mensaje mensaje a mostrar al usuario
     * @return texto ingresado
     */
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /**
     * Lee un número entero desde consola.
     *
     * @param mensaje mensaje a mostrar al usuario
     * @return número entero ingresado
     */
    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
            }
        }
    }

    /**
     * Lee una fecha desde consola en formato yyyy-MM-dd.
     *
     * @param mensaje mensaje a mostrar al usuario
     * @return fecha ingresada
     */
    public LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return LocalDate.parse(entrada);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Debe usar el formato yyyy-MM-dd.");
            }
        }
    }

    /**
     * Lee una opción de confirmación simple.
     *
     * @param mensaje mensaje a mostrar al usuario
     * @return true si la respuesta es s, false en caso contrario
     */
    public boolean leerConfirmacion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return true;
            }

            if (respuesta.equals("n")) {
                return false;
            }

            System.out.println("Entrada inválida. Responda con 's' o 'n'.");
        }
    }

    /**
     * Cierra el recurso de entrada.
     */
    public void cerrar() {
        scanner.close();
    }
}