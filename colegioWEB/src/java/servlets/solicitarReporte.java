/*
 * Autor: Diego Garrido
 */
package servlets;

import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
                    /*cargar y enviar el curso como objeto quizás?
                    RetrieveCurso r = new RetrieveCurso();
                    Curso cur = r.retrieveCurso(curso);
                    request.setAttribute("objCurso",cur);
                     */
                    request.setAttribute("curso", curso);
                    request.getRequestDispatcher("solicitarReporte.jsp").forward(request, response);
                    break;
                case ("reprobados"):
                    datos.add(new Object[]{"Alumnos del curso " + curso + " en estado de repitencia"});
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        if (cur.getAlumnos().get(i).estaReprobando()) {
                            datos.add(new Object[]{cur.getAlumnos().get(i).getNombre() + " por " + cur.getAlumnos().get(i).razonReprobado()});
                        }
                    }
                    generar(datos, curso, s, url, request, response, tipo, "reportReprobados.jsp");
                    break;
                case ("asistencia"):
                    break;
                case ("porcentaje"):
                    break;
                case ("asignatura"):
                    break;
                case ("planificacion"):
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
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
                            datos.add(new Object[]{"Notas " + cur.getAsignaturas().get(j).getNombre() + " Profesor: " + cur.getAsignaturas().get(j).getProfesor().getNombre() + " Promedio: " + cur.getAlumnos().get(i).getPromedioAsignatura(cur.getAsignaturas().get(j).getNombre())});
                            int cont = 0;
                            datos.add(new Object[]{"Notas de Pruebas y Promedio Actividades. (Nota 0 significa pendiente)"});
                            for (int k = 0; k < cur.getAlumnos().get(i).getNotas().size(); k++) {
                                if (cur.getAlumnos().get(i).getNotas().get(k).contains(cur.getAsignaturas().get(j).getNombre())) {
                                    datos.add(new Object[]{cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[0] + ": " + cur.getAlumnos().get(i).getNotas().get(k).split(",")[0] + " Fecha: " + cur.getAsignaturas().get(j).getPlanificacion().get(cont).split(",")[2]});
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
                        }
                        generar(datos, curso, s, url, request, response, tipo, "reportPlanificacion.jsp");
                    }
                    break;
                case ("alumnos"):
                    datos.add(new Object[]{"Apoderados con mas de un hijo en el curso " + curso + ": "});
                    String exis = "";
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        if (cur.getAlumnos().get(i).getApoderado().getHijos().size() > 1 && !exis.contains(cur.getAlumnos().get(i).getNombre().split(" ")[0])) {
                            datos.add(new Object[]{"Nombre: " + cur.getAlumnos().get(i).getApoderado().getNombre()});
                            datos.add(new Object[]{"Hijos: "});
                            datos.add(new Object[]{cur.getAlumnos().get(i).getApoderado().getHijos().toString().replaceAll("\\[", "").replaceAll("\\]", "")});
                            datos.add(new Object[]{" "});
                            exis += cur.getAlumnos().get(i).getNombre().split(" ")[0];
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
