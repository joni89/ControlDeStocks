package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class ProductoAlmacen {

    private Producto producto;
    private int stock;

    public ProductoAlmacen(Producto producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
