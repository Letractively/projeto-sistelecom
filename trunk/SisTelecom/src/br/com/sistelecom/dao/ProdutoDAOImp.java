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

import br.com.sistelecom.connection.ConnectionFactory;
import br.com.sistelecom.entity.Produto;
import br.com.sistelecom.interfaces.dao.ProdutoDAO;

/**
 *
 * @author Danilo Alves
 */
public class ProdutoDAOImp implements ProdutoDAO {

    private Connection conn;

    public ProdutoDAOImp() throws Exception {

        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro " + "\n" + e.getMessage());
        }
    }

    /**
     * Método que cria novos produtos
     *
     * @param produto
     * @throws Exception
     */
    //@Override
    public void salvar(Produto produto) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        if (produto == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {
            String SQL = "INSERT into produto (nome_produto, tipo, valor_receita, criacao, status, auditoria)"
                    + "values(?, ?, ?, ?, ?, ?)";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getTipo());
            ps.setInt(3, produto.getValorReceita());
            ps.setDate(4, new java.sql.Date(produto.getCriacao().getTime()));
            ps.setString(5, produto.getStatus());
            ps.setDate(6, new java.sql.Date(produto.getAuditoria().getTime()));
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Não foi possível cadastrar esse produto: " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

    }

    /**
     * Método que atualiza os produtos
     *
     * @param produto
     * @throws Exception
     */
    //@Override
    public void atualizar(Produto produto) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (produto == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {

            String SQL = "UPDATE produto SET nome_produto=?, tipo=?, valor_receita=?, criacao=?, status=?, auditoria=? "
                    + "where idproduto = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getTipo());
            ps.setInt(3, produto.getValorReceita());
            ps.setDate(4, new java.sql.Date(produto.getCriacao().getTime()));
            ps.setString(5, produto.getStatus());
            ps.setDate(6, new java.sql.Date(produto.getAuditoria().getTime()));
            ps.setInt(7, produto.getIdProduto());

            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Não foi possível atualizar esse produto: " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }
    /**
     * Método que lista todos os produtos
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosProdutos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
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
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que busca um produto pelo id
     * @param idproduto
     * @return
     * @throws Exception 
     */
    //@Override
    public Produto procurarIdProduto(Integer idProduto) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from produto where idproduto = ?");
            ps.setInt(1, idProduto);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado com o numero de registro: " + idProduto);
            }

            String nomeProduto = rs.getString(2);
            String tipo = rs.getString(3);
            Integer valorReceita = rs.getInt(4);
            Date criacao = rs.getDate(5);
            String status = rs.getString(6);
            Date auditoria = rs.getDate(7);
            
            return new Produto(idProduto, nomeProduto, tipo, valorReceita, criacao, status, auditoria);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Méotod que busca um produto pelo nome
     * @param nome_produto
     * @return
     * @throws Exception 
     */
    //@Override
    public Produto procurarNomeProduto(String nomeProduto) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{ 
            conn = this.conn;
            ps = conn.prepareStatement("select * from produto where nome_produto = ?");
            ps.setString(1, nomeProduto);
            rs = ps.executeQuery();
            
            if(!rs.next()) {
                throw new Exception("Não foi localizado o produto com esse nome: " + nomeProduto);
            }
            Integer idProduto = rs.getInt(1);
            String tipo = rs.getString(3);
            Integer valorReceita = rs.getInt(4);
            Date criacao = rs.getDate(5);
            String status = rs.getString(6);
            Date auditoria = rs.getDate(7);
            
            return new Produto(idProduto, nomeProduto, tipo, valorReceita, criacao, status, auditoria);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que deleta um produto
     * @param produto
     * @throws Exception 
     */
    //@Override
    public void excluir(Produto produto) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(produto==null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }
        try{
            conn = this.conn;
            ps = conn.prepareStatement("delete from produto where idproduto = ?");
            ps.setInt(1, produto.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }
}