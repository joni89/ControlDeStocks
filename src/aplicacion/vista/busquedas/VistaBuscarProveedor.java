package aplicacion.vista.busquedas;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.Proveedor;
import aplicacion.vista.Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jonatan
 */
public class VistaBuscarProveedor implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JPanel panelListaProveedores;
    private final JPanel panelID;
    private final JPanel panelBotones;
    private final JList<Proveedor> listaProveedores;
    private final JLabel id;
    private final JTextField txtID;
    private final JButton botonBuscar;
    private final JButton botonCancelar;
    /**
     * Constructor con parámetros.
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaBuscarProveedor(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        this.panelListaProveedores = new JPanel(new BorderLayout());
        panel.add(this.panelListaProveedores);

        listaProveedores = crearListaProveedores();
        listaProveedores.setEnabled(false);
        panelListaProveedores.add("Center", new JScrollPane(listaProveedores));
        
        this.panelID = new JPanel(new FlowLayout());
        panelListaProveedores.add("South", this.panelID);
        
        this.id = new JLabel("ID: ");
        this.id.setPreferredSize(new Dimension(100, 20));
        this.panelID.add(id);
        
        this.txtID = new JTextField();
        this.txtID.setPreferredSize(new Dimension(100, 20));
        this.panelID.add(txtID);
        
        this.panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        this.panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(this.panelBotones);

        this.botonBuscar = new JButton("Buscar");
        this.botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBuscarProveedor();
            }
        });
        this.panelBotones.add(this.botonBuscar);

        this.botonCancelar = new JButton("Cancelar");
        this.botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionCancelar();
            }
        });
        this.panelBotones.add(this.botonCancelar);

    }

    /**
     * Devuelve una lista de proveedores.
     * 
     * @return lista de productosAlmacen.
     */
    private JList<Proveedor> crearListaProveedores() {

        JList<Proveedor> lista = new JList<>(new Vector<>(almacen.getProveedores()));

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Proveedor proveedor = (Proveedor) value;

                String texto = String.format("Nombre: %s \t ID: %s", proveedor.getNombre(), proveedor.getId());
                this.setText(texto);

                return resultado;
            }
        });

        return lista;
    }

    /**
     * Añade stock a un producto del almacén.
     */
    private void accionBuscarProveedor() {
        String id = txtID.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Debe introducir un ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.controlador.mostrarResultadoProveedor(id);

    }

    /**
     * Muestra la vista principal.
     */
    private void accionCancelar() {
        this.controlador.mostrarBuscar();
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        System.out.println("aplicacion.vista.VistaBuscarProveedor.refrescar()");
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
