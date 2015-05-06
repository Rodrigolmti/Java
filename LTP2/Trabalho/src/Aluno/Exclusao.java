import java.util.*;

public class Exclusao {
	public static void excluir() {
    	Rotinas.Aluno regAluno = new Rotinas.Aluno();
    	Scanner leia = new Scanner(System.in);
    	String matriculaChave;
    	char confirmacao;
    	long posicaoRegistro = 0;
    	 
    	do {
    		do {
    			System.out.println(" ***************  EXCLUSÃO DE ALUNOS  ***************** ");
    			System.out.print("Digite a Matrícula do Aluno que deseja excluir ( FIM para encerrar ): ");
    			matriculaChave = leia.nextLine();
    			if (matriculaChave.equals("FIM")) {
    				break;
    			}
    			
      			posicaoRegistro = Rotinas.pesquisarAluno(Menu.ARQUIVO_EM_DISCO, regAluno, matriculaChave);
   				if (posicaoRegistro == -1) {
   					System.out.println("Matrícula não cadastrada no arquivo, digite outro valor\n");
   				}
    		}while (posicaoRegistro == -1);

    		if (matriculaChave.equals("FIM")) {
    			System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
    			break;
    		}

    		System.out.println("Nome do aluno.......: " + regAluno.nomeAluno);
    		System.out.println("Data de nascimento..: " + regAluno.dtNasc);
    		System.out.println("Valor da mensalidade: " + regAluno.mensalidade);
    		System.out.println("Sexo do aluno.......: " + regAluno.sexo);
    		System.out.println();
    		
	    	do {
	    		System.out.print("\nConfirma a exclusão deste aluno (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			Rotinas.desativarAluno(Menu.ARQUIVO_EM_DISCO, regAluno, posicaoRegistro);
	    		 }
	    	}while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
    	}while ( ! regAluno.matricula.equals("FIM"));

	}
}
