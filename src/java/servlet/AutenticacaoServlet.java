/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsuarioDao;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thalyta
 */
public class AutenticacaoServlet extends HttpServlet {

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
        try {
            
            String login = request.getParameter("LOGIN");
            String senha = request.getParameter("SENHA");
            
            int tipoUsuarioSelecionado = Integer.parseInt(request.getParameter("tipo_usuario"));
            
            String msg = "";
            
            if (login.equals("") || senha.equals("")) {
                printPage(request, response, "Login ou senha Inválido!");
            } else {
                
                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = usuarioDao.autenticaUsuario(login, senha);
                
                if (usuario == null) {
                    printPage(request, response, "Login ou senha Inválido!");
                } else {
                    
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("usuarioLogado", usuario);
                    
                    if (usuario.getTipo() == tipoUsuarioSelecionado && tipoUsuarioSelecionado == 1) {
                        response.sendRedirect("HomeCliente");
                    } else if (usuario.getTipo() == tipoUsuarioSelecionado && tipoUsuarioSelecionado == 2) {
                        response.sendRedirect("HomeAdministrador");
                    } else if (usuario.getTipo() == tipoUsuarioSelecionado && tipoUsuarioSelecionado == 3) {
                        response.sendRedirect("HomeGerenteGeral");
                    } else if (usuario.getTipo() == tipoUsuarioSelecionado && tipoUsuarioSelecionado == 4) {
                        response.sendRedirect("HomeGerenteDeAgencia");
                    } else {
                        printPage(request, response, "Login ou senha Inválido!");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutenticacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printPage(HttpServletRequest request, HttpServletResponse response, String mensagem) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String text = "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/geral.css\" />\n"
                + "        <title>BANCO DA GENTE</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "\n"
                + "        <div id=\"principal\">\n"
                + "\n"
                + "            <h1>Banco da Gente</h1>\n"
                + "\n"
                + "<h3>" + mensagem + "</h3>"
                + "            <form method=\"Post\" action=\"AutenticacaoServlet\">\n"
                + "                <label>Logar como: </label>\n"
                + "\n"
                + "                <select name=\"tipo_usuario\">\n"
                + "                    <option value=\"1\" selected>Cliente</option>\n"
                + "                    <option value=\"2\" >Administrador</option>\n"
                + "                    <option value=\"3\" >Gerente Geral</option>\n"
                + "                    <option value=\"4\" >Gerente de Agencia</option>\n"
                + "                </select><br>\n"
                + "                \n"
                + "                <table id=\"table_index\">\n"
                + "                    <tr>\n"
                + "                        <td>\n"
                + "                            <label>Login: </label>\n"
                + "                        </td>\n"
                + "                        <td>\n"
                + "                            <input type=\"text\" name=\"LOGIN\"/>\n"
                + "                        </td>\n"
                + "                    </tr>\n"
                + "                    <tr>\n"
                + "                        <td>\n"
                + "                            <label>Senha: </label>\n"
                + "                        </td>\n"
                + "                        <td>\n"
                + "                            <input type=\"password\" name=\"SENHA\"/><br>\n"
                + "                        </td>\n"
                + "                    </tr>\n"
                + "                </table>\n"
                + "                <input type=\"submit\" name=\"enviar\" value=\"Enviar\"/>\n"
                + "\n"
                + "            </form><br>\n"
                + "            <a href = \"#\">Verificar as informações sobre as agências do banco</a><br>\n"
                + "            <a href = \"#\">Realizar simulações sobre financiamentos</a>\n"
                + "        </div>\n"
                + "\n"
                + "    </body>\n"
                + "</html>";
        writer.print(text);
        writer.close();
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
