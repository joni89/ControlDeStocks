package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.vista.Vista;

/**
 *
 * @author jonatan
 */
public abstract class Controlador {

	private final JFrame ventana;
	private Vista vistaActiva;

	public Controlador() {
		this.ventana = new JFrame();
		this.vistaActiva = null;
	}

	protected JFrame getVentana() {
		return this.ventana;
	}

	protected void setVistaActiva(Vista vista) {
		this.ventana.setContentPane(vista.getComponenteRaiz());
		this.vistaActiva = vista;
	}

	protected void refrescarVistaActiva() {
		if(this.vistaActiva != null) {
			this.vistaActiva.refrescar();
		}
	}

}
