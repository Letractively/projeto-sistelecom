package br.com.sistelecom.entidade.relatorio;

import java.util.Date;

public class FuncionarioRelatorio {
	
	private int idFuncionario;
	private String nome;
	private long tel1;
	private String email;
	private Date admissao;
	private String status;
	private String login;
	
	
	public FuncionarioRelatorio() {
		super();
	}
	
	public FuncionarioRelatorio(int idFuncionario, String nome, long tel1,
			String email, Date admissao, String status, String login) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.tel1 = tel1;
		this.email = email;
		this.admissao = admissao;
		this.status = status;
		this.login = login;
	}
	
	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}
	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the admissão
	 */
	public Date getAdmissao() {
		return admissao;
	}
	/**
	 * @param admissão the admissão to set
	 */
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

}
