package br.com.sistelecom.entity;

public class VendaItem {
	
	private int idVenda;
	private int idItem;
	
	
	public VendaItem() {
		super();
	}
	
	public VendaItem(int idVenda, int idItem) {
		super();
		this.idVenda = idVenda;
		this.idItem = idItem;
	}
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
	

}
