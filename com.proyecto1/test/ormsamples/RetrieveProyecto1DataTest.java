/*
 * Autor: Diego Garrido
 */
package ormsamples;

import com.proyecto1.Curso;
import java.util.ArrayList;
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
public class RetrieveProyecto1DataTest {
    
    public RetrieveProyecto1DataTest() {
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
     * Test of retrieveCurso method, of class RetrieveProyecto1Data.
     * @throws java.lang.Exception
     */
    @Test
    public void testRetrieveCurso() throws Exception {
        System.out.println("retrieveCurso");
        String curs = "1 A";
        RetrieveProyecto1Data instance = new RetrieveProyecto1Data();
        Curso expResult = new Curso(1,'A');
        Curso result = instance.retrieveCurso(curs);
        assertEquals(expResult.getNivel(), result.getNivel());
    }

    /**
     * Test of existCurso method, of class RetrieveProyecto1Data.
     * añadir cursos 1A y 1B para pasar este Test
     */
    @Test
    public void testExistCurso() {
        System.out.println("existCurso");
        int nivel = 1;
        RetrieveProyecto1Data instance = new RetrieveProyecto1Data();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("A");
        expResult.add("B");
        ArrayList<String> result = instance.existCurso(nivel);
        assertEquals(expResult, result);
    }
    
}
