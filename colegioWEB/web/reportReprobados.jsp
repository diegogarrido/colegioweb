<%-- 
    Document   : reportReprobados
    Created on : 17-06-2017, 22:22:37
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de reprobados por curso</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <h3 style="text-align: center">Reporte alumnos reprobados en el curso ${curso}</h3>
        <form method="get" action="${url[0]}">
            <button class="btn btn-4" type="submit">Descargar Word <img alt="" src="https://image.flaticon.com/icons/png/512/0/532.png" height="21" width="21"/></button>
        </form>
        <form method="get" action="${url[1]}">
            <button class="btn btn-4" type="submit">Ver HTML <img alt="" src="https://image.flaticon.com/icons/png/512/0/532.png" height="21" width="21"/></button>
        </form>
        <form method="get" action="${url[2]}">
            <button class="btn btn-4" type="submit">Descargar Excel <img alt="" src="https://image.flaticon.com/icons/png/512/0/532.png" height="21" width="21"/></button>
        </form>
        <form method="get" action="${url[3]}">
            <button class="btn btn-4" type="submit">Ver XML <img alt="" src="https://image.flaticon.com/icons/png/512/0/532.png" height="21" width="21"/></button>
        </form>
        <h5 style="text-align: center">se pueden guardar los HTML y XML haciendo click derecho, guardar como</h5>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
