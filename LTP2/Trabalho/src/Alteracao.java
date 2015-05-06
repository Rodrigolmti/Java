
import java.util.Scanner;

public class Alteracao {
	public static void alterar() {
    	Rotinas.Notebook regNotebook = new Rotinas.Notebook();
    	Scanner leia = new Scanner(System.in);
    	String codNotebook;
    	char confirmacao;
    	long posicaoRegistro = 0;
    	 
    	do {
    		do {
    			System.out.println("\n ***************  ALTERAÇÃO DE NOTEBOOK  ***************** ");
    			System.out.print("Digite o codigo do Notebook que deseja alterar( FIM para encerrar ): ");
    			codNotebook = leia.nextLine();
    			if (codNotebook.equals("FIM")) {
    				break;
    			}
    			
       			posicaoRegistro = Rotinas.pesquisarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook, codNotebook);
   				if (posicaoRegistro == -1) {
   					System.out.println("Notebook não cadastrado no arquivo, digite outro valor\n");
   				}
    		}while (posicaoRegistro == -1);

    		if (codNotebook.equals("FIM")) {
    			break;
    		}
    		
    		regNotebook.ativo = 'S';
    		
    		System.out.println("Marca atual.........................: " + regNotebook.marca);
    		do {
	    		System.out.print  ("Digite a nova marca.................: ");
	    		regNotebook.marca = leia.nextLine();
    		} while (! Rotinas.consistirMarca(regNotebook.marca));
    		
    		System.out.println();
    		System.out.println("Modelo atual.....................: " + regNotebook.modelo);
    		do {
	    		System.out.print  ("Digite novo modelo: ");
		    	regNotebook.modelo = leia.nextLine();
    		} while (regNotebook.modelo == "");
	    	
	    	System.out.println();
    		System.out.println("Processador atual..................: " + regNotebook.processador);
    		do {
	    		System.out.print  ("Digite o processador...........: ");
		    	regNotebook.processador = leia.nextLine();
    		} while (! Rotinas.consistirProcessador(regNotebook.processador));
	    	
	    	System.out.println();
    		System.out.println("Quantidade de memoria atual..........................: " + regNotebook.quantMemoria);
    		do {
	    		System.out.print  ("Digite a nova quantidade de memoria............: ");
		    	regNotebook.quantMemoria = leia.nextInt();
    		} while (!(regNotebook.quantMemoria >= 1 && regNotebook.quantMemoria <= 16));
	    	
	    	System.out.println();
    		System.out.println("Tamnho da tela..................: " + regNotebook.tamanhoTela);
    		do {
	    		System.out.print  ("Digite o tamanho da tela...........: ");
		    	regNotebook.tamanhoTela = leia.nextInt();
    		} while (! Rotinas.consistirTamanhoTela(regNotebook.tamanhoTela));
	    	
	    	System.out.println();
    		System.out.println("Quantidade em estoque..................: " + regNotebook.quantEstoque);
    		do {
	    		System.out.print  ("Digite a quantidade em estoque...........: ");
		    	regNotebook.quantEstoque = leia.nextInt();
    		} while (!(regNotebook.quantEstoque > 0));
	    	
	    	System.out.println();
    		System.out.println("Preco atual cadastrado..................: " + regNotebook.preco);
    		do {
	    		System.out.print  ("Digite o preço...........: ");
		    	regNotebook.preco = leia.nextFloat();
    		} while (!(regNotebook.preco >= 500 && regNotebook.preco <= 10000));
		    	
		    	
	    	do {//Confirmação de alteração de dados.
	    		System.out.print("\nConfirma a alteração dos dados (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			Rotinas.excluiNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook, posicaoRegistro);
	    			Rotinas.gravarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook);
	    	    	System.out.println("Dados gravados com sucesso !\n");
	    		 }
	    	}while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
    	}while ( ! regNotebook.codNotebook.equals("FIM"));

	}
}
