package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;
import aplicacion.modelo.Cliente;
import aplicacion.modelo.Proveedor;
import aplicacion.modelo.Envio;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.ProductoEnvio;
import aplicacion.vista.VistaCrearClienteProveedor;
import aplicacion.vista.VistaCrearProducto;
import aplicacion.vista.VistaFactura;
import aplicacion.vista.VistaListaProductos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author jonatan
 */
public class ControladorPrincipal extends Controlador {

    private final Almacen almacen;
    private final VistaListaProductos vistaListaProductos;
    private final VistaCrearClienteProveedor vistaClienteProveedor;
    private int idProducto;
    private int idEnvio;

    /**
     * Constructor.
     */
    public ControladorPrincipal() {
        this.almacen = new Almacen();
        this.vistaListaProductos = new VistaListaProductos(this, this.almacen);
        this.vistaClienteProveedor = new VistaCrearClienteProveedor(this);
        this.idProducto = 1;
        this.idEnvio = 1;
    }

    /**
     * Inicia la ventana principal.
     */
    public void iniciarApp() {
        JFrame ventana = this.getVentana();
        ventana.setTitle("Control de Stocks");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setVisible(true);

        this.mostrarListaProductos();
    }

    //Productos
    private Producto crearProducto(String nombre, String fabricante, Proveedor proveedor, double precio) {
        return new Producto(idProducto++, nombre, fabricante, proveedor, precio);
    }

    private void anadirProductoAlmacen(Producto producto, int stock) {
        if(obtenerProducto(producto.getId()) != null){
            throw new IllegalStateException();
        }

        this.almacen.getProductos().add(new ProductoAlmacen(producto, stock));
    }

    private ProductoAlmacen obtenerProductoAlmacen(int idProducto) {
        for (ProductoAlmacen productoAlmacen : almacen.getProductos()) {
            if (productoAlmacen.getProducto().getId() == idProducto) {
                return productoAlmacen;
            }
        }
        return null;
    }

    private Producto obtenerProducto(int id) {
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(idProducto);
        return productoAlmacen == null ? null : productoAlmacen.getProducto();
    }

    private int obtenerStockProducto(int id) {
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(idProducto);
        return productoAlmacen == null ? 0 : productoAlmacen.getStock();
    }

    /**
     * Se crea el producto, se añade al almacen y establecemos la vista activa.
     * @param nombre nombre del producto
     * @param fabricante
     * @param proveedor
     * @param precio
     * @param stock
     */
    public void crearAnadirProducto(String nombre, String fabricante, Proveedor proveedor, double precio, int stock) {
        Producto producto = crearProducto(nombre, fabricante, proveedor, precio);
        anadirProductoAlmacen(producto, stock);
        this.setVistaActiva(vistaListaProductos);
        this.refrescarVistaActiva();
    }

    /**
     * Elimina un producto del almacen.
     * @param producto
     */
    public void eliminarProducto(Producto producto) {
        Producto productoAlmacen = obtenerProducto(producto.getId());
        if(productoAlmacen != null){
            this.almacen.getProductos().remove(productoAlmacen);    
        }
    }
    
    private void anadirStock(Producto producto, int cantidad){
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(producto.getId());
        productoAlmacen.setStock(productoAlmacen.getStock() + cantidad);
    }
    
    private void restarStock(Producto producto, int cantidad){
        anadirStock(producto, -cantidad);
    }
    /**
     * Muestra la lista de productos y refresca la vista.
     */
    public void mostrarListaProductos() {
        this.setVistaActiva(this.vistaListaProductos);
        this.refrescarVistaActiva();
    }

