package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Socio implements Serializable{
	private int codigo;
	private String cpf;
	private String nome;
	private GregorianCalendar entrada;
	private GregorianCalendar saida;
	
	private ArrayList<Dependente> dependentes;
	
	private static int seq = 0;

	public Socio(String cpf, String nome, GregorianCalendar entrada,
			ArrayList<Dependente> dependentes) {
		codigo = ++seq;
		this.cpf = cpf;
		this.nome = nome;
		this.entrada = entrada;
		this.dependentes = dependentes;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GregorianCalendar getEntrada() {
		return entrada;
	}

	public void setEntrada(GregorianCalendar entrada) {
		this.entrada = entrada;
	}

	public GregorianCalendar getSaida() {
		return saida;
	}

	public void setSaida(GregorianCalendar saida) {
		this.saida = saida;
	}

	public int getCodigo() {
		return codigo;
	}

	public ArrayList<Dependente> getDependentes() {
		return dependentes;
	}

	public static void setSeq(int seq) {
		Socio.seq = seq;
	}
	public String toString() {
		return
				"Código: " + codigo + "\n" +
				"CPF: " + LtpUtil.formatarCPF(cpf) + "\n" +
				"Nome: " + nome + "\n" +
				"Entrada: " + LtpUtil.formatarData(entrada, "dd/MM/yyyy") + "\n" +
				"Saída: " + (saida==null?"":LtpUtil.formatarData(saida, "dd/MM/yyyy")) + "\n";
	}
}
