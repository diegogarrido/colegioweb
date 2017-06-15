/*
 * Autor: Diego Garrido
 */
package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CambiarNota;

/**
 *
 * @author Diego
 */
@WebServlet(name = "cambiarNota", urlPatterns = {"/cambiarNota"})
public class cambiarNota extends HttpServlet {

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
            String nota = request.getParameter("nota");
            if (Double.parseDouble(nota) >= 1 && Double.parseDouble(nota) <= 7) {
                if(nota.length()==1){
                    nota+=".0";
                }
                CambiarNota c = new CambiarNota();
                request.setAttribute("msg", c.cambiarNota(Integer.parseInt(request.getParameter("idAlumno")), request.getParameter("curso"), Integer.parseInt(request.getParameter("idActividad")), nota, request.getParameter("asignatura")));
                RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                dis.forward(request, response);
            } else {
                request.setAttribute("msg", "Error: Ingrese un número entre 1.0 y 7.0");
                RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                dis.forward(request, response);
            }
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
