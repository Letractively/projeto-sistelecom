package br.com.sistelecom.entity;

import java.util.List;

public class Itens {
	
	private int idItens;
	private int produto;
	private String situacao;
	private long numeroSA3;
	private String numeroSiebel;
	private String numeroOS;
	private long numeroOIB2B;
	private String fidelidade;
	private String prazo;
	private List<Itens> listaDeItens;
	
	public Itens() {
		super();
	}

	public Itens(int idItens, int produto, String situacao, long numeroSA3,
			String numeroSiebel, String numeroOS, long numeroOIB2B, String fidelidade,
			String prazo) {
		super();
		this.idItens = idItens;
		this.produto = produto;
		this.situacao = situacao;
		this.numeroSA3 = numeroSA3;
		this.numeroSiebel = numeroSiebel;
		this.numeroOS = numeroOS;
		this.numeroOIB2B = numeroOIB2B;
		this.fidelidade = fidelidade;
		this.prazo = prazo;
	}

	/**
	 * @return the idItens
	 */
	public int getIdItens() {
		return idItens;
	}

	/**
	 * @param idItens the idItens to set
	 */
	public void setIdItens(int idItens) {
		this.idItens = idItens;
	}

	/**
	 * @return the produto
	 */
	public int getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(int produto) {
		this.produto = produto;
	}

	/**
	 * @return the situacao
	 */
	public String getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the numeroSA3
	 */
	public long getNumeroSA3() {
		return numeroSA3;
	}

	/**
	 * @param numeroSA3 the numeroSA3 to set
	 */
	public void setNumeroSA3(long numeroSA3) {
		this.numeroSA3 = numeroSA3;
	}

	/**
	 * @return the numeroSiebel
	 */
	public String getNumeroSiebel() {
		return numeroSiebel;
	}

	/**
	 * @param numeroSiebel the numeroSiebel to set
	 */
	public void setNumeroSiebel(String numeroSiebel) {
		this.numeroSiebel = numeroSiebel;
	}

	/**
	 * @return the numeroOS
	 */
	public String getNumeroOS() {
		return numeroOS;
	}

	/**
	 * @param numeroOS the numeroOS to set
	 */
	public void setNumeroOS(String numeroOS) {
		this.numeroOS = numeroOS;
	}

	/**
	 * @return the numeroOIB2B
	 */
	public long getNumeroOIB2B() {
		return numeroOIB2B;
	}

	/**
	 * @param numeroOIB2B the numeroOIB2B to set
	 */
	public void setNumeroOIB2B(long numeroOIB2B) {
		this.numeroOIB2B = numeroOIB2B;
	}

	/**
	 * @return the fidelidade
	 */
	public String getFidelidade() {
		return fidelidade;
	}

	/**
	 * @param fidelidade the fidelidade to set
	 */
	public void setFidelidade(String fidelidade) {
		this.fidelidade = fidelidade;
	}

	/**
	 * @return the prazo
	 */
	public String getPrazo() {
		return prazo;
	}

	/**
	 * @param prazo the prazo to set
	 */
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	/**
	 * @return the listaDeItens
	 */
	public List<Itens> getListaDeItens() {
		return listaDeItens;
	}

	/**
	 * @param listaDeItens the listaDeItens to set
	 */
	public void setListaDeItens(List<Itens> listaDeItens) {
		this.listaDeItens = listaDeItens;
	}
	

}
