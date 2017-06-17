<%-- 
    Document   : index
    Created on : 02-06-2017, 3:19:24
    Author     : Diego
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.archivos.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Curso</title>
        <link rel="stylesheet" href="css/pagina.css" media="screen">
        <link rel="stylesheet" href="css/combobox.css" media="screen">
        <link rel="stylesheet" href="css/tabla.css" media="screen">
        <link rel="stylesheet" href="css/botones.css" media="screen">
    </head>
    <body>
        <h1>Bienvenido al gestor versión Web del Colegio</h1>
        <h2>Cursos que existen actualmente en la base de datos:</h2>

        <%!
            private String verCursos() {
                String msg = "";
                Database dat = new Database();
                for (int i = 1; i < 9; i++) {
                    if (i % 2 == 0) {
                        msg += "<tr>";
                    } else {
                        msg += "<tr class=\"alt\">";
                    }
                    msg += "<td>" + i + "</td><td>";
                    ArrayList<String> letras = dat.existCurso(i);
                    for (int j = 0; j < letras.size(); j++) {
                        msg += "" + i + letras.get(j) + "-";
                    }
                    msg = msg.substring(0, msg.length() - 1);
                    msg += "</td></tr>";
                }
                return msg;
            }
        %>
        <div class="datagrid">
            <table>
                <thead>
                    <tr>
                        <th>Nivel</th>
                        <th>Cursos</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        out.println(verCursos());
                    %>
                </tbody>
            </table>
        </div>
        <%!
            private String listarCursos() {
                String msg = "";
                Database dat = new Database();
                for (int i = 1; i < 9; i++) {
                    ArrayList<String> letras = dat.existCurso(i);
                    for (int j = 0; j < letras.size(); j++) {
                        msg += "<option value=\"" + i + " " + letras.get(j) + "\">" + i + " " + letras.get(j) + "</option>";
                    }
                }
                return msg;
            }
        %>
        <div class="row">
            <form class="column" action="buscarCurso" method="post" style="text-align: center">
                <h3>
                    Ver Curso: Seleccione curso a mostrar
                </h3>
                <div class="styled-select slate" style="margin: auto">
                    <select name="curso">
                        <%
                            out.println(listarCursos());
                        %>
                    </select>
                </div>
                <br>
                <button type="submit" class="btn btn-4">Mostrar Curso</button>
            </form>
            <form class="column" action="addCurso" method="post" style="text-align: center">
                <h3>
                    Agregar Curso: Seleccione nivel al que añadir curso
                </h3>
                <div class="styled-select slate" style="margin: auto">
                    <select name="nivel" size="1">
                        <option value="1"> 1 </option>
                        <option value="2"> 2 </option>
                        <option value="3"> 3 </option>
                        <option value="4"> 4 </option>
                        <option value="5"> 5 </option>
                        <option value="6"> 6 </option>
                        <option value="7"> 7 </option>
                        <option value="8"> 8 </option>
                    </select>
                </div>
                <br>
                <button type="submit" class="btn btn-4">Agregar Curso</button>
            </form>
        </div>
        <form action="generate" method="get" style="text-align: center">
            <p style="text-align: center">
                <button type="submit" class="btn btn-4">Generar nuevo Colegio</button>
            </p>
        </form>
    </body>
</html>

