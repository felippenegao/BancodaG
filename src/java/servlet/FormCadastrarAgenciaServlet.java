/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalyta
 */
@WebServlet(name = "FormCadastrarAgenciaServlet", urlPatterns = {"/FormCadastrarAgenciaServlet"})
public class FormCadastrarAgenciaServlet extends HttpServlet {

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
        PrintWriter writer = response.getWriter();
        String mensagem = "";
        if (request.getAttribute("mensagem") != null) {
            mensagem = (String) request.getAttribute("mensagem");
        }
        
       try {
            writer.print("<html><head>");
            writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/geral.css\" />");
            writer.print("<title>Cadastrar agencia</title></head><body>");
            writer.print("<h2>Cadastrar Agencia</h2>");
            writer.print("<table><form action=\"TrataAgencia\" method=\"Post\">");
            writer.print("<tr><td>Numero</td><td><input type=\"text\" name=\"numero\"/></td></tr>");
            writer.print("<tr><td>Nome</td><td><input type=\"text\" name=\"nome\"/></td></tr>");
            writer.print("<tr><td>Rua</td><td><input type=\"text\" name=\"rua\"/></td></tr>");
            writer.print("<tr><td>Bairro</td><td><input type=\"text\" name=\"bairro\"/></td></tr>");
            writer.print("<tr><td>Cidade</td><td><input type=\"text\" name=\"cidade\"/></td></tr>");
            writer.print("<tr><td>Estado</td><td><input type=\"text\" name=\"estado\"/></td></tr>");
            writer.print("<tr><td><input type=\"submit\" value=\"Salvar\"></td><td>" + mensagem +"</td></tr></table></form>");
            writer.println("<a href=\"HomeAdministrador\">Home</a><br>");
            writer.print("</body></html>");
        } finally {
            writer.close();
        }}

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
