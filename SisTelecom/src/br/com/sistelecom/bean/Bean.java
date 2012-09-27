package br.com.sistelecom.bean;

import javax.faces.event.ActionEvent;

public abstract class Bean {

	/**
	 * Ação para inclusão de um novo registro.
	 * @return
	 */
	public String novoRegistro(){
		return null;
	}
	
	/**
	 * Lista todos os registros.
	 * @return
	 */
	public String listarTodos(){
		return null;
	}
	
	/**
	 * Alterar registro a partir da lista
	 * @return
	 */
	public String carregarRegistro(){
		return null;
	}

	/**
	 * Exclui registro a partir da listagem
	 * @param actionEvent
	 */
	public void excluirRegistro(ActionEvent actionEvent){
		
	}
	
	public boolean validarDadosFormulario(){
		return false;
	}
}
