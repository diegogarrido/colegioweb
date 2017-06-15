/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import com.archivos.Serial;
import com.proyecto1.Curso;
import java.util.ArrayList;
import org.orm.*;
import orm.Alumno;

/**
 * Leer y actualizar base de datos
 * @author Diego
 */
public class RetrieveAndUpdateProyecto1Data {

    /**
     * Actualizar un curso determinado de la base de datos
     * @param cur Curso a actualizar
     * @throws PersistentException
     */
    public void retrieveAndUpdateTestData(Curso cur) throws PersistentException {
        PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();
        Serial ser = new Serial();
        orm.Curso[] lormCursos = orm.CursoDAO.listCursoByQuery(null, null);
        int idcur = 0;
        for (int i = 0; i < lormCursos.length; i++) {
            String c = "" + lormCursos[i].getNivel() + lormCursos[i].getLetra();
            if (c.equals("" + cur.getNivel() + cur.getLetra())) {
                idcur = i;
            }
        }
        try {
            ArrayList<Integer> indexes =  new ArrayList();
            orm.Alumno[] lormAlumnos = orm.AlumnoDAO.listAlumnoByQuery(null, null);
            for (Alumno lormAlumno : lormAlumnos) {
                if (lormAlumno.getCurso().equals(lormCursos[idcur].getNivel()+" "+lormCursos[idcur].getLetra())) {
                    indexes.add(lormAlumno.getId_pk());
                }
            }
            for (int i = 0; i < indexes.size(); i++) {
                orm.Alumno lormAlumno = orm.AlumnoDAO.loadAlumnoByORMID(indexes.get(i));
                lormAlumno.setAnotaciones(ser.serializar(cur.getAlumnos().get(i).getAnotaciones()));
                lormAlumno.setAsistencia(ser.serializar(cur.getAlumnos().get(i).getAsistencia()));
                lormAlumno.setNotas(ser.serializar(cur.getAlumnos().get(i).getNotas()));
                lormAlumno.setNotasAsig(ser.serializar(cur.getAlumnos().get(i).getNotasAsig()));
                orm.AlumnoDAO.save(lormAlumno);
            }
            indexes.clear();
            orm.Asignatura[] lormAsignaturas = orm.AsignaturaDAO.listAsignaturaByQuery(null,null);
            String c =""+lormCursos[idcur].getNivel()+" "+lormCursos[idcur].getLetra();
            for(int i=0;i<lormAsignaturas.length;i++){
                if(lormAsignaturas[i].getNombre().contains(c)){
                    indexes.add(i);
                }
            }
            for (int i = 0; i < indexes.size(); i++) {
                orm.Asignatura lormAsignatura = lormAsignaturas[indexes.get(i)];
                lormAsignatura.setPlanificacion(ser.serializar(cur.getAsignaturas().get(i).getPlanificacion()));
                lormAsignatura.getProfesorid_id_fk().setAsignaturas(ser.serializar(cur.getAsignaturas().get(i).getProfesor().getAsignaturas()));
                orm.AsignaturaDAO.save(lormAsignatura);
            }
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }

    }
/*
    public void retrieveByCriteria() throws PersistentException {
        System.out.println("Retrieving Alumno by AlumnoCriteria");
        orm.AlumnoCriteria lormAlumnoCriteria = new orm.AlumnoCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lormAlumnoCriteria.id_pk.eq();
        System.out.println(lormAlumnoCriteria.uniqueAlumno());

        System.out.println("Retrieving Apoderado by ApoderadoCriteria");
        orm.ApoderadoCriteria lormApoderadoCriteria = new orm.ApoderadoCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lormApoderadoCriteria.id_pk.eq();
        System.out.println(lormApoderadoCriteria.uniqueApoderado());

        System.out.println("Retrieving Asignatura by AsignaturaCriteria");
        orm.AsignaturaCriteria lormAsignaturaCriteria = new orm.AsignaturaCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lormAsignaturaCriteria.id_pk.eq();
        System.out.println(lormAsignaturaCriteria.uniqueAsignatura());

        System.out.println("Retrieving Profesor by ProfesorCriteria");
        orm.ProfesorCriteria lormProfesorCriteria = new orm.ProfesorCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lormProfesorCriteria.id_pk.eq();
        System.out.println(lormProfesorCriteria.uniqueProfesor());

        System.out.println("Retrieving Curso by CursoCriteria");
        orm.CursoCriteria lormCursoCriteria = new orm.CursoCriteria();
        // Please uncomment the follow line and fill in parameter(s)
        //lormCursoCriteria.id_pk.eq();
        System.out.println(lormCursoCriteria.uniqueCurso());

    }
*/
}
