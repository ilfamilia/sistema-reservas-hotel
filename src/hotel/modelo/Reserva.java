package hotel.modelo;

import java.time.LocalDate;

/**
 * Clase que representa una reserva de una habitación.
 *
 * Esta entidad relaciona a un cliente con una habitación
 * dentro de un rango de fechas determinado.
 */
public class Reserva {

    private int id;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    /**
     * Constructor vacío.
     */
    public Reserva() {
    }

    /**
     * Constructor con los atributos principales de la reserva.
     *
     * @param id identificador de la reserva
     * @param cliente cliente asociado a la reserva
     * @param habitacion habitación reservada
     * @param fechaEntrada fecha de entrada
     * @param fechaSalida fecha de salida
     */
    public Reserva(int id, Cliente cliente, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el identificador de la reserva.
     *
     * @return id de la reserva
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la reserva.
     *
     * @param id nuevo id de la reserva
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el cliente asociado a la reserva.
     *
     * @return cliente de la reserva
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la reserva.
     *
     * @param cliente nuevo cliente de la reserva
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la habitación asociada a la reserva.
     *
     * @return habitación reservada
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }

    /**
     * Establece la habitación asociada a la reserva.
     *
     * @param habitacion nueva habitación reservada
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Obtiene la fecha de entrada.
     *
     * @return fecha de entrada
     */
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Establece la fecha de entrada.
     *
     * @param fechaEntrada nueva fecha de entrada
     */
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Obtiene la fecha de salida.
     *
     * @return fecha de salida
     */
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida.
     *
     * @param fechaSalida nueva fecha de salida
     */
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Devuelve una representación textual de la reserva.
     *
     * @return texto con la información de la reserva
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", habitacion=" + habitacion +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
