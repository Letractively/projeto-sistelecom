package br.com.sistelecom.to;

/**
 * <p>Encapsula os dados dos produtos mais vendidos</p>
 * @author Danilo
 */
public class ProdutoTO {
	
	private String nomeProduto;

	/**
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * @param nomeProduto the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	@Override
	public String toString() {
		return this.nomeProduto == null ? "" : this.nomeProduto;
	}
	
}
