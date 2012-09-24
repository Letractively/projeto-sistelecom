/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sistelecom.dao.DepartamentoDAOImp;
import br.com.sistelecom.entity.Departamento;
import br.com.sistelecom.interfaces.dao.DepartamentoDAO;

/**
 *
 * @author Danilo Alves
 */
public class DepartamentoController {
    
    private Departamento departamento;
    private DataModel modelDepartamento;
    
    public String novoDepartamento() {
        this.departamento = new Departamento();
        return "novoDepartamentoOK";
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }   
    
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }
    
    public DataModel getTodosDepartamentos() throws Exception {
        DepartamentoDAO departamentodao = new DepartamentoDAOImp();
        modelDepartamento = new ListDataModel(departamentodao.todosDepartamentos());
        return modelDepartamento;
    }
    
    public Departamento getDepartamentoAtualizarOuExcluir() {
        departamento = (Departamento) modelDepartamento.getRowData();
        return departamento;
    } 
    
    public String update() {
        departamento = getDepartamentoAtualizarOuExcluir();
        setDepartamento(departamento);
        return "atualizarOK";
    }
    
    public String excluir() throws Exception {
        DepartamentoDAO departamentodao = new DepartamentoDAOImp();
        departamento = getDepartamentoAtualizarOuExcluir();
        departamentodao.excluir(departamento);
        return "excluirOK";
    }
    
    public String create() throws Exception {
        DepartamentoDAO departamentodao = new DepartamentoDAOImp();
        if(departamento.getIdDepartamento()==null){
            departamentodao.salvar(departamento);
        }
        else{
            departamentodao.atualizar(departamento);
        }
        return "salvarOK";
    }
}
