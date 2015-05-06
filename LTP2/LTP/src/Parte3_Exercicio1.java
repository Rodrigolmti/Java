import java.util.*;
public class Parte3_Exercicio1 {
	public static void main(String[] args) {
		String dtHoje;
		String dtNasc;
		
		int diaHoje;
		int mesHoje;
		int anoHoje;
		int diaNasc;
		int mesNasc;
		int anoNasc;
		int idade;
		
		Scanner leia = new Scanner(System.in);
		
		//2 - entrada de dados
		System.out.print("Digite a data de hoje: ");
		dtHoje = leia.next();
		
		System.out.print("Digite a data de nascimento: ");
		dtNasc = leia.next();

		// 3- cálculos

		diaHoje = Integer.parseInt( dtHoje.substring(0,2) );
		mesHoje = Integer.parseInt( dtHoje.substring(3,5) );
		anoHoje = Integer.parseInt( dtHoje.substring(6) );
			
		diaNasc = Integer.parseInt( dtNasc.substring(0,2) );
		mesNasc = Integer.parseInt( dtNasc.substring(3,5) );
		anoNasc = Integer.parseInt( dtNasc.substring(6) );
		
		idade = anoHoje - anoNasc;
		if (mesNasc > mesHoje) {
			idade --;
		} else if (mesNasc == mesHoje && diaNasc > diaHoje) {
			idade --;
		}
		System.out.println("A idade é: " + idade);
	}
}

