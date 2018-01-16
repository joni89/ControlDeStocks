package aplicacion.vista;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.modelo.estado.EstadoApplicacion;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author jonatan
 */
public class VistaVentanaPrincipal implements Vista {

    private final ControladorPrincipal controlador;
    private final EstadoApplicacion estado;
    private final Almacen almacen;

    private final VistaListaProductos listaProductos;
    private final VistaListaClientesInventada listaClientes;

    private VistaComponentes vistaActual;

    private final JFrame ventana;

    public VistaVentanaPrincipal(ControladorPrincipal controlador, EstadoApplicacion estado, Almacen almacen) {

        this.controlador = controlador;
        this.estado = estado;
        this.almacen = almacen;

        this.listaProductos = new VistaListaProductos(this.controlador, this.almacen);
        this.listaClientes = new VistaListaClientesInventada(this.controlador, this.almacen);

        this.ventana = new JFrame("Mayúsculas");
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana.setSize(500, 400);
        this.ventana.getContentPane().setLayout(new GridLayout(1, 1));

        this.setVistaActual(this.listaProductos);

    }

    private void setVistaActual(VistaComponentes nuevaVistaActual) {
        nuevaVistaActual.refrescar();
        ventana.setContentPane(nuevaVistaActual.getComponenteRaiz());
        this.vistaActual = nuevaVistaActual;
    }

    // TODO temporal
    private void refrescarVistaActual() {

        switch(estado.getPantallaActual()) {
            case LISTA_PRODUCTOS:
                setVistaActual(this.listaProductos);
                break;
            case LISTA_CLIENTES:
                setVistaActual(this.listaClientes);
                break;
        }

        this.vistaActual.refrescar();
    }

    @Override
    public void refrescar() {

        if(!ventana.isVisible()) {
            ventana.setVisible(true);
        }

        this.refrescarVistaActual();

    }
    
}
