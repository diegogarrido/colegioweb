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
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
    </head>
    <body>
        <h3 style="text-align: center">Bienvenido al centro de reportes de la versión web del Colegio</h3>
        <h4 style="text-align: center">Curso ${curso}</h4>
        <form action="solicitarReporte" method="post" style="text-align: center">
            <b>Eliga el reporte que desea solicitar</b>
            <br><br>
            <div class="styled-select slate" style="margin: auto; width: 350px;">
                <select name="reportType" style="width: 365px;">
                    <option value="reprobados">Ver estudiantes reprobando</option>
                    <option value="asistencia">Ver estudiantes con asistencia X</option>
                    <option value="porcentaje">Porcentaje de Notas/Asistencia</option>
                    <option value="asignatura">Ver Promedios por Asignatura</option>
                    <option value="planificacion">Planificacion/Notas/Anotaciones</option>
                    <option value="alumnos">Apoderados con mas de un alumno</option>
                    <option value="enviar">Planificacion para los apoderados</option>
                </select>
            </div>
            <br>
            <input type="hidden" name="curso" value="${curso}">
            <button class="btn btn-4" type="submit">Solicitar</button>
        </form>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
