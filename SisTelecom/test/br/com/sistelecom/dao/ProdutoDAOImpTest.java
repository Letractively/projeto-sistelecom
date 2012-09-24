/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.sistelecom.entity.Produto;

/**
 *
 * @author Danilo Alves
 */
public class ProdutoDAOImpTest {
    
    public ProdutoDAOImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProdutoDAOImp.
     */
    @Test
    public void salvar() throws Exception {
        System.out.println("create");
        final Produto produto = new Produto(null, "Profissional Equipe Flat 100 Titular", "Voz móvel", 2000, new Date(), "ativo", new Date());
        final ProdutoDAOImp instance = new ProdutoDAOImp();
        instance.salvar(produto);
        assertNotNull(produto);
        assertTrue(produto.getNomeProduto().length() >0);
        assertEquals(produto.getStatus(), "ativo");
    }
    
    public Produto pesquisarId(Integer id) throws Exception {
        ProdutoDAOImp instance = new ProdutoDAOImp();
        return instance.procurarIdProduto(id);
    }
    
    public Produto pesquisarNomeProduto(String nome) throws Exception {
        ProdutoDAOImp instance = new ProdutoDAOImp();
        return instance.procurarNomeProduto(nome);
    }

    /**
     * Test of update method, of class ProdutoDAOImp.
     */
    @Test
    public void atualizar() throws Exception {
        System.out.println("update");
        final Produto produto = new Produto(1, "Oi Profissional Equipe Flat 200 Titular", "Voz móvel", 3000, new Date(), "desativado", new Date());
        final ProdutoDAOImp instance = new ProdutoDAOImp();
        instance.atualizar(produto);
        assertTrue(produto.getStatus().length() >0);
        assertEquals(produto.getStatus(), "desativado");
    }

    /**
     * Test of allProduto method, of class ProdutoDAOImp.
     */
    @Test
    public void todosProdutos() throws Exception {
        System.out.println("allProduto");
        ProdutoDAOImp instance = new ProdutoDAOImp();
        List expResult = null;
        List result = instance.todosProdutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchidproduto method, of class ProdutoDAOImp.
     */
    @Test
    public void procurarIdProduto() throws Exception {
        System.out.println("searchidproduto");
        final Integer idProduto = 1;
        final Produto produto = pesquisarId(idProduto);
        assertNotNull(produto);
        assertTrue(produto.getNomeProduto().length() > 0);
        System.out.println(produto.getStatus());
    }

    /**
     * Test of searchnomeproduto method, of class ProdutoDAOImp.
     */
    @Test
    public void procurarNomeProduto() throws Exception {
        System.out.println("searchnomeproduto");
        final String nome_produto = "Oi Profissional Equipe Flat 200 Titular";
        final Produto produto = pesquisarNomeProduto(nome_produto);
        assertNotNull(produto);
        assertEquals(produto, produto.getNomeProduto());
    }

    /**
     * Test of delete method, of class ProdutoDAOImp.
     */
    @Test
    public void excluir() throws Exception {
        System.out.println("delete");
        Produto produto = new Produto();
        Integer idProduto = 1;
        produto.setIdProduto(idProduto);
        ProdutoDAOImp instance = new ProdutoDAOImp();
        instance.excluir(produto);
        
        try{
            produto = pesquisarId(idProduto);
        } catch (Exception ex) {
            return;
        }
        fail("Não foi possível deletar esse produto");
    }
}
