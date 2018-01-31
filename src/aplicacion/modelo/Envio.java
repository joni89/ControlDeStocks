package aplicacion.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class Envio {
    private int id;
    private List<ProductoEnvio> productos;
    private Date fecha;
    private Cliente cliente;
    private boolean cobrado;
    private double costeEnvio;

    /**
     * Constructor vacío.
     */
    public Envio() {}

    /**
     * Constructor con parámetros.
     * @param id
     * @param productos
     * @param fecha
     * @param cliente
     * @param cobrado
     * @param costeEnvio
     */
    public Envio(int id, List<ProductoEnvio> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        this.id = id;
        this.productos = productos;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cobrado = cobrado;
        this.costeEnvio = costeEnvio;
    }

    /**
     *
     * @return Devuelve el id.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Devuelve las productos del envío.
     *
     * @return las productos del envío
     */
    public List<ProductoEnvio> getProductos() {
        return productos;
    }

    /**
     * Establece las productos del envío.
     * @param productos
     */
    public void setProductos(List<ProductoEnvio> productos) {
        this.productos = productos;
    }

    /**
     *
     * @return Devuelve la fecha.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha.
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return Devuelve el cliente.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece un cliente.
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return Devuelve true o false.
     */
    public boolean isCobrado() {
        return cobrado;
    }

    /**
     * Establece si esta cobrado (true) o no (false).
     * @param cobrado
     */
    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    /**
     *
     * @return Devuelve el coste del envío.
     */
    public double getCosteEnvio() {
        return costeEnvio;
    }

    /**
     * Establece el coste del envío.
     * @param costeEnvio
     */
    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }
    
    
}
