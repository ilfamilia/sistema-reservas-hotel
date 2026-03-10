package hotel.modelo;

/**
 * Clase que representa a un cliente o huésped del hotel.
 *
 * Esta entidad almacena la información básica del cliente
 * asociada a una reserva.
 */
public class Cliente {

    private int id;
    private String nombre;
    private String documento;
    private String telefono;

    /**
     * Constructor vacío.
     *
     * Se incluye para facilitar la creación de objetos
     * en distintos contextos académicos o de prueba.
     */
    public Cliente() {
    }

    /**
     * Constructor con todos los atributos principales del cliente.
     *
     * @param id identificador del cliente
     * @param nombre nombre completo del cliente
     * @param documento documento de identificación
     * @param telefono número de teléfono del cliente
     */
    public Cliente(int id, String nombre, String documento, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return id del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param id nuevo id del cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el documento del cliente.
     *
     * @return documento del cliente
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Establece el documento del cliente.
     *
     * @param documento nuevo documento del cliente
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     *
     * @param telefono nuevo teléfono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación textual del cliente.
     *
     * @return texto con la información del cliente
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
