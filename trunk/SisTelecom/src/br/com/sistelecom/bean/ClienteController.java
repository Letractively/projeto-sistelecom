/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sistelecom.dao.ClienteDAOImp;
import br.com.sistelecom.dao.RamoDAOImp;
import br.com.sistelecom.entity.Cliente;
import br.com.sistelecom.interfaces.dao.ClienteDAO;
import br.com.sistelecom.interfaces.dao.RamoDAO;

/**
 *
 * @author Danilo Alves
 */
public class ClienteController {
    
    private Cliente cliente;
    
    private DataModel modelCliente;
    
    public String novoCliente() throws Exception{
    	
    	ClienteDAO clientedao = new ClienteDAOImp();
    	try {
			clientedao.salvar(this.getCliente());
			System.out.println("Salvo!");
		} catch (Exception e) {
			System.out.println("Não Salvo!");
		}
        return null;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente (Cliente cliente){
        this.cliente = cliente;
    }
    
    public DataModel getTodosClientes() throws Exception {
        ClienteDAO clientedao = new ClienteDAOImp();
        modelCliente = new ListDataModel(clientedao.todosClientes());
        return modelCliente;
    }
    
    public Cliente getClienteAtualizarOuExcluir() {
        cliente = (Cliente) modelCliente.getRowData();
        return cliente;
    }
    
    public String atualizar(){
        cliente = getClienteAtualizarOuExcluir();
        setCliente(cliente);
        return "atualizarOK";
    }
    
    public String excluir() throws Exception {
        ClienteDAO clientedao = new ClienteDAOImp();
        cliente = getClienteAtualizarOuExcluir();
        clientedao.excluir(cliente);
        return "excluirOK";
    }
    
    public String salvar() throws Exception {
        ClienteDAO clientedao = new ClienteDAOImp();
        if(cliente.getIdCliente()==null){
            clientedao.salvar(cliente);
        }
        else{
            clientedao.atualizar(cliente);
        }
        return "salvarOK";
    }

	public javax.faces.model.DataModel getModelCliente() {
		return modelCliente;
	}

	public void setModelCliente(javax.faces.model.DataModel modelCliente) {
		this.modelCliente = modelCliente;
	}
}
