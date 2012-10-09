package br.com.sistelecom.entity;

public class Itens {
	
	private int idItens;
	private int produto;
	private String situacao;
	private int numeroSA3;
	private int numeroSiebel;
	private int numeroOS;
	private int numeroOIB2B;
	private String fidelidade;
	private String prazo;
	
	public Itens() {
		super();
	}

	public Itens(int idItens, int produto, String situacao, int numeroSA3,
			int numeroSiebel, int numeroOS, int numeroOIB2B, String fidelidade,
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
	public int getNumeroSA3() {
		return numeroSA3;
	}

	/**
	 * @param numeroSA3 the numeroSA3 to set
	 */
	public void setNumeroSA3(int numeroSA3) {
		this.numeroSA3 = numeroSA3;
	}

	/**
	 * @return the numeroSiebel
	 */
	public int getNumeroSiebel() {
		return numeroSiebel;
	}

	/**
	 * @param numeroSiebel the numeroSiebel to set
	 */
	public void setNumeroSiebel(int numeroSiebel) {
		this.numeroSiebel = numeroSiebel;
	}

	/**
	 * @return the numeroOS
	 */
	public int getNumeroOS() {
		return numeroOS;
	}

	/**
	 * @param numeroOS the numeroOS to set
	 */
	public void setNumeroOS(int numeroOS) {
		this.numeroOS = numeroOS;
	}

	/**
	 * @return the numeroOIB2B
	 */
	public int getNumeroOIB2B() {
		return numeroOIB2B;
	}

	/**
	 * @param numeroOIB2B the numeroOIB2B to set
	 */
	public void setNumeroOIB2B(int numeroOIB2B) {
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
	

}
