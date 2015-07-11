/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.agenda;

import java.util.*;
import bean.agenda.BeanAgenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utileria.*;

/**
 *
 * @author Ivan
 */
public class AgendaDao extends DataBaseConnectivity {

    public boolean insertarInsecto(BeanAgenda insecto) {
        String query = "insert into participante (Nombres, Apaterno, Amaterno, Celular, Telefono, Edad, Direccion, cp)values(?,?,?,?,?,?,?,? )";
        boolean res = false;
        openConnections(query);
        try {
            ps.setString(1, insecto.getNombres());
            ps.setString(2, insecto.getApaterno());
            ps.setString(3, insecto.getAmaterno());
            ps.setString(4, insecto.getCelular());
            ps.setString(5, insecto.getTelefono());
            ps.setInt(6, insecto.getEdad());
            ps.setString(7, insecto.getDireccion());
            ps.setString(8, insecto.getCp());
            res = ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Hubo un error en la insercion" + e);
        } finally {
            closeConnections();
        }
        return res;
    }

    public boolean modificarInsecto(BeanAgenda insecto, int idInsecto) {
        String query = "UPDATE participante SET Nombres=?, Apaterno=?, Amaterno=?, Celular=?, Telefono=?, Edad=?, Direccion=?, cp=? WHERE idParticipante = ?";
        boolean res = false;
        openConnections(query);
        try {
            ps.setString(1, insecto.getNombres());
            ps.setString(2, insecto.getApaterno());
            ps.setString(3, insecto.getAmaterno());
            ps.setString(4, insecto.getCelular());
            ps.setString(5, insecto.getCelular());
            ps.setInt(6, insecto.getEdad());
            ps.setString(7, insecto.getDireccion());
            ps.setString(8, insecto.getCp());
            ps.setInt(9, idInsecto);
            res = ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Hubo un error en la modificacion " + e);
        } finally {
             closeConnections();
        }
        return res;
    }

    public boolean eliminarInsecto(int idInsecto) {
        boolean res = false;
        String query = "DELETE FROM participante WHERE idParticipante = ? ";
        openConnections(query);
        try {
            ps.setInt(1, idInsecto);
            res = ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println("Hubo un error al eliminar al insecto es posible que tenga un Ki muy alto " + e);
        } finally {
            closeConnections();
        }
        return res;
    }

    public List consultaAgenda() {
        List insectos = new ArrayList();
        String query = "SELECT Nombres, Apaterno, Amaterno FROM participante";
        openConnections(query);
        try{
            ResultSet rs = (ResultSet)ps.executeQuery();
            while(rs.next()){
                BeanAgenda unInsecto = new BeanAgenda();
                unInsecto.setNombres(rs.getString("Nombres"));
                unInsecto.setApaterno(rs.getString("Apaterno"));
                unInsecto.setAmaterno(rs.getString("Amaterno"));
                insectos.add(unInsecto);
            }
        } catch (Exception e){
            System.err.println("Hubo un error al consultar a los insectos su ki es tan bajo que no aparecen en el radar " + e);
        } finally {
            closeConnections();
        }
        System.out.println("---->>> insectos: " + insectos.size());
        return insectos;
    }
}
