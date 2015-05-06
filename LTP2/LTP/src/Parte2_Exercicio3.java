import java.util.*;
public class Parte2_Exercicio3 {
	public static void main(String[] args) {
		// 1 - declara��o das vari�veis
		int codOperario;
		char classe;
		int numPecasFabricadas;
		float salario;
		float somaSalarios = 0;
		int somaNumPecasFab = 0;
		int menorNumPecasFab = 999;
		int codOperarioMenorNumPecas = 0;
		int somaNumPecasClasseB = 0;
		int contOperariosClasseB = 0;
		
		Scanner leia = new Scanner (System.in);
		
		do {
			// 2 - Entrada de dados
			System.out.print("Digite o C�digo do Oper�rio: ");
			codOperario = leia.nextInt();
			if (codOperario == 0) {
				break;
			}
			
			do {
				System.out.print("Digite a classe do Oper�rio: ");
				classe = leia.next().charAt(0);
				if (classe != 'A' && classe != 'B' && classe != 'C') {
					System.out.println("Classe Inv�lida! Digite A, B ou C");
				}
			} while (classe != 'A' && classe != 'B' && classe != 'C');
			
			do {
				System.out.print("Digite o Num. Pe�as Fabricadas: ");
				numPecasFabricadas = leia.nextInt();
				if (numPecasFabricadas < 0) {
					System.out.println("Num. Pe�as inv�lido! digite valor acima de zero");
				}
			} while (numPecasFabricadas < 0);
			
			// 3 - c�lculos
			if (classe == 'A') {
				if (numPecasFabricadas <= 30) {
					salario = 500 + 2 * numPecasFabricadas;
				} else if (numPecasFabricadas <= 40) {
					salario = 500 + (float) 2.30 * numPecasFabricadas;
				} else {
					salario = 500 + (float) 2.80 * numPecasFabricadas;
				}
			} else if (classe == 'B') {
				salario = 1200;
			} else {
				if (numPecasFabricadas <= 50) {
					salario = 40 * numPecasFabricadas;
				} else {
					salario = 45 * numPecasFabricadas;
				}
			}						
			
			System.out.println("O sal�rio �: " + salario);
			somaSalarios = somaSalarios + salario;
			somaNumPecasFab = somaNumPecasFab + numPecasFabricadas;
			
			if (numPecasFabricadas < menorNumPecasFab) {
				menorNumPecasFab = numPecasFabricadas;
				codOperarioMenorNumPecas = codOperario;
			}
			
			if (classe == 'B') {
				somaNumPecasClasseB = somaNumPecasClasseB + numPecasFabricadas;
				contOperariosClasseB ++;
			}
			
		} while (codOperario != 0);

		// 4 - sa�da de dados
		System.out.println("Total gasto com sal�rios: " + somaSalarios);
		System.out.println("Total de pe�as fabricadas: " + somaNumPecasFab);
		System.out.println("Oper�rio que fabricou menor num pe�as: " + 
				codOperarioMenorNumPecas);
		if (contOperariosClasseB > 0) {
			System.out.println("M�dia num. pe�as classe B: " + 
					(float) somaNumPecasClasseB / contOperariosClasseB);
		}
	} 

}



