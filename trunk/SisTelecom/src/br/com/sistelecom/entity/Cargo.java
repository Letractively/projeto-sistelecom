/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.entity;

/**
 *
 * @author Danilo Alves
 */
public class Cargo {
 
    private Integer idCargo;
    private String nomeCargo;

    public Cargo() {
    }
    
    public Cargo(Integer idCargo, String nomeCargo) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
    }
    
    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }
    
}
