/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.vista;

import javax.swing.JComponent;
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
public class VistaCrearEnvioTest {
    
    public VistaCrearEnvioTest() {
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
     * Test of refrescar method, of class VistaCrearEnvio.
     */
    @Test
    public void testRefrescar() {
        System.out.println("refrescar");
        VistaCrearEnvio instance = null;
        instance.refrescar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComponenteRaiz method, of class VistaCrearEnvio.
     */
    @Test
    public void testGetComponenteRaiz() {
        System.out.println("getComponenteRaiz");
        VistaCrearEnvio instance = null;
        JComponent expResult = null;
        JComponent result = instance.getComponenteRaiz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
