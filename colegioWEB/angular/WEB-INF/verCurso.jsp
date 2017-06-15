<%-- 
    Document   : verCurso
    Created on : 02-06-2017, 2:52:05
    Author     : Diego
--%>

<%@page import="org.orm.PersistentException"%>
<%@page import="com.proyecto1.Curso"%>
<%@page import="com.archivos.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Curso ${msg}</title>
        <!-- CSS de Angular-->
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.css">
        <!-- CSS del proyecto -->
        <link rel="stylesheet" type="text/css" href="web.css">
    </head>
    <body>
        <div>
            <header class="header">
                Alumnos en el curso ${msg}
            </header>
        </div>
        <div class="container">
            <md-button class="md-raised" onclick="''">Alumno1</md-button>
            <md-button class="md-raised" onclick="window.location = 'notas.jsp';">Alumno2</md-button>
            <md-button class="md-raised" onclick="window.location = 'notas.jsp';">Alumno3</md-button>
            <md-button class="md-raised" onclick="window.location = 'notas.jsp';">Alumno4</md-button>
            <md-button class="md-raised" onclick="window.location = 'notas.jsp';">Alumno5</md-button>
        </div>
        
        <%!
            String print() {
                String msg = "";
                Database dat = new Database();
                try {
                    Curso cur = dat.retrieveCurso("1 A");
                    for (int i = 0; i < cur.getAlumnos().size(); i++) {
                        msg += "<div class=\"md-list-item-text\" layout=\"column\">";
                        msg += "<h3>" + cur.getAlumnos().get(i).getNombre() + "</h3>";
                        msg += "</div>";
                    }
                } catch (PersistentException ex) {
                }
                return msg;
            }
        %>

        <%
            out.println();
        %>
        
        <!-- Angular -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
        <!-- Librerías requeridas para usar Angular Materials -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-aria.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-messages.min.js"></script>
        <script src="web.js"></script>
        <!-- Angular Materials -->
        <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.js"></script>   
    </body>
</html>
