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

import br.com.sistelecom.entity.Cliente;

/**
 *
 * @author Danilo Alves
 */
public class ClienteDAOImpTest {
    
    //private static Cliente cliente;
    
    public ClienteDAOImpTest() {
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
     * Test of create method, of class ClienteDAOImp.
     */
    @Test
    public void salvar() throws Exception {
        System.out.println("create");
        final Cliente cliente = new Cliente(null,"12345678000109", "Danilo razao", "Danilo Teste Fantasia", 1, "Teste logradouro", 400, "Teste Complemento", "jardim guanabara 2", 5, 1, 74000000, 628510014, 623207315, "danilo@teste", 1020304050, new Date(), "00891310100", "Danilo Fernando Testes", new Date(), null, null, new Date(), null, null, new Date(), new Date());
        final ClienteDAOImp instance = new ClienteDAOImp();
        instance.salvar(cliente);
        assertNotNull("cliente", cliente);
        assertTrue(cliente.getRazaoSocial().length() > 0);
    }

    /**
     * Test of update method, of class ClienteDAOImp.
     */
    @Test
    public void atualizar() throws Exception {
        System.out.println("update");
        final Cliente cliente = new Cliente(1, "12345678000109", "Danilo razao", " ", 1, "Teste 2 logradorou", 500, "Teste 2 complemento", "Guanabara", 50, 9, 74675690, 623207, 62851001, "danilo.brt.corp@gmail.com", 1020312, new Date(), "00891310100", "Danilo Fernando Alves", new Date(), null, null, new Date(), null, null, new Date(), new Date());
        final ClienteDAOImp instance = new ClienteDAOImp();
        instance.atualizar(cliente);
        assertNotNull(cliente);
        assertEquals("Danilo razao", pesquisarId(1).getRazaoSocial());
    }

    /**
     * Test of allCliente method, of class ClienteDAOImp.
     */
    @Test
    public void todosClientes() throws Exception {
        System.out.println("allCliente");
        ClienteDAOImp instance = new ClienteDAOImp();
        List expResult = null;
        List result = instance.todosClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public Cliente pesquisarId(Integer id) throws Exception {
        
        ClienteDAOImp instance = new ClienteDAOImp();
        return instance.procurarIdCliente(id);
    }
    /**
     * Test of searchidcliente method, of class ClienteDAOImp.
     */
    @Test
    public void procurarIdCliente() throws Exception {
        System.out.println("searchidcliente");
        final Integer idCliente = 1;
        final Cliente cliente = pesquisarId(idCliente); 
        assertNotNull(cliente);
        assertTrue(cliente.getNomeFantasia().length() > 0);
        System.out.println(cliente.getRazaoSocial());
    }
    
    public Cliente pesquisarCnpj(String cnpj) throws Exception {
        
        ClienteDAOImp instance = new ClienteDAOImp();
        return instance.procurarCnpj(cnpj);
    }
    /**
     * Test of searchcnpj method, of class ClienteDAOImp.
     */
    @Test
    public void procurarCnpj() throws Exception {
        System.out.println("searchcnpj");
        final String cnpj = "12345678000109";
        final Cliente cliente = pesquisarCnpj(cnpj);
        assertNotNull(cliente);
        assertTrue(cliente.getBairro().length() > 0);
        System.out.println(cliente.getRazaoSocial());
    }

    /**
     * Test of delete method, of class ClienteDAOImp.
     */
    @Test
    public void excluir() throws Exception {
        System.out.println("delete");
        Cliente cliente = new Cliente();
        Integer idCliente = 1;
        cliente.setIdCliente(idCliente);
        ClienteDAOImp instance = new ClienteDAOImp();
        instance.excluir(cliente);
        
        try{
            cliente = pesquisarId(idCliente);
        } catch (Exception ex) {
            return;
        }
        fail("O cliente não poderia ser encontrado.");
    }
}
