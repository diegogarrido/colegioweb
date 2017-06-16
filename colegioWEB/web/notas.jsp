<%-- 
    Document   : notas
    Created on : 07-06-2017, 12:35:56
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas del alumno ${alumno}</title>
        <script>
            function cambiarValue() {
                var sel = document.getElementById("combobox").NodeList();
                document.getElementById("texto").setAttribute("value", sel);
            }
        </script>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/tabla.css" media="screen">
    </head>
    <body>
        <h1>Asignatura: ${asignatura}<br>Alumno: ${alumno}<br> Profesor: ${profesor}</h1>
        <div class="container">
            <div class="datagrid">
                <table style="width:100%">
                    <thead>
                        <tr>
                            <th>Actividad</th>
                            <th>Nota</th>
                            <th>Ponderación</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${notas}
                    </tbody>
                </table>
            </div>
        </div>
        <br>
        <form action="cambiarNota" method="post" style="text-align: center">
            <b>Cambiar Nota de una actividad:</b>
            <br>
            <div class="styled-select slate" style="margin: auto">
                <select name="idActividad" style="margin: auto">
                    <c:forEach var="i" begin="0" end="3">
                        <option value="${i}">
                            ${planificacion.get(i).split(",")[0]}
                        </option>
                    </c:forEach>
                    <c:forEach var="i" begin="5" end="${planificacion.size()-1}">
                        <option value="${i}">
                            ${planificacion.get(i).split(",")[0]}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <br>
            Ingrese nota
            <input type="number" name="nota" step="any" min="1.0" max="7.0">
            <input type="hidden" name="curso" value="${curso}">
            <input type="hidden" name="idAlumno" value="${idAlumno}">
            <input type="hidden" name="idAsignatura" value="${idAsignatura}">
            <input type="hidden" name="asignatura" value="${asignatura}">
            <input type="submit" value="Cambiar nota">
        </form>
        <br>
        <form action="cambiarActividad" method="post" style="text-align: center">
            <b>Modificar actividad: (deje el campo en blanco si quiere mantener la información anterior)</b>
            <br>
            <select name="idActividad" id="combobox" onchange="cambiarValue()">
                <c:forEach var="i" begin="0" end="${planificacion.size()-1}">
                    <option value="${i}">
                        ${planificacion.get(i).split(",")[0]}
                    </option>
                </c:forEach>
            </select>
            <br>
            Descripción de la actividad o prueba
            <input type="text" name="descripcion" id="texto" value="${planificacion.get(0).split(",")[0]}">
            <br>
            Porcentaje de ponderación (Si es una Prueba o el Promedio de las actividades)
            <input type="number" name="porcentaje" min="1" max="100">%
            <br>
            Fecha de la actividad
            <input type="date" name="fecha">
            <input type="hidden" name="asignatura" value="${asignatura}">
            <input type="hidden" name="idAsignatura" value="${idAsignatura}">
            <br>
            <input type="submit" value="Cambiar actividad">
        </form>

        <p style="text-align: left">
            <button type="button" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
