package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Itens;

public class ItemDAOImpl implements ItemDAO{

	public List<Itens> listarTodos() {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from itens");
			rs = ps.executeQuery();
			List<Itens> list = new ArrayList<Itens>();
			while(rs.next()) {
				list.add(new Itens(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getString(9)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void salvar(Itens item) throws Exception {
	}

	public void excluir(Itens item) throws Exception {
		
		try{
			Connection conn = SistelecomSingleConnection.getConnection();

			String SQL = "delete from itens where iditens = ?";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, item.getIdItens());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public void atualizar(Itens item) throws Exception {	
		
		try{
			
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "UPDATE itens SET produto=?, situacao=?, numeroSa3=?, numeroSiebel=?, numeroSiebel=?, numeroOs=?, numeroOib2b=?, fidelidade=?, prazo=? where iditens = ?";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, item.getProduto());
			ps.setString(2, item.getSituacao());
			ps.setLong(3, item.getNumeroSA3());
			ps.setString(4, item.getNumeroSiebel());
			ps.setString(5, item.getNumeroOS());
			ps.setLong(6, item.getNumeroOIB2B());
			ps.setString(7, item.getFidelidade());
			ps.setString(8, item.getPrazo());
			ps.setInt(9, item.getIdItens());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public Itens obterPorId(int id) {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from itens where iditens = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o item com esse id: " + id);
			}

			Itens item = new Itens();
			item.setIdItens(id);
			item.setProduto(rs.getInt(2));
			item.setSituacao(rs.getString(3));
			item.setNumeroSA3(rs.getLong(4));
			item.setNumeroSiebel(rs.getString(5));
			item.setNumeroOS(rs.getString(6));
			item.setNumeroOIB2B(rs.getLong(7));
			item.setFidelidade(rs.getString(8));
			item.setPrazo(rs.getString(9));

			return item;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return null;
	}

	public int salvarItem(Itens item) throws Exception{
		try{
			
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO itens (produto, situacao, numeroSa3, numeroSiebel, numeroOs, numeroOib2b, fidelidade, prazo) values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, item.getProduto());
			ps.setString(2, item.getSituacao());
			ps.setLong(3, item.getNumeroSA3());
			ps.setString(4, item.getNumeroSiebel());
			ps.setString(5, item.getNumeroOS());
			ps.setLong(6, item.getNumeroOIB2B());
			ps.setString(7, item.getFidelidade());
			ps.setString(8, item.getPrazo());
			ps.executeUpdate();
			
		}	catch (Exception e){
			
			e.printStackTrace();
		}
		
		return item.getIdItens();
	}

	public int getId() {
		
		Connection conn = SistelecomSingleConnection.getConnection();
		
		String SQL = "select max(iditens) as id from itens";
       
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
