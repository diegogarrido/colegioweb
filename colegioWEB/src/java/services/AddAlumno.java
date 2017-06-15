/*
 * Autor: Diego Garrido
 */
package services;

import com.archivos.Database;
import com.proyecto1.Apoderado;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "AddAlumno")
public class AddAlumno {

    /**
     * Web service operation
     * @param ap
     * @param asistencias
     * @param curso
     * @param nombre
     * @param cantNotas
     * @param cantNotasAsig
     * @param apExis
     * @return 
     */
    @WebMethod(operationName = "addAlumno")
    public String addAlumno(@WebParam(name = "ap") Apoderado ap, @WebParam(name = "asistencias") int asistencias, @WebParam(name = "curso") String curso, @WebParam(name = "nombre") String nombre, @WebParam(name = "cantNotas") ArrayList cantNotas, @WebParam(name = "cantNotasAsig") ArrayList cantNotasAsig, @WebParam(name = "apExis") boolean apExis) {
        Database dat = new Database();
        ap.getHijos().add(nombre);
        dat.addAlumno(ap, asistencias, curso, nombre, cantNotas, cantNotasAsig, apExis);
        return "Alumno Agregado";
    }

    /**
     * Web service operation
     * @param nombreAp Nombre de apoderados
     * @param asistencias Cantidad de registros de asistencia
     * @param curso Curso
     * @param nombre Nombre del alumno
     * @param cantNotas Cantidad de notas
     * @param cantNotasAsig Cantidad de notas de actividades
     * @return 
     
    @WebMethod(operationName = "addApoderado")
    public String addApoderado(@WebParam(name = "nombreApoderado") String nombreAp, @WebParam(name = "asistencias") int asistencias, @WebParam(name = "curso") String curso, @WebParam(name = "nombre") String nombre, @WebParam(name = "cantNotas") int cantNotas, @WebParam(name = "cantNotasAsig") int cantNotasAsig) {
        Apoderado ap = new Apoderado(nombreAp);
        ArrayList<String> array=new ArrayList();
        for(int i=0;i<cantNotas;i++){
            array.add("0,20,Asignatura 1 A");
        }
        ArrayList<String> array2=new ArrayList();
        for(int i=0;i<cantNotasAsig;i++){
            array2.add("0,Asignatura 1 A");
        }
        addAlumno(ap, asistencias, curso, nombre, array, array2,false);
        return "Apoderado Creado";
    }*/
}
