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

import br.com.sistelecom.entity.Funcionario;

/**
 *
 * @author Danilo Alves
 */
public class FuncionarioDAOImplTest {
    
    //private static Funcionario funcionario;
    
    public FuncionarioDAOImplTest() {
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
     * Test of create method, of class FuncionarioDAOImpl.
     */
    @Test
    public void create() throws Exception {
        System.out.println("create");
        final Funcionario funcionario = new Funcionario(null, "03211", 5, "danio", "rua", 4, "ad", "guanab", 10, 9, 74, new Date(), 21, 321, "danilo@", 132, "RG", 5, 6, "fernando", new Date(), "ativo", "dan", "pass");
        final FuncionarioDAOImpl instance = new FuncionarioDAOImpl();
        instance.salvar(funcionario);
        assertNotNull("funcionario", funcionario);
        assertTrue(funcionario.getNome().length() > 0);
    }

    /**
     * Test of update method, of class FuncionarioDAOImp.
     */
    @Test
    public void update() throws Exception {
        System.out.println("update");
        final Funcionario funcionario = new Funcionario(3, "12312", 5, "danilo", "rua", 1, "rua", "guan", 10, 1, 74, new Date(), 21, 32, "sfas", 213, "CPF", 8, 9, "fernando", new Date(), "demitido", "danilo", "pass");
        final FuncionarioDAOImpl instance = new FuncionarioDAOImpl();
        instance.atualizar(funcionario);
        assertNotNull(funcionario);
        assertEquals("12312", pesquisarId(3).getCpf());
    }

    /**
     * Test of allFuncionario method, of class FuncionarioDAOImp.
     */
    @Test
    public void listarTodos() throws Exception {
        System.out.println("listarTodos");
        FuncionarioDAOImpl instance = new FuncionarioDAOImpl();
        List expResult = null;
        List result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public Funcionario pesquisarId(Integer id) throws Exception {
        
        FuncionarioDAOImpl instance = new FuncionarioDAOImpl();
        return instance.obterPorId(id);
    }
    /**
     * Test of searchidfuncionario method, of class FuncionarioDAOImp.
     */
    @Test
    public void obterPorId() throws Exception {
        System.out.println("obterPorId");
        final Integer id = 4;
        final Funcionario funcionario = pesquisarId(id); 
        assertNotNull(funcionario);
        assertTrue(funcionario.getNome().length() > 0);
        System.out.println(funcionario.getNome());
    }
    
    /**
     * Test of delete method, of class FuncionarioDAOImp.
     */
    @Test
    public void delete() throws Exception {
        System.out.println("delete");
        Funcionario funcionario = new Funcionario();
        Integer id = 2;
        funcionario.setIdFuncionario(id);
        FuncionarioDAOImpl instance = new FuncionarioDAOImpl();
        instance.excluir(funcionario);
        
        try{
        	funcionario = pesquisarId(id);
        } catch (Exception ex) {
            return;
        }
        fail("O funcionario não poderia ser encontrado.");
    }
}
