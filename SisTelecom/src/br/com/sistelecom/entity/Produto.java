/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.entity;

import java.util.Date;

/**
 *
 * @author Danilo Alves
 */
public class Produto {
    
    private Integer idProduto;
    private String nomeProduto;
    private String tipo;
    private Integer valorReceita;
    private Date criacao;
    private String status;
    private Date auditoria;

    public Produto() {
    }

    public Produto(Integer idProduto, String nomeProduto, String tipo, Integer valorReceita, Date criacao, String status, Date auditoria) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipo = tipo;
        this.valorReceita = valorReceita;
        this.criacao = criacao;
        this.status = status;
        this.auditoria = auditoria;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValorReceita() {
        return valorReceita;
    }

    public void setValorReceita(Integer valorReceita) {
        this.valorReceita = valorReceita;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Date auditoria) {
        this.auditoria = auditoria;
    }
    
}
