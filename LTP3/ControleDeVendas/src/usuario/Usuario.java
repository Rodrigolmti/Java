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

public class Usuario {
	public static void main(String[] args) throws SisVendasException {
		int ultimoValor;
		if (fileExist()) {
			try {
				lerArq("Venda");
				ultimoValor = Cadastro.listaVendas.get(Cadastro.listaVendas.size() - 1)
						.getNumVenda();
				Venda.setSeq(ultimoValor);
			}catch (Exception erro) {
				System.out.println("Lista de dados 'VENDAS' não foi preenchido!");
			}
			
			try {
				lerArq("Produto");
				ultimoValor = Cadastro.listaProdutos.get(Cadastro.listaProdutos.size() - 1)
						.getCodigo();
				Venda.setSeq(ultimoValor);
			}catch (Exception erro) {
				System.out.println("Lista de dados 'PRODUTO' não foi preenchido!");
			}
			
			try {
				lerArq("Cliente");
				ultimoValor = Cadastro.listaClientes.get(Cadastro.listaClientes.size() - 1)
						.getCodigo();
				Venda.setSeq(ultimoValor);
			}catch (Exception erro) {
			System.out.println("Lista de dados 'Clientes' não foi preenchido!");
			}

		}

		menu();
		gravarArq("Vendas");
		gravarArq("Produto");
		gravarArq("Cliente");
		System.out.println("Sistema finalizado, arquivos gravados!");
	}

	private static void lerArq(String obj) {
		ObjectInputStream inp;
		try {
			if (obj.equals("Venda")) {
				inp = new ObjectInputStream(new FileInputStream("Vendas.obj"));
				Cadastro.listaVendas = (ArrayList<Venda>) inp.readObject();
				inp.close();
			} else if (obj.equals("Produto")) {
				inp = new ObjectInputStream(new FileInputStream("Produtos.obj"));
				Cadastro.listaProdutos = (ArrayList<Produto>) inp.readObject();

			} else {
				inp = new ObjectInputStream(new FileInputStream("Clientes.obj"));
				Cadastro.listaClientes = (ArrayList<Cliente>) inp.readObject();

			}
			inp.close();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}

	}

