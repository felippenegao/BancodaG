/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalyta
 */
public class HomeGerenteGeral extends HttpServlet {

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
        try {
            Usuario usuario =(Usuario) request.getSession().getAttribute("usuarioLogado");
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Gerente Geral</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/geral.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Gerente Geral " + usuario.getNome() + "</h1>"
                    + "<ul id='menu'>"
                    + "<li class='menu_li'><a href='SelectAgencia?cmd=todas'>Listar agencias do banco</a></li>"
                    +"<li class='menu_li'><a href='SelectConta?cmd=todas'>Listar informaçoes sobre contas</a></li>"
                    +"<li class='menu_li'><a href='intervalo_saldo_gerente_geral.jsp'>Filtrar conta pelo saldo</a></li>"
                    +"<li class=\"menu_li\"><a href=\"LogoutServlet\">Sair</a>"
                    + "</ul>");
            out.println("</body>");
            out.println("</html>");
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