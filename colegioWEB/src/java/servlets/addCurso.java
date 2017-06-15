/*
 * Autor: Diego Garrido
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import services.AddCurso;

/**
 *
 * @author Diego
 */
@WebServlet(name = "addCurso", urlPatterns = {"/addCurso"})
public class addCurso extends HttpServlet {

    @EJB
    private AddCurso addCurso;

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
        try{
        response.setContentType("text/html;charset=UTF-8");
        int nivel = 0;
        String msg = "";
        try {
            nivel = Integer.parseInt(request.getParameter("nivel"));
            if (nivel > 0 && nivel < 9) {
                try {
                    addCurso.addCurso(nivel);
                    msg = "Añadido un curso al nivel " + nivel + " exitosamente!";
                } catch (Exception ex) {
                    msg = "Error, " + ex.getMessage();
                }
            } else {
                msg = "Ingrese un número del 1 al 8!";
            }
        } catch (java.lang.NumberFormatException ex) {
            msg = "Error, ingrese un número del 1 al 8 e intente nuevamente.";
        }

        request.setAttribute("msg", msg);

        RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
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
