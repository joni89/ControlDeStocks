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
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param personaContacto
     */
    public Proveedor(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        super(id, nombre, direccion, telefono, email, personaContacto);
    }
    
    
}
