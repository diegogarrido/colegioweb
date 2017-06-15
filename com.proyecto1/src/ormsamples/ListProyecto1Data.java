/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;

/**
 * Listar los datos de la base de datos
 * @author Diego
 */
public class ListProyecto1Data {

    private static final int ROW_COUNT = 500;

    /**
     * Listar
     * @throws PersistentException
     */
    public void listTestData() throws PersistentException {
        System.out.println("Listing Alumno...");
        orm.Alumno[] ormAlumnos = orm.AlumnoDAO.listAlumnoByQuery(null, null);
        int length = Math.min(ormAlumnos.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormAlumnos[i]);
            System.out.println("nombre: " + ormAlumnos[i].getNombre());
            System.out.println("curso: " + ormAlumnos[i].getCurso());
            System.out.println("apoderado: " + ormAlumnos[i].getApoderado_id_fk());
            System.out.println("notas: " + ormAlumnos[i].getNotas());
            System.out.println("notas asig: " + ormAlumnos[i].getNotasAsig());
            System.out.println("asistencia: " + ormAlumnos[i].getAsistencia());
            System.out.println("anotaciones: " + ormAlumnos[i].getAnotaciones());
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Apoderado...");
        orm.Apoderado[] ormApoderados = orm.ApoderadoDAO.listApoderadoByQuery(null, null);
        length = Math.min(ormApoderados.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormApoderados[i]);
            System.out.println("nombre: " + ormApoderados[i].getNombre());
            System.out.println("hijos: " + ormApoderados[i].getHijos());
            System.out.println("alumno: " + ormApoderados[i].getAlumno());
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Asignatura...");
        orm.Asignatura[] ormAsignaturas = orm.AsignaturaDAO.listAsignaturaByQuery(null, null);
        length = Math.min(ormAsignaturas.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormAsignaturas[i]);
            System.out.println("nombre: "+ormAsignaturas[i].getNombre());
            System.out.println("planificacion: "+ormAsignaturas[i].getPlanificacion());
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Profesor...");
        orm.Profesor[] ormProfesors = orm.ProfesorDAO.listProfesorByQuery(null, null);
        length = Math.min(ormProfesors.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormProfesors[i]);
            System.out.println("nombre: "+ormProfesors[i].getNombre());
        }
        System.out.println(length + " record(s) retrieved.");

        System.out.println("Listing Curso...");
        orm.Curso[] ormCursos = orm.CursoDAO.listCursoByQuery(null, null);
        length = Math.min(ormCursos.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormCursos[i]);
            System.out.println("nivel: "+ormCursos[i].getNivel());
            System.out.println("letra: "+ormCursos[i].getLetra());
        }
        System.out.println(length + " record(s) retrieved.");
        
        System.out.println("Alumnos: "+ormAlumnos.length);
        System.out.println("Apoderados: "+ormApoderados.length);
        System.out.println("Asignaturas: "+ormAsignaturas.length);
        System.out.println("Profesores: "+ormProfesors.length);
        System.out.println("Cursos: "+ormCursos.length);
    }
/*
    public void listByCriteria() throws PersistentException {
        System.out.println("Listing Alumno by Criteria...");
        orm.AlumnoCriteria lormAlumnoCriteria = new orm.AlumnoCriteria();
        // Please uncomment the follow line and fill in parameter(s) 
        //lormAlumnoCriteria.id.eq();
        lormAlumnoCriteria.setMaxResults(ROW_COUNT);
        orm.Alumno[] ormAlumnos = lormAlumnoCriteria.listAlumno();
        int length = ormAlumnos == null ? 0 : Math.min(ormAlumnos.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormAlumnos[i]);
        }
        System.out.println(length + " Alumno record(s) retrieved.");

        System.out.println("Listing Apoderado by Criteria...");
        orm.ApoderadoCriteria lormApoderadoCriteria = new orm.ApoderadoCriteria();
        // Please uncomment the follow line and fill in parameter(s) 
        //lormApoderadoCriteria.id.eq();
        lormApoderadoCriteria.setMaxResults(ROW_COUNT);
        orm.Apoderado[] ormApoderados = lormApoderadoCriteria.listApoderado();
        length = ormApoderados == null ? 0 : Math.min(ormApoderados.length, ROW_COUNT);
        for (int i = 0; i < length; i++) {
            System.out.println(ormApoderados[i]);
        }
        System.out.println(length + " Apoderado record(s) retrieved.");
    }
*/

    /**
     * Main
     * @param args
     */

    public static void main(String[] args) {
        try {
            ListProyecto1Data listProyecto1Data = new ListProyecto1Data();
            try {
                listProyecto1Data.listTestData();
                //listProyecto1Data.listByCriteria();
            } finally {
                orm.Proyecto1PersistentManager.instance().disposePersistentManager();
            }
        } catch (Exception e) {
        }
    }
}
