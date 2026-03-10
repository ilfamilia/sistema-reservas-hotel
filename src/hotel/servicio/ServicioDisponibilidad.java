package hotel.servicio;

import hotel.modelo.Habitacion;
import hotel.modelo.Reserva;
import hotel.repositorio.RepositorioHabitacion;
import hotel.repositorio.RepositorioReserva;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio encargado de verificar la disponibilidad de habitaciones.
 */
public class ServicioDisponibilidad {

    private final RepositorioHabitacion repositorioHabitacion;
    private final RepositorioReserva repositorioReserva;

    /**
     * Constructor del servicio.
     *
     * @param repositorioHabitacion repositorio de habitaciones
     * @param repositorioReserva repositorio de reservas
     */
    public ServicioDisponibilidad(RepositorioHabitacion repositorioHabitacion,
                                  RepositorioReserva repositorioReserva) {
        this.repositorioHabitacion = repositorioHabitacion;
        this.repositorioReserva = repositorioReserva;
    }

    /**
     * Obtiene el listado de habitaciones existentes.
     *
     * @return lista de habitaciones
     */
    public List<Habitacion> obtenerHabitaciones() {
        return repositorioHabitacion.obtenerTodas();
    }

    /**
     * Verifica si una habitación existe.
     *
     * @param numeroHabitacion número de habitación
     * @return true si existe, false en caso contrario
     */
    public boolean existeHabitacion(int numeroHabitacion) {
        return repositorioHabitacion.buscarPorNumero(numeroHabitacion) != null;
    }

    /**
     * Verifica si una habitación está disponible en un rango de fechas.
     *
     * @param numeroHabitacion número de habitación
     * @param fechaEntrada fecha de entrada
     * @param fechaSalida fecha de salida
     * @return true si está disponible, false en caso contrario
     */
    public boolean estaDisponible(int numeroHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        Habitacion habitacion = repositorioHabitacion.buscarPorNumero(numeroHabitacion);

        if (habitacion == null) {
            return false;
        }

        List<Reserva> reservas = repositorioReserva.obtenerTodas();

        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero() == numeroHabitacion
                    && haySolapamiento(fechaEntrada, fechaSalida, reserva.getFechaEntrada(), reserva.getFechaSalida())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determina si dos rangos de fechas se solapan.
     *
     * La lógica utilizada considera que existe conflicto cuando los rangos
     * comparten al menos un día del período reservado.
     *
     * @param entradaNueva fecha de entrada de la nueva reserva
     * @param salidaNueva fecha de salida de la nueva reserva
     * @param entradaExistente fecha de entrada de la reserva existente
     * @param salidaExistente fecha de salida de la reserva existente
     * @return true si existe solapamiento, false si no existe
     */
    private boolean haySolapamiento(LocalDate entradaNueva, LocalDate salidaNueva,
                                    LocalDate entradaExistente, LocalDate salidaExistente) {
        return entradaNueva.isBefore(salidaExistente) && salidaNueva.isAfter(entradaExistente);
    }
}