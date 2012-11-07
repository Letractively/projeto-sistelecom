package br.com.sistelecom.to;

/**
 * <p>Encapsula os dados dos produtos mais vendidos</p>
 * @author Danilo
 */
public class ProdutoTO implements Comparable<ProdutoTO>{
	
	private String nomeProduto;
	private int quantidade;

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
	
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return this.nomeProduto == null ? "" : this.nomeProduto;
	}

	public int compareTo(ProdutoTO o) {
		if(this.getQuantidade() == o.getQuantidade()){
			return 0;
		}else if(this.getQuantidade() > o.getQuantidade()){
			return 1;
		}else{
			return -1;
		}
	}

 }
