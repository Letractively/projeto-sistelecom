package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.dao.EstadoDAOImpl;
import br.com.sistelecom.entity.Estado;

public class EstadoController implements Controller<Estado>{
	
	private Estado estado;
	private List<Estado> lista;
	private List<SelectItem> listaEstado;
	private DAO<Estado> estadoDAO = new EstadoDAOImpl();
	
	public EstadoController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Estado>();
		this.setLista(this.getDao().listarTodos());
	}
	
	public void carregarRegistro(ActionEvent evento) {
	}
	
	public void atualizarRegistro() {
	}
	
	public void salvar(ActionEvent evento) {
	}
	
	public void excluirRegistro(ActionEvent evento) {
	}
	
	public boolean validarDadosFormulario() {
		return true;
	}
	
	public void limpar() {
		// TODO Auto-generated method stub
		
	}
	
	public EstadoDAOImpl getDao() {
		return new EstadoDAOImpl();
	}
	
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		if (this.estado == null) {
			this.estado = new Estado();
		}
		return estado;
	}
	
	/**
	 * @param cargo the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Estado> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> getListaEstado() {
		List<Estado> listaDeEstado = estadoDAO.listarTodos();
		
		if(this.listaEstado == null){
			this.listaEstado = new LinkedList<SelectItem>();
			for (Estado estado : listaDeEstado) {
				this.listaEstado.add(new SelectItem(estado.getIdEstado(), estado.getSiglaUf(), estado.getNomeEstado()));
			}
		}
		return listaEstado;
	}

	/**
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaEstado(List<SelectItem> listaEstado) {
		this.listaEstado = listaEstado;
	}

}
