package br.com.sistelecom.entity;

public class Estado {
	
	private int idEstado;
	private String siglaUf;
	private String nomeEstado;
	
	public Estado() {
		
	}
	
	public Estado(int idEstado, String siglaUf, String nomeEstado) {
		super();
		this.idEstado = idEstado;
		this.siglaUf = siglaUf;
		this.nomeEstado = nomeEstado;
	}
	/**
	 * @return the idEstado
	 */
	public int getIdEstado() {
		return idEstado;
	}
	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	/**
	 * @return the siglaUf
	 */
	public String getSiglaUf() {
		return siglaUf;
	}
	/**
	 * @param siglaUf the siglaUf to set
	 */
	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}
	/**
	 * @return the nomeEstado
	 */
	public String getNomeEstado() {
		return nomeEstado;
	}
	/**
	 * @param nomeEstado the nomeEstado to set
	 */
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	
	

}
