/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sistelecom.dao.ProdutoDAOImp;
import br.com.sistelecom.entity.Produto;
import br.com.sistelecom.interfaces.dao.ProdutoDAO;

/**
 *
 * @author Danilo Alves
 */
public class ProdutoController {

    private Produto produto;
    private DataModel modelProduto;

    public String novoProduto() {
        this.produto = new Produto();
        return "novoProdutoOK";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public DataModel getTodosProdutos() throws Exception {
        ProdutoDAO produtodao = new ProdutoDAOImp();
        modelProduto = new ListDataModel(produtodao.todosProdutos());
        return modelProduto;
    }

    public Produto getProdutoAtualizarOuExcluir() {
        produto = (Produto) modelProduto.getRowData();
        return produto;
    }

    public String atualizar() {
        produto = getProdutoAtualizarOuExcluir();
        setProduto(produto);
        return "atualizarOK";
    }

    public String excluir() throws Exception {
        ProdutoDAO produtodao = new ProdutoDAOImp();
        produto = getProdutoAtualizarOuExcluir();
        produtodao.excluir(produto);
        return "excluirOK";
    }

    public String salvar() throws Exception {
        ProdutoDAO produtodao = new ProdutoDAOImp();
        if (produto.getIdProduto() == null) {
            produtodao.salvar(produto);
        } else {
            produtodao.atualizar(produto);
        }
        return "salvarOK";
    }
}