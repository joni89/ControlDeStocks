package aplicacion.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class Almacen {
    
    private List <Producto> productos;
    private List <Cliente> clientes;
    private List <Proveedor> proveedores;
    private List <Envio> envioRealizados;
    
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
    public Almacen(List<Producto> productos, List<Cliente> clientes, List<Proveedor> proveedores, List<Envio> envioRealizados) {
        this.productos = productos;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.envioRealizados = envioRealizados;
    }

    /**
     * 
     * @return Devuelve la lista de productos.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece una lista de productos.
     * @param productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
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
    public List<Envio> getEnvioRealizados() {
        return envioRealizados;
    }

    /**
     * Establece la lista de envios.
     * @param envioRealizados
     */
    public void setEnvioRealizados(List<Envio> envioRealizados) {
        this.envioRealizados = envioRealizados;
    }
    
    
    
}
