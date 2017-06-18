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
@WebService(serviceName = "AddAsistencia")
@Stateless()
public class AddAsistencia {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public Curso add(@WebParam(name = "curso") String curso) {
        try {
            RetrieveCurso r = new RetrieveCurso();
            Curso cur = r.retrieveCurso(curso);
            for (int i = 0; i < cur.getAlumnos().size(); i++) {
                cur.getAlumnos().get(i).añadirAsistencia();
            }
            UpdateCurso u = new UpdateCurso();
            u.updateCurso(cur);
            return cur;
        } catch (Exception e) {
            return null;
        }
    }
}
