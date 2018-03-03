package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaFactura implements Vista {

    private final ControladorPrincipal controlador;
    private final String factura;

    private final JPanel panel;
    private final JPanel panelFactura;
    private final JPanel panelBotones;
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

        this.panel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        this.panelFactura = new JPanel(new BorderLayout());
        panel.add(this.panelFactura);

        this.textArea = new JTextArea(factura);
        this.textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.textArea.setEnabled(false);
        this.textArea.setDisabledTextColor(Color.BLACK);
        this.panelFactura.add(this.textArea);

        this.panelBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.panelBotones.setBorder(new EmptyBorder(40, 50, 80, 50));
        this.panel.add(panelBotones);

        this.botonVolver = new JButton("Volver");
        this.botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionVolver();
            }

        });
        this.panelBotones.add(this.botonVolver);
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
