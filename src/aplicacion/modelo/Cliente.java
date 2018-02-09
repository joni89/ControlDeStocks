package aplicacion.modelo;

import java.io.Serializable;

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
     * 
     * @param id CIF o NIF del cliente
     * @param nombre nombre.
     * @param direccion dirección.
     * @param telefono télefono.
     * @param email email.
     * @param personaContacto persona de contacto.
     */
    public Cliente(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        super(id, nombre, direccion, telefono, email, personaContacto);
    }
    
}
