package aplicacion.vista.busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Envio;
import aplicacion.modelo.ProductoEnvio;
import aplicacion.vista.Vista;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaResultadoEnvio implements Vista {

    private final ControladorPrincipal controlador;
    private final Envio envio;

    private final JPanel panel;
    private final JPanel panelListaProductosEnvio;
    private final JPanel panelCosas;
    private final JPanel panelBotones;
    private final JList<ProductoEnvio> listaProductos;
    private final JLabel clientes;
    private final JLabel txtFecha;
    private final JLabel cobrado;
    private final JButton botonAceptar;

    /**
     * Se crean los componentes de la vista.
     * 
     * @param controlador un controlador
     * @param envio un envío
     */
    public VistaResultadoEnvio(ControladorPrincipal controlador, Envio envio) {

        this.controlador = controlador;
        this.envio = envio;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.panelListaProductosEnvio = new JPanel(new BorderLayout());
        panel.add(this.panelListaProductosEnvio);
        
        this.listaProductos = crearListaProductos();
        panelListaProductosEnvio.add("Center", new JScrollPane(listaProductos));
        
        this.panelCosas = new JPanel(new GridLayout(3, 2));
        panelListaProductosEnvio.add("East", this.panelCosas);
        
        this.clientes = new JLabel(envio.getCliente().getNombre());
        this.panelCosas.add(this.crearFila("Cliente", clientes));

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.txtFecha = new JLabel(df.format(envio.getFecha()));
        this.panelCosas.add(this.crearFila("Fecha", txtFecha));

        this.cobrado = new JLabel(envio.getCobrado() ? "Cobrado" : "No cobrado");
        this.panelCosas.add(this.crearFila("Estado", cobrado));
        
        this.panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        this.panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(this.panelBotones);

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
     * @param componente componente a mostrar.
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JLabel componente) {
        componente.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(componente);

        return panel;
    }

    /**
     * Crea una lista de productos y la devuelve.
     * 
     * @return lista de productos envío.
     */
    private JList<ProductoEnvio> crearListaProductos() {

        JList<ProductoEnvio> lista = new JList<>(new Vector<>(envio.getProductos()));

        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                ProductoEnvio productoEnvio = (ProductoEnvio) value;

                String texto = String.format("%s (%d uds.)", productoEnvio.getProducto().getNombre(), productoEnvio.getCantidad());
                this.setText(texto);

                return resultado;
            }
        });

        return lista;
    }
    
    /**
     * Muestra la vista de buscar producto.
     */
    private void accionAceptar() {
        this.controlador.mostrarBuscarEnvio();
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
