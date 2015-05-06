import java.util.*;
public class Parte6_Exercicio2 {
	public static void main (String[] args) {
		String nomeEmpregado[] = new String[100];
		String codEmpregado;
		int numPecasFabricadas;
		float salario[] = new float[100];
		float mediaSalarios;
		float somaSalarios = 0;
		Scanner leia = new Scanner(System.in);
		
		byte cont;
		for (cont = 0 ; cont <= 99 ; cont++) {
			do {
				System.out.print("Digite o nome do empregado (FIM para encerrar): ");
				nomeEmpregado[cont] = leia.nextLine();
				if (nomeEmpregado[cont].length() < 2) {
					System.out.println("Nome inválido! Digite mínimo 2 caracteres");
				}
			}while(nomeEmpregado[cont].length() < 2);
			
			if (nomeEmpregado[cont].equalsIgnoreCase("FIM")) {
				break;
			}
			
			do {
				System.out.print("Digite o código do empregado: ");
				codEmpregado = leia.next();
			}while( ! validarCodigo(codEmpregado, nomeEmpregado[cont].substring(0,2)) );
			
			do {
				System.out.print("Digite o número de peças fabricadas: ");
				numPecasFabricadas = leia.nextInt();
				if (numPecasFabricadas <= 0) {
					System.out.println("Erro ! Digite valor acima de zero");
				}
			}while(numPecasFabricadas <= 0);
			
			// cálculos
			salario[cont] = calcularSalario(numPecasFabricadas);
			somaSalarios = somaSalarios + salario[cont];
			
			leia.nextLine();  // limpar buffer do nextLine()
		} // fim do for
		
		mediaSalarios = somaSalarios / cont;
		
		for (byte x=0 ; x < cont; x++ ) {
			System.out.println(nomeEmpregado[x] + "  " + salario[x] + "  " + mediaSalarios);
		}
		System.out.println("Total pago com salários: " + somaSalarios );
		
	} // fim do main
	
	public static boolean validarCodigo (String codEmp, String duasPrimLetrasNome) {
		if (codEmp.length() != 5) {
			System.out.println("Código inválido! Digite 5 caracteres");
			return false;
		}
		
		if ( ! duasPrimLetrasNome.equals(codEmp.substring(0,2)) ) {
			System.out.println("Código inválido! 2 prim. caracteres devem "
					+ "ser iguais aos do Nome");
			return false;
		} 
		
		for (byte x=2 ; x<=4 ; x++) {
			if (codEmp.charAt(x) <'0' || codEmp.charAt(x) > '9') {
				System.out.println("Código inválido! 3 ultimos caracteres "
						+ "devem ser dígitos");
				return false;
			}
		}
		return true;
	}
	
	public static float calcularSalario (int numPecas) {
		float salario;
		if (numPecas <= 200) {
			salario = 2 * numPecas;
		} else if (numPecas <= 400) {
			salario = (float) 2.30 * numPecas;
		} else {
			salario = (float) 2.50 * numPecas;
		}
		return salario;	
	}
}
