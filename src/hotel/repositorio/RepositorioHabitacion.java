package hotel.repositorio;

import hotel.modelo.Habitacion;
import java.util.List;

public interface RepositorioHabitacion {

    List<Habitacion> obtenerTodas();

    Habitacion buscarPorNumero(int numero);
}



