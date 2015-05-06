import java.util.*;

public class Inclusao {
	
	public static void incluir() {
    	Rotinas.Aluno regAluno = new Rotinas.Aluno();
    	Scanner leia = new Scanner(System.in);
    	String matriculaChave;
    	char confirmacao;
    	long posicaoRegistro;
    	 
    	do {
    		do {
    			System.out.println("\n ***************  INCLUSAO DE ALUNOS  ***************** ");
    			System.out.print("Digite a Matrícula do Aluno( FIM para encerrar): ");
    			matriculaChave = leia.nextLine();
    			if (matriculaChave.equals("FIM")) {
    				break;
    			}
    			posicaoRegistro = Rotinas.pesquisarAluno(Menu.ARQUIVO_EM_DISCO, regAluno, matriculaChave);

    			if (posicaoRegistro >= 0) {
   					System.out.println("Matrícula já cadastrada, digite outro valor\n");
    			}
    		}while (posicaoRegistro >= 0);

    		if (matriculaChave.equals("FIM")) {
    			break;
    		}

    		regAluno.ativo = 'S';
    		regAluno.matricula = matriculaChave;
    		System.out.print("Digite o nome do aluno.........................: ");
    		regAluno.nomeAluno = leia.nextLine();
    		System.out.print("Digite a data de nascimento (DD/MM/AAAA).......: ");
	    	regAluno.dtNasc = leia.nextLine();	    	
    		System.out.print("Digite o valor da mensalidade..................: ");
	    	regAluno.mensalidade = leia.nextFloat();
    		System.out.print("Digite o Sexo do aluno (M/F)...................: ");
	    	regAluno.sexo = leia.next().charAt(0);
	    	
	    	do {
	    		System.out.print("\nConfirma a gravação dos dados (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			Rotinas.gravarAluno(Menu.ARQUIVO_EM_DISCO, regAluno);
	    		}
	    	}while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
    	}while ( ! regAluno.matricula.equals("FIM"));	    

	}

}
