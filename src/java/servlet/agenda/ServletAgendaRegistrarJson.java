/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.agenda;

import bean.agenda.BeanAgenda;
import com.google.gson.Gson;
import dao.agenda.AgendaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
public class ServletAgendaRegistrarJson extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        BeanAgenda unInsecto = new BeanAgenda();
           AgendaDao dao = new AgendaDao();
        try {
           
           unInsecto.setNombres(request.getParameter("nom"));
           unInsecto.setApaterno(request.getParameter("ap"));
           unInsecto.setAmaterno(request.getParameter("am"));
           unInsecto.setCelular(request.getParameter("cel"));
           unInsecto.setTelefono(request.getParameter("tel"));
           unInsecto.setEdad(Integer.parseInt(request.getParameter("edad")));
           unInsecto.setDireccion(request.getParameter("dir"));
           unInsecto.setCp(request.getParameter("cp"));
//           dao.insertarInsecto(unInsecto);
           
           response.setContentType("application/json");
        response.getWriter().write(respuestaJson(dao.insertarInsecto(unInsecto)));
//           response.getWriter().write(respuestaJson(dao.modificarInsecto(unInsecto, 20)));
//           response.getWriter().write(respuestaJson(dao.eliminarInsecto(19)));
        } finally {            
//            out.close();
        }
        
        
    }

    public String respuestaJson(boolean registro){
            Gson json = new Gson();
            HashMap hm = new HashMap();
            hm.put("RegistroAgenda", registro);
            return json.toJson(hm);
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
