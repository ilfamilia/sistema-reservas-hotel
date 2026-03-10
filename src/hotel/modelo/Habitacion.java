package hotel.modelo;

/**
 * Representa una habitación del hotel.
 *
 * Contiene datos relevantes como número, tipo y estado general.
 */
public class Habitacion {

    private int numero;
    private TipoHabitacion tipo;
    private String estado;

    /**
     * Constructor vacío.
     */
    public Habitacion() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param numero número de la habitación
     * @param tipo tipo de habitación
     * @param estado estado general de la habitación
     */
    public Habitacion(int numero, TipoHabitacion tipo, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
    }

    /**
     * Obtiene el número de la habitación.
     *
     * @return número de la habitación
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la habitación.
     *
     * @param numero nuevo número
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el tipo de habitación.
     *
     * @return tipo de habitación
     */
    public TipoHabitacion getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de habitación.
     *
     * @param tipo nuevo tipo
     */
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el estado general de la habitación.
     *
     * @return estado general
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado general de la habitación.
     *
     * @param estado nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Representación textual de la habitación.
     *
     * @return texto descriptivo de la habitación
     */
    @Override
    public String toString() {
        return "\nHabitacion:" +
                "\nnumero = " + numero +
                "\ntipo = " + tipo +
                "\nestado = '" + estado + '\'';
    }
}