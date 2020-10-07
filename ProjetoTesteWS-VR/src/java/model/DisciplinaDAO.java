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
public class DisciplinaDAO {
    
    public void create(ClassDisciplina c) throws SQLException{
        String sql;
        ResultSet result = null;
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;      
       
        sql = "select 1 from disciplina"
                + " where professor = ?"
                + "   and (periodo = ? or periodo = 'Integral')"
                + "   and dia_semana = ?";  
        statement = (PreparedStatement) conexao.prepareStatement(sql);
        statement.setInt(1, c.getProfessor());
        statement.setString(2, c.getPeriodo());
        statement.setString(3, c.getDia_semana());

        result = statement.executeQuery();

        if (result.next()){
            JOptionPane.showMessageDialog(null, "Professor já vinculado a outra disciplina, conflito de dia ou periodo");
            return;  
        }
    
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("insert into disciplina (descricao,ementa,limite_vaga,professor,"
                    + "dia_semana,carga_hr,periodo)values(?,?,?,?,?,?,?)");
            statement.setString(1, c.getDescricao());
            statement.setString(2, c.getEmenta());
            statement.setInt(3, c.getLimite_vaga());
            statement.setInt(4, c.getProfessor());
            statement.setString(5, c.getDia_semana());
            statement.setDouble(6, c.getCarga_hr());
            statement.setString(7, c.getPeriodo());
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Diciplina cadastrado com sucesso!");   
        } catch (SQLException ex) {
            throw new RuntimeException("Diciplina não cadastrado, verifique as informações: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public List<ClassDisciplina> read() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassDisciplina> diciplinas = new ArrayList<>();
        
        try {
            statement = (PreparedStatement) conexao.prepareStatement("select * from disciplina");
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassDisciplina diciplina = new ClassDisciplina();
                
                diciplina.setDescricao(result.getString("DESCRICAO"));
                diciplina.setEmenta(result.getString("EMENTA"));
                diciplina.setLimite_vaga(Integer.parseInt(result.getString("LIMITE_VAGA")));
                diciplina.setProfessor(Integer.parseInt(result.getString("PROFESSOR")));
                diciplina.setDia_semana(result.getString("DIA_SEMANA"));
                diciplina.setCarga_hr(Double.parseDouble(result.getString("CARGA_HR")));
                diciplina.setPeriodo(result.getString("PERIODO"));
                diciplina.setCodigo(Integer.parseInt(result.getString("ID")));
                
                diciplinas.add(diciplina);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return diciplinas;
    }
    
    public List<ClassDisciplina> readTabNotLinked(int idCurso) throws SQLException{
        String sql;
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassDisciplina> diciplinas = new ArrayList<>();
        
        try {
            sql = "select *" +
                  "  from disciplina d" +
                  " where id not in (select d.id" +
                  "                    from disciplina d, curso c, matricula m" +
                  "                   where d.id = m.disciplina_id" +
                  "                     and m.curso_id = ?)";
            statement = (PreparedStatement) conexao.prepareStatement(sql);
            statement.setInt(1, idCurso);
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassDisciplina diciplina = new ClassDisciplina();
                
                diciplina.setDescricao(result.getString("DESCRICAO"));
                diciplina.setLimite_vaga(Integer.parseInt(result.getString("LIMITE_VAGA")));
                diciplina.setDia_semana(result.getString("DIA_SEMANA"));
                diciplina.setCarga_hr(Double.parseDouble(result.getString("CARGA_HR")));
                diciplina.setPeriodo(result.getString("PERIODO"));
                diciplina.setCodigo(Integer.parseInt(result.getString("ID")));
                
                diciplinas.add(diciplina);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return diciplinas;
    }
    
    
    public List<ClassDisciplina> readTabLinked(int idCurso) throws SQLException{
        String sql;
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<ClassDisciplina> diciplinas = new ArrayList<>();
        
        try {
            sql = "select d.id, d.descricao, d.carga_hr, d.limite_vaga, d.dia_semana, d.periodo" +
                  "  from disciplina d, curso c, matricula m " +
                  " where d.id = m.disciplina_id " +
                  "   and m.curso_id = ?";
            statement = (PreparedStatement) conexao.prepareStatement(sql);
            statement.setInt(1, idCurso);
            result = statement.executeQuery();
            
            while (result.next()) {
                
                ClassDisciplina diciplina = new ClassDisciplina();
                
                diciplina.setDescricao(result.getString("DESCRICAO"));
                diciplina.setLimite_vaga(Integer.parseInt(result.getString("LIMITE_VAGA")));
                diciplina.setDia_semana(result.getString("DIA_SEMANA"));
                diciplina.setCarga_hr(Double.parseDouble(result.getString("CARGA_HR")));
                diciplina.setPeriodo(result.getString("PERIODO"));
                diciplina.setCodigo(Integer.parseInt(result.getString("ID")));
                
                diciplinas.add(diciplina);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
        
        return diciplinas;
    }
    
    public void update(ClassDisciplina c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("update disciplina set descricao = ?, ementa = ?,limite_vaga = ?, professor = ?,"
                    + "dia_semana = ?, carga_hr = ?, periodo = ? where id = ?");
            
            statement.setString(1, c.getDescricao());
            statement.setString(2, c.getEmenta());
            statement.setInt(3, c.getLimite_vaga());
            statement.setInt(4, c.getProfessor());
            statement.setString(5, c.getDia_semana());
            statement.setDouble(6, c.getCarga_hr());
            statement.setString(7, c.getPeriodo());
            
            statement.setInt(8, c.getCodigo());
            
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Problemas ao alterar o cadastro: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
    
    public void delete(ClassDisciplina c) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        try {
            statement =  (PreparedStatement) conexao.prepareStatement("delete from disciplina where id = ?");
            statement.setInt(1, c.getCodigo());
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Disciplina Excluido com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar excluir o diciplina: ", ex);
        }finally{
            Conexao.closeConnection(conexao, statement);
        }
    }
}
