import java.io.*;
import java.util.*;

public class Consulta {

	public static void consultar() 	{
    	Rotinas.Aluno regAluno = new Rotinas.Aluno();
    	Scanner leia = new Scanner(System.in);
    	RandomAccessFile pesqAluno;
    	byte opcao;
    	String matriculaChave;
    	char sexoAux;
    	long posicaoRegistro;
    	 
    	do {
			do {
    			System.out.println(" ***************  CONSULTA DE ALUNOS  ***************** ");
    			System.out.println(" [1] CONSULTAR APENAS 1 ALUNO ");
    			System.out.println(" [2] LISTA DE TODOS OS ALUNOS ");
    			System.out.println(" [3] LISTA SOMENTE SEXO MASCULINO OU FEMININO ");
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

				case 1:  // consulta de uma única matrícula
					leia.nextLine();  // limpa buffer de memória
	    			System.out.print("Digite a Matrícula do Aluno: ");
	    			matriculaChave = leia.nextLine();

	       			posicaoRegistro = Rotinas.pesquisarAluno(Menu.ARQUIVO_EM_DISCO, regAluno, matriculaChave);
	   				if (posicaoRegistro == -1) {
	   					System.out.println("Matrícula não cadastrada no arquivo \n");
	   				}else{
    					imprimirCabecalho();
    					imprimirAluno(regAluno);
    					System.out.println("\n FIM DE RELATÓRIO - ENTER para continuar...\n");
    					leia.nextLine();
    				}
	   				
	    			break;
	    			
				case 2:  // imprime todos os alunos
	    			try { 
	    				pesqAluno = new RandomAccessFile("ALUNOS.DAT", "rw");
    					imprimirCabecalho();
		    		    while (true) {
		    		    	regAluno.ativo		 = pesqAluno.readChar();
		    				regAluno.matricula   = pesqAluno.readUTF();
		    		    	regAluno.nomeAluno   = pesqAluno.readUTF();
		    		    	regAluno.dtNasc      = pesqAluno.readUTF();
		    		    	regAluno.mensalidade = pesqAluno.readFloat();
		    		    	regAluno.sexo        = pesqAluno.readChar();
		    				if ( regAluno.ativo == 'S') {
		    					imprimirAluno(regAluno);
		    				}
		    			}
		    		//    pesqAluno.close();
	    		    } catch (EOFException e) {
	 					System.out.println("\n FIM DE RELATÓRIO - ENTER para continuar...\n");
	 					leia.nextLine();
	 					matriculaChave = leia.nextLine();
					} catch (IOException e) { 
						System.out.println("Erro na abertura do arquivo - programa será finalizado");
						System.exit(0);
				 	}
	    			break;
	    			
				case 3:  // imprime alunos do sexo desejado
					do {
		    			System.out.print("Digite o Sexo desejado (M/F): ");
		    			sexoAux = leia.next().charAt(0);
		    			if (sexoAux != 'F' && sexoAux != 'M') {
		    				System.out.println("Sexo Inválido, digite M ou F");
		    			}
					}while (sexoAux != 'F' && sexoAux != 'M');
					
	    			try { 
	    				pesqAluno = new RandomAccessFile("ALUNOS.DAT", "rw");
	    				imprimirCabecalho();
		    		    while (true) {
		    		    	regAluno.ativo		 = pesqAluno.readChar();
		    				regAluno.matricula   = pesqAluno.readUTF();
		    		    	regAluno.nomeAluno   = pesqAluno.readUTF();
		    		    	regAluno.dtNasc      = pesqAluno.readUTF();
		    		    	regAluno.mensalidade = pesqAluno.readFloat();
		    		    	regAluno.sexo        = pesqAluno.readChar();
		    				 
		    				if ( sexoAux == regAluno.sexo && regAluno.ativo == 'S') {
		    					imprimirAluno(regAluno);
		    				}
		    			}
	    		    } catch (EOFException e) {
	 					System.out.println("\n FIM DE RELATÓRIO - ENTER para continuar...\n");
	 					leia.nextLine();
	 					matriculaChave = leia.nextLine();
					} catch (IOException e) { 
						System.out.println("Erro na abertura do arquivo - programa será finalizado");
						System.exit(0);
				 	}
	    			
			}	

    	} while ( opcao != 0 );

	}

	public static void imprimirCabecalho () {
		System.out.println("-MATRÍCULA-  -------- NOME ALUNO ----------  --DATA NASC--  -Mensalidade-  -sexo- ");
	}
	
    public static void imprimirAluno (Rotinas.Aluno regAluno) {
		System.out.println(	formatarString(regAluno.matricula, 11 ) + "  " +
				formatarString(regAluno.nomeAluno , 30) + "  " + 
				formatarString(regAluno.dtNasc , 13) + "  " + 
				formatarString( String.valueOf(regAluno.mensalidade) , 13 ) + "  " +
				formatarString( Character.toString(regAluno.sexo) , 6 )   ); 
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