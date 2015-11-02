package dados;

import java.sql.Date;

public class Pessoa {

	private int codigo;
	private String nome;
	private String telefone;
	private Date nascimento;
	private String email;
	
	public Pessoa(int codigo, String nome, String telefone, Date nascimento,
			String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.email = email;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nResultado da busca por: " + nome
				+ "\nCodigo: " + codigo
				+ "\nNome: " + nome 
				+ "\nTelefone: " + telefone
				+ "\nData de nascimento: "+ nascimento
				+ "\nEmail: " + email
				+ "\n";
	}
}
