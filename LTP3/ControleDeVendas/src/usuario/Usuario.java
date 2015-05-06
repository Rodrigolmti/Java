package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpUtil;
import dados.Cliente;
import dados.Produto;
import dados.Venda;
import cadastro.Cadastro;

/**
 * 
 * @author Rodrigo
 * @version 1.0
 * @since 24/04/2015
 * Esta classe e responsavel por:
 *  Classe Usuário: - pacote : usuário – (Métodos estáticos e privativos com exceção do main)
	Método para apresentar um menu (interface de caracteres). Todos os métodos abaixo, com exceção do main, mais a opção para sair, devem ser chamados no menu. 
	Método para ler os dados armazenados em arquivo de objetos da lista de clientes, lista de produtos e lista de vendas);
	Método para gravar os dados em arquivo de objetos  da lista de clientes, lista de produtos e lista de vendas);
	Clientes
	Método para incluir um novo cliente. 
	Validações:
	Cpf :
	CPF tem que ser válido
	Não poderá ser cadastrado cliente com cpf já cadastrado anteriormente.
	Nome :
	Nome obrigatório com no mínimo duas palavras
	Telefone :
	Telefone obrigatório
	E-mail :
	O E-mail tem que ser válido
	Método para alterar o cliente via código.
	Validações:
	Não existe cliente para o código
	Exibir os dados do cliente e somente alterar o cliente após a confirmação do usuário.
	Validações:
	Cpf :
	CPF tem que ser válido
	Não poderá ser alterado o cpf se já existe outro cliente com cpf já cadastrado.
	Nome :
	Nome obrigatório com no mínimo duas palavras
	Telefone :
	Telefone obrigatório
	E-mail :
	O E-mail tem que ser válido
	Método para excluir um cliente via código. 
	Validações:
	Não existe cliente para o código
	O cliente não pode ser excluído se tiver alguma venda registrada para ele.
	Exibir os dados do cliente e somente excluir o cliente após a confirmação do usuário.
	Método para consultar o cliente via cpf;
	Método para consultar clientes em ordem alfabética pelo nome ou por parte do nome do cliente.
	Produtos
	Método para incluir um novo produto;
	Validações:
	Nome :
	Nome é obrigatório.
	Preço unitário
	O preço é obrigatório e maior que zero
	Método para alterar o produto via código.
	Validações:
	Não existe produto para o código
	Exibir os dados do produto e somente alterar o produto após a confirmação do usuário.
	Validações:
	Nome :
	Nome é obrigatório.
	Preço unitário
	O preço é obrigatório e maior que zero
	Método para excluir um produto via código;
	 Validações:
	Não existe produto para o código.
	O produto não pode ser excluído se tiver alguma venda registrada para ele.
	Exibir os dados do produto e somente excluir o produto após a confirmação do usuário.
	Método para consultar produtos em ordem alfabética pelo nome ou por parte do nome do produto.
	Vendas
	Método para incluir uma venda para um cliente;
	Validações da venda:
	Cliente :
	Não existe cliente para o CPF .
	Data da venda
	Data tem que ser válida
	Data da venda não pode ser maior que a data corrente
	Validações dos itens da venda:
	A venda tem que ter pelo menos um item
	Produto
	Não existe produto para o código
	Já existe o produto em outro item desta venda
	Quantidade	
	A quantidade tem que ser maior que zero
	Valor
	Valor = quantidade x preço unitário do produto
	Método para excluir uma venda de um cliente via código da venda;
	Validações:
	Não existe venda para o código.
	Exibir os dados da venda e somente excluir a venda após a confirmação do usuário.
	Método para consultar as vendas pelo período  em ordem de cliente e data da venda decrescente. 
	Validações:
	Período de venda inválido.
	Data inicial inválida, Data final inválida, Data inicial superior a Data final
	Método para consultar a Estatística de Vendas por cliente em ordem alfabética em um período de vendas (Nome, quantas vezes o cliente comprou no período e valor total das compras do cliente no período ) . 
	Validações:
	Período de venda inválido.
	Data inicial inválida, Data final inválida, Data inicial superior a Data final

 */

