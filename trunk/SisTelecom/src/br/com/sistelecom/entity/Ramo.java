/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.entity;

/**
 *
 * @author Danilo Alves
 */
public class Ramo {
    
    private Integer idRamo;
    private String nomeRamo;
    private boolean status=true;

    public Ramo() {
    }

    public Ramo(Integer idRamo, String nomeRamo, Boolean status) {
        this.idRamo = idRamo;
        this.nomeRamo = nomeRamo;
        this.status = status;
    }

    public Integer getIdRamo() {
        return idRamo;
    }

    public void setIdRamo(Integer idRamo) {
        this.idRamo = idRamo;
    }

    public String getNomeRamo() {
        return nomeRamo;
    }

    public void setNomeRamo(String nomeRamo) {
        this.nomeRamo = nomeRamo;
    }

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
}
