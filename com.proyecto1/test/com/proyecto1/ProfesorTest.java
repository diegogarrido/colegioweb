/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Junit Profesor
 * @author Diego
 */
public class ProfesorTest {
    
    /**
     * Junit Profesor
     */
    public ProfesorTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Profesor.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Profesor instance = new Profesor("nombre");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Profesor.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nombre";
        Profesor instance = new Profesor();
        instance.setNombre(nombre);
        assertEquals(nombre,instance.getNombre());
    }

    /**
     * Test of getAsignaturas method, of class Profesor.
     */
    @Test
    public void testGetAsignaturas() {
        System.out.println("getAsignaturas");
        Profesor instance = new Profesor();
        ArrayList<String> expResult = new ArrayList();
        ArrayList<String> result = instance.getAsignaturas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAsignaturas method, of class Profesor.
     */
    @Test
    public void testSetAsignaturas() {
        System.out.println("setAsignaturas");
        ArrayList<String> asignaturas = null;
        Profesor instance = new Profesor();
        instance.setAsignaturas(asignaturas);
        assertEquals(asignaturas,instance.getAsignaturas());
    }

    /**
     * Test of hashCode method, of class Profesor.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Profesor instance = new Profesor();
        int expResult = 249;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Profesor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Profesor instance = new Profesor();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
