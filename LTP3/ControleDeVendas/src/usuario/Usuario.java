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
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;
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
	public static void main(String args[]) throws SisVendasException {
	
			if (new File("Vendas.obj").exists() && new File("Clientes.obj").exists() && new File("Produtos.obj").exists()) {
				
				int ultCod = Cadastro.listaVendas.get(Cadastro.listaVendas.size()-1).getNumVenda();
				lerArqVendas();
				Venda.setSeq(ultCod);
				int ultCod1 = Cadastro.listaClientes.get(Cadastro.listaClientes.size()-2).getCodigo();
				lerArqClientes();
				Cliente.setSeq(ultCod1);
				int ultCod2 = Cadastro.listaProdutos.get(Cadastro.listaProdutos.size()-3).getCodigo();
				lerArqProdutos();
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
				 Cadastro.listaVendas = (ArrayList<Venda>)inp.readObject();
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
		 * @throws SisVendasException 
		 * @exception Apresenta erro caso não a opção seja invalida
		 */
		private static void menu()  {
			int opcao = 0;
			do {
				System.out.println("\t\t--------# SISTEMA DE CONTROLE DE VENDAS #--------\n");
				System.out.println("\n-> - 0 - Para finalizar e gravar os arquivos\n");
				System.out.println(" ---> CADASTRO DE CLIENTES <---");
				System.out.println("-> - 1 - Incluir novo cliente");
				System.out.println("-> - 2 - Alterar o cliente via codigo");
				System.out.println("-> - 3 - Excluir um cliente via codigo");
				System.out.println("-> - 4 - Consultar o cliente via cpf");
				System.out.println("-> - 5 - Consultar cliente em ordem alfabetica pelo nome\n");
				System.out.println(" ---> CADASTRO DE PRODUTOS <---");
				System.out.println("-> - 6 - Incluir um novo produto");
				System.out.println("-> - 7 - Alterar o produto via codigo");
				System.out.println("-> - 8 - Excluir o produto via codigo");
				System.out.println("-> - 9 - Consultar produto em ordem alfabetica pelo nome\n");
				System.out.println(" ---> CADASTRO DE VENDAS <---");
				System.out.println("-> - 10 - Incluir uma venda");
				System.out.println("-> - 11 - Excluir venda");
				System.out.println("-> - 12 - Consultar as vendas pelo periodo em ordem de cliente e data de venda");
				System.out.println("-> - 13 - Consultar estatisticas de venda por cliente\n");
				opcao = Console.readInt("Informe a opcao desejada: ");
				switch (opcao) {
					case 0:
						break;
					case 1:
						incluirCliente();
						break;
					case 2:
						alterarClienteCod(); 
						break;
					case 3:
						excluirCliente();
						break;
					case 4:
						buscarPorCpf();
						break;
					case 5:
						pesqClienteNome();
						break;
					case 6:
						incluirProduto();
						break;
					case 7:
						alterarProduto();
						break;
					case 8:
						excluirProdutoCod();
						break;
					case 9:
						pesqProdutoNome();
						break;
					case 10:
						incluirVenda();
						break;
					case 11:
						excluirVendaCod();
						break;
					case 12:
						vendaClientePerido();
						break;
					case 13:
						
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
				}
			}while(opcao!=0);
		}
		
	/**
	* Responsavel por apresentar cliente por periodo de venda
	* @param sem parametro
	* @return void
	* @throws SisVendasException 
	* @exception Apresenta erro caso seja invalido: data
	*/
	private static void vendaClientePerido() {
		
		GregorianCalendar data1 = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Informe a data 1: ");
			if(!LtpUtil.validarData(data, data1)) {
				System.out.println("Data invalida.");
				continue;
			}
			if (data1.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		
		GregorianCalendar data2 = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Informe a data 2: ");
			if(!LtpUtil.validarData(data, data2)) {
				System.out.println("Data invalida.");
				continue;
			}
			if (data2.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		
		
		ArrayList<Venda> resp = Cadastro.vendaClientePerido(data1, data2);
		if (resp.isEmpty()) {
			System.out.println("Nao existe nehuma venda cadastrada neste periodo.");
		} else {
			for (Venda objProduto : resp ) {
				System.out.println(objProduto.toString());
				
			}
		}	
	}

	/**
    * Responsavel por incluir um novo cliente no sistema
	* @throws SisVendasException 
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
				System.out.println("CPF invalido");
				continue;
			}
			
			try {
				Cliente objCliente = Cadastro.pesqClienteCpf(cpf);
				System.out.println("CPF ja esta cadastrado para o Socio" +
				objCliente.getNome());
			} catch (SisVendasException erro) {
				break;
			}
			
			try {
				Cliente objcliente = Cadastro.pesqClienteCpf(cpf);
				if (objcliente!=null) 
				{
					System.out.println("Ja existe cliente para o CPF");
					continue;
				} else break;
			} catch (SisVendasException erro) {
				break;
			}
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
				System.out.println("Falta informar o e-mail!");
			} else break;
			
			if (!LtpUtil.validarEmail(email)) 
			{
				System.out.println("E-mail invalido!");
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
		
		Cadastro.incluirCliente(new Cliente(cpf, nome, telefone, email, dataInclusao, null));
		System.out.println("\nCliente cadastrado no sistema.\n");
	}
	/**
	 * Responsavel por alterar um cliente no sistema
	 * @param sem parametro
	 * @return void
	 * @throws SisVendasException 
	 * @exception Apresenta erro caso seja invalido: nome, cpf, telefone, e-mail e data de entrada
	 */
	private static void alterarClienteCod() {
		System.out.println("\n" + "Alterar um cliente no sistema.");
		
		try {
				int codigo = Console.readInt("Informe o codigo do cliente");
				Cliente obj = Cadastro.pesqClienteCod(codigo);
				
				buscarPorCod(codigo);
				String valida = Console.readLine("Voce deseja alterar este cliente? / Informe SIM OU NAO ");
				System.out.println("");
					if (valida.equalsIgnoreCase("SIM")) {	
						String cpf;
						while(true) 
						{
							cpf = Console.readLine("CPF: ");
							if(!LtpUtil.validarCPF(cpf)) 
							{
								System.out.println("CPF invÃ¡lida");
								continue;
							}
							try {
								Cliente objCliente = Cadastro.pesqClienteCpf(cpf);
								System.out.println("CPF já está cadastrado para o Sócio " +
								objCliente.getNome());
							} catch (SisVendasException erro) {
								break;
							}
							
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
							if (email.isEmpty() && !LtpUtil.validarEmail(email)) 
							{
								System.out.println("Falta informar o e-mail e ou email invalido!");
							} else break;
						}
						GregorianCalendar dataAlteracao = new GregorianCalendar();
						
						obj.setCpf(cpf);
						obj.setNome(nome);
						obj.setTelefone(telefone);
						obj.setEmail(email);
						obj.setDataAltaracao(dataAlteracao);
						
						System.out.println("");
						System.out.println("\nCliente Alterado no sistema.");
						
					}
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	/**
	 * Responsavel por excluir cliente via cod, caso nao haja venda cadastrado ao cliente
	 * @param int cod
	 * @return null caso seja invalido
	 * @throws SisVendasException 
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	private static Cliente excluirCliente() {
		try {
			int codigo = Console.readInt("Informe o codigo: ");
			buscarPorCod(codigo);
			Cliente obj;
			Cliente objVenda;
			
			String valida1 = Console.readLine("Voce deseja excluir este cliente? / Informe SIM OU NAO ");
			if (valida1.equalsIgnoreCase("SIM")) {
				
				obj = Cadastro.pesqClienteCod(codigo);
				objVenda = obj;
				if(Cadastro.pesqVendaCliente(objVenda)){
					Cadastro.excluirCliente(obj);
					System.out.println("Cliente excluido com sucesso");
				}else {
					System.out.println("Impossivel excluir cliente, venda cadastrada!.");
				}
			} else {
				return null;
			}
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	return null;
	}
	
	
	/**
	 * Responsavel por buscar cliente via cpf
	 * @param String cpf
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cpf ou nao encontrado no sistema
	 */
	private static void buscarPorCpf() {
		try {
			String cpf = Console.readLine("Informe o cpf do cliente");
			if(!LtpUtil.validarCPF(cpf)) 
			{
				System.out.println("CPF invalido");
			} else {
				Cliente objCliente = Cadastro.pesqClienteCpf(cpf);
				System.out.println(objCliente.toString());
			}
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}

	
	/**
	 * Responsavel por buscar cliente via cod
	 * @param int Cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod ou nao encontrado no sistema
	 */
	private static void  buscarPorCod(int codigo) throws SisVendasException {
		try {
			Cliente obj = Cadastro.pesqClienteCod(codigo);
			if (obj != null) { 
				System.out.println(obj.toString());
			} else {
				System.out.println("Nao existe cliente neste codigo");
			}
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	/**
	 * Responsavel por incluir um novo produto no sistema
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome e preco
	 */
	private static void incluirProduto() {
		String nome;
		while(true) {
			nome = Console.readLine("Informe o nome do produto: ");
			if(nome.isEmpty()) {
				System.out.println("Falta informar um nome");
			} else break;
		}
		double preco;
		while(true) {
			preco = Console.readDouble("Informe o preço do produto: ");
			if(preco < 0) {
				System.out.printf("\nInforme um preco maior que 0!");
				continue;
			}
			else {
				break;
			}
		}
		GregorianCalendar dataInclusao = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Data de cadastro: ");
			if(!LtpUtil.validarData(data, dataInclusao)) {
				System.out.println("Data invalida.");
				continue;
			}
			if (dataInclusao.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		
		Cadastro.incluirProduto(new Produto(nome, preco, dataInclusao, null));
		System.out.println("\nProduto cadastrado no sistema.");
	}
	/**
	 * Responsavel por alterar o produto
	 * @param sem parametro
	 * @return void
	 * @exception Apresenta erro caso seja invalido: nome e preco
	 */
	private static void alterarProduto() {
		System.out.println("Alteração de produto no sistema!");
		
		try {
				int codigo = Console.readInt("Informe o codigo do produto: ");
				Produto obj = Cadastro.pesqProdutoCod(codigo);
				pesqProdutoCod(codigo);
				
				String valida = Console.readLine("Voce deseja alterar este cliente? / Informe SIM OU NAO ");
				System.out.println("");
					if (valida.equalsIgnoreCase("SIM")) {
						String nome;
						while(true) {
							nome = Console.readLine("Informe o nome do produto: ");
							if(nome.isEmpty()) {
								System.out.println("Falta informar um nome");
							} else break;
						}
						double preco;
						while(true) {
							preco = Console.readDouble("Informe o preço do produto: ");
							if(preco < 0) {
								System.out.printf("\nInforme um preco maior que 0!");
								continue;
							}
							else {
								break;
							}
						}
						GregorianCalendar dataAlteracao = new GregorianCalendar();
						
						obj.setNome(nome);
						obj.setPrecoUnitario(preco);
						obj.setDataAlteracao(dataAlteracao);
						
						System.out.println("\nProduto cadastrado no sistema.");
					}			
			}catch (SisVendasException erro) {
				System.out.println(erro.getMessage());
			}
	}
	
	/**
	 * Responsavel por excluir um produto no sistema
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod
	 */
	private static Produto excluirProdutoCod() {
		//Verificar se tem venda cadastrada
		System.out.println("Excluir produto");
		try {
			int codigo = Console.readInt("Informe o codigo: ");
			pesqProdutoCod(codigo);
			String valida3 = Console.readLine("Voce deseja excluir este produto? / Informe SIM OU NAO ");
			if (valida3.equalsIgnoreCase("SIM")) {
				Produto obj = Cadastro.pesqProdutoCod(codigo);
				
				if (obj != null) { 
					Cadastro.excluirProduto(obj);
					System.out.println("O produto foi excluido com sucesso!");
				}
			} else {
				System.out.println("Nao existe cliente neste codigo");
			}
				
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
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
		try {
		Produto obj;
		obj = Cadastro.pesqProdutoCod(codigo);
			if (obj != null) { 
				System.out.println(obj.toString());
			} else {
				System.out.println("Nao existe produto neste codigo");
			}
		} catch (SisVendasException e) {
			
			e.printStackTrace();
		}return null;
	}
	
	/**
	 * Responsavel por incluir uma venda no sistema
	 * @param sem parametro
	 * @return void
	 * @throws SisVendasException 
	 * @exception Apresenta erro caso seja invalido: cpf data da venda e quantidade 
	 */
	private static void incluirVenda() {

		ArrayList<ItemVenda> itemVenda = new ArrayList<ItemVenda>();
		String cpf;
		Cliente objcliente;
		while(true) 
		{
			cpf = Console.readLine("Informe o CPF do vendedor: ");
			if(!LtpUtil.validarCPF(cpf)) 
			{
				System.out.println("CPF invalido");
				continue;
			}
			try {
				objcliente = Cadastro.pesqClienteCpf(cpf);
				if (objcliente.equals(cpf)) 
				{
					System.out.println("Nao existe cliente para o cpf");
					continue;
				} else break;
			} catch (SisVendasException erro) {
				System.out.println(erro.getMessage());
			}
			
		}
		GregorianCalendar dataInclusao = new GregorianCalendar();
		while(true) {
			String data = Console.readLine("Informe a data de venda: ");
			if(!LtpUtil.validarData(data, dataInclusao)) {
				System.out.println("Data invalida.");
				continue;
			}
			if (dataInclusao.after(new GregorianCalendar())) {
				System.out.println("Data entrada superior a data de hoje");
			} else break;
		}
		System.out.println("\nItens da venda!");
		
		Produto obj;
		//Validar isto Já existe o produto em outro item desta venda
		while(true) {
			int codigo = Console.readInt("Informe o codigo do produto para o cadastro: ");
			try {
					obj = Cadastro.pesqProdutoCod(codigo);
				if (obj != null) { 
					break;
				} else {
					System.out.println("Nao existe produto neste codigo");
				}
			
			} catch (SisVendasException erro) {
				System.out.println(erro.getMessage());
			}
		}
		int quantidade;
		double preco = 0;
		double valor = 0;
		while(true) {
			
			quantidade = Console.readInt("Informe a quantidade de itens vendidos: ");
			if (quantidade <= 0) {
				System.out.println("A quantidade tem que ser maior que zero!");
			}else {
				preco = Console.readDouble("Informe o preco do produto vendido: ");
				valor = preco * quantidade;
				if (preco <= 0) {
					System.out.println("A quantidade tem que ser maior que zero!");
				}else {
					break;
				}
				break;
			}
		}
		
		
		itemVenda.add(new ItemVenda(obj, preco, quantidade, valor));
		Cadastro.incluirVenda(new Venda(objcliente, dataInclusao, itemVenda));
		System.out.println("\nProduto cadastrado no sistema.");
	}
	
	/**
	 * Responsavel por excluir uma venda por cod
	 * @param int codigo
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod
	 */
	private static Venda excluirVendaCod() {
		System.out.println("Excluir venda");
		try {
			int codigo = Console.readInt("Informe o codigo: ");
			pesqVendaCod(codigo);
			String valida4 = Console.readLine("Voce deseja excluir esta venda? / Informe SIM OU NAO ");
				if (valida4.equalsIgnoreCase("SIM")) {
					Venda obj = Cadastro.pesqVendaCod(codigo);
					
					if (obj != null) { 
						Cadastro.excluirVenda(obj);
						System.out.println("A venda foi excluida com sucesso!");
					} else {
						System.out.println("Nao existe venda neste codigo");
					}
				}
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
		return null;
	}
	

	/**
	 * Responsavel por pesquisar uma venda por cod no sistema
	 * @param int cod
	 * @return null caso seja invalido
	 * @exception Apresenta erro caso seja invalido: cod
	 */
	private static Produto pesqVendaCod(int codigo) {
		try {
		Venda obj;
		obj = Cadastro.pesqVendaCod(codigo);
			if (obj != null) { 
				System.out.println(obj.toString());
			} else {
				System.out.println("Nao existe venda neste codigo");
			}
		} catch (SisVendasException e) {
			
			e.printStackTrace();
		}return null;
	}
	
	/**
	 * Responsavel por pesquisar cliente por nome
	 * @param sem parametro
	 * @return void
	 * @throws SisVendasException 
	 * @exception Apresenta erro caso seja invalido: nome
	 */
	private static void pesqClienteNome() {
		try {
			System.out.println("\nPesquisa de Clientes pelo Nome");
			String nome = Console.readLine("Informe o nome ou parte do nome: ");
			ArrayList<Cliente> resp = Cadastro.pesqClienteNome(nome);
			if (resp.isEmpty()) {
				System.out.println("Nao existe nehum cliente para o nome.");
			} else {
				for (Cliente objSocio : resp ) {
					System.out.println(objSocio.toString());
					
				}
			}
		
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	/**
	 * Responsavel por pesquisar produto por nome
	 * @param sem parametro
	 * @return void
	 * @throws SisVendasException 
	 * @exception Apresenta erro caso seja invalido: nome
	 */
	private static void pesqProdutoNome() {
		try {
			System.out.println("\nPesquisa de Produto pelo Nome");
			String nome = Console.readLine("Informe o nome ou parte do nome: ");
			ArrayList<Produto> resp = Cadastro.pesqProdutoNome(nome);
			if (resp.isEmpty()) {
				System.out.println("Nao existe nehum produto para o nome.");
			} else {
				for (Produto objProduto : resp ) {
					System.out.println(objProduto.toString());
					
				}
			}	
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}
}
