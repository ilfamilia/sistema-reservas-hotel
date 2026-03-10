package hotel.repositorio.memoria;

import hotel.modelo.Reserva;
import hotel.modelo.Habitacion;
import hotel.repositorio.RepositorioReserva;

import java.util.ArrayList;
import java.util.List;

public class RepositorioReservaEnMemoria implements RepositorioReserva {

    private List<Reserva> reservas;

    public RepositorioReservaEnMemoria() {
        this.reservas = new ArrayList<>();
    }

    @Override
    public void guardar(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public List<Reserva> obtenerTodas() {
        return reservas;
    }

    @Override
    public List<Reserva> obtenerPorHabitacion(Habitacion habitacion) {

        List<Reserva> resultado = new ArrayList<>();

        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion)) {
                resultado.add(reserva);
            }
        }

        return resultado;
    }
}
