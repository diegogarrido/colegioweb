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
        <title>Reporte de la asignatura para profesores</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <form action="ingreseServlt" method="post">
            <h3>Seleccione un profesor</h3>
            <br>
            <div class="styled-select slate" style="margin: auto;">
                <select name="sel">
                    ${profesores}
                </select>
            </div>
            <br>
            <button type="submit" class="btn btn-4">Elegir profesor</button>
        </form>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
