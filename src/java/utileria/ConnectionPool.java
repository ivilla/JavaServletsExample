package utileria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String service;
    private static ResourceBundle propiedadesBD;

    /**
     *  Método que carga el driver, establece la conexión.
     *
     *  @ return Connection
     *
     */

    public static Connection getConexionBD() throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(ipAddress, user, password);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Drier JDBC no encontrado");
            cnfe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        if (propiedadesBD == null) {
            propiedadesBD = ResourceBundle.getBundle("agenda");
            ipAddress = propiedadesBD.getString("ip_address");
            dbName = propiedadesBD.getString("db_name");
            user = propiedadesBD.getString("user");
            password = propiedadesBD.getString("password");
            service = propiedadesBD.getString("service");
        }

        return DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + service + "/" + dbName, user, password);
    }

    public static void main(String[] args) {
        try {
            Connection con = getConexionBD();
            System.out.println("Conexion efectuada...");
            con.close();
        } catch (Exception e) {
            System.err.println("LA CAGASTE " + e);
        }
    }
}
