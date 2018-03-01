package aplicacion.vista.busquedas;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.vista.Vista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonatan
 */
public class VistaBuscarProveedor implements Vista {

    private final ControladorPrincipal controlador;

    private final JPanel panel;
    private final JTextField txtID;
    private final JButton botonBuscar;
    private final JButton botonCancelar;

    /**
     * Constructor con parámetros.
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaBuscarProveedor(ControladorPrincipal controlador) {

        this.controlador = controlador;

        this.panel = new JPanel(new GridLayout(3, 1));

        this.txtID = new JTextField();
        this.panel.add(this.crearFila("ID", txtID));

        this.botonBuscar = new JButton("Buscar");
        this.botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBuscarProveedor();
            }
        });
        this.panel.add(this.botonBuscar);

        this.botonCancelar = new JButton("Cancelar");
        this.botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionCancelar();
            }
        });
        this.panel.add(this.botonCancelar);

    }

    /**
     * Devuelve el panel. Dado un nombre, crea una label y la añade al panel
     * junto al JTextField.
     *
     * @param nombreLabel Nombre de la etiqueta a añadir.
     * @param caja JTextField a añadir.
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JTextField caja) {
        caja.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(caja);

        return panel;
    }

    /**
     * Añade stock a un producto del almacén.
     */
    private void accionBuscarProveedor() {
        String id = txtID.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Debe introducir un ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.controlador.mostrarResultadoProveedor(id);

    }

    /**
     * Muestra la vista principal.
     */
    private void accionCancelar() {
        this.controlador.mostrarBuscar();
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaBuscarProveedor.refrescar()");
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
