package aplicacion.vista.busquedas;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.Envio;
import aplicacion.modelo.Proveedor;
import aplicacion.vista.Vista;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.JDBCType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class VistaBuscarEnvio implements Vista{
    
    private final ControladorPrincipal controlador;
    private final Almacen almacen;

    private final JPanel panel;
    private final JPanel panelListaEnvio;
    private final JPanel panelID;
    private final JPanel panelBotones;
    private final JList<Envio> listaEnvios;
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
    public VistaBuscarEnvio(ControladorPrincipal controlador, Almacen almacen) {

        this.controlador = controlador;
        this.almacen = almacen;

        this.panel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        this.panelListaEnvio = new JPanel(new BorderLayout());
        panel.add(this.panelListaEnvio);

        listaEnvios = crearListaEnvios();
        listaEnvios.setEnabled(false);
        panelListaEnvio.add("Center", new JScrollPane(listaEnvios));
        
        this.panelID = new JPanel(new FlowLayout());
        panelListaEnvio.add("South", this.panelID);
        
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
                accionBuscarEnvio();
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
     * Devuelve una lista de envios.
     * 
     * @return lista de productosAlmacen.
     */
    private JList<Envio> crearListaEnvios() {

        JList<Envio> lista = new JList<>(new Vector<>(almacen.getEnviosRealizados()));

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component resultado = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Envio envio = (Envio) value;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                String texto = String.format("Fecha %s \t ID: %s", df.format(envio.getFecha()), envio.getId());
                this.setText(texto);

                return resultado;
            }
        });

        return lista;
    }
    
    /**
     * Añade stock a un producto del almacén.
     */
    private void accionBuscarEnvio() {
        String idTexto = txtID.getText();
        if (idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Debe introducir un ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idTexto);
            this.controlador.mostrarResultadoEnvio(id);

        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(panel, "Debe introducir un número", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        System.out.println("aplicacion.vista.VistaBuscarEnvio.refrescar()");
    }

    /**
     * Devuelve el panel.
     * @return el panel.
     */
    @Override
    public JComponent getComponenteRaiz() {
        return this.panel;
    }
}
