package br.com.sistelecom.entidade.relatorio;

public class CargoRelatorio {
	
	private int idCargo;
	private String nomeCargo;
	
	
	public CargoRelatorio() {
		super();
	}
	
	public CargoRelatorio(int idCargo, String nomeCargo) {
		super();
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
	}
	/**
	 * @return the idCargo
	 */
	public int getIdCargo() {
		return idCargo;
	}
	/**
	 * @param idCargo the idCargo to set
	 */
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	/**
	 * @return the nomeCargo
	 */
	public String getNomeCargo() {
		return nomeCargo;
	}
	/**
	 * @param nomeCargo the nomeCargo to set
	 */
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
