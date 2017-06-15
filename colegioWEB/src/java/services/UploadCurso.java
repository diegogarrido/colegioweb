/*
 * Autor: Diego Garrido
 */
package services;

import com.archivos.Database;
import com.proyecto1.Curso;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "UploadCurso")
@Stateless()
public class UploadCurso {

    /**
     * Web service operation
     * @param curso
     * @return 
     */
    @WebMethod(operationName = "uploadCurso")
    public String uploadCurso(@WebParam(name = "curso") Curso curso) {
        Database dat = new Database();
        dat.uploadData(curso);
        return "Curso agregado";
    }
}
