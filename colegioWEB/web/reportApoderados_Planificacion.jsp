<%-- 
    Document   : reportApoderados_Planificacion
    Created on : 18-06-2017, 2:20:43
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de planificacion para apoderados</title>
    </head>
    <body>
        <form action="ingreseServlt" method="post">
            <h3>Eliga apoderado para crear reporte(s)</h3>
            <br>
            <select name="idApoderado">
                ${apoderados}
            </select>
            <br>
            <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
