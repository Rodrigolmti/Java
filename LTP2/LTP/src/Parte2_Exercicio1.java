import java.util.*;
public class Parte2_Exercicio1 {
	public static void main (String []args) {
		// 1- declaração de variáveis
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
			System.out.print("Digite o salário do empregado: ");
			salario = leia.nextFloat();
			System.out.print("Digite o número de dependentes: ");
			numDependentes = leia.nextByte();
			
			// 3- cálculos
			if (salario < 1000) {
				novoSalario = (float)(salario * 1.30);
			} else if (salario <= 2000) {
				novoSalario = (float)(salario * 1.20);
			} else {
				novoSalario = (float)(salario * 1.10);
			}
			
			novoSalario = novoSalario + 50 * numDependentes;
			System.out.println("O novo salário é:" + novoSalario);
			
			somaNovosSalarios = somaNovosSalarios + novoSalario;
			if (novoSalario > 1700) {
				contAcima1700 ++;
			}
			leia.nextLine();
		}
		// 4- saída de dados
		System.out.println("Soma dos novos salários: " + somaNovosSalarios);
		System.out.println("Média dos novos salários: " + somaNovosSalarios / 10);
		System.out.println("Núm. empregados que passou a receber mais de R$1700,00: " +
				contAcima1700);
	}
}
