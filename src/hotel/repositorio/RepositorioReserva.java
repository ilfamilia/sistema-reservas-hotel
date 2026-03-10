package hotel.repositorio;

import hotel.modelo.Reserva;
import hotel.modelo.Habitacion;
import java.util.List;

public interface RepositorioReserva {

    void guardar(Reserva reserva);

    List<Reserva> obtenerTodas();

    List<Reserva> obtenerPorHabitacion(Habitacion habitacion);
}
