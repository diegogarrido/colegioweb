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
@WebService(serviceName = "RetrieveCurso")
@Stateless()
public class RetrieveCurso {

    /**
     * Web service operation
     * @param curso
     * @return 
     */
    @WebMethod(operationName = "retrieveCurso")
    public Curso retrieveCurso(@WebParam(name = "curso") String curso) {
        try {
            Database dat = new Database();
            return dat.retrieveCurso(curso);
        } catch (PersistentException ex) {
            return null;
        }
    }
}
