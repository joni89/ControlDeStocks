/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.modelo.Cliente;
import aplicacion.modelo.Envio;
import aplicacion.modelo.Producto;
import aplicacion.modelo.ProductoAlmacen;
import aplicacion.modelo.ProductoEnvio;
import aplicacion.modelo.Proveedor;
import java.io.File;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonatan
 */
public class ControladorPrincipalTest {
    
    public ControladorPrincipalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of iniciarApp method, of class ControladorPrincipal.
     */
    @Test
    public void testIniciarApp() {
        System.out.println("iniciarApp");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.iniciarApp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearAnadirProducto method, of class ControladorPrincipal.
     */
    @Test
    public void testCrearAnadirProducto() {
        System.out.println("crearAnadirProducto");
        String nombre = "";
        String fabricante = "";
        Proveedor proveedor = null;
        double precio = 0.0;
        int stock = 0;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.crearAnadirProducto(nombre, fabricante, proveedor, precio, stock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of eliminarProducto method, of class ControladorPrincipal.
//     */
//    @Test
//    public void testEliminarProductoAlmacen() {
//        System.out.println("eliminarProductoAlmacen");
//        ProductoAlmacen productoAlmacen = null;
//        ControladorPrincipal instance = new ControladorPrincipal();
//        instance.eliminarProductoAlmacen(productoAlmacen);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of anadirStock method, of class ControladorPrincipal.
     */
    @Test
    public void testAnadirStock() {
        System.out.println("anadirStock");
        ProductoAlmacen producto = null;
        int cantidad = 0;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.anadirStock(producto, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restarStock method, of class ControladorPrincipal.
     */
    @Test
    public void testRestarStock() {
        System.out.println("restarStock");
        ProductoAlmacen producto = null;
        int cantidad = 0;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.restarStock(producto, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearAnadirCliente method, of class ControladorPrincipal.
     */
    @Test
    public void testCrearAnadirCliente() {
        System.out.println("crearAnadirCliente");
        String id = "";
        String nombre = "";
        String direccion = "";
        String telefono = "";
        String email = "";
        String personaContacto = "";
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.crearAnadirCliente(id, nombre, direccion, telefono, email, personaContacto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCliente method, of class ControladorPrincipal.
     */
    @Test
    public void testEliminarCliente() {
        System.out.println("eliminarCliente");
        Cliente cliente = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.eliminarCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearAnadirProveedor method, of class ControladorPrincipal.
     */
    @Test
    public void testCrearAnadirProveedor() {
        System.out.println("crearAnadirProveedor");
        String id = "";
        String nombre = "";
        String direccion = "";
        String telefono = "";
        String email = "";
        String personaContacto = "";
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.crearAnadirProveedor(id, nombre, direccion, telefono, email, personaContacto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarProveedor method, of class ControladorPrincipal.
     */
    @Test
    public void testEliminarProveedor() {
        System.out.println("eliminarProveedor");
        Proveedor proveedor = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.eliminarProveedor(proveedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearAnadirEnvio method, of class ControladorPrincipal.
     */
    @Test
    public void testCrearAnadirEnvio() {
        System.out.println("crearAnadirEnvio");
        List<ProductoEnvio> productos = null;
        Date fecha = null;
        Cliente cliente = null;
        boolean cobrado = false;
        ControladorPrincipal instance = new ControladorPrincipal();
        boolean expResult = false;
        instance.crearAnadirEnvio(productos, fecha, cliente, cobrado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarStock method, of class ControladorPrincipal.
     */
    @Test
    public void testComprobarStock() {
        System.out.println("comprobarStock");
        Envio envio = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        boolean expResult = false;
        boolean result = instance.comprobarStock(envio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarEnviosFechas method, of class ControladorPrincipal.
     */
    @Test
    public void testBuscarEnviosFechas() {
        System.out.println("buscarEnviosFechas");
        Date fechaInicio = null;
        Date fechaFin = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        List<Envio> expResult = null;
        List<Envio> result = instance.buscarEnviosFechas(fechaInicio, fechaFin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarFacturaArchivo method, of class ControladorPrincipal.
     */
    @Test
    public void testGuardarFacturaArchivo() throws Exception {
        System.out.println("guardarFacturaArchivo");
        String factura = "";
        File archivo = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.guardarFacturaArchivo(factura, archivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarVistaPrincipal method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarVistaPrincipal() {
        System.out.println("mostrarVistaPrincipal");
        ControladorPrincipal instance = new ControladorPrincipal();
        //instance.mostrarVistaPrincipal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCrearProducto method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarCrearProducto() {
        System.out.println("mostrarCrearProducto");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarCrearProducto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCrearCliente method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarCrearCliente() {
        System.out.println("mostrarCrearCliente");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarCrearCliente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCrearProveedor method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarCrearProveedor() {
        System.out.println("mostrarCrearProveedor");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarCrearProveedor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCrearStock method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarCrearStock() {
        System.out.println("mostrarCrearStock");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarCrearStock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCrearEnvio method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarCrearEnvio() {
        System.out.println("mostrarCrearEnvio");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarCrearEnvio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarFactura method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarFactura() {
        System.out.println("mostrarFactura");
        Envio envio = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarFactura(envio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCrearFactura method, of class ControladorPrincipal.
     */
    @Test
    public void testMostrarCrearFactura() {
        System.out.println("mostrarCrearFactura");
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.mostrarCrearFactura();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarJsonProductos method, of class ControladorPrincipal.
     */
    @Test
    public void testGenerarJsonProductos() throws Exception {
        System.out.println("generarJsonProductos");
        List<ProductoAlmacen> productos = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.generarJsonProductos(productos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerJsonProductos method, of class ControladorPrincipal.
     */
    @Test
    public void testLeerJsonProductos() throws Exception {
        System.out.println("leerJsonProductos");
        ControladorPrincipal instance = new ControladorPrincipal();
        List<ProductoAlmacen> expResult = null;
        List<ProductoAlmacen> result = instance.leerJsonProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarXmlClientes method, of class ControladorPrincipal.
     */
    @Test
    public void testGenerarXmlClientes() throws Exception {
        System.out.println("generarXmlClientes");
        List<Cliente> clientes = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.generarXmlClientes(clientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerXmlClientes method, of class ControladorPrincipal.
     */
    @Test
    public void testLeerXmlClientes() throws Exception {
        System.out.println("leerXmlClientes");
        ControladorPrincipal instance = new ControladorPrincipal();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.leerXmlClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarTxtProveedores method, of class ControladorPrincipal.
     */
    @Test
    public void testGenerarTxtProveedores() throws Exception {
        System.out.println("generarTxtProveedores");
        List<Proveedor> proveedores = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.generarTxtProveedores(proveedores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerTxtProveedores method, of class ControladorPrincipal.
     */
    @Test
    public void testLeerTxtProveedores() throws Exception {
        System.out.println("leerTxtProveedores");
        ControladorPrincipal instance = new ControladorPrincipal();
        List<Proveedor> expResult = null;
        List<Proveedor> result = instance.leerTxtProveedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarBinEnvios method, of class ControladorPrincipal.
     */
    @Test
    public void testGenerarBinEnvios() throws Exception {
        System.out.println("generarBinEnvios");
        List<Envio> envios = null;
        ControladorPrincipal instance = new ControladorPrincipal();
        instance.generarBinEnvios(envios);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerBinEnvios method, of class ControladorPrincipal.
     */
    @Test
    public void testLeerBinEnvios() throws Exception {
        System.out.println("leerBinEnvios");
        ControladorPrincipal instance = new ControladorPrincipal();
        List<Envio> expResult = null;
        List<Envio> result = instance.leerBinEnvios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
