package aplicacion.vista.eliminacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Cliente;
import aplicacion.vista.Vista;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
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
public class VistaEliminarCliente implements Vista {

    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JList<Cliente> listaClientes;
    private final JButton botonEliminar;
    private final JButton botonCancelar;

    /**
     * Constructor
     *
     * @param controlador Controlador principal
     * @param almacen Almacen
     */
    public VistaEliminarCliente(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(3, 1));

        listaClientes = crearListaClientes();
        panel.add(new JScrollPane(listaClientes));

        this.botonEliminar = new JButton("Eliminar");
        this.botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionEliminarCliente();
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
     * Crea una lista de clientes y la devuelve.
     * 
     * @return lista de clientes.
     */
    private JList<Cliente> crearListaClientes() {

        JList<Cliente> lista = new JList<>(new Vector<>(almacen.getClientes()));

        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Cliente cliente = (Cliente) value;

                this.setText(cliente != null ? cliente.getNombre() : "No existen clientes");

                return resultado;
            }
        });

        return lista;
    }

    /**
     * Gestiona la acción de eliminar un cliente.
     */
    private void accionEliminarCliente() {
        Cliente cliente = listaClientes.getSelectedValue();

        if (cliente == null) {
            JOptionPane.showMessageDialog(panel, "Debe seleccionar algún cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
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
        System.out.println("aplicacion.vista.VistaEliminarCliente.refrescar()");
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
