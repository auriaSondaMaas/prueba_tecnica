<%-- 
    Document   : addPacientes
    Created on : 19/06/2021, 02:55:55 PM
    Author     : Auria Sonda Maas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br><br>
<div class="container">
    <h4 style="text-align: center;">Lista de pacientes</h4>
    <div class="table-container">
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
                    <th>Acciones</th>
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
                            <a class="button is-warning" href="Controller?menu=4&opcion=edit&id=${paciente.getIdPaciente()}"><i style="color:whitesmoke;" class="material-icons">edit</i></a>
                            <a class="button is-danger" onclick="eliminar([[${paciente.getIdPaciente()}]]);"><i style="color:whitesmoke;" class="material-icons">delete</i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <form class="box" action="Controller?menu=4" method="post">
        <div class="field-body">
            <div class="field">
                <p class="control is-expanded has-icons-left">
                    <input class="input" type="text" name="txnombreP" placeholder="Nombre(s)" value="${pacienteEdit.getNombre()}">
                    <span class="icon is-small is-left">
                        <i class="fas fa-user"></i>
                    </span>
                </p>
            </div>
            <div class="field">
                <p class="control is-expanded has-icons-left has-icons-right">
                    <input class="input" type="text" name="txapellidoP" placeholder="Apellido(s)" value="${pacienteEdit.getApellido()}">
                    <span class="icon is-small is-left">
                        <i class="fas fa-envelope"></i>
                    </span>
                </p>
            </div>
            <div class="field">
                <p class="control is-expanded has-icons-left has-icons-right">
                    <input class="input" type="text" name="txedad" placeholder="edad" value="${pacienteEdit.getEdad()}">
                    <span class="icon is-small is-left">
                        <i class="fas fa-envelope"></i>
                    </span>
                </p>
            </div>
            <div class="field">
                <p class="control is-expanded has-icons-left has-icons-right">
                    <input class="input" type="text" name="txsexo" placeholder="Sexo" maxlength="1" value="${pacienteEdit.getSexo()}">
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
                    <input class="input" type="text" name="txtfechaN" placeholder="yyyy/mm/dd" value="${pacienteEdit.getFecha_nacimiento()}">
                    <span class="icon is-small is-left">
                        <i class="fas fa-envelope"></i>
                    </span>
                    Fecha Nacimiento
                </p>
            </div>

            <div class="field">
                <p class="control is-expanded has-icons-left has-icons-right">
                    <input class="input" type="text" name="txnombreTut" placeholder="Nombre Tutor" value="${pacienteEdit.getNombreTutor()}">
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
                                  <input class="input" type="text" name="txnumeroTutor" placeholder="Telefono del tutor" maxlength="10" value="${pacienteEdit.getTelefonoTutor()}">
                              </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <br><br>
        <div class="field is-horizontal">
            <p class="control is-expanded has-icons-left">
                <input class="input" type="text" name="txfechaIns" placeholder="yyyy/mm/dd" value="${pacienteEdit.getFecha_inscripcion()}">
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
        <button type="submit" name="opcion" value="add" class="button is-primary">Registrar</button>
        <button type="submit" name="opcion" value="update" class="button is-info">Actualizar</button>
        <%
            if(request.getAttribute("botonCancelar") != null) {
        %>
                <button type="submit" name="opcion" value="listar" class="button is-danger">Cancelar</button>
        <%
                
            }
        %>
    </form> 
</div>