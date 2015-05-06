package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Dependente implements Serializable {
	
	private String nome;
	private GregorianCalendar nascimento;
	private String tipo;
	
	public Dependente(String nome, GregorianCalendar nascimento, String tipo) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public GregorianCalendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(GregorianCalendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return 
				"Nome: " + nome + "\n" +
				"Nascimento: " + LtpUtil.formatarData(nascimento, "dd/MM/yyyy") + "\n" +
				"Tipo: " + tipo + "\n";
		
	}
}
