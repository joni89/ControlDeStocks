package aplicacion.controlador;

import aplicacion.Componente;
import aplicacion.vista.Vista;

/**
 *
 * @author jonatan
 */
public abstract class Controlador implements Componente {

    protected void refrescar(Vista... vistas) {
        for(Vista vista : vistas) {
            vista.refrescar();
        }
    }

}
