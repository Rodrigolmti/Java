import java.util.*;
public class Exercicio1_Parte1 {
	public static void main (String []args) {
		// 1 - declara��o das vari�veis
		String nome;
		byte nota1;
		byte nota2;
		byte nota3;
		float media;
		
		Scanner leia = new Scanner(System.in);
		
		// 2 - entrada de dados
		System.out.print("Digite o nome do aluno: ");
		nome = leia.nextLine();
		
		System.out.print("Digite a nota 1 do aluno: ");
		nota1 = leia.nextByte();
		
		System.out.print("Digite a nota 2 do aluno: ");
		nota2 = leia.nextByte();
		
		System.out.print("Digite a nota 3 do aluno: ");
		nota3 = leia.nextByte();
		
		// 3 - C�lculos
		
		media = (nota1 + nota2 + nota3) / (float) 3;
		
		if (media <= 4) {
			System.out.println("aluno REPROVADO");
		} else if (media < 7) {
			System.out.println("aluno em RECUPERA��O");
		} else {
			System.out.println("aluno APROVADO");
		}
		
		// 4 - Sa�da de dados
		System.out.println("a m�dia do aluno �: " + media);
		
	}

}
