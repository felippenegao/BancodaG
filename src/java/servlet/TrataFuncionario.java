/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsuarioDao;
import entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalyta
 */
public class TrataFuncionario extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        Integer id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String rua = request.getParameter("rua");
        
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        
        
        String dataNasc = request.getParameter("data_nascimento");
        
        int tipoUsuario = Integer.parseInt(request.getParameter("tipo_usuario"));
        
        Usuario usuario = new Usuario(login, senha, cpf, nome, rg, rua, bairro, cidade, estado, cep, email, dataNasc, tipoUsuario, null);
       try{
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.salvarUsuario(usuario);
       } catch (SQLException ex) {
           System.out.println("Erro : " + ex.getMessage());
       }
       request.setAttribute("mensagem", "Usuário cadastrado!");
       request.getRequestDispatcher("FormCadastrarFuncionarioServlet").forward(request, response);
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
