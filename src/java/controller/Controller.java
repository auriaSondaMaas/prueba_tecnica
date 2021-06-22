/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HospitalDao;
import model.Paciente;
import model.PacienteDao;
import model.Usuario;
import model.UsuarioDao;

/**
 *
 * @author Auria Sonda Maas
 */
public class Controller extends HttpServlet {
    private Paciente paciente;
    private PacienteDao pacienteDao;
    private HospitalDao hospitalDao;
    private int idPaciente;
    private UsuarioDao udao;
    private Usuario usu;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        paciente = new Paciente();
        pacienteDao = new PacienteDao();
        hospitalDao = new HospitalDao();
        
        String nombreP;
        String apellidoP;
        int edadP;
        String sexoP;
        String fechaN;
        String nombreT;
        String telefonoT;
        String fechaI;
        int idHO;
        
        String user, pwd;
        udao = new UsuarioDao();
        usu = new Usuario();
        
        HttpSession s1 = request.getSession();
        if (request.getParameter("menu") != null){
            int smenu = Integer.parseInt(request.getParameter("menu"));
            try {
                switch (smenu) {
                    case 1:
                        //operaciones sin loguearse
                        String listado = request.getParameter("opcion");
                        List hospitales = hospitalDao.listaHospitales();
                        request.setAttribute("hospitales", hospitales);
                        switch(listado) {
                            case "listar":
                                List lista = pacienteDao.listar();
                                request.setAttribute("pacientes", lista);
                                request.getRequestDispatcher("pacientes.jsp").forward(request, response);
                                break;
                                
                            case "form":
                                request.getRequestDispatcher("registroPacientes.jsp").forward(request, response);
                                break;
                                
                            case "hospitales":
                                break;
                                
                            case "add": //agregar nuevo paciente
                                nombreP = request.getParameter("txnombreP");
                                apellidoP = request.getParameter("txapellidoP");
                                edadP = Integer.parseInt(request.getParameter("txedad"));
                                sexoP = request.getParameter("txsexo");
                                fechaN = request.getParameter("txtfechaN");
                                nombreT = request.getParameter("txnombreTut");
                                telefonoT = request.getParameter("txnumeroTutor");
                                fechaI = request.getParameter("txfechaIns");
                                idHO = Integer.parseInt(request.getParameter("idHosporigen"));
                                paciente.setNombre(nombreP);
                                paciente.setApellido(apellidoP);
                                paciente.setEdad(edadP);
                                paciente.setSexo(sexoP);
                                paciente.setFecha_nacimiento(fechaN);
                                paciente.setNombreTutor(nombreT);
                                paciente.setTelefonoTutor(telefonoT);
                                paciente.setFecha_inscripcion(fechaI);
                                paciente.setIdHospital(idHO);
                                pacienteDao.add(paciente);
                                request.getRequestDispatcher("Controller?menu=1&opcion=listar").forward(request, response);
                                break;
                                
                            case "print":
                                idPaciente = Integer.parseInt(request.getParameter("id"));
                                try {
                                    pacienteDao.generarPDF(idPaciente);
                                } catch (FileNotFoundException | DocumentException ex) {
                                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                request.getRequestDispatcher("Controller?menu=1&opcion=listar").forward(request, response);
                                break;
                                
                            case "verHistorial":
                                break;
                            case "addHistorial":
                                break;
                        } 
                        break;
                    case 2:
                        //página de login
                        response.sendRedirect("login.jsp");
                        break;
                    case 3:
                        //validación del login
                        if(request.getAttribute("tipo_usu") == "1") {
//                            s1 = request.getSession();
                            s1.setAttribute("super", request.getAttribute("users"));
                            //s1.setAttribute("privad", 1);
                            request.getRequestDispatcher("usuarios.jsp?smenu=3").forward(request, response);
                            //                    response.sendRedirect("usuarios.jsp");
                        } else if(request.getAttribute("tipo_usu") == "2") {
//                            s1 = request.getSession();
                            //request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
                            s1.setAttribute("admin", request.getAttribute("users"));
                            request.getRequestDispatcher("home-admin.jsp?smenu=1").forward(request, response);
                            //                    response.sendRedirect("pacientes.jsp");
                        }
                        break;
                    case 4:
                        //opciones logueo admin
                        String opciones = request.getParameter("opcion");
                        List hospitales2 = hospitalDao.listaHospitales();
                        request.setAttribute("hospitales", hospitales2);
                        switch(opciones) {
                            case "listar":
                                List lista = pacienteDao.listar();
                                request.setAttribute("pacientes", lista);
                                request.getRequestDispatcher("home-admin.jsp?smenu=2").forward(request, response);
                                break;
                                
                            case "add":
                                nombreP = request.getParameter("txnombreP");
                                apellidoP = request.getParameter("txapellidoP");
                                edadP = Integer.parseInt(request.getParameter("txedad"));
                                sexoP = request.getParameter("txsexo");
                                fechaN = request.getParameter("txtfechaN");
                                nombreT = request.getParameter("txnombreTut");
                                telefonoT = request.getParameter("txnumeroTutor");
                                fechaI = request.getParameter("txfechaIns");
                                idHO = Integer.parseInt(request.getParameter("idHosporigen"));
                                paciente.setNombre(nombreP);
                                paciente.setApellido(apellidoP);
                                paciente.setEdad(edadP);
                                paciente.setSexo(sexoP);
                                paciente.setFecha_nacimiento(fechaN);
                                paciente.setNombreTutor(nombreT);
                                paciente.setTelefonoTutor(telefonoT);
                                paciente.setFecha_inscripcion(fechaI);
                                paciente.setIdHospital(idHO);
                                pacienteDao.add(paciente);
                                request.getRequestDispatcher("Controller?menu=4&opcion=listar").forward(request, response);
                                break;
                                
                            case "edit":
                                idPaciente = Integer.parseInt(request.getParameter("id"));
                                Paciente pc = pacienteDao.listarId(idPaciente);
                                request.setAttribute("pacienteEdit", pc);
                                request.setAttribute("botonCancelar", "1");
                                request.getRequestDispatcher("Controller?menu=4&opcion=listar").forward(request, response);
                                break;
                                
                            case "update":
                                nombreP = request.getParameter("txnombreP");
                                apellidoP = request.getParameter("txapellidoP");
                                edadP = Integer.parseInt(request.getParameter("txedad"));
                                sexoP = request.getParameter("txsexo");
                                fechaN = request.getParameter("txtfechaN");
                                nombreT = request.getParameter("txnombreTut");
                                telefonoT = request.getParameter("txnumeroTutor");
                                fechaI = request.getParameter("txfechaIns");
                                idHO = Integer.parseInt(request.getParameter("idHosporigen"));
                                paciente.setNombre(nombreP);
                                paciente.setApellido(apellidoP);
                                paciente.setEdad(edadP);
                                paciente.setSexo(sexoP);
                                paciente.setFecha_nacimiento(fechaN);
                                paciente.setNombreTutor(nombreT);
                                paciente.setTelefonoTutor(telefonoT);
                                paciente.setFecha_inscripcion(fechaI);
                                paciente.setIdHospital(idHO);
                                pacienteDao.add(paciente);
                                request.getRequestDispatcher("Controller?menu=4&opcion=listar").forward(request, response);
                                break;
                                
                            case "delete":
                                idPaciente = Integer.parseInt(request.getParameter("id"));
                                pacienteDao.delete(idPaciente);
                                request.getRequestDispatcher("Controller?menu=4&opcion=listar").forward(request, response);
                                break;
                                
                            case "verHistorial":
                                break;
                        }
//                        request.getRequestDispatcher("usuarios.jsp?smenu=2").forward(request, response);
                        break;
                    case 5:
                        //operaciones dba
                        break;
                    case 6:
                        //cerrar sesion
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if(request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if(accion.equalsIgnoreCase("ingresar")) {
                user = request.getParameter("user");
                pwd = request.getParameter("pwd");
                try {
                    usu = udao.login(user, pwd);
                    if(usu != null) {
                        if(usu.getTipoUsu() == 1) {
                            request.setAttribute("users", usu);
                            request.setAttribute("tipo_usu", "1");
                            request.getRequestDispatcher("Controller?menu=3").forward(request, response);
                        } else if(usu.getTipoUsu() == 2) {
                            request.setAttribute("users", usu);
                            request.setAttribute("tipo_usu", "2");
                            request.getRequestDispatcher("Controller?menu=3").forward(request, response);
                        } else {
                            request.getRequestDispatcher("login.jsp?error=1").forward(request, response);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
