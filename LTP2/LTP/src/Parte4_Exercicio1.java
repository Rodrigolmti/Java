import java.util.*;
public class Parte4_Exercicio1 {
	public static void main (String args[]) {
		String cidades[] = new String[20];
		int distancias[] = new int[20];
		byte contCidades;
		String cidadePesquisa;
		boolean encontrou;
		float precoPassagem;
		int tempoVoo;
		int numEscalas;
		
		Scanner leia = new Scanner(System.in);
		
		// Entrada de dados
		for (contCidades = 0; contCidades <= 19; contCidades++) {
			
			do{
				System.out.print("Digite o nome da cidade "+ (contCidades+1) + 
						" (FIM para encerrar): ");
				cidades[contCidades] = leia.nextLine();
				if (cidades[contCidades].length() == 0) {
					System.out.println("Digitação do nome da cidade é obrigatório !");
				}
			}while(cidades[contCidades].length() == 0);
			
			if (cidades[contCidades].equalsIgnoreCase("FIM")) {
				break;
			}
			
			do{
				System.out.print("Digite a distância até BH: ");
				distancias[contCidades] = leia.nextInt();
				if (distancias[contCidades] < 500) {
					System.out.println("Distância inválida ! Digite mínimo 500");
				}
			}while(distancias[contCidades] < 500);
			
			leia.nextLine();
		}
		
		//contCidades = (byte) (contCidades - 1);
		
		do{
			System.out.print("Digite a cidade de destino (SAIR para finalizar): ");
			cidadePesquisa = leia.nextLine();
			
			if (cidadePesquisa.equalsIgnoreCase("SAIR")) {
				break;
			}
			
			encontrou = false;
			for (byte x = 0 ; x < contCidades ; x++ ) {
				
				if (cidadePesquisa.equals(cidades[x])) {
					encontrou = true;
					precoPassagem = (float) 0.25 * distancias[x];
					tempoVoo = 60 * distancias[x] / 800;
					if (tempoVoo > 180) {
						numEscalas = tempoVoo / 180;
					} else {
						numEscalas = 0;
					}
					System.out.println("Preço da passagem: " + precoPassagem);	
					System.out.println("Tempo de voo (minutos): " + tempoVoo);
					System.out.println("Num. escalas no percurso: " + numEscalas);
					break;
				}
			}
			
			if ( ! encontrou ) {
				System.out.println("Cidade não cadastrada !");
			}
			
			
		}while( ! cidadePesquisa.equalsIgnoreCase("SAIR") );
		
		
	}
}
