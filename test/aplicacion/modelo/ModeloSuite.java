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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jonatan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({aplicacion.modelo.ProductoAlmacenTest.class, aplicacion.modelo.ProductoTest.class, aplicacion.modelo.AlmacenTest.class, aplicacion.modelo.EnvioTest.class, aplicacion.modelo.ProductoEnvioTest.class, aplicacion.modelo.EmpresaTest.class, aplicacion.modelo.ProveedorTest.class, aplicacion.modelo.ClienteTest.class})
public class ModeloSuite {

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
