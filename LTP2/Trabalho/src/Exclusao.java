import java.util.Scanner;
import java.util.*;


public class Exclusao {
	public static void excluir() {
		
	
				Rotinas.Notebook regNotebook = new Rotinas.Notebook();
		    	Scanner leia = new Scanner(System.in);
		    	String codNotebook;
		    	char confirmacao;
		    	long posicaoRegistro = 0;
		    	 
		    	do {
		    		do {
		    			System.out.println(" ***************  EXCLUSÃO DE NOTEBOOK  ***************** ");
		    			System.out.print("Digite o codigo do Notebook ( FIM para encerrar ): ");
		    			codNotebook = leia.nextLine();
		    			if (codNotebook.equals("FIM")) {
		    				break;
		    			}
		    			
		      			posicaoRegistro = Rotinas.pesquisarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook,codNotebook);
		   				if (posicaoRegistro == -1) {
		   					System.out.println("Codigo de Notebook não cadastrado");
		   				}
		    		}while (posicaoRegistro == -1);

		    		if (codNotebook.equals("FIM")) {
		    			System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
		    			break;
		    		}

		    		System.out.println("Codigo Notebook: " + regNotebook.codNotebook);
		    		System.out.println("Marca do Notebook.: " + regNotebook.marca);
		    		System.out.println("Modelo do Notebook: " + regNotebook.modelo);
		    		System.out.println("Processador do Notebook: " + regNotebook.processador);
		    		System.out.println("Quantidade de memoria do Notebook: " + regNotebook.quantMemoria);
		    		System.out.println("Tamanho da tela do Notebook: " + regNotebook.tamanhoTela);
		    		System.out.println("Quantidade em estoque: " + regNotebook.quantEstoque);
		    		System.out.println("Preco do Notebook: " + regNotebook.preco);
		    		System.out.println();
		    		
			    	do {
			    		System.out.print("\nConfirma a exclusão deste aluno (S/N) ? ");
			    		confirmacao = leia.next().charAt(0);
			    		if (confirmacao == 'S') {
			    			Rotinas.excluiNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook, posicaoRegistro);
			    		 }
			    	}while (confirmacao != 'S' && confirmacao != 'N');

			    	leia.nextLine();
		    	}while ( ! regNotebook.codNotebook.equals("FIM"));
	}
}
