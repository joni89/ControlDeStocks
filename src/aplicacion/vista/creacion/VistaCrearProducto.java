package aplicacion.vista.creacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Proveedor;
import aplicacion.vista.Vista;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jonatan
 */
public class VistaCrearProducto implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JTextField txtNombre;
    private final JTextField txtFabricante;
    private final JComboBox<Proveedor> comboProveedores;
    private final JTextField txtPrecio;
    private final JTextField txtCantidad;
    private final JButton botonGuardar;
    private final JButton botonCancelar;

    /**
     * Se crean los componentes de la vista.
     * 
     * @param controlador controlador
     * @param almacen almacen
     */
    public VistaCrearProducto(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.txtNombre = new JTextField();
        this.panel.add(this.crearFila("Nombre", txtNombre));

        this.txtFabricante = new JTextField();
        this.panel.add(this.crearFila("Fabricante", txtFabricante));

        comboProveedores = crearComboProveedores();
        panel.add(comboProveedores);

        this.txtPrecio = new JTextField();
        this.panel.add(this.crearFila("Precio", txtPrecio));

        this.txtCantidad = new JTextField();
        this.panel.add(this.crearFila("Cantidad", txtCantidad));

        this.botonGuardar = new JButton("Guardar");
        this.botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionCrearProducto();
            }
        });
        this.panel.add(this.botonGuardar);

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
     * Crea una etiqueta y junto con un JTextField lo añade al panel
     * 
     * @param nombreLabel
     * @param caja
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
     * Crea un comboBox de proveedores.
     * 
     * @return JCombox de proveedores.
     */
    private JComboBox<Proveedor> crearComboProveedores() {

        JComboBox<Proveedor> combo = new JComboBox<>(new Vector<>(almacen.getProveedores()));
        
        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Proveedor proveedor = (Proveedor) value;
                this.setText(proveedor != null ? proveedor.getNombre() : "No existen proveedores");

                return resultado;
            }
        });

        return combo;
    }

    /**
     * Crea un producto.
     */
    private void accionCrearProducto() {
        String nombre = txtNombre.getText();
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(this.panel, "Introduzca nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fabricante = txtFabricante.getText();
        Proveedor proveedor = (Proveedor)comboProveedores.getSelectedItem();
        double precio;

        try{
            precio = Double.parseDouble(txtPrecio.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this.panel, "Formato de precio no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int unidades;

        try{
            unidades = Integer.parseInt(txtCantidad.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this.panel, "Formato de cantidad no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.controlador.crearAnadirProducto(nombre, fabricante, proveedor, precio, unidades);
    }

    /**
     * Muestra la vista principal.
     */
    private void accionCancelar() {
        this.controlador.mostrarVistaPrincipal();
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaCrearProducto.refrescar()");
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
