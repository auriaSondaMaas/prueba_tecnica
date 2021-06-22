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
public class HospitalDao {
    private Conexion conexion;
    private Connection connection;
    private int res;
    
    public List listaHospitales() throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        List<Hospital> hospitales = new ArrayList<>();
        String sql = "select *from hospital;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Hospital hosps = new Hospital();
            hosps.setIdHospital(rs.getInt("idHospital")); 
            hosps.setNombreHospital(rs.getString("nombre"));
            hosps.setDireccion(rs.getString("direccion"));
            hosps.setTelefono(rs.getString("telefono"));
            hospitales.add(hosps);
        }
        connection.close();
        return hospitales;
    }
    
    public Hospital listarIdHosp(int id) throws SQLException {
        Hospital hosp = new Hospital();
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select *from sucursal where idDependencia="+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            hosp.setNombreHospital(rs.getString("nombre"));
            hosp.setDireccion(rs.getString("direccion"));
            hosp.setTelefono(rs.getString("telefono"));
        }
        return hosp;
    }
    
//    public int add(Sucursal sucur) throws SQLException{
//        int estado = 1;
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "insert into sucursal (Sucursal, Estado) values (?, ?);";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, sucur.getSucursal());
//        statement.setInt(2, estado);
//        statement.executeUpdate();
//        return res;
//    }
//    
//    public int update(Sucursal sucur) throws SQLException{
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "update sucursal set Sucursal=? where idDependencia=? ";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, sucur.getSucursal());
//        statement.setInt(2, sucur.getidDependencia());
//        statement.executeUpdate();
//        return res;
//    }
//    
//    public int delete(int id) throws SQLException{
//        conexion = new Conexion();
//        connection = conexion.getConexion();
//        String sql = "update sucursal set Estado=0 where idDependencia="+id;
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.executeUpdate();
//        return res;
//    }
}
