package aplicacion.vista.creacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Envio;
import aplicacion.vista.Vista;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaCrearFactura implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JPanel panelListaEnvios;
    private final JPanel panelBotones;
    private final JList<Envio> listaEnvios;
    private final JButton botonCrear;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaCrearFactura(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        this.panelListaEnvios = new JPanel(new BorderLayout());
        panel.add(this.panelListaEnvios);

        listaEnvios = crearListaEnvios();
        panelListaEnvios.add(new JScrollPane(listaEnvios));

        this.panelBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.panelBotones.setBorder(new EmptyBorder(40, 50, 80, 50));
        this.panel.add(panelBotones);
        
        this.botonCrear = new JButton("Crear factura");
        this.botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearFactura();
            }
        });
        this.panelBotones.add(this.botonCrear);

    }

    /**
     * Crea una lista de envíos y la devuelve.
     * 
     * @return lista de envíos.
     */
    private JList<Envio> crearListaEnvios() {

        JList<Envio> lista = new JList<>(new Vector<>(almacen.getEnviosRealizados()));

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Envio envio = (Envio) value;

                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                String texto = String.format("#%d %s (%s)", envio.getId(), envio.getCliente().getNombre(), df.format(envio.getFecha()));
                this.setText(texto);

                return resultado;
            }
        });

        return lista;
    }

    /**
     * Crea una factura.
     */
    private void accionCrearFactura() {
        Envio envio = listaEnvios.getSelectedValue();

        if (envio == null) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún envío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        controlador.mostrarFactura(envio);
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaCrearFactura.refrescar()");
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
