<%-- 
    Document   : usuarios
    Created on : 19/06/2021, 02:10:48 AM
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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <%@include file='header.jsp'%>
        <br><br>
        <div class="container">
            <div class="box">    
                <h4 style="text-align: center;">Pacientes registrados</h4>
                <table class="table is-hoverable">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre(s)</th>
                            <th>Apellido(s)</th>
                            <th>Edad</th>
                            <th>Sexo</th>
                            <th>Fecha Nacimiento</th>
                            <th>Nombre Tutor</th>
                            <th>Telefono Tutor</th>
                            <th>Fecha Inscripción</th>
                            <th>Hospital de Origen</th>
                            <th>Acción</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${pacientes}" var="paciente">
                            <tr>
                                <td>${paciente.getIdPaciente()}</td>
                                <td>${paciente.getNombre()}</td>
                                <td>${paciente.getApellido()}</td>
                                <td>${paciente.getEdad()}</td>
                                <td>${paciente.getSexo()}</td>
                                <td>${paciente.getFecha_nacimiento()}</td>
                                <td>${paciente.getNombreTutor()}</td>
                                <td>${paciente.getTelefonoTutor()}</td>
                                <td>${paciente.getFecha_inscripcion()}</td>
                                <td>${paciente.getHospitalOrigen()}</td>
                                <td>
                                    <a class="button is-dark" onclick="imprimir([[${paciente.getIdPaciente()}]]);"><i style="color:whitesmoke;" class="material-icons">print</i></a>
                                <td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="js/events.js"></script> 
        <script type="text/javascript" src="js/sweetalert.min.js"></script>
    </body>
</html>
