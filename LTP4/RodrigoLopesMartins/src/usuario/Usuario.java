package usuario;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Pessoa;
import erro.PessoaException;
import utilitarios.Console;
import utilitarios.LtpUtil;
import banco.Banco;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

	public static void main(String[] args) {
		try{
			Banco.abrirConexao();
			menu();
			Banco.fecharConexao();
			System.out.println("\nFinaliza��o do aplicativo.");
			System.exit(0);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void menu() {
		int opcao;
		do{
			System.out.println("#--------------------------------------------------#");
			System.out.println("         	   MENU PRODUTOS");
			System.out.println("1-Incluir pessoa");
			System.out.println("2-Alterar pessoa");
			System.out.println("3-Excluir pessoa");
			System.out.println("4-Consultar pessoa pelo codigo");
			System.out.println("5-Consultar pessoa pelo nome");
			System.out.println("6-Consultar pessoa pela data de nascimento");
			System.out.println("0-Sair");
			System.out.println("#--------------------------------------------------#");
			opcao = Console.readInt("Informe a op��o: ");
			switch(opcao) {
			case 1:
				incluirPessoa();
				break;
			case 2:
				alterarPessoa();
				break;
			case 3:
				excluirPessoa();
				break;
			case 4:
				consultarPessoaCodigo();
				break;
			case 5:
				consultaNome();
				break;
			case 6:
				consultarPessoasData();
				break;
			case 0: 
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}
		} while(opcao!=0);
		
	}

	private static void incluirPessoa() {
		System.out.println("\n" + "Incluir pessoa\n");

		String nome;
		String telefone;
		String email;
		
		while(true) {
			nome=Console.readLine("Nome da pessoa: ").trim();
			
			try {
				Banco.consultaPessoaNome(nome);
			} catch (SQLException | PessoaException e) {
				System.out.println(e.getMessage());
				return;
			}
			
			if(nome.isEmpty()) {
				System.out.println("Nome invalido!");
			} else break;
			
		}
		
		while(true) {
			telefone=Console.readLine("Telefone da pessoa: ");
			if(telefone.isEmpty()) {
				System.out.println("Telefone invalido!");
			} else break;
		}

		while(true) {
			email=Console.readLine("Email da pessoa: ");
			if(email.isEmpty()) {
				System.out.println("E-mail invalido!");
			} else break;
		}

		Date nascimento = new Date(System.currentTimeMillis());
		while (true) {
			String nascimentoString = Console.readLine("Informe a data de nascimento dd/mm/aaaa");
			if (LtpUtil.validarData(nascimentoString, nascimento) && nascimento.before(new Date(System.currentTimeMillis()))) {
				break;
			} else System.out.println("Data informada invalida");
		}
		
		Pessoa objPessoa = new Pessoa(0, nome, telefone, nascimento, email);
		
		try {
			Banco.incluirPessoa(objPessoa);
			System.out.println("\nPessoa Cadastrada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
	private static void alterarPessoa() {
		System.out.println("\n" + "Alterar pessoa\n");
		
		int codigo = 0;
		String nome;
		String telefone;
		String email;
		
		try {
			codigo=Console.readInt("Codigo da pessoa: ");
			Banco.consultaPessoaCodigo(codigo);
		} catch (SQLException | PessoaException e) {
			System.out.println(e.getMessage());
		}
		
		while(true) {
			nome=Console.readLine("Nome da pessoa: ").trim();
			if(nome.isEmpty()) {
				System.out.println("Nome invalido!");
			} else break;
			
		}
		
		while(true) {
			telefone=Console.readLine("Telefone da pessoa: ");
			if(telefone.isEmpty()) {
				System.out.println("Telefone invalido!");
			} else break;
		}

		while(true) {
			email=Console.readLine("Email da pessoa: ");
			if(email.isEmpty()) {
				System.out.println("E-mail invalido!");
			} else break;
		}
	
		Date nascimento = new Date(System.currentTimeMillis());
		while (true) {
			String nascimentoString = Console.readLine("Informe a data de nascimento dd/mm/aaaa");
			if (LtpUtil.validarData(nascimentoString, nascimento) && nascimento.before(new Date(System.currentTimeMillis()))) {
				break;
			} else System.out.println("Data informada invalida");
		}
		
		
		Pessoa objPessoa;
                try {
                    objPessoa = Banco.buscarPessoaCodigo(codigo);

                    objPessoa.setNome(nome);
                    objPessoa.setTelefone(telefone);
                    objPessoa.setNascimento(nascimento);
                    objPessoa.setEmail(email);

                    Banco.alterarPessoa(objPessoa);
                    System.out.println("\nPessoa Alterada.");
                
                } catch (SQLException | PessoaException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	private static void excluirPessoa() {
		System.out.println("\n" + "Excluir pessoa\n");
		
		int codigo;
		String opcao;
		
		try {
			codigo=Console.readInt("Codigo da pessoa: ");
			
			Banco.consultaPessoaCodigo(codigo);
			Pessoa obj = Banco.buscarPessoaCodigo(codigo);
			
			System.out.println(obj.toString());
			
			opcao = Console.readLine("\nVoce deseja realmente apagar este dado  (S/N) ?");
			if(opcao.equalsIgnoreCase("S")) {
				Banco.excluirPessoa(codigo);
				System.out.println("\nPessoa excluida do banco de dados!");
			}
			
		} catch (SQLException | PessoaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void consultarPessoaCodigo() {
		
		System.out.println("\n" + "Buscar pessoa por codigo\n");
		
		int codigo;
		
		try {
			codigo=Console.readInt("Codigo da pessoa: ");
			Pessoa pessoa = Banco.buscarPessoaCodigo(codigo);
			System.out.println(pessoa.toString());
		} catch (SQLException | PessoaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void consultaNome() {
		
		System.out.println("\n" + "Buscar pessoa por nome\n");
		
		String nome;
                ArrayList<Pessoa> listaPessoas;
		
		try {
			nome = Console.readLine("Informe o nome da pessoa: ");
			listaPessoas = Banco.buscarPessoaNome(nome);
			System.out.println(listaPessoas.toString());
		} catch (SQLException | PessoaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void consultarPessoasData() {
		
		ArrayList<Pessoa> listaPessoas;
		
		try {
			int mes = Console.readInt("Informe o mes de nascimento: ");
			
			listaPessoas = Banco.buscarPessoaMes(mes);
			
			System.out.println(listaPessoas.toString());
			
		} catch (SQLException | PessoaException e) {
			System.out.println(e.getMessage());
		}
	}
}