	private static void gravarArq(String obj) {
		ObjectOutputStream out;

		try {
			if (obj.equals("Vendas")) {
				out = new ObjectOutputStream(new FileOutputStream("Vendas.obj"));
				out.writeObject(Cadastro.listaVendas);

			} else if (obj.equals("Produto")) {
				out = new ObjectOutputStream(new FileOutputStream(
						"Produtos.obj"));
				out.writeObject(Cadastro.listaProdutos);

			} else {

				out = new ObjectOutputStream(new FileOutputStream(
						"Clientes.obj"));
				out.writeObject(Cadastro.listaClientes);

			}
			out.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(2); // Termino por falha na gravação do arquivo
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
		
		//Inclusão de cliente

		/**
		 * Método responsável pelo cadastro de clientes.
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
				System.out.println("CPF ja esta cadastrado para o Socio " +
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
		do{
			nome = Console.readLine("Nome: ").trim();
			if (!nome.matches("^(\\D*)+(\\s*)+(\\D)$")) 
			{
				System.out.println("Falta informar o nome.");
			} else break;
		}while(!nome.matches("^(\\D*)+(\\s*)+(\\D)$"));
		
		while (true) {
			telefone = Console.readLine("Telefone: ");
			if (telefone.isEmpty()) 
			{
				System.out.println("Falta informar o telefone.");
			} else break;
		}
		do {
			email = Console.readLine("E-mail: ");
			
			if (!LtpUtil.validarEmail(email)) 
			{
				System.out.println("E-mail invalido!");
			} else break;
			
		}while(!LtpUtil.validarEmail(email));
		
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
	 * Método responsável pela alteração de clientes.
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
	 * Método responsável pela exclusão de clientes
	 * 
	 * @throws SisVendasException
	 *             - Quando não é possível encontrar o cliente
	 *             - Quando for encontrada alguma venda cadastrada
	 */
	private static Cliente excluirCliente() {
		System.out.println("\n" + "Excluir um cliente no sistema.");
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
	 * Método responsável pela busca de clientes pelo CPF
	 * 
	 * @throws SisVendasException
	 *             - Quando não é encontrado cliente pelo CPF informado
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
	 * Método responsável pela busca de clientes pelo COD
	 * 
	 * @throws SisVendasException
	 *             - Quando não é encontrado cliente pelo COD informado
	 */
	private static void  buscarPorCod(int codigo) {
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
	 * Método responsável pela busca de clientes por periodo de datas
	 * 
	 * @throws SisVendasException
	 *             - Quanda as datas forem invalidas
	 *             - Quando não houver venda entre o periodo informado 
	 */
	private static void vendaClientePerido() {
		try {
		
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
			
		}catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	
	//Inclusão de produtos!
	
	/**
	 * Método responsável por incluir um novo produto
	 * 
	 */
	private static void incluirProduto() {
		System.out.println("\n" + "Incluir um novo produto no sistema.");
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
	 * Método responsável pela busca de clientes por periodo de datas
	 * 
	 * @throws SisVendasException
	 *             - Quanda as datas forem invalidas
	 *             - Quando não houver venda entre o periodo informado 
	 */
	private static void alterarProduto() {
		System.out.println("\n" + "Alteração de produto no sistema!");
		
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
		System.out.println("\n" + "Excluir um produto no sistema");
		try {
			int codigo = Console.readInt("Informe o codigo: ");
			pesqProdutoCod(codigo);
			String valida3 = Console.readLine("Voce deseja excluir este produto? / Informe SIM OU NAO ");
			if (valida3.equalsIgnoreCase("SIM")) {
				Produto obj = Cadastro.pesqProdutoCod(codigo);
				if(Cadastro.pesqProdutoVenda(obj)){
					System.out.println("Impossivel excluir produto, venda cadastrada!");
				} else{
					Cadastro.excluirProduto(obj);
					System.out.println("O produto foi excluido com sucesso!");	
				}
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
	
	//Inclusão Venda
	
	/**
	 * Responsavel por incluir uma venda no sistema
	 * @param sem parametro
	 * @return void
	 * @throws SisVendasException 
	 * @exception Apresenta erro caso seja invalido: cpf data da venda e quantidade 
	 */
	private static void incluirVenda() {
		System.out.println("\n" + "Incluir uma venda no sistema.");
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
		
		int quantProd = Console.readInt("Informe quantos produtos tem a venda: ");
		int quantidade = 0;
		Produto objProd = null;
		double preco = 0;
		double valor = 0;
		Produto obj = null;
		for (int a=0;a<quantProd;a++) {
			while(true) {
				
				try {
					int codigo = Console.readInt("Informe o codigo do produto para o cadastro: ");	
						obj = Cadastro.pesqProdutoCod(codigo);
						if (obj != null) { 
							break;
						} else {
							System.out.println("Nao existe produto neste codigo");
						}
						
						if(Cadastro.pesqProdutoVenda(obj)) {//Arrumar o metodo de verificar se ja existe o produto na venda
							System.out.println("Este produto já esta cadastrado na venda!");
							break;
						} 
				} catch (SisVendasException erro) {//Fazer metodo de estatistica
					System.out.println(erro.getMessage());
				}
			}
			while(true) {
				
				quantidade = Console.readInt("Informe a quantidade de itens vendidos: ");
				if (quantidade <= 0) {
					System.out.println("A quantidade tem que ser maior que zero!");
				}else {//Arrumar o preço do array
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
		}
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
		System.out.println("\n" + "Excluir uma venda no sistema");
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
	
	//Metodos relacionados a gravar e ler objetos
	
	private static boolean fileExist() {
		if (new File("Vendas.obj").exists()
				&& new File("Clientes.obj").exists()
				&& new File("Produtos.obj").exists()) {
			return true;
		}

		return false;

	}

	private static void lerArqVendas() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream(
					"Vendas.obj"));
			Cadastro.listaVendas = (ArrayList<Venda>) inp.readObject();
			inp.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}

	}
}
