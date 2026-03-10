package hotel.modelo;

/**
 * Representa al cliente o huésped del hotel.
 */
public class Cliente {

    private int id;
    private String nombre;
    private String documento;
    private String telefono;

    /**
     * Constructor vacío.
     */
    public Cliente() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador del cliente
     * @param nombre nombre completo del cliente
     * @param documento documento de identidad del cliente
     * @param telefono teléfono del cliente
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
     * @param id nuevo id
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
     * @param nombre nuevo nombre
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
     * @param documento nuevo documento
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
     * @param telefono nuevo teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Representación textual del cliente.
     *
     * @return texto descriptivo del cliente
     */
    @Override
    public String toString() {
        return "\nCliente: " +
                "\nid = " + id +
                "\nnombre = '" + nombre + '\'' +
                "\ndocumento = '" + documento + '\'' +
                "\ntelefono = '" + telefono + '\'';
    }
}