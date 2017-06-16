/*
 * Autor: Diego Garrido
 */
package servlets;

import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RetrieveCurso;

/**
 *
 * @author Diego
 */
@WebServlet(name = "notas", urlPatterns = {"/notas"})
public class notas extends HttpServlet {

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
            String alumno = request.getParameter("alumno");
            String asignatura = request.getParameter("asignatura");
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            String notas = "";
            int idAsig = -1;
            Curso cur = retrieveCurso.retrieveCurso(curso);
            for (int i = 0; i < cur.getAsignaturas().size(); i++) {
                if (cur.getAsignaturas().get(i).getNombre().equals(asignatura)) {
                    idAsig = i;
                    break;
                }
            }
            String profesor = cur.getAsignaturas().get(idAsig).getProfesor().getNombre();
            int cont = 0;
            for (int i = 0; i < cur.getAlumnos().get(idAlumno).getNotas().size(); i++) {
                if (cur.getAlumnos().get(idAlumno).getNotas().get(i).split(",")[2].equals(asignatura)) {
                    if (cont % 2 == 0) {
                        notas += "<tr>";
                    } else {
                        notas += "<tr class=\"alt\">";
                    }
                    notas += "<td>" + cur.getAsignaturas().get(idAsig).getPlanificacion().get(cont).split(",")[0] + "</td>";
                    String nota = cur.getAlumnos().get(idAlumno).getNotas().get(i).split(",")[0];
                    if (nota.equals("0")) {
                        nota = "Pendiente";
                    }
                    notas += "<td>" + nota + "</td>";
                    notas += "<td>" + cur.getAlumnos().get(idAlumno).getNotas().get(i).split(",")[1] + "</td>";
                    notas += "<td>" + cur.getAsignaturas().get(idAsig).getPlanificacion().get(cont).split(",")[2] + "</td>";
                    notas += "</tr>";
                    cont++;
                }
            }
            
            for (int i = 0; i < cur.getAlumnos().get(idAlumno).getNotasAsig().size(); i++) {
                if (cur.getAlumnos().get(idAlumno).getNotasAsig().get(i).split(",")[1].equals(asignatura)) {
                    if (cont % 2 == 0) {
                        notas += "<tr>";
                    } else {
                        notas += "<tr class=\"alt\">";
                    }
                    notas += "<td>" + cur.getAsignaturas().get(idAsig).getPlanificacion().get(cont).split(",")[0] + "</td>";
                    String nota = cur.getAlumnos().get(idAlumno).getNotasAsig().get(i).split(",")[0];
                    if (nota.equals("0")) {
                        nota = "Pendiente";
                    }
                    notas += "<td>" + nota + "</td>";
                    notas += "<td>-</td>";
                    notas += "<td>" + cur.getAsignaturas().get(idAsig).getPlanificacion().get(cont).split(",")[2] + "</td>";
                    notas += "</tr>";
                    cont++;
                }
            }
            request.setAttribute("alumno", alumno);
            request.setAttribute("idAlumno", idAlumno);
            request.setAttribute("curso", curso);
            request.setAttribute("notas", notas);
            request.setAttribute("asignatura", asignatura);
            request.setAttribute("idAsignatura", idAsig);
            request.setAttribute("profesor", profesor);
            request.setAttribute("planificacion", cur.getAsignaturas().get(idAsig).getPlanificacion());
            RequestDispatcher dis = request.getRequestDispatcher("notas.jsp");
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
