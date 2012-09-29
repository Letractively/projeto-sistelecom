package br.com.sistelecom.to;

public class FuncionarioTO {
	
	private boolean selecionado;
	private int id;
	private String nome;
	private String cpf;
	private int cargo;
	private int tel1;
	private int tel2;
	
	public FuncionarioTO() {
	
	}
	
	public FuncionarioTO(boolean selecionado, int id, String nome, String cpf, int cargo, int tel1, int tel2) {
		super();
		this.selecionado = selecionado;
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.tel1 = tel1;
		this.tel2 = tel2;
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

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the cargo
	 */
	public int getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the tel1
	 */
	public int getTel1() {
		return tel1;
	}

	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}

	/**
	 * @return the tel2
	 */
	public int getTel2() {
		return tel2;
	}

	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}
	

}
