package aplicacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.ProductoAlmacen;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaPrincipal implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;
    private boolean ordenarProductosPorCantidad;

    private final JPanel panel;
    private final JPanel panelProductos;
    private final JPanel panelBotonesOrdenar;
    private final JPanel panelBotones;

    private final JList<ProductoAlmacen> listaProductos;
    private final JButton botonOrdenarPorNombre;
    private final JButton botonOrdenarPorCantidad;

    private final JButton botonNuevoProducto;
    private final JButton botonNuevoCliente;
    private final JButton botonNuevoProveedor;
    private final JButton botonStock;
    private final JButton botonEnvio;
    private final JButton botonFactura;

    /**
     * Constructor para crear los componentes de la vista.
     * 
     * @param controlador Controlador principal
     * @param almacen almacen.
     */
    public VistaPrincipal(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;
        this.ordenarProductosPorCantidad = false;

        this.panel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.panelProductos = new JPanel(new BorderLayout());
        panel.add(this.panelProductos);

        listaProductos = crearListaProductos();
        panelProductos.add("Center", new JScrollPane(listaProductos));

        this.panelBotonesOrdenar = new JPanel(new FlowLayout());
        panelProductos.add("South", this.panelBotonesOrdenar);

        botonOrdenarPorNombre = new JButton("Ordenar por nombre");
        botonOrdenarPorNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionOrdenarPorNombre();
            }
        });
        panelBotonesOrdenar.add(botonOrdenarPorNombre);

        botonOrdenarPorCantidad = new JButton("Ordenar por cantidad");
        botonOrdenarPorCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionOrdenarPorCantidad();
            }
        });
        panelBotonesOrdenar.add(botonOrdenarPorCantidad);

        this.panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        panel.add(this.panelBotones);

        this.botonNuevoProducto = new JButton("Nuevo Producto");
        this.botonNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProducto();
            }
        });
        this.panelBotones.add(this.botonNuevoProducto, 0);

        this.botonNuevoCliente = new JButton("Nuevo Cliente");
        this.botonNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearCliente();
            }
        });
        this.panelBotones.add(this.botonNuevoCliente);

        this.botonNuevoProveedor = new JButton("Nuevo Proveedor");
        this.botonNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProveedor();
            }
        });
        this.panelBotones.add(this.botonNuevoProveedor);

        this.botonStock = new JButton("Añadir stock");
        this.botonStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAnadirStock();
            }
        });
        this.panelBotones.add(this.botonStock);

        this.botonEnvio = new JButton("Nuevo Envío");
        this.botonEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearEnvio();
            }
        });
        this.panelBotones.add(this.botonEnvio);

        this.botonFactura = new JButton("Nueva Factura");
        this.botonFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearFactura();
            }
        });
        this.panelBotones.add(this.botonFactura);
    }

    /**
     * Devuelve una lista de productosAlmacen.
     * 
     * @return lista de productosAlmacen.
     */
    private JList<ProductoAlmacen> crearListaProductos() {

        JList<ProductoAlmacen> lista = new JList<>();

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
     * Nos lleva a la vista que crea un producto.
     */
    private void accionCrearProducto() {
        this.controlador.mostrarCrearProducto();
    }

    /**
     * Nos lleva a la vista que crea un cliente.
     */
    private void accionCrearCliente() {
        this.controlador.mostrarCrearCliente();
    }

    /**
     * Nos lleva a la vista que crea un proveedor.
     */
    private void accionCrearProveedor() {
        this.controlador.mostrarCrearProveedor();
    }

    /**
     * Nos lleva a la vista que crea el stock.
     */
    private void accionAnadirStock() {
        this.controlador.mostrarCrearStock();
    }

    /**
     * Nos lleva a la vista que crea un envío.
     */
    private void accionCrearEnvio() {
        this.controlador.mostrarCrearEnvio();
    }

    /**
     * Nos lleva a la vista que crea un factura.
     */
    private void accionCrearFactura() {
        this.controlador.mostrarCrearFactura();
    }

    /**
     * Refresca la vista.
     */
    @Override
    public void refrescar() {

        List<ProductoAlmacen> productosOrdenados = new ArrayList<>(almacen.getProductos());

        Collections.sort(productosOrdenados, new Comparator<ProductoAlmacen>() {
            @Override
            public int compare(ProductoAlmacen prod1, ProductoAlmacen prod2) {
                if(ordenarProductosPorCantidad) {
                    return Integer.compare(prod1.getStock(), prod2.getStock());
                } else {
                    return prod1.getProducto().getNombre().compareToIgnoreCase(prod2.getProducto().getNombre());
                }
            }
        });

        DefaultListModel<ProductoAlmacen> items = new DefaultListModel<>();

        for(ProductoAlmacen producto : productosOrdenados) {
            items.addElement(producto);
        }

        listaProductos.setModel(items);

    }

    private void accionOrdenarPorNombre() {
        this.ordenarProductosPorCantidad = false;
        this.refrescar();
    }

    private void accionOrdenarPorCantidad() {
        this.ordenarProductosPorCantidad = true;
        this.refrescar();
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
