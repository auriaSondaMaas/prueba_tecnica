package model;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Auria Sonda Maas
 */

public class UsuarioDao {
    private Conexion conexion;
    private Connection connection;
    private int res;
    
    public Usuario login(String usu, String pass) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        Usuario users = new Usuario();
        int tipo_user = 0;
        String sql = "select * from login where nombre_usuario=? and pass=? and Estado=1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usu);
        statement.setString(2, pass);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            users.setUsuario(rs.getString("nombre_usuario"));
//            System.out.println("nombre:" + users.getUsuario());
            users.setPass(rs.getString("pass"));
//            System.out.println("pass:" + users.getPass());
            users.setTipoUsu(rs.getInt("tipo_usuario"));
        }
        connection.close();
        return users;
    }
    
    private int idUsuario() throws SQLException {
        Usuario us = new Usuario();
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select idUsuario from login order by idUsuario desc limit 1;;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            us.setId(rs.getInt("idUsuario"));
        }
        connection.close();
        int id = us.getId();
        System.out.println("idUs: " + id);
        return id;
    } 
    
     //operaciones CRUD
//    public List listar() throws SQLException {
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        List<Usuario> usus = new ArrayList<>();
//        String sql = "select login.idUsuario, login.Nombre_Usuario, login.Contraseña, login.Tipo_Usuario, login.Estado, sucursal.Sucursal from dyjamir.login, dyjamir.sucursal where login.idDependencia = sucursal.idDependencia and login.Estado = 1;";
////        String sql = "SELECT idUsuario, Nombre_Usuario, Contraseña, Tipo_Usuario, Sucursal FROM dyjamir.login a inner join dyjamir.sucursal b on a.idDependencia = b.idDependencia";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        ResultSet rs = statement.executeQuery();
//        while(rs.next()) {
//            Usuario users = new Usuario();
//            users.setId(rs.getInt("idUsuario"));
//            //System.out.println("id:" + users.getIdUsu());
//            users.setUsuario(rs.getString("Nombre_Usuario"));
//            //System.out.println("nombre:" + users.getNombre_usuario());
//            users.setPass(rs.getString("Contraseña"));
//            users.setTipoUsu(rs.getInt("Tipo_Usuario"));
//            users.setEstado(rs.getInt("Estado"));
//            //System.out.println("estado:" + users.getEstado());
//            usus.add(users);
//        }
//        connection.close();
//       return usus;      
//    }
    
    /*public Usuario listarId(int id) throws SQLException {
        Usuario user = new Usuario();
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select *from login where idUsuario="+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            user.setUsuario(rs.getString("Nombre_Usuario"));
            //System.out.println("nombre:" + users.getNombre_usuario());
            user.setPass(rs.getString("Contraseña"));
            user.setTipoUsu(rs.getInt("tipo_Usuario"));
            //System.out.println("estado:" + users.getEstado());
            user.setEstado(rs.getInt("Estado"));
        }
        connection.close();
        return user;
    } */

//    public int add(Usuarios user) throws SQLException {
//        int estado = 1;
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "insert into login (Nombre_Usuario, Contraseña, tipo_usuario, estado) values (?, ?, ?, ?, ?);";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, user.getNombre_usuario());
//        statement.setString(2, user.getPassword());
//        statement.setInt(3, user.getTipo_usuario());
//        statement.setInt(4, user.getIdDependencia());
//        statement.setInt(5, estado);
//        statement.executeUpdate();
//        return res;
//    }
//
//    public int update (Usuarios user) throws SQLException {
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "update login set nombre_usuario=?, Contraseña=?, Tipo_Usuario=?, estado=? where idUsuario=? ";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, user.getNombre_usuario());
//        statement.setString(2, user.getPassword());
//        statement.setInt(3, user.getTipo_usuario());
//        statement.setInt(4, user.getIdDependencia());
//        statement.setInt(5, user.getEstado());
//        statement.setInt(6, user.getIdUsu());
//        statement.executeUpdate();
//        return res;
//    }
//
//    public int delete(int id) throws SQLException {
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "update login set Estado=0 where idUsuario="+id;
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.executeUpdate();
//        return res;
//    }
//    
//    public boolean checkUser(String user) throws SQLException {
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "select Nombre_Usuario from login where Nombre_Usuario = ?;";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, user);
//        ResultSet rs = statement.executeQuery();
//        if(rs.next()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
