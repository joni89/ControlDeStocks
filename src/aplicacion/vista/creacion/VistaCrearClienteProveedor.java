package aplicacion.vista.creacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Proveedor;
import aplicacion.vista.Vista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaCrearClienteProveedor implements Vista{

    private final ControladorPrincipal controlador;
    private final boolean proveedor;

    private final JPanel panel;
    private final JPanel panelBotones;
    private final JTextField txtNombre;
    private final JTextField txtId;
    private final JTextField txtDireccion;
    private final JTextField txtTelefono;
    private final JTextField txtEmail;
    private final JTextField txtPersonaContacto;
    private final JButton botonGuardar;

    /**
     *Crea todos los componentes de la vista.
     * 
     * @param controlador controlador.
     * @param proveedor proveedor.
     */
    public VistaCrearClienteProveedor(ControladorPrincipal controlador, boolean proveedor) {

        this.controlador = controlador;
        this.proveedor = proveedor;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.txtNombre = new JTextField();
        this.panel.add(this.crearFila("Nombre", txtNombre));

        this.txtId = new JTextField();
        this.panel.add(this.crearFila("CIF/NIF", txtId));
        
        this.txtDireccion = new JTextField();
        this.panel.add(this.crearFila("Dirección", txtDireccion));
        
        this.txtTelefono = new JTextField();
        this.panel.add(this.crearFila("Teléfono", txtTelefono));
        
        this.txtEmail = new JTextField();
        this.panel.add(this.crearFila("Email", txtEmail));
        
        this.txtPersonaContacto = new JTextField();
        this.panel.add(this.crearFila("Persona de Contacto", txtPersonaContacto));
        
        this.panelBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.panel.add(panelBotones);

        this.botonGuardar = new JButton("Guardar");
        this.botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearClienteProveedor();
            }
        });
        this.panelBotones.add(this.botonGuardar);

    }

    /**
     * Crea una etiqueta y junto con un JTextField lo añade al panel
     * 
     * @param nombreLabel
     * @param caja
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JTextField caja){
        caja.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        etiqueta.setPreferredSize(new Dimension(150, 20));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        panel.add(etiqueta);
        panel.add(caja);

        
        return panel;
    }
    
    /**
     * Crea cliente o proveedor.
     */
    private void accionCrearClienteProveedor() {
        String nombre = txtNombre.getText();
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(this.panel, "Introduzca nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String id = txtId.getText();
        if(!id.matches("^\\d{8}[A-Za-z]$")){
            JOptionPane.showMessageDialog(this.panel, "CIF/NIF debe constar de 8 número y una letra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        if(!telefono.matches("^(\\+\\d+ ?)?\\d+$")){
            JOptionPane.showMessageDialog(this.panel, "Formato de teléfono no valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String email = txtEmail.getText();
        if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            JOptionPane.showMessageDialog(this.panel, "Formato de email no valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String personaContacto = txtPersonaContacto.getText();

        if(this.proveedor) {
            this.controlador.crearAnadirProveedor(id, nombre, direccion, telefono, email, personaContacto);
        } else {
            this.controlador.crearAnadirCliente(id, nombre, direccion, telefono, email, personaContacto);
        }

    }

    /**
     * Saca un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaCrearClienteProveedor.refrescar()");
    }

    /**
     * Devuelve el panel.
     * @return el panel.
     */
    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }
    
}
