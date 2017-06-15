/*
 * Autor: Diego Garrido
 */
package servlets;

import com.archivos.Database;
import com.proyecto1.Curso;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "asignatura", urlPatterns = {"/asignatura"})
public class asignatura extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            String alumno = request.getParameter("alumno");
            String curso = request.getParameter("curso");
            String profesores = "";
            int idAlumno = -1;
            Database dat = new Database();
            Curso cur = null;
            try {
                cur = dat.retrieveCurso(curso);
            } catch (PersistentException ex) {
                Logger.getLogger(asignatura.class.getName()).log(Level.SEVERE, null, ex);
            }
            String asignaturas = "";
            for (int i = 0; i < cur.getAlumnos().size(); i++) {
                if (cur.getAlumnos().get(i).getNombre().equals(alumno)) {
                    idAlumno = i;
                    break;
                }
            }
            for (int i = 0; i < cur.getAsignaturas().size(); i++) {
                if (!profesores.contains(cur.getAsignaturas().get(i).getProfesor().getNombre())) {
                    profesores += "<option value\"" + cur.getAsignaturas().get(i).getProfesor().getNombre() + "\">" + cur.getAsignaturas().get(i).getProfesor().getNombre() + "</option>";
                }
                asignaturas += "<option value\"" + cur.getAsignaturas().get(i).getNombre() + "\">" + cur.getAsignaturas().get(i).getNombre() + "</option>";
            }
            profesores += "<option value\"Nuevo Profesor\">Nuevo Profesor</option>";
            request.setAttribute("idAlumno", idAlumno);
            request.setAttribute("alumno", alumno);
            request.setAttribute("asignaturas", asignaturas);
            request.setAttribute("profesores", profesores);
            request.setAttribute("curso", curso);

            RequestDispatcher dis = request.getRequestDispatcher("asignatura.jsp");
            dis.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", "Error: " + e.getMessage());
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
