package aplicacion.vista.busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.vista.Vista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaResultadoProducto implements Vista {

    private final ControladorPrincipal controlador;
    private final ProductoAlmacen producto;

    private final JPanel panel;
    private final JPanel panelBotones;
    private final JLabel nombre;
    private final JLabel fabricante;
    private final JLabel proveedor;
    private final JLabel precio;
    private final JLabel stock;
    private final JButton botonAceptar;

    /**
     * Se crean los componentes de la vista.
     * 
     * @param controlador el controlador
     * @param producto un producto
     */
    public VistaResultadoProducto(ControladorPrincipal controlador, ProductoAlmacen producto) {

        this.controlador = controlador;
        this.producto = producto;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.nombre = new JLabel(producto.getProducto().getNombre());
        this.panel.add(this.crearFila("Nombre", nombre));

        this.fabricante = new JLabel(producto.getProducto().getFabricante());
        this.panel.add(this.crearFila("Fabricante", fabricante));

        String nombreProveedor;
        if(producto.getProducto().getProveedor() != null) {
            nombreProveedor = producto.getProducto().getProveedor().getNombre();
        } else {
            nombreProveedor = "";
        }

        this.proveedor = new JLabel(nombreProveedor);
        this.panel.add(this.crearFila("Proveedor", proveedor));

        this.precio = new JLabel(Double.toString(producto.getProducto().getPrecio()));
        this.panel.add(this.crearFila("Precio", precio));

        this.stock = new JLabel(Integer.toString(producto.getStock()));
        this.panel.add(this.crearFila("Cantidad", stock));
        
        this.panelBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.panel.add(panelBotones);

        this.botonAceptar = new JButton("Aceptar");
        this.botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionAceptar();
            }
        });
        this.panelBotones.add(this.botonAceptar);

    }

    /**
     * Crea una etiqueta con otra etiqueta y las añade al panel
     * 
     * @param nombreLabel Descripción del resultado.
     * @param resultado Resultado a mostrar.
     * @return panel
     */
    private JPanel crearFila(String nombreLabel, JComponent resultado) {
        resultado.setPreferredSize(new Dimension(300, 20));
        JLabel etiqueta = new JLabel(nombreLabel + ":");
        etiqueta.setPreferredSize(new Dimension(100, 20));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(etiqueta);
        panel.add(resultado);

        return panel;
    }

    /**
     * Muestra la vista de buscar producto.
     */
    private void accionAceptar() {
        this.controlador.mostrarBuscarProducto();
    }

    /**
     * Devuevle un mensaje.
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
