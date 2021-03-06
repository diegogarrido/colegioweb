<%-- 
    Document   : asignatura
    Created on : 07-06-2017, 12:38:13
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
        <link rel="stylesheet" href="css/input.css" media="screen">
        <script>
            function nuevoProf() {
                if (document.getElementById("seleccion").value == "Nuevo Profesor") {
                    document.getElementById("datos").removeAttribute("hidden");
                    document.getElementById("in").setAttribute("required", "");
                } else {
                    document.getElementById("datos").setAttribute("hidden", "");
                    document.getElementById("in").removeAttribute("required");
                }
            }
        </script>
        <title>Asignatura</title>
    </head>
    <body>
        <h2 style="margin: 0px 0px 0px 35%;">Asignaturas</h2>
        <div class="row" style="text-align: center">
            <form class="column" action="notas" method="post">
                <br><br>
                <h3>Seleccione asignatura <br> para mostrar notas</h3>
                <input type="hidden" name="curso" value="${curso}">
                <input type="hidden" name="alumno" value="${alumno}">
                <input type="hidden" name="idAlumno" value="${idAlumno}">
                <div class="styled-select slate" style="margin: auto">
                    <select name="asignatura">
                        ${asignaturas}
                    </select>
                </div>
                <br>
                <button class="btn btn-4" type="submit">Ver notas</button>
            </form>
            <form class="column" action="addAsignatura" method="post">
                <h3>Agregar Asignatura</h3>
                <input type="hidden" name="curso" value="${curso}">
                Nombre Asignatura:<br>(ingrese solo el nombre, el nivel se añadirá automáticamente)
                <br><br>
                <input type="text" name="nombreAsignatura" required>
                <br>
                Profesor:
                <div class="styled-select slate" style="margin: auto">
                    <select id="seleccion" name="profesor" onchange="nuevoProf()">
                        ${profesores}
                    </select>
                </div>
                <br>
                <div id="datos" hidden>
                    Nombre:
                    <input id="in" type="text" name="nombreProfesor">
                </div>
                <br>
                <button class="btn btn-4" type="submit">Añadir</button>
            </form>
        </div>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
