import java.util.*;
public class Menu {
	static String ARQUIVO_EM_DISCO = "ALUNOS.DAT";
	
	public static void main(String[] args) {	
    	Scanner leia = new Scanner(System.in);    
    	byte opcao = -1;
    	 
    	do {
			do {
    			System.out.println("\n ***************  CADASTRO DE ALUNOS  ***************** ");
    			System.out.println(" [1] INCLUIR ALUNOS ");
    			System.out.println(" [2] ALTERAR ALUNOS ");
    			System.out.println(" [3] CONSULTAR ALUNOS ");
    			System.out.println(" [4] EXCLUIR ALUNOS ");
    			System.out.println(" [0] SAIR");
    			System.out.print("\nDigite a opção desejada: ");
    			opcao = leia.nextByte();
    			if (opcao < 0 || opcao > 4) {
    				System.out.println("opcao Inválida, digite novamente.\n");
    			}
    		}while (opcao < 0 || opcao > 4);
			
			switch (opcao) {
				case 0:
					System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
					break;
				case 1: 
					Inclusao.incluir(); 
					break;
				case 2:
					Alteracao.alterar();
					break;
				case 3: 
					Consulta.consultar();
					break;
				case 4: 
					Exclusao.excluir();
					break;
			}
    	} while ( opcao != 0 );
    	leia.close();
	}

}
