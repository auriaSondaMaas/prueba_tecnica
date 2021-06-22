package model;

/**
 *
 * @author Auria Sonda Maas
 */

public class Paciente {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String fecha_nacimiento;
    private String nombreTutor;
    private String telefonoTutor;
    private String fecha_inscripcion;
    private int idHospital;
    
    private String hospitalOrigen;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombre, String apellido, int edad, String sexo, String fecha_nacimiento, String nombreTutor, String telefonoTutor, String fecha_inscripcion, int idHospital) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombreTutor = nombreTutor;
        this.telefonoTutor = telefonoTutor;
        this.fecha_inscripcion = fecha_inscripcion;
        this.idHospital = idHospital;
    }

    public Paciente(int idPaciente, String nombre, String apellido, int edad, String sexo, String fecha_nacimiento, String nombreTutor, String telefonoTutor, String fecha_inscripcion, int idHospital, String hospitalOrigen) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombreTutor = nombreTutor;
        this.telefonoTutor = telefonoTutor;
        this.fecha_inscripcion = fecha_inscripcion;
        this.idHospital = idHospital;
        this.hospitalOrigen = hospitalOrigen;
    }
    
    

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_naciemiento) {
        this.fecha_nacimiento = fecha_naciemiento;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getTelefonoTutor() {
        return telefonoTutor;
    }

    public void setTelefonoTutor(String telefonoTutor) {
        this.telefonoTutor = telefonoTutor;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getHospitalOrigen() {
        return hospitalOrigen;
    }

    public void setHospitalOrigen(String hospitalOrigen) {
        this.hospitalOrigen = hospitalOrigen;
    }
    
    
}
