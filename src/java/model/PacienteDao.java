package model;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Auria Sonda Maas
 */
public class PacienteDao {
    private Conexion conexion;
    private Connection connection;
    private int res;
     //operaciones CRUD
    public List listar() throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        List<Paciente> pcientes = new ArrayList<>();
        String sql = "select paciente.idPaciente, paciente.nombre, "
                + "paciente.apellido, paciente.edad, paciente.sexo, "
                + "paciente.fecha_nacimiento, paciente.nombre_tutor, "
                + "paciente.telefono_tutor, paciente.fecha_isncripcion, "
                + "hospital.nombre from hospital_infantil.paciente, "
                + "hospital_infantil.hospital where paciente.idHospital = hospital.idHospital;";
//        String sql = "SELECT idUsuario, Nombre_Usuario, Contraseña, Tipo_Usuario, Sucursal FROM dyjamir.login a inner join dyjamir.sucursal b on a.idDependencia = b.idDependencia";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Paciente pacientes = new Paciente();
            pacientes.setIdPaciente(rs.getInt("idPaciente"));
            //System.out.println("id:" + users.getIdUsu());
            pacientes.setNombre(rs.getString("nombre"));
            //System.out.println("nombre:" + users.getNombre_usuario());
            pacientes.setApellido(rs.getString("apellido"));
            pacientes.setEdad(rs.getInt("edad"));
            pacientes.setSexo(rs.getString("sexo"));
            System.out.println("sexo:" + pacientes.getSexo());
            pacientes.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            pacientes.setNombreTutor(rs.getString("nombre_tutor"));
            pacientes.setTelefonoTutor(rs.getString("telefono_tutor"));
            pacientes.setFecha_inscripcion(rs.getString("fecha_isncripcion"));
//            pacientes.setIdHospital(rs.getInt("idHospital"));
            pacientes.setHospitalOrigen(rs.getString("hospital.nombre"));
            pcientes.add(pacientes);
        }
        connection.close();
       return pcientes;      
    }
    
    private int idPaciente() throws SQLException {
        Paciente pc = new Paciente();
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select idPaciente from paciente order by idPaciente desc limit 1;";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            pc.setIdPaciente(rs.getInt("idPaciente"));
        }
        connection.close();
        int id = pc.getIdPaciente();
        System.out.println("idpc: " + id);
        return id;
    } 
    
    public Paciente listarId(int id) throws SQLException {
        Paciente paciente = new Paciente();
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "select paciente.nombre, paciente.apellido, paciente.edad, paciente.sexo, paciente.fecha_nacimiento, paciente.nombre_tutor, paciente.telefono_tutor, paciente.fecha_isncripcion, hospital.nombre from hospital_infantil.paciente, hospital_infantil.hospital where paciente.idHospital = hospital.idHospital and idPaciente ="+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            //System.out.println("id:" + users.getIdUsu());
            paciente.setNombre(rs.getString("nombre"));
            //System.out.println("nombre:" + users.getNombre_usuario());
            paciente.setApellido(rs.getString("apellido"));
            paciente.setEdad(rs.getInt("edad"));
            paciente.setSexo(rs.getString("sexo"));
            //System.out.println("estado:" + users.getEstado());
            paciente.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            paciente.setNombreTutor(rs.getString("nombre_tutor"));
            paciente.setTelefonoTutor(rs.getString("telefono_tutor"));
            paciente.setFecha_inscripcion(rs.getString("fecha_isncripcion"));
//            paciente.setIdHospital(rs.getInt("idHospital"));
            paciente.setHospitalOrigen(rs.getString("hospital.nombre"));
        }
        connection.close();
        return paciente;
    }

    public int add(Paciente pacientes) throws SQLException {
        int idP = idPaciente() + 1;
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "INSERT INTO paciente (idPaciente, nombre, apellido, edad, sexo, fecha_nacimiento, nombre_tutor, telefono_tutor, fecha_isncripcion, idHospital) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idP);
        statement.setString(2, pacientes.getNombre());
        statement.setString(3, pacientes.getApellido());
        statement.setInt(4, pacientes.getEdad());
        statement.setString(5, pacientes.getSexo());
        statement.setString(6, pacientes.getFecha_nacimiento());
        statement.setString(7, pacientes.getNombreTutor());
        statement.setString(8, pacientes.getTelefonoTutor());
        statement.setString(9, pacientes.getFecha_inscripcion());
        statement.setInt(10, pacientes.getIdHospital());
        res = statement.executeUpdate();
        statement.close();
        connection.close();
        return res;
    }

    public int update (Paciente pacientes) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "update paciente set nombre = ?, apellido = ?, edad = ?, "
                + "sexo = ?, fecha_nacimiento = ?, nombre_tutor = ?,"
                + " telefono_tutor = ?, fecha_isncripcion = ?, "
                + "idHospital = ? where idUsuario = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(2, pacientes.getNombre());
        statement.setString(3, pacientes.getApellido());
        statement.setInt(4, pacientes.getEdad());
        statement.setString(5, pacientes.getSexo());
        statement.setString(6, pacientes.getFecha_nacimiento());
        statement.setString(7, pacientes.getNombreTutor());
        statement.setString(8, pacientes.getTelefonoTutor());
        statement.setString(9, pacientes.getFecha_inscripcion());
        statement.setInt(10, pacientes.getIdHospital());
        statement.executeUpdate();
        connection.close();
        return res;
    }

    public int delete(int id) throws SQLException {
        conexion = new Conexion();
        connection = conexion.getConexion();
        String sql = "DELETE FROM paciente WHERE idPaciente ="+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        connection.close();
        return res;
    }
    
    public void generarPDF(int idP) throws FileNotFoundException, DocumentException, SQLException {
        Paciente paciente = listarId(idP);
//        String nomArch = "Paciente_" + paciente.getApellido() + ".pdf";
        
        // Se crea el documento
        Document documento = new Document();
        
        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("Paciente_"+paciente.getApellido()+".pdf");
        
        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);
        
        // Se abre el documento
        documento.open();
        
        // Parrafo
        Paragraph titulo = new Paragraph("Información de Paciente \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                        )
        );
        
        // Añadimos el titulo al documento
        documento.add(titulo);
        
        // Creamos una tabla
        PdfPTable tabla = new PdfPTable(9);
        tabla.addCell("Nombre completo");
        tabla.addCell("Edad");
        tabla.addCell("Sexo");
        tabla.addCell("Fecha Nacimiento");
        tabla.addCell("Edad");
        tabla.addCell("Nombre Tutor");
        tabla.addCell("Telefono Tutor");
        tabla.addCell("Fecha Inscripción");
        tabla.addCell("Hospital Origen");
        
