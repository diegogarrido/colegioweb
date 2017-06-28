/*
 * Autor: Diego Garrido
 */
package servlets;

import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author Diego
 */
@WebServlet(name = "cambiarActividad", urlPatterns = {"/cambiarActividad"})
public class cambiarActividad extends HttpServlet {

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
            String descripcion = null;
            if (request.getParameter("descripcion").length() > 0) {
                descripcion = request.getParameter("descripcion");
            }
            int porcentaje = -1;
            if (request.getParameter("porcentaje").length() > 0) {
                porcentaje = Integer.parseInt(request.getParameter("porcentaje"));
            }
            String fecha = null;
            if (request.getParameter("fecha").length() > 0) {
                fecha = request.getParameter("fecha");
                String[] split = fecha.split("-");
                fecha = split[2] + "/" + split[1] + "/" + split[0];
            }
            int idActividad = Integer.parseInt(request.getParameter("idActividad"));
            int idAsignatura = Integer.parseInt(request.getParameter("idAsignatura"));
            String curso = request.getParameter("curso");
            RetrieveCurso r = new RetrieveCurso();
            Curso cur = r.retrieveCurso(curso);
            String activ = cur.getAsignaturas().get(idAsignatura).getPlanificacion().get(idActividad);
            String[] split = activ.split(",");
            if (descripcion != null && idAsignatura != 4) {
                split[0] = descripcion;
            }
            if (fecha != null && idAsignatura != 4) {
                split[2] = fecha;
            }
            activ = split[0] + "," + split[1] + "," + split[2];
            cur.getAsignaturas().get(idAsignatura).getPlanificacion().set(idActividad, activ);
            if (porcentaje != -1 && idActividad <= 4) {
                ArrayList<Integer> indexes = new ArrayList<Integer>();
                for (int i = 0; i < cur.getAlumnos().get(0).getNotas().size(); i++) {
                    if (cur.getAlumnos().get(0).getNotas().get(i).contains(cur.getAsignaturas().get(idAsignatura).getNombre())) {
                        indexes.add(i);
                    }
                }
                for (int i = 0; i < cur.getAlumnos().size(); i++) {
                    String not = cur.getAlumnos().get(i).getNotas().get(indexes.get(idActividad));
                    not = not.split(",")[0] + "," + porcentaje + "," + not.split(",")[2];
                    cur.getAlumnos().get(i).getNotas().set(indexes.get(idActividad), not);
                }
            }
            UpdateCurso u = new UpdateCurso();
            u.updateCurso(cur);
            request.setAttribute("msg", "Actividad modificada exitosamente");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
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
