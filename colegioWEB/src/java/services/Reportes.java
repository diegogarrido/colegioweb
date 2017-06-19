/*
 * Autor: Diego Garrido
 */
package services;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
/*import java.beans.XMLEncoder;
import java.io.FileNotFoundException;*/
import java.io.FileOutputStream;/*
import java.io.IOException;*/
import java.io.OutputStream;/*
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;*/
import java.io.Reader;
import java.io.StringReader;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Diego
 */
@WebService(serviceName = "Reportes")
@Stateless()
public class Reportes {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "word")
    public String word(@WebParam(name = "datos") Object ob, @WebParam(name = "nombre") String nombre, @WebParam(name = "xsl") String xsl) {
        try {
            XStream x = new XStream();
            Source xml = new StreamSource(new StringReader(x.toXML(ob)));
            Source xslDoc = new StreamSource(new FileInputStream(xsl));
            xsl = xsl.split("xslt")[0];
            File directorio = new File(xsl+"/reportes");
            directorio.mkdirs();
            OutputStream docFile = new FileOutputStream(xsl + "/reportes/" + nombre + ".doc");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xml, new StreamResult(docFile));
            return "Exito word";
        } catch (Exception ex) {
            return "Error: " + ex;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "html")
    public String html(@WebParam(name = "datos") Object ob, @WebParam(name = "nombre") String nombre, @WebParam(name = "xsl") String xsl) {
        try {
            XStream x = new XStream();
            Source xml = new StreamSource(new StringReader(x.toXML(ob)));
            Source xslDoc = new StreamSource(new FileInputStream(xsl));
            xsl = xsl.split("xslt")[0];
            File directorio = new File(xsl+"/reportes");
            directorio.mkdirs();
            OutputStream docFile = new FileOutputStream(xsl + "/reportes/" + nombre + ".html");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xml, new StreamResult(docFile));
            return "Exito html";
        } catch (Exception ex) {
            return "Error: " + ex;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "excel")
    public String excel(@WebParam(name = "datos") Object ob, @WebParam(name = "nombre") String nombre, @WebParam(name = "xsl") String xsl) {
        try {
            XStream x = new XStream();
            Source xml = new StreamSource(new StringReader(x.toXML(ob)));
            Source xslDoc = new StreamSource(new FileInputStream(xsl));
            xsl = xsl.split("xslt")[0];
            File directorio = new File(xsl+"/reportes");
            directorio.mkdirs();
            OutputStream docFile = new FileOutputStream(xsl + "/reportes/" + nombre + ".xls");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xml, new StreamResult(docFile));
            return "Exito excel";
        } catch (Exception ex) {
            return "Error: " + ex;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "xml")
    public String xml(@WebParam(name = "datos") Object ob, @WebParam(name = "nombre") String nombre, @WebParam(name = "xsl") String xsl) {
        try {
            XStream x = new XStream();
            Source xml = new StreamSource(new StringReader(x.toXML(ob)));
            xsl = xsl.split("xslt")[0];
            File directorio = new File(xsl+"/reportes");
            directorio.mkdirs();
            OutputStream docFile = new FileOutputStream(xsl + "/reportes/" + nombre + ".xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trasform = tFactory.newTransformer();
            trasform.transform(xml, new StreamResult(docFile));
            return "Exito excel";
        } catch (Exception ex) {
            return "Error: " + ex;
        }
    }
}
