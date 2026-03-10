package hotel.servicio;

import hotel.modelo.Habitacion;
import hotel.modelo.Reserva;
import hotel.repositorio.RepositorioHabitacion;
import hotel.repositorio.RepositorioReserva;

import java.time.LocalDate;

/**
 * Servicio de aplicación responsable de crear reservas, aplicando validaciones
 * y reglas de negocio. No persiste datos directamente; delega en los repositorios
 * y delega la verificación de disponibilidad en {@link ServicioDisponibilidad}.
 *
 * <p><b>Diseño (SOLID)</b>:
 * <ul>
 *   <li>SRP: Esta clase sólo coordina la creación de reservas y validaciones de negocio.</li>
 *   <li>DIP: Depende de interfaces (repositorios) y de un servicio especializado.</li>
 * </ul>
 *
 * <p><b>Reglas implementadas</b>:
 * <ul>
 *   <li>La habitación debe existir.</li>
 *   <li>La fecha de salida debe ser posterior a la fecha de entrada.</li>
 *   <li>No se permite crear una reserva si hay conflicto de fechas.</li>
 * </ul>
 *
 * <p><b>Dependencias esperadas</b> (contrato de integración):
 * <ul>
 *   <li>{@code RepositorioHabitacion#obtenerPorNumero(int numero)}</li>
 *   <li>{@code RepositorioReserva#guardar(Reserva reserva)}</li>
 * </ul>
 * Además, se utiliza {@link ServicioDisponibilidad#estaDisponible(int, LocalDate, LocalDate)}.
 */
public class ServicioReserva {

    private final RepositorioReserva repositorioReserva;
    private final RepositorioHabitacion repositorioHabitacion;
    private final ServicioDisponibilidad servicioDisponibilidad;

    /**
     * Crea el servicio de reservas con sus dependencias.
     * @param repositorioReserva acceso a persistencia de reservas en memoria
     * @param repositorioHabitacion acceso a habitaciones (validación de existencia)
     * @param servicioDisponibilidad componente reutilizado para validar disponibilidad
     */
    public ServicioReserva(RepositorioReserva repositorioReserva,
                           RepositorioHabitacion repositorioHabitacion,
                           ServicioDisponibilidad servicioDisponibilidad) {
        if (repositorioReserva == null || repositorioHabitacion == null || servicioDisponibilidad == null) {
            throw new IllegalArgumentException("Las dependencias del servicio no pueden ser nulas.");
        }
        this.repositorioReserva = repositorioReserva;
        this.repositorioHabitacion = repositorioHabitacion;
        this.servicioDisponibilidad = servicioDisponibilidad;
    }

    /**
     * Crea una reserva aplicando todas las validaciones necesarias. La reserva recibida
     * debe contener al menos: habitación (con su número), fecha de entrada y fecha de salida.
     *
     * <p><b>Nota de integración</b>: Se asume que la entidad {@code Reserva} expone
     * métodos de acceso como {@code getHabitacion()}, {@code getFechaEntrada()} y
     * {@code getFechaSalida()}. El repositorio asignará el identificador si corresponde.
     *
     * @param reserva objeto de reserva a crear
     * @return la reserva persistida (posiblemente con ID asignado por el repositorio)
     * @throws IllegalArgumentException si los datos son inválidos o la habitación no existe
     * @throws IllegalStateException si no hay disponibilidad para el rango solicitado
     */
    public Reserva crearReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        if (reserva.getHabitacion() == null) {
            throw new IllegalArgumentException("La reserva debe indicar una habitación.");
        }
        Habitacion habSolicitada = reserva.getHabitacion();
        Integer numeroHabitacion = habSolicitada.getNumero(); // Se asume getter de número

        if (numeroHabitacion == null) {
            throw new IllegalArgumentException("La habitación de la reserva debe tener número.");
        }

        LocalDate entrada = reserva.getFechaEntrada();
        LocalDate salida = reserva.getFechaSalida();

        // Validación de fechas (misma política que ServicioDisponibilidad)
        if (entrada == null || salida == null) {
            throw new IllegalArgumentException("Las fechas de entrada y salida no pueden ser nulas.");
        }
        if (!salida.isAfter(entrada)) {
            throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de entrada.");
        }

        // Validar existencia de la habitación
        Habitacion existente = repositorioHabitacion.buscarPorNumero(numeroHabitacion);
        if (existente == null) {
            throw new IllegalArgumentException("La habitación " + numeroHabitacion + " no existe.");
        }

        // Verificar disponibilidad previa a la creación
        boolean disponible = servicioDisponibilidad.estaDisponible(numeroHabitacion, entrada, salida);
        if (!disponible) {
            throw new IllegalStateException("La habitación " + numeroHabitacion +
                    " no está disponible en el rango solicitado.");
        }

        // Persistir a través del repositorio
        // Contrato esperado: el repositorio devuelve la reserva guardada (con ID si aplica).
        repositorioReserva.guardar(reserva);
        return reserva;
    }
}
