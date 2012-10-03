/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;


import static org.junit.Assert.*;

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
public class ClienteDAOImplTest {
    
    //private static Cliente cliente;
    
    public ClienteDAOImplTest() {
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
    public void create() throws Exception {
        System.out.println("create");
        final Cliente cliente = new Cliente(null, "000", "dadada", "dasasda", 50, "fasdfas", 400, "qd 50", "guanabara", 50, 9, 7400, 200, 300, "danilo", 012030, new Date(), "0083", "daniolo", new Date(),"123312", "sdfafa", new Date(), "412341", "fasdfa", new Date());
        final ClienteDAOImpl instance = new ClienteDAOImpl();
        instance.salvar(cliente);
        assertNotNull("cliente", cliente);
        assertTrue(cliente.getRazaoSocial().length() > 0);
    }

    /**
     * Test of update method, of class ClienteDAOImp.
     */
    @Test
    public void update() throws Exception {
        System.out.println("update");
        final Cliente cliente = new Cliente(2, "12345678000109", "Danilo razao", " ", 1, "Teste 2 logradorou", 500, "Teste 2 complemento", "Guanabara", 50, 9, 74675690, 623207, 62851001, "danilo.brt.corp@gmail.com", 1020312, new Date(), "00891310100", "Danilo Fernando Alves", new Date(), null, null, new Date(), null, null, new Date());
        final ClienteDAOImpl instance = new ClienteDAOImpl();
        instance.atualizar(cliente);
        assertNotNull(cliente);
        assertEquals("Danilo razao", pesquisarId(2).getRazaoSocial());
    }

    /**
     * Test of allCliente method, of class ClienteDAOImp.
     */
    @Test
    public void allCliente() throws Exception {
        System.out.println("allCliente");
        ClienteDAOImp instance = new ClienteDAOImp();
        List expResult = null;
        List result = instance.allCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public Cliente pesquisarId(Integer id) throws Exception {
        
        ClienteDAOImp instance = new ClienteDAOImp();
        return instance.searchidcliente(id);
    }
    /**
     * Test of searchidcliente method, of class ClienteDAOImp.
     */
    @Test
    public void searchidcliente() throws Exception {
        System.out.println("searchidcliente");
        final Integer id = 1;
        final Cliente cliente = pesquisarId(id); 
        assertNotNull(cliente);
        assertTrue(cliente.getNome_fantasia().length() > 0);
        System.out.println(cliente.getRazao_social());
    }
    
    public Cliente pesquisarCnpj(String cnpj) throws Exception {
        
        ClienteDAOImp instance = new ClienteDAOImp();
        return instance.searchcnpj(cnpj);
    }
    /**
     * Test of searchcnpj method, of class ClienteDAOImp.
     */
    @Test
    public void searchcnpj() throws Exception {
        System.out.println("searchcnpj");
        final String cnpj = "12345678000109";
        final Cliente cliente = pesquisarCnpj(cnpj);
        assertNotNull(cliente);
        assertTrue(cliente.getBairro().length() > 0);
        System.out.println(cliente.getRazao_social());
    }

    /**
     * Test of delete method, of class ClienteDAOImp.
     */
    @Test
    public void delete() throws Exception {
        System.out.println("delete");
        Cliente cliente = new Cliente();
        Integer id = 1;
        cliente.setIdcliente(id);
        ClienteDAOImp instance = new ClienteDAOImp();
        instance.delete(cliente);
        
        try{
            cliente = pesquisarId(id);
        } catch (Exception ex) {
            return;
        }
        fail("O cliente não poderia ser encontrado.");
    }
}
