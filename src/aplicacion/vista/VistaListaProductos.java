package aplicacion.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Producto;

/**
 *
 * @author jonatan
 */
public class VistaListaProductos implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JLabel label;
    private final JButton botonCrearProducto;

    /**
     *
     * @param controlador
     * @param almacen
     */
    public VistaListaProductos(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        this.label = new JLabel();
        this.panel.add(this.label);


        this.botonCrearProducto = new JButton("Crear producto");
        this.botonCrearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionCrearProducto();
            }
        });
        this.panel.add(this.botonCrearProducto);

    }


    private void accionCrearProducto() {
        System.out.println("aplicacion.vista.VistaListaProductos.accionCrearProducto()");
        this.controlador.mostrarCrearProducto();
    }

    /**
     *
     */
    @Override
    public void refrescar() {

        // Esta función lee el modelo y lo pinta
        List<Producto> productos = this.almacen.getProductos();

        this.label.setText("Número de productos: " + productos.size());

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
