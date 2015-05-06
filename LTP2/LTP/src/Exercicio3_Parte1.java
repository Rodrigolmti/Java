import java.util.*;
public class Exercicio3_Parte1 {
	public static void main(String []args){
		// 1 - declaração de variáveis]
		float bonus;
		float valeTransp;
		float salario;
		byte tempoCasa;
		
		Scanner leia = new Scanner(System.in);
		
		// 2 - Entrada de dados
		System.out.print("Digite o tempo de casa do empregado: ");
		tempoCasa = leia.nextByte();
		
		System.out.print("Digite o salário: ");
		salario = leia.nextFloat();
		
		// 3 - cálculos
		if (tempoCasa <= 5) {
			if (salario <= 300) {
				bonus = 50;
				valeTransp = (float) (salario * 0.05);
			} else {
				bonus = 80;
				valeTransp = (float) (salario * 0.06);				
			}
		} else if (tempoCasa <= 10) {
			if (salario <= 500) {
				bonus = (float) (salario * 0.15);
				valeTransp = 70;				
			} else if (salario <= 2000) {
				bonus = (float) (salario * 0.13);
				valeTransp = 90;								
			} else {
				bonus = (float) (salario * 0.12);
				valeTransp = (float) (salario * 0.08);				
			}
		} else {
			bonus = 300;
			valeTransp = (float) (salario * 0.04);							
		}
			
		// 4 - Saída de dados
		System.out.println("O bônus é: " + bonus);
		System.out.println("O desconto de vale transporte é: " + valeTransp);
	}

}
