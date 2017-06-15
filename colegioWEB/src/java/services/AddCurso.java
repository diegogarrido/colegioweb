/*
 * Autor: Diego Garrido
 */
package services;

import com.archivos.Database;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "AddCurso")
@Stateless()
public class AddCurso {

    /**
     * Web service operation
     * @param nivel
     * @return 
     */
    @WebMethod(operationName = "addCurso")
    public String addCurso(@WebParam(name = "nivel") int nivel) {
        Database dat = new Database();
        dat.addCurso(nivel);
        return "Curso Agregado";
    }
}
