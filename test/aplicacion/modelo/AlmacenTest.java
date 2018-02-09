/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

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
public class AlmacenTest {
    
    public AlmacenTest() {
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
     * Test of getProductos method, of class Almacen.
     */
    @Test
    public void testGetProductos() {
        System.out.println("getProductos");
        Almacen instance = new Almacen();
        List<ProductoAlmacen> expResult = null;
        List<ProductoAlmacen> result = instance.getProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductos method, of class Almacen.
     */
    @Test
    public void testSetProductos() {
        System.out.println("setProductos");
        List<ProductoAlmacen> productos = null;
        Almacen instance = new Almacen();
        instance.setProductos(productos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientes method, of class Almacen.
     */
    @Test
    public void testGetClientes() {
        System.out.println("getClientes");
        Almacen instance = new Almacen();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.getClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientes method, of class Almacen.
     */
    @Test
    public void testSetClientes() {
        System.out.println("setClientes");
        List<Cliente> clientes = null;
        Almacen instance = new Almacen();
        instance.setClientes(clientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProveedores method, of class Almacen.
     */
    @Test
    public void testGetProveedores() {
        System.out.println("getProveedores");
        Almacen instance = new Almacen();
        List<Proveedor> expResult = null;
        List<Proveedor> result = instance.getProveedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProveedores method, of class Almacen.
     */
    @Test
    public void testSetProveedores() {
        System.out.println("setProveedores");
        List<Proveedor> proveedores = null;
        Almacen instance = new Almacen();
        instance.setProveedores(proveedores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnviosRealizados method, of class Almacen.
     */
    @Test
    public void testGetEnviosRealizados() {
        System.out.println("getEnviosRealizados");
        Almacen instance = new Almacen();
        List<Envio> expResult = null;
        List<Envio> result = instance.getEnviosRealizados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnviosRealizados method, of class Almacen.
     */
    @Test
    public void testSetEnviosRealizados() {
        System.out.println("setEnviosRealizados");
        List<Envio> enviosRealizados = null;
        Almacen instance = new Almacen();
        instance.setEnviosRealizados(enviosRealizados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
