/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Danilo Alves
 */
public final class SistelecomSingleConnection {

	private static Connection connection;
	private static final String URL = "jdbc:mysql://localhost/sistelecom";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "danilo";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    private SistelecomSingleConnection() {}
        
    public static Connection getConnection(){
    	 return connection;
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