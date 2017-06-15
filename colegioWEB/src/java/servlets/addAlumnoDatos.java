/*
 * Autor: Diego Garrido
 */
package servlets;

import com.archivos.Database;
import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;

/**
 *
 * @author Diego
 */
@WebServlet(name = "addAlumnoDatos", urlPatterns = {"/addAlumnoDatos"})
public class addAlumnoDatos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String curso = request.getParameter("curso");
            String apoderados = "";
            Database dat = new Database();
            try {
                Curso cur = dat.retrieveCurso(curso);
                for (int i = 0; i < cur.getAlumnos().size(); i++) {
                    if (!apoderados.contains(cur.getAlumnos().get(i).getApoderado().getNombre())) {
                        apoderados += "<option value=\"" + cur.getAlumnos().get(i).getApoderado().getNombre() + "\">" + cur.getAlumnos().get(i).getApoderado().getNombre() + "</option>";
                    }
                }
            } catch (PersistentException ex) {
            }
            apoderados += "<option value=\"Nuevo Apoderado\">Nuevo Apoderado</option>";
            request.setAttribute("apoderados", apoderados);
            request.setAttribute("curso", curso);

            RequestDispatcher dis = request.getRequestDispatcher("addAlumno.jsp");
            dis.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", "Error: "+e.getMessage());
            RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
            dis.forward(request, response);
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
