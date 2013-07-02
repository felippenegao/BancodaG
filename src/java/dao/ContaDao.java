/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import entidades.Conta;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thalyta
 */
public class ContaDao {

    Connection conexao;
    PreparedStatement statement = null;

    public ContaDao() throws SQLException {
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

    public boolean salvarConta(Conta conta) throws SQLException {
        try {
            String sql = "INSERT INTO conta(numero, saldo, id_usuario, id_agencia) values(?, ?, ?, ?)";
            statement = this.conexao.prepareStatement(sql);
            statement.setInt(1, conta.getNumero());
            statement.setDouble(2, conta.getSaldo());
            statement.setInt(3, conta.getId_usuario());
            statement.setInt(4, conta.getId_agencia());
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

    public Conta getConta(int numero) {
        Conta conta = null;
        try {
            String sql = "select * from conta where numero = ?";
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            statement.setInt(1, numero);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                conta = new Conta(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getInt("id_usuario"), rs.getInt("id_agencia"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

        return conta;
    }
    
    public boolean updateConta(Conta conta) throws SQLException {
        try {
            String sql = "UPDATE conta SET numero = ?, saldo = ?, id_usuario = ?, id_agencia = ? where id = ?";
            
            this.conexao = ConnectionFactory.getInstance().getConnection();
            statement = this.conexao.prepareStatement(sql);
            statement.setInt(1, conta.getNumero());
            statement.setDouble(2, conta.getSaldo());
            statement.setInt(3, conta.getId_usuario());
            statement.setInt(4, conta.getId_agencia());
            statement.setInt(5, conta.getId());
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
    
    public void  updateMov(Conta c,Usuario user, Double value) throws SQLException{
        String sql = "insert into movimentacao(data_operacao,hora,conta,titular,tipo,valor,id_usuario) values (?,?,?,?,?,?,?)";
    
        this.conexao = ConnectionFactory.getInstance().getConnection();
        statement = this.conexao.prepareStatement(sql);
        java.util.Date data = new java.util.Date();
        statement.setDate(1,new Date(data.getTime()));
        statement.setTimestamp(2, new Timestamp(data.getTime()));
        statement.setInt(3, c.getId());
        statement.setString(4,user.getNome());
        statement.setString(5, "Transferencia");
        statement.setDouble(6, value);
        statement.setInt(7, c.getId_usuario());
        
        statement.executeUpdate();
        
    }
    
    public boolean remove(int id) {
        String sql = "delete from conta where \"id\"= ?";
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

    public ArrayList<Conta> getContas() {
        ArrayList<Conta> contas = null;
        try {
            String sql = "select * from conta";
            contas = new ArrayList<Conta>();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                contas.add(new Conta(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getInt("id_usuario"), rs.getInt("id_agencia")));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

        return contas;

    }

    public ArrayList<Conta> getContas(int id_usuario) {
        ArrayList<Conta> contas = null;
        try {
            String sql = "select * from conta where id_usuario = ?";

            contas = new ArrayList<Conta>();

            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);

            statement.setInt(1, id_usuario);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                contas.add(new Conta(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getInt("id_usuario"), rs.getInt("id_agencia")));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

        return contas;

    }
    
    
    public List<Usuario> getClientesPeloSaldo(String valorInicial, String valorFinal ) {
        List<Usuario> clientes = new ArrayList<Usuario>();
        try {
            String sql = "select u.id, u.login,u.senha,u.cpf,u.nome,u.rg,u.rua,u.bairro,u.cidade,u.estado, "
                    + " u.datanasc,u.cep,u.email,u.tipo  from conta c join usuario u on u.id=c.id_usuario "
                    + " and u.tipo=1 and saldo between "+ valorInicial +" and "+ valorFinal;
                       
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
    
    
    public List<Conta> getContasPeloSaldo(String valorInicial, String valorFinal ) {
        List<Conta> contas = new ArrayList<Conta>();
        try {
            String sql = "select * from conta where saldo between "+valorInicial+" and "+valorFinal;
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                contas.add(new Conta(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getInt("id_usuario"),rs.getInt("id_agencia")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contas;
    }

    public Conta getContaPeloId(String id) {
        Conta conta = null;
        try {
            String sql = "select * from conta where id="+id;
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                conta = new Conta(rs.getInt("id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getInt("id_usuario"),rs.getInt("id_agencia"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conta;
    }
    
}
