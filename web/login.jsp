<%-- 
    Document   : login
    Created on : 18/06/2021, 07:50:09 PM
    Author     : Auria Sonda Maas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión || CC</title>
        <link type="text/css" rel="stylesheet" href="css/bulma.css"/>
    </head>
    <body>  
        <br><br><br>
        
        <div class="container">
            <div class="columns is-mobile">
                <div class="column is-three-fifths is-offset-one-fifth">
                    <div class="box ">
                        <br>
                        <div class="has-text-centered">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="images/grupo.png" alt="Imagen referencia al inicio de sesión">
                            </figure>
                        </div>
                        <br>
                        <form class="box" action="Login" method="post">
                            <div class="field">
                                <label class="label">Usuario</label>
                                <div class="control">
                                    <input class="input" type="text" name="user" placeholder="nombre usuario" maxlength="8">
                                </div>
                            </div>

                            <div class="field">
                              <label class="label">Password</label>
                              <div class="control">
                                <input class="input" type="password" name="pwd" placeholder="********">
                              </div>
                            </div>
                            <input type="submit" name="accion" value="Ingresar" class="button is-primary">
                        </form>
                    </div>
                </div>
            </div>
        </div>
            
        <%
            if (request.getParameter("error") != null){
        %>
                <div class="notification is-danger">
                    <button class="delete"></button>
                    El Usuario y/o Contraseña es Invalida
                </div>
        <%
            }
        %>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                (document.querySelectorAll('.delete') || []).forEach(($delete) => {
                  $notification = $delete.parentNode;

                  $delete.addEventListener('click', () => {
                    $notification.parentNode.removeChild($notification);
                  });
                });
              });
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    </body>
</html>
