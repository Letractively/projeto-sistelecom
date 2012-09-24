/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Danilo Alves
 */
public class ConnectionFactory {

    public ConnectionFactory() {
    }
        
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/sistelecom";
            return DriverManager.getConnection(url, "root", "danilo");
        }
        catch (ClassNotFoundException e){
            throw new Exception (e.getMessage());
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public static void closeConnection (Connection conn, Statement stmt, ResultSet rs) throws Exception{
        close(conn, stmt, rs);
    }
    
    public static void closeConnection (Connection conn, Statement stmt) throws Exception{
        close(conn, stmt, null);
    }
    
    public static void closeConnection (Connection conn) throws Exception{
        close(conn, null, null);
    }
    
    private static void close (Connection conn, Statement stmt, ResultSet rs) throws Exception{
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}