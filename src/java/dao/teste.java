/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thalyta
 */
public class teste {
    
    public static void main(String[] args) {
//        try {
            
//            MovDAO dao = new MovDAO();
//            ArrayList<Movimentacao> contas = dao.getMov(24);
//            
//            Iterator<Movimentacao> it = contas.iterator();
//            
//            while (it.hasNext()) {                
//                System.out.println(it.next());
//            }
//            
//            UsuarioDao dao = new UsuarioDao();
//            ArrayList<Usuario> users = dao.getUsuarios(4);
//            
//            Iterator<Usuario> it = users.iterator();
//            
//            while (it.hasNext()) {                
//                System.out.println(it.next());
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
  
            ContaDao dao;
            try {
                dao = new ContaDao();
                int qtde = dao.getContasPeloSaldo("1", "9").size();
                System.out.println(qtde);
            } catch (SQLException ex) {
                Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
}
