/*
 * Autor: Diego Garrido
 */
package services;

import com.archivos.Database;
import com.archivos.Generator;
import com.proyecto1.Curso;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ormsamples.CreateProyecto1DatabaseSchema;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "Generate")
public class Generate {

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "generate")
    public String generate() {
        Database dat = new Database();
        Generator gen = new Generator();
        String[] args = null;
        if (dat.estadoTablas()) {
            dat.deleteData();
        } else {
            CreateProyecto1DatabaseSchema.main(args);
        }
        for (int i = 1; i < 17; i++) {
            Curso cur = gen.generar(i);
            dat.uploadData(cur);
        }
        return "Nuevo Colegio Generado";
    }
}
