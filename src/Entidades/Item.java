package Entidades;

public class Item {
	private int quantidade;
	private Double preco;
	private Produto produto;
	
	public Item () {
	}
	public Item(int quantidade, Double preco, Produto produto) {

		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Produto getProduto() {
		return produto;
	}

	public Double subTotal () {
		return preco * quantidade ;
	}
	public String toString() {
		return produto.getNome() 
				+ ", $" 
				+ String.format("%.2f", preco) 
				+ ", Quantity: " 
				+ quantidade + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
	
}
