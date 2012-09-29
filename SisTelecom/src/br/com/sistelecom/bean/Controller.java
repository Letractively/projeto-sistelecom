package br.com.sistelecom.bean;

import javax.faces.event.ActionEvent;

import br.com.sistelecom.dao.DAO;

public interface Controller<E> {

	public abstract void salvar(ActionEvent evento);
	
	public abstract void novoRegistro();
	
	public abstract void atualizarRegistro();

	public abstract void excluirRegistro(ActionEvent evento);
	
	public abstract void listarTodos();

	public abstract void carregarRegistro(ActionEvent evento);
	
	public abstract boolean validarDadosFormulario();
	
	public abstract DAO<E> getDao();
	
	
}
