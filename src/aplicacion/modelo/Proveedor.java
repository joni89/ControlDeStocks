package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class Proveedor extends Empresa{

    /**
     * Constructor vacío.
     */
    public Proveedor() {}

    /**
     * Constructor con parámetros.
     * 
     * @param id id.
     * @param nombre nombre.
     * @param direccion dirección.
     * @param telefono télefono.
     * @param email email.
     * @param personaContacto personaContacto.
     */
    public Proveedor(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        super(id, nombre, direccion, telefono, email, personaContacto);
    }
    
    
}