//        for(int i = 0 ; i < lista.size() ; i++) {
//            tabla.addCell("" + i);
//            tabla.addCell(lista.get(i).getNombre());
//            tabla.addCell(lista.get(i).getTelefono());
//        }
        tabla.addCell(paciente.getNombre() + " " + paciente.getApellido());
        tabla.addCell(String.valueOf(paciente.getEdad()));
        tabla.addCell(paciente.getSexo());
        tabla.addCell(paciente.getFecha_nacimiento());
        tabla.addCell(paciente.getNombreTutor());
        tabla.addCell(paciente.getTelefonoTutor());
        tabla.addCell(paciente.getFecha_inscripcion());
        tabla.addCell(paciente.getHospitalOrigen());
        
                
        
        // Añadimos la tabla al documento
        documento.add(tabla);
        
        // Se cierra el documento
        documento.close();
    
    }
    
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
    
//    public static void main(String[] args) throws SQLException {
//        PacienteDao p = new PacienteDao();
//        Paciente pacientes = new Paciente();
//        pacientes.setNombre("Auria del Carmen");
//        pacientes.setApellido("Sonda Maas");
//        pacientes.setEdad(8);
//        pacientes.setSexo("F");
//        pacientes.setFecha_nacimiento("2013/10/09");
//        pacientes.setNombreTutor("Auria Maas Caamal");
//        pacientes.setTelefonoTutor("9811571114");
//        pacientes.setFecha_inscripcion("2021/06/19");
//        pacientes.setIdHospital(3);
//        p.add(pacientes);
//    }
}
