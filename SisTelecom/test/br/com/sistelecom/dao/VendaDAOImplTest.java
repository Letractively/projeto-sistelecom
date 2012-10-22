package br.com.sistelecom.dao;

import org.junit.Test;

import br.com.sistelecom.entity.Venda;

import junit.framework.TestCase;

public class VendaDAOImplTest extends TestCase{

	private DAO<Venda> dao = new VendaDAOImpl();
	
	@Test
	public void testSalvar(){
		final Venda venda = new Venda();
		//TODO: Povoar Objeto
		
		try {
			dao.salvar(venda);
			assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			assertTrue(Boolean.FALSE);
		}
	}
}
