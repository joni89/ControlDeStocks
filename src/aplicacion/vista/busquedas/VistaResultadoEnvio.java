package aplicacion.vista.busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Envio;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.ProductoEnvio;
import aplicacion.vista.Vista;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonatan
 */
public class VistaResultadoEnvio implements Vista {

    private final ControladorPrincipal controlador;
    private final Envio envio;

    private final JPanel panel;
    private final JList<ProductoEnvio> listaProductos;
    private final JLabel clientes;
    private final JLabel txtFecha;
    private final JLabel cobrado;
    private final JButton botonAceptar;

    /**
     * Se crean los componentes de la vista.
     * 
     * @param controlador controlador
     * @param envio
     */
    public VistaResultadoEnvio(ControladorPrincipal controlador, Envio envio) {

        this.controlador = controlador;
        this.envio = envio;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.listaProductos = crearListaProductos();
        panel.add(new JScrollPane(listaProductos));
        
        this.clientes = new JLabel(envio.getCliente().getNombre());
        this.panel.add(this.crearFila("Cliente", clientes));

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.txtFecha = new JLabel(df.format(envio.getFecha()));
        this.panel.add(this.crearFila("Fecha", txtFecha));

        this.cobrado = new JLabel(envio.getCobrado() ? "Cobrado" : "No cobrado");
        this.panel.add(this.crearFila("Cobrado", cobrado));

        this.botonAceptar = new JButton("Aceptar");
        this.botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAceptar();
            }
        });
        this.panel.add(this.botonAceptar);

    }

    /**
     * Crea una etiqueta con otra etiqueta y las añade al panel
     * 
     * @param nombreLabel Descripción del resultado.
     * @param resultado Resultado a mostrar.
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JLabel resultado) {
        resultado.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(resultado);

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
