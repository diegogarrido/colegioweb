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
@WebService(serviceName = "DeleteData")
@Stateless()
public class DeleteData {

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "deleteData")
    public String deleteData() {
        Database dat = new Database();
        dat.deleteData();
        return "Datos borrados";
    }
}
