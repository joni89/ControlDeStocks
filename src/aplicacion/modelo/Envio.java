package aplicacion.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class Envio {
    
    private List<Producto> productos;
    private Date fecha;
    private Cliente cliente;
    private boolean cobrado;
    private double costeEnvio;

    /**
     *
     */
    public Envio() {}

    /**
     *
     * @param productos
     * @param fecha
     * @param cliente
     * @param cobrado
     * @param costeEnvio
     */
    public Envio(List<Producto> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        this.productos = productos;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cobrado = cobrado;
        this.costeEnvio = costeEnvio;
    }
    
    /**
     *
     * @return
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     *
     * @param productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public boolean isCobrado() {
        return cobrado;
    }

    /**
     *
     * @param cobrado
     */
    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    /**
     *
     * @return
     */
    public double getCosteEnvio() {
        return costeEnvio;
    }

    /**
     *
     * @param costeEnvio
     */
    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }
    
    
}
