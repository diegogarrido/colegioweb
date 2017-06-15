<%-- 
    Document   : verAsistencia
    Created on : 15-06-2017, 11:35:47
    Author     : Francisco Fierro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>Día</tr>
                <tr>¿Asistio?</tr>
            </thead>
            <c:forEach var="i" begin="0" end="${asistencia.size()}">
                <tr>
                    ${asistencia.get(i)}            
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
