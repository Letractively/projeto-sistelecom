/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.entity;

/**
 *
 * @author Danilo Alves
 */
public class Departamento {
    
    private Integer idDepartamento;
    private String nomeDepartamento;
    private String gerenteDepartamento;

    public Departamento(Integer idDepartamento, String nomeDepartamento, String gerenteDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
        this.gerenteDepartamento = gerenteDepartamento;
    }

    public Departamento() {
    }
    
    /**
     * @return the idDepartamento
     */
    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the nomeDepartamento
     */
    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    /**
     * @param nomeDepartamento the nomeDepartamento to set
     */
    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    /**
     * @return the gerenteDepartamento
     */
    public String getGerenteDepartamento() {
        return gerenteDepartamento;
    }

    /**
     * @param gerenteDepartamento the gerenteDepartamento to set
     */
    public void setGerenteDepartamento(String gerenteDepartamento) {
        this.gerenteDepartamento = gerenteDepartamento;
    }
    
}
