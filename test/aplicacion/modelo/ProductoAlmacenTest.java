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
public class ProductoAlmacenTest {
    
    public ProductoAlmacenTest() {
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
     * Test of getProducto method, of class ProductoAlmacen.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        ProductoAlmacen instance = null;
        Producto expResult = null;
        Producto result = instance.getProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducto method, of class ProductoAlmacen.
     */
    @Test
    public void testSetProducto() {
        System.out.println("setProducto");
        Producto producto = null;
        ProductoAlmacen instance = null;
        instance.setProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStock method, of class ProductoAlmacen.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
        ProductoAlmacen instance = null;
        int expResult = 0;
        int result = instance.getStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStock method, of class ProductoAlmacen.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 0;
        ProductoAlmacen instance = null;
        instance.setStock(stock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
