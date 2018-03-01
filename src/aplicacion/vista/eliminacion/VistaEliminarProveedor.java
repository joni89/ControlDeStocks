package aplicacion.vista.eliminacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Proveedor;
import aplicacion.vista.Vista;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jonatan
 */
public class VistaEliminarProveedor implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JList<Proveedor> listaProveedores;
    private final JButton botonEliminar;
    private final JButton botonCancelar;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaEliminarProveedor(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaProveedores = crearListaProveedores();
        panel.add(new JScrollPane(listaProveedores));

        this.botonEliminar = new JButton("Eliminar");
        this.botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarProveedor();
            }
        });
        this.panel.add(this.botonEliminar);

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
     * Crea una lista de proveedores y la devuelve.
     * 
     * @return lista de proveedores.
     */
    private JList<Proveedor> crearListaProveedores() {

        JList<Proveedor> lista = new JList<>();

        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Proveedor proveedor = (Proveedor) value;
                this.setText(proveedor != null ? proveedor.getNombre() : "No existen proveedores");

                return resultado;
            }
        });

        return lista;
    }

    /**
     * Gestiona la acción de eliminar un proveedor.
     */
    private void accionEliminarProveedor() {
        Proveedor proveedor = listaProveedores.getSelectedValue();

        if (proveedor == null) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        controlador.eliminarProveedor(proveedor);
    }

    /**
     * Muestra la vista principal.
     */
    private void accionCancelar() {
        this.controlador.mostrarEliminar();
    }

    /**
     * Devuevle un mensaje.
     */
    @Override
    public void refrescar() {
        DefaultListModel<Proveedor> items = new DefaultListModel<>();
        for(Proveedor proveedor : almacen.getProveedores()) {
            items.addElement(proveedor);
        }
        listaProveedores.setModel(items);
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
