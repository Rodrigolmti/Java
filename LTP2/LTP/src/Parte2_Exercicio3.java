import java.util.*;
public class Parte2_Exercicio3 {
	public static void main(String[] args) {
		// 1 - declaração das variáveis
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
			System.out.print("Digite o Código do Operário: ");
			codOperario = leia.nextInt();
			if (codOperario == 0) {
				break;
			}
			
			do {
				System.out.print("Digite a classe do Operário: ");
				classe = leia.next().charAt(0);
				if (classe != 'A' && classe != 'B' && classe != 'C') {
					System.out.println("Classe Inválida! Digite A, B ou C");
				}
			} while (classe != 'A' && classe != 'B' && classe != 'C');
			
			do {
				System.out.print("Digite o Num. Peças Fabricadas: ");
				numPecasFabricadas = leia.nextInt();
				if (numPecasFabricadas < 0) {
					System.out.println("Num. Peças inválido! digite valor acima de zero");
				}
			} while (numPecasFabricadas < 0);
			
			// 3 - cálculos
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
			
			System.out.println("O salário é: " + salario);
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

		// 4 - saída de dados
		System.out.println("Total gasto com salários: " + somaSalarios);
		System.out.println("Total de peças fabricadas: " + somaNumPecasFab);
		System.out.println("Operário que fabricou menor num peças: " + 
				codOperarioMenorNumPecas);
		if (contOperariosClasseB > 0) {
			System.out.println("Média num. peças classe B: " + 
					(float) somaNumPecasClasseB / contOperariosClasseB);
		}
	} 

}



