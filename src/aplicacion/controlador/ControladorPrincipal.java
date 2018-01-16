package aplicacion.controlador;

import aplicacion.modelo.Almacen;
import aplicacion.modelo.estado.EstadoApplicacion;
import aplicacion.modelo.estado.Pantalla;
import aplicacion.vista.VistaVentanaPrincipal;

/**
 *
 * @author jonatan
 */
public class ControladorPrincipal extends Controlador {

    private final Almacen almacen;
    private final EstadoApplicacion estado;
    private final VistaVentanaPrincipal vista;

    public ControladorPrincipal() {
        this.almacen = new Almacen();
        this.estado = new EstadoApplicacion();
        this.vista = new VistaVentanaPrincipal(this, this.estado, this.almacen);
    }

    public void iniciarApp() {
        this.estado.setPantallaActual(Pantalla.LISTA_PRODUCTOS);
        refrescar(this.vista);
    }

    public void verClientes(){
        this.estado.setPantallaActual(Pantalla.LISTA_CLIENTES);
        refrescar(vista);

    }

}
