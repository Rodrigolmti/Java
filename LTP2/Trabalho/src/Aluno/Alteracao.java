import java.util.*;

public class Alteracao {
	public static void alterar() {
    	Rotinas.Aluno regAluno = new Rotinas.Aluno();
    	Scanner leia = new Scanner(System.in);
    	String matriculaChave;
    	char confirmacao;
    	long posicaoRegistro = 0;
    	 
    	do {
    		do {
    			System.out.println("\n ***************  ALTERAÇÃO DE ALUNOS  ***************** ");
    			System.out.print("Digite a Matrícula do Aluno que deseja alterar( FIM para encerrar ): ");
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
    			break;
    		}
    		
    		regAluno.ativo = 'S';
    		
    		System.out.println("Nome Atual do aluno.........................: " + regAluno.nomeAluno);
    		System.out.print  ("Digite o NOVO NOME do Aluno.................: ");
    		regAluno.nomeAluno = leia.nextLine();
    		
    		System.out.println();
    		System.out.println("Data de nascimento atual.....................: " + regAluno.dtNasc);
    		System.out.print  ("Digite a NOVA DATA de Nascimento (DD/MM/AAAA): ");
	    	regAluno.dtNasc = leia.nextLine();
	    	
	    	System.out.println();
    		System.out.println("Valor Atual da mensalidade...................: " + regAluno.mensalidade);
    		System.out.print  ("Digite o NOVO VALOR da Mensalidade...........: ");
	    	regAluno.mensalidade = leia.nextFloat();
	    	
	    	System.out.println();
    		System.out.println("Sexo Atual do aluno..........................: " + regAluno.sexo);
    		System.out.print  ("Digite o NOVO SEXO do Aluno (M/F)............: ");
	    	regAluno.sexo = leia.next().charAt(0);
	    	
	    	do {
	    		System.out.print("\nConfirma a alteração dos dados (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			Rotinas.desativarAluno(Menu.ARQUIVO_EM_DISCO, regAluno, posicaoRegistro);
	    			Rotinas.gravarAluno(Menu.ARQUIVO_EM_DISCO, regAluno);
	    	    	System.out.println("Dados gravados com sucesso !\n");
	    		 }
	    	}while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
    	}while ( ! regAluno.matricula.equals("FIM"));

	}
}
