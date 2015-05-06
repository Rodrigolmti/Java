import java.io.*;

public class Rotinas {

	public static class Aluno {
		public char 	ativo;
		public String 	matricula;
		public String 	nomeAluno;
		public String 	dtNasc;
		public float 	mensalidade;
		public char 	sexo;
	}

	public static long pesquisarAluno(String arquivo, Aluno regAluno, String matriculaPesq) {	
		// método para localizar um registro no arquivo em disco
		long posicaoCursorArquivo = 0;
		try { 
		    RandomAccessFile pesqAluno = new RandomAccessFile(arquivo, "rw");
		    while (true) {
		    	posicaoCursorArquivo  = pesqAluno.getFilePointer();	// registro foi encontrado
		    	regAluno.ativo		 = pesqAluno.readChar();
				regAluno.matricula   = pesqAluno.readUTF();
		    	regAluno.nomeAluno   = pesqAluno.readUTF();
		    	regAluno.dtNasc      = pesqAluno.readUTF();
		    	regAluno.mensalidade = pesqAluno.readFloat();
		    	regAluno.sexo        = pesqAluno.readChar();
				 
				if ( matriculaPesq.equals(regAluno.matricula) && regAluno.ativo == 'S') {
					pesqAluno.close();
					return posicaoCursorArquivo;
				}
			}
		}catch (EOFException e) {
			return -1; // registro não foi encontrado
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
			System.exit(0);
			return -1;
	 	}
	}
	
	public static void gravarAluno(String arquivo, Aluno regAluno) {	
		// método para incluir um novo registro no final do arquivo em disco
		try {
			RandomAccessFile salvaAluno = new RandomAccessFile(arquivo, "rw");
	
			salvaAluno.seek(salvaAluno.length());  // posiciona o ponteiro no final do arquivo (EOF)
			salvaAluno.writeChar(regAluno.ativo);
			salvaAluno.writeUTF(regAluno.matricula);
		    salvaAluno.writeUTF(regAluno.nomeAluno);
		    salvaAluno.writeUTF(regAluno.dtNasc);
		    salvaAluno.writeFloat(regAluno.mensalidade);
		    salvaAluno.writeChar(regAluno.sexo);
		    
		    salvaAluno.close();
	    	System.out.println("Dados gravados com sucesso !\n");
	    }catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
			System.exit(0);
	 	}
	}
	
	public static void desativarAluno(String arquivo, Aluno regAluno, long posicao)	{    
		// método para alterar o valor do campo ATIVO para N, tornando assim o registro excluído
		try {
			RandomAccessFile salvaAluno = new RandomAccessFile(arquivo, "rw");
			
			salvaAluno.seek(posicao);
			salvaAluno.writeChar('N');   // desativar o registro antigo
		    salvaAluno.close();
	    }catch (IOException e) { 
	    	System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
	    	System.exit(0);
	    }

	}

		
}
