<%-- 
    Document   : reportAsistencia
    Created on : 18-06-2017, 1:58:51
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de asistencia por curso</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <form action="solicitarReporte" method="post" style="text-align: center">
            <h3>Ingrese porcentaje limite</h3>
            <input type="number" min="1" max="100" name="porcentaje">% de asistencia
            <input type="hidden" name="curso" value="${curso}">
            <input type="hidden" name="reportType" value="${reportType}">
            <br><br>
            <button class="btn btn-4" type="submit">Aceptar</button>
        </form>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
