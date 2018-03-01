package aplicacion.vista.eliminacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Envio;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.vista.Vista;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
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
public class VistaEliminarProducto implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JList<ProductoAlmacen> listaProductos;
    private final JButton botonEliminar;
    private final JButton botonCancelar;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaEliminarProducto(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaProductos = crearListaProductos();
        panel.add(new JScrollPane(listaProductos));

        this.botonEliminar = new JButton("Eliminar");
        this.botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarProducto();
            }
        });
        this.panel.add(this.botonEliminar);

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
     * Gestiona la acción de eliminar un producto.
     */
    private void accionEliminarProducto() {
        List<ProductoAlmacen> productosAlmacen = listaProductos.getSelectedValuesList();

        if (productosAlmacen.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        controlador.eliminarProductosAlmacen(productosAlmacen);
    }

    /**
     * Muestra la vista principal.
     */
    private void accionCancelar() {
        this.controlador.mostrarEliminar();
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        DefaultListModel<ProductoAlmacen> items = new DefaultListModel<>();
        for(ProductoAlmacen producto : almacen.getProductos()) {
            items.addElement(producto);
        }
        listaProductos.setModel(items);
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
