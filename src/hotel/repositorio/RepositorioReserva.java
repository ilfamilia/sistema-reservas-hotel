package hotel.repositorio;

import hotel.modelo.Reserva;

import java.util.List;

/**
 * Interfaz para el acceso a datos de reservas.
 */
public interface RepositorioReserva {

    /**
     * Guarda una nueva reserva.
     *
     * @param reserva reserva a guardar
     */
    void guardar(Reserva reserva);

    /**
     * Obtiene todas las reservas registradas.
     *
     * @return lista de reservas
     */
    List<Reserva> obtenerTodas();

    /**
     * Busca una reserva por su id.
     *
     * @param id identificador de la reserva
     * @return reserva encontrada o null si no existe
     */
    Reserva buscarPorId(int id);
}