package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private final JButton botonVolver;

    /**
     * Se crean los componentes de la vista.
     * 
     * @param controlador controlador.
     * @param factura factura.
     */
    public VistaFactura(ControladorPrincipal controlador, String factura) {

        this.controlador = controlador;
        this.factura = factura;

        this.panel = new JPanel();

        this.textArea = new JTextArea(factura);
        this.textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.textArea.setEnabled(false);
        this.textArea.setDisabledTextColor(Color.BLACK);
        this.panel.add(this.textArea);


        this.botonVolver = new JButton("Volver");
        this.botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionVolver();
            }

        });
        this.panel.add(this.botonVolver);
    }

    /**
     * Muestra la vista crear factura.
     */
    private void accionVolver() {
        this.controlador.mostrarCrearFactura();
    }
    
    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaCrearProducto.refrescar()");
    }

    /**
     * Devuelve el panel.
     * 
     * @return el panel.
     */
    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }

}
