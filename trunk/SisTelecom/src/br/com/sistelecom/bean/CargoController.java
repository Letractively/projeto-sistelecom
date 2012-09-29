/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.sistelecom.dao.CargoDAOImpl;
import br.com.sistelecom.dao.RamoDAOImpl;
import br.com.sistelecom.entity.Cargo;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.to.RamoTO;

/**
 *
 * @author Danilo Alves
 */

public class CargoController extends Controller<Cargo> {

	private Cargo cargo;
	private List<RamoTO> lista;
	
	public CargoController() {
		this.carregarDadosNaTela();
	}
	
	@Override
	public void carregarDadosNaTela() {
		if(this.getLista() == null){
			this.listarTodos();
		}
	}
	
	@Override
	public void novoRegistro(ActionEvent evento) {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getCargo());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Cargo incluído com sucesso."));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(e.getMessage()));
				return;
			}
		}
	}
	
	@Override
	public void listarTodos() {
		this.lista = new LinkedList<RamoTO>();
		this.setLista(this.getDao().todosRamosParaExibirEmTabela());
	}
	
	@Override
	public void carregarRegistro(ActionEvent evento) {
		int idCargo = this.getCargo().getIdCargo();

		final Cargo cargo = this.getDao().obterPorId(idCargo);

		this.getCargo().setIdCargo(cargo.getIdCargo());
		this.getCargo().setNomeCargo(cargo.getNomeCargo());
	}
	
	@Override
	public void excluirRegistro(ActionEvent actionEvent) {
		int idCargo = this.getCargo().getIdCargo();
		
		final Cargo cargo = this.getDao().obterPorId(idCargo);
		try {
			this.getDao().excluir(cargo);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(e.getMessage()));
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Ramo excluído com sucesso."));
	}
	
	@Override
	public boolean validarDadosFormulario() {
		if (this.getCargo().getNomeCargo().equals("")) {
			
			return false;
		}
		return true;
	}
	
	@Override
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
	
}
