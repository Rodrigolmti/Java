package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:
/*
 *  Classe Cliente: - pacote : dados
	Atributos: c�digo (int), cpf (String), nome (String), telefone (String), email (String), dataInclusao (GregorianCalendar), 
	dataUltAlteracao. Todos com acesso privado. O c�digo do cliente � um n� sequencial gerado pelo sistema.
	M�todo construtor para inicializar os atributos por meio de par�metros;
	M�todos get e set para obter e modificar cada um dos valores dos atributos.
	M�todo toString retornando uma String com os atributos da classe formatados
*/

public class Cliente {

	private int codigo;
	private static int sequencia = 0;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataAlteracao;
	
	public Cliente(String cpf, String nome, String telefone, String email
			,GregorianCalendar dataInclusao, GregorianCalendar dataAlteracao) {
		super();
		codigo = sequencia++;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public GregorianCalendar getDataAltaracao() {
		return dataAlteracao;
	}

	public void setDataAltaracao(GregorianCalendar dataAltaracao) {
		this.dataAlteracao = dataAltaracao;
	}
	
	public static void setSeq(int seq) {
		Cliente.sequencia = seq;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome
				+ ", telefone=" + telefone + ", email=" + email
				+ ", dataInclusao=" + dataInclusao + ", dataAltaracao="
				+ dataAlteracao + "]";
	}
	
}
