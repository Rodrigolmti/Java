package dados;

/*
 * •	Classe Divida:  –  pacote : dados
•	Atributos: empresa (Estabelecimento), codDividaEmpresa (String), dataVencimento (GregorianCalendar), valorDivida (double), dataRegistro (GregorianCalendar). Todos com acesso privado;
•	Método construtor para inicializar os atributos por meio de parâmetros.
•	Métodos get e set para obter e modificar cada um dos valores dos atributos;
•	Método toString para retornar os atributos formatados

 */

import java.util.GregorianCalendar;

public class Divida {

	private Estabelecimento empresa;
	private String codDividaEmpresa;
	private GregorianCalendar dataVencimento;
	private double valorDivida;
	private GregorianCalendar dataRegistro;
	
	public Divida(Estabelecimento empresa, String codDividaEmpresa,
			GregorianCalendar dataVencimento, double valorDivida,
			GregorianCalendar dataRegistro) {
		super();
		this.empresa = empresa;
		this.codDividaEmpresa = codDividaEmpresa;
		this.dataVencimento = dataVencimento;
		this.valorDivida = valorDivida;
		this.dataRegistro = dataRegistro;
	}
	
	public Estabelecimento getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Estabelecimento empresa) {
		this.empresa = empresa;
	}
	public String getCodDividaEmpresa() {
		return codDividaEmpresa;
	}
	public void setCodDividaEmpresa(String codDividaEmpresa) {
		this.codDividaEmpresa = codDividaEmpresa;
	}
	public GregorianCalendar getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(GregorianCalendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public double getValorDivida() {
		return valorDivida;
	}
	public void setValorDivida(double valorDivida) {
		this.valorDivida = valorDivida;
	}
	public GregorianCalendar getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(GregorianCalendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	@Override
	public String toString() {
		return "Divida [empresa=" + empresa + ", codDividaEmpresa="
				+ codDividaEmpresa + ", dataVencimento=" + dataVencimento
				+ ", valorDivida=" + valorDivida + ", dataRegistro="
				+ dataRegistro + "]";
	}
	
}
