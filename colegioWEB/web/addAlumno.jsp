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
        <link rel="stylesheet" href="css/input.css" media="screen">
        <script>
            function nuevoAp() {
                if (document.getElementById("seleccion").value == "Nuevo Apoderado") {
                    document.getElementById("datos").removeAttribute("hidden");
                    document.getElementById("inA").setAttribute("required", "");
                    document.getElementById("inN").setAttribute("required", "");
                } else {
                    document.getElementById("datos").setAttribute("hidden", "");
                    document.getElementById("inA").removeAttribute("required");
                    document.getElementById("inN").removeAttribute("required");
                }
            }
        </script>
    </head>
    <body>
        <h1 style="text-align: center">Ingrese los datos del nuevo alumno</h1>
        <form action="addAlumno" method="post" style="text-align: center">
            <font size="4"><b>Nombre:</b></font>
            <input type="text" name="nombre" style="width: 200px" required/>
            <br>
            <font size="4"><b>Apellido:</b></font>
            <input type="text" name="apellido" style="width: 200px" required/>
            <input type="hidden" name="curso" value="${curso}"/>
            <h3>Apoderado</h3>
            <div class="styled-select slate" style="margin: auto">
                <select id="seleccion" name="apoderado" onchange="nuevoAp()">
                    ${apoderados}
                </select>
            </div>
            <div id="datos" hidden>
                <br>
                <font size="4"><b>Nombre:</b></font>
                <input id="inN" type="text" name="nombreApoderado" style="width: 200px"/>
                <br>
                <font size="4"><b>Apellido:</b></font>
                <input id="inA" type="text" name="apellidoApoderado" style="width: 200px"/>
            </div>
            <br>
            <button class="btn btn-4" type="submit">Agregar Alumno</button>
        </form>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
