package aplicacion.controlador;

import aplicacion.Instancias;
import aplicacion.modelo.Almacen;
import aplicacion.vista.VistaPrincipal;

/**
 *
 * @author jonatan
 */
public class ControladorPrincipal extends Controlador {

    private Almacen almacen;
    private VistaPrincipal vista;

    @Override
    public void inicializar(Instancias instancias) {
        almacen = instancias.getAlmacen();
        vista = instancias.getVistaPrincipal();
    }

    public void accionUsuario(String parametro1, String parametro2){

        // modifica el modelo
        // ...

        // refresca las vistas
        refrescar(vista);

    }

}
