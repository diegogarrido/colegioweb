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
        <link rel="stylesheet" href="css/botones.css" media="screen">
        <link rel="stylesheet" href="css/input.css" media="screen">
    </head>
    <body>
        <h3>Anotaciones del alumno ${alumno}</h3>
        <div class="datagrid">
            <table>
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="0" end="${anotaciones.size()-1}">
                        <c:choose>
                            <c:when test="${i%2==0}"><tr></c:when>
                            <c:when test="${i%2!=0}"><tr class="alt"></c:when>
                            </c:choose>
                            <td>${anotaciones.get(i).split(",")[0]}</td>
                            <td>${anotaciones.get(i).split(",")[1]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <form class="column" action="addAnotacion" method="post" style="text-align: center">
                <b>Agregar anotación</b>
                <br><br>
                <b>Escriba el motivo de la anotación:</b>
                <input type="text" name="descripcion" required>
                <br>
                <b>Tipo:</b>
                <div class="styled-select slate" style="margin: auto">
                    <select name="tipo">
                        <option value="Positiva">Positiva</option>
                        <option value="Negativa">Negativa</option>
                    </select>
                </div>
                <input type="hidden" name="curso" value="${curso}">
                <input type="hidden" name="alumno" value="${alumno}">
                <br>
                <button class="btn btn-4" type="submit">Añadir anotación</button>
            </form>
            <form class="column" action="cambiarAnotacion" method="post" style="text-align: center">
                <b>Editar Anotación</b>
                <br><br>
                <b>Re - escriba motivo de la anotacion:</b>
                <input type="text" name="descripcion" required>
                <br>
                <b style="text-align: center"> Eliga anotacion a modificar:</b>
                <div class="styled-select slate" style="margin: auto">
                    <select name="idAnotacion">
                        <c:forEach var="i" begin="0" end="${anotaciones.size()-1}">
                            <option value="${i}">
                                ${anotaciones.get(i).split(",")[1]}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <input type="hidden" name="curso" value="${curso}">
                <input type="hidden" name="alumno" value="${alumno}">
                <button class="btn btn-4" type="submit">Editar anotacion</button>
            </form>
        </div>
        <p>
            <button type="button" class="btn btn-4" style="margin: 0px" onclick="window.location = 'index.jsp';"> 
                Inicio
            </button>
        </p>
    </body>
</html>
