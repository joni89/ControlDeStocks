package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jonatan
 */
public class VistaFactura implements Vista {

    private final ControladorPrincipal controlador;
    private final String factura;

    private final JPanel panel;
    private final JTextArea textArea;

    public VistaFactura(ControladorPrincipal controlador, String factura) {

        this.controlador = controlador;
        this.factura = factura;

        this.panel = new JPanel();

        this.textArea = new JTextArea(factura);
        this.panel.add(this.textArea);

    }

    @Override
    public void refrescar() {

    }

    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }

}
