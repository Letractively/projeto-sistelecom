/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.to.RamoTO;

/**
 *
 * @author Danilo Alves
 */
public class RamoDAOImpl implements DAO<Ramo> {

	public void salvar(Ramo ramo) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO ramo (nome_ramo) values (?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ramo.getNomeRamo());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		} 
	}
	
	public void atualizar(Ramo ramo) throws Exception{
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			String SQL = "UPDATE ramo SET nome_ramo=? where idramo = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ramo.getNomeRamo());
			ps.setInt(2, ramo.getIdRamo());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Ramo> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from ramo");
			rs = ps.executeQuery();
			List<Ramo> list = new ArrayList<Ramo>();
			while(rs.next()) {
				list.add(new Ramo(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RamoTO> todosRamosParaExibirEmTabela() {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from ramo");
			rs = ps.executeQuery();
			List<RamoTO> list = new ArrayList<RamoTO>();
			while(rs.next()) {
				Integer idRamo = rs.getInt(1);
				String nomeRamo = rs.getString(2);

				list.add(new RamoTO(Boolean.FALSE,idRamo, nomeRamo));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Ramo obterPorId(int id){

		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from ramo where idramo = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o ramo com esse id: " + id);
			}
			
			Ramo ramo = new Ramo();
			ramo.setIdRamo(id);
			ramo.setNomeRamo(rs.getString(2));
			
			return ramo;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public void excluir(Ramo ramo) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "delete from ramo where idramo = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, ramo.getIdRamo());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
}