package br.com.sistelecom.entity;

import java.util.Date;

public class Venda {
	
	private int idVenda;
	private int idCliente;
	private int idFuncionario;
	private int idItem;
	private Date dataVenda;
	
	/**
	 * @return the idVenda
	 */
	public int getIdVenda() {
		return idVenda;
	}
	/**
	 * @param idVenda the idVenda to set
	 */
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
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
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}
	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
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
