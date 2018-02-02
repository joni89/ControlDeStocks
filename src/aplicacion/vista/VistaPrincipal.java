package aplicacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Proveedor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

/**
 *
 * @author jonatan
 */
public class VistaPrincipal implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final TextArea cajaInfo;
    private final JButton botonNuevoProducto;
    private final JButton botonNuevoCliente;
    private final JButton botonNuevoProveedor;
    private final JButton botonStock;
    private final JButton botonEnvio;
    private final JButton botonFactura;

    /**
     *
     * @param controlador
     */
    public VistaPrincipal(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        this.cajaInfo = new TextArea();
        this.panel.add(this.cajaInfo);

        this.botonNuevoProducto = new JButton("Nuevo Producto");
        this.botonNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProducto();
            }
        });
        this.panel.add(this.botonNuevoProducto);

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
        this.controlador.mostrarFactura(null); //TODO no le puedo pasar null
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
