package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.CargoDAOImpl;
import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.dao.EstadoDAOImpl;
import br.com.sistelecom.entity.Cargo;
import br.com.sistelecom.entity.Estado;
import br.com.sistelecom.to.RamoTO;

public class CargoController implements Controller<Cargo>{
	
	private Cargo cargo;
	private List<Cargo> lista;
	private List<SelectItem> listaCargo;
	private DAO<Cargo> cargoDAO = new CargoDAOImpl();
	
	public CargoController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getCargo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do cargo.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Cargo>();
		this.setLista(this.getDao().listarTodos());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idCargo = Integer.parseInt(id);

		final Cargo cargo = this.getDao().obterPorId(idCargo);

		this.getCargo().setIdCargo(cargo.getIdCargo());
		this.getCargo().setNomeCargo(cargo.getNomeCargo());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getCargo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo atualizado com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do cargo.",""));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getCargo().getIdCargo() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idCargo = Integer.parseInt(id);
		
		final Cargo cargo = this.getDao().obterPorId(idCargo);
		
		try {
			if(cargo != null){
				this.getDao().excluir(cargo);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do cargo.",""));
			e.printStackTrace();
		}
	}
	
	public boolean validarDadosFormulario() {
		if (this.getCargo().getNomeCargo() == null || this.getCargo().getNomeCargo().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o nome do cargo.",""));
			return false;
		}
		return true;
	}
	
	public CargoDAOImpl getDao() {
		return new CargoDAOImpl();
	}
	
	/**
	 * @return the cargo
	 */
	public Cargo getCargo() {
		if (this.cargo == null) {
			this.cargo = new Cargo();
		}
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Cargo> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> getListaCargo() {
		List<Cargo> listaDeCargo = cargoDAO.listarTodos();
		
		if(this.listaCargo == null){
			this.listaCargo = new LinkedList<SelectItem>();
			for (Cargo cargo : listaDeCargo) {
				this.listaCargo.add(new SelectItem(cargo.getIdCargo(), cargo.getNomeCargo()));
			}
		}
		return listaCargo;
	}

	/**
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaCargo(List<SelectItem> listaCargo) {
		this.listaCargo = listaCargo;
	}

}
