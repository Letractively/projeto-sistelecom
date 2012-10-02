package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlActionParameter;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import br.com.sistelecom.dao.ClienteDAOImpl;
import br.com.sistelecom.dao.DAO;
import br.com.sistelecom.entity.Cliente;
import br.com.sistelecom.to.ClienteTO;

public class ClienteController implements Controller<Cliente>{
	
	private Cliente cliente;
	private List<ClienteTO> lista;
	private List<SelectItem> listaCliente;
	private DAO<Cliente> clienteDAO = new ClienteDAOImpl();
		
	public ClienteController() {
		this.listarTodos();
	}
	
	public void novoRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().salvar(this.getCliente());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente incluído com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na inclusão do cliente.",""));
				return;
			}
		}
	}
	
	public void listarTodos() {
		this.lista = new LinkedList<ClienteTO>();
		this.setLista(this.getDao().todosClientesParaExibirEmTabela());
	}
	
	public void carregarRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idCliente = Integer.parseInt(id);

		final Cliente cliente = this.getDao().obterPorId(idCliente);

		this.getCliente().setIdCliente(cliente.getIdCliente());
		this.getCliente().setCnpj(cliente.getCnpj());
		this.getCliente().setRazaoSocial(cliente.getRazaoSocial());
		this.getCliente().setNomeResp1(cliente.getNomeResp1());
		this.getCliente().setTel1(cliente.getTel1());
		this.getCliente().setTel2(cliente.getTel2());
	}
	
	public void atualizarRegistro() {
		if (validarDadosFormulario()) {
			try {
				this.getDao().atualizar(this.getCliente());
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente atualizado com sucesso.",""));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na atualização do cliente.",""));
				return;
			}
		}
	}
	
	public void salvar(ActionEvent evento) {
		if(this.getCliente().getIdCliente() == 0){
			this.novoRegistro();
		}else{
			this.atualizarRegistro();
		}
	}
	
	public void excluirRegistro(ActionEvent evento) {
		final String id = ((HtmlActionParameter)((HtmlAjaxCommandButton)evento.getSource()).getChildren().get(0)).getValue().toString();
		int idCliente = Integer.parseInt(id);
		
		final Cliente cliente = this.getDao().obterPorId(idCliente);
		
		try {
			if(cliente != null){
				this.getDao().excluir(cliente);
				this.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente excluído com sucesso.",""));
			}
		} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro na exclusão do cliente.",""));
			e.printStackTrace();
		}
	}
	
	public boolean validarDadosFormulario() {
		if (this.getCliente().getCnpj() == null || this.getCliente().getCnpj().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o CNPJ do cliente.",""));
			return false;
		}
		return true;
	}
	
	public ClienteDAOImpl getDao() {
		return new ClienteDAOImpl();
	}
	
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		if (this.cliente == null) {
			this.cliente= new Cliente();
		}
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the lista
	 */
	public List<ClienteTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<ClienteTO> lista) {
		this.lista = lista;
	}
	
	public List<SelectItem> getListaCliente() {
		List<Cliente> listaDeCliente = clienteDAO.listarTodos();
		
		if(this.listaCliente == null){
			this.listaCliente = new LinkedList<SelectItem>();
			for (Cliente cliente : listaDeCliente) {
				this.listaCliente.add(new SelectItem(cliente.getIdCliente(), cliente.getCnpj()));
			}
		}
		return listaCliente;
	}

	/**
	 * @param listaRamo the listaRamo to set
	 */
	public void setListaCliente(List<SelectItem> listaCliente) {
		this.listaCliente = listaCliente;
	}


}
