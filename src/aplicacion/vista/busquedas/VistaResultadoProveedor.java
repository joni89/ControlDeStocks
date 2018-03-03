package aplicacion.vista.busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Proveedor;
import aplicacion.vista.Vista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaResultadoProveedor implements Vista {

    private final ControladorPrincipal controlador;
    private final Proveedor proveedor;

    private final JPanel panel;
    private final JPanel panelBotones;
    private final JLabel nombre;
    private final JLabel id;
    private final JLabel direccion;
    private final JLabel telefono;
    private final JLabel email;
    private final JLabel personaContacto;
    private final JButton botonAceptar;

    /**
     * Se crean los componentes de la vista.
     * 
     * @param controlador controlador
     * @param proveedor  un proveedor
     */
    public VistaResultadoProveedor(ControladorPrincipal controlador, Proveedor proveedor) {

        this.controlador = controlador;
        this.proveedor = proveedor;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.nombre = new JLabel(proveedor.getNombre());
        this.panel.add(this.crearFila("Nombre", nombre));

        this.id = new JLabel(proveedor.getId());
        this.panel.add(this.crearFila("NIF/CIF", id));

        this.direccion = new JLabel(proveedor.getDireccion());
        this.panel.add(this.crearFila("Direccion", direccion));

        this.telefono = new JLabel(proveedor.getTelefono());
        this.panel.add(this.crearFila("Telefono", telefono));

        this.email = new JLabel(proveedor.getEmail());
        this.panel.add(this.crearFila("Email", email));

        this.personaContacto = new JLabel(proveedor.getPersonaContacto() == null ? "" : proveedor.getPersonaContacto());
        this.panel.add(this.crearFila("Persona de contacto", personaContacto));

        this.panelBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        this.panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.panel.add(panelBotones);
        
        this.botonAceptar = new JButton("Aceptar");
        this.botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAceptar();
            }
        });
        this.panelBotones.add(this.botonAceptar);

    }

    /**
     * Crea una etiqueta con otra etiqueta y las añade al panel
     * 
     * @param nombreLabel Descripción del resultado.
     * @param resultado Resultado a mostrar.
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JLabel resultado) {
        resultado.setPreferredSize(new Dimension(300, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        etiqueta.setPreferredSize(new Dimension(150, 20));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(etiqueta);
        panel.add(resultado);

        return panel;
    }

    /**
     * Muestra la vista de buscar producto.
     */
    private void accionAceptar() {
        this.controlador.mostrarBuscarProveedor();
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
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
