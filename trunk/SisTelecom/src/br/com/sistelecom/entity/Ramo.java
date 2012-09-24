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

    public Ramo() {
    }

    public Ramo(Integer idRamo, String nomeRamo) {
        this.idRamo = idRamo;
        this.nomeRamo = nomeRamo;
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
    
}
