package br.com.sistelecom.entity;

import java.util.Date;

public class RegVenda {
	
	private int idRegVenda;
	private int cliente;
	private int funcionario;
	private int itens;
	private Date dataVenda;
	
	public RegVenda() {
		super();
	}

	public RegVenda(int idRegVenda, int cliente, int funcionario, int itens,
			Date dataVenda) {
		super();
		this.idRegVenda = idRegVenda;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.itens = itens;
		this.dataVenda = dataVenda;
	}

	/**
	 * @return the idRegVenda
	 */
	public int getIdRegVenda() {
		return idRegVenda;
	}

	/**
	 * @param idRegVenda the idRegVenda to set
	 */
	public void setIdRegVenda(int idRegVenda) {
		this.idRegVenda = idRegVenda;
	}

	/**
	 * @return the cliente
	 */
	public int getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the funcionario
	 */
	public int getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the itens
	 */
	public int getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(int itens) {
		this.itens = itens;
	}

	/**
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}

	/**
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	

}
