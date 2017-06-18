<%-- 
    Document   : addAlumno
    Created on : 03-06-2017, 21:38:24
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir alumno al curso</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <h1 style="text-align: center">Ingrese los datos del nuevo alumno</h1>
        <form action="addAlumno" method="post" style="text-align: center">
            <h3>
                Nombre
                <input type="text" name="nombre" style="width: 200px" required/>
            </h3>
            <h3>
                Apellido
                <input type="text" name="apellido" style="width: 200px" required/>
            </h3>
            <input type="hidden" name="curso" value="${curso}"/>
            <h3>Apoderado</h3>
            <div class="styled-select slate" style="margin: auto">
                <select name="apoderado">
                    ${apoderados}
                </select>
            </div>
            <h3>
                Si selecciona Nuevo Apoderado<br>Nombre:
                <input type="text" name="nombreApoderado" style="width: 200px"/>
            </h3>
            <h3>
                Apellido:
                <input type="text" name="apellidoApoderado" style="width: 200px"/>
            </h3>
            <button class="btn btn-4" type="submit">Agregar Alumno</button>
        </form>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
