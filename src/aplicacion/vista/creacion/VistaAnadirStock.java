package aplicacion.vista.creacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.vista.Vista;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonatan
 */
public class VistaAnadirStock implements Vista{
    
    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JTextField txtCantidad;
    private final JButton botonAnadir;
    private final JList<ProductoAlmacen> listaProductos;

    /**
     * Constructor con parámetros.
     * 
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaAnadirStock(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaProductos = crearListaProductos();
        panel.add(new JScrollPane(listaProductos));
        
        this.txtCantidad = new JTextField();
        this.panel.add(this.crearFila("Cantidad", txtCantidad));

        this.botonAnadir = new JButton("Añadir");
        this.botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAnadirStock();
            }
        });
        this.panel.add(this.botonAnadir);

    }

    /**
     * Devuelve el panel. Dado un nombre, crea una label y la añade al panel junto al JTextField.
     * 
     * @param nombreLabel Nombre de la etiqueta a añadir.
     * @param caja JTextField a añadir.
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JTextField caja) {
        caja.setPreferredSize(new Dimension(200, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(etiqueta);
        panel.add(caja);

        return panel;
    }
    
    /**
     * Devuelve una lista de productosAlmacen.
     * 
     * @return lista de productosAlmacen.
     */
    private JList<ProductoAlmacen> crearListaProductos() {

        JList<ProductoAlmacen> lista = new JList<>(new Vector<>(almacen.getProductos()));

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
     * Añade stock a un producto del almacén.
     */
    private void accionAnadirStock() {
        ProductoAlmacen producto = listaProductos.getSelectedValue();

        int cantidad;

        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "La cantidad no es válida", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(cantidad <= 0) {
            JOptionPane.showMessageDialog(panel, "La cantidad introducida debe ser mayor que 0", "Cantidad no permitida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (producto == null) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.controlador.anadirStock(producto, cantidad);
        txtCantidad.setText("");
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {

        DefaultListModel<ProductoAlmacen> items = new DefaultListModel<>();

        int i=0;
        for(ProductoAlmacen producto : almacen.getProductos()) {
            items.add(i, producto);
            ++i;
        }

        listaProductos.setModel(items);

        System.out.println("aplicacion.vista.VistaAnadirStock.refrescar()");
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
