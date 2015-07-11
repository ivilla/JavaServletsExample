/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utileria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ivan
 */
public class DataBaseConnectivity {

    public Connection connect;
    public PreparedStatement ps;

    public void openConnections(String query) {
        try {
            connect = ConnectionPool.getConexionBD();
            ps = connect.prepareStatement(query);
        } catch (SQLException sqle) {
            System.out.println("Error al conectarse a la base de datos");
            sqle.printStackTrace();
        }
    }

    public void closeConnections() {
        try {
            connect.close();
            ps.close();
        } catch (SQLException sqle) {
            System.out.println("Error al cerrar la conexion a la base de datos");
            sqle.printStackTrace();
        }
    }
}
