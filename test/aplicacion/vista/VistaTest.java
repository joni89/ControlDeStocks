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
public class VistaTest {
    
    public VistaTest() {
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
     * Test of refrescar method, of class Vista.
     */
    @Test
    public void testRefrescar() {
        System.out.println("refrescar");
        Vista instance = new VistaImpl();
        instance.refrescar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComponenteRaiz method, of class Vista.
     */
    @Test
    public void testGetComponenteRaiz() {
        System.out.println("getComponenteRaiz");
        Vista instance = new VistaImpl();
        JComponent expResult = null;
        JComponent result = instance.getComponenteRaiz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VistaImpl implements Vista {

        public void refrescar() {
        }

        public JComponent getComponenteRaiz() {
            return null;
        }
    }
    
}
