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
        <h3>Alumnos del ${curso} en estado de repitencia</h3>
        <br>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Razón de repitencia</th>
                </tr>
            </thead>
            <tbody>
                ${alumnosRepitentes}
            </tbody>
        </table>
    </body>
</html>
