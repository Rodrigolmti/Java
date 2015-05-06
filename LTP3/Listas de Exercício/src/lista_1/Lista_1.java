package lista_1;

import java.util.Arrays;

import utilitarios.Console;

public class Lista_1 {

	public static void main(String[] args) {
		int exercicioID = Console.readInt("----- MENU -----\n"
				+ "\n1 - Exerc�cio 1\n"
				+ "2 - Exerc�cio 2\n"
				+ "3 - Exerc�cio 3\n"
				+ "4 - Exerc�cio 4\n"
				+ "5 - Exerc�cio 5\n"
				+ "0 - Sair\n"
				+ "\nDigite o exerc�cio desejado: ");
		
		switch(exercicioID){
			case 1: 
				exercicio1(); 
				break;
			case 2:
				exercicio2(); 
				break;
			case 3:
				exercicio3(); 
				break;
			case 4:
				exercicio4(); 
				break;
			case 5:
				exercicio5();
				break;
			case 0:
				System.out.println("\nPrograma encerrado.");
				break;
			default:
				System.out.println("\nOp��o inv�lida!");
				break;	
		}
		

	}

	private static void exercicio1() {
		System.out.println("// Exerc�cio 1: Gera 10 n�meros reais aleat�rios \n");
		for(int i=0;i<=9;i++){
			System.out.println((int) (Math.random() * 101) + 1);
		}
		
	}

	private static void exercicio2() {
		System.out.println("// Exerc�cio 2: Jogar o dado dez vezes \n");
		for(int i=0;i<=9;i++){
			System.out.println((int) (Math.random() * 6) + 1);
		}
		
	}

	private static void exercicio3() {
		System.out.println("// Exerc�cio 3: Jogar o dado cem vezes \n");
		for(int i=0;i<=99;i++){
			System.out.println((int) (Math.random() * 6) + 1);
		}
		
		
	}

	private static void exercicio4() {
		System.out.println("// Exerc�cio 4: Imprime n�meros aleat�rios dentro de uma faixa espec�fica \n");
		int limiteInferior = Console.readInt("Digite o limite inferior: ");
		int limiteSuperior = Console.readInt("Digite o limite superior: ");
		
		int n = Console.readInt("Digite a quantidade de n�meros: ");
		
		for(int i=0; i<n; i++){
			System.out.println(limiteInferior + (int) ( Math.random ()*(limiteSuperior-limiteInferior) ) );
		}
		
		
	}

	private static void exercicio5() {
		System.out.println("// Exerc�cio 5: Imprimir 6 n�meros inteiros , sem repeti��o  e  ordenados, cada um compreendido na faixa de 1 a 60 \n");
		int[] numeros = new int[6];
		Arrays.fill(numeros, 0);
		int numero;
		
		for(int i=0; i < 6;i++){
			while(true){
				boolean flag = false;
				numero =  (int) (Math.random() * 60) + 1;
				
				for(int t=0; t < 6; t++){
					if(numero == numeros[t]){
						flag = true;
						break;
					}
				}
				if(flag == true) continue;
				else break;
			}
			numeros[i] = numero;
		}
		Arrays.sort(numeros);
		
		for(int x : numeros){
			System.out.print(x + " ");
		}
	}


}
