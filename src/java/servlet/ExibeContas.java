/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ContaDao;
import entidades.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalyta
 */
@WebServlet(name = "ExibeContas", urlPatterns = {"/ExibeContas"})
public class ExibeContas extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            ArrayList<Conta> contas = new ArrayList<Conta>();
            
            ContaDao dao = new ContaDao();
            
            contas = dao.getContas();
            
            Iterator<Conta> it = contas.iterator();
            
            String msn = (String) request.getAttribute("msn");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExibeContas</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/geral.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Contas</h2>");
            out.print("<ul>");
            out.print("<h3>"+(msn != null?msn:"")+"</h3>");
            while (it.hasNext()) {    
               Conta user = it.next(); 
                out.print("<li>"+user+"</li> <a href='ExcluirConta?cmd="+user.getId()+"'>Excluir</a>");
                out.println();
            }
            out.print("</ul>");
            out.println("<br><a href=\"HomeAdministrador\">Home</a><br>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
            Logger.getLogger(ExibeContas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
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
