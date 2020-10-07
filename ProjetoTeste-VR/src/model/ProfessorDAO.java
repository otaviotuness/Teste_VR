/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Otavio
 */
public class ProfessorDAO {
    public void create(ClassProfessor c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;

        try {
            statement =  (PreparedStatement) conexao.prepareStatement("insert into professor (nome,rg,cpf,titulo)values(?,?,?,?)");
            statement.setString(1, c.getNome());
            statement.setString(2, c.getRg());
            statement.setString(3, c.getCpf());
            statement.setString(4, c.getTitulo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");   
        } catch (SQLException ex) {
            throw new RuntimeException("Professor não cadastrado, verifique as informações: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public List<ClassProfessor> read() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassProfessor> professors = new ArrayList<>();
        
        try {
            statement = (PreparedStatement) conexao.prepareStatement("select * from professor");
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassProfessor professor = new ClassProfessor();
                
                professor.setNome(result.getString("NOME"));
                professor.setRg(result.getString("RG"));
                professor.setCpf(result.getString("CPF"));
                professor.setTitulo(result.getString("TITULO"));
                professor.setCodigo(Integer.parseInt(result.getString("ID")));
                
                professors.add(professor);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return professors;
    }
    
    public List<ClassProfessor> readMestre() throws SQLException{
        String sql;
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassProfessor> professors = new ArrayList<>();
        
        try {
            sql = "select * "
                 +  "from professor "
                 + "where (titulo = 'Mestre' or titulo = 'Doutor')";
            
            statement = (PreparedStatement) conexao.prepareStatement(sql);
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassProfessor professor = new ClassProfessor();
                
                professor.setNome(result.getString("NOME"));
                professor.setRg(result.getString("RG"));
                professor.setCpf(result.getString("CPF"));
                professor.setTitulo(result.getString("TITULO"));
                professor.setCodigo(Integer.parseInt(result.getString("ID")));
                
                professors.add(professor);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return professors;
    }
    
    public void update(ClassProfessor c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("update professor set nome = ?, rg = ?,cpf = ?, titulo = ? where id = ?");
            
            statement.setString(1, c.getNome());
            statement.setString(2, c.getRg());
            statement.setString(3, c.getCpf());
            statement.setString(4, c.getTitulo());
            statement.setDouble(5, c.getCodigo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Problemas ao alterar o cadastro: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public void delete(ClassProfessor c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("delete from professor where id = ?");
            statement.setInt(1, c.getCodigo());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "professor Excluido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar excluir o professor: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
}
