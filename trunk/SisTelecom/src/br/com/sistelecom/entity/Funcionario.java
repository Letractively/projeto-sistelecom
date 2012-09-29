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
	private Integer departamento;
	private String nome;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private Integer cidade;
	private Integer uf;
	private Integer cep;
	private Date nasc;
	private Integer tel1;
	private Integer tel2;
	private Integer doc;
	private String tipoDoc;
	private Integer cargo;
	private String supervFuncao;
	private String supervNome;
	private Date admissao;
	private String status;
	private String login;
	private String password;

	public Funcionario() {
	}

	public Funcionario(Integer idFuncionario, String cpf, Integer departamento,
			String nome, String logradouro, Integer numero, String complemento,
			String bairro, Integer cidade, Integer uf, Integer cep, Date nasc,
			Integer tel1, Integer tel2, Integer doc, String tipoDoc,
			Integer cargo, String supervFuncao, String supervNome,
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
		this.doc = doc;
		this.tipoDoc = tipoDoc;
		this.cargo = cargo;
		this.supervFuncao = supervFuncao;
		this.supervNome = supervNome;
		this.admissao = admissao;
		this.status = status;
		this.login = login
				;
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

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public Integer getUf() {
		return uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public Integer getTel1() {
		return tel1;
	}

	public void setTel1(Integer tel1) {
		this.tel1 = tel1;
	}

	public Integer getTel2() {
		return tel2;
	}

	public void setTel2(Integer tel2) {
		this.tel2 = tel2;
	}

	public Integer getDoc() {
		return doc;
	}

	public void setDoc(Integer doc) {
		this.doc = doc;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public String getSupervFuncao() {
		return supervFuncao;
	}

	public void setSupervFuncao(String supervFuncao) {
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
