package com.archivos;

import java.util.ArrayList;
import ormsamples.*;
import com.proyecto1.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

/**
 * Clase que conecta la capa de negocios con la de persistencia
 * @author Diego
 */
public class Database {

    Serial ser = new Serial();
    

    /**
     * Constructor
     */
    public Database() {
    }

    /**
     * Verificar que existen las 5 tablas de la base de datos:
     * alumno, apoderado, asignatura, curso, profesor
     * @return true: existen. false: faltan 1 o mas.
     */
    public boolean estadoTablas(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto1?&useSSL=false", "root", "admin");
            int cont=0;
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                cont++;
            }
            if(cont==5){return true;}
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return false;
    }
    
    /**
     * Borrar todos los datos de todas las tablas de la base de datos
     */
    public void deleteData(){
        DeleteProyecto1Data delete = new DeleteProyecto1Data();
        try {
            delete.deleteData();
        } catch (PersistentException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Subir un nuevo curso a la base de datos
     * @param cur Curso a subir
     */
    public void uploadData(Curso cur){
        try {
            CreateProyecto1Data c = new CreateProyecto1Data();
            c.createTestData(cur);
        } catch (PersistentException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * subir todos los cursos generados con el poblamiento de datos
     * (este método se utiliza sólo en el Main de la capa de negocios que realiza 
     * el poblamiento inicial y lo sube, en caso de haber dañado los datos en la base de datos
     * utilizar este Main)
     * @deprecated 
     */
    public void uploadData() {
        CreateProyecto1Data c = new CreateProyecto1Data();
        for (int j = 1; j < 17; j++) {
            String curso = j + "A";
            if (j >= 9) {
                curso = "" + (j - 8) + "B";
            }
            Curso cur = (Curso) ser.cargarGson(Curso.class, "cursos/curso" + curso + "/curso" + curso);
            try {
                c.createTestData(cur);
            } catch (PersistentException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    orm.Proyecto1PersistentManager.instance().disposePersistentManager();
                } catch (PersistentException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Leer la base de datos y materializar un curso determinado para ser utilizado en el programa
     * @param curso String con el identificador del curso ej: (1 A)
     * @return Curso materializado con sus datos correspondientes
     * @throws PersistentException
     */
    public Curso retrieveCurso(String curso) throws PersistentException{
        RetrieveProyecto1Data p = new RetrieveProyecto1Data();
        Curso cur = p.retrieveCurso(curso);
        return cur;
    }
    
    /**
     * Añadir alumno a la base de datos
     * @param ap Apoderado del alumno
     * @param asistencias cantidad de registros de asistencia del curso
     * @param curso curso del alumno
     * @param nombre nombre del alumno
     * @param cantNotas cantidad de notas del curso
     * @param cantNotasAsig cantidad de notas de actividades del curso
     * @param apExis true: se utilizó un apoderado existente en la base de datos, false: se creó un nuevo apoderado
     */
    public void addAlumno(Apoderado ap,int asistencias,String curso,String nombre,ArrayList<String> cantNotas,ArrayList<String> cantNotasAsig,boolean apExis){
        CreateProyecto1Data c = new CreateProyecto1Data();
        Alumno al = new Alumno();
        ArrayList<Boolean> asistencia = new ArrayList();
        for (int i = 0; i < asistencias; i++) {
            asistencia.add(false);
        }
        ArrayList<String> notas = new ArrayList();
        for (int i = 0; i < cantNotas.size(); i++) {
            String asig = cantNotas.get(i).split(",")[2];
            notas.add("0,20," + asig);
        }
        ArrayList<String> notasAsig = new ArrayList();
        for(int i =0;i<cantNotasAsig.size();i++){
            String asig = cantNotasAsig.get(i).split(",")[1];
            notasAsig.add("0,"+asig);
        }
        al.setAnotaciones(new ArrayList());
        al.setApoderado(ap);
        al.setAsistencia(asistencia);
        al.setCurso(curso);
        al.setNombre(nombre);
        al.setNotas(notas);
        al.setNotasAsig(notasAsig);
        c.addAlumno(al,apExis);
    }
    
    /**
     * Actualizar datos de un curso que ya existe en la base de datos
     * @param cur curso a actualizar
     * @throws PersistentException
     */
    public void updateData(Curso cur)throws PersistentException{
        RetrieveAndUpdateProyecto1Data u = new RetrieveAndUpdateProyecto1Data();
        //for(int i = 1; i<17;i++){
            /*String curso = i + "A";
            if (i >= 9) {
                curso = "" + (i - 8) + "B";
            }*/
            //Curso cur = (Curso) ser.cargarGson(Curso.class, "cursos/curso" + curso + "/curso" + curso);
            u.retrieveAndUpdateTestData(cur);
        //}
    }
    
    /**
     * Verificar que letras de un determinado nivel existen en la base de datos
     * @param nivel nivel a verificar de 1 a 8
     * @return arraylist con las letras de los cursos que existen de este nivel (A,B,C,etc)
     */
    public ArrayList<String> existCurso(int nivel){
        RetrieveProyecto1Data p = new RetrieveProyecto1Data();
        return p.existCurso(nivel);
    }
    
    /**
     * Añadir curso nuevo a la base de datos
     * @param nivel nivel al que añadir el nuevo curso (1 a 8)
     */
    public void addCurso(int nivel){
        try {
            CreateProyecto1Data c = new CreateProyecto1Data();
            char[] abc = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            ArrayList<String> letras = existCurso(nivel);
            Curso cur = new Curso(nivel, abc[letras.size()]);
            cur.setAsignaturas(new ArrayList());
            cur.setAlumnos(new ArrayList());
            c.createTestData(cur);
        } catch (PersistentException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Añadir asignatura a la base de datos
     * @param as objeto asignatura a añadir
     * @param existprof true: se utiliza un profesor existente en la base de datos. false: se utiliza un nuevo profesor.
     */
    public void addAsignatura(Asignatura as,boolean existprof){
        CreateProyecto1Data c = new CreateProyecto1Data();
        c.addAsignatura(as, existprof);
    }
}
