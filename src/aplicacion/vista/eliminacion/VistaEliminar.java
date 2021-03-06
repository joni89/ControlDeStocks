package aplicacion.vista.eliminacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.vista.Vista;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaEliminar implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JButton botonProductos;
    private final JButton botonClientes;
    private final JButton botonProveedores;
    private final JButton botonEnvio;

    /**
     * Constructor para crear los componentes de la vista.
     * 
     * @param controlador Controlador principal
     * @param almacen almacen.
     */
    public VistaEliminar(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(2, 3, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.botonProductos = new JButton("Productos");
        this.botonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarProducto();
            }
        });
        this.panel.add(this.botonProductos, 0);

        this.botonClientes = new JButton("Clientes");
        this.botonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarCliente();
            }
        });
        this.panel.add(this.botonClientes);

        this.botonProveedores = new JButton("Proveedores");
        this.botonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarProveedor();
            }
        });
        this.panel.add(this.botonProveedores);

        this.botonEnvio = new JButton("Envios");
        this.botonEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarEnvio();
            }
        });
        this.panel.add(this.botonEnvio);

    }

    /**
     * Nos lleva a la vista que crea un producto.
     */
    private void accionEliminarProducto() {
        this.controlador.mostrarEliminarProducto();
    }

    /**
     * Nos lleva a la vista que crea un cliente.
     */
    private void accionEliminarCliente() {
        this.controlador.mostrarEliminarCliente();
    }

    /**
     * Nos lleva a la vista que elimina un proveedor.
     */
    private void accionEliminarProveedor() {
        this.controlador.mostrarEliminarProveedor();
    }
    
    /**
     * Nos lleva a la vista que elimina un envío.
     */
    private void accionEliminarEnvio() {
        this.controlador.mostrarEliminarEnvio();
    }

    /**
     * Refresca la vista.
     */
    @Override
    public void refrescar() {
        DefaultListModel<ProductoAlmacen> items = new DefaultListModel<>();
        for(ProductoAlmacen producto : almacen.getProductos()) {
            items.addElement(producto);
        }
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
