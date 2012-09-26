package br.com.sistelecom.to;

public class RamoTO {

	private boolean selecionado;
	private int id;
	private String nome;
	
	public RamoTO() {
	
	}
	
	public RamoTO(boolean selecionado, int id, String nome) {
		super();
		this.selecionado = selecionado;
		this.id = id;
		this.nome = nome;
	}

	/**
	 * @return the selecionado
	 */
	public boolean isSelecionado() {
		return selecionado;
	}
	/**
	 * @param selecionado the selecionado to set
	 */
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
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
