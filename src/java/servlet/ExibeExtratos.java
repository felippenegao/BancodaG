/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ContaDao;
import dao.MovDAO;
import entidades.Movimentacao;
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
@WebServlet(name = "ExibeExtratos", urlPatterns = {"/ExibeExtratos"})
public class ExibeExtratos extends HttpServlet {

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
           String cmd = request.getParameter("cmd");
             
            //ArrayList<Conta> contas = new ArrayList<Conta>();
            
            HttpSession session = request.getSession();

            Usuario usuario_logado = (Usuario) session.getAttribute("usuarioLogado");

            if(usuario_logado == null){
                
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            
            else{

                int id = usuario_logado.getId();

                //UsuarioDao dao = new UsuarioDao();
                MovDAO movDao = new MovDAO();
                
                ArrayList<Movimentacao> movimentacoes = movDao.getMov(id);
                
                session.setAttribute("extratos", movimentacoes);
                
                request.getRequestDispatcher("extratos_cliente.jsp").forward(request, response);
                
           }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ExibeExtratos.class.getName()).log(Level.SEVERE, null, ex);
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
