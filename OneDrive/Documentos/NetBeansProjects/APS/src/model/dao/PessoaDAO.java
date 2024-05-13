/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
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
    
    
    
    
    
    
}
