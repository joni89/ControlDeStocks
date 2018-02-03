package aplicacion.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class Almacen {
    
    private List <ProductoAlmacen> productos;
    private List <Cliente> clientes;
    private List <Proveedor> proveedores;
    private List <Envio> enviosRealizados;
    
    /**
     * Constructor sin parametros.
     */
    public Almacen() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Constructor con parametros.
     * @param productos
     * @param clientes
     * @param proveedores
     * @param envioRealizados
     */
    public Almacen(List<ProductoAlmacen> productos, List<Cliente> clientes, List<Proveedor> proveedores, List<Envio> envioRealizados) {
        this.productos = productos;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.enviosRealizados = envioRealizados;
    }

    /**
     * Devuelve la lista de productos.
     * @return lista de productos.
     */
    public List<ProductoAlmacen> getProductos() {
        return productos;
    }

    /**
     * Establece una lista de productos.
     * @param productos
     */
    public void setProductos(List<ProductoAlmacen> productos) {
        this.productos = productos;
    }

    /**
     * Devuelve la lista de clientes.
     * 
     * @return Devuelve la lista de clientes.
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Establece la lista de clientes.
     * @param clientes
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     *
     * @return Devuelve la lista de proveedores.
     */
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    /**
     * Establece la lista de proveedores.
     * @param proveedores
     */
    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * 
     * @return Devuelve la lista de envios realizados.
     */
    public List<Envio> getEnviosRealizados() {
        return enviosRealizados;
    }

    /**
     * Establece la lista de envios.
     * @param enviosRealizados
     */
    public void setEnviosRealizados(List<Envio> enviosRealizados) {
        this.enviosRealizados = enviosRealizados;
    }
    
    
    
}
