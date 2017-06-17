<%-- 
    Document   : verAnotaciones
    Created on : 16-06-2017, 20:45:49
    Author     : Francisco Fierro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Anotaciones</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/tabla.css" media="screen">        
    </head>
    <body>
        <h3>Anotaciones del alumno ${alumno}</h3>
        <table>
            <thead>
                <tr>
                    <td>Tipo</td>
                    <td>Descripción</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" begin="0" end="${anotaciones.size()}">
                    <tr>
                        <td>${anotaciones.get(i).split(",")[0]}</td>
                        <td>${anotaciones.get(i).split(",")[1]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="addAnotacion" method="post">
            Escriba el motivo de la anotación: <input type="text" name="descripcion">
            <select name="tipo">
                <option value="Positiva">Positiva</option>
                <option value="Negativa">Negativa</option>
            </select>
            <input type="submit" value="Añadir anotación">
        </form>
        <form action="cambiarAnotacion" method="post">
            <b> Eliga anotacion a modificar </b>        
            <select name="idAnotacion" id="combobox" onchange="cambiarValue()">
                <c:forEach var="i" begin="0" end="${anotaciones.size()}">
                    <option>
                        ${anotaciones.get(i).split(",")[1]}
                    </option>
                </c:forEach>
            </select>
            <br>
            Re - escriba motivo de la anotacion            
            <input type="text" name="descripcion" id="texto" value="${anotaciones.get(i).split(",")[1]}">
            <input type="submit" value="Editar anotacion">
        </form>
    </body>
</html>
