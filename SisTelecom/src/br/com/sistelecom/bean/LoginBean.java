package br.com.sistelecom.bean;

import javax.faces.event.ActionEvent;


public class LoginBean {
	
	private String nome;
	private String senha;
	
	public void logar(ActionEvent actionEvent){
		System.out.println(actionEvent.getSource());
		System.out.println(this.nome);
		System.out.println(this.senha);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
