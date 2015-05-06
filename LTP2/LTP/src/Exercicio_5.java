import java.util.*;
public class Exercicio_5 {

	public static void main(String[] args) {
		float salarioBruto;
		float salarioLiquido = 0;
		
		Scanner leia = new Scanner (System.in);
		
			System.out.println("Informe o salario bruto: ");
			salarioBruto = leia.nextFloat();
			salarioLiquido = cauculoSalario(salarioBruto);//Metodo cauculo do salario
			System.out.println("Valor final: " + salarioLiquido);

	}
	
	public static float cauculoSalario (float salarioBruto) {
		
		float salarioAux;
		float salarioIr = 0;
		float salarioInss = 0;
		float salarioVr;
		float salarioLiquido;
		
		if (salarioBruto <= 1174.86 ) {//Cauculo INSS
			salarioInss = (float) (salarioBruto * 0.8);
		} else if (salarioBruto >= 1174.87 && salarioBruto <= 1958.10) {
			salarioInss = (float) (salarioBruto * 0.9);
		} else if (salarioBruto >= 1958.11 && salarioBruto <= 3916.20) {
			salarioInss = (float) (salarioBruto * 0.11);
		} else if (salarioBruto >= 3916.20) {
			salarioInss = (float) 430.78;
		}
		
		if (salarioBruto <= 1637.11) {//Cauculo imposto de renda
			//nada acontece
		} else if (salarioBruto >= 1637.12 && salarioBruto <= 2453.50) {
			salarioIr = (float) ((float) salarioBruto * 7.5) / 100;
		} else if (salarioBruto >= 2453.51  && salarioBruto <= 3271.38) {
			salarioIr = (float) ((float) salarioBruto * 15.0) / 100;
		} else if (salarioBruto >= 3271.39 && salarioBruto <= 4087.65) {
			salarioIr = (float) ((float) salarioBruto * 22.5) / 100;
		} else if (salarioBruto >= 4087.66) {
			salarioIr = (float) ((float) salarioBruto * 27.5) / 100;
			
		}
		
		if (salarioBruto <= 1.700) {//Cauculo vale refeição
			salarioVr = (float) (0.4 / 100 * salarioBruto);
		} else {
			salarioVr = 200;
		}
		
		return salarioLiquido = salarioBruto - salarioInss - salarioIr - salarioVr;
		
		
	}
	

}
