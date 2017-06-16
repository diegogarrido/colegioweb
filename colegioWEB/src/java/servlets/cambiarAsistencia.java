/*
 * Autor: Diego Garrido
 */
package servlets;

import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CambiarAsistencia;
import services.RetrieveCurso;

/**
 *
 * @author Diego
 */
@WebServlet(name = "cambiarAsistencia", urlPatterns = {"/cambiarAsistencia"})
public class cambiarAsistencia extends HttpServlet {

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
        String msg;
        try {
            int idAsistencia = Integer.parseInt(request.getParameter("idAsistencia"));
            String alumno = request.getParameter("alumno");
            System.out.println("alumno: "+alumno);
            String curso = request.getParameter("curso");
            System.out.println("curso: "+curso);
            int idAlumno = -1;
            RetrieveCurso r = new RetrieveCurso();
            Curso cur = r.retrieveCurso(curso);
            System.out.println("curso cargado");
            for (int i = 0; i < cur.getAlumnos().size(); i++) {
                if (cur.getAlumnos().get(i).getNombre().equals(alumno)) {
                    idAlumno = i;
                    break;
                }
            }
            System.out.println("idAlumno: "+idAlumno);
            CambiarAsistencia c = new CambiarAsistencia();
            cur = c.cambiar(idAlumno, curso, idAsistencia);
            if (cur!=null) {
                request.setAttribute("asistencia", cur.getAlumnos().get(idAlumno).getAsistencia());
                request.setAttribute("alumno", alumno);
                request.setAttribute("curso", curso);
                request.getRequestDispatcher("verAsistencia.jsp").forward(request, response);
            } else {
                request.setAttribute("msg","Error");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", e.getCause());
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
