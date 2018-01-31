package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class ProductoEnvio {

    private Producto producto;
    private int cantidad;

    public ProductoEnvio(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
