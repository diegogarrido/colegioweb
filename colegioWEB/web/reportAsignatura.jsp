<%-- 
    Document   : reportAsignatura
    Created on : 18-06-2017, 2:19:24
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ingreseServlt" method="post">
            <h3>Seleccione un profesor</h3>
            <br>
            <select name="sel">
                ${profesores}
            </select>
            <br>
            <button type="submit">Elegir profesor</button>
        </form>
    </body>
</html>
