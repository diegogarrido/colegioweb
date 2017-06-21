/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RetrieveCurso;
import services.UpdateCurso;

/**
 *
 * @author francisiron
 */
@WebServlet(name = "cambiarAnotacion", urlPatterns = {"/cambiarAnotacion"})
public class cambiarAnotacion extends HttpServlet {

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
            int idAnotacion = Integer.parseInt(request.getParameter("idAnotacion"));
            String alumno = request.getParameter("alumno");
            String curso = request.getParameter("curso");
            String descripcion = "";
            if (request.getParameter("descripcion").length() > 0) {
                descripcion = request.getParameter("descripcion");
                int idAlumno = -1;
                RetrieveCurso rt = new RetrieveCurso();
                Curso cur = rt.retrieveCurso(curso);
                for (int i = 0; i < cur.getAlumnos().size(); i++) {
                    if (cur.getAlumnos().get(i).getNombre().equals(alumno)) {
                        idAlumno = i;
                        break;
                    }
                }
                String anotacion = cur.getAlumnos().get(idAlumno).getAnotaciones().get(idAnotacion).split(",")[0];
                cur.getAlumnos().get(idAlumno).getAnotaciones().set(idAnotacion, anotacion+","+descripcion);
                UpdateCurso u = new UpdateCurso();
                u.updateCurso(cur);
                request.setAttribute("msg", "Anotación modificada exitosamente");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Error: ingrese una descripción");
                RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                dis.forward(request, response);

            }

        } catch (Exception ex) {
            request.setAttribute("msg", "Error: " + ex.getMessage());
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
