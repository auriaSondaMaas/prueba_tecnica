package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Auria Sonda Maas
 */
public class Conexion {
    private Connection conexion;
    private final String url = "jdbc:mysql://localhost:3306/hospital_infantil?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String user = "root";
    private final String password = "";
    protected Statement stm; 
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectando a la bd...");
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println(" Error no se ha establecido la conexión: ");
            System.out.println(" " + ex.getMessage() + "\n" + ex.getCause() + "\n" + ex.toString());
        }
        
        return conexion;
    }
}
