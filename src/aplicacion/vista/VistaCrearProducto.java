package aplicacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Proveedor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

/**
 *
 * @author jonatan
 */
public class VistaCrearProducto implements Vista {

    private final ControladorPrincipal controlador;

    private final JPanel panel;
    private final JTextField txtNombre;
    private final JButton botonGuardar;
    private final JButton botonCancelar;

    /**
     *
     * @param controlador
     */
    public VistaCrearProducto(ControladorPrincipal controlador) {

        this.controlador = controlador;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.txtNombre = new JTextField();
        this.panel.add(this.crearFila("Nombre", txtNombre));

        this.botonGuardar = new JButton("Guardar");
        this.botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProducto();
            }
        });
        this.panel.add(this.botonGuardar);

        this.botonCancelar = new JButton("Cancelar");
        this.botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionCancelar();
            }
        });
        this.panel.add(this.botonCancelar);
    }

    private JPanel crearFila(String nombreLabel, JTextField caja){
        caja.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(caja);
        
        return panel;
    }
    private void accionCrearProducto() {
        String nombre = txtNombre.getText();
        String fabricante = "fabricante1";
        Proveedor proveedor = null;
        double precio = 12.34;
        int unidades = 0;
        this.controlador.crearAnadirProducto(nombre, fabricante, proveedor, precio, unidades);
    }

    private void accionCancelar() {
        this.controlador.mostrarListaProductos();
    }

    /**
     *
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaCrearProducto.refrescar()");
    }

    /**
     *
     * @return
     */
    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }

}
