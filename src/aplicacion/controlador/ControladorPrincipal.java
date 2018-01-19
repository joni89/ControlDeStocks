package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;
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

	public void verProductos() {
		this.setVistaActiva(this.vistaListaProductos);
		this.refrescarVistaActiva();
	}

	public void verClientes() {
		this.setVistaActiva(this.vistaListaClientes);
		this.refrescarVistaActiva();
	}

	public void simularCrearProducto() {

		Producto productoVacio = new Producto();
		this.almacen.getProductos().add(productoVacio);

		this.refrescarVistaActiva();

	}

}
