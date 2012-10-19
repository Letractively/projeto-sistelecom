package br.com.sistelecom.entidade.relatorio;

import java.util.Date;

public class ProdutoRelatorio {
	
	private int idProduto;
	private String nomeProduto;
	private String tipo;
	private float valorReceita;
	private Date criacao;
	
	
	public ProdutoRelatorio() {
		super();
	}
	
	public ProdutoRelatorio(int idProduto, String nomeProduto, String tipo,
			float valorReceita, Date criacao) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.tipo = tipo;
		this.valorReceita = valorReceita;
		this.criacao = criacao;
	}
	/**
	 * @return the idProduto
	 */
	public int getIdProduto() {
		return idProduto;
	}
	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	/**
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}
	/**
	 * @param nomeProduto the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the valorReceita
	 */
	public float getValorReceita() {
		return valorReceita;
	}
	/**
	 * @param valorReceita the valorReceita to set
	 */
	public void setValorReceita(float valorReceita) {
		this.valorReceita = valorReceita;
	}
	/**
	 * @return the criacao
	 */
	public Date getCriacao() {
		return criacao;
	}
	/**
	 * @param criacao the criacao to set
	 */
	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}
	
	

}
