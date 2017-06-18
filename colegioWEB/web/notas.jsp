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
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/tabla.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
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
        <div style="text-align: center">
            <b>Promedio de la Asignatura: </b>${promedio}
            &emsp;&emsp;
            <b>Ponderación:</b>
            <c:choose>
                <c:when test="${ponderacion>100}">${ponderacion} Ajuste la ponderación a 100%!</c:when>
                <c:when test="${ponderacion<=100}">${ponderacion}</c:when>
            </c:choose>
        </div>
        <div class="row">
            <form class="column" action="cambiarNota" method="post" style="text-align: center">
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
                <input type="number" name="nota" step="any" min="1.0" max="7.0" required>
                <input type="hidden" name="curso" value="${curso}">
                <input type="hidden" name="idAlumno" value="${idAlumno}">
                <input type="hidden" name="idAsignatura" value="${idAsignatura}">
                <input type="hidden" name="asignatura" value="${asignatura}">
                <br><br>
                <button class="btn btn-4" type="submit">Cambiar nota</button>
            </form>
            <form class="column" action="addActividad" method="post" style="text-align: center">
                <b>Agregar actividad:</b><br>
                Descripción de la actividad o prueba
                <input type="text" name="descripcion" required>
                <br><br>
                Fecha de la actividad
                <input type="date" name="fecha" required>
                <input type="hidden" name="idAsignatura" value="${idAsignatura}">
                <input type="hidden" name="curso" value="${curso}">
                <input type="hidden" name="asignatura" value="${asignatura}">
                <br><br>
                <button class="btn btn-4" type="submit">Añadir actividad</button>
            </form>
        </div>
        <div class="row">
            <form class="column" action="cambiarActividad" method="post" style="text-align: center">
                <b>Modificar actividad:<br>(deje el campo en blanco si quiere mantener la información anterior)</b>
                <br>Actividad:
                <div class="styled-select slate" style="margin: auto">
                    <select name="idActividad">
                        <c:forEach var="i" begin="0" end="${planificacion.size()-1}">
                            <option value="${i}">
                                ${planificacion.get(i).split(",")[0]}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                Descripción de la actividad o prueba
                <input type="text" name="descripcion">
                <br>
                Porcentaje de ponderación (para pruebas o promedio de las actividades)
                <input type="number" name="porcentaje" min="1" max="100">%
                <br>
                Fecha de la actividad
                <input type="date" name="fecha">
                <input type="hidden" name="idAsignatura" value="${idAsignatura}">
                <input type="hidden" name="curso" value="${curso}">
                <br><br>
                <button class="btn btn-4" type="submit">Cambiar actividad</button>
            </form>
        </div>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
