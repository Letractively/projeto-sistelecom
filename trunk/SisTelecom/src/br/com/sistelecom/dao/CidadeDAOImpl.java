package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Cidade;
import br.com.sistelecom.entity.Estado;

public class CidadeDAOImpl implements DAO<Cidade>{
	
	private Estado estado = new Estado();
	
	public void salvar(Cidade cidade) throws Exception {
	}
	
	public void atualizar(Cidade cidade) throws Exception{
	}
	
	public List<Cidade> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from cidade");
			rs = ps.executeQuery();
			List<Cidade> list = new ArrayList<Cidade>();
			while(rs.next()) {
				list.add(new Cidade(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Cidade> listarCidadesPorUf(int id){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select idcidade, nome_cidade from cidade inner join estado on estado.idestado = cidade.uf where estado.idestado = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<Cidade> list = new ArrayList<Cidade>();
			while(rs.next()) {
				final Cidade cidade = new Cidade();
				cidade.setUf(rs.getInt(1));
				cidade.setNomeCidade(rs.getString(2));
				list.add(cidade);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cidade obterPorId(int id){
		return null;
	}
	
	public void excluir(Cidade cidade) throws Exception {	
	}

}
