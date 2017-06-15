/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
import orm.Alumno;
import orm.Apoderado;
import orm.Asignatura;
import orm.Curso;
import orm.Profesor;

/**
 * Borrar datos de las tablas sin hacer Drop
 * @author Diego
 */
public class DeleteProyecto1Data {

    /**
     * Borrar
     * @throws PersistentException
     */
    public void deleteData() throws PersistentException {
        PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();
        try {
            orm.Alumno[] lormAlumnos = orm.AlumnoDAO.listAlumnoByQuery(null, null);
            // Delete the persistent object
            for (Alumno lormAlumno : lormAlumnos) {
                lormAlumno.setApoderado_id_fk(null);
                lormAlumno.setCursoid_id_fk(null);
                orm.AlumnoDAO.delete(lormAlumno);
            }
            
            orm.Apoderado[] lormApoderados = orm.ApoderadoDAO.listApoderadoByQuery(null, null);
            // Delete the persistent object
            for (Apoderado lormApoderado : lormApoderados) {
                lormApoderado.setAlumno(null);
                orm.ApoderadoDAO.delete(lormApoderado);
            }
            
            orm.Asignatura[] lormAsignaturas = orm.AsignaturaDAO.listAsignaturaByQuery(null, null);
            // Delete the persistent object
            for (Asignatura lormAsignatura : lormAsignaturas) {
                lormAsignatura.setCursoid_fk(null);
                lormAsignatura.setProfesorid_id_fk(null);
                orm.AsignaturaDAO.delete(lormAsignatura);
            }
            
            orm.Profesor[] lormProfesores = orm.ProfesorDAO.listProfesorByQuery(null, null);
            // Delete the persistent object
            for (Profesor lormProfesore : lormProfesores) {
                orm.ProfesorDAO.delete(lormProfesore);
            }
            
            orm.Curso[] lormCursos = orm.CursoDAO.listCursoByQuery(null, null);
            // Delete the persistent object
            for (Curso lormCurso : lormCursos) {
                orm.CursoDAO.delete(lormCurso);
            }
            
            t.commit();
        } catch (Exception e) {
        }/*
        try {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "//localhost:3306/proyecto1?&useSSL=false";
            String connectionURL = "jdbc:mysql:" + dbName;
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(connectionURL + "&user=root&password=admin"); Statement st = conn.createStatement()) {
                st.executeUpdate("DELETE FROM alumno");
                st.executeUpdate("DELETE FROM apoderado");
                st.executeUpdate("DELETE FROM asignatura");
                st.executeUpdate("DELETE FROM profesor");
                st.executeUpdate("DELETE FROM curso");
            }
        } catch (ClassNotFoundException | SQLException e) {
        }*/
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        try {
            DeleteProyecto1Data deleteProyecto1Data = new DeleteProyecto1Data();
            try {
                deleteProyecto1Data.deleteData();
            } finally {
                orm.Proyecto1PersistentManager.instance().disposePersistentManager();
            }
        } catch (Exception e) {
        }
    }
}
