package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;
import aplicacion.modelo.Cliente;
import aplicacion.modelo.Proveedor;
import aplicacion.modelo.Envio;
import aplicacion.modelo.ListaClientes;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.ProductoEnvio;
import aplicacion.vista.creacion.VistaAnadirStock;
import aplicacion.vista.creacion.VistaCrearClienteProveedor;
import aplicacion.vista.creacion.VistaCrearEnvio;
import aplicacion.vista.creacion.VistaCrearFactura;
import aplicacion.vista.creacion.VistaCrearProducto;
import aplicacion.vista.eliminacion.VistaEliminar;
import aplicacion.vista.VistaFactura;
import aplicacion.vista.VistaPrincipal;
import aplicacion.vista.eliminacion.VistaEliminarProducto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jonatan
 */
public class ControladorPrincipal extends Controlador {

    private final Almacen almacen;
    private final VistaPrincipal vistaPrincipal;
    private int idProducto;
    private int idEnvio;

    /**
     * Constructor.
     */
    public ControladorPrincipal() {
        this.almacen = new Almacen();
        this.vistaPrincipal = new VistaPrincipal(this, almacen);
        this.idProducto = 1;
        this.idEnvio = 1;
    }

    /**
     * Inicia la ventana principal.
     */
    public void iniciarApp() {
        cargarAlmacen();

        JFrame ventana = this.getVentana();
        ventana.setTitle("Control de Stocks");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setJMenuBar(this.crearMenus());
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                guardarAlmacen();
            }
        });
        ventana.setSize(600, 400);
        ventana.setVisible(true);

        this.mostrarVistaPrincipal();
    }

    private JMenuBar crearMenus() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menuAcciones = new JMenu("Acciones");
        menuBar.add(menuAcciones);

        JMenuItem accionBuscar = new JMenuItem("Buscar");
        accionBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se pulsó BUSCAR");
            }
        });
        menuAcciones.add(accionBuscar);

        JMenuItem accionEliminar = new JMenuItem("Eliminar");
        accionEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mostrarEliminar();
            }
        });
        menuAcciones.add(accionEliminar);

        // BÓRRAME
        JMenuItem accionCrearCliente = new JMenuItem("Crear cliente");
        accionCrearCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCrearCliente();
            }
        });
        menuAcciones.add(accionCrearCliente);

        return menuBar;

    }

    private void cargarAlmacen() {
        try {

            List<ProductoAlmacen> productos = leerJsonProductos();

            int maxIdProducto = 0;

            for (ProductoAlmacen producto : productos) {
                int idProducto = producto.getProducto().getId();
                if (idProducto > maxIdProducto) {
                    maxIdProducto = idProducto;
                }
            }

            this.idProducto = maxIdProducto + 1;

            almacen.setProductos(productos);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this.getVentana(), "No se han podido cargar los productos del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {

            List<Cliente> clientes = leerXmlClientes();

            almacen.setClientes(clientes);

        } catch (IOException | JAXBException ex) {
            JOptionPane.showMessageDialog(this.getVentana(), "No se han podido cargar los clientes del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {

            List<Proveedor> proveedores = leerTxtProveedores();

            almacen.setProveedores(proveedores);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.getVentana(), "No se han podido cargar los proveedores del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {

            List<Envio> envios = leerBinEnvios();

            int maxIdEnvio = 0;

            for (Envio envio : envios) {
                int idEnvio = envio.getId();
                if (idEnvio > maxIdEnvio) {
                    maxIdEnvio = idEnvio;
                }
            }

            this.idEnvio = maxIdEnvio + 1;

            almacen.setEnviosRealizados(envios);

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this.getVentana(), "No se han podido cargar los envíos del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarAlmacen() {
        try {
            generarJsonProductos(almacen.getProductos());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se han podido guardar los productos del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            generarXmlClientes(almacen.getClientes());
        } catch (IOException | JAXBException ex) {
            JOptionPane.showMessageDialog(null, "No se han podido guardar los clientes del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            generarTxtProveedores(almacen.getProveedores());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se han podido guardar los proveedores del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            generarBinEnvios(almacen.getEnviosRealizados());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se han podido guardar los envíos del almacén", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Productos
    /**
     * Crea el producto incrementando su id.
     *
     * @param nombre nombre del producto.
     * @param fabricante nombre del fabricante.
     * @param proveedor nombre del proveedor.
     * @param precio valor monetario del producto.
     * @return Devuelve un producto.
     */
    private Producto crearProducto(String nombre, String fabricante, Proveedor proveedor, double precio) {
        Objects.requireNonNull(nombre);
        return new Producto(idProducto++, nombre, fabricante, proveedor, precio);
    }

    /**
     * Añade productos al almacen.
     *
     * @param producto Producto a añadir al almacén.
     * @param stock Cantidad de productos.
     */
    private void anadirProductoAlmacen(Producto producto, int stock) {
        if (obtenerProducto(producto.getId()) != null) {
            throw new IllegalStateException();
        }

        this.almacen.getProductos().add(new ProductoAlmacen(producto, stock));
    }

    /**
     * Por un id se obtiene el productoAlmacen del almacén.
     *
     * @param idProducto id del producto.
     * @return Devuelve el productoAlmacen si lo encuentra. Si no, null.
     */
    private ProductoAlmacen obtenerProductoAlmacen(int idProducto) {
        for (ProductoAlmacen productoAlmacen : almacen.getProductos()) {
            if (productoAlmacen.getProducto().getId() == idProducto) {
                return productoAlmacen;
            }
        }
        return null;
    }

    /**
     * Dado un id obtengo un producto del almacén.
     *
     * @param id ID del producto a obtener.
     * @return Devuelve el producto.
     */
    private Producto obtenerProducto(int id) {
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(id);
        return productoAlmacen == null ? null : productoAlmacen.getProducto();
    }

    /**
     * Dado un id obtengo el stock del producto del almacén.
     *
     * @param id ID del producto a obtener.
     * @return Devuelve el stock.
     */
    private int obtenerStockProducto(int id) {
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(id);
        return productoAlmacen == null ? 0 : productoAlmacen.getStock();
    }

    /**
     * Se crea el producto, se añade al almacen y establecemos la vista activa.
     *
     * @param nombre nombre del producto.
     * @param fabricante nombre del fabricante.
     * @param proveedor Proveedor del producto.
     * @param precio Valor monetario del producto.
     * @param stock Cantidad del producto.
     */
    public void crearAnadirProducto(String nombre, String fabricante, Proveedor proveedor, double precio, int stock) {
        Producto producto = crearProducto(nombre, fabricante, proveedor, precio);
        anadirProductoAlmacen(producto, stock);
        this.setVistaActiva(vistaPrincipal);
        this.refrescarVistaActiva();
    }

    /**
     * Elimina un producto del almacen.
     *
     * @param producto Producto a eliminar.
     */
    public void eliminarProducto(Producto producto) {
        Producto productoAlmacen = obtenerProducto(producto.getId());
        if (productoAlmacen != null) {
            this.almacen.getProductos().remove(productoAlmacen);
        }
    }

    /**
     * Añade stock a un producto.
     *
     * @param producto Producto a añadir stock.
     * @param cantidad Cantidad de producto.
     */
    public void anadirStock(ProductoAlmacen producto, int cantidad) {
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(producto.getProducto().getId());
        productoAlmacen.setStock(productoAlmacen.getStock() + cantidad);
        this.refrescarVistaActiva();
    }

    /**
     * Quita stock de un producto.
     *
     * @param producto Producto a quitar stock.
     * @param cantidad Cantidad a quitar.
     */
    public void restarStock(Producto producto, int cantidad) {
        ProductoAlmacen productoAlmacen = obtenerProductoAlmacen(producto.getId());
        restarStock(productoAlmacen, cantidad);
    }

    /**
     * Quita stock de un producto.
     *
     * @param producto Producto a quitar stock.
     * @param cantidad Cantidad a quitar.
     */
    public void restarStock(ProductoAlmacen producto, int cantidad) {
        anadirStock(producto, -cantidad);
    }

    //Clientes
    /**
     * Crea un cliente.
     *
     * @param id CIF o NIF del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param email Correo electrónico del cliente.
     * @param personaContacto Nombre de la persona de contacto del cliente.
     * @return Nuevo cliente.
     */
    private Cliente crearCliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Objects.requireNonNull(id); //esto en todos los crear
        return new Cliente(id, nombre, direccion, telefono, email, personaContacto);
    }

    /**
     * Añadir cliente
     *
     * @param cliente Cliente a añadir
     */
    private void anadirCliente(Cliente cliente) {
        if (obtenerCliente(cliente.getId()) != null) {
            throw new IllegalStateException();
        }

        this.almacen.getClientes().add(cliente);
    }

    /**
     * Obtención de un cliente dado su CIF o NIF.
     *
     * @param id CIF o NIF del cliente.
     * @return Devuelve el cliente si lo encuentra. Si no, null.
     */
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
     *
     * @param id CIF o NIF del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param email Correo electrónico del cliente.
     * @param personaContacto Nombre de la persona de contacto del cliente.
     */
    public void crearAnadirCliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Cliente cliente = crearCliente(id, nombre, direccion, telefono, email, personaContacto);
        anadirCliente(cliente);
    }

    /**
     * Elimina un cliente del almacén.
     *
     * @param cliente Cliente a eliminar.
     */
    public void eliminarCliente(Cliente cliente) {
        Cliente clienteAlmacen = obtenerCliente(cliente.getId());
        if (clienteAlmacen != null) {
            this.almacen.getClientes().remove(clienteAlmacen);
        }

    }

    //Proveedores
    /**
     * Crea un proveedor.
     *
     * @param id CIF del proveedor.
     * @param nombre Nombre del proveedor.
     * @param direccion Dirección del proveedor.
     * @param telefono Teléfono del proveedor.
     * @param email Correo electrónico del proveedor.
     * @param personaContacto Nombre de la persona de contacto del proveedor.
     * @return Nuevo proveedor.
     */
    private Proveedor crearProveedor(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Proveedor proveedorVacio = new Proveedor(id, nombre, direccion, telefono, email, personaContacto);
        return proveedorVacio;
    }

    /**
     * Añadir proveedor.
     *
     * @param proveedor Proveedor a añadir.
     */
    private void anadirProveedor(Proveedor proveedor) {
        if (obtenerProveedor(proveedor.getId()) != null) {
            throw new IllegalStateException();
        }

        this.almacen.getProveedores().add(proveedor);
    }

    /**
     * Obtención de un proveedor dado su CIF.
     *
     * @param id CIF del proveedor.
     * @return Devuelve el proveedor si lo encuentra. Si no, null.
     */
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
     *
     * @param id CIF del proveedor.
     * @param nombre Nombre del proveedor.
     * @param direccion Dirección del proveedor.
     * @param telefono Teléfono del proveedor.
     * @param email Correo electrónico del proveedor.
     * @param personaContacto Nombre de la persona de contacto del proveedor.
     */
    public void crearAnadirProveedor(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        Proveedor proveedor = crearProveedor(id, nombre, direccion, telefono, email, personaContacto);
        anadirProveedor(proveedor);
    }

    /**
     * Elimina un proveedor.
     *
     * @param proveedor Proveedor a eliminar.
     */
    public void eliminarProveedor(Proveedor proveedor) {
        Proveedor proveedorAlmacen = obtenerProveedor(proveedor.getId());
        if (proveedorAlmacen != null) {
            this.almacen.getProveedores().remove(proveedorAlmacen);
        }
    }

    //Envio
    /**
     * Crea un envío incrementando su id.
     *
     * @param productos Lista de productos del envío.
     * @param fecha Fecha del envío.
     * @param cliente Cliente al que va el envío.
     * @param cobrado Si esta o no cobrado.
     * @param costeEnvio Valor monetario del envío.
     * @return Devuelve el envío.
     */
    private Envio crearEnvio(List<ProductoEnvio> productos, Date fecha, Cliente cliente, boolean cobrado) {
        double costeEnvio = 0;

        for (ProductoEnvio productoEnvio : productos) {
            costeEnvio += productoEnvio.getProducto().getPrecio() * productoEnvio.getCantidad();
        }

        Envio envioVacio = new Envio(idEnvio++, productos, fecha, cliente, cobrado, costeEnvio);
        return envioVacio;
    }

    /**
     * Añade el envío.
     *
     * @param envio Envío a añadir.
     * @return Devuelve true si se realizó el envío, false si no lo hizo.
     */
    private boolean anadirEnvio(Envio envio) {
        if (obtenerEnvio(envio.getId()) != null) {
            throw new IllegalStateException();
        }

        if (comprobarStock(envio)) {
            restarStockEnvio(envio);
            this.almacen.getEnviosRealizados().add(envio);
            return true;
        }

        return false;
    }

    /**
     * Se obtiene el envío a partir de su ID
     *
     * @param id ID del envío a obtener.
     * @return Devuelve el envio si lo encuentra. Si no, null.
     */
    private Envio obtenerEnvio(int id) {
        for (Envio envio : almacen.getEnviosRealizados()) {
            if (envio.getId() == id) {
                return envio;
            }
        }
        return null;
    }

    /**
     * Crea un envio y lo añade al almacen.
     *
     * @param productos Lista de productos del envío.
     * @param fecha Fecha del envío.
     * @param cliente Cliente al que va el envío.
     * @param cobrado Si esta o no cobrado.
     * @return true si el envío fue creado, false si no.
     */
    public boolean crearAnadirEnvio(List<ProductoEnvio> productos, Date fecha, Cliente cliente, boolean cobrado) {
        Envio envio = crearEnvio(productos, fecha, cliente, cobrado);
        boolean creado = anadirEnvio(envio);
        return creado;
    }

    /**
     * Elimina el envio.
     *
     * @param envio Envío a eliminar.
     */
    private void eliminarEnvio(Envio envio) {
        Envio envioAlmacen = obtenerEnvio(envio.getId());
        if (envioAlmacen != null) {
            almacen.getEnviosRealizados().remove(envioAlmacen);
        }
    }

    /**
     * Comprueba el stock del envio.
     *
     * @param envio Envío a comprobar.
     * @return Devuelve true si tiene stock, false si no tiene.
     */
    public boolean comprobarStock(Envio envio) {
        for (ProductoEnvio productoEnvio : envio.getProductos()) {
            int stock = obtenerStockProducto(productoEnvio.getProducto().getId());

            if (productoEnvio.getCantidad() > stock) {
                return false;
            }
        }
        return true;
    }

    /**
     * Resta el stock del producto/s que se ha/n enviado.
     *
     * @param envio Envio del que se obtiene la cantidad del producto.
     */
    private void restarStockEnvio(Envio envio) {
        for (ProductoEnvio productoEnvio : envio.getProductos()) {
            restarStock(productoEnvio.getProducto(), productoEnvio.getCantidad());
        }
    }

    //Facturas
    /**
     * Busca los envios entre dos fechas.
     *
     * @param fechaInicio fecha de inicio.
     * @param fechaFin fecha de fin.
     * @return devuelve los envio/s fruto de la busqueda.
     */
    public List<Envio> buscarEnviosFechas(Date fechaInicio, Date fechaFin) {

        long fechaIn = fechaInicio.getTime();
        long fechaEnd = fechaFin.getTime();
        List<Envio> enviosEncontrados = new ArrayList<Envio>();

        for (Envio envio : almacen.getEnviosRealizados()) {
            long fechaActual = envio.getFecha().getTime();
            if (fechaActual >= fechaIn && fechaActual <= fechaEnd) {
                enviosEncontrados.add(envio);
            }
        }

        return enviosEncontrados;
    }

    /**
     * Crea una factura.
     *
     * @param envio Envio para crear la factura.
     */
    private String crearFacturaEnvio(Envio envio) {

        StringBuilder sb = new StringBuilder();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        sb.append(String.format("Envío #%d\n", envio.getId()));
        sb.append(String.format("Fecha: %s\n", df.format(envio.getFecha())));
        sb.append(String.format("Cliente: %s\n", envio.getCliente().getNombre()));

        sb.append(String.format("\n%-30s %16s %5s %16s\n", "Producto", "Precio Unid. (€)", "Cant.", "Precio (€)"));

        // TODO completar este método
        for (ProductoEnvio productoEnvio : envio.getProductos()) {
            double precio = productoEnvio.getProducto().getPrecio() * productoEnvio.getCantidad();
            sb.append(String.format("%-30s %14.2f %5d %14.2f\n", productoEnvio.getProducto().getNombre(), productoEnvio.getProducto().getPrecio(), productoEnvio.getCantidad(), precio));
        }

        sb.append(String.format("\nTotal: %.2f", envio.getCosteEnvio()));

        return sb.toString();

    }

    /**
     * Guarda la factura en un archivo.
     *
     * @param factura Factura a guardar.
     * @param archivo Archivo donde se va guardar la factura.
     * @throws IOException si se produce un error de E/S
     */
    public void guardarFacturaArchivo(String factura, File archivo) throws IOException {
        try (PrintStream ps = new PrintStream(archivo, StandardCharsets.UTF_8.name())) {
            ps.append(factura);
        }
    }

    //Vistas
    
    /**
     * Muestra la lista de productos y refresca la vista.
     */
    public void mostrarVistaPrincipal() {
        this.setVistaActiva(this.vistaPrincipal);
        this.refrescarVistaActiva();
    }
    
    /**
     * Se muestra la ventana de creacción del producto.
     */
    public void mostrarCrearProducto() {

        VistaCrearProducto vistaCrearProducto = new VistaCrearProducto(this, almacen);

        this.setVistaActiva(vistaCrearProducto);
        this.refrescarVistaActiva();

    }

    /**
     * Se muestra la ventana de creacción del cliente.
     */
    public void mostrarCrearCliente() {

        VistaCrearClienteProveedor vistaCrearClienteProveedor = new VistaCrearClienteProveedor(this, false);

        this.setVistaActiva(vistaCrearClienteProveedor);
        this.refrescarVistaActiva();

    }

    /**
     * Se muestra la ventana de creacción del proveedor.
     */
    public void mostrarCrearProveedor() {

        VistaCrearClienteProveedor vistaCrearClienteProveedor = new VistaCrearClienteProveedor(this, true);

        this.setVistaActiva(vistaCrearClienteProveedor);
        this.refrescarVistaActiva();

    }

    /**
     * Se muestra la ventana de creación de nuevo stock.
     */
    public void mostrarCrearStock() {

        VistaAnadirStock vistaAnadirStock = new VistaAnadirStock(this, almacen);

        this.setVistaActiva(vistaAnadirStock);
        this.refrescarVistaActiva();
    }

    /**
     * Se muestra la ventana de creacción del envío.
     */
    public void mostrarCrearEnvio() {

        VistaCrearEnvio vistaCrearEnvio = new VistaCrearEnvio(this, almacen);

        this.setVistaActiva(vistaCrearEnvio);
        this.refrescarVistaActiva();
    }

    /**
     * Se muestra la emisión de la factura.
     * @param envio envío.
     */
    public void mostrarFactura(Envio envio) {

        String factura = crearFacturaEnvio(envio);

        VistaFactura vista = new VistaFactura(this, factura);

        this.setVistaActiva(vista);
        this.refrescarVistaActiva();

    }

    /**
     * Se muestra la pantalla de creación de facturas.
     */
    public void mostrarCrearFactura() {

        VistaCrearFactura vista = new VistaCrearFactura(this, almacen);

        this.setVistaActiva(vista);
        this.refrescarVistaActiva();
    }
    
    /**
     * Se muestra la pantalla de eliminar.
     */
    public void mostrarEliminar() {

        VistaEliminar eliminar = new VistaEliminar(this, almacen);

        this.setVistaActiva(eliminar);
        this.refrescarVistaActiva();
    }
    
    
    /**
     * Se muestra la pantalla de eliminar.
     */
    public void mostrarEliminarProducto(){

        VistaEliminarProducto eliminarProducto = new VistaEliminarProducto(this, almacen);

        this.setVistaActiva(eliminarProducto);
        this.refrescarVistaActiva();
    }

    //Archivos
    /**
     * Dado un objeto java se convierte a json.
     *
     * @param productos Lista de productos que hay en el almacén.
     * @throws IOException IOException
     */
    public void generarJsonProductos(List<ProductoAlmacen> productos) throws IOException {
        File archivo = crearArchivo("productos.json");

        Gson gson = new Gson();

        try(FileWriter fw = new FileWriter(archivo)){
            gson.toJson(productos, fw);    
        }
    }

    public List<ProductoAlmacen> leerJsonProductos() throws IOException {
        File archivo = crearArchivo("productos.json");

        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        Gson gson = new Gson();
        try(FileReader fr = new FileReader(archivo)){
            List<ProductoAlmacen> listaProductosJson = gson.fromJson(fr, new TypeToken<List<ProductoAlmacen>>() {
            }.getType());
            
            if(listaProductosJson == null){
                return new ArrayList<>();
            }
            
            return listaProductosJson;
        }
    }

    public void generarXmlClientes(List<Cliente> clientes) throws IOException, JAXBException {

        File archivo = crearArchivo("clientes.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaClientes.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ListaClientes listaClientes = new ListaClientes(clientes);

        jaxbMarshaller.marshal(listaClientes, archivo);

    }

    public List<Cliente> leerXmlClientes() throws IOException, JAXBException {

        File archivo = crearArchivo("clientes.xml");

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(ListaClientes.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ListaClientes listaClientes = (ListaClientes) jaxbUnmarshaller.unmarshal(archivo);

        return listaClientes.getClientes();

    }

    /**
     * Dado un objeto java se convierte a texto.
     *
     * @param proveedores proveedores
     * @throws IOException IOExeption.
     */
    public void generarTxtProveedores(List<Proveedor> proveedores) throws IOException {

        try (PrintStream out = new PrintStream(crearArchivo("proveedores.txt"))) {

            for (Proveedor proveedor : proveedores) {
                out.printf("%s\t%s\t%s\t%s\t%s\t%s\n",
                        proveedor.getId(),
                        proveedor.getNombre(),
                        proveedor.getDireccion(),
                        proveedor.getTelefono(),
                        proveedor.getEmail(),
                        proveedor.getPersonaContacto());
            }
        }
    }

    public List<Proveedor> leerTxtProveedores() throws IOException {
        File archivo = crearArchivo("proveedores.txt");

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        List<Proveedor> proveedores = new ArrayList<>();
        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] trozos = line.split("\t");

                Proveedor proveedor = new Proveedor(obtenerElemento(trozos, 0), obtenerElemento(trozos, 1), obtenerElemento(trozos, 2), obtenerElemento(trozos, 3), obtenerElemento(trozos, 4), obtenerElemento(trozos, 5));
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }

    private String obtenerElemento(String[] array, int indice) {
        return indice < array.length ? array[indice] : null;
    }

    public void generarBinEnvios(List<Envio> envios) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(crearArchivo("envios.bin"));
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(envios);
        }
    }

    public List<Envio> leerBinEnvios() throws IOException, ClassNotFoundException {
        File archivo = crearArchivo("envios.bin");

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            return (List<Envio>) in.readObject();
        }
    }

    private File crearArchivo(String nombre) throws IOException {
        String carpetaUsuario = System.getProperty("user.home");

        File carpeta = new File(carpetaUsuario, ".almacen");

        if (!carpeta.exists() && !carpeta.mkdir()) {
            throw new IOException("No se pudo crear la carpeta .almacen");
        }
        return new File(carpeta, nombre);
    }

}
