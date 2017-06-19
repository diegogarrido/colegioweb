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
            String curso = request.getParameter("curso");
            String tipo = "null";
            if (request.getParameter("reportType") != null) {
                tipo = request.getParameter("reportType");
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
                    Curso cur = retrieveCurso.retrieveCurso(curso);
                    ArrayList<Object> datos = new ArrayList();
                    datos.add(new Object[]{"Alumnos del curso " + curso + " en estado de repitencia"});
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        if (cur.getAlumnos().get(i).estaReprobando()) {
                            datos.add(new Object[]{cur.getAlumnos().get(i).getNombre() + " por " + cur.getAlumnos().get(i).razonReprobado()});
                        }
                    }
                    String[] url = new String[4];
                    ServletContext s = getServletContext();
                    if (reportes.word(datos, "reprobados" + curso.replaceAll(" ", ""), s.getRealPath("/xslt/word.xsl")).contains("Exito")) {
                        url[0] = "reportes/reprobados" + curso.replaceAll(" ", "") + ".doc";
                        request.setAttribute("url", url);
                        request.setAttribute("curso", curso);
                        request.getRequestDispatcher("reportReprobados.jsp").forward(request, response);
                    } else {
                        request.setAttribute("msg", "Error");
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("msg", "Error "+e.getLocalizedMessage());
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
