package hotel;

import hotel.consola.MenuPrincipal;
import hotel.repositorio.RepositorioHabitacion;
import hotel.repositorio.RepositorioReserva;
import hotel.repositorio.memoria.RepositorioHabitacionEnMemoria;
import hotel.repositorio.memoria.RepositorioReservaEnMemoria;
import hotel.servicio.ServicioDisponibilidad;
import hotel.servicio.ServicioReserva;

/**
 * Punto de entrada del sistema.
 *
 * Esta clase se encarga de inicializar las dependencias principales
 * y arrancar el menú de consola.
 */
public class Main {

    /**
     * Método principal de ejecución.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        RepositorioHabitacion repositorioHabitacion = new RepositorioHabitacionEnMemoria();
        RepositorioReserva repositorioReserva = new RepositorioReservaEnMemoria();

        ServicioDisponibilidad servicioDisponibilidad =
                new ServicioDisponibilidad(repositorioHabitacion, repositorioReserva);

        ServicioReserva servicioReserva =
                new ServicioReserva(repositorioHabitacion, repositorioReserva, servicioDisponibilidad);

        MenuPrincipal menuPrincipal = new MenuPrincipal(servicioReserva, servicioDisponibilidad);
        menuPrincipal.iniciar();
    }
}