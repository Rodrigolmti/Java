package dados;

import java.util.GregorianCalendar;

import sun.util.calendar.Gregorian;

/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:
/*
Atributos: codigo (int), nome (String), precoUnitario (double), dataInclusao (GregorianCalendar), dataUltAlteracao (GregorianCalendar). Todos com acesso privado, o c�digo do produto � um n�mero sequencial gerado pelo sistema;
M�todo construtor para inicializar os atributos por meio de par�metros;
M�todos get e set para obter e modificar cada um dos valores dos atributos.
M�todo toString retornando uma String com os atributos da classe formatados.

 */

public class Produto {
	
	private int codigo;
	private static int sequencia = 0;
	private String nome;
	private double precoUnitario;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataAlteracao;
	public Produto(String nome, double precoUnitario,
	GregorianCalendar dataInclusao, GregorianCalendar dataAlteracao) {
		super();
		codigo = sequencia++;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public GregorianCalendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(GregorianCalendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	public static void setSeq(int seq) {
		Produto.sequencia = seq;
	}
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome
				+ ", precoUnitario=" + precoUnitario + ", dataInclusao="
				+ dataInclusao + ", dataAlteracao=" + dataAlteracao + "]";
	}
	
}
