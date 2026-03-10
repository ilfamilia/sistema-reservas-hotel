package hotel.consola;

import hotel.modelo.Cliente;
import hotel.modelo.Habitacion;
import hotel.modelo.Reserva;
import hotel.servicio.ServicioDisponibilidad;
import hotel.servicio.ServicioReserva;

import java.time.LocalDate;
import java.util.List;

/**
 * Menú principal del sistema.
 *
 * Esta clase coordina la interacción con el usuario desde consola.
 */
public class MenuPrincipal {

    private final ServicioReserva servicioReserva;
    private final ServicioDisponibilidad servicioDisponibilidad;
    private final EntradaConsola entradaConsola;
    private boolean ejecutando;

    /**
     * Constructor del menú principal.
     *
     * @param servicioReserva servicio de reservas
     * @param servicioDisponibilidad servicio de disponibilidad
     */
    public MenuPrincipal(ServicioReserva servicioReserva, ServicioDisponibilidad servicioDisponibilidad) {
        this.servicioReserva = servicioReserva;
        this.servicioDisponibilidad = servicioDisponibilidad;
        this.entradaConsola = new EntradaConsola();
        this.ejecutando = true;
    }

    /**
     * Inicia la ejecución del menú.
     */
    public void iniciar() {
        while (ejecutando) {
            mostrarMenu();
            int opcion = entradaConsola.leerEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
            System.out.println();
        }

        entradaConsola.cerrar();
    }

    /**
     * Muestra las opciones disponibles del sistema.
     */
    private void mostrarMenu() {
        System.out.println("==============================================");
        System.out.println(" SISTEMA DE RESERVACIÓN DE HABITACIONES");
        System.out.println("==============================================");
        System.out.println("1. Mostrar habitaciones existentes");
        System.out.println("2. Verificar disponibilidad de una habitación");
        System.out.println("3. Crear reserva");
        System.out.println("4. Listar reservas");
        System.out.println("0. Salir");
        System.out.println("==============================================");
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     *
     * @param opcion opción elegida
     */
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarHabitaciones();
                break;
            case 2:
                verificarDisponibilidad();
                break;
            case 3:
                crearReserva();
                break;
            case 4:
                listarReservas();
                break;
            case 0:
                salir();
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    /**
     * Muestra las habitaciones registradas en el sistema.
     */
    private void mostrarHabitaciones() {
        List<Habitacion> habitaciones = servicioDisponibilidad.obtenerHabitaciones();

        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return;
        }

        System.out.println("Habitaciones existentes:");
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    /**
     * Permite verificar la disponibilidad de una habitación.
     */
    private void verificarDisponibilidad() {
        int numeroHabitacion = entradaConsola.leerEntero("Ingrese el número de la habitación: ");
        LocalDate fechaEntrada = entradaConsola.leerFecha("Ingrese la fecha de entrada (yyyy-MM-dd): ");
        LocalDate fechaSalida = entradaConsola.leerFecha("Ingrese la fecha de salida (yyyy-MM-dd): ");

        if (!fechaSalida.isAfter(fechaEntrada)) {
            System.out.println("La fecha de salida debe ser posterior a la fecha de entrada.");
            return;
        }

        if (!servicioDisponibilidad.existeHabitacion(numeroHabitacion)) {
            System.out.println("La habitación indicada no existe.");
            return;
        }

        boolean disponible = servicioDisponibilidad.estaDisponible(numeroHabitacion, fechaEntrada, fechaSalida);

        if (disponible) {
            System.out.println("La habitación está disponible en el rango solicitado.");
        } else {
            System.out.println("La habitación no está disponible en el rango solicitado.");
        }
    }

    /**
     * Permite crear una nueva reserva.
     */
    private void crearReserva() {
        try {
            int idReserva = entradaConsola.leerEntero("Ingrese el id de la reserva: ");
            int idCliente = entradaConsola.leerEntero("Ingrese el id del cliente: ");
            String nombreCliente = entradaConsola.leerTexto("Ingrese el nombre del cliente: ");
            String documentoCliente = entradaConsola.leerTexto("Ingrese el documento del cliente: ");
            String telefonoCliente = entradaConsola.leerTexto("Ingrese el teléfono del cliente: ");
            int numeroHabitacion = entradaConsola.leerEntero("Ingrese el número de la habitación: ");
            LocalDate fechaEntrada = entradaConsola.leerFecha("Ingrese la fecha de entrada (yyyy-MM-dd): ");
            LocalDate fechaSalida = entradaConsola.leerFecha("Ingrese la fecha de salida (yyyy-MM-dd): ");

            Cliente cliente = new Cliente(idCliente, nombreCliente, documentoCliente, telefonoCliente);

            Reserva reserva = servicioReserva.crearReserva(
                    idReserva,
                    cliente,
                    numeroHabitacion,
                    fechaEntrada,
                    fechaSalida
            );

            System.out.println("Reserva creada correctamente.");
            System.out.println(reserva);
        } catch (IllegalArgumentException e) {
            System.out.println("No fue posible crear la reserva: " + e.getMessage());
        }
    }

    /**
     * Muestra todas las reservas registradas.
     */
    private void listarReservas() {
        List<Reserva> reservas = servicioReserva.obtenerReservas();

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        System.out.println("Reservas registradas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    /**
     * Finaliza la ejecución del sistema.
     */
    private void salir() {
        System.out.println("Gracias por utilizar el sistema.");
        ejecutando = false;
    }
}