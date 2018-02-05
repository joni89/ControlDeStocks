package aplicacion.vista;

import javax.swing.JComponent;

/**
 *
 * @author jonatan
 */
public interface Vista {

    /**
     * Método para refrescar la vista.
     */
    void refrescar();

    /**
     * 
     * @return
     */
    JComponent getComponenteRaiz();

}
