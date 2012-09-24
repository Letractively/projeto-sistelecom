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

import br.com.sistelecom.entity.Funcionario;

/**
 *
 * @author Danilo Alves
 */
public class FuncionarioDAOImpTest {
    
    public FuncionarioDAOImpTest() {
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
     * Test of create method, of class FuncionarioDAOImp.
     */
    @Test
    public void salvar() throws Exception {
        System.out.println("create");
        final Funcionario funcionario = new Funcionario(null, "00891310100", 3, "Danilo Fernando", "R. Porto nacional", 50, "Qd 50 Lt 12", "Jardim Guanabara", 50, 9, 74675690, new Date(), 623207315, 628510014, 4392773, "RG", 5, "Gerente", "Eu mesmo", new Date(), "ativo", new Date(), "teste", "teste");
        final FuncionarioDAOImp instance = new FuncionarioDAOImp();
        instance.salvar(funcionario);
        assertNotNull("funcionario", funcionario);
        assertTrue(funcionario.getNome().length() > 0);
    }

    /**
     * Test of update method, of class FuncionarioDAOImp.
     */
    @Test
    public void atualizar() throws Exception {
        System.out.println("update");
        final Funcionario funcionario = new Funcionario(2, "00891310100", 3, "Danilo Alves", "Rua porto Nacional", 400, "QD 50 Lt 12", "Guanabara", 50, 9, 74675690, new Date(), 623207, 628510, 4392773, "RG", 2, "Gerente comercial", null, new Date(), "demitido", new Date(), "teste", "teste");
        final FuncionarioDAOImp instance = new FuncionarioDAOImp();
        instance.atualizar(funcionario);
        assertNotNull(funcionario);
        assertEquals("Danilo Alves", pesquisarId(2).getNome());
    }

    /**
     * Test of allFuncionario method, of class FuncionarioDAOImp.
     */
    @Test
    public void todosFuncionarios() throws Exception {
        System.out.println("allFuncionario");
        FuncionarioDAOImp instance = new FuncionarioDAOImp();
        List expResult = null;
        List result = instance.todosFuncionarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public Funcionario pesquisarId(Integer id) throws Exception {
        
        FuncionarioDAOImp instance = new FuncionarioDAOImp();
        return instance.procurarIdFuncionario(id);
    }
    
    public Funcionario pesquisarCpf(String cpf) throws Exception {
        
        FuncionarioDAOImp instance = new FuncionarioDAOImp();
        return instance.procurarCpf(cpf);
    }

    /**
     * Test of searchidfuncionario method, of class FuncionarioDAOImp.
     */
    @Test
    public void procurarIdFuncionario() throws Exception {
        System.out.println("searchidfuncionario");
        final Integer idFuncionario = 2;
        final Funcionario funcionario = pesquisarId(idFuncionario);
        assertNotNull(funcionario);
        assertTrue(funcionario.getNome().length() > 0);
        System.out.println(funcionario.getNome());
    }

    /**
     * Test of searchcpf method, of class FuncionarioDAOImp.
     */
    @Test
    public void procurarCpf() throws Exception {
        System.out.println("searchcpf");
        final String cpf = "00891310100";
        final Funcionario funcionario = pesquisarCpf(cpf);
        assertNotNull(funcionario);
        assertTrue(funcionario.getCpf().length() > 0);
        System.out.println(funcionario.getCpf());
    }

    /**
     * Test of delete method, of class FuncionarioDAOImp.
     */
    @Test
    public void excluir() throws Exception {
        System.out.println("delete");
        Funcionario funcionario = new Funcionario();
        Integer idFuncionario = 2;
        funcionario.setIdFuncionario(idFuncionario);
        FuncionarioDAOImp instance = new FuncionarioDAOImp();
        instance.excluir(funcionario);
        
        try {
            funcionario = pesquisarId(idFuncionario);
        } catch (Exception ex) {
            return;
        }
        fail("O funcionário não pode ser encontrado.");
    }
}
