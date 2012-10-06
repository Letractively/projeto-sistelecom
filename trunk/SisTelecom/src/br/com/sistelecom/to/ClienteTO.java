package br.com.sistelecom.to;

public class ClienteTO {
	
	private boolean selecionado;
	private int id;
	private String cnpj;
	private String razaoSocial;
	private String nomeResp1;
	private long tel1;
	
	public ClienteTO() {
		super();
	}

	public ClienteTO(boolean selecionado, int id, String cnpj,
			String razaoSocial, String nomeResp1, long tel1) {
		super();
		this.selecionado = selecionado;
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeResp1 = nomeResp1;
		this.tel1 = tel1;
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
}
