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
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Alumnos del curso ${curso} con porcentaje de asistencia bajo el ${porcentaje}%</h3>
        <br>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Porcentaje de asistencia</th>
                </tr>
            </thead>
            <tbody>
                ${alumnosAsistencia}
            </tbody>
        </table>
    </body>
</html>
