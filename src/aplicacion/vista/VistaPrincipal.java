package aplicacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.ProductoAlmacen;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonatan
 */
public class VistaPrincipal implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JList<ProductoAlmacen> listaProductos;
    private final JButton botonNuevoProducto;
    private final JButton botonNuevoCliente;
    private final JButton botonNuevoProveedor;
    private final JButton botonStock;
    private final JButton botonEnvio;
    private final JButton botonFactura;

    /**
     * Constructor
     * 
     * @param controlador Controlador principal
     * @param almacen
     */
    public VistaPrincipal(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaProductos = crearListaProductos();
        panel.add(listaProductos);

        this.botonNuevoProducto = new JButton("Nuevo Producto");
        this.botonNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProducto();
            }
        });
        this.panel.add(this.botonNuevoProducto, 0);

        this.botonNuevoCliente = new JButton("Nuevo Cliente");
        this.botonNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearCliente();
            }
        });
        this.panel.add(this.botonNuevoCliente);

        this.botonNuevoProveedor = new JButton("Nuevo Proveedor");
        this.botonNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProveedor();
            }
        });
        this.panel.add(this.botonNuevoProveedor);

        this.botonStock = new JButton("Añadir stock");
        this.botonStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAnadirStock();
            }
        });
        this.panel.add(this.botonStock);

        this.botonEnvio = new JButton("Nuevo Envío");
        this.botonEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearEnvio();
            }
        });
        this.panel.add(this.botonEnvio);

        this.botonFactura = new JButton("Nueva Factura");
        this.botonFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearFactura();
            }
        });
        this.panel.add(this.botonFactura);
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

                String texto = String.format("%s (%d uds.)", productoAlmacen.getProducto().getNombre(), productoAlmacen.getStock());
                this.setText(texto);

                return resultado;
            }
        });

        return lista;
    }

    private void accionCrearProducto() {
        this.controlador.mostrarCrearProducto();
    }

    private void accionCrearCliente() {
        this.controlador.mostrarCrearCliente();
    }

    private void accionCrearProveedor() {
        this.controlador.mostrarCrearProveedor();
    }

    private void accionAnadirStock() {
        this.controlador.mostrarCrearStock();
    }

    private void accionCrearEnvio() {
        this.controlador.mostrarCrearEnvio();
    }

    private void accionCrearFactura() {
        this.controlador.mostrarCrearFactura();
    }

    /**
     *
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
     *
     * @return
     */
    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }

}
