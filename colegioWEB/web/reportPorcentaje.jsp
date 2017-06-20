<%-- 
    Document   : reportPorcentaje
    Created on : 18-06-2017, 2:06:24
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de notas y asistencia por alumno</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
    </head>
    <body>
        <h3 style="text-align: center">Seleccione alumno para mostrar porcentajes</h3>
        <form action="solicitarReporte" method="post">
            <div class="styled-select slate" style="margin: auto">
                <select name="idAlumno">
                    <c:forEach var="i" begin="0" end="${alumnos.size()-1}">
                        <option value="${i}">${alumnos.get(i).getNombre()}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <input type="hidden" name="curso" value="${curso}">
            <input type="hidden" name="reportType" value="${reportType}">
            <button class="btn btn-4" type="submit">Elegir alumno</button>
        </form>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
