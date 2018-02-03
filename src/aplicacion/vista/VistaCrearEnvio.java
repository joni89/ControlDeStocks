package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.ProductoAlmacen;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonatan
 */
public class VistaCrearEnvio implements Vista{
    
    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
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

        this.panel = new JPanel(new GridLayout(3, 1));

        JList<ProductoAlmacen> listaProductos = crearListaProductos();
        panel.add(listaProductos);

        this.botonAnadir = new JButton("Añadir");
        this.botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAnadirEnvio();
            }
        });
        this.panel.add(this.botonAnadir);

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

    private void accionAnadirEnvio() {
        this.controlador.mostrarCrearProducto();
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
