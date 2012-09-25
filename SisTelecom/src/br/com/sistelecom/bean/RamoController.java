/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.sistelecom.dao.RamoDAOImp;
import br.com.sistelecom.entity.Cargo;
import br.com.sistelecom.entity.Ramo;
import br.com.sistelecom.interfaces.dao.RamoDAO;

/**
 *
 * @author Danilo Alves
 */
public class RamoController {

    private List<SelectItem> listaRamos;
   
    private Ramo ramo;
    private DataModel modelRamo;

    public String novoRamo() {
        this.ramo = new Ramo();
        return "novoRamoOK";
    }

    public Ramo getRamo() {
    	if(this.ramo == null){
    		this.ramo = new Ramo();
    	}
        return ramo;
    }

    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }

    public DataModel getTodosProdutos() throws Exception {
        RamoDAO ramodao = new RamoDAOImp();
        modelRamo = new ListDataModel(ramodao.todosRamos());
        return modelRamo;
    }

    public Ramo getRamoAtualizarOuExcluir() {
        ramo = (Ramo) modelRamo.getRowData();
        return ramo;
    }

    public String atualizar() {
        ramo = getRamoAtualizarOuExcluir();
        setRamo(ramo);
        return "atualizarOK";
    }

    public String excluir() throws Exception {
        RamoDAO ramodao = new RamoDAOImp();
        ramo = getRamoAtualizarOuExcluir();
        ramodao.excluir(ramo);
        return "excluirOK";
    }

    public String salvar() throws Exception {
        RamoDAO ramodao = new RamoDAOImp();
        if (ramo.getIdRamo() == null) {
            ramodao.salvar(ramo);
        } else {
            ramodao.atualizar(ramo);
        }
        return "salvarOK";
    }
    
    public List<SelectItem> getListaRamos() throws Exception {
        final List<Ramo> ramos = this.getRamos();
       
        if(this.listaRamos == null){
            this.listaRamos = new LinkedList<SelectItem>();
        }
        
        for (Ramo ramo1 : ramos) {
            listaRamos.add(new SelectItem(ramo1.getIdRamo(),ramo1.getNomeRamo()));
        }
        return listaRamos;
    }

    public void setListaRamos(List<SelectItem> listaRamos) {
        this.listaRamos = listaRamos;
    }
    
    private List<Ramo> getRamos() throws Exception{
      RamoDAO ramodao = new RamoDAOImp();
      return ramodao.todosRamos();
    }

	public javax.faces.model.DataModel getModelRamo() {
		return modelRamo;
	}

	public void setModelRamo(javax.faces.model.DataModel modelRamo) {
		this.modelRamo = modelRamo;
	}
}
