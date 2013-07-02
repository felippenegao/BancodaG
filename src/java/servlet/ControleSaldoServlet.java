/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ContaDao;
import entidades.Conta;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ControleSaldoServlet", urlPatterns = {"/ControleSaldoServlet"})
public class ControleSaldoServlet extends HttpServlet {

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

            String saldo1 = request.getParameter("saldo1");
            String saldo2 = request.getParameter("saldo2");

            ContaDao dao = new ContaDao();

            Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
            if (usuarioLogado.getTipo() == 4) {
                ArrayList<Usuario> list = (ArrayList<Usuario>) dao.getClientesPeloSaldo(saldo1, saldo2);
                request.setAttribute("lista", list);
                request.getRequestDispatcher("detalhes_saldo_clientes_agencia.jsp").forward(request, response);
            } else if (usuarioLogado.getTipo() == 3) {
                ContaDao contaDao = new ContaDao();
                List<Conta> list = contaDao.getContasPeloSaldo(saldo1, saldo2);
                request.setAttribute("lista", list);
                request.getRequestDispatcher("detalhes_saldo_clientes_geral.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaldoServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
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
