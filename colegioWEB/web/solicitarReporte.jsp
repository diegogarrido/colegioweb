<%-- 
    Document   : solicitarReporte
    Created on : 17-06-2017, 20:51:19
    Author     : francisiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar un reporte</title>
    </head>
    <body>
        <h3>Bienvenido al centro de reportes de la versión web del Colegio</h3>
        <br>
        <form action="solicitarReporte" method="post">
            <b>Eliga el reporte que desea solicitar</b>
            <br>
            <select name="reportType">
                <option value="reprobados">Ver estudiantes reprobando</option>
                <option value="asistencia">Ver estudiantes con asistencia X</option>
                <option value="porcentaje">Porcentaje de Notas/Asistencia</option>
                <option value="asignatura">Ver Promedios por Asignatura</option>
                <option value="planificacion">Planificacion/Notas/Anotaciones</option>
                <option value="alumnos">Apoderados con mas de un alumno</option>
                <option value="enviar">Planificacion para los apoderados</option>
            </select>
            <br>
            <input type="submit" value="Solicitar">
        </form>
    </body>
</html>
