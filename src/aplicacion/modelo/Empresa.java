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
     *
     * @return Devuelve el ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return Devuelve el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return Devuelve la dirección.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección.
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return Devuelve el número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono.
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return Devuelve el email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return Devuelve la persona de contacto.
     */
    public String getPersonaContacto() {
        return personaContacto;
    }

    /**
     * Establece la persona de contacto.
     * @param personaContacto
     */
    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    
}
