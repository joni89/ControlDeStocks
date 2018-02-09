package aplicacion.controlador;

import javax.swing.JFrame;

import aplicacion.vista.Vista;

/**
 *
 * @author jonatan
 */
public abstract class Controlador {

    private final JFrame ventana;
    private Vista vistaActiva;

    /**
     *Constructor
     */
    public Controlador() {
        this.ventana = new JFrame();
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
     * Establece la vista activa
     * @param vista Vista
     */
    protected void setVistaActiva(Vista vista) {
        this.ventana.setContentPane(vista.getComponenteRaiz());
        this.vistaActiva = vista;
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

}
