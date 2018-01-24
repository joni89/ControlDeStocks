package aplicacion.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Cliente;

/**
 *
 * @author jonatan
 */
public class VistaListaClientesInventada implements Vista {

	private final ControladorPrincipal controlador;
	private final Almacen almacen;

	private final JPanel panel;
	private final JLabel labelTexto;
	private JButton botonVolver;

	public VistaListaClientesInventada(ControladorPrincipal controlador, Almacen almacen) {

		this.controlador = controlador;
		this.almacen = almacen;

		this.panel = new JPanel(new GridLayout(2, 1));

		this.labelTexto = new JLabel();
		this.panel.add(this.labelTexto);

		this.botonVolver = new JButton("Volver");
		this.botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionVolver();
			}
		});
		this.panel.add(this.botonVolver);

	}

	private void accionVolver() {
		this.controlador.mostrarListaProductos();
	}

	@Override
	public void refrescar() {

		// Esta función lee el modelo y lo pinta

		List<Cliente> clientes = this.almacen.getClientes();

		this.labelTexto.setText("Número de clientes: " + clientes.size());

	}

	@Override
	public JComponent getComponenteRaiz() {
		return this.panel;
	}

}
