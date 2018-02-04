package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Cliente;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.Proveedor;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonatan
 */
public class VistaCrearEnvio implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JList<ProductoAlmacen> listaProductos;
    JComboBox<Cliente> comboClientes;
    private final JTextField txtFecha;
    private final JCheckBox cobrado;
    private final JTextField txtCosteEnvio;
    private final JButton botonAnadir;
    private final JButton botonCancelar;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaCrearEnvio(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaProductos = crearListaProductos();
        panel.add(listaProductos);

        this.txtFecha = new JTextField();
        this.panel.add(this.crearFila("Fecha", txtFecha));

        comboClientes = crearComboClientes();
        panel.add(comboClientes);

        this.cobrado = new JCheckBox("Cobrado");
        panel.add(cobrado);

        this.txtCosteEnvio = new JTextField();
        this.panel.add(this.crearFila("Coste de envío", txtCosteEnvio));

        this.botonAnadir = new JButton("Añadir");
        this.botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAnadirEnvio();
            }
        });
        this.panel.add(this.botonAnadir);

        this.botonCancelar = new JButton("Cancelar");
        this.botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionCancelar();
            }
        });
        this.panel.add(this.botonCancelar);

    }

    private JList<ProductoAlmacen> crearListaProductos() {

        JList<ProductoAlmacen> lista = new JList<>(new Vector<>(almacen.getProductos()));

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Esto se hace para mostrar el nombre del producto en la lista (sino, por defecto mostraría "Producto@1234...")
        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                ProductoAlmacen productoAlmacen = (ProductoAlmacen) value;
                this.setText(productoAlmacen.getProducto().getNombre());

                return resultado;
            }
        });

        return lista;
    }

    private JComboBox<Cliente> crearComboClientes() {

        JComboBox<Cliente> combo = new JComboBox<>(new Vector<>(almacen.getClientes()));

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

    private JPanel crearFila(String nombreLabel, JTextField caja) {
        caja.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(caja);

        return panel;
    }

    private void accionAnadirEnvio() {
        ProductoAlmacen productoAlmacen = listaProductos.getSelectedValue(); //tiene que ser una lista de productos
        String fecha = txtFecha.getText();
        Cliente cliente = (Cliente) comboClientes.getSelectedItem();
        boolean cobrado = this.cobrado.isSelected();
        double coste = Double.parseDouble(txtCosteEnvio.getText());
        //this.controlador.crearAnadirEnvio(productos, fecha, cliente, cobrado, coste);
    }

    private void accionCancelar() {
        this.controlador.mostrarListaPrincipal();
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
