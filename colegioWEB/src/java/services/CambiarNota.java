/*
 * Autor: Diego Garrido
 */
package services;

import com.proyecto1.Curso;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "CambiarNota")
@Stateless()
public class CambiarNota {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarNota")
    public String cambiarNota(@WebParam(name = "idAlumno") int idAlumno, @WebParam(name = "curso") String curso, @WebParam(name = "idActividad") int idActividad, @WebParam(name = "nota") String nota, @WebParam(name = "asignatura") String asignatura) {
        RetrieveCurso ret = new RetrieveCurso();
        UpdateCurso u = new UpdateCurso();
        try {
            Curso cur = ret.retrieveCurso(curso);
            if (idActividad < 4) {
                ArrayList<Integer> indexes = new ArrayList();
                for (int i = 0; i < cur.getAlumnos().get(idAlumno).getNotas().size(); i++) {
                    if (cur.getAlumnos().get(idAlumno).getNotas().get(i).contains(asignatura)) {
                        indexes.add(i);
                    }
                }
                String not = cur.getAlumnos().get(idAlumno).getNotas().get(indexes.get(idActividad));
                String[] split = not.split(",");
                split[0] = nota;
                not = split[0] + "," + split[1] + "," + split[2];
                cur.getAlumnos().get(idAlumno).getNotas().set(indexes.get(idActividad), not);
                u.updateCurso(cur);
                return "Nota cambiada exitosamente";
            } else {
                ArrayList<Integer> indexes = new ArrayList();
                for (int i = 0; i < cur.getAlumnos().get(idAlumno).getNotasAsig().size(); i++) {
                    if (cur.getAlumnos().get(idAlumno).getNotasAsig().get(i).contains(asignatura)) {
                        indexes.add(i);
                    }
                }
                idActividad -= 5;
                String not = cur.getAlumnos().get(idAlumno).getNotasAsig().get(indexes.get(idActividad));
                String[] split = not.split(",");
                split[0] = nota;
                not = split[0] + "," + split[1];
                cur.getAlumnos().get(idAlumno).getNotasAsig().set(indexes.get(idActividad), not);
                cur.getAlumnos().get(idAlumno).promediarNotasAsig(asignatura);
                u.updateCurso(cur);
                return "Nota cambiada exitosamente";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
