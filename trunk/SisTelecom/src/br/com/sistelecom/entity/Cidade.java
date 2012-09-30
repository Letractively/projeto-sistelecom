package br.com.sistelecom.entity;

public class Cidade {
	
	private int idCidade;
	private int uf;
	private String nomeCidade;
	
	
	public Cidade() {
		super();
	}


	public Cidade(int idCidade, int uf, String nomeCidade) {
		super();
		this.idCidade = idCidade;
		this.uf = uf;
		this.nomeCidade = nomeCidade;
	}


	/**
	 * @return the idCidade
	 */
	public int getIdCidade() {
		return idCidade;
	}


	/**
	 * @param idCidade the idCidade to set
	 */
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}


	/**
	 * @return the uf
	 */
	public int getUf() {
		return uf;
	}


	/**
	 * @param uf the uf to set
	 */
	public void setUf(int uf) {
		this.uf = uf;
	}


	/**
	 * @return the nomeCidade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}


	/**
	 * @param nomeCidade the nomeCidade to set
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	
}
