package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Venda;

public class VendaDAOImpl implements DAO<Venda>{

	public List<Venda> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Venda venda) throws Exception {
		
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO reg_venda (cliente, funcionario, data_venda) values (?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, venda.getIdCliente());
			ps.setInt(2, venda.getIdFuncionario());
			ps.setDate(3, new java.sql.Date(venda.getDataVenda().getTime()));
			ps.executeUpdate();
			
			final ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				System.out.println(rs.getLong(1));
			}
			
			
		} catch (Exception e) {
			throw new Exception();
		} 
	}
	
	public Integer salvarVenda(Venda venda) throws Exception{
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO reg_venda (cliente, funcionario, data_venda) values (?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, venda.getIdCliente());
			ps.setInt(2, venda.getIdFuncionario());
			ps.setDate(3, new java.sql.Date(venda.getDataVenda().getTime()));
			ps.executeUpdate();
			
			final ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				return rs.getInt(1);
			}
			
			return RESULTADO_SEM_REGISTROS;
			
		} catch (Exception e) {
			return RESULTADO_SEM_REGISTROS;
		}
		
	} 

	public void excluir(Venda venda) throws Exception {
		
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "delete from reg_venda where idreg_venda = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, venda.getIdVenda());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public void atualizar(Venda entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Venda obterPorId(int id) {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from reg_venda where idreg_venda = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o pedido com esse id: " + id);
			}
			
			Venda venda = new Venda();
			venda.setIdVenda(id);
			venda.setIdCliente(rs.getInt(2));
			venda.setIdFuncionario(rs.getInt(3));
			venda.setDataVenda(rs.getDate(4));
			
			return venda;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

}
