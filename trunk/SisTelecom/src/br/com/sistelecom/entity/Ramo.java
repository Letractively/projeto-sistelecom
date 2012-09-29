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
    
    private int idRamo;
    private String nomeRamo;

    public Ramo() {
    }

    public Ramo(int idRamo, String nomeRamo) {
        this.idRamo = idRamo;
        this.nomeRamo = nomeRamo;
    }

    public int getIdRamo() {
        return idRamo;
    }

    public void setIdRamo(int idRamo) {
        this.idRamo = idRamo;
    }

    public String getNomeRamo() {
        return nomeRamo;
    }

    public void setNomeRamo(String nomeRamo) {
        this.nomeRamo = nomeRamo;
    }
    
}
