package br.com.sistelecom.entidade.relatorio;

public class ClienteRelatorio {

	
	private int idCliente;
	private String cnpj;
	private String razaoSocial;
	private long tel1;
	private String nomeResp1;
	
	
	public ClienteRelatorio() {
		super();
	}
	
	public ClienteRelatorio(int idCliente, String cnpj, String razaoSocial, long tel1,
			String nomeResp1) {
		super();
		this.idCliente = idCliente;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.tel1 = tel1;
		this.nomeResp1 = nomeResp1;
	}
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}
	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	/**
	 * @return the tel1
	 */
	public long getTel1() {
		return tel1;
	}
	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(long tel1) {
		this.tel1 = tel1;
	}
	/**
	 * @return the nomeResp1
	 */
	public String getNomeResp1() {
		return nomeResp1;
	}
	/**
	 * @param nomeResp1 the nomeResp1 to set
	 */
	public void setNomeResp1(String nomeResp1) {
		this.nomeResp1 = nomeResp1;
	}
	
	
	
}
