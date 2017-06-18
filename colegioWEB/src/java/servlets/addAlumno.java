/*
 * Autor: Diego Garrido
 */
package servlets;

import com.archivos.Database;
import com.proyecto1.Apoderado;
import com.proyecto1.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;
import services.AddAlumno;

/**
 *
 * @author Diego
 */
@WebServlet(name = "addAlumno", urlPatterns = {"/addAlumno"})
public class addAlumno extends HttpServlet {

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
            String curso = request.getParameter("curso");
            String nombre = request.getParameter("nombre");
            nombre = ("" + nombre.charAt(0)).toUpperCase() + nombre.substring(1, nombre.length()).toLowerCase();
            String apellido = request.getParameter("apellido");
            apellido = ("" + apellido.charAt(0)).toUpperCase() + apellido.substring(1, apellido.length()).toLowerCase();
            String apoderado = request.getParameter("apoderado");
            AddAlumno add = new AddAlumno();
            Database dat = new Database();
            Curso cur = dat.retrieveCurso(curso);
            Apoderado ap = null;

            boolean exis = true;
            if (apoderado.equals("Nuevo Apoderado")) {
                String nombreAp = request.getParameter("nombreApoderado");
                if (nombreAp.length() > 0 && !nombreAp.equals("null")) {
                    String apellidoAp = request.getParameter("apellidoApoderado");
                    nombreAp = ("" + nombreAp.charAt(0)).toUpperCase() + nombreAp.substring(1, nombreAp.length()).toLowerCase();
                    apellidoAp = ("" + apellidoAp.charAt(0)).toUpperCase() + apellidoAp.substring(1, apellidoAp.length()).toLowerCase();
                    exis = false;
                    ap = new Apoderado(apellidoAp + " " + nombreAp);
                } else {
                    request.setAttribute("msg", "Error: Ingrese un nombre para el Apoderado");
                    RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                    dis.forward(request, response);
                }
            } else {
                for (int i = 0; i < cur.getAlumnos().size(); i++) {
                    if (cur.getAlumnos().get(i).getApoderado().getNombre().equals(apoderado)) {
                        ap = cur.getAlumnos().get(i).getApoderado();
                    }
                }
            }
            if (apellido.toLowerCase().equals(ap.getNombre().split(" ")[0].toLowerCase())) {
                add.addAlumno(ap, cur.getAlumnos().get(0).getAsistencia().size(), curso, apellido + " " + nombre, cur.getAlumnos().get(0).getNotas(), cur.getAlumnos().get(0).getNotasAsig(), exis);
                request.setAttribute("msg", "Alumno añadido exitosamente");
                RequestDispatcher dis = request.getRequestDispatcher("mensaje.jsp");
                dis.forward(request, response);
            } else {
                request.setAttribute("msg", "El apellido ingresado no coincide con el del apoderado");
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
