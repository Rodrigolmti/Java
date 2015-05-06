import java.util.*;
public class Exercicio7 {

	public static void main(String[] args) {
		String cpf;
		int d1;
		int di1;
		int di2;
		int d2;
		
		Scanner leia = new Scanner (System.in);
		
			
				System.out.println("Informe o CPF: ");
				do {
					cpf = leia.next();
						if (cpf.length() < 11) {
							System.out.println("Cpf informado invlido!");
							
						}
						
						d1 = (Integer.parseInt(cpf.substring(9,10)));
						d2 = (Integer.parseInt(cpf.substring(10,11)));
				
						di1 = digito1(cpf);
						di2 = digito2(cpf);
						
						System.out.println("Digitos verificadores: " + di1 + di2);
						
						
				}while (! (cpf.length() < 11));
 
	}
	
	public static int digito1 (String cpf) {//Cauculo o primeiro digito
		int c[] = new int[11];
		int soma = 0;
		int sequencia = 10;
		int resto;
		
		for (int i = 0; i < 9; i++) {
			c[i] = Integer.parseInt(cpf.substring(i,i+1));
			soma = soma + (c[i] * sequencia);
			sequencia--;
		}
		
		resto = soma / 11;
		
		if (resto == 0 || resto == 11) {
			return 0;
		} else {
			return (11 - resto);
		}	
	}
	
	public static int digito2 (String cpf) {//Caucula o segundo digito
		int c[] = new int[11];
    	int soma = 0; 
		int sequencia = 10;
		int  resto;
		 
		  for (int i=1; i < 10; i++){
		 
		     c[i] = Integer.parseInt(cpf.substring(i,i+1));
		 
		     soma = soma + (c[i] * sequencia);
		 
		     sequencia--;
		 
		  }
		 
		  resto = soma % 11;
		 
		  if (resto == 0 || resto == 1){
		 
		     return 0;
		 
		  }else{
		 
		     return (11 - resto);
		 
		  }
		
	}

}
