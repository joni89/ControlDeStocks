package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;
import aplicacion.modelo.Cliente;
import aplicacion.modelo.Proveedor;
import aplicacion.modelo.Envio;
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

	public ControladorPrincipal() {
		this.almacen = new Almacen();
		this.vistaListaProductos = new VistaListaProductos(this, this.almacen);
		this.vistaListaClientes = new VistaListaClientesInventada(this, this.almacen);
	}

	public void iniciarApp() {

		JFrame ventana = this.getVentana();
		ventana.setTitle("Control de Stocks");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(500, 400);
		ventana.setVisible(true);

		this.verProductos();

	}
        
        //Productos
        
        public void crearProducto() {
                //Coger variables de los componentes swing y devolver dicho producto
		Producto productoVacio = new Producto();
		this.almacen.getProductos().add(productoVacio);

		this.refrescarVistaActiva();
	}
        
        private void añadirProductoAlmacen(Producto producto){
            
        }
        
        public void crearAñadirProducto(){
//            Producto producto = crearProducto();
//            añadirProductoAlmacen(producto);
        }
        
        public void eliminarProducto(Producto producto){
            //restar stock
        }

	public void verProductos() {
		this.setVistaActiva(this.vistaListaProductos);
		this.refrescarVistaActiva();
	}
        
        //Clientes
        
        public void crearCliente() {
                //Coger variables de los componentes swing y devolver dicho cliente
		Cliente clienteVacio = new Cliente();

		this.refrescarVistaActiva();
	}
        
        private void añadirCliente(Cliente cliente){
            
        }
        
        public void crearAñadirCliente(){
//            Cliente cliente = crearCliente();
//            añadirCliente(cliente);
        }
        
        public void eliminarCliente(Cliente cliente){
            
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
        
        private void añadirProveedor(Proveedor proveedor){
            
        }
        
        public void crearAñadirProveedor(){
//            Proveedor proveedor = crearProveedor();
//            añadirProveedor(proveedor);
        }
        
        public void eliminarProveedor(Proveedor proveedor){
            
        }
        
        //Envio
        
        public void crearEnvio() {
                //Coger variables de los componentes swing y devolver dicho envio
		Envio envioVacio = new Envio();

		this.refrescarVistaActiva();
	}
        
        private void añadirEnvio(Envio envio){
            
        }
        
        public void crearAñadirEnvio(){
//            Envio envio = crearEnvio();
//            añadirEnvio(envio);
        }
        
        public void eliminarEnvio(Envio envio){
            
        }
}
