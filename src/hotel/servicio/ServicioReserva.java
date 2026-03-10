package hotel.servicio;

import hotel.modelo.Cliente;
import hotel.modelo.Habitacion;
import hotel.modelo.Reserva;
import hotel.repositorio.RepositorioHabitacion;
import hotel.repositorio.RepositorioReserva;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio encargado de la creación y consulta de reservas.
 *
 * Aquí se aplican las principales reglas de negocio relacionadas
 * con el proceso de reservación.
 */
public class ServicioReserva {

    private final RepositorioHabitacion repositorioHabitacion;
    private final RepositorioReserva repositorioReserva;
    private final ServicioDisponibilidad servicioDisponibilidad;

    /**
     * Constructor del servicio.
     *
     * @param repositorioHabitacion repositorio de habitaciones
     * @param repositorioReserva repositorio de reservas
     * @param servicioDisponibilidad servicio de disponibilidad
     */
    public ServicioReserva(RepositorioHabitacion repositorioHabitacion,
                           RepositorioReserva repositorioReserva,
                           ServicioDisponibilidad servicioDisponibilidad) {
        this.repositorioHabitacion = repositorioHabitacion;
        this.repositorioReserva = repositorioReserva;
        this.servicioDisponibilidad = servicioDisponibilidad;
    }

    /**
     * Crea una nueva reserva si se cumplen las reglas de negocio.
     *
     * @param idReserva id de la reserva
     * @param cliente cliente que realiza la reserva
     * @param numeroHabitacion número de la habitación
     * @param fechaEntrada fecha de entrada
     * @param fechaSalida fecha de salida
     * @return reserva creada
     * @throws IllegalArgumentException si alguna validación falla
     */
    public Reserva crearReserva(int idReserva,
                                Cliente cliente,
                                int numeroHabitacion,
                                LocalDate fechaEntrada,
                                LocalDate fechaSalida) {

        validarIdReserva(idReserva);
        validarCliente(cliente);
        validarFechas(fechaEntrada, fechaSalida);

        Habitacion habitacion = repositorioHabitacion.buscarPorNumero(numeroHabitacion);
        if (habitacion == null) {
            throw new IllegalArgumentException("No existe una habitación con el número indicado.");
        }

        if (!servicioDisponibilidad.estaDisponible(numeroHabitacion, fechaEntrada, fechaSalida)) {
            throw new IllegalArgumentException("La habitación no está disponible en el rango de fechas solicitado.");
        }

        Reserva reserva = new Reserva(idReserva, cliente, habitacion, fechaEntrada, fechaSalida);
        repositorioReserva.guardar(reserva);

        return reserva;
    }

    /**
     * Obtiene todas las reservas registradas.
     *
     * @return lista de reservas
     */
    public List<Reserva> obtenerReservas() {
        return repositorioReserva.obtenerTodas();
    }

    /**
     * Valida el id de la reserva.
     *
     * @param idReserva id de la reserva
     */
    private void validarIdReserva(int idReserva) {
        if (idReserva <= 0) {
            throw new IllegalArgumentException("El id de la reserva debe ser mayor que cero.");
        }

        if (repositorioReserva.buscarPorId(idReserva) != null) {
            throw new IllegalArgumentException("Ya existe una reserva con ese id.");
        }
    }

    /**
     * Valida los datos básicos del cliente.
     *
     * @param cliente cliente a validar
     */
    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }

        if (cliente.getId() <= 0) {
            throw new IllegalArgumentException("El id del cliente debe ser mayor que cero.");
        }

        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio.");
        }

        if (cliente.getDocumento() == null || cliente.getDocumento().trim().isEmpty()) {
            throw new IllegalArgumentException("El documento del cliente es obligatorio.");
        }

        if (cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del cliente es obligatorio.");
        }
    }

    /**
     * Valida las fechas de la reserva.
     *
     * @param fechaEntrada fecha de entrada
     * @param fechaSalida fecha de salida
     */
    private void validarFechas(LocalDate fechaEntrada, LocalDate fechaSalida) {
        if (fechaEntrada == null || fechaSalida == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas.");
        }

        if (!fechaSalida.isAfter(fechaEntrada)) {
            throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de entrada.");
        }
    }
}