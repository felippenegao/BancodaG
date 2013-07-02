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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thalyta
 */
@WebServlet(name = "TransferenciaPasso2", urlPatterns = {"/TransferenciaPasso2"})
public class TransferenciaPasso2 extends HttpServlet {

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

            HttpSession session = request.getSession();

            Usuario usuario_logado = (Usuario) session.getAttribute("usuarioLogado");

            int id = usuario_logado.getId();

            ContaDao contaDao = new ContaDao();
            
            String debitar = request.getParameter("conta_debitar");
            String creditar = request.getParameter("conta_creditar");
            String val = request.getParameter("valor");
            
               Conta contaDebitar = contaDao.getConta(Integer.parseInt(debitar));
               Conta contaCreditar = contaDao.getConta(Integer.parseInt(creditar));
               double valor = Double.parseDouble(val);
            

               if (valor <= contaDebitar.getSaldo()) {
                contaDebitar.setSaldo(contaDebitar.getSaldo() - valor);
                contaCreditar.setSaldo(contaCreditar.getSaldo() + valor);
                contaDao.updateConta(contaDebitar);
                contaDao.updateConta(contaCreditar);
                
                   System.out.println("saldo debitado - " + contaDebitar.getSaldo());
                   System.out.println("saldo creditado - " + contaCreditar.getSaldo());
                
                //Faz a insercao dos valores da movimentacao para registro no banco
                contaDao.updateMov(contaDebitar,usuario_logado, valor) ;
                
                request.setAttribute("conteudo", "Conta debitada: " + contaDebitar.toString());
                
                request.setAttribute("aviso", "Transferência realizada com sucesso!");
                request.setAttribute("cmd", "passo2");
                
            } else {
                request.setAttribute("cmd", "passo1");
                request.setAttribute("aviso", "Valor maior que o saldo da conta!");
            }
            
            
            
            
        } catch (SQLException ex) {
            request.setAttribute("aviso", ex.getMessage());
        } finally {
            request.getRequestDispatcher("transferencia.jsp").forward(request, response);
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
