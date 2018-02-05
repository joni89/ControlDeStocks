package aplicacion.modelo;

import java.io.Serializable;

/**
 *
 * @author jonatan
 */
public class ProductoEnvio implements Serializable {

    private Producto producto;
    private int cantidad;

    /**
     * Constructor con parámetros.
     * 
     * @param producto
     * @param cantidad
     */
    public ProductoEnvio(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el producto.
     * 
     * @return el producto.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto.
     * 
     * @param producto producto.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Devuelve la cantidad.
     * 
     * @return la cantidad.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad.
     * 
     * @param cantidad cantidad.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
