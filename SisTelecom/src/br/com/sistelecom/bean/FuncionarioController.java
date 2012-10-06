package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.dao.FuncionarioDAOImpl;
import br.com.sistelecom.entity.Funcionario;
import br.com.sistelecom.to.FuncionarioTO;

public class FuncionarioController implements Controller<Funcionario>{
	
	private Funcionario funcionario;
	private List<FuncionarioTO> lista;
	private List<SelectItem> listaFuncionario;
	private DAO<Funcionario> funcionarioDAO = new FuncionarioDAOImpl();
		
	public FuncionarioController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getFuncionario());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Funcionário incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do funcionário.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<FuncionarioTO>();
		this.setLista(this.getDao().todosFuncionariosParaExibirEmTabela());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idFuncionario = Integer.parseInt(id);

		final Funcionario funcionario = this.getDao().obterPorId(idFuncionario);

		this.getFuncionario().setIdFuncionario(funcionario.getIdFuncionario());
		this.getFuncionario().setCpf(funcionario.getCpf());
		this.getFuncionario().setDepartamento(funcionario.getDepartamento());
		this.getFuncionario().setNome(funcionario.getNome());
		//this.getFuncionario().setLogradouro(funcionario.getLogradouro());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getFuncionario());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Funcionário atualizado com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do funcionário.",""));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getFuncionario().getIdFuncionario() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
		this.limpar();
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idFuncionario = Integer.parseInt(id);
		
		final Funcionario funcionario = this.getDao().obterPorId(idFuncionario);
		
		try {
			if(funcionario != null){
				this.getDao().excluir(funcionario);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Funcionário excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do funcionário.",""));
			e.printStackTrace();
		}
		this.limpar();
	}
	
	public boolean validarDadosFormulario() {
		if (this.getFuncionario().getCpf() == null || this.getFuncionario().getCpf().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o CPF do funcionario.",""));
			return false;
		}
		return true;
	}
	
	public void limpar() {
		this.funcionario = new Funcionario();
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

	/**
	 * @return the lista
	 */
	public List<FuncionarioTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<FuncionarioTO> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> getListaEstado() {
		List<Funcionario> listaDeFuncionario = funcionarioDAO.listarTodos();
		
		if(this.listaFuncionario == null){
			this.listaFuncionario = new LinkedList<SelectItem>();
			for (Funcionario funcionario : listaDeFuncionario) {
				this.listaFuncionario.add(new SelectItem(funcionario.getIdFuncionario(), funcionario.getCpf(), funcionario.getNome()));
			}
		}
		return listaFuncionario;
	}

	/**
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaFuncionario(List<SelectItem> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

}