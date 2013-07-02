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
import java.util.List;
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
@WebServlet(name = "ControleAgenciaServlet", urlPatterns = {"/ControleAgenciaServlet"})
public class ControleAgenciaServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();



        String cmd = request.getParameter("cmd");

        if (cmd == null) {
            request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
        } else if (cmd.equals("listUsers")) {

            try {
                String numeroAgencia = request.getParameter("agencia");
                UsuarioDao usuarioDao = new UsuarioDao();
                List<Usuario> listaUsuarios = usuarioDao.getClientesAgencia(numeroAgencia);
                if (!listaUsuarios.isEmpty()) {
                    request.setAttribute("listaDeUsuarios", listaUsuarios);
                    request.setAttribute("numeroAgencia", numeroAgencia);
                } else {
                    request.setAttribute("mensagem", "Nenhum resultado foi retornado!");
                }
                request.getRequestDispatcher("exibe_clientes.jsp").forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ControleAgenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (cmd.equals("detail_clientes_agencia")) {

            String id = request.getParameter("id");
            if (id != null) {

                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = usuarioDao.getClientePorId(id);

                if (usuario != null) {
                    request.setAttribute("usuarioLocalizadoPeloGerenteDeAgenciaPeloSaldo", usuario);
                    request.getRequestDispatcher("detalhes_clientes.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("msg", "Dados Inexistentes");
            }

            request.getRequestDispatcher("localizarUsuario.jsp").forward(request, response);
        } else if (cmd.equals("detail_clientes_geral")) {

            String id = request.getParameter("id");
            if (id != null) {

                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = usuarioDao.getClientePorId(id);

                if (usuario != null) {
                    request.setAttribute("usuarioLocalizadoPeloGerenteGeralPeloSaldo", usuario);
                    request.getRequestDispatcher("detalhes_clientes.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("msg", "Dados Inexistentes");
            }

            request.getRequestDispatcher("localizarUsuario.jsp").forward(request, response);
        } else if (cmd.equals("localizar")) {
            request.getRequestDispatcher("localizarUsuario.jsp").forward(request, response);
        } else if (cmd.equals("filtrar")) {
            request.getRequestDispatcher("filtraSaldoUsuario.jsp").forward(request, response);
        } else if (cmd.equals("sair")) {
            request.getRequestDispatcher("logoutServlet").forward(request, response);
        } else if (cmd.equalsIgnoreCase("listUsers")) {
            //Buscar lista de usuarios no banco;
            //setar lista de usuarios na sessão;
            //redirecionar para a pagina jsp que vai exibir os dados;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControleAgenciaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
