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
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Porcentaje de notas y asistencia</h3>
        <br>
        <h4>Alumno: ${alumno}</h4>
        <br>
        <h4>Asistencia: ${asistencia}%</h4>
        <br>
        <h4>Notas:</h4>
        <br>
        <h4>%{asignatura}: ${promedios}</h4>
        <table>
            <thead>
                <tr>
                    <th>Actividad</th>
                    <th>Nota</th>
                    <th>Ponderacion</th>
                </tr>
            </thead>
            <tbody>
                ${notas}
            </tbody>
        </table>
            <br>
            <h4>Promedio General: ${promediosGenerales}</h4>
            <h4>Promedio rojos: ${promediosRojos}</h4>
            <h4>${condicion}</h4>
    </body>
</html>
