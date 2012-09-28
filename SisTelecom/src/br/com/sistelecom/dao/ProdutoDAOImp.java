/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Produto;
import br.com.sistelecom.interfaces.dao.ProdutoDAO;

/**
 *
 * @author Danilo Alves
 */
public class ProdutoDAOImp implements ProdutoDAO {

    /**
     * Método que cria novos produtos
     *
     * @param produto
     * @throws Exception
     */
    //@Override
    public void salvar(Produto produto) {
    	
        Connection conn = SistelecomSingleConnection.getConnection();
        PreparedStatement ps = null;

        try {
            String SQL = "INSERT into produto (nome_produto, tipo, valor_receita, criacao, status, auditoria)"
                    + "values(?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getTipo());
            ps.setInt(3, produto.getValorReceita());
            ps.setDate(4, new java.sql.Date(produto.getCriacao().getTime()));
            ps.setString(5, produto.getStatus());
            ps.setDate(6, new java.sql.Date(produto.getAuditoria().getTime()));
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }

    }

    /**
     * Método que atualiza os produtos
     *
     * @param produto
     * @throws Exception
     */
    //@Override
    public void atualizar(Produto produto) {
    	
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();

        try {

            String SQL = "UPDATE produto SET nome_produto=?, tipo=?, valor_receita=?, criacao=?, status=?, auditoria=? "
                    + "where idproduto = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getTipo());
            ps.setInt(3, produto.getValorReceita());
            ps.setDate(4, new java.sql.Date(produto.getCriacao().getTime()));
            ps.setString(5, produto.getStatus());
            ps.setDate(6, new java.sql.Date(produto.getAuditoria().getTime()));
            ps.setInt(7, produto.getIdProduto());

            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    /**
     * Método que lista todos os produtos
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosProdutos() {
    	
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select * from produto");
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                Integer idProduto = rs.getInt(1);
                String nomeProduto = rs.getString(2);
                String tipo = rs.getString(3);
                Integer valorReceita = rs.getInt(4);
                Date criacao = rs.getDate(5);
                String status = rs.getString(6);
                Date auditoria = rs.getDate(7);

                list.add(new Produto(idProduto, nomeProduto, tipo, valorReceita, criacao, status, auditoria));
            }
            return list;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que busca um produto pelo id
     * @param idproduto
     * @return
     * @throws Exception 
     */
    //@Override
    public Produto procurarIdProduto(Integer idProduto) {
    	
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select * from produto where idproduto = ?");
            ps.setInt(1, idProduto);
            rs = ps.executeQuery();

            String nomeProduto = rs.getString(2);
            String tipo = rs.getString(3);
            Integer valorReceita = rs.getInt(4);
            Date criacao = rs.getDate(5);
            String status = rs.getString(6);
            Date auditoria = rs.getDate(7);
            
            return new Produto(idProduto, nomeProduto, tipo, valorReceita, criacao, status, auditoria);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Méotod que busca um produto pelo nome
     * @param nome_produto
     * @return
     * @throws Exception 
     */
    //@Override
    public Produto procurarNomeProduto(String nomeProduto) {
    	
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;
        
        try{ 
            ps = conn.prepareStatement("select * from produto where nome_produto = ?");
            ps.setString(1, nomeProduto);
            rs = ps.executeQuery();
            
            Integer idProduto = rs.getInt(1);
            String tipo = rs.getString(3);
            Integer valorReceita = rs.getInt(4);
            Date criacao = rs.getDate(5);
            String status = rs.getString(6);
            Date auditoria = rs.getDate(7);
            
            return new Produto(idProduto, nomeProduto, tipo, valorReceita, criacao, status, auditoria);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que deleta um produto
     * @param produto
     * @throws Exception 
     */
    //@Override
    public void excluir(Produto produto) {
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();

        try{
            ps = conn.prepareStatement("delete from produto where idproduto = ?");
            ps.setInt(1, produto.getIdProduto());
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}