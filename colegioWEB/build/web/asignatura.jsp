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
        <title>Asignatura</title>
    </head>
    <body>
        <div style="text-align: center">
            <h3>Seleccione asignatura</h3>  
            <form action="notas" method="post">
                <input type="hidden" name="curso" value="${curso}">
                <input type="hidden" name="alumno" value="${alumno}">
                <input type="hidden" name="idAlumno" value="${idAlumno}">
                <select name="asignatura">
                    ${asignaturas}
                </select>
                <input type="submit" value="Ver notas">
            </form>
            <h3>Agregar Asignatura</h3>
            <form action="addAsignatura" method="post">
                <input type="hidden" name="curso" value="${curso}">
                Nombre Asignatura: (ingrese solo el nombre, el nivel se añadirá automáticamente) <br>
                <input type="text" name="nombreAsignatura"> ${curso}
                <br><br>
                Profesor:
                <select name="profesor">
                    ${profesores}
                </select>
                <br><br>
                Si selecciona Nuevo Profesor<br>Nombre:
                <input type="text" name="nombreProfesor">
                <br><br>
                <input type="submit" value="Añadir">
            </form>
        </div>
        <p style="text-align: left">
            <button type="button" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
