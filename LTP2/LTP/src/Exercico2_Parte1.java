import java.util.*;
public class Exercico2_Parte1 {
	public static void main (String[]args) {
		// 1 - declara��o de vari�veis
		byte ladoA;
		byte ladoB;
		byte ladoC;
		
		Scanner leia = new Scanner(System.in);

		// 2 - entrada de dados
		System.out.print("Digite o lado A: ");
		ladoA = leia.nextByte();
		
		System.out.print("Digite o lado B: ");
		ladoB = leia.nextByte();
		
		System.out.print("Digite o lado C: ");
		ladoC = leia.nextByte();
		
		// 3 - c�lculos e sa�da de dados
		if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA) {
			System.out.println("estes 3 lados n�o formam um Tri�ngulo!");
		} else if (ladoA == ladoB && ladoB == ladoC) {
			System.out.println("Tri�ngulo Equil�tero!");	
		} else if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC) {
			System.out.println("Tri�ngulo Is�celes!");
		} else {
			System.out.println("Tri�ngulo Escaleno!");
		}
	}
}
