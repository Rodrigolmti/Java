package dados;

import java.io.Serializable;


/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:
/*
 Atributos: produto (Produto), precoUnitario (double), quantVenda (int), valorVenda (double).
 Todos com acesso privado;Método construtor para inicializar os atributos por meio de 
 parâmetros;
Métodos get e set para obter e modificar cada um dos valores dos atributos.
Método toString retornando uma String com os atributos da classe formatados
 */

public class ItemVenda implements Serializable{
	
	private Produto produto;
	private double precoUnitario;
	private int quantVenda;
	private double valorVenda;

	public ItemVenda(Produto produto, double precoUnitario, int quantVenda,
			double valorVenda) {
		super();
		this.produto = produto;
		this.precoUnitario = precoUnitario;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getQuantVenda() {
		return quantVenda;
	}

	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() {
		return "\nItens cadastrados na venda: \n"
				+ "Produto: " + produto + "\n" + 
				"Preco Unitario: " + precoUnitario + "\n" +
				"Quantidade: " + quantVenda + "\n" +
				"Valor venda: " + valorVenda + "\n";	
	}
	
}
