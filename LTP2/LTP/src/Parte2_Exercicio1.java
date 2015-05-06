import java.util.*;
public class Parte2_Exercicio1 {
	public static void main (String []args) {
		// 1- declara��o de vari�veis
		String nomeEmpregado;
		float salario;
		byte numDependentes;
		float novoSalario;
		float somaNovosSalarios = 0;
		byte contAcima1700 = 0;
		byte cont;
		
		Scanner leia = new Scanner(System.in);
		
		for (cont = 1; cont <= 10; cont++) {
			// 2- Entrada de dados
			System.out.print("Digite o nome do empregado " + cont + ": ");
			nomeEmpregado = leia.nextLine();
			System.out.print("Digite o sal�rio do empregado: ");
			salario = leia.nextFloat();
			System.out.print("Digite o n�mero de dependentes: ");
			numDependentes = leia.nextByte();
			
			// 3- c�lculos
			if (salario < 1000) {
				novoSalario = (float)(salario * 1.30);
			} else if (salario <= 2000) {
				novoSalario = (float)(salario * 1.20);
			} else {
				novoSalario = (float)(salario * 1.10);
			}
			
			novoSalario = novoSalario + 50 * numDependentes;
			System.out.println("O novo sal�rio �:" + novoSalario);
			
			somaNovosSalarios = somaNovosSalarios + novoSalario;
			if (novoSalario > 1700) {
				contAcima1700 ++;
			}
			leia.nextLine();
		}
		// 4- sa�da de dados
		System.out.println("Soma dos novos sal�rios: " + somaNovosSalarios);
		System.out.println("M�dia dos novos sal�rios: " + somaNovosSalarios / 10);
		System.out.println("N�m. empregados que passou a receber mais de R$1700,00: " +
				contAcima1700);
	}
}
