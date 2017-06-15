/*
 * Autor: Diego Garrido
 */
package services;

import com.archivos.Database;
import com.proyecto1.Curso;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.orm.PersistentException;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "UpdateCurso")
@Stateless()
public class UpdateCurso {

    /**
     * Web service operation
     * @param curso
     * @return 
     */
    @WebMethod(operationName = "updateCurso")
    public String updateCurso(@WebParam(name = "curso") Curso curso) {
        Database dat = new Database();
        try {
            dat.updateData(curso);
        } catch (PersistentException ex) {
            return "Error";
        }
        return "Curso Actualizado";
    }
}
