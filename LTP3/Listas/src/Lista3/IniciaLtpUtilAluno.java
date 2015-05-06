package Lista3;
import java.util.GregorianCalendar;
import utilitarios.Console;
import java.util.Scanner;

import servicos.*;

public class IniciaLtpUtilAluno {
	public static void main(String[] args){
		String aluno;
		String cpf;
		String cnpj;
		String data;
		double miliss;
	 	GregorianCalendar dt=new GregorianCalendar();
	 	Scanner input = new Scanner(System.in);
	
		Console.printPrompt("Informe o nome do aluno :");
	 	aluno = Console.readLine();
	 	do{
		 	
		 	cpf= Console.readLine("Informe o CPF");
		 	
		 	if(!LtpUtilAluno.validarCPF(cpf))
		 	{
			 	System.out.println("CPF errado !");
		 	}
		 	
	 	}while(!LtpUtilAluno.validarCPF(cpf));
		
	 	do{
		 	cnpj= Console.readLine("Informe o CNPJ");
		 	
		 	if(!LtpUtilAluno.validarCNPJ(cnpj))
		 	{
			 	System.out.println("CNPJ errado !");
		 	}
		 	
	 	}while(!LtpUtilAluno.validarCNPJ(cnpj));
	
			do{
		 	data= Console.readLine("Informe a DATA");
		 	
		 	if(!LtpUtilAluno.validaData(data))
		 	{
			 	System.out.println("DATA errada!");
		 	}
		 	
			}while(!LtpUtilAluno.validarData(data, dt));
	 
			double miliss1 = utilitarios.Console.readDouble("Informe os millisegundos :");
			System.out.println(LtpUtilAluno.formatarMilissegundos(miliss1));	
	}
}
