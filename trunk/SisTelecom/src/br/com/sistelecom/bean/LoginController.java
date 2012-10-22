package br.com.sistelecom.bean;

import javax.faces.event.ActionEvent;

import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.entity.Funcionario;

public class LoginController implements Controller<Funcionario>{
	
	
	public LoginController(){
	}

	public void salvar(ActionEvent evento) {
	}

	public void novoRegistro() {
	}

	public void atualizarRegistro() {
	}

	public void excluirRegistro(ActionEvent evento) {
	}

	public void listarTodos() {
	}

	public void carregarRegistro(ActionEvent evento) {
	}

	public boolean validarDadosFormulario() {
		return false;
	}

	public void limpar() {
	}

	public DAO<Funcionario> getDao() {
		return null;
	}

}
