/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

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
public class EnvioTest {
    
    public EnvioTest() {
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
     * Test of getId method, of class Envio.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Envio instance = new Envio();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Envio.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Envio instance = new Envio();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductos method, of class Envio.
     */
    @Test
    public void testGetProductos() {
        System.out.println("getProductos");
        Envio instance = new Envio();
        List<ProductoEnvio> expResult = null;
        List<ProductoEnvio> result = instance.getProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductos method, of class Envio.
     */
    @Test
    public void testSetProductos() {
        System.out.println("setProductos");
        List<ProductoEnvio> productos = null;
        Envio instance = new Envio();
        instance.setProductos(productos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Envio.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Envio instance = new Envio();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Envio.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Envio instance = new Envio();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class Envio.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        Envio instance = new Envio();
        Cliente expResult = null;
        Cliente result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class Envio.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        Cliente cliente = null;
        Envio instance = new Envio();
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCobrado method, of class Envio.
     */
    @Test
    public void testIsCobrado() {
        System.out.println("isCobrado");
        Envio instance = new Envio();
        boolean expResult = false;
        //boolean result = instance.isCobrado();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCobrado method, of class Envio.
     */
    @Test
    public void testSetCobrado() {
        System.out.println("setCobrado");
        boolean cobrado = false;
        Envio instance = new Envio();
        instance.setCobrado(cobrado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCosteEnvio method, of class Envio.
     */
    @Test
    public void testGetCosteEnvio() {
        System.out.println("getCosteEnvio");
        Envio instance = new Envio();
        double expResult = 0.0;
        double result = instance.getCosteEnvio();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCosteEnvio method, of class Envio.
     */
    @Test
    public void testSetCosteEnvio() {
        System.out.println("setCosteEnvio");
        double costeEnvio = 0.0;
        Envio instance = new Envio();
        instance.setCosteEnvio(costeEnvio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
