package model;

/**
 *
 * @author Auria Sonda Maas
 */

public class Usuario {
    private int id;
    private String usuario;
    private String pass;
    int tipoUsu;
    int estado;

    public Usuario() {
        
    }

    public Usuario(int id, String usuario, String pass, int tipoUsu, int estado) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.tipoUsu = tipoUsu;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(int tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
