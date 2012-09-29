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

import br.com.sistelecom.entity.Cargo;

/**
 *
 * @author Danilo Alves
 */
public class CargoDAOImpTest {
    
    public CargoDAOImpTest() {
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
     * Test of create method, of class CargoDAOImp.
     */
    @Test
    public void salvar() throws Exception {
        System.out.println("create");
        final Cargo cargo = new Cargo(null, "Gerente Comercial");
        final CargoDAOImpl instance = new CargoDAOImpl();
        instance.salvar(cargo);
        assertNotNull(cargo);
        assertTrue(cargo.getNomeCargo().length() > 0);
        System.out.println(cargo.getNomeCargo());
    }

    /**
     * Test of update method, of class CargoDAOImp.
     */
    @Test
    public void atualizar() throws Exception {
        System.out.println("update");
        final Cargo cargo = new Cargo(6, "Gerente Administrativo");
        final CargoDAOImpl instance = new CargoDAOImpl();
        instance.atualizar(cargo);
        assertNotNull(cargo);
        assertTrue(cargo.getNomeCargo().length() > 0);
    }

    /**
     * Test of allCargo method, of class CargoDAOImp.
     */
    @Test
    public void testTodosCargos() throws Exception {
        System.out.println("allCargo");
        CargoDAOImpl instance = new CargoDAOImpl();
        List expResult = null;
        List<Cargo> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public Cargo pesquisarId(Integer idcargo) throws Exception {
        CargoDAOImpl instance = new CargoDAOImpl();
        return instance.obterPorId(idcargo);
    }

    /**
     * Test of searchidcargo method, of class CargoDAOImp.
     */
    @Test
    public void procurarIdCargo() throws Exception {
        System.out.println("searchidcargo");
        final Integer idCargo = 2;
        final Cargo cargo = pesquisarId(idCargo);
        assertNotNull(cargo);
        assertTrue(cargo.getNomeCargo().length() > 0);
        System.out.println(cargo.getNomeCargo());
    }

    /**
     * Test of delete method, of class CargoDAOImp.
     */
    @Test
    public void excluir() throws Exception {
        System.out.println("delete");
        Cargo cargo = new Cargo();
        Integer idCargo = 1;
        cargo.setIdCargo(idCargo);
        CargoDAOImpl instance = new CargoDAOImpl();
        instance.excluir(cargo);
        
        try {
            cargo = pesquisarId(idCargo);
        } catch (Exception ex) {
            return;
        }
    }
}
