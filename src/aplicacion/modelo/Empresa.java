package aplicacion.modelo;

/**
 *
 * @author jonatan
 */
public class Empresa {
    
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String personaContacto;
    
    /**
     * Constructor vacío.
     */
    public Empresa(){}
    
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
    public Empresa(String id, String nombre, String direccion, String telefono, String email, String personaContacto) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.personaContacto = personaContacto;
    }
    
    /**
     * Devuelve el ID.
     * 
     * @return ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID.
     * 
     * @param id ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre.
     * 
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección.
     * 
     * @return dirección.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección.
     * 
     * @param direccion Dirección.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el número de teléfono.
     * 
     * @return teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono.
     * 
     * @param telefono teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el email.
     * 
     * @return email. 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email.
     * 
     * @param email Correo electrónico.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la persona de contacto.
     * 
     * @return persona de contacto.
     */
    public String getPersonaContacto() {
        return personaContacto;
    }

    /**
     * Establece la persona de contacto.
     * 
     * @param personaContacto Persona de contacto.
     */
    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    
}
