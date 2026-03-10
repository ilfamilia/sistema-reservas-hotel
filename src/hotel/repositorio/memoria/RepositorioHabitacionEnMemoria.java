package hotel.repositorio.memoria;

import hotel.modelo.Habitacion;
import hotel.repositorio.RepositorioHabitacion;

import java.util.ArrayList;
import java.util.List;

public class RepositorioHabitacionEnMemoria implements RepositorioHabitacion {

    private List<Habitacion> habitaciones;

    public RepositorioHabitacionEnMemoria() {
        this.habitaciones = new ArrayList<>();
    }

    @Override
    public List<Habitacion> obtenerTodas() {
        return habitaciones;
    }

    @Override
    public Habitacion buscarPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }
}
