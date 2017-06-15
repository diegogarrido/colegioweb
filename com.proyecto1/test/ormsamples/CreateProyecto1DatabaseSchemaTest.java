/*
 * Autor: Diego Garrido
 */
package ormsamples;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Cambiar base de datos a /proyecto2 en hibernate
 * @author Diego
 */
public class CreateProyecto1DatabaseSchemaTest {
    
    public CreateProyecto1DatabaseSchemaTest() {
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
     * Test of main method, of class CreateProyecto1DatabaseSchema.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CreateProyecto1DatabaseSchema.main(args);
    }
    
}
