import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Rotinas {

	public static class Notebook {
		public char ativo;
		public String codNotebook;
		public String marca;
		public String modelo;
		public String processador;
		public int quantMemoria;
		public int tamanhoTela;
		public int quantEstoque;
		public float preco;
		public int quantVendida;
		public String dtUltimaVenda;
	}
	
	
	
	public static boolean consistirMarca (String marca) {
		for (int i = 0; i <= Menu.marcas.length -1; i++) {
			if (marca.equals(Menu.marcas[i])) {
				return true;
			}
		}
		System.out.println("Marca informada inválida!");
		return false;
	}
	
	public static boolean consistirProcessador (String processador) {
		for (int i = 0; i <= Menu.processadores.length -1; i++) {
			if (processador.equals(Menu.processadores[i])) {
				return true;
			}
		}
		System.out.println("Processador informado inválido!");
		return false;
	}
	
	public static boolean consistirTamanhoTela (int tamanhoTela) {
		for (int i = 0; i <= Menu.tamanhoTela.length -1; i++) {
			if (tamanhoTela == Menu.tamanhoTela[i]) {
				return true;
			}
		}
		System.out.println("Tamanho de tela informado inválido");
		return false;
	}
	
	
	public static long pesquisarNotebook(String arquivo, Notebook regNotebook, String pesqNotebook) {	
		// método para localizar um registro no arquivo em disco
		long posicaoCursorArquivo = 0;
		try { 
		    RandomAccessFile pesqNot = new RandomAccessFile(arquivo, "rw");
		    while (true) {
		    	posicaoCursorArquivo  = pesqNot.getFilePointer();	// registro foi encontrado
		    	regNotebook.ativo		 = pesqNot.readChar();
		    	regNotebook.codNotebook   = pesqNot.readUTF();
		    	regNotebook.marca   = pesqNot.readUTF();
		    	regNotebook.modelo      = pesqNot.readUTF();
		    	regNotebook.processador = pesqNot.readUTF();
		    	regNotebook.quantMemoria  = pesqNot.readInt();
		    	regNotebook.tamanhoTela   = pesqNot.readInt();
		    	regNotebook.quantEstoque  = pesqNot.readInt();
		    	regNotebook.preco = pesqNot.readFloat();
		    	regNotebook.quantVendida = pesqNot.readInt();
		    	regNotebook.dtUltimaVenda = pesqNot.readUTF();
		    	
				if (pesqNotebook.equals(regNotebook.codNotebook) && regNotebook.ativo == 'S') {
					pesqNot.close();
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
	
	public static void gravarNotebook(String arquivo, Notebook regNotebook) {	
		// método para incluir um novo registro no final do arquivo em disco
		try {
			RandomAccessFile salvaNotebook = new RandomAccessFile(arquivo, "rw");
	
			salvaNotebook.seek(salvaNotebook.length());  // posiciona o ponteiro no final do arquivo (EOF)
			salvaNotebook.writeChar(regNotebook.ativo);
			salvaNotebook.writeUTF(regNotebook.codNotebook);
			salvaNotebook.writeUTF(regNotebook.marca);
			salvaNotebook.writeUTF(regNotebook.modelo);
			salvaNotebook.writeUTF(regNotebook.processador);
			salvaNotebook.writeInt(regNotebook.quantMemoria);
			salvaNotebook.writeInt(regNotebook.tamanhoTela);
			salvaNotebook.writeInt(regNotebook.quantEstoque);
			salvaNotebook.writeFloat(regNotebook.preco);
			salvaNotebook.writeInt(regNotebook.quantVendida);
			salvaNotebook.writeUTF(regNotebook.dtUltimaVenda);
		    
			salvaNotebook.close();
	    	System.out.println("Dados gravados com sucesso !\n");
	    }catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
			System.exit(0);
	 	}
	}
	
	public static void excluiNotebook(String arquivo, Notebook regNotebook, long posicao)	{    
		// método para alterar o valor do campo ATIVO para N, tornando assim o registro excluído
		try {
			RandomAccessFile salvaNotebook = new RandomAccessFile(arquivo, "rw");
			
			salvaNotebook.seek(posicao);
			salvaNotebook.writeChar('N');   // desativar o registro antigo
			salvaNotebook.close();
	    }catch (IOException e) { 
	    	System.out.println("Erro na abertura do arquivo  -  programa será finalizado");
	    	System.exit(0);
	    }

	}

		
}
