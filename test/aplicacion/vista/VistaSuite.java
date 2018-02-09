/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.vista;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jonatan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({aplicacion.vista.VistaFacturaTest.class, aplicacion.vista.VistaPrincipalTest.class, aplicacion.vista.VistaTest.class, aplicacion.vista.VistaCrearEnvioTest.class, aplicacion.vista.VistaCrearProductoTest.class, aplicacion.vista.VistaCrearFacturaTest.class, aplicacion.vista.VistaCrearClienteProveedorTest.class, aplicacion.vista.VistaAnadirStockTest.class})
public class VistaSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
