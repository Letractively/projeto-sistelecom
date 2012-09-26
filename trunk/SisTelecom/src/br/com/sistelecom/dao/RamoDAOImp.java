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

import br.com.sistelecom.connection.ConnectionFactory;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.interfaces.dao.RamoDAO;
import br.com.sistelecom.to.RamoTO;

/**
 *
 * @author Danilo Alves
 */
public class RamoDAOImp implements RamoDAO {

	private Connection conn;

	public RamoDAOImp (){

		try{
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que cria os tios de ramos que o cliente pode ter
	 * @param ramo
	 * @throws Exception 
	 */
	//@Override
	public void salvar(Ramo ramo) throws Exception {

		PreparedStatement ps = null;
		Connection conn = null;

		if(ramo==null) {
			throw new Exception("O valor passado não pode ser nulo");
		}

		try{

			String SQL = "INSERT INTO ramo (nome_ramo, status) values (?, ?)";

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, ramo.getNomeRamo());
			ps.setBoolean(2, ramo.getStatus());
			ps.executeUpdate();
		} catch (Exception sqle) {
			throw new Exception("Erro ao inserir o ramo: " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	/**
	 * Método que atualiza um ramo
	 * @param ramo
	 * @throws Exception 
	 */
	//@Override
	public void atualizar(Ramo ramo) throws Exception {

		PreparedStatement ps = null;
		Connection conn = null;

		if(ramo==null) {
			throw new Exception("O valor passado não pode ser nulo");
		}

		try{

			String SQL = "UPDATE ramo SET nome_ramo=?, status=? " +
					"where idramo = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, ramo.getNomeRamo());
			ps.setBoolean(2, ramo.getStatus());
			ps.setInt(3, ramo.getIdRamo());

			ps.executeUpdate();
		} catch (Exception sqle) {
			throw new Exception("Erro ao atualizar ramo: " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	/**
	 * Método que lista todos os ramos
	 * @return
	 * @throws Exception 
	 */
	//@Override
	public List todosRamos() throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try{
			conn = this.conn;
			ps = conn.prepareStatement("select * from ramo");
			rs = ps.executeQuery();
			List<Ramo> list = new ArrayList<Ramo>();
			while(rs.next()) {
				Integer idRamo = rs.getInt(1);
				String nomeRamo = rs.getString(2);
				Boolean status = rs.getBoolean(3);

				list.add(new Ramo(idRamo, nomeRamo, status));
			}
			return list;
		} catch (Exception sqle) {
			throw new Exception (sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	public List todosRamosParaExibirEmTabela() throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try{
			conn = this.conn;
			ps = conn.prepareStatement("select * from ramo");
			rs = ps.executeQuery();
			List<RamoTO> list = new ArrayList<RamoTO>();
			while(rs.next()) {
				Integer idRamo = rs.getInt(1);
				String nomeRamo = rs.getString(2);

				list.add(new RamoTO(Boolean.FALSE,idRamo, nomeRamo));
			}
			return list;
		} catch (Exception sqle) {
			throw new Exception (sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	/**
	 * Método que busca um ramo a partir de um id
	 * @param idRamo
	 * @return
	 * @throws Exception 
	 */
	//@Override
	public Ramo procurarIdRamo(Integer idRamo) throws Exception {

		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = this.conn;
			ps = conn.prepareStatement("select * from ramo where idramo = ?");
			ps.setInt(1, idRamo);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o ramo com esse id: " + idRamo);
			}

			String nomeRamo = rs.getString(2);
			Boolean status = rs.getBoolean(3);

			return new Ramo(idRamo, nomeRamo, status);
		} catch (Exception sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	/**
	 * Método que deleta um ramo
	 * @param ramo
	 * @throws Exception 
	 */
	//@Override
	public void excluir(Ramo ramo) throws Exception {

		PreparedStatement ps = null;
		Connection conn = null;

		if(ramo==null) {
			throw new Exception("O valor passado não pode ser nulo");
		}

		try{

			String SQL = "UPDATE ramo status=0 where idramo = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setBoolean(1, ramo.getStatus());
			ps.setInt(2, ramo.getIdRamo());

			ps.executeUpdate();
		} catch (Exception sqle) {
			throw new Exception("Erro ao atualizar ramo: " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}