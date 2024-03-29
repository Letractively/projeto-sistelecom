package br.com.sistelecom.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.VendaDAOImpl;
import br.com.sistelecom.dao.VendaItemDAOImpl;
import br.com.sistelecom.entity.Itens;
import br.com.sistelecom.entity.Venda;
import br.com.sistelecom.entity.VendaItem;


public class VendaController implements Controller<Venda> {

	private Venda venda;
	private ItensController itensController;
	private static final String ITENS_CONTROLLER_NOME = "itensController";
	private int idCliente;
	private int idFuncionario;
	
	public VendaController(){
		this.listarTodos();
	}
	
	public void salvar(ActionEvent evento) {
		
		if(this.getVenda().getIdVenda() == 0){
			this.getItensController().setListaDeItensInseridos(new ArrayList<Integer>());
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
		
		this.limpar();
	}

	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				final Venda venda = new Venda();
				venda.setIdCliente(this.getIdCliente());
				venda.setIdFuncionario(this.getIdFuncionario());
				venda.setDataVenda(new Date());
				
				final ItensController controllerItem = this.getItensController();
				
				for(Itens item: this.getItensController().getLista()){
					controllerItem.salvarItens(item);	
				}
				
				final int idVenda = this.getDao().salvarVenda(venda);
				
				List<Integer> inseridos = this.getItensController().getListaDeItensInseridos();
				
				for (Integer idItemInserido : inseridos) {
					
					final VendaItem vendaItem = new VendaItem(); 
					vendaItem.setIdVenda(idVenda);
					vendaItem.setIdItem(idItemInserido);
					
					new VendaItemDAOImpl().salvar(vendaItem);
				}
				
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido incluído com sucesso.",""));
				this.limpar();
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do pedido.",""));
				return;
			}
		}
	}

	public void atualizarRegistro() {
		// TODO Auto-generated method stub
		
	}

	public void excluirRegistro(ActionEvent evento) {
		
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idVenda = Integer.parseInt(id);
		
		final Venda venda = this.getDao().obterPorId(idVenda);
		
		try {
			if(venda != null){
				this.getDao().excluir(venda);
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Pedido excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do pedido.",""));
			e.printStackTrace();
		}
		
		this.limpar();
	}

	public void listarTodos() {
		// TODO Auto-generated method stub
		
	}

	public void carregarRegistro(ActionEvent evento) {
		// TODO Auto-generated method stub
		
	}

	public boolean validarDadosFormulario() {
		
		if (this.getIdCliente() == 0 || this.getIdFuncionario() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Falta informar o cliente e/ou o consultor.",""));
			return false;
		}
		return true;
	}

	public void limpar() {
		// TODO Auto-generated method stub
		
	}

	public VendaDAOImpl getDao() {
		return new VendaDAOImpl();
	}
	
	
	/**
	 * @return the itensController
	 */
	public ItensController getItensController() {
		final ItensController ic = (ItensController)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ITENS_CONTROLLER_NOME);
		if(ic != null){
			this.itensController = ic;
		}
		
		return itensController;
	}

	/**
	 * @return the venda
	 */
	public Venda getVenda() {
		if(venda == null){
			this.venda = new Venda();
		}
		return venda;
	}

	/**
	 * @param venda the venda to set
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
}
