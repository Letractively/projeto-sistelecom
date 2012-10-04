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
        final Cliente cliente = new Cliente(3, "000000", "dededede", "desdedes", 50, "rua qlauqer", 800, "dqdq000", "fdasfasd", 60, 10, 10233, 32112, 321312, "dasdfaf@", 12023, new Date(), "93211232", "dtegadas", new Date(), null, null, new Date(), null, null, new Date());
        final ClienteDAOImpl instance = new ClienteDAOImpl();
        instance.atualizar(cliente);
        assertNotNull(cliente);
        assertEquals("Danilo razao", pesquisarId(4).getRazaoSocial());
    }

    /**
     * Test of allCliente method, of class ClienteDAOImp.
     */
    @Test
    public void listarTodos() throws Exception {
        System.out.println("listarTodos");
        ClienteDAOImpl instance = new ClienteDAOImpl();
        List expResult = null;
        List result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public Cliente pesquisarId(Integer id) throws Exception {
        
        ClienteDAOImpl instance = new ClienteDAOImpl();
        return instance.obterPorId(id);
    }
    /**
     * Test of searchidcliente method, of class ClienteDAOImp.
     */
    @Test
    public void obterPorId() throws Exception {
        System.out.println("obterPorId");
        final Integer id = 4;
        final Cliente cliente = pesquisarId(id); 
        assertNotNull(cliente);
        assertTrue(cliente.getNomeFantasia().length() > 0);
        System.out.println(cliente.getRazaoSocial());
    }
    
    /**
     * Test of delete method, of class ClienteDAOImp.
     */
    @Test
    public void delete() throws Exception {
        System.out.println("delete");
        Cliente cliente = new Cliente();
        Integer id = 2;
        cliente.setIdCliente(id);
        ClienteDAOImpl instance = new ClienteDAOImpl();
        instance.excluir(cliente);
        
        try{
            cliente = pesquisarId(id);
        } catch (Exception ex) {
            return;
        }
        fail("O cliente não poderia ser encontrado.");
    }
}
