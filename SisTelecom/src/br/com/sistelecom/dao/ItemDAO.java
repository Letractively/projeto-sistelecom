package br.com.sistelecom.dao;

import br.com.sistelecom.entity.Itens;

public interface ItemDAO extends DAO<Itens>{
	
	public int salvarItem(Itens item) throws Exception;
	
}
