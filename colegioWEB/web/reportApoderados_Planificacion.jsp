<%-- 
    Document   : reportApoderados_Planificacion
    Created on : 18-06-2017, 2:20:43
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de planificacion para apoderados</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
    </head>
    <body>
        <form action="solicitarReporte" method="post">
            <h3 style="text-align: center">Eliga apoderado para crear reporte(s)</h3>
            <br>
            <div class="styled-select slate" style="margin: auto;">
                <select name="idApoderado">
                    <c:forEach var="i" begin="0" end="${alumnos.size()-1}">
                        <option value="${i}">${alumnos.get(i).getApoderado().getNombre()}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="curso" value="${curso}">
            <input type="hidden" name="reportType" value="${reportType}">
            <br>
            <button type="submit" class="btn btn-4">Aceptar</button>
            <p>
                <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                    Inicio
                </button>
            </p>
        </form>
    </body>
</html>
