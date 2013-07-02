/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import entidades.Conta;
import entidades.Telefones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidades.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thalyta
 */
public class UsuarioDao {

    Connection conexao;
    PreparedStatement statement = null;

    public UsuarioDao() throws SQLException {
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

    public boolean salvarUsuario(Usuario usuario) throws SQLException {
        try {
            String sql = "INSERT INTO Usuario(login, senha, cpf, nome, rg, rua, bairro, cidade, estado, cep, email, datanasc, tipo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = this.conexao.prepareStatement(sql);
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getCpf());
            statement.setString(4, usuario.getNome());
            statement.setString(5, usuario.getRg());
            statement.setString(6, usuario.getRua());
            statement.setString(7, usuario.getBairro());
            statement.setString(8, usuario.getCidade());
            statement.setString(9, usuario.getEstado());
            statement.setString(10, usuario.getCep());
            statement.setString(11, usuario.getEmail());
            statement.setString(12, usuario.getDatanasc());
            statement.setInt(13, usuario.getTipo());

            int resultado = statement.executeUpdate();
            if (resultado == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Erro " + ex.getMessage());
            return false;
        } finally {
            statement.close();
            conexao.close();
        }
    }

    public boolean salvarTelefone(Telefones telefone, Usuario usuario) throws SQLException {

        String sql = "INSERT INTO Telefones values(?, ?, ?)";
        statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, telefone.getId());
        statement.setString(2, telefone.getTelefone());
        statement.setInt(3, telefone.getId_usuario());


        int resultado = this.statement.executeUpdate();
        if (resultado == 1) {
            return true;
        }
        return false;
    }

    public ArrayList<Usuario> getUsuariosClientes() {
        ArrayList<Usuario> clientes = null;
        try {
            String sql = "select * from usuario where tipo=1";
            clientes = new ArrayList<Usuario>();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                clientes.add(new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("rg"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
                        rs.getString("email"), rs.getString("datanasc"), rs.getInt("tipo"), null));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return clientes;
    }

    public ArrayList<Usuario> getClientesAgencia(String numeroAgencia) {
        ArrayList<Usuario> clientes = null;
        try {
            String sql = "select u.id, u.login,u.senha,u.cpf,u.nome,u.rg,u.rua,u.bairro,u.cidade,u.estado,"
                    + " u.datanasc,u.cep,u.email,u.tipo from usuario u join conta c on u.id=c.id_usuario "
                    + " join agencia a on c.id_agencia=a.id and tipo=1 and a.numero=" + numeroAgencia;
            clientes = new ArrayList<Usuario>();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                clientes.add(new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("rg"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
                        rs.getString("email"), rs.getString("datanasc"), rs.getInt("tipo"), null));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return clientes;
    }

    public Usuario getClientePeloCpf(String cpf) {
        Usuario cliente = null;
        try {
            String sql = "select * from usuario where tipo=1 and cpf=?";
            cliente = new Usuario();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cliente = new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("rg"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
                        rs.getString("email"), rs.getString("datanasc"), rs.getInt("tipo"), null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = null;
        try {
            String sql = "select * from usuario";
            usuarios = new ArrayList<Usuario>();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("rg"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
                        rs.getString("email"), rs.getString("datanasc"), rs.getInt("tipo"), null));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }

    public ArrayList<Usuario> getUsuarios(int id_agencia) {
        ArrayList<Usuario> usuarios = null;
        try {
            String sql = "select * from conta c , usuario u where id_agencia = ? and u.id = c.id_usuario";
            usuarios = new ArrayList<Usuario>();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            statement.setInt(1, id_agencia);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("rg"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
                        rs.getString("email"), rs.getString("datanasc"), rs.getInt("tipo"), null));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usuarios;
    }

    public Usuario autenticaUsuario(String login, String senha) {
        String sql = "select * from usuario where login=? and senha=?";
        Usuario usuario = null;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setTipo(resultSet.getInt("tipo"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro : " + ex);
        }
        return usuario;
    }

    public boolean remove(int id) {
        String sql = "delete from usuario where \"id\"= ?";
        Connection connection = null;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            if (result == 1) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro : " + ex);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Conta consultarSaldo(int id) {
        Conta conta = null;
        try {
            String sql = "select * from conta  where id = ?;";
            Connection con = ConnectionFactory.getInstance().getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                conta = new Conta(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getInt("id_usuario"), rs.getInt("id_agencia"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conta;
    }

    public Usuario getClientePorId(String id) {
        Usuario u = null;
        int n = Integer.parseInt(id);
        try {
            String sql = "select * from usuario where tipo=1 and id=" + n;
            Connection con = ConnectionFactory.getInstance().getConnection();
            statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                u = new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getString("rg"), rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"),
                        rs.getString("email"), rs.getString("datanasc"), rs.getInt("tipo"), null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
//    public ArrayList<Conta> getContasUsuario(int id) throws SQLException{
//        ArrayList<Conta> contas = new ArrayList<Conta>();
//        
//        String sql = "select c.numero, c.saldo from conta c, usuario u where u.id = ? and u.id = c.id_usuario";
//        
//        statement = conexao.prepareStatement(sql);
//        statement.setInt(1, id);
//        
//        ResultSet rs = statement.executeQuery();
//        
//        while (rs.next()) {       
//            
//            Conta c = new Conta();
//            
//            c.setNumero(rs.getString("numero"));
//            c.setSaldo(rs.getDouble("saldo"));
//            
//            contas.add(c);
//        }
//        
//        return contas;
//        
//    }
}
