package dados;

import java.io.Serializable;
import java.util.ArrayList;

import dados.ItemVenda;

import java.util.GregorianCalendar;
/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:/*
	Atributos: numVenda (int), cliente (Cliente), dataVenda (GregorianCalendar), 
	vendaItens (ArrayList<itemVenda>). Todos com acesso privado, o n�mero da venda � um n�mero sequencial gerado pelo sistema;
	M�todo construtor para inicializar os atributos por meio de par�metros;
	M�todos get e set para obter e modificar cada um dos valores dos atributos.
	M�todo toString retornando uma String com os atributos da classe formatados.
 */
public class Venda implements Serializable{
		
	private int numVenda;
	private static int sequencia = 0;
	private	Cliente cliente;
	private GregorianCalendar dataVenda;
	private ArrayList<ItemVenda> vendaItens = new ArrayList<ItemVenda>();
	
	public Venda(Cliente cliente, GregorianCalendar dataVenda, 
			ArrayList<ItemVenda> vendaItens) {
		super();
		this.cliente = cliente;
		this.dataVenda = dataVenda;
		this.vendaItens = vendaItens;
		numVenda = sequencia++;
		
	}

	public int getNumVenda() {
		return numVenda;
	}


	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}


	public ArrayList<ItemVenda> getItemVenda() {
		return vendaItens;
	}


	public void setItemVenda(ArrayList<ItemVenda> itemVenda) {
		this.vendaItens = vendaItens;
	}
	
	public static void setSeq(int seq) {
		Venda.sequencia = seq;
	}
	
	@Override
	public String toString() {
		return "Venda [numVenda=" + numVenda + ", cliente=" + cliente
				+ ", dataVenda=" + dataVenda + ", vendaItens=" + vendaItens + "]";
	}

}
