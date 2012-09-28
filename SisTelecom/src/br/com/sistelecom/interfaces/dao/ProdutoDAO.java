/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.interfaces.dao;

import java.util.List;

import br.com.sistelecom.entity.Produto;

/**
 *
 * @author Danilo Alves
 */
public interface ProdutoDAO {

    /**
     * Método que lista todos os produtos
     * @return
     * @throws Exception
     */
    List todosProdutos();

    /**
     * Método que cria novos produtos
     *
     * @param produto
     * @throws Exception
     */
    void salvar(Produto produto);

    /**
     * Método que deleta um produto
     * @param produto
     * @throws Exception
     */
    void excluir(Produto produto);

    /**
     * Método que busca um produto pelo id
     * @param idproduto
     * @return
     * @throws Exception
     */
    Produto procurarIdProduto(Integer idproduto);

    /**
     * Méotod que busca um produto pelo nome
     * @param nome_produto
     * @return
     * @throws Exception
     */
    Produto procurarNomeProduto(String nome_produto);

    /**
     * Método que atualiza os produtos
     *
     * @param produto
     * @throws Exception
     */
    void atualizar(Produto produto);
    
}
