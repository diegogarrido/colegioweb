/*
 * Autor: Diego Garrido
 */
package services;

import com.proyecto1.Curso;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "AddActividad")
@Stateless()
public class AddActividad {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public String add(@WebParam(name = "idAsignatura") int idAsignatura, @WebParam(name = "curso") String curso, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "fecha") String fecha, @WebParam(name = "asignatura") String asignatura) {
        try {
            RetrieveCurso ret = new RetrieveCurso();
            Curso cur = ret.retrieveCurso(curso);
            cur.getAsignaturas().get(idAsignatura).añandirActividad(descripcion, false, fecha);
            for (int i = 0; i < cur.getAlumnos().size(); i++) {
                cur.getAlumnos().get(i).añadirNotaAsig(asignatura);
            }
            UpdateCurso u = new UpdateCurso();
            u.updateCurso(cur);
            return "Actividad agregada exitosamente";
        } catch (Exception ex) {
            return "Error: " + ex.getCause();
        }
    }
}
