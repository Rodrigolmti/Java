import java.util.Scanner;

public class Venda {
	public static void registrarVenda() {
	
		Scanner leia = new Scanner(System.in);
		Rotinas.Notebook regNotebook = new Rotinas.Notebook();
		char confirmacao;
		int quantVendidaAux = 0;
		String codNotebook;
		String registro;
    	long posicaoRegistro;
		
		    	 
    	do {
    		do {
    			System.out.println("\n ***************  VENDA DE NOTEBOOK  ***************** ");
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
    		
    		System.out.println("Marca atual.........................: " + regNotebook.marca);
    		System.out.println();
    		System.out.println("Modelo atual.....................: " + regNotebook.modelo);
    		System.out.println();
    		System.out.println("Processador atual..................: " + regNotebook.processador);
    		System.out.println();
    		System.out.println("Quantidade de memoria atual..........................: " + regNotebook.quantMemoria);
    		System.out.println();
    		System.out.println("Tamnho da tela..................: " + regNotebook.tamanhoTela);
    		System.out.println();
    		System.out.println("Quantidade em estoque..................: " + regNotebook.quantEstoque);
    		System.out.println();
    		System.out.println("Preco atual cadastrado..................: " + regNotebook.preco);
    		
    		do {
	    		System.out.println("Informe a quantidade de Notebooks vendidos: ");
	    		quantVendidaAux = leia.nextInt();
	    		if (regNotebook.quantVendida < 0) {
	    			System.out.println("Quantidade vendida inválida!");
	    		}
    		} while (regNotebook.quantVendida > 0);
    		
    		System.out.println("Informe a data da venda!");
    		regNotebook.dtUltimaVenda = leia.next();
    		
    		regNotebook.quantVendida = regNotebook.quantVendida + quantVendidaAux;
			regNotebook.quantEstoque = regNotebook.quantVendida - quantVendidaAux;
    		
    		do {//Confirmação de alteração de dados.
	    		System.out.print("\nConfirmar a venda de Notebooks (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			
	    			Rotinas.gravarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook);
	    	    	System.out.println("Dados gravados com sucesso !\n");
	    		 }
	    	}while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
    		
    	} while (! regNotebook.codNotebook.equals("FIM"));
	}
}
