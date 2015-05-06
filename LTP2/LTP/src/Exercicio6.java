import java.util.*;

public class Exercicio6 {

	public static void main(String[] args) {
		float valorProduto;
		float valorFrete;
		boolean valida;
		float valorFinal;
		float valorDolar;
		
		Scanner leia = new Scanner (System.in);
		
		int i = 0;
		do {
			
			do {
				
			valida = true;
			System.out.println("Informe o valor do produto: ");
			valorProduto = leia.nextFloat();
			
			System.out.println("Informe o valor do frete: ");
			valorFrete = leia.nextFloat();
			
				if (valorProduto + valorFrete > 500) {
					System.out.println("Valor informado fora dos limites de compra!");
					valida = false;
				}
			
			} while (! valida);
			
			System.out.println("Informe o valor do dolar: ");
			valorDolar = leia.nextFloat();
			
				valorFinal = ValidaPreco(valorProduto, valorFrete, valorDolar);//Chamada do metodo
				System.out.println("Valor final: " + valorFinal);
		
		} while (i > 10);

	}
	
	public static float ValidaPreco (float valorProduto, float valorFrete, float valorDolar ) {//Metodo que retorna o preço
		
		float valorFinal = 0;
		
		if (valorProduto + valorFrete == 50) {
			System.out.println("Carga isenta!");
		} else {
			
			valorFinal = (float) ((valorProduto * 1.6 + valorFrete) * 1.18 * valorDolar);
			
		}
		
		return valorFinal;
		
		
	}

}
