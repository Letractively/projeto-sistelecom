package br.com.sistelecom.bean;

import javax.faces.event.ActionEvent;

import br.com.sistelecom.dao.DAO;

public abstract class Controller<E> {

	public abstract void carregarDadosNaTela();
	
	public abstract void novoRegistro(ActionEvent evento);
	
	public abstract void listarTodos();

	public abstract void carregarRegistro(ActionEvent evento);

	public abstract void excluirRegistro(ActionEvent actionEvent);
	
	public abstract boolean validarDadosFormulario();
	
	public abstract DAO<E> getDao();
	
	
}
