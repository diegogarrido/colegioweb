<%-- 
    Document   : verCurso
    Created on : 02-06-2017, 20:23:57
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso ${curso}</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/tabla.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <h1 style="text-align: center">Alumnos en el curso ${curso}</h1>
        <div class="container">
            <div class="datagrid">
                <table style="width:100%">
                    <thead>
                        <tr>
                            <th>N°</th>
                            <th>Nombre Alumno</th>
                            <th>Apoderado</th>
                            <th>Hijos</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${alumnos}
                    </tbody>
                </table>
            </div>
        </div>
        <br>
        <div class="row">
            <form class="column" action="addAlumnoDatos" method="post" style="text-align: center">
                <input type="hidden" name="curso" value="${curso}"/>
                <br>
                <button class="btn btn-4" type="submit">Agregar Alumno</button>
            </form>
            <form class="column" action="asignatura" method="post" style="text-align: center">
                <input type="hidden" name="curso" value="${curso}"/>
                <div class="styled-select slate" style="margin: auto">
                    <select name="alumno">
                        ${seleccion}
                    </select>
                </div>
                <br>
                <button class="btn btn-4" type="submit">Ver notas</button>
            </form>
            <form class="column" action="verAsistencia" method="post" style="text-align: center">
                <input type="hidden" name="curso" value="${curso}"/>
                <div class="styled-select slate" style="margin: auto">
                    <select name="alumno">
                        ${seleccion}
                    </select>
                </div>
                <br>
                <button class="btn btn-4" type="submit">Ver Asistencia</button>
            </form>
            <form class="column" action="verAnotaciones" method="post" style="text-align: center">
                <div class="styled-select slate" style="margin: auto">
                    <select name="alumno">
                        ${seleccion}
                    </select>
                </div>
                <br>
                <input type="hidden" name="curso" value="${curso}"/>
                <button class="btn btn-4" type="submit">Ver Anotaciones</button>
            </form>
            <form class="column" action="solicitarReporte" method="post" style="text-align: center">
                <br>
                <input type="hidden" name="curso" value="${curso}"/>
                <button class="btn btn-4" type="submit">Reportes</button>
            </form>
        </div>
        <br><br><br><br>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
