<%-- 
    Document   : header
    Created on : 18/06/2021, 08:08:40 PM
    Author     : Auria Sonda Maas
--%>

<nav class="navbar is-warning" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="#">
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
            <a href="Controller?menu=1&opcion=listar" class="navbar-item">
                Control de pacientes
            </a>

            <a href="Controller?menu=1&opcion=form" class="navbar-item">
                Registro de pacientes
            </a>
            <a class="navbar-item is-disabled">
                Historial de pacientes
            </a>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a href="Controller?menu=2" class="button is-info is-outlined is-rounded is-fullwidth">
                        <strong>Acceder</strong>
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>
