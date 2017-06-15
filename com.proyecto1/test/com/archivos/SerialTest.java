/*
 * Autor: Diego Garrido
 */
package com.archivos;

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
public class SerialTest {
    
    public SerialTest() {
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
     * Test of serializar method, of class Serial.
     */
    @Test
    public void testSerializar() {
        System.out.println("serializar");
        Object ob = null;
        Serial instance = new Serial();
        String expResult = "null";
        String result = instance.serializar(ob);
        assertEquals(expResult, result);
    }

    /**
     * Test of deserializar method, of class Serial.
     */
    @Test
    public void testDeserializar() {
        System.out.println("deserializar");
        String json = "string";
        Serial instance = new Serial();
        Object expResult = "string";
        Object result = instance.deserializar(String.class, json);
        assertEquals(expResult, result);
    }
   
}
