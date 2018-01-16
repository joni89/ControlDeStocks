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

    public Envio() {}

    public Envio(List<Producto> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        this.productos = productos;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cobrado = cobrado;
        this.costeEnvio = costeEnvio;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public double getCosteEnvio() {
        return costeEnvio;
    }

    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }
    
    
}
