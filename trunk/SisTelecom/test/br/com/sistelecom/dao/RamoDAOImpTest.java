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

import br.com.sistelecom.entity.Ramo;

/**
 *
 * @author Danilo Alves
 */
public class RamoDAOImpTest {
    
    public RamoDAOImpTest() {
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
     * Test of create method, of class RamoDAOImp.
     */
    @Test
    public void salvar() throws Exception {
        System.out.println("salvar");
        final Ramo ramo = new Ramo(null, "Padaria", true);
        final RamoDAOImp instance = new RamoDAOImp();
        instance.salvar(ramo);
        assertNotNull(ramo);
        assertTrue(ramo.getNomeRamo().length() > 0);
    }
    
    public Ramo pesquisarId(Integer idramo) throws Exception {
        RamoDAOImp instance = new RamoDAOImp();
        return instance.procurarIdRamo(idramo);
    }

    /**
     * Test of update method, of class RamoDAOImp.
     */
    @Test
    public void atualizar() throws Exception {
        System.out.println("atualizar");
        final Ramo ramo = new Ramo(20, "Borracharia", false);
        final RamoDAOImp instance = new RamoDAOImp();
        instance.atualizar(ramo);
        assertNotNull(ramo);
    }

    /**
     * Test of allRamo method, of class RamoDAOImp.
     */
    @Test
    public void todosRamos() throws Exception {
        System.out.println("todosRamos");
        final RamoDAOImp instance = new RamoDAOImp();
        List expResult = null;
        List result = instance.todosRamos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchIdRamo method, of class RamoDAOImp.
     */
    @Test
    public void procurarIdRamo() throws Exception {
        System.out.println("procurarIdRamo");
        final Integer idRamo = 1;
        final Ramo ramo = pesquisarId(idRamo);
        assertNotNull(ramo);
        assertTrue(ramo.getNomeRamo().length() > 0);
        System.out.println(ramo.getNomeRamo());
    }

    /**
     * Test of delete method, of class RamoDAOImp.
     */
    @Test
    public void excluir() throws Exception {
        System.out.println("excluir");
        Ramo ramo = new Ramo();
        Integer idRamo = 2;
        ramo.setIdRamo(idRamo);
        RamoDAOImp instance = new RamoDAOImp();
        instance.excluir(ramo);
        
        try{
            ramo = pesquisarId(idRamo);
        } catch (Exception ex) {
            return;
        }
        fail("O cliente não pode ser encontrado");
    }
}
