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
public class AlunoDAO {
    public void create(ClassAluno c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;

        try {
            statement =  (PreparedStatement) conexao.prepareStatement("insert into aluno (matricula, nome, rg, cpf,curso)values(?,?,?,?,?)");
            statement.setString(1, c.getMatricula());
            statement.setString(2, c.getNome());
            statement.setString(3, c.getRg());
            statement.setString(4, c.getCpf());
            statement.setInt(5, c.getCurso());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");   
        } catch (SQLException ex) {
            throw new RuntimeException("Aluno não cadastrado, verifique as informações: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public List<ClassAluno> read() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassAluno> alunos = new ArrayList<>();
        
        try {
            statement = (PreparedStatement) conexao.prepareStatement("select * from aluno");
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassAluno aluno = new ClassAluno();
                
                aluno.setNome(result.getString("NOME"));
                aluno.setMatricula(result.getString("MATRICULA"));
                aluno.setCpf(result.getString("CPF"));
                aluno.setRg(result.getString("RG"));
                aluno.setCodigo(Integer.parseInt(result.getString("ID")));
                
                alunos.add(aluno);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return alunos;
    }
    
    public void update(ClassAluno c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("update aluno set matricula = ?, nome = ?,cpf = ?, rg = ?, curso = ? where id = ?");
            
            statement.setString(1, c.getMatricula());
            statement.setString(2, c.getNome());
            statement.setString(3, c.getCpf());
            statement.setString(4, c.getRg());
            statement.setInt(5, c.getCurso());
            
            statement.setInt(6, c.getCodigo());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Problemas ao alterar o cadastro: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public void delete(ClassAluno c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("delete from aluno where id = ?");
            statement.setInt(1, c.getCodigo());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Aluno Excluido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar excluir o aluno: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
}
