/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.vista.Vista;
import javax.swing.JFrame;
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
public class ControladorTest {
    
    public ControladorTest() {
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
     * Test of getVentana method, of class Controlador.
     */
    @Test
    public void testGetVentana() {
        System.out.println("getVentana");
        Controlador instance = new ControladorImpl();
        JFrame expResult = null;
        JFrame result = instance.getVentana();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVistaActiva method, of class Controlador.
     */
    @Test
    public void testSetVistaActiva() {
        System.out.println("setVistaActiva");
        Vista vista = null;
        Controlador instance = new ControladorImpl();
        instance.setVistaActiva(vista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refrescarVistaActiva method, of class Controlador.
     */
    @Test
    public void testRefrescarVistaActiva() {
        System.out.println("refrescarVistaActiva");
        Controlador instance = new ControladorImpl();
        instance.refrescarVistaActiva();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ControladorImpl extends Controlador {
    }
    
}
