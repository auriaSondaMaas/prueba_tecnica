<%-- 
    Document   : usuarios
    Created on : 19/06/2021, 02:10:48 AM
    Author     : Auria Sonda Maas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session= "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="css/bulma.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
       
        <nav class="navbar is-warning" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="Controller?menu=2">
                    <img src="images/logo3.png" width="60" height="40">
                </a>

                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasic">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasic" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item is-disabled">
                        Historial de Pacientes
                    </a>
                </div>
            </div>
            
            <div class="">
                <div class="navbar-item">
                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                          ${users.getUsuario()}
                        </a>

                        <div class="navbar-dropdown is-right">
                            <a href="Controller?menu=4&opcion=listar" class="navbar-item">
                                Registro de Pacientes
                            </a>
                            <hr class="navbar-divider">
                            <a href="CerrarSesion?cs=2" class="navbar-item">
                             Cerrar Sesión
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("admin") != null){    
        %>
        <br><br>
        <div class="container">
            <%@include file='routing.jsp'%>
        </div>
        <%
            }
        %>
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="js/events.js"></script> 
        <script type="text/javascript" src="js/sweetalert.min.js"></script>
    </body>
</html>
