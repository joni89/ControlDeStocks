/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

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
public class ProductoEnvioTest {
    
    public ProductoEnvioTest() {
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
     * Test of getProducto method, of class ProductoEnvio.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        ProductoEnvio instance = null;
        Producto expResult = null;
        Producto result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class ProductoEnvio.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        Producto producto = null;
        ProductoEnvio instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class ProductoEnvio.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        ProductoEnvio instance = null;
        int expResult = 0;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class ProductoEnvio.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        ProductoEnvio instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
