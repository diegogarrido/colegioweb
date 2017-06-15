/*
 * Autor: Diego Garrido
 */
package services;

import com.archivos.Database;
import com.proyecto1.Asignatura;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "AddAsignatura")
@Stateless()
public class AddAsignatura {

    /**
     * Web service operation
     * @param asignatura
     * @param exisProf
     * @return 
     */
    @WebMethod(operationName = "addAsignatura")
    public String addAsignatura(@WebParam(name = "asignatura") Asignatura asignatura, @WebParam(name = "exisProf") boolean exisProf) {
        Database dat = new Database();
        dat.addAsignatura(asignatura, exisProf);
        return null;
    }
}
