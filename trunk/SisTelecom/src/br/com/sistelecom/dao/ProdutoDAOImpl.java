package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Produto;

public class ProdutoDAOImpl implements DAO<Produto> {

	public void salvar(Produto produto) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();

			String SQL = "INSERT INTO produto (nome_produto, tipo, valor_receita, criacao) values (?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNomeProduto());
			ps.setString(2, produto.getTipo());
			ps.setFloat(3, produto.getValorReceita());
			ps.setDate(4, new java.sql.Date(produto.getCriacao().getTime()));
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		} 
	}

	public void atualizar(Produto produto) throws Exception{
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			String SQL = "UPDATE produto SET nome_produto=?, tipo=?, valor_receita=?, criacao=? where idproduto = ?";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNomeProduto());
			ps.setString(2, produto.getTipo());
			ps.setFloat(3, produto.getValorReceita());
			ps.setDate(4, new java.sql.Date(produto.getCriacao().getTime()));
			ps.setInt(5, produto.getIdProduto());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public List<Produto> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from produto");
			rs = ps.executeQuery();
			List<Produto> list = new ArrayList<Produto>();
			while(rs.next()) {
				list.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Produto obterPorId(int id){

		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from produto where idproduto = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o produto com esse id: " + id);
			}

			Produto produto = new Produto();
			produto.setIdProduto(id);
			produto.setNomeProduto(rs.getString(2));
			produto.setTipo(rs.getString(3));
			produto.setValorReceita(rs.getFloat(4));
			produto.setCriacao(rs.getDate(5));

			return produto;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public void excluir(Produto produto) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();

			String SQL = "delete from produto where idproduto = ?";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, produto.getIdProduto());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		}
	}
}

