<%-- 
    Document   : reportPorcentaje
    Created on : 18-06-2017, 2:06:24
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de notas y asistencia por alumno</title>
    </head>
    <body>
        <form action="ingreseServlt" method="post">
            <h3>Seleccione un alumno</h3>
            <br>
            <select name="idAlumno">
                ${alumnos}
            </select>
            <br>
            <button type="submit">Elegir alumno</button>
        </form>
    </body>
</html>
