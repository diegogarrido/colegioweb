package ormsamples;

import com.archivos.Serial;
import com.proyecto1.Alumno;
import com.proyecto1.Apoderado;
import com.proyecto1.Asignatura;
import com.proyecto1.Curso;
import com.proyecto1.Profesor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

/**
 * Leer la base de datos y materializarla en Objetos
 *
 * @author Diego
 */
public class RetrieveProyecto1Data {

    Serial ser = new Serial();

    /**
     * Leer base de datos y materializar un curso determinado
     *
     * @param curs String del curso a materializar ej: 1 A
     * @return Curso materializado
     * @throws PersistentException
     */
    public Curso retrieveCurso(String curs) throws PersistentException {
        try {
            Curso cur = new Curso(Integer.parseInt(curs.split(" ")[0]), curs.split(" ")[1].charAt(0));
            String curso = "" + cur.getNivel() + " " + cur.getLetra();
            ArrayList<Integer> indexes = new ArrayList();
            orm.Alumno[] ormAlumnos = orm.AlumnoDAO.listAlumnoByQuery(null, null);
            for (int i = 0; i < ormAlumnos.length; i++) {
                if (ormAlumnos[i].getCurso().equals(curso)) {
                    indexes.add(i);
                }
            }
            for (int i = 0; i < indexes.size(); i++) {
                Apoderado ap = new Apoderado(ormAlumnos[indexes.get(i)].getApoderado_id_fk().getNombre());
                ap.setHijos((ArrayList<String>) ser.deserializar(ArrayList.class, ormAlumnos[indexes.get(i)].getApoderado_id_fk().getHijos()));
                Alumno al = new Alumno(ormAlumnos[indexes.get(i)].getNombre(), ormAlumnos[indexes.get(i)].getCurso(), ap);
                al.setAnotaciones((ArrayList<String>) ser.deserializar(ArrayList.class, ormAlumnos[indexes.get(i)].getAnotaciones()));
                al.setAsistencia((ArrayList<Boolean>) (ser.deserializar(ArrayList.class, ormAlumnos[indexes.get(i)].getAsistencia())));
                al.setNotas((ArrayList<String>) ser.deserializar(ArrayList.class, ormAlumnos[indexes.get(i)].getNotas()));
                al.setNotasAsig((ArrayList<String>) ser.deserializar(ArrayList.class, ormAlumnos[indexes.get(i)].getNotasAsig()));
                cur.getAlumnos().add(al);
            }
            orm.Asignatura[] ormAsignaturas = orm.AsignaturaDAO.listAsignaturaByQuery(null, null);
            for (orm.Asignatura ormAsignatura : ormAsignaturas) {
                if (ormAsignatura.getNombre().contains(curso)) {
                    Profesor prof = new Profesor(ormAsignatura.getProfesorid_id_fk().getNombre());
                    prof.setAsignaturas((ArrayList<String>) ser.deserializar(ArrayList.class, ormAsignatura.getProfesorid_id_fk().getAsignaturas()));
                    Asignatura as = new Asignatura(prof, ormAsignatura.getNombre());
                    as.setPlanificacion((ArrayList<String>) ser.deserializar(ArrayList.class, ormAsignatura.getPlanificacion()));
                    cur.getAsignaturas().add(as);
                }
            }
            return cur;
        } catch (org.hibernate.exception.SQLGrammarException ex) {
            return null;
        }
    }

    /**
     * Verificar que letras existen de un determinado nivel
     * @param nivel Nivel a examinar
     * @return ArrayList con las letras existentes (A,B,etc)
     */
    public ArrayList<String> existCurso(int nivel) {
        ArrayList<String> result = new ArrayList();
        try {
            orm.Curso[] lormCursos = orm.CursoDAO.listCursoByQuery(null, null);
            for (orm.Curso lormCurso : lormCursos) {
                if (lormCurso.getNivel() == nivel) {
                    result.add("" + lormCurso.getLetra());
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(RetrieveProyecto1Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
