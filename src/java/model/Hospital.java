package model;

/**
 *
 * @author Auria Sonda Maas
 */
public class Hospital {
    private int idHospital;
    private String nombreHospital;
    private String direccion;
    private String telefono;

    public Hospital() {
    }

    public Hospital(int idHospital, String nombreHospital, String direccion, String telefono) {
        this.idHospital = idHospital;
        this.nombreHospital = nombreHospital;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
