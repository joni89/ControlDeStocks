package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;
import aplicacion.modelo.Cliente;
import aplicacion.modelo.Proveedor;
import aplicacion.modelo.Envio;
import aplicacion.vista.VistaCrearProducto;
import aplicacion.vista.VistaListaClientesInventada;
import aplicacion.vista.VistaListaProductos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonatan
 */
public class ControladorPrincipal extends Controlador {

    private final Almacen almacen;
    private final VistaListaProductos vistaListaProductos;
    private final VistaListaClientesInventada vistaListaClientes;
    private final VistaCrearProducto vistaCrearProducto;
    private int idProducto;
    private String idCliente;
    private String idProveedor;

    public ControladorPrincipal() {
        this.almacen = new Almacen();
        this.vistaListaProductos = new VistaListaProductos(this, this.almacen);
        this.vistaListaClientes = new VistaListaClientesInventada(this, this.almacen);
        this.vistaCrearProducto = new VistaCrearProducto(this);
    }

    public void iniciarApp() {
        JFrame ventana = this.getVentana();
        ventana.setTitle("Control de Stocks");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setVisible(true);

        this.mostrarListaProductos();
    }

    //Productos
    private Producto crearProducto(String nombre, String fabricante, Proveedor proveedor, double precio, int unidades) {
        Producto productoVacio = new Producto(idProducto, nombre, fabricante, proveedor, precio, unidades);
        ++idProducto;
        return productoVacio;
    }

    private void anadirProductoAlmacen(Producto producto) {
        this.almacen.getProductos().add(obtenerProducto(producto.getId()));
    }

    private Producto obtenerProducto(int id) {
        for (Producto producto : almacen.getProductos()) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public void crearAnadirProducto(String nombre, String fabricante, Proveedor proveedor, double precio, int unidades) {
        Producto producto = crearProducto(nombre, fabricante, proveedor, precio, unidades);
        anadirProductoAlmacen(producto);
        this.setVistaActiva(vistaListaProductos);
        this.refrescarVistaActiva();
    }

    public void eliminarProducto(Producto producto) {
        this.almacen.getProductos().remove(producto);
    }

    public void mostrarListaProductos() {
        this.setVistaActiva(this.vistaListaProductos);
        this.refrescarVistaActiva();
    }

    //Clientes
    public Cliente crearCliente(String nombre, String direccion, String telefono, String email, String personaContacto) {
        Cliente clienteVacio = new Cliente(idCliente, nombre, direccion, telefono, email, personaContacto);

        return clienteVacio;
    }

    private void anadirCliente(Cliente cliente) {
        this.almacen.getClientes().add(cliente);
    }

    private Cliente obtenerCliente(int id) {
        for (Producto producto : almacen.getProductos()) {
            if (producto.getId() == id) {
                // return producto;
            }
        }
        return null;
    }

    public void crearAnadirCliente(String nombre, String direccion, String telefono, String email, String personaContacto) {
        Cliente cliente = crearCliente(nombre, direccion, telefono, email, personaContacto);
        anadirCliente(cliente);
        this.setVistaActiva(vistaListaClientes);
        this.refrescarVistaActiva();
    }

    public void eliminarCliente(Cliente cliente) {
        this.almacen.getClientes().remove(cliente);
    }

    public void verClientes() {
        this.setVistaActiva(this.vistaListaClientes);
        this.refrescarVistaActiva();
    }

    //Proveedores
    public Proveedor crearProveedor(String nombre, String direccion, String telefono, String email, String personaContacto) {
        Proveedor proveedorVacio = new Proveedor(idProveedor, nombre, direccion, telefono, email, personaContacto);
        return proveedorVacio;
    }

    private void anadirProveedor(Proveedor proveedor) {
        this.almacen.getProveedores().add(proveedor);
    }

    public void crearAnadirProveedor(String nombre, String direccion, String telefono, String email, String personaContacto) {
        Proveedor proveedor = crearProveedor(nombre, direccion, telefono, email, personaContacto);
        anadirProveedor(proveedor);
        this.setVistaActiva(vistaListaClientes);
    }

    public void eliminarProveedor(Proveedor proveedor) {
        this.almacen.getProveedores().remove(proveedor);
    }

    //Envio
    public Envio crearEnvio(List<Producto> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        Envio envioVacio = new Envio(productos, fecha, cliente, cobrado, costeEnvio);
        return envioVacio;
    }

    private void anadirEnvio(Envio envio) {
        this.almacen.getEnvioRealizados().add(envio);
    }

    public void crearAnadirEnvio(List<Producto> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        Envio envio = crearEnvio(productos, fecha, cliente, cobrado, costeEnvio);
        anadirEnvio(envio);
    }

    public Envio comprobarStock(Envio envio) {
        for (Producto stock : envio.getProductos()) {
            if (stock.getUnidades() > 0) {
                return envio;
            }
        }
        return null;
    }

    public void eliminarEnvio(Envio envio) {
        this.almacen.getEnvioRealizados().remove(envio);
    }
    
    //Facturas
    public Envio buscarEnviosFechas (Date fechaInicio, Date fechaFin){
        
        return null;
    }
    
    public void crearFacturaEnvio(Envio envio){
        //debería devolver una factura pero no existe ninguna clase factura
    }
    
    public void guardarFacturaArchivo(Envio envio){
        //debería recibir una factura para poder guardarla
    }

    //Vistas
    public void mostrarCrearProducto() {
        this.setVistaActiva(vistaCrearProducto);
        this.refrescarVistaActiva();
    }
}
