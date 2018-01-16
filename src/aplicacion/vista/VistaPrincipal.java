package aplicacion.vista;

import aplicacion.Instancias;
import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jonatan
 */
public class VistaPrincipal implements Vista {

    private ControladorPrincipal controlador;
    private Almacen almacen;

    private JFrame ventana;
    private JTextField cajaTexto;
    private JLabel labelTexto;

    @Override
    public void inicializar(Instancias instancias) {

        controlador = instancias.getControladorPrincipal();
        almacen = instancias.getAlmacen();

        cajaTexto = new JTextField();
        cajaTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                controlador.accionUsuario("a", "b");
            }
        });

        labelTexto = new JLabel();

        ventana = new JFrame("Mayúsculas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.getContentPane().setLayout(new GridLayout(2, 1));
        ventana.getContentPane().add(cajaTexto);
        ventana.getContentPane().add(labelTexto);

        ventana.setVisible(true);

        refrescar();

    }

    @Override
    public void refrescar() {

        // Esta función lee el modelo y lo pinta

//        String texto = almacen.getTexto();
//        labelTexto.setText(texto);

    }
    
}
