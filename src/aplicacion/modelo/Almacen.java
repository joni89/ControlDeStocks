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
     *
     */
    public Almacen() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     *
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
     * @return
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     *
     * @param productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     *
     * @return
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     *
     * @param clientes
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     *
     * @return
     */
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    /**
     *
     * @param proveedores
     */
    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    /**
     *
     * @return
     */
    public List<Envio> getEnvioRealizados() {
        return envioRealizados;
    }

    /**
     *
     * @param envioRealizados
     */
    public void setEnvioRealizados(List<Envio> envioRealizados) {
        this.envioRealizados = envioRealizados;
    }
    
    
    
}
