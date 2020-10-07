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
public class CursoDAO {
    
    public void create(ClassCurso c) throws SQLException{
        String sql;
        ResultSet result = null;
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        
        sql = "select 1 from curso "
             + "where professor = ?";  
        statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, c.getProfessor());

        result = statement.executeQuery();

        if (result.next()){
            JOptionPane.showMessageDialog(null, "Professor já vinculado a outra disciplina");
            return;  
        }

        try {
            statement =  (PreparedStatement) conexao.prepareStatement("insert into curso (descricao,duracao,periodo,qtd_aluno,carga_hr,professor)values(?,?,?,?,?,?)");
            statement.setString(1, c.getDescricao());
            statement.setDouble(2, c.getDuracao());
            statement.setString(3, c.getPeriodo());
            statement.setInt(4, c.getQtd_aluno());
            statement.setDouble(5, c.getCarga_hr());
            statement.setInt(6, c.getProfessor());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");   
        } catch (SQLException ex) {
            throw new RuntimeException("Curso não cadastrado, verifique as informações: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public List<ClassCurso> read() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassCurso> cursos = new ArrayList<>();
        
        try {
            statement = (PreparedStatement) conexao.prepareStatement("select * from curso");
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassCurso curso = new ClassCurso();
                
                curso.setDescricao(result.getString("DESCRICAO"));
                curso.setQtd_aluno(Integer.parseInt(result.getString("QTD_ALUNO")));
                curso.setCarga_hr(Double.parseDouble(result.getString("CARGA_HR")));
                curso.setPeriodo(result.getString("PERIODO"));
                curso.setDuracao(Double.parseDouble(result.getString("DURACAO")));
                curso.setCodigo(Integer.parseInt(result.getString("ID")));
                
                cursos.add(curso);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return cursos;
    }
    
    public void update(ClassCurso c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("update curso set descricao = ?, duracao = ?,periodo = ?, qtd_aluno = ?, carga_hr = ?, professor = ? where id = ?");
            
            statement.setString(1, c.getDescricao());
            statement.setDouble(2, c.getDuracao());
            statement.setString(3, c.getPeriodo());
            statement.setInt(4, c.getQtd_aluno());
            statement.setDouble(5, c.getCarga_hr());
            statement.setInt(6, c.getProfessor());
            
            statement.setInt(7, c.getCodigo());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Problemas ao alterar o cadastro: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public void delete(ClassCurso c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("delete from curso where id = ?");
            statement.setInt(1, c.getCodigo());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Curso Excluido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar excluir o curso: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
}
