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
import br.com.sistelecom.dao.RamoDAOImpl;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.to.RamoTO;

public class RamoController implements Controller<Ramo> {

	private Ramo ramo;
	private List<RamoTO> lista;
	private List<SelectItem> listaRamo;
	private DAO<Ramo> ramoDAO = new RamoDAOImpl();
	
	public RamoController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getRamo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Ramo incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do ramo.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<RamoTO>();
		this.setLista(this.getDao().todosRamosParaExibirEmTabela());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idRamo = Integer.parseInt(id);

		final Ramo ramo = this.getDao().obterPorId(idRamo);

		this.getRamo().setIdRamo(ramo.getIdRamo());
		this.getRamo().setNomeRamo(ramo.getNomeRamo());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getRamo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Ramo atualizado com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do ramo.",""));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getRamo().getIdRamo() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
		
		this.limpar();
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idRamo = Integer.parseInt(id);
		
		final Ramo ramo = this.getDao().obterPorId(idRamo);
		
		try {
			if(ramo != null){
				this.getDao().excluir(ramo);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Ramo excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do ramo.",""));
			e.printStackTrace();
		}
		
		this.limpar();
	}
	
	public boolean validarDadosFormulario() {
		if (this.getRamo().getNomeRamo() == null || this.getRamo().getNomeRamo().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o nome do ramo.",""));
			return false;
		}
		return true;
	}
	
	public void limpar() {
		this.ramo = new Ramo();
	}
	
	public RamoDAOImpl getDao() {
		return new RamoDAOImpl();
	}
	
	/**
	 * @return the ramo
	 */
	public Ramo getRamo() {
		if (this.ramo == null) {
			this.ramo = new Ramo();
		}
		return ramo;
	}

	/**
	 * @param ramo the ramo to set
	 */
	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

	/**
	 * @return the lista
	 */
	public List<RamoTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<RamoTO> lista) {
		this.lista = lista;
	}
	
	/**
	 * @return the listaDepartamento
	 */
	public List<SelectItem> getListaRamo() {
		List<Ramo> listaDeRamo = ramoDAO.listarTodos();
		
		if(this.listaRamo == null){
			this.listaRamo = new LinkedList<SelectItem>();
			for (Ramo ramo : listaDeRamo) {
				this.listaRamo.add(new SelectItem(ramo.getIdRamo(), ramo.getNomeRamo()));
			}
		}
		return listaRamo;
	}

	/**
	 * @param listaRamo the listaRamo to set
	 */
	public void setListaRamo(List<SelectItem> listaRamo) {
		this.listaRamo = listaRamo;
	}
	
}
