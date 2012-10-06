/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.entity;

import java.util.Date;

/**
 * 
 * @author Danilo Alves
 */
public class Funcionario {

	private Integer idFuncionario;
	private String cpf;
	private int departamento;
	private String nome;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private int cidade;
	private int uf;
	private long cep;
	private Date nasc;
	private long tel1;
	private long tel2;
	private String email;
	private long doc;
	private String tipoDoc;
	private int cargo;
	private int supervFuncao;
	private String supervNome;
	private Date admissao;
	private String status;
	private String login;
	private String password;

	public Funcionario() {
	}

	public Funcionario(Integer idFuncionario, String cpf, int departamento,
			String nome, String logradouro, int numero, String complemento,
			String bairro, int cidade, int uf, long cep, Date nasc,
			long tel1, long tel2, String email, long doc, String tipoDoc,
			int cargo, int supervFuncao, String supervNome,
			Date admissao, String status, String login,
			String password) {

		this.idFuncionario = idFuncionario;
		this.cpf = cpf;
		this.departamento = departamento;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.nasc = nasc;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email = email;
		this.doc = doc;
		this.tipoDoc = tipoDoc;
		this.cargo = cargo;
		this.supervFuncao = supervFuncao;
		this.supervNome = supervNome;
		this.admissao = admissao;
		this.status = status;
		this.login = login;
		this.password = password;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public int getUf() {
		return uf;
	}

	public void setUf(int uf) {
		this.uf = uf;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public long getTel1() {
		return tel1;
	}

	public void setTel1(long tel1) {
		this.tel1 = tel1;
	}

	public long getTel2() {
		return tel2;
	}

	public void setTel2(long tel2) {
		this.tel2 = tel2;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public long getDoc() {
		return doc;
	}

	public void setDoc(long doc) {
		this.doc = doc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public int getSupervFuncao() {
		return supervFuncao;
	}

	public void setSupervFuncao(int supervFuncao) {
		this.supervFuncao = supervFuncao;
	}

	public String getSupervNome() {
		return supervNome;
	}

	public void setSupervNome(String supervNome) {
		this.supervNome = supervNome;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
