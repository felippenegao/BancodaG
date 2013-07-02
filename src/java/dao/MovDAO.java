/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import entidades.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Thalyta
 */
public class MovDAO {
     Connection conexao;
    PreparedStatement statement = null;

    public MovDAO() throws SQLException {
         this.conexao = ConnectionFactory.getInstance().getConnection();
    }
    
    
    
    public ArrayList<Movimentacao> getMov(int id_user) throws SQLException{
        
        String sql = "Select * from movimentacao where id_usuario = ?";
        statement = this.conexao.prepareStatement(sql);
        statement.setInt(1, id_user);
        
        ArrayList<Movimentacao> lista = new ArrayList<Movimentacao>();
       
        ResultSet rs = statement.executeQuery();
        Movimentacao mov = null;
        
        while (rs.next()) {      
            
            mov = new Movimentacao();
            mov.setConta(null);
            mov.setId(rs.getInt("id"));
            mov.setTitular(rs.getString("titular"));
            mov.setData(rs.getDate("data_operacao"));
            mov.setTipoMovimentacao(rs.getString("tipo"));
            mov.setValor(rs.getDouble("valor"));
                
            lista.add(mov);  
        }
        
        return lista;
        
   }

    
}