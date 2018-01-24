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
    
    public Producto(){}
    
    public Producto(int id, String nombre, String fabricante, Proveedor proveedor, double precio, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.proveedor = proveedor;
        this.precio = precio;
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    
          
}
