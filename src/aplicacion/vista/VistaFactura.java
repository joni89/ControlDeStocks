package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import java.awt.Color;
import java.awt.Font;
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
        this.textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.textArea.setEnabled(false);
        this.textArea.setDisabledTextColor(Color.BLACK);
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
