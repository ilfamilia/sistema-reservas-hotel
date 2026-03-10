package hotel.consola;

import java.util.Scanner;

/**

 * Clase de utilidad para leer datos desde la consola.

 * Contiene métodos estáticos para leer texto y números.

 */

public class EntradaConsola {

    // Scanner único para toda la clase

    private static final Scanner scanner = new Scanner(System.in);

    /**

     * Lee un texto desde la consola.

     * @param mensaje Mensaje que se muestra al usuario

     * @return Texto ingresado por el usuario

     */

    public static String leerTexto(String mensaje) {

        System.out.print(mensaje + ": ");

        return scanner.nextLine();

    }

    /**

     * Lee un número entero desde la consola.

     * @param mensaje Mensaje que se muestra al usuario

     * @return Número entero ingresado por el usuario

     */

    public static int leerEntero(String mensaje) {

        System.out.print(mensaje + ": ");

        try {

            return Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Error: debe ingresar un número entero.");

            return leerEntero(mensaje); // vuelve a pedir si hay error

        }

    }

}
