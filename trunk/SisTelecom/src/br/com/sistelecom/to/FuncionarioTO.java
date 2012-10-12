package br.com.sistelecom.to;

public class FuncionarioTO {
	
	private boolean selecionado;
	private int id;
	private String cpf;
	private int departamento;
	private String nomeDepartamento;
	private String nome;
	
	public FuncionarioTO() {
	
	}
	
	public FuncionarioTO(boolean selecionado, int id, String cpf, int departamento, String nomeDepartamento, String nome) {
		super();
		this.selecionado = selecionado;
		this.id = id;
		this.departamento = departamento;
		this.nomeDepartamento = nomeDepartamento;
		this.cpf = cpf;
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
	 * @return the departamento
	 */
	public int getDepartamento() {
		return departamento;
	}
	/**
	 * @param nome the departamento to set
	 */
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
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
