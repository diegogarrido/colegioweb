/**
 * Clase creadora de datos en la base de datos
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
import com.archivos.Serial;
import com.proyecto1.Alumno;
import com.proyecto1.Asignatura;
import com.proyecto1.Curso;
import com.proyecto1.Profesor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateProyecto1Data {

    /**
     * Crear un curso en la base de datos
     * @param cur curso a subir
     * @throws PersistentException
     */
    public void createTestData(Curso cur) throws PersistentException {
        PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();
        Serial ser = new Serial();
        orm.Curso lormCurso = orm.CursoDAO.createCurso();
        lormCurso.setLetra(cur.getLetra());
        lormCurso.setNivel(cur.getNivel());
        orm.CursoDAO.save(lormCurso);
        for (int i = 0; i < cur.getAlumnos().size(); i++) {

            orm.Alumno lormAlumno = orm.AlumnoDAO.createAlumno();
            lormAlumno.setNombre(cur.getAlumnos().get(i).getNombre());
            lormAlumno.setCurso(cur.getAlumnos().get(i).getCurso());
            lormAlumno.setNotas(ser.serializar(cur.getAlumnos().get(i).getNotas()));
            lormAlumno.setNotasAsig(ser.serializar(cur.getAlumnos().get(i).getNotasAsig()));
            lormAlumno.setAsistencia(ser.serializar(cur.getAlumnos().get(i).getAsistencia()));
            lormAlumno.setAnotaciones(ser.serializar(cur.getAlumnos().get(i).getAnotaciones()));
            lormAlumno.setCursoid_id_fk(lormCurso);

            orm.Apoderado lormApoderado = orm.ApoderadoDAO.createApoderado();
            lormApoderado.setNombre(cur.getAlumnos().get(i).getApoderado().getNombre());
            lormApoderado.setHijos(ser.serializar(cur.getAlumnos().get(i).getApoderado().getHijos()));
            lormApoderado.setAlumno(lormAlumno);
            orm.ApoderadoDAO.save(lormApoderado);

            lormAlumno.setApoderado_id_fk(lormApoderado);
            orm.AlumnoDAO.save(lormAlumno);
            orm.ApoderadoDAO.save(lormApoderado);
        }
        for (int i = 0; i < cur.getAsignaturas().size(); i++) {
            orm.Profesor lormProfesor = orm.ProfesorDAO.createProfesor();
            lormProfesor.setNombre(cur.getAsignaturas().get(i).getProfesor().getNombre());
            lormProfesor.setAsignaturas(ser.serializar(cur.getAsignaturas().get(i).getProfesor().getAsignaturas()));
            orm.ProfesorDAO.save(lormProfesor);

            orm.Asignatura lormAsignatura = orm.AsignaturaDAO.createAsignatura();
            lormAsignatura.setCursoid_fk(lormCurso);
            lormAsignatura.setProfesorid_id_fk(lormProfesor);
            lormAsignatura.setNombre(cur.getAsignaturas().get(i).getNombre());
            lormAsignatura.setPlanificacion(ser.serializar(cur.getAsignaturas().get(i).getPlanificacion()));
            orm.AsignaturaDAO.save(lormAsignatura);
        }

        try {
            t.commit();
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
        //System.out.println(curs + " guardado :" + t.wasCommitted());
    }

    /**
     * Agregar un nuevo curso a la base de datos
     * @param cur curso a agregar
     */
    public void addCurso(Curso cur) {
        try {
            PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();

            orm.Curso lormCurso = orm.CursoDAO.createCurso();
            lormCurso.setNivel(cur.getNivel());
            lormCurso.setLetra(cur.getLetra());
            
            orm.CursoDAO.save(lormCurso);
            try {
                t.commit();
            } catch (Exception ex) {
                System.out.println(ex.getCause());
            }
        } catch (PersistentException ex) {
            Logger.getLogger(CreateProyecto1Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Agregar una nueva asignatura en la base de datos
     * @param as Asignatura a añadir
     * @param exisProf true: la imparte un profesor existente en la base de datos. false: la imparte un nuevo profesor que se debe agregar a la base de datos.
     */
    public void addAsignatura(Asignatura as, boolean exisProf) {
        try {
            PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();
            Serial ser = new Serial();
            orm.Curso[] lormCursos = orm.CursoDAO.listCursoByQuery(null, null);
            int idCur = -1;
            for (int i = 0; i < lormCursos.length; i++) {
                if (as.getNombre().contains(lormCursos[i].getNivel() + " " + lormCursos[i].getLetra())) {
                    idCur = i;
                }
            }
            orm.Asignatura lormAsignatura = orm.AsignaturaDAO.createAsignatura();
            lormAsignatura.setNombre(as.getNombre());
            lormAsignatura.setCursoid_fk(lormCursos[idCur]);
            lormAsignatura.setPlanificacion(ser.serializar(as.getPlanificacion()));
            if (exisProf) {
                orm.Profesor[] lormProfesores = orm.ProfesorDAO.listProfesorByQuery(null, null);
                for (int i = 0; i < lormProfesores.length; i++) {
                    if (lormProfesores[i].getNombre().equals(as.getProfesor().getNombre())) {
                        lormProfesores[i].setAsignaturas(ser.serializar(as.getProfesor().getAsignaturas()));
                        lormAsignatura.setProfesorid_id_fk(lormProfesores[i]);
                        break;
                    }
                }
            } else {
                orm.Profesor lormProfesor = orm.ProfesorDAO.createProfesor();
                lormProfesor.setNombre(as.getProfesor().getNombre());
                lormProfesor.setAsignaturas(ser.serializar(as.getProfesor().getAsignaturas()));
                lormAsignatura.setProfesorid_id_fk(lormProfesor);
                orm.ProfesorDAO.save(lormProfesor);
                
            }
            try {
                t.commit();
            } catch (Exception ex) {
                System.out.println(ex.getCause());
            }
        } catch (PersistentException ex) {
            Logger.getLogger(CreateProyecto1Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Añadir pofesor a la base de datos
     * @param prof profesor a añadir
     */
    public void addProfesor(Profesor prof) {
        try {
            PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();
            orm.Profesor lormProfesor = orm.ProfesorDAO.createProfesor();
            lormProfesor.setNombre(prof.getNombre());
            Serial ser = new Serial();
            lormProfesor.setAsignaturas(ser.serializar(prof.getAsignaturas()));
            orm.ProfesorDAO.save(lormProfesor);
            try {
                t.commit();
            } catch (Exception ex) {
                System.out.println(ex.getCause());
            }
        } catch (PersistentException ex) {
            Logger.getLogger(CreateProyecto1Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Añadir alumno a la base de datos
     * @param al Alumno a añadir
     * @param exisAp true: su apoderado está en la base de datos. false: su apoderado se debe agregar a la base de datos.
     */
    public void addAlumno(Alumno al, boolean exisAp) {
        try {
            PersistentTransaction t = orm.Proyecto1PersistentManager.instance().getSession().beginTransaction();
            Serial ser = new Serial();

            orm.Alumno lormAlumno = orm.AlumnoDAO.createAlumno();
            lormAlumno.setAnotaciones(ser.serializar(al.getAnotaciones()));
            if (exisAp) {
                orm.Apoderado[] lormApoderados = orm.ApoderadoDAO.listApoderadoByQuery(null, null);
                for (int i = 0; i < lormApoderados.length; i++) {
                    String nomAp = lormApoderados[i].getNombre().toLowerCase();
                    if (nomAp.equals(al.getApoderado().getNombre().toLowerCase())) {
                        lormApoderados[i].setHijos(ser.serializar(al.getApoderado().getHijos()));
                    }
                }
            }
            orm.Apoderado lormApoderado = orm.ApoderadoDAO.createApoderado();
            lormApoderado.setNombre(al.getApoderado().getNombre());
            lormApoderado.setHijos(ser.serializar(al.getApoderado().getHijos()));
            lormApoderado.setAlumno(lormAlumno);
            lormAlumno.setApoderado_id_fk(lormApoderado);

            lormAlumno.setAsistencia(ser.serializar(al.getAsistencia()));
            lormAlumno.setCurso(al.getCurso());
            orm.Curso[] lormCursos = orm.CursoDAO.listCursoByQuery(null, null);
            int idcur = 0;
            for (int i = 0; i < lormCursos.length; i++) {
                String c = "" + lormCursos[i].getNivel() + " " + lormCursos[i].getLetra();
                if (c.equals(al.getCurso())) {
                    idcur = i;
                }
            }
            lormAlumno.setCursoid_id_fk(lormCursos[idcur]);
            lormAlumno.setNombre(al.getNombre());
            lormAlumno.setNotas(ser.serializar(al.getNotas()));
            lormAlumno.setNotasAsig(ser.serializar(al.getNotasAsig()));

            orm.AlumnoDAO.save(lormAlumno);
            try {
                t.commit();
            } catch (Exception ex) {
                System.out.println(ex.getCause());
            }
        } catch (PersistentException ex) {
            Logger.getLogger(CreateProyecto1Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
