/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import entidades.Agencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thalyta
 */
public class AgenciaDao {

    Connection conexao;
    PreparedStatement statement = null;

    public AgenciaDao() throws SQLException {
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

    public boolean salvarAgencia(Agencia agencia) throws SQLException {
        try {

            String sql = "INSERT INTO agencia(numero, nome, rua, bairro, cidade, estado) values ( ?, ?, ?, ?, ?, ?)";

            statement = this.conexao.prepareStatement(sql);

            statement.setInt(1, agencia.getNumero());
            statement.setString(2, agencia.getNome());
            statement.setString(3, agencia.getRua());
            statement.setString(4, agencia.getBairro());
            statement.setString(5, agencia.getCidade());
            statement.setString(6, agencia.getEstado());

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

    public boolean remove(int id) {
        String sql = "delete from agencia where \"id\"= ?";
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

    public Agencia getAgencia(Integer numero) throws SQLException {
        String sql = "select * from agencia where numero = ?";
        Connection connection = null;

        Agencia agencia = new Agencia();
        connection = ConnectionFactory.getInstance().getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, numero);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
                agencia = new Agencia(rs.getInt("id"), rs.getInt("numero"), rs.getString("nome"), rs.getString("rua"), rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("estado"));
            }
        return agencia;
    }

    public ArrayList<Agencia> getAgencias() {
        ArrayList<Agencia> agencias = null;
        try {
            String sql = "select * from agencia";
            agencias = new ArrayList<Agencia>();
            statement = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                agencias.add(new Agencia(rs.getInt("id"), rs.getInt("numero"), rs.getString("nome"), rs.getString("rua"), rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("estado")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

        return agencias;

    }
}
