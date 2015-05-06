import java.io.*;
import java.util.*;

public class Consulta {
		public static void consultar() {

		    	Rotinas.Notebook regNotebook = new Rotinas.Notebook();
		    	Scanner leia = new Scanner(System.in);
		    	RandomAccessFile pesquisarNotebook;
		    	byte opcao;
		    	String codNotebook;
		    	long posicaoRegistro;
		    	 
		    	do {
					do {
		    			System.out.println(" ***************  CONSULTA DE NOTEBOOK  ***************** ");
		    			System.out.println(" [1] CONSULTAR APENAS 1 NOTEBOOK ");
		    			System.out.println(" [2] LISTA DE TODOS OS NOTEBOOKS ");
		    			System.out.println(" [3] LISTA SOMENTE NOTEBOOK JÁ VENDIDOS ");
		    			System.out.println(" [0] SAIR");
		    			System.out.print("\nDigite a opção desejada: ");
		    			opcao = leia.nextByte();
		    			if (opcao < 0 || opcao > 3) {
		    				System.out.println("opcao Inválida, digite novamente.\n");
		    			}
		    		}while (opcao < 0 || opcao > 3);
					
					switch (opcao) {
						case 0:
							System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
							break;

						case 1:  // consulta de um único NOtebook
							leia.nextLine();  // limpa buffer de memória
			    			System.out.print("Digite o codigo do notebook: ");
			    			codNotebook = leia.nextLine();

			       			posicaoRegistro = Rotinas.pesquisarNotebook(Menu.ARQUIVO_EM_DISCO, regNotebook, codNotebook);
			   				if (posicaoRegistro == -1) {
			   					System.out.println("Notebook não cadastrado no arquivo \n");
			   				}else{
		    					imprimirCabecalho();
		    					imprimirNotebook(regNotebook);
		    					System.out.println("\n FIM DE RELATÓRIO - ENTER para continuar...\n");
		    					leia.nextLine();
		    				}
			   				
			    			break;
			    			
						case 2:  // imprime todos os Notebooks
			    			try { 
			    				pesquisarNotebook = new RandomAccessFile("NOTEBOOK.DAT", "rw");
		    					imprimirCabecalho();
				    		    while (true) {
				    		    	
				    		    	regNotebook.ativo = pesquisarNotebook.readChar();
				    		    	regNotebook.codNotebook = pesquisarNotebook.readUTF();
				    		    	regNotebook.marca = pesquisarNotebook.readUTF();
				    		    	regNotebook.modelo  = pesquisarNotebook.readUTF();
				    		    	regNotebook.processador = pesquisarNotebook.readUTF();
				    		    	regNotebook.quantMemoria = pesquisarNotebook.readInt();
				    		    	regNotebook.tamanhoTela = pesquisarNotebook.readInt();
				    		    	regNotebook.quantEstoque = pesquisarNotebook.readInt();
				    		    	regNotebook.preco = pesquisarNotebook.readFloat();
				    		    	regNotebook.quantVendida = pesquisarNotebook.readInt(); 
				    		    	regNotebook.dtUltimaVenda = pesquisarNotebook.readUTF();
				    				if ( regNotebook.ativo == 'S') {
				    					imprimirNotebook(regNotebook);
				    				}
				    			}
				    		
			    		    } catch (EOFException e) {
			 					System.out.println("\n FIM DE RELATÓRIO - ENTER para continuar...\n");
			 					leia.nextLine();
			 					codNotebook = leia.nextLine();
							} catch (IOException e) { 
								System.out.println("Erro na abertura do arquivo - programa será finalizado");
								System.exit(0);
						 	}
			    			break;
			    			
						case 3:  // imprime Notebooks vendidos 
						try {
							pesquisarNotebook = new RandomAccessFile("NOTEBOOK.DAT", "rw");
							imprimirCabecalho();
							 while (true) {
							
							
								for (int i =0; i < regNotebook.quantVendida; i++) {
									if (regNotebook.quantVendida > 0) {
										regNotebook.codNotebook = pesquisarNotebook.readUTF();
					    		    	regNotebook.marca = pesquisarNotebook.readUTF();
					    		    	regNotebook.modelo  = pesquisarNotebook.readUTF();
					    		    	regNotebook.processador = pesquisarNotebook.readUTF();
					    		    	regNotebook.quantMemoria = pesquisarNotebook.readInt();
					    		    	regNotebook.tamanhoTela = pesquisarNotebook.readInt();
					    		    	regNotebook.quantEstoque = pesquisarNotebook.readInt();
					    		    	regNotebook.preco = pesquisarNotebook.readFloat();
					    		    	regNotebook.quantVendida = pesquisarNotebook.readInt(); 
									}
								}
							 }
						} catch (EOFException e) {
		 					System.out.println("\n FIM DE RELATÓRIO - ENTER para continuar...\n");
		 					leia.nextLine();
		 					codNotebook = leia.nextLine();
						} catch (IOException e) { 
							System.out.println("Erro na abertura do arquivo - programa será finalizado");
							System.exit(0);
					 	}
		    			break;
			    			
					}	

		    	} while ( opcao != 0 );

			}

			public static void imprimirCabecalho () {
				System.out.println("-CODNOTE-  ---MARCA---  --MODELO--  -PROCESSADOR-  ---ESTOQUE--  --PRECO--  ---QUANT VEND---  ---VLR TOTAL---");
			}
			
		    public static void imprimirNotebook (Rotinas.Notebook regNotebook) {
				System.out.println(formatarString(regNotebook.codNotebook , 12) + "  " + 
						formatarString(regNotebook.marca , 6) + "  " + 
						formatarString(regNotebook.modelo , 12) + "  " +
						formatarString(regNotebook.processador , 17)  + "   " +
						formatarString(String.valueOf(regNotebook.quantEstoque) , 8) + "  " + 
						formatarString(String.valueOf(regNotebook.preco) , 13) + "  " + 
						formatarString(String.valueOf (regNotebook.quantVendida) , 15) + 
						(regNotebook.preco * regNotebook.quantVendida));
						
			}
		 
		    public static String formatarString (String texto, int tamanho) {	
		    	// retorna uma string com o número de caracteres passado como parâmetro em TAMANHO
		    	if (texto.length() > tamanho) {
		    		texto = texto.substring(0,tamanho);
		    	}else{
		    		while (texto.length() < tamanho) {
		    			texto = texto + " ";
		    		}
		    	}
		    	return texto;
	 }
}
	

