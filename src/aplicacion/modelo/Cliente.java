package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class Cliente extends Empresa{

    public Cliente() {}

    public Cliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        super(id, nombre, direccion, telefono, email, personaContacto);
    }
    
}
