package com.archivos;

import com.google.gson.Gson;
import java.beans.XMLEncoder;
import java.io.*;
import org.json.JSONException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase administradora de datos locales
 *
 * @author Diego
 */
public final class Serial {

    Gson gson = new Gson();

    /**
     * Serialziar un objeto y guardarlo como json para ser utilizado por el
     * programa
     *
     * @param ob Un objeto cualquiera
     * @param archivo Nombre con el que guardar el archivo
     * @throws IOException
     */
    public void guardarGson(Object ob, String archivo) throws IOException {
        Gson gson = new Gson();
        String str = gson.toJson(ob);
        try (FileWriter file = new FileWriter("archivos/" + archivo + ".json")) {
            file.write(str);
        }
    }

    /**
     * Serializar un objeto a json
     * @param ob objeto a serializar
     * @return String con el json del objeto serializado
     */
    public String serializar(Object ob){
        String str;
        Gson gson = new Gson();
        str=gson.toJson(ob);
        return str;
    }
    
    /**
     * Deserializar json a objeto
     * @param aClass tipo de objeto
     * @param json String del json
     * @return objeto materializado desde el json
     */
    public Object deserializar(Class aClass,String json){
        Gson gson = new Gson();
        Object o = gson.fromJson(json, aClass);
        return o;
    }
    
    /**
     * Transformar un objeto a xml para ser utilizado en los reportes
     *
     * @param ob Clase a guardar
     * @param archivo Nombre del archivo
     * @throws JSONException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void guardarXml(Object ob, String archivo) throws JSONException, FileNotFoundException, IOException {
        FileOutputStream outputFile = new FileOutputStream("archivos/" + archivo + ".xml");
        try (XMLEncoder xe = new XMLEncoder(outputFile)) {
            xe.writeObject(ob);
        }
    }

    /**
     * Cargar y materializar un objeto a partir de datos guardados como json
     *
     * @param aClass Tipo de objeto que se va a construir
     * @param archivo Nombre del archivo a cargar
     * @return Un objeto del tipo entregado con los datos del json leído
     */
    public Object cargarGson(Class aClass, String archivo){
        Object obj=null;
        try {
            obj = gson.fromJson(new FileReader("archivos/" + archivo + ".json"), aClass);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    /**
     * Cargar un xml y transformarlo a Word con todos los datos del curso
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void planificacionWord(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/planificacionword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/planific.doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con todos los datos del curso
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void planificacionHtml(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();

        Source xslDoc = new StreamSource("archivos/planificacionhtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/planific.html";

        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con todos los datos del curso
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void planificacionExcel(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();

        Source xslDoc = new StreamSource("archivos/planificacionexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/planific.xls";

        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Word con los datos de la asignatura que
     * imparte cierto Profesor
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Profesor
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void asignaturaWord(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/asign" + nombre + ".doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con los datos de la asignatura que
     * imparte cierto Profesor
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Profesor
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void asignaturaHtml(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturahtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/asign" + nombre + ".html";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con los datos de la asignatura que
     * imparte cierto Profesor
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Profesor
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void asignaturaExcel(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/asign" + nombre + ".xls";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Word con los porcentajes de notas y
     * Asistencia de cierto alumno
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Alumno
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void porcentajesWord(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteAlumno" + nombre + ".doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con los porcentajes de notas y
     * Asistencia de cierto alumno
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Alumno
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void porcentajesHtml(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturahtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteAlumno" + nombre + ".html";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con los porcentajes de notas y
     * Asistencia de cierto alumno
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Alumno
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void porcentajesExcel(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteAlumno" + nombre + ".xls";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Word con los Alumnos bajo cierto
     * porcentaje de asistencia
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void asistenciaWord(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteAsistencia.doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con los Alumnos bajo cierto
     * porcentaje de asistencia
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void asistenciaHtml(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturahtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteAsistencia.html";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con los Alumnos bajo cierto
     * porcentaje de asistencia
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void asistenciaExcel(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteAsistencia.xls";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Word con los Alumnos en estado de
     * Reprobación y la razón
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void reprobadosWord(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reprobados.doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con los Alumnos en estado de
     * Reprobación y la razón
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void reprobadosHtml(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturahtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reprobados.html";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con los Alumnos en estado de
     * Reprobación y la razón
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void reprobadosExcel(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reprobados.xls";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Word con los Apoderados con más de un
     * hijo
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void apoderadosWord(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/apoderados.doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con los Apoderados con más de un
     * hijo
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void apoderadosHtml(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturahtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/apoderados.html";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con los Apoderados con más de un
     * hijo
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void apoderadosExcel(String archivo) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/apoderados.xls";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Word con la planificación de los hijos de
     * cierto Apoderado
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Apoderado
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void apoderadosWord(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaword.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteApoderado" + nombre + ".doc";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Html con la planificación de los hijos de
     * cierto Apoderado
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Apoderado
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void apoderadosHtml(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturahtml.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteApoderado" + nombre + ".html";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }

    /**
     * Cargar un xml y transformarlo a Excel con la planificación de los hijos
     * de cierto Apoderado
     *
     * @param archivo String con la ruta y nombre del archivo xml a cargar
     * @param nombre Nombre del Apoderado
     * @throws FileNotFoundException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void apoderadosExcel(String archivo, String nombre) throws FileNotFoundException, TransformerConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("archivos/asignaturaexcel.xsl");
        Source xmlDoc = new StreamSource("archivos/" + archivo + ".xml");
        archivo = archivo.substring(0, 14);
        String outputFileName = "archivos/" + archivo + "/reportes/reporteApoderado" + nombre + ".xls";
        OutputStream docFile = new FileOutputStream(outputFileName);
        Transformer trasform = tFactory.newTransformer(xslDoc);
        trasform.transform(xmlDoc, new StreamResult(docFile));
    }
}
