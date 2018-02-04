package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class ProductoAlmacen {

    private Producto producto;
    private int stock;

    /**
     * Constructor con parámetros.
     * 
     * @param producto
     * @param stock
     */
    public ProductoAlmacen(Producto producto, int stock) {
        this.producto = producto;
        this.stock = stock;
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
     * Devuelve el stock.
     * 
     * @return el stock.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock.
     * 
     * @param stock stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
