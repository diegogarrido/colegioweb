/*
 * Autor: Diego Garrido
 */
package servlets;

import com.archivos.Database;
import com.proyecto1.Asignatura;
import com.proyecto1.Curso;
import com.proyecto1.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AddAsignatura;
import services.RetrieveCurso;

/**
 *
 * @author Diego
 */
@WebServlet(name = "addAsignatura", urlPatterns = {"/addAsignatura"})
public class addAsignatura extends HttpServlet {

    @EJB
    private AddAsignatura addAsignatura;

    @EJB
    private RetrieveCurso retrieveCurso;

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
            String nombreAsign = request.getParameter("nombreAsignatura");
            nombreAsign = ("" + nombreAsign.charAt(0)).toUpperCase() + nombreAsign.substring(1, nombreAsign.length()).toLowerCase() + " " + curso;
            String profesor = request.getParameter("profesor");
            String nombreProf = request.getParameter("nombreProfesor");
            Curso cur = retrieveCurso.retrieveCurso(curso);
            Profesor prof = new Profesor();
            boolean exist = false;
            if (profesor.equals("Nuevo Profesor")) {
                for (int i = 0; i < cur.getAsignaturas().size(); i++) {
                    if (nombreProf.length() == 0) {
                        if (cur.getAsignaturas().get(i).getProfesor().getNombre().equals(nombreProf)) {
                            request.setAttribute("msg", "Error: Ingrese un nombre");
                            RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                            dis.forward(request, response);
                        }
                    }
                    if (cur.getAsignaturas().get(i).getProfesor().getNombre().equals(nombreProf)) {
                        request.setAttribute("msg", "Error: El profesor ya existe");
                        RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                        dis.forward(request, response);
                    }
                }
                nombreProf = ("" + nombreProf.charAt(0)).toUpperCase() + nombreProf.substring(1, nombreProf.length()).toLowerCase();
                prof.setNombre(nombreProf);
                ArrayList<String> asign = new ArrayList();
                asign.add(nombreAsign);
                prof.setAsignaturas(asign);
            } else {
                for (int i = 0; i < cur.getAsignaturas().size(); i++) {
                    if (cur.getAsignaturas().get(i).getProfesor().getNombre().equals(profesor)) {
                        prof = cur.getAsignaturas().get(i).getProfesor();
                        exist = true;
                        break;
                    }
                }
            }
            cur.addAsignatura(prof, nombreAsign);
            addAsignatura.addAsignatura(cur.getAsignaturas().get(cur.getAsignaturas().size() - 1), exist);
            Database dat = new Database();
            dat.updateData(cur);
            request.setAttribute("msg", "Asignatura añadida exitosamente");
            RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
            dis.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg", "Error: " + e.getMessage() + " " + e.getLocalizedMessage());
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
