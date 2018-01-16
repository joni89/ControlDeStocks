package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author jonatan
 */
public class VistaListaProductos implements VistaComponentes {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JLabel label;
    private final JButton boton;

    public VistaListaProductos(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(2, 1));

        this.label = new JLabel();
        this.panel.add(this.label);

        this.boton = new JButton("Ver clientes");
        this.panel.add(this.boton);

        this.boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controlador.verClientes();
            }
        });

    }

    @Override
    public void refrescar() {

        // Esta función lee el modelo y lo pinta

        List<Producto> productos = this.almacen.getProductos();

        this.label.setText("Número de productos: " + productos.size());

    }

    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }
    
}
