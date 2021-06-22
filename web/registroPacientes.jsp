<%-- 
    Document   : registroPacientes
    Created on : 20/06/2021, 01:58:27 AM
    Author     : Auria Sonda Maas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pacientes | CC</title>
        <link type="text/css" rel="stylesheet" href="css/bulma.css"/>
    </head>
    <body>
        <%@include file='header.jsp'%>
        <br><br>
        <div class="container">

            <form class="box" action="Controller?menu=1" method="post">
                <div class="field-body">
                    <div class="field">
                        <p class="control is-expanded has-icons-left">
                            <input class="input" type="text" name="txnombreP" placeholder="Nombre(s)">
                            <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control is-expanded has-icons-left has-icons-right">
                            <input class="input" type="text" name="txapellidoP" placeholder="Apellido(s)">
                            <span class="icon is-small is-left">
                                <i class="fas fa-envelope"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control is-expanded has-icons-left has-icons-right">
                            <input class="input" type="number" name="txedad" placeholder="edad">
                            <span class="icon is-small is-left">
                                <i class="fas fa-envelope"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control is-expanded has-icons-left has-icons-right">
                            <input class="input" type="text" name="txsexo" placeholder="Sexo" maxlength="1">
                            <span class="icon is-small is-left">
                                <i class="fas fa-envelope"></i>
                            </span>
                        </p>
                    </div>
                </div>

                <br><br>

                <div class="field-body">
                     <div class="field">
                        <p class="control is-expanded has-icons-left has-icons-right">
                            <input class="input" type="text" name="txtfechaN" placeholder="yyyy/mm/dd">
                            <span class="icon is-small is-left">
                                <i class="fas fa-envelope"></i>
                            </span>
                            Fecha Nacimiento
                        </p>
                    </div>

                    <div class="field">
                        <p class="control is-expanded has-icons-left has-icons-right">
                            <input class="input" type="text" name="txnombreTut" placeholder="Nombre Tutor">
                            <span class="icon is-small is-left">
                                <i class="fas fa-envelope"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label"></div>
                        <div class="field-body">
                            <div class="field is-expanded">
                                    <div class="field has-addons">
                                      <p class="control">
                                        <a class="button is-static">
                                          +52
                                        </a>
                                      </p>
                                      <p class="control is-expanded">
                                          <input class="input" type="text" name="txnumeroTutor" placeholder="Telefono del tutor" maxlength="10">
                                      </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                <br><br>
                <div class="field is-horizontal">
                    <p class="control is-expanded has-icons-left">
                        <input class="input" type="text" name="txfechaIns" placeholder="yyyy/mm/dd">
                        <span class="icon is-small is-left">
                            <i class="fas fa-user"></i>
                        </span>
                        Fecha Inscripción
                    </p>
                    <br>
                    <div class="field-label is-normal">
                      <label class="label">Hospital de Origen</label>
                    </div>
                    <div class="field-body">
                        <div class="field is-narrow">
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="idHosporigen">
                                    <c:forEach items="${hospitales}" var="hospital">  
                                        <option value="${hospital.getIdHospital()}">${hospital.getNombreHospital()}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" name="opcion" value="add" class="button is-primary is-fullwidth">Registrar</button>
            </form> 
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    </body>
</html>
