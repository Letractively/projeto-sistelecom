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
    
    private int idProduto;
    private String nomeProduto;
    private String tipo;
    private float valorReceita;
    private Date criacao;

    public Produto() {
    }

    public Produto(int idProduto, String nomeProduto, String tipo, float valorReceita, Date criacao) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipo = tipo;
        this.valorReceita = valorReceita;
        this.criacao = criacao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
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

    public float getValorReceita() {
        return valorReceita;
    }

    public void setValorReceita(float valorReceita) {
        this.valorReceita = valorReceita;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
