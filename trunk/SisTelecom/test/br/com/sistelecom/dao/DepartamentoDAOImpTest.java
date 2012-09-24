/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.sistelecom.entity.Departamento;

/**
 *
 * @author Danilo Alves
 */
public class DepartamentoDAOImpTest {
    
    public DepartamentoDAOImpTest() {
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
     * Test of create method, of class DepartamentoDAOImp.
     */
    @Test
    public void salvar() throws Exception {
        System.out.println("create");
        final Departamento departamento = new Departamento(null, "COMERCIAL", "DANILO FERNANDO");
        final DepartamentoDAOImp instance = new DepartamentoDAOImp();
        instance.salvar(departamento);
        assertNotNull("departamento", departamento);
        assertEquals("nome_departamento", "COMERCIAL", pesquisarId(2).getNomeDepartamento());
    }

    /*
     * Test of update method, of class DepartamentoDAOImp.
     */
    @Test
    public void atualizar() throws Exception {
        System.out.println("update");
        final Departamento departamento = new Departamento(3, "Administrativo", "MURILO LELES");
        final DepartamentoDAOImp instance = new DepartamentoDAOImp();
        instance.atualizar(departamento);
        assertEquals("MURILO LELES", pesquisarId(3).getGerenteDepartamento());
    }

    /**
     * Test of allDepartamento method, of class DepartamentoDAOImp.
     */
    @Test
    public void todosDepartamentos() throws Exception {
        System.out.println("allDepartamento");
        DepartamentoDAOImp instance = new DepartamentoDAOImp();
        List expResult = null;
        List result = instance.todosDepartamentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public Departamento pesquisarId(Integer iddepartamento) throws Exception {
        DepartamentoDAOImp instance = new DepartamentoDAOImp();
        return instance.procurarIdDepartamento(iddepartamento);
    }
    /**
     * Test of searchidDepartamento method, of class DepartamentoDAOImp.
     */
    @Test
    public void procurarIdDepartamento() throws Exception {
        System.out.println("searchidDepartamento");
        final Integer idDepartamento = 2;
        final Departamento departamento = pesquisarId(idDepartamento);
        assertTrue(departamento.getGerenteDepartamento().length() > 0);
        System.out.println(departamento.getNomeDepartamento());
        
    }

    public Departamento pesquisarNomeDepartamento(String nomeDepartamento) throws Exception {
        
        DepartamentoDAOImp instance = new DepartamentoDAOImp();
        return instance.procurarNomeDepartamento(nomeDepartamento);
    }
    /**
     * Test of searchnomeDepartamento method, of class DepartamentoDAOImp.
     */
    @Test
    public void procurarNomeDepartamento() throws Exception {
        System.out.println("searchnomeDepartamento");
        final String nomeDepartamento = "Administrativo";
        final Departamento departamento = pesquisarNomeDepartamento(nomeDepartamento);
        assertTrue(departamento.getNomeDepartamento().length() > 0);
        assertNotNull(pesquisarNomeDepartamento(nomeDepartamento));
        System.out.println(departamento.getGerenteDepartamento());
    }

    /**
     * Test of delete method, of class DepartamentoDAOImp.
     */
    @Test
    public void excluir() throws Exception {
        System.out.println("delete");
        Departamento departamento = new Departamento();
        Integer idDepartamento = 2;
        departamento.setIdDepartamento(idDepartamento);
        DepartamentoDAOImp instance = new DepartamentoDAOImp();
        instance.excluir(departamento);
        
        try {
            departamento = pesquisarId(idDepartamento);
        } catch (Exception ex) {
            return;
        }
        fail("O departamento não pode ser encontrado");
    }
}
