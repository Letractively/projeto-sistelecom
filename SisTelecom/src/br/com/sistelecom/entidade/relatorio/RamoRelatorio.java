package br.com.sistelecom.entidade.relatorio;

public class RamoRelatorio {
	
	private int idRamo;
	private String nomeRamo;
	
	
	public RamoRelatorio() {
		super();
	}
	
	public RamoRelatorio(int idRamo, String nomeRamo) {
		super();
		this.idRamo = idRamo;
		this.nomeRamo = nomeRamo;
	}
	/**
	 * @return the idRamo
	 */
	public int getIdRamo() {
		return idRamo;
	}
	/**
	 * @param idRamo the idRamo to set
	 */
	public void setIdRamo(int idRamo) {
		this.idRamo = idRamo;
	}
	/**
	 * @return the nomeRamo
	 */
	public String getNomeRamo() {
		return nomeRamo;
	}
	/**
	 * @param nomeRamo the nomeRamo to set
	 */
	public void setNomeRamo(String nomeRamo) {
		this.nomeRamo = nomeRamo;
	}
	

}
