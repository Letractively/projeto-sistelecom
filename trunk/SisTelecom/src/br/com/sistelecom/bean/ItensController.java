package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.ItemDAO;
import br.com.sistelecom.dao.ItemDAOImpl;
import br.com.sistelecom.dao.ProdutoDAOImpl;
import br.com.sistelecom.entity.Itens;

public class ItensController implements Controller<Itens>{
	
	private Itens item;
	private List<Itens> lista;
	private List<SelectItem> listaItens;
	private ItemDAO itensDAO = new ItemDAOImpl();
	private List<Integer> listaDeItensInseridos = new LinkedList<Integer>();
	
	public ItensController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getItem());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Item incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do item.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Itens>();
		this.setLista(this.getDao().listarTodos());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idItem = Integer.parseInt(id);

		final Itens item = this.getDao().obterPorId(idItem);

		this.getItem().setIdItens(item.getIdItens());
		this.getItem().setProduto(item.getProduto());
		this.getItem().setSituacao(item.getSituacao());
		this.getItem().setNumeroSA3(item.getNumeroSA3());
		this.getItem().setNumeroSiebel(item.getNumeroSiebel());
		this.getItem().setNumeroOS(item.getNumeroOS());
		this.getItem().setNumeroOIB2B(item.getNumeroOIB2B());
		this.getItem().setFidelidade(item.getFidelidade());
		this.getItem().setPrazo(item.getPrazo());
	}
	
	public void  salvarItens(final Itens item){
		try {
			final int id = this.getDao().salvarItem(item);
			this.getListaDeItensInseridos().add(new Integer(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarRegistro() {
		
		final int id = item.getIdItens();
		
		if (validarDadosFormulario()) {
			try {
				if(itensDAO.obterPorId(id) != null){
		
					this.getDao().atualizar(this.getItem());
					this.listarTodos();
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Item atualizado com sucesso.",""));
				}
				else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Item a ser atualizado não existe.",""));
				}
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do item.",""));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getItem().getIdItens() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
		
		this.limpar();
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idItem = Integer.parseInt(id);
		
		final Itens item = this.getDao().obterPorId(idItem);
		
		try {
			if(item != null){
				this.getDao().excluir(item);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Item excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do item.",""));
			e.printStackTrace();
		}
		
		this.limpar();
	}
	
	public boolean validarDadosFormulario() {
		if (this.getItem().getProduto() == 0 || this.getItem().getPrazo().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione pelo menos um produto.",""));
			return false;
		}
		return true;
	}
	
	public void limpar() {
		this.item = new Itens();
	}
	
	public ItemDAOImpl getDao() {
		return new ItemDAOImpl();
	}
	
	public void adicionarItem(ActionEvent evento){
		if(this.getLista() == null){
			this.lista = new LinkedList<Itens>();
		}
		
		final Random idTemporario = new Random();
		
		final Itens item = new Itens();
		item.setProduto(this.getItem().getProduto());
		item.setSituacao(this.getItem().getSituacao());
		item.setNumeroSA3(this.getItem().getNumeroSA3());
		item.setNumeroSiebel(this.getItem().getNumeroSiebel());
		item.setNumeroOIB2B(this.getItem().getNumeroOIB2B());
		item.setNumeroOS(this.getItem().getNumeroOS());
		item.setFidelidade(this.getItem().getFidelidade());
		item.setPrazo(this.getItem().getPrazo());
		item.setIdItens(Math.abs(idTemporario.nextInt()));
		
		this.getLista().add(item);
	}
	
	public void removerItem(ActionEvent evento){
		if(this.getLista() != null){
			int indice = 0;
			for (Itens item : this.getLista()) {
				if(item.getIdItens() == this.getItem().getIdItens()){
					this.getLista().remove(indice);
					break;
				}
				indice++;
			}	
		}
		
		//final ItensController itensController = (ItensController)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("itensController");
	}
	/**
	 * @return the item
	 */
	public Itens getItem() {
		if (this.item == null) {
			this.item= new Itens();
		}
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItens(Itens item) {
		this.item = item;
	}

	/**
	 * @return the lista
	 */
	public List<Itens> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Itens> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> getListaItens() {
		List<Itens> listaDeItens = itensDAO.listarTodos();
		
		if(this.listaItens == null){
			this.listaItens = new LinkedList<SelectItem>();
			for (Itens item : listaDeItens ) {
				this.listaItens.add(new SelectItem(item.getIdItens(), new ProdutoDAOImpl().obterPorId(item.getProduto()).getNomeProduto()));
			}
		}
		return listaItens;
	}

	/**
	 * @param listaRamo the listaRamo to set
	 */
	public void setListaItens(List<SelectItem> listaItens) {
		this.listaItens = listaItens;
	}

	/**
	 * @return the listaDeItensInseridos
	 */
	public List<Integer> getListaDeItensInseridos() {
		return listaDeItensInseridos;
	}

}
