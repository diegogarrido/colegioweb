/*
 * Autor: Diego Garrido
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AddActividad;

/**
 *
 * @author Diego
 */
@WebServlet(name = "addActividad", urlPatterns = {"/addActividad"})
public class addActividad extends HttpServlet {

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
            int idAsignatura = Integer.parseInt(request.getParameter("idAsignatura"));
            String asignatura = request.getParameter("asignatura");
            String fecha = null;
            String descripcion = null;
            if (request.getParameter("fecha").length() > 0) {
                fecha = request.getParameter("fecha");
                String[] split = fecha.split("-");
                fecha = split[2] + "/" + split[1] + "/" + split[0];
            }
            if (request.getParameter("descripcion").length() > 0) {
                descripcion = request.getParameter("descripcion");
            }
            AddActividad a = new AddActividad();
            String msg = a.add(idAsignatura, curso, descripcion, fecha, asignatura);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", "Error: " + e.getCause());
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