    //Clientes
    private Cliente crearCliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Objects.requireNonNull(id); //esto en todos los crear
        return new Cliente(id, nombre, direccion, telefono, email, personaContacto);
    }

    private void anadirCliente(Cliente cliente) {
        if(obtenerCliente(cliente.getId()) != null){
            throw new IllegalStateException();
        }
        
        this.almacen.getClientes().add(cliente);
    }

    private Cliente obtenerCliente(String id) {
        for (Cliente cliente : almacen.getClientes()) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Se crea el cliente y se añade al almacén.
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param personaContacto
     */
    public void crearAnadirCliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Cliente cliente = crearCliente(id, nombre, direccion, telefono, email, personaContacto);
        anadirCliente(cliente);
    }

    /**
     * Elimina un cliente del almacén.
     * @param cliente
     */
    public void eliminarCliente(Cliente cliente) {
        Cliente clienteAlmacen = obtenerCliente(cliente.getId());
        if(clienteAlmacen != null){
            this.almacen.getClientes().remove(clienteAlmacen);
        }
        
    }

    //Proveedores
    private Proveedor crearProveedor(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Proveedor proveedorVacio = new Proveedor(id, nombre, direccion, telefono, email, personaContacto);
        return proveedorVacio;
    }

    private void anadirProveedor(Proveedor proveedor) {
        if(obtenerProveedor(proveedor.getId()) != null){
            throw new IllegalStateException();
        }

        this.almacen.getProveedores().add(proveedor);
    }

    private Proveedor obtenerProveedor(String id) {
        for (Proveedor proveedor : almacen.getProveedores()) {
            if (proveedor.getId().equals(id)) {
                return proveedor;
            }
        }
        return null;
    }
    
    /**
     * Crea un proveedor y lo añade al almacén.
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param personaContacto
     */
    public void crearAnadirProveedor(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Proveedor proveedor = crearProveedor(id, nombre, direccion, telefono, email, personaContacto);
        anadirProveedor(proveedor);
    }

    /**
     * Elimina un proveedor.
     * @param proveedor
     */
    public void eliminarProveedor(Proveedor proveedor) {
        Proveedor proveedorAlmacen = obtenerProveedor(proveedor.getId());
        if(proveedorAlmacen != null){
            this.almacen.getProveedores().remove(proveedorAlmacen);
        }
    }

    //Envio
    private Envio crearEnvio(List<ProductoEnvio> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        Envio envioVacio = new Envio(idEnvio++, productos, fecha, cliente, cobrado, costeEnvio);
        return envioVacio;
    }

    private boolean anadirEnvio(Envio envio) {
        if(obtenerEnvio(envio.getId()) != null){
            throw new IllegalStateException();
        }

        if(comprobarStock(envio)) {
            this.almacen.getEnviosRealizados().add(envio);
            return true;
        }

        return false;
    }
    
    private Envio obtenerEnvio(int id){
        for(Envio envio : almacen.getEnviosRealizados()){
            if(envio.getId() == id){
                return envio;
            }
        }
        return null;
    }
    

    /**
     * Crea un envio y lo añade al almacen.
     * @param productos
     * @param fecha
     * @param cliente
     * @param cobrado
     * @param costeEnvio
     */
    public boolean crearAnadirEnvio(List<ProductoEnvio> productos, Date fecha, Cliente cliente, boolean cobrado, double costeEnvio) {
        Envio envio = crearEnvio(productos, fecha, cliente, cobrado, costeEnvio);
        return anadirEnvio(envio);
    }
    
    /**
     * Elimina el envio.
     * @param envio
     */
    private void eliminarEnvio(Envio envio){
        Envio envioAlmacen = obtenerEnvio(envio.getId());
        if(envioAlmacen != null){
            almacen.getEnviosRealizados().remove(envioAlmacen);
        }
    }
    
    /**
     * Comprueba el stock del envio.
     * @param envio
     * @return Si tiene stock, devuelve el envio.
     */
    public boolean comprobarStock(Envio envio) {
        for (ProductoEnvio productoEnvio : envio.getProductos()) {
            int stock = obtenerStockProducto(productoEnvio.getProducto().getId());
            if(productoEnvio.getCantidad() > stock){
                return false;
            }
        }
        return true;
    }
    
    private void restarStockEnvio(Envio envio){
        for(ProductoEnvio productoEnvio : envio.getProductos()){
            restarStock(productoEnvio.getProducto(), productoEnvio.getCantidad());
        }
    }
    
    //Facturas

    /**
     * Busca los envios entre dos fechas.
     * @param fechaInicio
     * @param fechaFin
     * @return devuelve los envio/s fruto de la busqueda.
     */
    public Envio buscarEnviosFechas (Date fechaInicio, Date fechaFin){
        
        return null;
    }
    
    /**
     *
     * @param envio
     */
    private String crearFacturaEnvio(Envio envio){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Envío #%d\n", envio.getId()));
        sb.append(String.format("Fecha: %d\n", envio.getFecha())); // TODO Falta formatear

        // TODO completar este método

        for(ProductoEnvio productoEnvio : envio.getProductos()) {
            sb.append(String.format("%s... y más cosas\n", productoEnvio.getProducto().getNombre()));
        }

        return sb.toString();

    }
    
    /**
     *
     * @param envio
     */
    public void guardarFacturaArchivo(String factura, File archivo) throws IOException{
        try(PrintStream ps = new PrintStream(archivo, StandardCharsets.UTF_8.name())) {
            ps.append(factura);
        }
    }

    //Vistas

    /**
     * Se muestra la ventana de creacción del producto.
     */
    public void mostrarCrearProducto() {

        VistaCrearProducto vistaCrearProducto =  new VistaCrearProducto(this);

        this.setVistaActiva(vistaCrearProducto);
        this.refrescarVistaActiva();

    }

    public void mostrarFactura(Envio envio) {

        String factura = crearFacturaEnvio(envio);

        VistaFactura vista = new VistaFactura(this, factura);

        this.setVistaActiva(vista);
        this.refrescarVistaActiva();

    }

}
