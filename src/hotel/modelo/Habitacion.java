package hotel.modelo;

/**
 * Clase que representa una habitación del hotel.
 *
 * Esta entidad contiene la información general de la habitación,
 * como su número, tipo y estado general.
 */
public class Habitacion {

    private int numero;
    private TipoHabitacion tipo;
    private String estadoGeneral;

    /**
     * Constructor vacío.
     */
    public Habitacion() {
    }

    /**
     * Constructor con los atributos principales de la habitación.
     *
     * @param numero número identificador de la habitación
     * @param tipo tipo de habitación
     * @param estadoGeneral estado general de la habitación
     */
    public Habitacion(int numero, TipoHabitacion tipo, String estadoGeneral) {
        this.numero = numero;
        this.tipo = tipo;
        this.estadoGeneral = estadoGeneral;
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
     * @param numero nuevo número de la habitación
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el tipo de la habitación.
     *
     * @return tipo de habitación
     */
    public TipoHabitacion getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la habitación.
     *
     * @param tipo nuevo tipo de habitación
     */
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el estado general de la habitación.
     *
     * @return estado general de la habitación
     */
    public String getEstadoGeneral() {
        return estadoGeneral;
    }

    /**
     * Establece el estado general de la habitación.
     *
     * @param estadoGeneral nuevo estado general
     */
    public void setEstadoGeneral(String estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    /**
     * Devuelve una representación textual de la habitación.
     *
     * @return texto con la información de la habitación
     */
    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", tipo=" + tipo +
                ", estadoGeneral='" + estadoGeneral + '\'' +
                '}';
    }
}
