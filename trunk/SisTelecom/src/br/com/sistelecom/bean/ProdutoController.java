package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.ProdutoDAOImpl;
import br.com.sistelecom.entity.Produto;

public class ProdutoController implements Controller<Produto>{
	
	private Produto produto;
	private List<Produto> lista;
	private List<SelectItem> listaProduto;
	
	public ProdutoController(){
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getProduto());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do produto.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<Produto>();
		this.setLista(this.getDao().listarTodos());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idProduto = Integer.parseInt(id);

		final Produto produto = this.getDao().obterPorId(idProduto);

		this.getProduto().setIdProduto(produto.getIdProduto());
		this.getProduto().setNomeProduto(produto.getNomeProduto());
		this.getProduto().setTipo(produto.getTipo());
		this.getProduto().setValorReceita(produto.getValorReceita());
		this.getProduto().setCriacao(produto.getCriacao());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getProduto());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto atualizado com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do produto.",""));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getProduto().getIdProduto() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
		this.limpar();
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idProduto = Integer.parseInt(id);
		
		final Produto produto = this.getDao().obterPorId(idProduto);
		
		try {
			if(produto != null){
				this.getDao().excluir(produto);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do produto.",""));
			e.printStackTrace();
		}
		this.limpar();
	}
	
	public boolean validarDadosFormulario() {
		if (this.getProduto().getNomeProduto() == null || this.getProduto().getNomeProduto().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o nome do produto.",""));
			return false;
		}
		return true;
	}
	
	public void limpar() {
		this.produto = new Produto();
	}
	
	public ProdutoDAOImpl getDao() {
		return new ProdutoDAOImpl();
	}
	
	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		if (this.produto == null) {
			this.produto = new Produto();
		}
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> listaProduto() {
		
		final List<Produto> listaDeProduto = new ProdutoDAOImpl().listarTodos();
		
		final List<SelectItem> produtos = new LinkedList<SelectItem>();
		
		if(listaDeProduto != null){
			for (Produto produto : listaDeProduto) {
				produtos.add(new SelectItem(produto.getIdProduto(), produto.getNomeProduto(), produto.getTipo()));
			}
		}
		
		return produtos;
	}
	
	/**
	 * @return the listaCliente
	 */
	public List<SelectItem> getListaProduto() {
		this.listaProduto = this.listaProduto();
		return listaProduto;
	}

	/**
	 * @param listaProduto the listaProduto to set
	 */
	public void setListaProduto(List<SelectItem> listaProduto) {
		this.listaProduto = listaProduto;
	}

}
