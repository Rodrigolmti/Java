package cadastro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collection;
import java.util.GregorianCalendar;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import utilitarios.Console;
import utilitarios.LtpUtil;
import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;


/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:
 *  Atributos: clientes (lista de Clientes), produtos (lista de Produtos), e lista de vendas (lista de Vendas). As listas devem ser implementadas usando a classe ArrayList. Todas estáticas e com visibilidade publica;
	Lista de Clientes
	Método para incluir um novo cliente. Parâmetro o cliente;
	Método para excluir um cliente da lista de clientes. Parâmetro o cliente.
	Método para buscar o cliente pelo código. Parâmetro o código. Retornar a mensagem “Não existe cliente para o código” para o caso de não achar o cliente, em um objeto SisVendasException.
	Método para buscar o cliente pelo cpf. Parâmetro o cpf. Retornar a mensagem “Não existe cliente para o cpf” para o caso de não achar o cliente, em um objeto SisVendasException.
	Método para obter lista de clientes em ordem alfabética pelo nome ou por parte do nome do cliente. Retornar a mensagem “Não existe nenhum cliente para o nome” para o caso de não achar nenhum cliente, em um objeto SisVendasException.
	Lista de Produtos
	Método para incluir um novo produto. Parâmetro o produto;
	Método para excluir um produto da lista de produtos. Parâmetro o produto.
	Método para buscar o produto pelo código. Parâmetro o código. Retornar a mensagem “Não existe produto para o código” para o caso de não achar o produto, em um objeto SisVendasException.
	Método para obter lista de produtos em ordem alfabética pelo nome ou por parte do nome do produto. Retornar a mensagem “Não existe nenhum produto para o nome” para o caso de não achar nenhum produto, em um objeto SisVendasException.
	Lista de Vendas
	Método para incluir uma nova venda. Parâmetro a venda;
	Método para excluir uma venda da lista de vendas. Parâmetro a venda.
	Método para buscar a venda pelo código. Parâmetro o código. Retornar a mensagem “Não existe venda para o código” para o caso de não achar a venda, em um objeto SisVendasException.
	Método para buscar as vendas para o cliente em ordem descendente do código da venda. Parâmetro o cliente. Retornar a mensagem “Não existe nenhuma venda para o cliente” para o caso de não achar nenhuma venda, em um objeto SisVendasException.
	Método para obter lista de vendas em ordem do nome do cliente e data da venda decrescente. Parâmetro: período das vendas;
	Método para obter a Estatística de Vendas por cliente em ordem alfabética (Nome do cliente, quantas vezes comprou no período e valor total da compras no período). Parâmetro: período das vendas. Retorno: Lista EstatisticaClientes.
 */

public class Cadastro {

	public static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public static ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	
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
	 * @exception Se houver venda cadastrada, não sera excluida o cliente
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
		throw new SisVendasException("Não existe Cliente para o coidgo.");
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
		throw new SisVendasException("Não existe Cliente para o cpf.");
	}
	
	/**
	 * Responsavel por pesquisar cliente via nome
	 * @param String nome
	 * @return resposta com a lista de clientes em ordem
	 * @exception Não existe cliente para o nome.
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
					//Collections.sort(resposta, new ClientePorNome());
					return resposta;
				}else {
					throw new SisVendasException("Não existe Cliente para o nome.");
				}
	}
	
	/**
	 * Responsavel por pesquisar o produto via nome 
	 * @param String nome
	 * @return resposta com a lista de produtos em ordem
	 * @exception Não existe produto para o nome.
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
				//Collections.sort(resposta, new ProdutoPorNome());
				return resposta;
			} else {
				throw new SisVendasException("Não existe produto para o nome.");
			}
	}
	
	//Lista de produtos
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
		listaProdutos.remove(obj);//Verificar se tem venda cadastrada
	}
	
	/**
	 * Responsavel por pesquisar um produto por codigo
	 * @param int codigo
	 * @return null caso seja invalido
	 * @exception sem erro
	 */
	public static Produto pesqProdutoCod (int codigo) {
		for (Produto obj : listaProdutos) {
			if (obj.getCodigo() == codigo) {
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	public static void ordemAlfabeticaProduto (String nome) {
		
	}
	//Lista de Vendas
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
	public static Venda pesqVendaCod (int codigo) {
		for (Venda obj : listaVendas) {
			if (obj.getNumVenda() == codigo) {
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	public static void pesqVendaCliente (Cliente cliente) {
		
	}
	
	//Verficar o parametro ...
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	public static void pesqVendaClienteData () {
		
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	public static void estatisticaCliente (Cliente cliente) {
		
	}
	

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
}

