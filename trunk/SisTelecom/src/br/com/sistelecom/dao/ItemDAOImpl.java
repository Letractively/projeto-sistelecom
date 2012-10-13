package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Itens;

public class ItemDAOImpl implements ItemDAO{

	public List<Itens> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Itens entidade) throws Exception {}

	public void excluir(Itens entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Itens entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Itens obterPorId(int id) {
		// TODO Auto-generated method stub
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

}
