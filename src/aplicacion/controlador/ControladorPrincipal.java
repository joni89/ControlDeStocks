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

/**
 *
 * @author jonatan
 */
public class ControladorPrincipal extends Controlador {

    private final Almacen almacen;
    private final VistaListaProductos vistaListaProductos;
    private final VistaListaClientesInventada vistaListaClientes;
    private final VistaCrearProducto vistaCrearProducto;
    

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
        //Coger variables de los componentes swing y devolver dicho producto
        int id = 1;
        Producto productoVacio = new Producto(id, nombre, fabricante, proveedor, precio, unidades);
        return productoVacio;
    }

    private void anadirProductoAlmacen(Producto producto) {
        this.almacen.getProductos().add(producto);
    }

    public void crearAnadirProducto(String nombre, String fabricante, Proveedor proveedor, double precio, int unidades) {
        Producto producto = crearProducto(nombre, fabricante, proveedor, precio, unidades);
        anadirProductoAlmacen(producto);
        this.setVistaActiva(vistaListaProductos);
        this.refrescarVistaActiva();
    }

    public void eliminarProducto(Producto producto) {
        //restar stock
    }

    public void mostrarListaProductos() {
        this.setVistaActiva(this.vistaListaProductos);
        this.refrescarVistaActiva();
    }

    //Clientes
    public void crearCliente() {
        //Coger variables de los componentes swing y devolver dicho cliente
        Cliente clienteVacio = new Cliente();

        this.refrescarVistaActiva();
    }

    private void anadirCliente(Cliente cliente) {

    }

    public void crearAnadirCliente() {
//            Cliente cliente = crearCliente();
//            añadirCliente(cliente);
    }

    public void eliminarCliente(Cliente cliente) {

    }

    public void verClientes() {
        this.setVistaActiva(this.vistaListaClientes);
        this.refrescarVistaActiva();
    }

    //Proveedores
    public void crearProveedor() {
        //Coger variables de los componentes swing y devolver dicho proveedor
        Proveedor proveedorVacio = new Proveedor();

        this.refrescarVistaActiva();
    }

    private void anadirProveedor(Proveedor proveedor) {

    }

    public void crearAnadirProveedor() {
//            Proveedor proveedor = crearProveedor();
//            añadirProveedor(proveedor);
    }

    public void eliminarProveedor(Proveedor proveedor) {

    }

    //Envio
    public void crearEnvio() {
        //Coger variables de los componentes swing y devolver dicho envio
        Envio envioVacio = new Envio();

        this.refrescarVistaActiva();
    }

    private void anadirEnvio(Envio envio) {

    }

    public void crearAnadirEnvio() {
//            Envio envio = crearEnvio();
//            añadirEnvio(envio);
    }

    public void eliminarEnvio(Envio envio) {

    }
    
    //Vistas
    
    public void mostrarCrearProducto(){
        System.out.println("aplicacion.controlador.ControladorPrincipal.mostrarCrearProducto()");
        this.setVistaActiva(vistaCrearProducto);
        this.refrescarVistaActiva();
    }
}