public class Usuario {
	public static void main(String args[]) {
	
			if (new File("Vendas.obj").exists() && new File("Clientes.obj").exists() && new File("Produtos.obj").exists()) {
				lerArqVendas();
				lerArqClientes();
				lerArqProdutos();
				int ultCod = Cadastro.listaVendas.get(Cadastro.listaVendas.size()-1).getNumVenda();
				int ultCod1 = Cadastro.listaClientes.get(Cadastro.listaClientes.size()-1).getCodigo();
				int ultCod2 = Cadastro.listaProdutos.get(Cadastro.listaProdutos.size()-1).getCodigo();
				Cliente.setSeq(ultCod);
				Venda.setSeq(ultCod1);
				Produto.setSeq(ultCod2);
			}
			menu();
			gravarArqVendas();
			gravarArqCliente();
			gravarArqProdutos();
			System.out.println("\nFinalizar...");
			System.exit(0);
		}

		/**
		 * Responsavel por gravar o arquivo do objeto cliente no sistema
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não consiga gravar o objeto
		 */
		private static void gravarArqCliente() {
			try {
				ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("Clientes.obj"));
				out.writeObject(Cadastro.listaClientes);
				out.close();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
				System.exit(2); // Termino por falha na gravação do arquivo
			}
			
		}
		
		/**
		 * Responsavel por gravar o arquivo do objeto produtos no sistema
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não consiga gravar o objeto
		 */
		private static void gravarArqProdutos() {
			try {
				ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("Produtos.obj"));
				out.writeObject(Cadastro.listaProdutos);
				out.close();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
				System.exit(2); // Termino por falha na gravação do arquivo
			}
			
		}
		
		/**
		 * Responsavel por gravar o arquivo do objeto vendas no sistema
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não consiga gravar o objeto
		 */
		private static void gravarArqVendas() {
			try {
				ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("Vendas.obj"));
				out.writeObject(Cadastro.listaVendas);
				out.close();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
				System.exit(2); // Termino por falha na gravação do arquivo
			}
			
		}

		/**
		 * Responsavel por ler o arquivo do objeto vendas no sistema
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não consiga ler o objeto
		 */
		private static void lerArqVendas() {
			try {
				ObjectInputStream inp = 
					new ObjectInputStream(new FileInputStream("Vendas.obj"));
				 Cadastro.listaVendas= (ArrayList<Venda>)inp.readObject();
				inp.close();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
				System.exit(1); // termino por falha na leitura do arquivo
			}
			
		}
		
		/**
		 * Responsavel por ler o arquivo do objeto produtos no sistema
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não consiga ler o objeto
		 */
		private static void lerArqProdutos() {
			try {
				ObjectInputStream inp = 
					new ObjectInputStream(new FileInputStream("Produtos.obj"));
				 Cadastro.listaProdutos= (ArrayList<Produto>)inp.readObject();
				inp.close();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
				System.exit(1); // termino por falha na leitura do arquivo
			}
			
		}
		
		/**
		 * Responsavel por ler o arquivo do objeto cliente no sistema
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não consiga ler o objeto
		 */
		private static void lerArqClientes() {
			try {
				ObjectInputStream inp = 
					new ObjectInputStream(new FileInputStream("Clientes.obj"));
				 Cadastro.listaClientes= (ArrayList<Cliente>)inp.readObject();
				inp.close();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
				System.exit(1); // termino por falha na leitura do arquivo
			}
			
		}
		
		/**
		 * Responsavel por apresentar um menu de opções ao cliente
		 * @param sem parametro
		 * @return void
		 * @exception Apresenta erro caso não a opção seja invalida
		 */
		private static void menu() {
			int opcao = 0;
			do {
				System.out.println("--------# Sistema de controle de vendas #--------");
				System.out.println("-1-Incluir novo cliente");
				System.out.println("-2-Alterar o cliente via codigo");
				System.out.println("-3-Excluir um cliente via codigo");
				System.out.println("-4-Consultar o cliente via cpf");
				System.out.println("-5-Consultar cliente em ordem alfabetica pelo nome");
				System.out.println("-6-Incluir um novo produto");
				System.out.println("-7-Alterar o produto via codigo");
				System.out.println("-8-Excluir o produto via codigo");
				System.out.println("-9-Consultar produto em ordem alfabetica pelo nome");
				System.out.println("-10-Incluir uma venda");
				System.out.println("-11-Excluir venda");
				System.out.println("-12-Consultar as vendas pelo periodo em ordem de cliente e data de venda");
				System.out.println("-13-Consultar estatisticas de venda por cliente");
				opcao = Console.readInt("Informe a opcao desejada: ");
				int codigo;
				switch (opcao) {
					case 1:
						incluirCliente();
						break;
					case 2:
						codigo = Console.readInt("Informe o codigo: ");//Terminar a alteração
						buscarPorCod(codigo);
						String valida = Console.readLine("VocÃª deseja alterar este cliente? ");
						System.out.println("Informe SIM OU NÃ‚O");
							if (valida.equalsIgnoreCase("SIM")) {
								buscarPorCod(codigo);
								alterarClienteCod(codigo);
							} else {
								break;
							}
						break;
					case 3:
						codigo = Console.readInt("Informe o codigo: ");
						buscarPorCod(codigo);
						String valida1 = Console.readLine("VocÃª deseja excluir este cliente? ");
						System.out.println("Informe SIM OU NÃ‚O");
							if (valida1.equalsIgnoreCase("SIM")) {
								buscarPorCod(codigo);
								excluirCliente(codigo);
								//Verificar isto
							} else {
								break;
							}
						break;
					case 4:
						String cpf = Console.readLine("Informe o cpf do cliente");
						if(!LtpUtil.validarCPF(cpf)) 
						{
							System.out.println("CPF invÃ¡lida");
						} else {
							buscarPorCpf(cpf);
						}
						break;
					case 5:
						pesqClienteNome();
						break;
					case 6:
						incluirProduto();
						break;
					case 7:
						codigo = Console.readInt("Informe o codigo: ");
						Cadastro.pesqProdutoCod(codigo);
						String valida2 = Console.readLine("VocÃª deseja alterar este produto? ");
						System.out.println("Informe SIM OU NÃ‚O");
							if (valida2.equalsIgnoreCase("SIM")) {
								pesqProdutoCod(codigo);
								alterarProduto();
							} else {
								break;
							}
						break;
					case 8:
						codigo = Console.readInt("Informe o codigo: ");//Verificar se tem venda cadastrada
						Cadastro.pesqProdutoCod(codigo);
						String valida3 = Console.readLine("VocÃª deseja excluir este produto? ");
						System.out.println("Informe SIM OU NÃ‚O");
							if (valida3.equalsIgnoreCase("SIM")) {
								pesqProdutoCod(codigo);
								excluirProdutoCod(codigo);
							} else {
								break;
							}
						break;
					case 9:
						pesqProdutoNome();
						break;
					case 10:
						incluirVenda();
						break;
					case 11:
						codigo = Console.readInt("Informe o codigo: ");//excluir venda
						Cadastro.pesqProdutoCod(codigo);
						String valida4 = Console.readLine("VocÃª deseja excluir esta venda? ");
						System.out.println("Informe SIM OU NÃ‚O");
							if (valida4.equalsIgnoreCase("SIM")) {
								excluirVendaCod(codigo);
							} else {
								break;
							}
						break;
					case 12:
						
						break;
					case 13:
						
						break;
					default:
						System.out.println("OpÃ§Ã£o invÃ¡lida!");
						break;
				}
			}while(opcao!=0);
		}
		
	
	/**
    * Responsavel por incluir um novo cliente no sistema
	* @param sem parametro
	* @return void
	* @exception Apresenta erro caso seja invalido: nome, cpf, telefone, e-mail e data de entrada
	*/
	public static void incluirCliente() {
		System.out.println("\n" + "Incluir um novo cliente no banco.");
		String cpf;
		while(true) 
		{
			cpf = Console.readLine("CPF: ");
			if(!LtpUtil.validarCPF(cpf)) 
			{
				System.out.println("CPF invÃ¡lida");
				continue;
			}
			Cliente objcliente = cadastro.Cadastro.pesqClienteCpf(cpf);
			if (objcliente!=null) 
			{
				System.out.println("JÃ¡ existe cliente para o CPF");
				continue;
			} else break;
		}
		String nome;
		String telefone;
		String email;
		while (true) 
		{
			nome = Console.readLine("Nome: ").trim();
			if (nome.isEmpty()) 
			{
				System.out.println("Falta informar o nome.");
			} else break;
		}
		while (true) 
		{
			telefone = Console.readLine("Telefone: ");
			if (telefone.isEmpty()) 
			{
				System.out.println("Falta informar o telefone.");
			} else break;
		}
		while (true) 
		{
			email = Console.readLine("E-mail: ");
			if (email.isEmpty()) 
			{
				System.out.println("Falta informar o e-mail.");
			} else break;
		}
		GregorianCalendar dataInclusao = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Data de cadastro: ");
			if(!LtpUtil.validarData(data, dataInclusao)) {
				System.out.println("Data invÃ¡lida.");
				continue;
			}
			if (dataInclusao.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(cpf, nome, telefone, email, dataInclusao, null));
		System.out.println("\nCliente cadastradono sistema.");
	}
	/**
	 * Responsavel por alterar um cliente no sistema
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome, cpf, telefone, e-mail e data de entrada
	 */
	private static void alterarClienteCod (int cod) {
		System.out.println("\n" + "Alterar um cliente no sistema.");
		String cpf;
		while(true) 
		{
			cpf = Console.readLine("CPF: ");
			if(!LtpUtil.validarCPF(cpf)) 
			{
				System.out.println("CPF invÃ¡lida");
				continue;
			}
			Cliente objcliente = cadastro.Cadastro.pesqClienteCpf(cpf);
			if (objcliente!=null) 
			{
				System.out.println("JÃ¡ existe cliente para o CPF");
				continue;
			} else break;
		}
		String nome;
		String telefone;
		String email;
		while (true) 
		{
			nome = Console.readLine("Nome: ").trim();
			if (nome.isEmpty()) 
			{
				System.out.println("Falta informar o nome.");
			} else break;
		}
		while (true) 
		{
			telefone = Console.readLine("Telefone: ");
			if (telefone.isEmpty()) 
			{
				System.out.println("Falta informar o telefone.");
			} else break;
		}
		while (true) 
		{
			email = Console.readLine("E-mail: ");
			if (email.isEmpty()) 
			{
				System.out.println("Falta informar o e-mail.");
			} else break;
		}
		GregorianCalendar dataInclusao = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Data de cadastro: ");
			if(!LtpUtil.validarData(data, dataInclusao)) {
				System.out.println("Data invÃ¡lida.");
				continue;
			}
			if (dataInclusao.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(cpf, nome, telefone, email, dataInclusao, null));
		System.out.println("\nCliente cadastradono sistema.");
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	private static Cliente excluirCliente(int codigo) {
		Cliente obj = cadastro.Cadastro.pesqClienteCod(codigo);
		if (obj != null) { 
			System.out.println(obj.toString());
		} else {
			System.out.println("NÃ£o existe cliente neste codigo");
		}
		return null;
	}
	
	/**
	 * Responsavel por buscar cliente via cpf
	 * @param String cpf
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cpf ou nao encontrado no sistema
	 */
	private static Cliente buscarPorCpf(String cpf) {
		Cliente obj = cadastro.Cadastro.pesqClienteCpf(cpf);
		if (obj != null) { 
			System.out.println(obj.toString());
		} else {
			System.out.println("NÃ£o existe cliente neste codigo");
		}
		return null;
	}
	
	/**
	 * Responsavel por buscar cliente via cod
	 * @param int Cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	private static Cliente buscarPorCod(int codigo) {
		Cliente obj = cadastro.Cadastro.pesqClienteCod(codigo);
		if (obj != null) { 
			System.out.println(obj.toString());
		} else {
			System.out.println("NÃ£o existe cliente neste codigo");
		}
		return null;
	}
	
	/**
	 * Responsavel por incluir um novo produto no sistema
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome e preco
	 */
	private static void incluirProduto() {
		while(true) {
			String nome = Console.readLine("Informe o nome do produto: ");
			if(nome.isEmpty()) {
				System.out.println("Falta informar um nome");
			} else break;
		}
		while(true) {
			double preco = Console.readDouble("Informe o preço do produto: ");
			if(preco < 0) {
				System.out.printf("\nInforme um preco maior que 0!");
				continue;
			}
			else {
				break;
			}
		}
	}
	/**
	 * Responsavel por alterar o produto
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome e preco
	 */
	private static void alterarProduto() {
		while(true) {
			String nome = Console.readLine("Informe o nome do produto: ");
			if(nome.isEmpty()) {
				System.out.println("Falta informar um nome");
			} else break;
		}
		while(true) {
			double preco = Console.readDouble("Informe o preço do produto: ");
			if(preco < 0) {
				System.out.printf("\nInforme um preco maior que 0!");
				continue;
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * Responsavel por excluir um produto no sistema
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod
	 */
	private static Produto excluirProdutoCod(int codigo) {//Verificar se tem venda cadastrada
		Produto obj = cadastro.Cadastro.pesqProdutoCod(codigo);
		if (obj != null) { 
			System.out.println(obj.toString());
			cadastro.Cadastro.excluirProduto(obj);
			System.out.println("O produto foi excluido com sucesso!");
		} else {
			System.out.println("NÃ£o existe cliente neste codigo");
		}
		return null;
	}
	
	/**
	 * Responsavel por pesquisar um produto por cod no sistema
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod
	 */
	private static Produto pesqProdutoCod(int codigo) {
		Produto obj = Cadastro.pesqProdutoCod(codigo);
		if (obj != null) { 
			System.out.println(obj.toString());
		} else {
			System.out.println("NÃ£o existe cliente neste codigo");
		}
		return null;
	}
	
	/**
	 * Responsavel por incluir uma venda no sistema
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: cpf data da venda e quantidade 
	 */
	private static void incluirVenda() {
		String cpf;
		while(true) 
		{
			cpf = Console.readLine("CPF: ");
			if(!LtpUtil.validarCPF(cpf)) 
			{
				System.out.println("CPF invÃ¡lida");
				continue;
			}
			Cliente objcliente = cadastro.Cadastro.pesqClienteCpf(cpf);
			if (!objcliente.equals(cpf)) 
			{
				System.out.println("Não existe cliente para o cpf");
				continue;
			} else break;
		}
		GregorianCalendar dataInclusao = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Informe a data de venda: ");
			if(!LtpUtil.validarData(data, dataInclusao)) {
				System.out.println("Data invÃ¡lida.");
				continue;
			}
			if (dataInclusao.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		while(true) {
			int quantidade = Console.readInt("Informe a quantidade de vendas: ");
			if (quantidade <= 0) {
				System.out.println("A quantidade tem que ser maior que zero!");
			}else {
				break;
			}
		}
		
		int valor;//VALOR = QUANTIDADE X VALOR DO PRODUTO;
	}
	
	/**
	 * Responsavel por excluir uma venda por cod
	 * @param int codigo
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod
	 */
	private static Venda excluirVendaCod(int codigo) {//Verificar se tem venda cadastrada
		Venda obj = Cadastro.pesqVendaCod(codigo);
		if (obj != null) { 
			System.out.println(obj.toString());
			cadastro.Cadastro.excluirVenda(obj);
			System.out.println("A venda foi excluida com sucesso!");
		} else {
			System.out.println("NÃ£o existe venda neste codigo");
		}
		return null;	}
	
	/**
	 * Responsavel por pesquisar cliente por nome
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome
	 */
	private static void pesqClienteNome() {
		System.out.println("\nPesquisa de Clientes pelo Nome\n");
		String nome = Console.readLine("Informe o nome ou parte do nome: ");
		ArrayList<Cliente> resp = Cadastro.pesqClienteNome(nome);
		if (resp.isEmpty()) {
			System.out.println("Não existe nehum cliente para o nome.");
		} else {
			for (Cliente objSocio : resp ) {
				System.out.println(objSocio.toString());
				
			}
		}
		
	}
	
	/**
	 * Responsavel por pesquisar produto por nome
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome
	 */
	private static void pesqProdutoNome() {
		System.out.println("\nPesquisa de Produto pelo Nome\n");
		String nome = Console.readLine("Informe o nome ou parte do nome: ");
		ArrayList<Produto> resp = Cadastro.pesqProdutoNome(nome);
		if (resp.isEmpty()) {
			System.out.println("Não existe nehum produto para o nome.");
		} else {
			for (Produto objProduto : resp ) {
				System.out.println(objProduto.toString());
				
			}
		}
		
	}
}