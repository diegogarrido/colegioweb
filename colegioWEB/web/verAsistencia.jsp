<%-- 
    Document   : verAsistencia
    Created on : 15-06-2017, 11:35:47
    Author     : Francisco Fierro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asistencia</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/tabla.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <h3>Asistencia del alumno ${alumno}</h3>
        <div class="container">
            <div class="datagrid">
                <table>
                    <thead>
                        <tr>
                            <th>Día</th>
                            <th>¿Asistió?</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="i" begin="0" end="${asistencia.size()-1}">
                            <c:choose>
                                <c:when test="${i%2==0}"><tr></c:when>
                                <c:when test="${i%2!=0}"><tr class="alt"></c:when>
                                </c:choose>
                                <td>
                                    ${(i+1)}
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${asistencia.get(i)==true}">Si</c:when>
                                        <c:when test="${asistencia.get(i)==false}">No</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <form class="column" action="cambiarAsistencia" method="post" style="text-align: center">
                <b>Cambiar registro</b>
                <br><br>
                <div class="styled-select slate" style="margin: auto">
                    <select name="idAsistencia">
                        <c:forEach var="i" begin="0" end="${asistencia.size()-1}">
                            <option value="${i}">Día ${(i+1)}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="hidden" name="alumno" value="${alumno}">
                <input type="hidden" name="curso" value="${curso}">
                <br>
                <button class="btn btn-4" type="submit">Cambiar</button>
            </form>
            <form class="column" action="addAsistencia" method="post" style="text-align: center">
                <br><br>
                <b>Agregar registro</b>
                <br><br>
                <input type="hidden" name="alumno" value="${alumno}">
                <input type="hidden" name="idAlumno" value="${idAlumno}">
                <input type="hidden" name="curso" value="${curso}">
                <button class="btn btn-4" type="submit">Agregar</button>
            </form>
        </div>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
