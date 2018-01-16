package aplicacion;

/**
 *
 * @author jonatan
 */
public class Main {

    public static void main(String[] args) {

        Instancias instancias = new Instancias();

        // Inicializamos los componentes (vistas y controladores)
        instancias.getControladorPrincipal().inicializar(instancias);
        instancias.getVistaPrincipal().inicializar(instancias);

    }

}
