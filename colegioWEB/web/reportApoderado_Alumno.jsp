<%-- 
    Document   : reportApoderado_Alumno
    Created on : 18-06-2017, 2:19:53
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de pupilos para apoderados</title>
    </head>
    <body>       
        <form action="InserteServlt" method="post">
            <h3>Seleccione el curso</h3>
            <br>
            <select name="idCurso">
                ${cursos}
            </select>
            <br>
            <button type="submit">Elegir curso</button>
        </form>
    </body>
</html>
