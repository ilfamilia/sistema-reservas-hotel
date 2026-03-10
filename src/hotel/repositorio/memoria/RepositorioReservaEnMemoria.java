package hotel.repositorio.memoria;

import hotel.modelo.Reserva;
import hotel.repositorio.RepositorioReserva;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación en memoria del repositorio de reservas.
 */
public class RepositorioReservaEnMemoria implements RepositorioReserva {

    private final List<Reserva> reservas;

    /**
     * Constructor del repositorio.
     */
    public RepositorioReservaEnMemoria() {
        this.reservas = new ArrayList<Reserva>();
    }

    /**
     * Guarda una nueva reserva en memoria.
     *
     * @param reserva reserva a guardar
     */
    @Override
    public void guardar(Reserva reserva) {
        reservas.add(reserva);
    }

    /**
     * Obtiene todas las reservas registradas.
     *
     * @return copia de la lista de reservas
     */
    @Override
    public List<Reserva> obtenerTodas() {
        return new ArrayList<Reserva>(reservas);
    }

    /**
     * Busca una reserva por su id.
     *
     * @param id identificador de la reserva
     * @return reserva encontrada o null si no existe
     */
    @Override
    public Reserva buscarPorId(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }
}