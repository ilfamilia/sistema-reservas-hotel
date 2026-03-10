package hotel;

import hotel.consola.MenuPrincipal;
import hotel.servicio.ServicioReserva;
import hotel.servicio.ServicioDisponibilidad;
import hotel.repositorio.memoria.RepositorioHabitacionEnMemoria;
import hotel.repositorio.memoria.RepositorioReservaEnMemoria;

public class Main {
    public static void main(String[] args) {
        // Repositorios en memoria (ejemplo)
        RepositorioHabitacionEnMemoria repoHabitacion = new RepositorioHabitacionEnMemoria();
        RepositorioReservaEnMemoria repoReserva = new RepositorioReservaEnMemoria();

        ServicioDisponibilidad servicioDisponibilidad = new ServicioDisponibilidad(repoHabitacion, repoReserva);
        ServicioReserva servicioReserva = new ServicioReserva(repoReserva, repoHabitacion, servicioDisponibilidad);

        MenuPrincipal menu = new MenuPrincipal(servicioReserva, servicioDisponibilidad);
        menu.mostrar();
    }
}