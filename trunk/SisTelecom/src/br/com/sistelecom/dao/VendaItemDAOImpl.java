package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.VendaItem;

public class VendaItemDAOImpl implements DAO<VendaItem>{

	public List<VendaItem> listarTodos() {
		return null;
	}

	public void salvar(VendaItem vendaItem) throws Exception {
		
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO venda_item (idvenda, iditem) values (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, vendaItem.getIdVenda());
			ps.setInt(2, vendaItem.getIdItem());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		} 
	}

	public void excluir(VendaItem entidade) throws Exception {
	}

	public void atualizar(VendaItem entidade) throws Exception {
	}

	public VendaItem obterPorId(int id) {
		return null;
	}

}
