package cadastro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collection;
import java.util.GregorianCalendar;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import usuario.Apresenta;
import utilitarios.Console;
import utilitarios.LtpUtil;
import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;


/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:
 *  Atributos: clientes (lista de Clientes), produtos (lista de Produtos), e lista de vendas (lista de Vendas). As listas devem ser implementadas usando a classe ArrayList. Todas est�ticas e com visibilidade publica;
	Lista de Clientes
	M�todo para incluir um novo cliente. Par�metro o cliente;
	M�todo para excluir um cliente da lista de clientes. Par�metro o cliente.
	M�todo para buscar o cliente pelo c�digo. Par�metro o c�digo. Retornar a mensagem �N�o existe cliente para o c�digo� para o caso de n�o achar o cliente, em um objeto SisVendasException.
	M�todo para buscar o cliente pelo cpf. Par�metro o cpf. Retornar a mensagem �N�o existe cliente para o cpf� para o caso de n�o achar o cliente, em um objeto SisVendasException.
	M�todo para obter lista de clientes em ordem alfab�tica pelo nome ou por parte do nome do cliente. Retornar a mensagem �N�o existe nenhum cliente para o nome� para o caso de n�o achar nenhum cliente, em um objeto SisVendasException.
	Lista de Produtos
	M�todo para incluir um novo produto. Par�metro o produto;
	M�todo para excluir um produto da lista de produtos. Par�metro o produto.
	M�todo para buscar o produto pelo c�digo. Par�metro o c�digo. Retornar a mensagem �N�o existe produto para o c�digo� para o caso de n�o achar o produto, em um objeto SisVendasException.
	M�todo para obter lista de produtos em ordem alfab�tica pelo nome ou por parte do nome do produto. Retornar a mensagem �N�o existe nenhum produto para o nome� para o caso de n�o achar nenhum produto, em um objeto SisVendasException.
	Lista de Vendas
	M�todo para incluir uma nova venda. Par�metro a venda;
	M�todo para excluir uma venda da lista de vendas. Par�metro a venda.
	M�todo para buscar a venda pelo c�digo. Par�metro o c�digo. Retornar a mensagem �N�o existe venda para o c�digo� para o caso de n�o achar a venda, em um objeto SisVendasException.
	M�todo para buscar as vendas para o cliente em ordem descendente do c�digo da venda. Par�metro o cliente. Retornar a mensagem �N�o existe nenhuma venda para o cliente� para o caso de n�o achar nenhuma venda, em um objeto SisVendasException.
	M�todo para obter lista de vendas em ordem do nome do cliente e data da venda decrescente. Par�metro: per�odo das vendas;
	M�todo para obter a Estat�stica de Vendas por cliente em ordem alfab�tica (Nome do cliente, quantas vezes comprou no per�odo e valor total da compras no per�odo). Par�metro: per�odo das vendas. Retorno: Lista EstatisticaClientes.
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
		getListaClientes().add(obj);
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param Cliente obj
	 * @return coid
	 * @exception Se houver venda cadastrada, n�o sera excluida o cliente
	 */
	public void excluirCliente (Cliente obj) {
		getListaClientes().remove(obj);
	}
	
	/**
	 * Responsavel por pesquisar cliente via codigo
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception sem erro
	 */
	public static Cliente pesqClienteCod (int codigo) {
		for (Cliente obj : getListaClientes()) {
			if (obj.getCodigo() == codigo) {
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * Responsavel por pesquisar cliente por cpf
	 * @param String cpf
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cpf
	 */
	public static Cliente pesqClienteCpf (String cpf) {
		for (Cliente obj : getListaClientes()) {
			if (obj.getCpf().equals(cpf)) {
				return obj;
			}
		}
		System.out.println("Cpf não encontrado");
		return null;
	}
	
	/**
	 * Responsavel por pesquisar cliente via nome
	 * @param String nome
	 * @return resposta com a lista de clientes em ordem
	 * @exception sem erro
	 */
	public static ArrayList<Cliente> pesqClienteNome (String nome) {
		ArrayList<Cliente> resposta = new ArrayList<Cliente>();
		for (Cliente objCliente : listaClientes) {
			if (objCliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resposta.add(objCliente);
			}
		}
		// CLASSIFICAR A LISTA RESPOSTA PELO NOME DO SOCIO
		Collections.sort(resposta, new ClientePorNome());
		return resposta;
	}
	
	/**
	 * Responsavel por pesquisar o produto via nome 
	 * @param String nome
	 * @return resposta com a lista de produtos em ordem
	 * @exception sem erro
	 */
	public static ArrayList<Produto> pesqProdutoNome (String nome) {
		ArrayList<Produto> resposta = new ArrayList<Produto>();
		for (Produto objProduto : listaProdutos) {
			if (objProduto.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resposta.add(objProduto);
			}
		}
		// CLASSIFICAR A LISTA RESPOSTA PELO NOME DO SOCIO
		Collections.sort(resposta, new ProdutoPorNome());
		return resposta;
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
	
	/**
	 * Responsavel pelo metodo get do arrayList de clientes
	 * @param sem parametro
	 * @return return listaClientes
	 * @exception sem erro
	 */
	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**
	 * Responsavel pelo metodo set do arrayList de clientes
	 * @param ArrayList<Cliente listaClientes>
	 * @return void
	 * @exception sem erro 
	 * 
	 */
	public static void setListaClientes(ArrayList<Cliente> listaClientes) {
		Cadastro.listaClientes = listaClientes;
	}
	
	public static ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public static void setListaProdutos(ArrayList<Produto> listaProdutos) {
		Cadastro.listaProdutos = listaProdutos;
	}

	public static ArrayList<Venda> getListaVendas() {
		return listaVendas;
	}

	public static void setListaVendas(ArrayList<Venda> listaVendas) {
		Cadastro.listaVendas = listaVendas;
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
