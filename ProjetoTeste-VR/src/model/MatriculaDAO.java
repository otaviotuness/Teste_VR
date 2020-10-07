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
import javax.swing.JOptionPane;

/**
 *
 * @author Otavio
 */
public class MatriculaDAO {
   
    public void create(ClassMatricula c) throws SQLException{
        String sql;
        ResultSet result = null;
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null; 

        sql = "   select * "+
              "  from disciplina d, matricula m, curso c "+
              " where d.id = m.disciplina_id "+
              "   and c.id = m.curso_id "+
              "   and m.curso_id = ? "+
              "   and d.dia_semana = ? "+
              "   and (d.periodo = ? or d.periodo = 'Integral')";
        
        statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, c.getCurso_id());
        statement.setString(2, c.getDia_semana());
        statement.setString(3, c.getPeriodo());

        result = statement.executeQuery();

        if (result.next()){
            JOptionPane.showMessageDialog(null, "Conflito de periodo ou dia da semana");
            return;  
        }
    
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("insert into matricula (curso_id,disciplina_id)values(?,?)");
            statement.setInt(1, c.getCurso_id());
            statement.setInt(2, c.getDisciplina_id());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Matricula cadastrado com sucesso!");   
        } catch (SQLException ex) {
            throw new RuntimeException("Matricula não cadastrado, verifique as informações: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public void delete(ClassMatricula c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("delete from matricula where curso_id = ? and disciplina_id = ?");
            statement.setInt(1, c.getCurso_id());
            statement.setInt(2, c.getDisciplina_id());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Matricula excluida com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar excluir o matricula: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
     
}
