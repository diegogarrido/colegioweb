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
    </head>
    <body>
        <form action="ingreseServlt" method="post">
            <h3>Ingrese porcentaje limite</h3>
            <input type="text" name="por">
            <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
