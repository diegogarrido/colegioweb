/*
 * Autor: Diego Garrido
 */
package servlets;

import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.Reportes;
import services.RetrieveCurso;

/**
 *
 * @author Diego
 */
@WebServlet(name = "solicitarReporte", urlPatterns = {"/solicitarReporte"})
public class solicitarReporte extends HttpServlet {

    @EJB
    private RetrieveCurso retrieveCurso;

    @EJB
    private Reportes reportes;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Curso cur = null;
            ArrayList<Object> datos = null;
            String[] url = null;
            ServletContext s = null;
            String curso = request.getParameter("curso");
            String tipo = "null";
            if (request.getParameter("reportType") != null) {
                tipo = request.getParameter("reportType");
                cur = retrieveCurso.retrieveCurso(curso);
                datos = new ArrayList();
                url = new String[4];
                s = getServletContext();
            }
            switch (tipo) {
                case ("null"):
                    request.setAttribute("curso", curso);
                    request.getRequestDispatcher("solicitarReporte.jsp").forward(request, response);
                    break;
                case ("reprobados"):
                    datos.add(new Object[]{"<b>"});
                    datos.add(new Object[]{"Alumnos del curso " + curso + " en estado de repitencia:"});
                    datos.add(new Object[]{"</b>"});
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        if (cur.getAlumnos().get(i).estaReprobando()) {
                            datos.add(new Object[]{cur.getAlumnos().get(i).getNombre() + " por " + cur.getAlumnos().get(i).razonReprobado()});
                        }
                    }
                    generar(datos, curso, s, url, request, response, tipo, "reportReprobados.jsp");
                    break;
                case ("asistencia"):
                    int porcentaje = -1;
                    if (request.getParameter("porcentaje") != null) {
                        porcentaje = Integer.parseInt(request.getParameter("porcentaje"));
                        datos.add(new Object[]{"<b>"});
                        datos.add(new Object[]{"Alumnos del curso " + curso + " con porcentaje de asistencia bajo " + porcentaje + "%:"});
                        datos.add(new Object[]{"</b>"});
                        for (int i = 0; i < cur.getAlumnos().size(); i++) {
                            if (Double.parseDouble(cur.getAlumnos().get(i).getPorcentajeAsistencia().replaceAll("%", "")) < porcentaje) {
                                datos.add(new Object[]{cur.getAlumnos().get(i).getNombre() + " con " + cur.getAlumnos().get(i).getPorcentajeAsistencia()});
                                datos.add(new Object[]{"<br>"});
                            }
                        }
                        String msg = "<h3 style=\"text-align: center\">Reporte alumnos del curso " + curso + " con porcentaje bajo " + porcentaje + "%</h3>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".doc\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Descargar Word <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".html\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Ver HTML <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".xls\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Descargar Excel <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".xml\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Ver XML <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "            <h5 style=\"text-align: center\">se pueden guardar los HTML y XML haciendo click derecho, guardar como</h5>";
                        generarMsg(datos, curso, s, request, response, tipo, msg);
                    } else {
                        request.setAttribute("curso", curso);
                        request.setAttribute("reportType", tipo);
                        request.getRequestDispatcher("reportAsistencia.jsp").forward(request, response);
                    }
                    break;
                case ("porcentaje"):
                    int idAlumno = -1;
                    if (request.getParameter("idAlumno") != null) {
                        idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
                        int rojos = 0;
                        datos.add(new Object[]{"<b>"});
                        datos.add(new Object[]{"Reporte porcentaje de asistencia y notas:"});
                        datos.add(new Object[]{"</b>"});
                        datos.add(new Object[]{"Alumno: " + cur.getAlumnos().get(idAlumno).getNombre()});
                        datos.add(new Object[]{"Porcentaje asistencia: " + cur.getAlumnos().get(idAlumno).getPorcentajeAsistencia()});
                        datos.add(new Object[]{"Notas: "});
                        for (int i = 0; i < cur.getAsignaturas().size(); i++) {
                            datos.add(new Object[]{cur.getAsignaturas().get(i).getNombre() + ": (Promedio: " + cur.getAlumnos().get(idAlumno).getPromedioAsignatura(cur.getAsignaturas().get(i).getNombre()) + ")"});
                            if (Double.parseDouble(cur.getAlumnos().get(idAlumno).getPromedioAsignatura(cur.getAsignaturas().get(i).getNombre())) < 4.0) {
                                rojos++;
                            }
                            int cont = 0;
                            for (int j = 0; j < cur.getAlumnos().get(idAlumno).getNotas().size(); j++) {
                                if (cur.getAlumnos().get(idAlumno).getNotas().get(j).contains(cur.getAsignaturas().get(i).getNombre())) {
                                    datos.add(new Object[]{"Actividad: " + cur.getAsignaturas().get(i).getPlanificacion().get(cont).split(",")[0] + " Nota: " + cur.getAlumnos().get(idAlumno).getNotas().get(j).split(",")[0] + " Ponderacion: " + cur.getAlumnos().get(idAlumno).getNotas().get(j).split(",")[1] + "%"});
                                    cont++;
                                }
                            }
                        }
                        datos.add(new Object[]{"Promedio General: " + cur.getAlumnos().get(idAlumno).getPromedio()});
                        datos.add(new Object[]{"Promedios rojos: " + rojos});
                        if (cur.getAlumnos().get(idAlumno).estaReprobando()) {
                            datos.add(new Object[]{"<font color=\"red\">"});
                            datos.add(new Object[]{"Condicion: No Aprueba"});
                            datos.add(new Object[]{"Por: "+cur.getAlumnos().get(idAlumno).razonReprobado()});
                            datos.add(new Object[]{"</font>"});
                        } else {
                            datos.add(new Object[]{"<font color=\"green\">"});
                            datos.add(new Object[]{"Condicion: Aprueba"});
                            datos.add(new Object[]{"</font>"});
                        }
                        tipo+=" "+cur.getAlumnos().get(idAlumno).getNombre();
                        String msg = "<h3 style=\"text-align: center\">Reporte Porcentaje de asistencia y notas del alumno"+cur.getAlumnos().get(idAlumno).getNombre()+"</h3>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".doc\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Descargar Word <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".html\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Ver HTML <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".xls\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Descargar Excel <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "        <form method=\"get\" action=\"reportes/" + tipo + curso.replaceAll(" ", "") + ".xml\">\n"
                                + "            <button class=\"btn btn-4\" type=\"submit\">Ver XML <img alt=\"\" src=\"https://image.flaticon.com/icons/png/512/0/532.png\" height=\"21\" width=\"21\"/></button>\n"
                                + "        </form>\n"
                                + "            <h5 style=\"text-align: center\">se pueden guardar los HTML y XML haciendo click derecho, guardar como</h5>";
                        generarMsg(datos, curso, s, request, response, tipo, msg);
                    } else {
                        request.setAttribute("curso", curso);
                        request.setAttribute("reportType", tipo);
                        request.setAttribute("alumnos", cur.getAlumnos());
                        request.getRequestDispatcher("reportPorcentaje.jsp").forward(request, response);
                    }
                    break;
                case ("asignatura"):
                    break;
                case ("planificacion"):
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        datos.add(new Object[]{"<b>"});
                        datos.add(new Object[]{"Información de todo el curso:"});
                        datos.add(new Object[]{"</b>"});
                        datos.add(new Object[]{"Alumno: " + cur.getAlumnos().get(i).getNombre() + " Apoderado: " + cur.getAlumnos().get(i).getApoderado().getNombre()});
                        datos.add(new Object[]{"Anotaciones: "});
                        if (cur.getAlumnos().get(i).getAnotaciones().isEmpty()) {
                            datos.add(new Object[]{"Sin anotaciones"});
                        } else {
                            for (int j = 0; j < cur.getAlumnos().get(i).getAnotaciones().size(); j++) {
                                datos.add(new Object[]{cur.getAlumnos().get(i).getAnotaciones().get(j).split(",")[0] + " por: " + cur.getAlumnos().get(i).getAnotaciones().get(j).split(",")[1]});
                            }
                        }
                        datos.add(new Object[]{"Porcentaje asistencia: " + cur.getAlumnos().get(i).getPorcentajeAsistencia()});
                        datos.add(new Object[]{"Promedio general: " + cur.getAlumnos().get(i).getPromedio()});
                        for (int j = 0; j < cur.getAsignaturas().size(); j++) {
                            datos.add(new Object[]{"Notas " + cur.getAsignaturas().get(j).getNombre()});
                            datos.add(new Object[]{"Profesor: " + cur.getAsignaturas().get(j).getProfesor().getNombre()});
                            datos.add(new Object[]{"Promedio: " + cur.getAlumnos().get(i).getPromedioAsignatura(cur.getAsignaturas().get(j).getNombre())});
                            int cont = 0;
                            datos.add(new Object[]{"Notas de Pruebas y Promedio Actividades. (Nota 0 significa pendiente)"});
                            for (int k = 0; k < cur.getAlumnos().get(i).getNotas().size(); k++) {
                                if (cur.getAlumnos().get(i).getNotas().get(k).contains(cur.getAsignaturas().get(j).getNombre())) {
                                    if (cont == 4) {
                                        datos.add(new Object[]{cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[0] + ": " + cur.getAlumnos().get(i).getNotas().get(k).split(",")[0]});
                                    } else {
                                        datos.add(new Object[]{cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[0] + ": " + cur.getAlumnos().get(i).getNotas().get(k).split(",")[0] + " Fecha: " + cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[2]});
                                    }
                                    cont++;
                                }
                            }
                            cont = 5;
                            datos.add(new Object[]{"Notas de Actividades. (Nota 0 significa pendiente)"});
                            for (int k = 0; k < cur.getAlumnos().get(i).getNotasAsig().size(); k++) {
                                if (cur.getAlumnos().get(i).getNotasAsig().get(k).contains(cur.getAsignaturas().get(j).getNombre())) {
                                    datos.add(new Object[]{cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[0] + ": " + cur.getAlumnos().get(i).getNotasAsig().get(k).split(",")[0] + " Fecha: " + cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[2]});
                                    cont++;
                                }
                            }
                            datos.add(new Object[]{"<br>"});
                        }
                    }
                    generar(datos, curso, s, url, request, response, tipo, "reportPlanificacion.jsp");
                    break;
                case ("alumnos"):
                    datos.add(new Object[]{"<b>"});
                    datos.add(new Object[]{"Apoderados con más de un hijo en el curso " + curso + ": "});
                    datos.add(new Object[]{"</b>"});
                    String exis = "";
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        if (cur.getAlumnos().get(i).getApoderado().getHijos().size() > 1 && !exis.contains(cur.getAlumnos().get(i).getNombre().split(" ")[0])) {
                            datos.add(new Object[]{"Apoderado: " + cur.getAlumnos().get(i).getApoderado().getNombre()});
                            datos.add(new Object[]{"Hijos: " + cur.getAlumnos().get(i).getApoderado().getHijos().toString().replaceAll("\\[", "").replaceAll("\\]", "")});
                            exis += cur.getAlumnos().get(i).getNombre().split(" ")[0];
                            datos.add(new Object[]{"<br>"});
                        }
                    }
                    generar(datos, curso, s, url, request, response, tipo, "reportApoderado_Alumno.jsp");
                    break;
                case ("enviar"):
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("msg", "Error " + e.getLocalizedMessage());
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }
    }

    private void generarMsg(ArrayList<Object> datos, String curso, ServletContext s, HttpServletRequest request, HttpServletResponse response, String tipo, String msg) throws ServletException, IOException {
        if (reportes.word(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/word.xsl")).contains("Exito")
                && reportes.html(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/html.xsl")).contains("Exito")
                && reportes.excel(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/excel.xsl")).contains("Exito")
                && reportes.xml(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/word.xsl")).contains("Exito")) {
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Error");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }
    }

    private void generar(ArrayList<Object> datos, String curso, ServletContext s, String[] url, HttpServletRequest request, HttpServletResponse response, String tipo, String jsp) throws ServletException, IOException {
        try {
            if (reportes.word(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/word.xsl")).contains("Exito")
                    && reportes.html(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/html.xsl")).contains("Exito")
                    && reportes.excel(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/excel.xsl")).contains("Exito")
                    && reportes.xml(datos, tipo + curso.replaceAll(" ", ""), s.getRealPath("/xslt/word.xsl")).contains("Exito")) {
                url[0] = "reportes/" + tipo + curso.replaceAll(" ", "") + ".doc";
                url[1] = "reportes/" + tipo + curso.replaceAll(" ", "") + ".html";
                url[2] = "reportes/" + tipo + curso.replaceAll(" ", "") + ".xls";
                url[3] = "reportes/" + tipo + curso.replaceAll(" ", "") + ".xml";
                request.setAttribute("url", url);
                request.setAttribute("curso", curso);
                request.getRequestDispatcher(jsp).forward(request, response);
            } else {
                request.setAttribute("msg", "Error");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", "Error " + e.getLocalizedMessage());
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
