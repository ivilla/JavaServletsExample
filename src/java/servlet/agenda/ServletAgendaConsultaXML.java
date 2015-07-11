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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
public class ServletAgendaConsultaXML extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
            
//        } finally {            
//            out.close();
//        }
//        response.setContentType("application/xml");
//        response.setContentType("application/json");
        AgendaDao dao = new AgendaDao();
        response.getWriter().write(respuestaXML(dao.consultaAgenda()));
    }
//    public String respuestaXML(List<BeanAgenda> consulta){
//                StringBuffer respuestaXML = new StringBuffer();
//                respuestaXML.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
//                respuestaXML.append("<respuesta>");
//                for(BeanAgenda abc : consulta){
//                    respuestaXML.append("\n <ListaInsectos>");
//                    respuestaXML.append("<idInsecto>");
//                    respuestaXML.append(abc.getIdInsecto());
//                    respuestaXML.append("\n </idInsecto>");
//                    respuestaXML.append("<nombres>");
//                    respuestaXML.append(abc.getNombres());
//                    respuestaXML.append("\n </nombres>");
//                    respuestaXML.append("<apaterno>");
//                    respuestaXML.append(abc.getApaterno());
//                    respuestaXML.append("\n </apaterno>");
//                    respuestaXML.append("\n </ListaInsectos>");
//                }
//                respuestaXML.append("</respuesta>");
//                return respuestaXML.toString();
//            }
    
    public String respuestaXML(List<BeanAgenda> consulta){
            Gson gson = new Gson();
            return gson.toJson(consulta);
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
