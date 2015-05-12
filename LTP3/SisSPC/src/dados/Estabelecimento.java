package dados;

/*
 * •	Classe Estabelecimento: –  pacote : dados
•	Atributos: cnpj (String), nomeEmpresa (String. Todos com acesso privado;
•	Método construtor para inicializar os atributos por meio de parâmetros.
•	Métodos get e set para obter e modificar cada um dos valores dos atributos;
•	Método toString para retornar os atributos formatados

 */

public class Estabelecimento {

	private String cnpj;
	private String nomeEmpresa;
	
	public Estabelecimento(String cnpj, String nomeEmpresa) {
		super();
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	@Override
	public String toString() {
		return "Estabelecimento [cnpj=" + cnpj + ", nomeEmpresa=" + nomeEmpresa
				+ "]";
	}
	
}
