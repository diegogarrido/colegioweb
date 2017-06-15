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
 * Junit de Apoderado
 * @author Diego
 */
public class ApoderadoTest {
    
    /**
     *
     */
    public ApoderadoTest() {
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
     * Test of getNombre method, of class Apoderado.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Apoderado instance = new Apoderado("nombre");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Apoderado.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nombre";
        Apoderado instance = new Apoderado();
        instance.setNombre(nombre);
        assertEquals(nombre,instance.getNombre());
    }

    /**
     * Test of getHijos method, of class Apoderado.
     */
    @Test
    public void testGetHijos() {
        System.out.println("getHijos");
        Apoderado instance = new Apoderado("nombre");
        ArrayList<String> expResult = new ArrayList();
        ArrayList<String> result = instance.getHijos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHijos method, of class Apoderado.
     */
    @Test
    public void testSetHijos() {
        System.out.println("setHijos");
        ArrayList<String> hijos = null;
        Apoderado instance = new Apoderado();
        instance.setHijos(hijos);
        assertEquals(hijos,instance.getHijos());
    }
    
}
