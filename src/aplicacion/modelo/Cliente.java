package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class Cliente extends Empresa{

    /**
     * Constructor vacío.
     */
    public Cliente() {}

    /**
     * Constructor con parámetros.
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param email
     * @param personaContacto
     */
    public Cliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        super(id, nombre, direccion, telefono, email, personaContacto);
    }
    
}
