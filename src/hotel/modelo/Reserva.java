package hotel.modelo;

import java.time.LocalDate;

/**
 * Representa una reserva de una habitación.
 *
 * Incluye el cliente, la habitación y el rango de fechas reservado.
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
     * Constructor con parámetros.
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
     * Obtiene el id de la reserva.
     *
     * @return id de la reserva
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la reserva.
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el cliente asociado a la reserva.
     *
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la reserva.
     *
     * @param cliente nuevo cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la habitación reservada.
     *
     * @return habitación
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }

    /**
     * Establece la habitación reservada.
     *
     * @param habitacion nueva habitación
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
     * Representación textual de la reserva.
     *
     * @return texto descriptivo de la reserva
     */
    @Override
    public String toString() {
        return "\nReserva:" +
                "\nid = " + id +
                "\ncliente = " + cliente +
                "\nhabitacion = " + habitacion +
                "\nfechaEntrada = " + fechaEntrada +
                "\nfechaSalida = " + fechaSalida;
    }
}