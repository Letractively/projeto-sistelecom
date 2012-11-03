package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entidade.relatorio.ProdutoRelatorio;
import br.com.sistelecom.entity.Produto;
import br.com.sistelecom.to.ProdutoTO;

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
	
	public List<ProdutoRelatorio> listarParaRelatorio(){
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from produto");
			rs = ps.executeQuery();
			List<ProdutoRelatorio> listaRelatorio = new ArrayList<ProdutoRelatorio>();
			while(rs.next()) {
				listaRelatorio.add(new ProdutoRelatorio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5)));
			}
			
			return listaRelatorio;
			
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
	
	/**
	 * Sugere um produto mais vendido.
	 * @param idVenda
	 * @return
	 */
	public List<ProdutoTO> sugerirProdutos(final int idVenda){
		Connection conn = SistelecomSingleConnection.getConnection();
		
		final StringBuilder sb = new StringBuilder();
		sb.append("select distinct(it.produto), it.produto, ");
		sb.append("(select nome_produto from produto where idproduto = it.produto) as nome_produto ");
		sb.append("from reg_venda as rv ");
		sb.append("inner join venda_item as ri ");
		sb.append("on rv.idreg_venda = ri.idvenda ");
		sb.append("inner join itens as it ");
		sb.append("on ri.iditem = it.iditens ");
		sb.append("where rv.idreg_venda = ?; ");

		final List<ProdutoTO> produtos = new LinkedList<ProdutoTO>();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			ps.setInt(1, idVenda);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				final ProdutoTO produto = new ProdutoTO();
				produto.setNomeProduto(rs.getString("nome_produto"));
				produtos.add(produto);
			}
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return produtos;
	}
}

