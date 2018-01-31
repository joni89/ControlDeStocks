package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Proveedor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonatan
 */
public class VistaCrearClienteProveedor implements Vista{

    private final ControladorPrincipal controlador;

    private final JPanel panel;
    private final JTextField txtNombre;
    private final JTextField txtDireccion;
    private final JTextField txtTelefono;
    private final JTextField txtEmail;
    private final JTextField txtPersonaContacto;
    private final JButton botonGuardar;
    private final JButton botonCancelar;

    /**
     *
     * @param controlador
     */
    public VistaCrearClienteProveedor(ControladorPrincipal controlador) {

        this.controlador = controlador;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.txtNombre = new JTextField();
        this.panel.add(this.crearFila("Nombre", txtNombre));
        
        this.txtDireccion = new JTextField();
        this.panel.add(this.crearFila("Dirección", txtDireccion));
        
        this.txtTelefono = new JTextField();
        this.panel.add(this.crearFila("Teléfono", txtTelefono));
        
        this.txtEmail = new JTextField();
        this.panel.add(this.crearFila("Email", txtEmail));
        
        this.txtPersonaContacto = new JTextField();
        this.panel.add(this.crearFila("Persona de Contacto", txtPersonaContacto));

        this.botonGuardar = new JButton("Guardar");
        this.botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearClienteProveedor();
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
    private void accionCrearClienteProveedor() {
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
        System.out.println("aplicacion.vista.VistaCrearClienteProveedor.refrescar()");
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
