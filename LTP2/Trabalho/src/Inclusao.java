import java.util.Scanner;

public class Inclusao {
	
	public static void incluir() {
		Scanner leia = new Scanner(System.in);
		Rotinas.Notebook regNotebook = new Rotinas.Notebook();
		char confirmacao;
		String codNotebook;
    	long posicaoRegistro;
		
		    	 
    	do {
    		do {
    			System.out.println("Informa codigo do NOTEBOOK");
    			codNotebook = leia.next();
    			
    			
    			if (codNotebook.equals("FIM")) {
    				break;
    			}
    			posicaoRegistro = Rotinas.pesquisarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook, codNotebook);

    			if (posicaoRegistro >= 0) {
   					System.out.println("Notebook informado já cadastrado!");
    			}
    		}while (posicaoRegistro >= 0);

    		if (codNotebook.equals("FIM")) {
    			break;
    		}
    		
    		regNotebook.codNotebook = codNotebook;
    		regNotebook.ativo = 'S';
    		do {
	    		System.out.println("Digite a marca do Notebook.............:");
	    		regNotebook.marca = leia.next();
    		}while (! Rotinas.consistirMarca(regNotebook.marca));
    		
    		leia.nextLine();
    		do {
	    		System.out.println("Digite o modelo do notebook..............: ");
	    		regNotebook.modelo = leia.nextLine();
    		} while ((regNotebook.modelo == ""));
    		
    		//leia.nextLine();
    		
    		do {
	    		System.out.println("Digite o processador do notebook.......: ");
	    		regNotebook.processador = leia.nextLine();
    		} while (! Rotinas.consistirProcessador(regNotebook.processador));
    		
    		do {
	    		System.out.println("Digite a quantidade de memoria do notebook..................: ");
	    		regNotebook.quantMemoria = leia.nextInt();
    		} while ( !(regNotebook.quantMemoria >= 1 && regNotebook.quantMemoria <= 16));
	    		
    		do {
	    		System.out.println("Digite o tamanho da tela do notebook...................: ");
	    		regNotebook.tamanhoTela = leia.nextInt();
    		} while (! Rotinas.consistirTamanhoTela(regNotebook.tamanhoTela));
    		
    		do {
	    		System.out.println("Digite a quantidade de notebooks...................: ");
	    		regNotebook.quantEstoque = leia.nextInt();
    		} while (!(regNotebook.quantEstoque > 0));
	    		
    		do {
	    		System.out.println("Digite o preco do notebook...................: ");
	    		regNotebook.preco = leia.nextFloat();
    		} while (!(regNotebook.preco >= 500) && regNotebook.preco <= 10000);
	    		
    		regNotebook.quantVendida = 0;
    		regNotebook.dtUltimaVenda = "";
    		
	    	do {
	    		System.out.println("\nConfirma a gravação dos dados (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			Rotinas.gravarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook);
	    		}
	    	}while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
    	}while ( ! regNotebook.marca.equals("FIM"));	    

	}

}

