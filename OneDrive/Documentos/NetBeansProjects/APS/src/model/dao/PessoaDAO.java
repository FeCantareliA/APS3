package model.dao;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

public class PessoaDAO {
   
    public void create(Pessoa p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt=con.prepareStatement("INSERT INTO pessoa(nome,email,cargo,departamento,senha) VALUES (?,?,?,?,?);");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getCargo());
            stmt.setString(4, p.getDepartamento());
            stmt.setString(5, p.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public boolean logar (String email, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt=con.prepareStatement("SELECT * FROM pessoa WHERE email=? and senha=?;");
            stmt.setString(1, email);
            stmt.setString(2,senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check=true;
            }
            
            
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return check;
    }
    
    
    
    
    
}
