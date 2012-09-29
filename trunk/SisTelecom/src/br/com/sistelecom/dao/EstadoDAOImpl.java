package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Estado;

public class EstadoDAOImpl implements DAO<Estado>{
	
	public void salvar(Estado estado) throws Exception {
	}
	
	public void atualizar(Estado estado) throws Exception{
	}
	
	public List<Estado> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from estado");
			rs = ps.executeQuery();
			List<Estado> list = new ArrayList<Estado>();
			while(rs.next()) {
				list.add(new Estado(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Estado obterPorId(int id){
		return null;
	}
	
	public void excluir(Estado estado) throws Exception {	
	}

}
