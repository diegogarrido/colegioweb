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
        <title>Reporte</title>
    </head>
    <body>        
        <form action="InserteServlt" method="post">
            <h3>Seleccione el curso</h3>
            <select name="idCurso">
                ${cursos}
            </select>
            <br>
            <button type="submit">Elegir curso</button>
        </form>
    </body>
</html>
