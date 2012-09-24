/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sistelecom.dao.FuncionarioDAOImp;
import br.com.sistelecom.entity.Funcionario;
import br.com.sistelecom.interfaces.dao.FuncionarioDAO;

/**
 *
 * @author Danilo Alves
 */
public class FuncionarioController {
    
    private Funcionario funcionario;
    private DataModel modelFuncionario;
    
    public String novoFuncionario() {
        this.funcionario = new Funcionario();
        return "novoFuncionarioOK";
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public DataModel getTodosFuncionarios () throws Exception {
        FuncionarioDAO funcionariodao = new FuncionarioDAOImp();
        modelFuncionario = new ListDataModel(funcionariodao.todosFuncionarios());
        return modelFuncionario;
    }
    
    public Funcionario getFuncionarioAtualizarOuExcluir() {
        funcionario = (Funcionario) modelFuncionario.getRowData();
        return funcionario;
    }
    
    public String update() {
        funcionario = getFuncionarioAtualizarOuExcluir();
        setFuncionario(funcionario);
        return "atualizarOK";
    }
    
    public String excluir() throws Exception {
        FuncionarioDAO funcionariodao = new FuncionarioDAOImp();
        funcionario = getFuncionarioAtualizarOuExcluir();
        funcionariodao.excluir(funcionario);
        return "excluirOK";
    }
    
    public String salvar() throws Exception {
        FuncionarioDAO funcionariodao = new FuncionarioDAOImp();
        if(funcionario.getIdFuncionario()==null) {
            funcionariodao.salvar(funcionario);
        }
        else{
            funcionariodao.atualizar(funcionario);
        }
        return "salvarOK";
    }

	public javax.faces.model.DataModel getModelFuncionario() {
		return modelFuncionario;
	}

	public void setModelFuncionario(javax.faces.model.DataModel modelFuncionario) {
		this.modelFuncionario = modelFuncionario;
	}   
}
