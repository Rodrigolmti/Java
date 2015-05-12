package dados;

import java.util.ArrayList;

/*
 * •	Classe Devedor: –  pacote : dados
•	Atributos: cpf (String), nomeDevedor (String), listaDividas (ArrayList<Divida>). Todos com acesso privado;
•	Método construtor para inicializar os atributos por meio de parâmetros.
•	Métodos get e set para obter e modificar cada um dos valores dos atributos;
•	Métodos para pesquisar, adicionar e excluir divida do devedor.
•	Método toString para retornar os atributos formatados

 */

public class Devedor {
	private String cpf;
	private String nomeDevedor;
	private ArrayList<Divida> listaDividas = new ArrayList<Divida>();
	
	public Devedor(String cpf, String nomeDevedor,
			ArrayList<Divida> listaDividas) {
		super();
		this.cpf = cpf;
		this.nomeDevedor = nomeDevedor;
		this.listaDividas = listaDividas;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeDevedor() {
		return nomeDevedor;
	}
	public void setNomeDevedor(String nomeDevedor) {
		this.nomeDevedor = nomeDevedor;
	}
	public ArrayList<Divida> getListaDividas() {
		return listaDividas;
	}
	public void setListaDividas(ArrayList<Divida> listaDividas) {
		this.listaDividas = listaDividas;
	}
	
	@Override
	public String toString() {
		return "Devedor [cpf=" + cpf + ", nomeDevedor=" + nomeDevedor
				+ ", listaDividas=" + listaDividas + "]";
	}
	
}
