package cadastro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.GregorianCalendar;

import dados.Cliente;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

public class Cadastro {

	public static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	
	//Inclusão de cliente
	
	/**
	 * Responsavel por incluir um novo cliente
	 * @param Cliente codigo
	 * @return void
	 * @exception sem erro
	 */
	public static void incluirCliente (Cliente obj) {
		listaClientes.add(obj);
	}

	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param Cliente obj
	 * @return coid
	 * @exception Se houver venda cadastrada, nï¿½o sera excluida o cliente
	 */
	public static void excluirCliente (Cliente obj) {
		listaClientes.remove(obj);
	}
	
	/**
	 * Responsavel por pesquisar cliente via codigo
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception sem erro
	 */
	public static Cliente pesqClienteCod (int codigo) throws SisVendasException {
		for (Cliente obj : listaClientes) {
			if (obj.getCodigo() == codigo) {
				return obj;
			}
		}
		throw new SisVendasException("Nao existe Cliente para o coidgo.");
	}
	
	/**
	 * Responsavel por pesquisar cliente por cpf
	 * @param String cpf
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cpf
	 */
	public static Cliente pesqClienteCpf (String cpf) throws SisVendasException {
		for (Cliente obj : listaClientes) {
			if (obj.getCpf().equals(cpf)) {
				return obj;
			}
		}
		throw new SisVendasException("Nao existe Cliente para o cpf.");
	}
	
	/**
	 * Responsavel por pesquisar cliente via nome
	 * @param String nome
	 * @return resposta com a lista de clientes em ordem
	 * @exception Nï¿½o existe cliente para o nome.
	 */
	public static ArrayList<Cliente> pesqClienteNome (String nome) throws SisVendasException {
				ArrayList<Cliente> resposta = new ArrayList<Cliente>();
				for (Cliente objCliente : listaClientes) {
					if (objCliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
						resposta.add(objCliente);
					}
				}
				if (resposta.size() > 0) {
					// CLASSIFICAR A LISTA RESPOSTA PELO NOME DO SOCIO
					Collections.sort(resposta, new ClientePorNome());
					return resposta;
				}else {
					throw new SisVendasException("Nao existe Cliente para o nome.");
				}
	}
	
	//Inclusão de produto
		
	/**
	 * Responsavel por incluir um novo produto
	 * @param Produto obj
	 * @return void
	 * @exception sem erro
	 */
	public static void incluirProduto (Produto obj) {
		listaProdutos.add(obj);
	}
	
	/**
	 * Responsavel por excluir um produto 
	 * @param Produto obj
	 * @return void
	 * @exception sem erro
	 */
	public static void excluirProduto (Produto obj) {
		listaProdutos.remove(obj);
	}
	
	/**
	 * Responsavel por pesquisar um produto por codigo
	 * @param int codigo
	 * @return null caso seja invalido
	 * @exception sem erro
	 */
	public static Produto pesqProdutoCod (int codigo) throws SisVendasException{
		for (Produto obj : listaProdutos) {
			if (obj.getCodigo() == codigo) {
				return obj;
			}
		}
		throw new SisVendasException("Nao existe produto para o codigo.");
	}
	
	/**
	 * Responsavel por pesquisar o produto via nome 
	 * @param String nome
	 * @return resposta com a lista de produtos em ordem
	 * @exception Nï¿½o existe produto para o nome.
	 */ 
	public static ArrayList<Produto> pesqProdutoNome (String nome) throws SisVendasException {
		
			ArrayList<Produto> resposta = new ArrayList<Produto>();
			for (Produto objProduto : listaProdutos) {
				if (objProduto.getNome().toUpperCase().contains(nome.toUpperCase())) {
					resposta.add(objProduto);
				}
			}
			if (resposta.size() > 0) {
			// CLASSIFICAR A LISTA RESPOSTA PELO NOME DO SOCIO
				Collections.sort(resposta, new ProdutoPorNome());
				return resposta;
			} else {
				throw new SisVendasException("Nao existe produto para o nome.");
			}
	}

	//Inclusão de vendas
	
	/**
	 * Responsavel por incluir uma venda no sistema
	 * @param Venda obj
	 * @return void
	 * @exception sem erro
	 */
	public static void incluirVenda(Venda obj) {
		listaVendas.add(obj);
	}
	
	/**
	 * Responsavel por excluir uma venda do sistema
	 * @param Venda obj
	 * @return void
	 * @exception sem erro
	 */
	public static void excluirVenda (Venda obj) {
		listaVendas.remove(obj);
	}
	
	/**
	 * Responsavel por pesquisar a venda por codigo
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception sem erro
	 */
	public static Venda pesqVendaCod (int codigo)throws SisVendasException {
		for (Venda obj : listaVendas) {
			if (obj.getNumVenda() == codigo) {
				return obj;
			}
		}
		throw new SisVendasException("Nao existe produto para o codigo.");
	}
	
	public static boolean pesqVendaCliente(Cliente objCli)throws SisVendasException {
		for (Venda obj : listaVendas) {
			if (obj.getCliente() == objCli) {
				return false;
			} else {
				return true;
			}
		}
		throw new SisVendasException("Impossivel excluir cliente, venda cadastrada!.");
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	public static ArrayList<Venda> vendaClientePerido (GregorianCalendar data1, GregorianCalendar data2) throws SisVendasException {
		ArrayList<Venda> resposta = new ArrayList<Venda>();
		
		for(Venda obj : listaVendas) {
			if(obj.getDataVenda().compareTo(data1) >= 0 &&
					obj.getDataVenda().compareTo(data2) <= 0) {
				resposta.add(obj);
			}
		}
		if (resposta.size() > 0) {
			Collections.sort(resposta, new ordenaVendasCliente());
			return resposta;
		} else {	
			throw new SisVendasException("Não foi possivel encontrar vendas neste periodo!");
		}
	}
	
}

	//Classes afins

	class ClientePorNome implements Comparator<Cliente> {

		@Override
		public int compare(Cliente o1, Cliente o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
		
	}
	
	class ProdutoPorNome implements Comparator<Produto> {

		@Override
		public int compare(Produto o1, Produto o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
		
	}

	class ClientePorData implements Comparator<Cliente> {

		@Override
		public int compare(Cliente o1, Cliente o2) {
			return o1.getDataInclusao().compareTo(o2.getDataInclusao());
		}
		
	}
	
	class ordenaVendasCliente implements Comparator<Venda> {
		
		@Override
		public int compare(Venda obj1, Venda obj2) {
			int resp = obj1.getCliente().getNome().compareTo(obj2.getCliente().getNome());
			if(resp != 0) return resp;
			return obj1.getDataVenda().compareTo(obj2.getDataVenda());
		}
	}


