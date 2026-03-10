package hotel.consola;

import hotel.modelo.Cliente;
import hotel.modelo.Habitacion;
import hotel.modelo.Reserva;
import hotel.modelo.TipoHabitacion;
import hotel.servicio.ServicioReserva;
import hotel.servicio.ServicioDisponibilidad;

import java.time.LocalDate;

public class MenuPrincipal {

    private final ServicioReserva servicioReserva;
    private final ServicioDisponibilidad servicioDisponibilidad;

    public MenuPrincipal(ServicioReserva servicioReserva, ServicioDisponibilidad servicioDisponibilidad) {
        this.servicioReserva = servicioReserva;
        this.servicioDisponibilidad = servicioDisponibilidad;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n=== Sistema de Reservación de Hotel ===");
            System.out.println("1. Listar habitaciones (ejemplo)");
            System.out.println("2. Crear reserva");
            System.out.println("3. Ver disponibilidad");
            System.out.println("0. Salir");

            opcion = EntradaConsola.leerEntero("Seleccione una opción");

            switch (opcion) {
                case 1:
                    // Aquí deberías llamar al repositorio de habitaciones
                    System.out.println("Habitación 101 - INDIVIDUAL - Disponible");
                    System.out.println("Habitación 102 - DOBLE - Ocupada");
                    break;
                case 2:
                    crearReserva();
                    break;
                case 3:
                    verificarDisponibilidad();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearReserva() {
        int numero = EntradaConsola.leerEntero("Número de habitación");
        String nombre = EntradaConsola.leerTexto("Nombre del cliente");
        String documento = EntradaConsola.leerTexto("Documento del cliente");
        String telefono = EntradaConsola.leerTexto("Teléfono del cliente");

        LocalDate entrada = LocalDate.parse(EntradaConsola.leerTexto("Fecha de entrada (YYYY-MM-DD)"));
        LocalDate salida = LocalDate.parse(EntradaConsola.leerTexto("Fecha de salida (YYYY-MM-DD)"));

        Cliente cliente = new Cliente(1, nombre, documento, telefono);
        Habitacion habitacion = new Habitacion(numero, TipoHabitacion.INDIVIDUAL, "Disponible");
        Reserva reserva = new Reserva(1, cliente, habitacion, entrada, salida);

        try {
            Reserva creada = servicioReserva.crearReserva(reserva);
            System.out.println("Reserva creada: " + creada);
        } catch (Exception e) {
            System.out.println("Error al crear reserva: " + e.getMessage());
        }
    }

    private void verificarDisponibilidad() {
        int numero = EntradaConsola.leerEntero("Número de habitación");
        LocalDate entrada = LocalDate.parse(EntradaConsola.leerTexto("Fecha de entrada (YYYY-MM-DD)"));
        LocalDate salida = LocalDate.parse(EntradaConsola.leerTexto("Fecha de salida (YYYY-MM-DD)"));

        try {
            boolean disponible = servicioDisponibilidad.estaDisponible(numero, entrada, salida);
            System.out.println("¿Disponible? " + disponible);
        } catch (Exception e) {
            System.out.println("Error al verificar disponibilidad: " + e.getMessage());
        }
    }
}