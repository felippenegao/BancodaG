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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalyta
 */
@WebServlet(name = "TrataConta", urlPatterns = {"/TrataConta"})
public class TrataConta extends HttpServlet {

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
        Integer numero = Integer.parseInt(request.getParameter("numero"));
        Double saldo = Double.parseDouble(request.getParameter("saldo"));
        Integer id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        Integer id_agencia = Integer.parseInt(request.getParameter("id_agencia"));


        Conta conta = new Conta(numero, saldo, id_usuario, id_agencia);
        try {
            ContaDao contaDao = new ContaDao();
            contaDao.salvarConta(conta);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro : " + ex.getMessage());
        }
        request.setAttribute("mensagem", "Conta cadastrada!");
        request.getRequestDispatcher("FormCadastrarContaServlet").forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
}
