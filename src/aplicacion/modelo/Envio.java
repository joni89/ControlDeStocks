package aplicacion.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class Envio implements Serializable{
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
     * 
     * @param id id.
     * @param productos productos.
     * @param fecha fecha.
     * @param cliente cliente.
     * @param cobrado cobrado.
     * @param costeEnvio coste de envío.
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
     * Devuelve el id.
     * 
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id.
     * 
     * @param id ID.
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
     * 
     * @param productos Lista de productos.
     */
    public void setProductos(List<ProductoEnvio> productos) {
        this.productos = productos;
    }

    /**
     * Devuelve la fecha.
     * 
     * @return fecha.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha.
     * 
     * @param fecha Fecha.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el cliente.
     * 
     * @return cliente.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece un cliente.
     * 
     * @param cliente cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve true o false.
     * 
     * @return true o false.
     */
    public boolean isCobrado() {
        return cobrado;
    }

    /**
     * Establece si esta cobrado (true) o no (false).
     * 
     * @param cobrado true o false.
     */
    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    /**
     * Devuelve el coste del envío.
     * 
     * @return coste del envío.
     */
    public double getCosteEnvio() {
        return costeEnvio;
    }

    /**
     * Establece el coste del envío.
     * 
     * @param costeEnvio Coste de envío.
     */
    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }
}
