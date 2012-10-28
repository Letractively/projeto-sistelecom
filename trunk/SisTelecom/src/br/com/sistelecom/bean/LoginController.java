package br.com.sistelecom.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.dao.FuncionarioDAOImpl;
import br.com.sistelecom.entity.Funcionario;

public class LoginController implements Controller<Funcionario>{
	
	private Funcionario funcionario = new Funcionario();
	private DAO<Funcionario> funcionarioDAO = new FuncionarioDAOImpl();
	
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
	
	public void validacao(){
		
		final String login = funcionario.getLogin();
		final String password = funcionario.getPassword();
		
		if(validarDadosFormulario()){
			
			try{
				if(((FuncionarioDAOImpl) funcionarioDAO).validarLogin(login, password) != null){
					this.getDao().validarLogin(login, password);
				}
				else{
				
				}
			} catch(Exception e){
				
			}
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

}
