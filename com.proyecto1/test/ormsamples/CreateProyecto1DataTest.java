/*
 * Autor: Diego Garrido
 */
package ormsamples;

import com.proyecto1.Alumno;
import com.proyecto1.Apoderado;
import com.proyecto1.Asignatura;
import com.proyecto1.Curso;
import com.proyecto1.Profesor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.orm.PersistentException;
import org.orm.cfg.JDBCConnectionSetting;
import orm.Proyecto1PersistentManager;

/**
 * Cambiar base de datos a /proyecto2 en hibernate
 *
 * @author Diego
 */
public class CreateProyecto1DataTest {

    public CreateProyecto1DataTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String user = "root";
        String pass = "admin";
        String connURL = "jdbc:mysql://localhost:3306/proyecto2?&amp;useSSL=false";

        JDBCConnectionSetting settings = new JDBCConnectionSetting();
        settings.setDriverClass("com.mysql.jdbc.Driver");
        settings.setDialect("org.hibernate.dialect.MySQLDialect");
        settings.setConnectionURL(connURL);
        settings.setUserName(user);
        settings.setPassword(pass);
        try {
            Proyecto1PersistentManager.setJDBCConnectionSetting(settings);
        } catch (PersistentException ex) {
            Logger.getLogger(CreateProyecto1DataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createTestData method, of class CreateProyecto1Data.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateTestData() throws Exception {
        System.out.println("createTestData");
        Curso cur = new Curso(1, 'A');
        CreateProyecto1Data instance = new CreateProyecto1Data();
        instance.createTestData(cur);
    }

    /**
     * Test of addCurso method, of class CreateProyecto1Data.
     */
    @Test
    public void testAddCurso() {
        System.out.println("addCurso");
        Curso cur = new Curso(1, 'B');
        CreateProyecto1Data instance = new CreateProyecto1Data();
        instance.addCurso(cur);
    }

    /**
     * Test of addAsignatura method, of class CreateProyecto1Data.
     */
    @Test
    public void testAddAsignatura() {
        System.out.println("addAsignatura");
        Asignatura as = new Asignatura(new Profesor("profesor"), "asignatura 1 A");
        boolean exisProf = false;
        CreateProyecto1Data instance = new CreateProyecto1Data();
        instance.addAsignatura(as, exisProf);
    }

    /**
     * Test of addProfesor method, of class CreateProyecto1Data.
     */
    @Test
    public void testAddProfesor() {
        System.out.println("addProfesor");
        Profesor prof = new Profesor("profesor");
        CreateProyecto1Data instance = new CreateProyecto1Data();
        instance.addProfesor(prof);
    }

    /**
     * Test of addAlumno method, of class CreateProyecto1Data.
     */
    @Test
    public void testAddAlumno() {
        System.out.println("addAlumno");
        Alumno al = new Alumno("nombre alumno", "1 A", new Apoderado("apoderado"));
        boolean exisAp = false;
        CreateProyecto1Data instance = new CreateProyecto1Data();
        instance.addAlumno(al, exisAp);
    }

}
