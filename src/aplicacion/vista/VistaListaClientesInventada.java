package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Cliente;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jonatan
 */
public class VistaListaClientesInventada implements VistaComponentes {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JLabel labelTexto;

    public VistaListaClientesInventada(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(1, 1));

        this.labelTexto = new JLabel();
        this.panel.add(this.labelTexto);

    }

    @Override
    public void refrescar() {

        // Esta función lee el modelo y lo pinta

        List<Cliente> clientes  = this.almacen.getClientes();

        this.labelTexto.setText("Número de clientes: " + clientes.size());

    }

    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }
    
}
