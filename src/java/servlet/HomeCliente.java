/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsuarioDao;
import entidades.Conta;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalyta
 */
public class HomeCliente extends HttpServlet {

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


            /* TODO output your page here. You may use following sample code. */
            //getsaldo(request, response);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeCliente</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/geral.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Página do Cliente " + ((Usuario) request.getSession().getAttribute("usuarioLogado")).getNome() + "</h1>");
            out.println("<div>"
                    + "<h1>Operações</h1>"
                    + "<ul id=\"menu\">"
                    + "<li class=\"menu_li\"><a href=\"TransferenciaPasso1\">Realizar transferencias</a></li>"
                    + "<li class=\"menu_li\"><a href=\"ExibeSaldo\">Consultar Saldo</a></li>"
                    + "<li class=\"menu_li\"><a href=\"ExibeExtratos\">Consultar Extratos</a></li>"
                    + "<li class=\"menu_li\"><a href=\"LogoutServlet\">Sair</a>"
                    + "</ul>"
                    + "</div>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    public void getsaldo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        try {
            UsuarioDao dao = new UsuarioDao();

            //Saber o saldo da conta de id igual a 1
            Conta conta = dao.consultarSaldo(1);

            out.print("Saldo: " + conta.getSaldo());


        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(HomeCliente.class.getName()).log(Level.SEVERE, null, ex);
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
