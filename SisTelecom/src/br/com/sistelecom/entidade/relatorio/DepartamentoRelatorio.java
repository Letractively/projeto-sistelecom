package br.com.sistelecom.entidade.relatorio;

public class DepartamentoRelatorio {
	
	private int idDepartamento;
	private String nomeDepartamento;
	private String gerenteDepartamento;
	
	
	public DepartamentoRelatorio() {
		super();
	}
	
	public DepartamentoRelatorio(int idDepartamento, String nomeDepartamento,
			String gerenteDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.nomeDepartamento = nomeDepartamento;
		this.gerenteDepartamento = gerenteDepartamento;
	}
	/**
	 * @return the idDepartamento
	 */
	public int getIdDepartamento() {
		return idDepartamento;
	}
	/**
	 * @param idDepartamento the idDepartamento to set
	 */
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	/**
	 * @return the nomeDepartamento
	 */
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	/**
	 * @param nomeDepartamento the nomeDepartamento to set
	 */
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	/**
	 * @return the gerenteDepartamento
	 */
	public String getGerenteDepartamento() {
		return gerenteDepartamento;
	}
	/**
	 * @param gerenteDepartamento the gerenteDepartamento to set
	 */
	public void setGerenteDepartamento(String gerenteDepartamento) {
		this.gerenteDepartamento = gerenteDepartamento;
	}

}
