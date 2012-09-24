/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.bean;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sistelecom.dao.CargoDAOImp;
import br.com.sistelecom.entity.Cargo;
import br.com.sistelecom.interfaces.dao.CargoDAO;

/**
 *
 * @author Danilo Alves
 */
public class CargoController {
    
    private Cargo cargo;
    private DataModel modelCargo;
    
    public String novoCargo(){
        this.cargo = new Cargo();
        return "novoCargoOK";
    }
    
    public Cargo getCargo(){
    	if(this.cargo == null){
    		this.cargo = new Cargo();
    	}
   
        return cargo;
    }
    
    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }
    
    public DataModel getTodosCargos() throws Exception {
        CargoDAO cargodao = new CargoDAOImp();
        modelCargo = new ListDataModel(cargodao.todosCargos());
        return modelCargo;
    }
    
    public Cargo getCargoAtualizarOuExcluir(){
        cargo = (Cargo) modelCargo.getRowData();
        return cargo;
    }
    
    public String atualizar() {
        cargo = getCargoAtualizarOuExcluir();
        setCargo(cargo);
        return "atualizarOK";
    }
    
    public String excluir() throws Exception {
        CargoDAO cargodao = new CargoDAOImp();
        cargo = getCargoAtualizarOuExcluir();
        cargodao.excluir(cargo);
        return "excluirOK";
    }
    
    public String salvar() throws Exception {
        CargoDAO cargodao= new CargoDAOImp();
        if(cargo.getIdCargo()==null){
            cargodao.salvar(cargo);
        }
        else{
            cargodao.atualizar(cargo);
        }
        return "salvarOK";
    }
}