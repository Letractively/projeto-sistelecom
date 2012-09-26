package br.com.sistelecom.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.sistelecom.dao.EstadoDAOImp;
import br.com.sistelecom.entity.Estado;
import br.com.sistelecom.interfaces.dao.EstadoDAO;

public class EstadoController {
	
	private List<SelectItem> listaEstados;
	
	private Estado estado;
	
	public Estado getEstado() {
		if(this.estado == null){
    		this.estado = new Estado();
    	}
        return estado;
    }
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<SelectItem> getListaEstados() throws Exception {
	        final List<Estado> estados = this.getEstados();
	       
	        if(this.listaEstados == null){
	            this.listaEstados = new LinkedList<SelectItem>();
	        }
	        
	        for (Estado estado1 : estados) {
	            listaEstados.add(new SelectItem(estado1.getIdEstado(),estado1.getSiglaUf(),estado1.getNomeEstado()));
	        }
	        return listaEstados;
	    }
	
    public void setListaEstados(List<SelectItem> listaEstados) {
        this.listaEstados = listaEstados;
    }
    
	
    private List<Estado> getEstados() throws Exception{
        EstadoDAO estadodao = new EstadoDAOImp();
        return estadodao.todosEstados();
      }

}
