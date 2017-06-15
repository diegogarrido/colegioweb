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
public class ListProyecto1DataTest {
    
    public ListProyecto1DataTest() {
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
     * Test of listTestData method, of class ListProyecto1Data.
     */
    @Test
    public void testListTestData() throws Exception {
        System.out.println("listTestData");
        ListProyecto1Data instance = new ListProyecto1Data();
        instance.listTestData();
    }

    /**
     * Test of main method, of class ListProyecto1Data.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ListProyecto1Data.main(args);
    }
    
}
