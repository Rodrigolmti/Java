package lista_3;

import java.util.GregorianCalendar;

import servicos.LtpUtilAluno;
import utilitarios.Console;
public class TesteLtpUtilAluno {

	public static void main(String[] args) {
		// Variav�is 
		String cpf;
		String cnpj;
		String email;
		String data;
		double miliss;
	 	GregorianCalendar dt=new GregorianCalendar();
	 	
		int exercicioID = Console.readInt("----- MENU -----\n"
				+ "\n1 - Validar CPF\n"
				+ "2 - Validar CNPJ\n"
				+ "3 - Validar EMAIL\n"
				+ "4 - Validar Data B�sica\n"
				+ "5 - Verificar se o conte�do de String � data v�lida\n"
				+ "6 - Formatar tempo em milisegundos\n"
				+ "0 - Sair\n"
				+ "\nDigite o exerc�cio desejado: ");
		
		switch(exercicioID){
			case 1: 
				do{
				 	cpf= Console.readLine("Informe o cpf (somente n�meros): ");
				 	
				 	if(!LtpUtilAluno.validarCPF(cpf)){
					 	System.out.println("CPF inv�lido! Digite novamente.\n");	
				 	}else{
				 		System.out.println("CPF v�lido!");
				 	}
				 	
			 	}while(!LtpUtilAluno.validarCPF(cpf));
				break;
			case 2:
				do{
				 	cnpj= Console.readLine("Informe o cnpj (somente n�meros): ");
				 	
				 	if(!LtpUtilAluno.validarCNPJ(cnpj)){
					 	System.out.println("CNPJ inv�lido! Digite novamente.\n");	
				 	}else{
				 		System.out.println("CNPJ v�lido!");
				 	}
				 	
			 	}while(!LtpUtilAluno.validarCNPJ(cnpj));
				break;
			case 3:
				do{
				 	email= Console.readLine("Informe o email: ");
				 	
				 	if(!LtpUtilAluno.validaData(email)){
					 	Console.printPrompt("Email inv�lido !");
				 	}else{
				 		System.out.println("Email v�lido!");
				 	}
					}while(!LtpUtilAluno.validarEmail(email));
				
				break;
			case 4:
				do{
				 	data= Console.readLine("Informe a data: ");
				 	
				 	if(!LtpUtilAluno.validaData(data)){
					 	Console.printPrompt("Data inv�lida !");
				 	}else{
				 		System.out.println("Data v�lida!");
				 	}
					}while(!LtpUtilAluno.validaData(data));
				
				break;
			case 5:
				do{
				 	data= Console.readLine("Informe a data: ");
				 	
				 	if(!LtpUtilAluno.validarData(data, dt)){
					 	Console.printPrompt("Data inv�lida !");
				 	}else{
				 		System.out.println("Data v�lida!");
				 	}
					}while(!LtpUtilAluno.validarData(data, dt));
				
				break;
			case 6:
				miliss= Console.readDouble("Informe os milisegundos: ");
					System.out.println(LtpUtilAluno.formatarMilissegundos(miliss));
				break;
			case 0:
				System.out.println("\nPrograma encerrado.");
				break;
			default:
				System.out.println("\nOp��o inv�lida!");
				break;	
		}

	}

}
