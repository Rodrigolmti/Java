package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import cadastro.CadSocios;
import dados.Dependente;
import dados.Socio;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class Usuario {

	public static void main(String[] args) {
		if (new File("Socios.obj").exists()) {
			lerArqSocios();
			int ultCod = CadSocios.listaSocios.get(CadSocios.listaSocios.size()-1).getCodigo();
			Socio.setSeq(ultCod);
		}
		menu();
		gravarArqSocios();
		System.out.println("\nFinalizar...");
		System.exit(0);
	}

	private static void gravarArqSocios() {
		try {
			ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("Socios.obj"));
			out.writeObject(CadSocios.listaSocios);
			out.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(2); // Termino por falha na gravação do arquivo
		}
		
	}

	private static void lerArqSocios() {
		try {
			ObjectInputStream inp = 
				new ObjectInputStream(new FileInputStream("Socios.obj"));
			CadSocios.listaSocios = (ArrayList<Socio>)inp.readObject();
			inp.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}
		
	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("\nCadastro de Sócio");
			System.out.println("1-Cadastrar Sócio e Dependentes");
			System.out.println("2-Pesquisar Sócio pelo CPF");
			System.out.println("3-Pesquisar Sócios pelo nome");
			System.out.println("0-Sair");
			opcao=Console.readInt("Informe o nº da opção: ");
			switch (opcao) {
				case 1:
					incluirSocio();
					break;
				case 2:
					PesqSocioCPF();
					break;
				case 3:
					pesqSociosNome();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void pesqSociosNome() {
		System.out.println("\nPesquisa de Sócios e Dependentes pelo Nome\n");
		String nome = Console.readLine("Informe o nome ou parte do nome: ");
		ArrayList<Socio> resp = CadSocios.pesqSocioNome(nome);
		if (resp.isEmpty()) {
			System.out.println("Não existe nehum sócio para o nome.");
		} else {
			for (Socio objSocio : resp ) {
				System.out.println(objSocio.toString());
				for (Dependente objDep : objSocio.getDependentes()) {
					System.out.println(objDep.toString());
				}
			}
		}
		
	}

	private static void PesqSocioCPF() {
		System.out.println("\nPesquisa do Sócio e Dependentes pelo CPF\n");
		String cpf = Console.readLine("CPF: ");
		if (!LtpUtil.validarCPF(cpf)) {
			System.out.println("CPF INVáLIDO");
		} else {
			Socio objSocio = CadSocios.pesqSocioCpf(cpf);
			if (objSocio==null) {
				System.out.println("NÃO EXISTE SÓCIO PARA O CPF");
			} else {
				System.out.println(objSocio.toString());
				if (objSocio.getDependentes().size() > 0) {
					System.out.println("\nDependentes\n");
					for (Dependente objDep : objSocio.getDependentes()) {
						System.out.println(objDep.toString());
					}
				}
			}
		}
		
	}

	private static void incluirSocio() {
		
		System.out.println("\nCadastrar Sócio e Dependentes\n");
		//cpf
		String cpf;
		while (true) {
			cpf = Console.readLine("CPF: ");
			if (!LtpUtil.validarCPF(cpf))  {
				System.out.println("CPF Inválido.");
				continue;
			}
			Socio objSocio = CadSocios.pesqSocioCpf(cpf);
			if (objSocio != null) {
				System.out.println("CPF já está cadastrado para o Sócio" +
									objSocio.getNome());
			} else break;
		}
		double preco = Console.readDouble("Preço: ");
		// nome
		String nome;
		while (true) {
			nome = Console.readLine("Nome: ").trim();
			if (nome.isEmpty() || LtpUtil.contarPalavras(nome) < 2) {
				System.out.println("Falta o nome ou nome incompleto.");
			} else break;
		}
		// entrada
		GregorianCalendar entrada = new GregorianCalendar();
		while (true) {
			String texto = Console.readLine("Data de Entrada: ");
			if (!LtpUtil.validarData(texto, entrada)) {
				System.out.println("Data de Entrada Inválida");
				continue;
			}
			if (entrada.after(new GregorianCalendar())) {
				System.out.println("Data de Entrada superior a Data Corrente.");
			} else break;
		}
		
		// Dependentes
		
		ArrayList<Dependente> listaDependentes = new ArrayList<Dependente>();
		
		int numDep = Console.readInt("Informe o Nº de dependentes: ");
		
		if (numDep > 0) {
			System.out.println("\nDependentes\n");
		}
		
		for (int i = 1; i <= numDep; i++) {
			// nome dependente
			String nomeDep;
			while (true) {
				nomeDep = Console.readLine("Nome do Dependente: ").trim();
				if (nomeDep.isEmpty() || LtpUtil.contarPalavras(nomeDep) < 2) {
					System.out.println("Falta nome ou nome incompleto");
				} else break;
			}
			// Data de Nascimento
			GregorianCalendar nascimento = new GregorianCalendar();
			while (true) {
				String data = Console.readLine("Data do Nascimento: ");
				if (!LtpUtil.validarData(data, nascimento)){
					System.out.println("Data de Nasc. Inválida.");
					continue;
				}
				if (nascimento.after(new GregorianCalendar())) {
					System.out.println("Data de Nasc. superior a Data Corrente.");
				} else break;
			}
			// Tipo de Dependência
			String tipo;
			while (true) {
				tipo = Console.readLine("Tipo de Dependência: ").trim();
				if (tipo.isEmpty()) {
					System.out.println("Falta o tipo de dependência.");
				} else break;
			}
			
			listaDependentes.add(new Dependente(nomeDep, nascimento, tipo));
			System.out.println("\nDependente registrado.\n");
		}
		
		CadSocios.incluirSocio(new Socio(cpf, nome, entrada, listaDependentes));
		
		System.out.println("\nSócio e Dependentes Cadastrado.");
		
	}

}
