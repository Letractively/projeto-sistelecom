package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entidade.relatorio.DepartamentoRelatorio;
import br.com.sistelecom.entity.Departamento;

public class DepartamentoDAOImpl implements DAO<Departamento>{
	
	public void salvar(Departamento departamento) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO departamento (nome_departamento, gerente_departamento) values (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, departamento.getNomeDepartamento());
			ps.setString(2, departamento.getGerenteDepartamento());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		} 
	}
	
	public void atualizar(Departamento departamento) throws Exception{
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			String SQL = "UPDATE departamento SET nome_departamento=?, gerente_departamento=? where iddepartamento = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, departamento.getNomeDepartamento());
			ps.setString(2, departamento.getGerenteDepartamento());
			ps.setInt(3, departamento.getIdDepartamento());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Departamento> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from departamento");
			rs = ps.executeQuery();
			List<Departamento> list = new ArrayList<Departamento>();
			while(rs.next()) {
				list.add(new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DepartamentoRelatorio> listarParaRelatorio(){
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from departamento");
			rs = ps.executeQuery();
			List<DepartamentoRelatorio> listaRelatorio = new ArrayList<DepartamentoRelatorio>();
			while(rs.next()) {
				
				listaRelatorio.add(new DepartamentoRelatorio(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listaRelatorio;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Departamento obterPorId(int id){

		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from departamento where iddepartamento = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o departamento com esse id: " + id);
			}
			
			Departamento departamento = new Departamento();
			departamento.setIdDepartamento(id);
			departamento.setNomeDepartamento(rs.getString(2));
			departamento.setGerenteDepartamento(rs.getString(3));
			
			return departamento;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public void excluir(Departamento departamento) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "delete from departamento where iddepartamento = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, departamento.getIdDepartamento());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
