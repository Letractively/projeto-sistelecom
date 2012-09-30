package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import br.com.sistelecom.dao.CidadeDAOImpl;
import br.com.sistelecom.entity.Cidade;

public class CidadeController {
	
	private Cidade cidade;
	private List<Cidade> lista;
	
	public CidadeController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Cidade>();
		this.setLista(this.getDao().listarTodos());
	}
	
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

}
