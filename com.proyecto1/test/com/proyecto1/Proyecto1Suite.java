/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Junit de todas las clases
 * @author Diego
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.proyecto1.ComProyecto1Test.class, com.proyecto1.AsignaturaTest.class, com.proyecto1.CursoTest.class, com.proyecto1.AlumnoTest.class, com.proyecto1.ApoderadoTest.class, com.proyecto1.ProfesorTest.class})
public class Proyecto1Suite {

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
}
