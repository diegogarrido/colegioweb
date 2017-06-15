/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Junit de Asignatura
 * @author Diego
 */
public class AsignaturaTest {
    
    /**
     *
     */
    public AsignaturaTest() {
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
     * Test of getNombre method, of class Asignatura.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Asignatura instance = new Asignatura(new Profesor("profesor"),"nombre");
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNombre method, of class Asignatura.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nombre";
        Asignatura instance = new Asignatura(new Profesor("profesor"),"nombre");
        instance.setNombre(nombre);
        assertEquals(nombre,instance.getNombre());
    }

    /**
     * Test of getProfesor method, of class Asignatura.
     */
    @Test
    public void testGetProfesor() {
        System.out.println("getProfesor");
        Asignatura instance = new Asignatura(new Profesor("profesor"),"nombre");
        String expResult = "profesor";
        String result = instance.getProfesor().getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProfesor method, of class Asignatura.
     */
    @Test
    public void testSetProfesor() {
        System.out.println("setProfesor");
        Profesor profesor = new Profesor("profesor");
        Asignatura instance = new Asignatura();
        instance.setProfesor(profesor);
        assertEquals(profesor,instance.getProfesor());
    }

    /**
     * Test of getPlanificacion method, of class Asignatura.
     */
    @Test
    public void testGetPlanificacion() {
        System.out.println("getPlanificacion");
        Asignatura instance = new Asignatura();
        ArrayList<String> array = instance.getPlanificacion();
        ArrayList<String> expResult = new ArrayList();
        assertEquals(expResult, array);
    }

    /**
     * Test of setPlanificacion method, of class Asignatura.
     */
    @Test
    public void testSetPlanificacion() {
        System.out.println("setPlanificacion");
        ArrayList<String> planificacion = null;
        Asignatura instance = new Asignatura();
        instance.setPlanificacion(planificacion);
        Assert.assertEquals(planificacion,instance.getPlanificacion());
    }

    /**
     * Test of añandirActividad method, of class Asignatura.
     */
    @Test
    public void testAñandirActividad() {
        System.out.println("a\u00f1andirActividad");
        String desc = "descripcion";
        boolean tipo = false;
        String fecha = "1/1/2017";
        Asignatura instance = new Asignatura();
        instance.añandirActividad(desc, tipo, fecha);
        assertEquals(instance.getPlanificacion().get(0),desc+","+tipo+","+fecha);
    }
    
}
