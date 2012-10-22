package br.com.sistelecom.dao;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.sistelecom.entity.Funcionario;
import br.com.sistelecom.entity.Venda;

public class VendaDAOImplTest extends TestCase{

	private DAO<Venda> dao = new VendaDAOImpl();
	
	@Test
	public void testSalvar(){
		
		/*System.out.println("create");
	    final Venda venda = new Venda();
	    final FuncionarioDAOImpl instance = new FuncionarioDAOImpl();
	    instance.salvar(funcionario);
	    assertNotNull("funcionario", funcionario);
	    assertTrue(funcionario.getNome().length() > 0);
	        
		/*try {
			dao.salvar(venda);
			assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			assertTrue(Boolean.FALSE);
		}*/
	}
}
