<!DOCTYPE html>
<!--
Autor: Diego Garrido
-->
<html lang="es" ng-app="mdButton">
    <head>
        <title>Colegio Web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS de Angular-->
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.4/angular-material.min.css">
        <!-- CSS del proyecto -->
        <link rel="stylesheet" type="text/css" href="web.css">
    </head>
    <body>
        <div layout="row" layout-align="center center">
            <md-fab-speed-dial md-direction="right" class="md-fling ">
                <md-fab-trigger>
                    <md-button aria-label="menu" class="md-fab md-warn">Curso</md-button>
                </md-fab-trigger>

                <md-fab-actions>
                    <md-button class="md-fab md-raised md-mini">A</md-button>
                    <md-button class="md-fab md-raised md-mini">B</md-button>
                    <md-button class="md-fab md-raised md-mini">C</md-button>
                </md-fab-actions>
            </md-fab-speed-dial>
        </div>

        <form action="buscarCurso" method="post">

        </form>

        <div>
            <md-button class="md-raised" onclick="window.location = 'verCurso.jsp';">Ver Curso</md-button>
        </div>


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
