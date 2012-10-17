package br.com.sistelecom.entidade.relatorio;

public class ClienteRelatorio {

	
	private int id;
	private String nome;
	
	
	/**
	 * @param id
	 * @param nome
	 */
	public ClienteRelatorio(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
