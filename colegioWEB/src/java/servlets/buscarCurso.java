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
@WebServlet(name = "buscarCurso", urlPatterns = {"/buscarCurso"})
public class buscarCurso extends HttpServlet {

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
            curso = curso.toUpperCase();
            curso = curso.replaceAll(" ", "");
            curso = "" + curso.charAt(0) + " " + curso.charAt(curso.length() - 1);
            String alumnos = "";
            String sel = "";

            Database dat = new Database();
            try {
                Curso cur = dat.retrieveCurso(curso);
                for (int i = 0; i < cur.getAlumnos().size(); i++) {
                    if (i % 2 == 0) {
                        alumnos += "<tr>";
                    } else {
                        alumnos += "<tr class=\"alt\">";
                    }
                    alumnos += "<td>" + (i + 1) + "</td>";
                    alumnos += "<td>" + cur.getAlumnos().get(i).getNombre() + "</td>";
                    alumnos += "<td>" + cur.getAlumnos().get(i).getApoderado().getNombre() + "</td>";
                    String hijos = "" + cur.getAlumnos().get(i).getApoderado().getHijos();
                    hijos = hijos.replaceAll("\\[", "");
                    hijos = hijos.replaceAll("\\]", "");
                    alumnos += "<td>" + hijos + "</td>";
                    alumnos += "</tr>";

                    sel += "<option value\"+" + cur.getAlumnos().get(i).getNombre() + "\">" + cur.getAlumnos().get(i).getNombre() + "</option>";
                }
                if (cur.getAlumnos() == null) {
                    alumnos = "<td>El curso no existe</td>";
                }
            } catch (PersistentException | java.lang.NumberFormatException ex) {
                alumnos = "<td>Error, Por favor ingrese un curso válido</td>";
            }

            request.setAttribute("seleccion", sel);
            request.setAttribute("curso", curso);
            request.setAttribute("alumnos", alumnos);

            RequestDispatcher dis = request.getRequestDispatcher("verCurso.jsp");
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
