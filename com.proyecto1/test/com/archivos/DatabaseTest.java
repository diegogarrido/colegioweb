/*
 * Autor: Diego Garrido
 */
package com.archivos;

import com.proyecto1.Apoderado;
import com.proyecto1.Asignatura;
import com.proyecto1.Curso;
import com.proyecto1.Profesor;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ormsamples.CreateProyecto1DatabaseSchema;

/**
 *
 * @author Diego
 */
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of deleteData method, of class Database.
     */
    @Test
    public void testDeleteData() {
        System.out.println("deleteData");
        Database instance = new Database();
        instance.deleteData();
    }

    /**
     * Test of uploadData method, of class Database.
     */
    @Test
    public void testUploadData_Curso() {
        System.out.println("uploadData");
        Curso cur = new Curso(1,'A');
        Database instance = new Database();
        instance.uploadData(cur);
    }

    /**
     * Test of retrieveCurso method, of class Database.
     * @throws java.lang.Exception
     */
    @Test
    public void testRetrieveCurso() throws Exception {
        System.out.println("retrieveCurso");
        String curso = "1 A";
        Database instance = new Database();
        Curso expResult = new Curso(1,'A');
        Curso result = instance.retrieveCurso(curso);
        assertEquals(expResult.getNivel(), result.getNivel());
    }

    /**
     * Test of addAlumno method, of class Database.
     */
    @Test
    public void testAddAlumno() {
        System.out.println("addAlumno");
        Apoderado ap = new Apoderado("apdoderado");
        int asistencias = 0;
        String curso = "1 A";
        String nombre = "alumno";
        ArrayList<String> cantNotas = new ArrayList();
        ArrayList<String> cantNotasAsig = new ArrayList();
        boolean apExis = false;
        Database instance = new Database();
        instance.addAlumno(ap, asistencias, curso, nombre, cantNotas, cantNotasAsig, apExis);
    }

    /**
     * Test of updateData method, of class Database.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateData() throws Exception {
        System.out.println("updateData");
        Curso cur = new Curso(1,'A');
        Database instance = new Database();
        instance.updateData(cur);
    }

    /**
     * Test of existCurso method, of class Database.
     * Crear curso 1 A en la base de datos para pasar este Test
     */
    @Test
    public void testExistCurso() {
        System.out.println("existCurso");
        int nivel = 1;
        Database instance = new Database();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("A");
        ArrayList<String> result = instance.existCurso(nivel);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCurso method, of class Database.
     */
    @Test
    public void testAddCurso() {
        System.out.println("addCurso");
        int nivel = 1;
        Database instance = new Database();
        instance.addCurso(nivel);
    }

    /**
     * Test of addAsignatura method, of class Database.
     */
    @Test
    public void testAddAsignatura() {
        System.out.println("addAsignatura");
        Asignatura as = new Asignatura(new Profesor("profesor"),"nombreAsignatura 1 A");
        boolean existprof = false;
        Database instance = new Database();
        instance.addAsignatura(as, existprof);
    }

    /**
     * Test of estadoTablas method, of class Database.
     */
    @Test
    public void testEstadoTablas() {
        System.out.println("estadoTablas");
        Database instance = new Database();
        String[] args=null;
        CreateProyecto1DatabaseSchema.main(args);
        boolean result = instance.estadoTablas();
        assertTrue(result);
    }
    
}
