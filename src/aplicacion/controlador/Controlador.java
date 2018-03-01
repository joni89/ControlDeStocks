package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.vista.Vista;
import javax.swing.JDialog;

/**
 *
 * @author jonatan
 */
public abstract class Controlador {

    private final JFrame ventana;
    private Vista vistaActiva;

    private final JDialog dialogo;
    private Vista vistaActivaDialogo;

    /**
     *Constructor
     */
    public Controlador() {
        this.ventana = new JFrame();
        this.dialogo = new JDialog(this.ventana, true);
        this.vistaActiva = null;
    }

    /**
     * Nos da la ventana
     * @return Devuelve la ventana
     */
    protected JFrame getVentana() {
        return this.ventana;
    }

    /**
     * Nos da el diálogo
     * @return Devuelve el diálogo
     */
    protected JDialog getDialogo() {
        return this.dialogo;
    }

    /**
     * Establece la vista activa
     * @param vista Vista
     */
    protected void setVistaActiva(Vista vista) {
        this.ventana.setContentPane(vista.getComponenteRaiz());
        this.vistaActiva = vista;
    }

    /**
     * Establece la vista activa del diálogo
     * @param vista Vista
     */
    protected void setVistaActivaDialogo(Vista vista) {
        this.dialogo.setContentPane(vista.getComponenteRaiz());
        this.vistaActivaDialogo = vista;
    }

    /**
     * Refresca la vista activa
     */
    protected void refrescarVistaActiva() {
        if (this.vistaActiva != null) {
            this.vistaActiva.refrescar();
            this.ventana.revalidate();
        }
    }

    /**
     * Refresca la vista activa del diálogo
     */
    protected void refrescarVistaActivaDialogo() {
        if (this.vistaActivaDialogo != null) {
            this.vistaActivaDialogo.refrescar();
            this.dialogo.revalidate();
        }
    }

}
