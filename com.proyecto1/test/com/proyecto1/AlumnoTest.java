/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Junit de Alumno
 * @author Diego
 */
public class AlumnoTest {
    
    /**
     *
     */
    public AlumnoTest() {
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
     * Test of getNotasAsig method, of class Alumno.
     */
    @Test
    public void testGetNotasAsig() {
        System.out.println("getNotasAsig");
        Alumno instance = new Alumno();
        ArrayList<String> expResult = instance.getNotasAsig();
        assertSame(expResult.size(),0);
    }

    /**
     * Test of setNotasAsig method, of class Alumno.
     */
    @Test
    public void testSetNotasAsig() {
        System.out.println("setNotasAsig");
        ArrayList<String> notasAsig = null;
        Alumno instance = new Alumno();
        instance.setNotasAsig(notasAsig);
        Assert.assertEquals(notasAsig, instance.getNotasAsig());
    }

    /**
     * Test of getAnotaciones method, of class Alumno.
     */
    @Test
    public void testGetAnotaciones() {
        System.out.println("getAnotaciones");
        Alumno instance = new Alumno();
        ArrayList<String> result = instance.getAnotaciones();
        assertEquals(new ArrayList<>(), result);
    }

    /**
     * Test of setAnotaciones method, of class Alumno.
     */
    @Test
    public void testSetAnotaciones() {
        System.out.println("setAnotaciones");
        ArrayList<String> anotaciones = null;
        Alumno instance = new Alumno();
        instance.setAnotaciones(anotaciones);
        assertEquals(anotaciones, instance.getAnotaciones());
    }

    /**
     * Test of getNotas method, of class Alumno.
     */
    @Test
    public void testGetNotas() {
        System.out.println("getNotas");
        Alumno instance = new Alumno();
        ArrayList<String> result = instance.getNotas();
        assertEquals(0, result.size());
    }

    /**
     * Test of setNotas method, of class Alumno.
     */
    @Test
    public void testSetNotas() {
        System.out.println("setNotas");
        ArrayList<String> notas = null;
        Alumno instance = new Alumno();
        instance.setNotas(notas);
        Assert.assertEquals(notas,instance.getNotas());
    }

    /**
     * Test of getAsistencia method, of class Alumno.
     */
    @Test
    public void testGetAsistencia() {
        System.out.println("getAsistencia");
        Alumno instance = new Alumno();
        ArrayList<Boolean> result = instance.getAsistencia();
        result.add(true);
        assertTrue(result.get(0));
    }

    /**
     * Test of setAsistencia method, of class Alumno.
     */
    @Test
    public void testSetAsistencia() {
        System.out.println("setAsistencia");
        ArrayList<Boolean> asistencia = null;
        Alumno instance = new Alumno();
        instance.setAsistencia(asistencia);
        assertEquals(asistencia,instance.getAsistencia());
    }

    /**
     * Test of getCurso method, of class Alumno.
     */
    @Test
    public void testGetCurso() {
        System.out.println("getCurso");
        Alumno instance = new Alumno("nombre","curso",new Apoderado());
        String expResult = "curso";
        String result = instance.getCurso();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurso method, of class Alumno.
     */
    @Test
    public void testSetCurso() {
        System.out.println("setCurso");
        String curso = "curso";
        Alumno instance = new Alumno();
        instance.setCurso(curso);
        assertEquals(curso,instance.getCurso());
    }

    /**
     * Test of getApoderado method, of class Alumno.
     */
    @Test
    public void testGetApoderado() {
        System.out.println("getApoderado");
        Alumno instance = new Alumno();
        Apoderado expResult = null;
        Apoderado result = instance.getApoderado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApoderado method, of class Alumno.
     */
    @Test
    public void testSetApoderado() {
        System.out.println("setApoderado");
        Apoderado apoderado = null;
        Alumno instance = new Alumno();
        instance.setApoderado(apoderado);
        assertEquals(apoderado,instance.getApoderado());
    }

    /**
     * Test of getNombre method, of class Alumno.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Alumno instance = new Alumno("nombre","curso",new Apoderado());
        String expResult = "nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Alumno.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nombre";
        Alumno instance = new Alumno();
        instance.setNombre(nombre);
        assertEquals(nombre,instance.getNombre());
    }

    /**
     * Test of getPorcentajeAsistencia method, of class Alumno.
     */
    @Test
    public void testGetPorcentajeAsistencia() {
        System.out.println("getPorcentajeAsistencia");
        Alumno instance = new Alumno();
        instance.setAsistencia(new ArrayList());
        instance.getAsistencia().add(true);
        instance.getAsistencia().add(false);
        String expResult = "50.0%";
        String result = instance.getPorcentajeAsistencia();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPromedioAsignatura method, of class Alumno.
     */
    @Test
    public void testGetPromedioAsignatura() {
        System.out.println("getPromedioAsignatura");
        Alumno instance = new Alumno();
        ArrayList<String> array = new ArrayList();
        array.add("4.0,20,asignatura");
        array.add("6.0,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("5.2,20,asignatura");
        array.add("3.5,20,asignatura");
        instance.setNotas(array);
        ArrayList<String> array2 = new ArrayList();
        array2.add("1.0,asignatura");
        array2.add("3.0,asignatura");
        array2.add("2.0,asignatura");
        array2.add("4.0,asignatura");
        array2.add("5.0,asignatura");
        instance.setNotasAsig(array2);
        instance.promediarNotasAsig("asignatura");
        String expResult = "4.3";
        String result = instance.getPromedioAsignatura("asignatura");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPromedio method, of class Alumno.
     */
    @Test
    public void testGetPromedio() {
        System.out.println("getPromedio");
        Alumno instance = new Alumno();
        ArrayList<String> array = new ArrayList();
        array.add("4.0,20,asignatura");
        array.add("6.0,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("5.2,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("4.0,20,asignatura2");
        array.add("6.0,20,asignatura2");
        array.add("3.5,20,asignatura2");
        array.add("5.2,20,asignatura2");
        array.add("3.5,20,asignatura2");
        instance.setNotas(array);
        ArrayList<String> array2 = new ArrayList();
        array2.add("1.0,asignatura");
        array2.add("3.0,asignatura");
        array2.add("2.0,asignatura");
        array2.add("4.0,asignatura");
        array2.add("5.0,asignatura");
        array2.add("1.0,asignatura2");
        array2.add("3.0,asignatura2");
        array2.add("2.0,asignatura2");
        array2.add("4.0,asignatura2");
        array2.add("5.0,asignatura2");
        instance.setNotasAsig(array2);
        instance.promediarNotasAsig("asignatura");
        instance.promediarNotasAsig("asignatura2");
        String expResult = "0.8";
        String result = instance.getPromedio();
        assertEquals(expResult, result);
    }

    /**
     * Test of estaReprobando method, of class Alumno.
     */
    @Test
    public void testEstaReprobando() {
        System.out.println("estaReprobando");
        Alumno instance = new Alumno();
        instance.setAsistencia(new ArrayList());
        instance.getAsistencia().add(true);
        ArrayList<String> array = new ArrayList();
        array.add("4.0,20,asignatura");
        array.add("6.0,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("5.2,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("4.0,20,asignatura2");
        array.add("6.0,20,asignatura2");
        array.add("3.5,20,asignatura2");
        array.add("5.2,20,asignatura2");
        array.add("3.5,20,asignatura2");
        instance.setNotas(array);
        ArrayList<String> array2 = new ArrayList();
        array2.add("1.0,asignatura");
        array2.add("3.0,asignatura");
        array2.add("2.0,asignatura");
        array2.add("4.0,asignatura");
        array2.add("5.0,asignatura");
        array2.add("1.0,asignatura2");
        array2.add("3.0,asignatura2");
        array2.add("2.0,asignatura2");
        array2.add("4.0,asignatura2");
        array2.add("5.0,asignatura2");
        instance.setNotasAsig(array2);
        instance.promediarNotasAsig("asignatura");
        instance.promediarNotasAsig("asignatura2");
        boolean expResult = false;
        boolean result = instance.estaReprobando();
        assertEquals(expResult, result);
    }

    /**
     * Test of razonReprobado method, of class Alumno.
     */
    @Test
    public void testRazonReprobado() {
        System.out.println("razonReprobado");
        Alumno instance = new Alumno();
        instance.setAsistencia(new ArrayList());
        instance.getAsistencia().add(true);
        instance.getAsistencia().add(false);
        ArrayList<String> array = new ArrayList();
        array.add("4.0,20,asignatura");
        array.add("6.0,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("5.2,20,asignatura");
        array.add("3.5,20,asignatura");
        array.add("4.0,20,asignatura2");
        array.add("6.0,20,asignatura2");
        array.add("3.5,20,asignatura2");
        array.add("5.2,20,asignatura2");
        array.add("3.5,20,asignatura2");
        instance.setNotas(array);
        ArrayList<String> array2 = new ArrayList();
        array2.add("1.0,asignatura");
        array2.add("3.0,asignatura");
        array2.add("2.0,asignatura");
        array2.add("4.0,asignatura");
        array2.add("5.0,asignatura");
        array2.add("1.0,asignatura2");
        array2.add("3.0,asignatura2");
        array2.add("2.0,asignatura2");
        array2.add("4.0,asignatura2");
        array2.add("5.0,asignatura2");
        instance.setNotasAsig(array2);
        instance.promediarNotasAsig("asignatura");
        instance.promediarNotasAsig("asignatura2");
        String expResult = "Porcentaje de Asistencia bajo 85%";
        String result = instance.razonReprobado();
        assertEquals(expResult, result);
    }

    /**
     * Test of añadirNotaAsig method, of class Alumno.
     */
    @Test
    public void testAñadirNotaAsig_String_String() {
        System.out.println("a\u00f1adirNotaAsig");
        String nota = "7.0";
        String asign = "Asignatura";
        Alumno instance = new Alumno();
        instance.añadirNotaAsig(nota, asign);
        assertEquals(instance.getNotasAsig().get(0),nota+","+asign);
    }

    /**
     * Test of añadirNotaAsig method, of class Alumno.
     */
    @Test
    public void testAñadirNotaAsig_String() {
        System.out.println("a\u00f1adirNotaAsig");
        String asign = "Asignatura";
        Alumno instance = new Alumno();
        instance.añadirNotaAsig(asign);
        assertEquals(instance.getNotasAsig().get(0),"0,"+asign);
    }

    /**
     * Test of promediarNotasAsig method, of class Alumno.
     */
    @Test
    public void testPromediarNotasAsig() {
        System.out.println("promediarNotasAsig");
        String asig = "Asignatura";
        Alumno instance = new Alumno();
        instance.promediarNotasAsig(asig);
        ArrayList<String> notas = new ArrayList();
        notas.add("0,20,Asignatura");
        notas.add("0,20,Asignatura");
        notas.add("0,20,Asignatura");
        notas.add("0,20,Asignatura");
        notas.add("1.0,20,Asignatura");
        instance.setNotas(notas);
        notas.clear();
        notas.add("1.0,Asignatura");
        notas.add("2.0,Asignatura");
        notas.add("3.0,Asignatura");
        notas.add("4.0,Asignatura");
        notas.add("5.0,Asignatura");
        instance.setNotasAsig(notas);
        instance.promediarNotasAsig(asig);
        assertEquals("3.0,Asignatura,Asignatura",instance.getNotas().get(4));
    }

    /**
     * Test of añadirAsistencia method, of class Alumno.
     */
    @Test
    public void testAñadirAsistencia() {
        System.out.println("a\u00f1adirAsistencia");
        Alumno instance = new Alumno();
        instance.añadirAsistencia();
        assertFalse(instance.getAsistencia().get(0));
    }
    
}
