package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.DepartamentoDAOImpl;
import br.com.sistelecom.entity.Departamento;

public class DepartamentoController implements Controller<Departamento>{
	
	private Departamento departamento;
	private List<Departamento> lista;
	
	public DepartamentoController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getDepartamento());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Departamento incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do departamento.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Departamento>();
		this.setLista(this.getDao().listarTodos());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idDepartamento = Integer.parseInt(id);

		final Departamento departamento = this.getDao().obterPorId(idDepartamento);

		this.getDepartamento().setIdDepartamento(departamento.getIdDepartamento());
		this.getDepartamento().setNomeDepartamento(departamento.getNomeDepartamento());
		this.getDepartamento().setGerenteDepartamento(departamento.getGerenteDepartamento());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getDepartamento());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Departamento atualizado com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do departamento.",""));
				return;
			}
		}
	}
	public void salvar(ActionEvent evento) {
		if(this.getDepartamento().getIdDepartamento() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idDepartamento = Integer.parseInt(id);
		
		final Departamento departamento = this.getDao().obterPorId(idDepartamento);
		
		try {
			if(departamento != null){
				this.getDao().excluir(departamento);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Departamento excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do departamento.",""));
			e.printStackTrace();
		}
	}
	
	public boolean validarDadosFormulario() {
		if (this.getDepartamento().getNomeDepartamento() == null || this.getDepartamento().getNomeDepartamento().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o nome do departamento.",""));
			return false;
		}
		return true;
	}
	
	public DepartamentoDAOImpl getDao() {
		return new DepartamentoDAOImpl();
	}
	
	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		if (this.departamento == null) {
			this.departamento = new Departamento();
		}
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the lista
	 */
	public List<Departamento> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Departamento> lista) {
		this.lista = lista;
	}
	

}
