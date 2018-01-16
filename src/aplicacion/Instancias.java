package aplicacion;

import aplicacion.controlador.ControladorPrincipal;
import aplicacion.modelo.Almacen;
import aplicacion.vista.VistaPrincipal;

/**
 *
 * @author jonatan
 */
public class Instancias {

    // Modelo
    private final Almacen almacen;

    // Componentes (vistas y controladores)
    private final ControladorPrincipal controladorPrincipal;
    private final VistaPrincipal vistaPrincipal;

    public Instancias() {

        almacen = new Almacen();

        controladorPrincipal = new ControladorPrincipal();

        vistaPrincipal = new VistaPrincipal();

    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }

    public VistaPrincipal getVistaPrincipal() {
        return vistaPrincipal;
    }

}
