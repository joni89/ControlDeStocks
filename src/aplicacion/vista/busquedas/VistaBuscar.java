package aplicacion.vista.busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.vista.Vista;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaBuscar implements Vista {

    private final ControladorPrincipal controlador;

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
    public VistaBuscar(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;

        this.panel = new JPanel(new GridLayout(2, 3, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.botonProductos = new JButton("Productos");
        this.botonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBuscarProducto();
            }
        });
        this.panel.add(this.botonProductos, 0);

        this.botonClientes = new JButton("Clientes");
        this.botonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBuscarCliente();
            }
        });
        this.panel.add(this.botonClientes);

        this.botonProveedores = new JButton("Proveedores");
        this.botonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBuscarProveedor();
            }
        });
        this.panel.add(this.botonProveedores);

        this.botonEnvio = new JButton("Envios");
        this.botonEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBuscarEnvio();
            }
        });
        this.panel.add(this.botonEnvio);

    }

    /**
     * Nos lleva a la vista que crea un producto.
     */
    private void accionBuscarProducto() {
        this.controlador.mostrarBuscarProducto();
    }

    /**
     * Nos lleva a la vista que crea un cliente.
     */
    private void accionBuscarCliente() {
        this.controlador.mostrarBuscarCliente();
    }

    /**
     * Nos lleva a la vista que elimina un proveedor.
     */
    private void accionBuscarProveedor() {
        this.controlador.mostrarBuscarProveedor();
    }
    
    /**
     * Nos lleva a la vista que elimina un envío.
     */
    private void accionBuscarEnvio() {
        this.controlador.mostrarBuscarEnvio();
    }

    /**
     * Refresca la vista.
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
