package br.com.sistelecom.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.sistelecom.dao.FuncionarioDAOImpl;
import br.com.sistelecom.entity.Funcionario;
import br.com.sistelecom.entity.Login;

public class LoginController implements Controller<Funcionario>{

	private Funcionario funcionario = new Funcionario();
	private Login usuario = new Login();	
	private static final String URL_HOME = "/SisTelecom/paginas/home/home.jsf";

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
		if (this.getFuncionario().getLogin() == null || this.getFuncionario().getPassword().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe login/senha para ter acesso.",""));
			return false;
		}	
		return true;
	}

	public void validacao(ActionEvent evento){
		final String nome = this.getUsuario().getUsuario();
		final String senha = this.getUsuario().getPassword();

		if(this.getDao().validarLogin(nome, senha)){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(URL_HOME);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados inválidos!", ""));
		}
	}
	
	public void limpar() {
	}

	public FuncionarioDAOImpl getDao() {
		return new FuncionarioDAOImpl();
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		if (this.funcionario == null) {
			this.funcionario = new Funcionario();
		}
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Login getUsuario() {
		if(this.usuario == null){
			this.usuario = new Login();
		}
		return usuario;
	}

	public void setUsuario(Login usuario) {
		this.usuario = usuario;
	}

}
