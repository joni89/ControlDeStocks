package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String fabricante;
    private String proveedor;
    private int precio;
    
    public Producto(){}
    
    public Producto(int id, String nombre, String fabricante, String proveedor, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.proveedor = proveedor;
        this.precio = precio;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
          
}
