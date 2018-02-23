package aplicacion.vista.creacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Envio;
import aplicacion.vista.Vista;
import java.awt.Component;
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

/**
 *
 * @author jonatan
 */
public class VistaCrearFactura implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JList<Envio> listaEnvios;
    private final JButton botonCrear;
    private final JButton botonCancelar;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaCrearFactura(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaEnvios = crearListaEnvios();
        panel.add(new JScrollPane(listaEnvios));

        this.botonCrear = new JButton("Crear factura");
        this.botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearFactura();
            }
        });
        this.panel.add(this.botonCrear);

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
     * Muestra la vista principal.
     */
    private void accionCancelar() {
        this.controlador.mostrarVistaPrincipal();
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
