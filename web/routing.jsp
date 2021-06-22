<%-- 
    Document   : routing
    Created on : 19/06/2021, 02:10:48 AM
    Author     : Auria Sonda Maas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    if (request.getParameter("smenu") != null){
        int smenu = Integer.parseInt(request.getParameter("smenu"));
        switch (smenu) {
            //inicio
            case 1:
%>
                <%@include file='bienvenida.jsp' %>
<%
                break;
            //agregar pacientes
            case 2:
%>
                <%@include file='addPacientes.jsp' %>
<%
            break;
            
            case 3:
%>
                <%@include file='home.jsp' %>
<%
                break;
        }
    } else {
%>
        <%@include file='index.jsp'%>
<%
    }
%>