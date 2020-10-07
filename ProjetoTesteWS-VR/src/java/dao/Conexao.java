/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/teste_vr","postgres","postgres");
        return conexao;
    }
    
    public static void closeConnection(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Não foi possível desconectar do banco de dados: ", ex);
            }
        } 
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Não foi possível desconectar do banco de dados: ", ex);
            }
        } 
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Não foi possível desconectar do banco de dados: ", ex);
            }
        } 
    }
}
