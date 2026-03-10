package hotel.repositorio.memoria;

import hotel.modelo.Habitacion;
import hotel.modelo.TipoHabitacion;
import hotel.repositorio.RepositorioHabitacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación en memoria del repositorio de habitaciones.
 *
 * Este repositorio inicia con habitaciones precargadas para permitir
 * el uso inmediato del sistema.
 */
public class RepositorioHabitacionEnMemoria implements RepositorioHabitacion {

    private final List<Habitacion> habitaciones;

    /**
     * Constructor del repositorio.
     *
     * Inicializa la lista interna y carga las habitaciones iniciales.
     */
    public RepositorioHabitacionEnMemoria() {
        this.habitaciones = new ArrayList<Habitacion>();
        cargarHabitacionesIniciales();
    }

    /**
     * Carga las habitaciones iniciales del sistema.
     */
    private void cargarHabitacionesIniciales() {
        habitaciones.add(new Habitacion(101, TipoHabitacion.INDIVIDUAL, "Disponible"));
        habitaciones.add(new Habitacion(102, TipoHabitacion.INDIVIDUAL, "Disponible"));
        habitaciones.add(new Habitacion(201, TipoHabitacion.DOBLE, "Disponible"));
        habitaciones.add(new Habitacion(202, TipoHabitacion.DOBLE, "Disponible"));
        habitaciones.add(new Habitacion(301, TipoHabitacion.SUITE, "Disponible"));
    }

    /**
     * Obtiene todas las habitaciones registradas.
     *
     * @return copia de la lista de habitaciones
     */
    @Override
    public List<Habitacion> obtenerTodas() {
        return new ArrayList<Habitacion>(habitaciones);
    }

    /**
     * Busca una habitación por su número.
     *
     * @param numero número de habitación
     * @return habitación encontrada o null si no existe
     */
    @Override
    public Habitacion buscarPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }
}