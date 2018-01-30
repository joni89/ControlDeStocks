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
    private int unidades;
    
    /**
     *
     */
    public Producto(){}
    
    /**
     *
     * @param id
     * @param nombre
     * @param fabricante
     * @param proveedor
     * @param precio
     * @param unidades
     */
    public Producto(int id, String nombre, String fabricante, Proveedor proveedor, double precio, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.proveedor = proveedor;
        this.precio = precio;
        this.unidades = unidades;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     *
     * @param fabricante
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     *
     * @return
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     *
     * @param proveedor
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     *
     * @param unidades
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    
          
}
