package aplicacion.vista.creacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Cliente;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.ProductoEnvio;
import aplicacion.vista.Vista;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaCrearEnvio implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JPanel panelListaProductos;
    private final JPanel panelCosas;
    private final JPanel panelBotones;
    private final JList<ProductoAlmacen> listaProductos;
    private final JComboBox<Cliente> comboClientes;
    private final JTextField txtFecha;
    private final JCheckBox cobrado;
    private final JButton botonAnadir;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaCrearEnvio(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        this.panelListaProductos = new JPanel(new BorderLayout());
        panel.add(this.panelListaProductos);

        listaProductos = crearListaProductos();
        panelListaProductos.add("Center", new JScrollPane(listaProductos));
        
        this.panelCosas = new JPanel(new GridLayout(3, 2));
        panelListaProductos.add("East", this.panelCosas);
        
        comboClientes = crearComboClientes();
        this.panelCosas.add(this.crearFila("Cliente", comboClientes));

        this.txtFecha = new JTextField();
        this.panelCosas.add(this.crearFila("Fecha", txtFecha));

        this.cobrado = new JCheckBox("Cobrado");
        panelCosas.add(cobrado);

        this.panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(this.panelBotones);
        
        this.botonAnadir = new JButton("Añadir");
        this.botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAnadirEnvio();
            }
        });
        this.panelBotones.add(this.botonAnadir);

    }

    /**
     * Crea una lista de productos y la devuelve.
     * 
     * @return lista de productos almacen.
     */
    private JList<ProductoAlmacen> crearListaProductos() {

        JList<ProductoAlmacen> lista = new JList<>(new Vector<>(almacen.getProductos()));

        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                ProductoAlmacen productoAlmacen = (ProductoAlmacen) value;

                String texto = String.format("%s (%d uds.)", productoAlmacen.getProducto().getNombre(), productoAlmacen.getStock());
                this.setText(texto);

                return resultado;
            }
        });

        return lista;
    }

    /**
     * Crea un comboBox y lo devuelve.
     * 
     * @return JComboBox.
     */
    private JComboBox<Cliente> crearComboClientes() {

        JComboBox<Cliente> combo = new JComboBox<>(new Vector<>(almacen.getClientes()));
        combo.setMaximumSize(new Dimension(500, 40));

        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Cliente cliente = (Cliente) value;
                this.setText(cliente != null ? cliente.getNombre() : "No existen clientes");

                return resultado;
            }
        });

        return combo;
    }

    /**
     * Crea una etiqueta y junto con un JTextField lo añade al panel
     * 
     * @param nombreLabel
     * @param caja
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JComponent caja) {
        caja.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(caja);

        return panel;
    }

    /**
     * Crea un envío.
     */
    private void accionAnadirEnvio() {
        List<ProductoAlmacen> productosAlmacen = listaProductos.getSelectedValuesList(); //tiene que ser una lista de productos
        String fechaTexto = txtFecha.getText();
        Cliente cliente = (Cliente) comboClientes.getSelectedItem();
        boolean cobrado = this.cobrado.isSelected();

        if (productosAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cliente == null) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<ProductoEnvio> productosEnvio = new ArrayList<>(productosAlmacen.size());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Date fecha;
        try {
            fecha = df.parse(fechaTexto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(panel, "La fecha no tiene el formato correcto (dd/mm/aaaa)", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (ProductoAlmacen productoAlmacen : productosAlmacen) {
            ProductoEnvio productoEnvio = new ProductoEnvio(productoAlmacen.getProducto(), 1);
            productosEnvio.add(productoEnvio);
        }

        this.controlador.crearAnadirEnvio(productosEnvio, fecha, cliente, cobrado);
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaCrearProducto.refrescar()");
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
