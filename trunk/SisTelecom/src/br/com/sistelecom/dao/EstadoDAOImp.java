package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Estado;
import br.com.sistelecom.interfaces.dao.EstadoDAO;

public class EstadoDAOImp implements EstadoDAO{

	public List todosEstados() {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;
		
		try{
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
		}catch (Exception e) {
			e.printStackTrace();
        }
		return null;
	}

}
