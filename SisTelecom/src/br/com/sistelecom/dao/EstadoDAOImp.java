package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.ConnectionFactory;
import br.com.sistelecom.entity.Estado;
import br.com.sistelecom.interfaces.dao.EstadoDAO;

public class EstadoDAOImp implements EstadoDAO{
	
	private Connection conn;
	
	public EstadoDAOImp () throws Exception {
		
		try{
			this.conn = ConnectionFactory.getConnection();
		}
		catch(Exception e){
			throw new Exception("Erro: " + "\n" + e.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.sistelecom.dao.EstadoDAO#todosEstados()
	 */
	/* (non-Javadoc)
	 * @see br.com.sistelecom.dao.EstadoDAO#todosEstados()
	 */
	public List todosEstados() throws Exception {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try{
			conn = this.conn;
			ps = conn.prepareStatement("select * from estado");
			rs = ps.executeQuery();
			List<Estado> list = new ArrayList<Estado>();
			while(rs.next()){
				int idEstado = rs.getInt(1);
				String siglaUf = rs.getString(2);
				String nomeEstado = rs.getString(3);
				
				list.add(new Estado(idEstado, siglaUf, nomeEstado));
			}
			return list;
		}catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
	}

}
