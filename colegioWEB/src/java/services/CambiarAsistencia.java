/*
 * Autor: Diego Garrido
 */
package services;

import com.proyecto1.Curso;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "CambiarAsistencia")
@Stateless()
public class CambiarAsistencia {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiar")
    public Curso cambiar(@WebParam(name = "idAlumno") int idAlumno, @WebParam(name = "curso") String curso, @WebParam(name = "idAsistencia") int idAsistencia) {
        try {
            RetrieveCurso r = new RetrieveCurso();
            Curso cur = r.retrieveCurso(curso);
            cur.getAlumnos().get(idAlumno).getAsistencia().set(idAsistencia, !cur.getAlumnos().get(idAlumno).getAsistencia().get(idAsistencia));
            UpdateCurso u = new UpdateCurso();
            u.updateCurso(cur);
            return cur;
        } catch (Exception e) {
            return null;
        }
    }
}
