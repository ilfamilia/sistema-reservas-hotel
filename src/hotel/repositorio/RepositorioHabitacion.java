package hotel.repositorio;

import hotel.modelo.Habitacion;

import java.util.List;

/**
 * Interfaz para el acceso a datos de habitaciones.
 */
public interface RepositorioHabitacion {

    /**
     * Obtiene todas las habitaciones registradas.
     *
     * @return lista de habitaciones
     */
    List<Habitacion> obtenerTodas();

    /**
     * Busca una habitación por su número.
     *
     * @param numero número de habitación
     * @return habitación encontrada o null si no existe
     */
    Habitacion buscarPorNumero(int numero);
}