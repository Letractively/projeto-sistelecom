package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import br.com.sistelecom.dao.CidadeDAOImpl;
import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.entity.Cidade;
import br.com.sistelecom.entity.Departamento;

public class CidadeController {
	
	private Cidade cidade;
	private List<Cidade> lista;
	private List<SelectItem> listaCidade;
	private DAO<Cidade> cidadeDAO = new CidadeDAOImpl();
	
	public CidadeController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Cidade>();
		this.setLista(this.getDao().listarTodos());
	}
	
	@SuppressWarnings("unused")
	public void listarCidadesPorUf(ValueChangeEvent event) throws AbortProcessingException {
		List<Cidade> cidade = this.getDao().listarCidadesPorUf(Integer.valueOf(event.getNewValue().toString()));
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
	
	public CidadeDAOImpl getDao() {
		return new CidadeDAOImpl();
	}
	
	/**
	 * @return the Cidade
	 */
	public Cidade getCidade() {
		if (this.cidade == null) {
			this.cidade = new Cidade();
		}
		return cidade;
	}
	
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> getListaCidade() {
		List<Cidade> listaDeCidade = cidadeDAO.listarTodos();
		
		if(this.listaCidade == null){
			this.listaCidade = new LinkedList<SelectItem>();
			for (Cidade cidade : listaDeCidade) {
				this.listaCidade.add(new SelectItem(cidade.getIdCidade(), String.valueOf(cidade.getUf()), cidade.getNomeCidade()));
			}
		}
		return listaCidade;
	}

	/**
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaCidade(List<SelectItem> listaCidade) {
		this.listaCidade = listaCidade;
	}

}
