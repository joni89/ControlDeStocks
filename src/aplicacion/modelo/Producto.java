package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String fabricante;
    private Proveedor proveedor;
    private double precio;
    
    /**
     * Constructor vacío.
     */
    public Producto(){}
    
    /**
     * Constructor con parámetros.
     * 
     * @param id
     * @param nombre
     * @param fabricante
     * @param proveedor
     * @param precio
     */
    public Producto(int id, String nombre, String fabricante, Proveedor proveedor, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    /**
     * Devuelve el ID del producto.
     * 
     * @return ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     * 
     * @param id ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del producto.
     * 
     * @return nombre. 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     * 
     * @param nombre nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el fabricante del producto.
     * 
     * @return fabricante.
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Establece el fabricante del producto.
     * 
     * @param fabricante fabricante
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Devuelve el proveedor.
     * 
     * @return el proveedor.
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Establece el proveedor.
     * 
     * @param proveedor proveedor.
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Devuelve el precio.
     * 
     * @return el precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio.
     * 
     * @param precio precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
