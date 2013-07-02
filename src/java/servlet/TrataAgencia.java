/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AgenciaDao;
import entidades.Agencia;
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
@WebServlet(name = "TrataAgencia", urlPatterns = {"/TrataAgencia"})
public class TrataAgencia extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrataAgencia</title>");            
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"recursos/css/geral.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrataAgencia at " + request.getContextPath() + "</h1>");
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
        
            Integer numero = Integer.parseInt(request.getParameter("numero"));
            String nome = request.getParameter("nome");
            String rua = request.getParameter("rua");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
            Agencia agencia = new Agencia(numero, nome, rua, bairro, cidade, estado);
            try{
            AgenciaDao agenciaDao = new AgenciaDao();
            agenciaDao.salvarAgencia(agencia);
       } catch (SQLException ex) {
           System.out.println("Erro : " + ex.getMessage());
       }
       request.setAttribute("mensagem", "Agencia cadastrada!");
       request.getRequestDispatcher("FormCadastrarAgenciaServlet").forward(request, response);
       
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    }

   
   

