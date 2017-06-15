/*
 * Autor: Diego Garrido
 */
package ormsamples;

import com.proyecto1.Asignatura;
import com.proyecto1.Curso;
import com.proyecto1.Profesor;
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
public class RetrieveAndUpdateProyecto1DataTest {
    
    public RetrieveAndUpdateProyecto1DataTest() {
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
     * Test of retrieveAndUpdateTestData method, of class RetrieveAndUpdateProyecto1Data.
     * @throws java.lang.Exception
     */
    @Test
    public void testRetrieveAndUpdateTestData() throws Exception {
        System.out.println("retrieveAndUpdateTestData");
        Curso cur = new Curso(1,'A');
        cur.getAsignaturas().add(new Asignatura(new Profesor("profesor"), "nueva asignatura"));
        RetrieveAndUpdateProyecto1Data instance = new RetrieveAndUpdateProyecto1Data();
        instance.retrieveAndUpdateTestData(cur);
    }
    
}
