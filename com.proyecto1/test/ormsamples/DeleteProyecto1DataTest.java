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
 *
 * @author Diego
 */
public class DeleteProyecto1DataTest {
    
    public DeleteProyecto1DataTest() {
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
     * Test of deleteData method, of class DeleteProyecto1Data.
     */
    @Test
    public void testDeleteData() throws Exception {
        System.out.println("deleteData");
        DeleteProyecto1Data instance = new DeleteProyecto1Data();
        instance.deleteData();
    }

    /**
     * Test of main method, of class DeleteProyecto1Data.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DeleteProyecto1Data.main(args);
    }
    
}
