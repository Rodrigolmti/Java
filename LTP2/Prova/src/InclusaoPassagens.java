import java.io.*;
import java.util.*;

public class InclusaoPassagens {
	
    	// declara��o e inicializa��o dos vetores globais com os respectivos valores
    	static String vetCiaAerea[]   = { "TAM", "GOL", "AZUL" , "WEBJET" , "COPA" , "AIR FRANCE" , "AMERICAN AIRLINES" , "LAN" , "CONTINENTAL" };
    	static String vetPrefixoVoo[] = { "TM" , "GO" , "AZ"   , "WJ"     , "CP"   , "AF"         , "AA"                , "LA"   , "CN" };
    	static String ARQUIVO_EM_DISCO = "PASSAGEM.DAT";

	public static class passagem {
		public char   ativo;
		public String codPassagem;
		public String codVoo;
		public String nomeCiaAerea;
		public String nomePassageiro;
		public String dataPartida;
		public String horaPartida;
		public String dataChegada;
		public String horaChegada;
		public float  pesoBagagem;
		public float  vlrPassagem;
		public float  taxaEmbarque;
		public float  vlrTotal;
		
	}

	public static void main(String[] args) {
		passagem regPassagem = new passagem();
    	Scanner leia = new Scanner(System.in);
    	char confirmacao;
    	String codPassagemChave;
    	RandomAccessFile arqPassagem;
    	long posicaoRegistro;
    	
    	do {
    		
   		System.out.println(" ***************  INCLUSAO DE PASSAGENS A�REAS  ***************** ");
    		do{
	   			System.out.print("Digite o Codigo da Passagem( FIM para encerrar): ");
	    		codPassagemChave = leia.nextLine();
	    		
    			posicaoRegistro = pesquisarCodVoo(ARQUIVO_EM_DISCO, regPassagem, codPassagemChave);

    			if (posicaoRegistro >= 0) {
   					System.out.println("C�digo inv�lido, utilize outro 'C�digo em uso'!");
    			}
	    		
    		}while (posicaoRegistro >= 0);
  			
 
    		if (codPassagemChave.equals("FIM")) {
    			System.out.println("\n ************  PROGRAMA ENCERRADO  ************** \n");
    			break;
    		}
    			
    		regPassagem.ativo = 'S';
    		regPassagem.codPassagem = codPassagemChave;
    		  		
    		System.out.print("Digite o C�digo do Voo...............: ");
	    	regPassagem.codVoo = leia.nextLine();	    	
    		
	    	do {
	    		System.out.print("Digite o nome da Companhia A�rea.....: ");
	    		regPassagem.nomeCiaAerea = leia.nextLine();
	    	}while (validaComp(regPassagem.nomeCiaAerea) == "ERRO");

	    	System.out.print("Digite o Nome do Passageiro..........: ");
	    	regPassagem.nomePassageiro = leia.nextLine();
    		
	    	System.out.print("Digite a Data de Partida (DD/MM/AAAA): ");
	    	regPassagem.dataPartida =  leia.nextLine();
    		
	    	System.out.print("Digite a Hora da Partida (HH:MM).....: ");
	    	regPassagem.horaPartida =  leia.nextLine();
    		
	    	System.out.print("Digite a Data de Chegada (DD/MM/AAAA): ");
	    	regPassagem.dataChegada =  leia.nextLine();
    		
	    	System.out.print("Digite a Hora da Chegada (HH:MM).....: ");
	    	regPassagem.horaChegada =  leia.nextLine();
    		
	    	System.out.print("Digite o peso da bagagem.............: ");
	    	regPassagem.pesoBagagem =  leia.nextFloat();
    		
	    	System.out.print("Digite o Valor da Passagem...........: ");
	    	regPassagem.vlrPassagem =  leia.nextFloat();
    		
	    	System.out.print("Digite o Valor da Taxa de Embarque...: ");
	    	regPassagem.taxaEmbarque =  leia.nextFloat();
	    	
    		System.out.print("Valor total a pagar..................: ");
	    	regPassagem.vlrTotal =  leia.nextFloat();
	    			
	    	do {
	    		System.out.print("\nConfirma a grava��o dos dados (S/N) ? ");
	    		confirmacao = leia.next().charAt(0);
	    		if (confirmacao == 'S') {
	    			try {
			    		arqPassagem = new RandomAccessFile("PASSAGEM.DAT", "rw");
			    		
			    		arqPassagem.seek(arqPassagem.length());  
			    		arqPassagem.writeChar (regPassagem.ativo);
			    		arqPassagem.writeUTF  (regPassagem.codPassagem);
			    		arqPassagem.writeUTF  (regPassagem.codVoo);
			    		arqPassagem.writeUTF  (regPassagem.nomeCiaAerea);
			    		arqPassagem.writeUTF  (regPassagem.nomePassageiro);
			    		arqPassagem.writeUTF  (regPassagem.dataPartida);
			    		arqPassagem.writeUTF  (regPassagem.horaPartida);
			    		arqPassagem.writeUTF  (regPassagem.dataChegada);
			    		arqPassagem.writeUTF  (regPassagem.horaChegada);
			    		arqPassagem.writeFloat(regPassagem.pesoBagagem);
			    		arqPassagem.writeFloat(regPassagem.vlrPassagem);
			    		arqPassagem.writeFloat(regPassagem.taxaEmbarque);
			    		arqPassagem.writeFloat(regPassagem.vlrTotal);
			    		arqPassagem.close();
	    		    	System.out.println("Dados gravados com sucesso !\n");
	    		    
	    			} catch (IOException e) { 
	    		    		System.out.println("Erro na grava�ao do registro - programa ser� finalizado");
	    		    		System.exit(0);
	    		   	}

	    		 }
	    		
	    	} while (confirmacao != 'S' && confirmacao != 'N');

	    	leia.nextLine();
	    	
    	} while ( ! regPassagem.codPassagem.equals("FIM"));
    	
    	leia.close();
	}
	
	public static String validaComp (String nomeCiaAerea) {//Metodo para fazer valida��o de companhia aerea
		for (int i = 0; i <= InclusaoPassagens.vetCiaAerea.length -1; i++) {
			if (nomeCiaAerea.equals(InclusaoPassagens.vetCiaAerea[i])) {
				String prefixoVoo;
				String codVoo;
				char charAtUm;
				char charAtDois;
				int codUm;
				int codDois;
				prefixoVoo = InclusaoPassagens.vetPrefixoVoo[i];
				
				charAtUm = InclusaoPassagens.vetPrefixoVoo[i].charAt(0);
				charAtDois = InclusaoPassagens.vetPrefixoVoo[i].charAt(1);
				codUm = (int) charAtUm;
				codDois = (int) charAtDois;
				
				codVoo = prefixoVoo + codUm + codDois;
				
				return codVoo;
			} 
		}
		System.out.println("Companhia aerea informada inv�lida!");
		return "ERRO";
		
	}
	
	public static long pesquisarCodVoo(String arquivo, passagem regPassagem, String pesqPassagem) {	
		// m�todo para localizar um registro no arquivo em disco
		long posicaoCursorArquivo = 0;
		try { 
		    RandomAccessFile pesqPas = new RandomAccessFile(arquivo, "rw");
		    while (true) {
		    	posicaoCursorArquivo  = pesqPas.getFilePointer();	// registro foi encontrado
		    	regPassagem.ativo		 = pesqPas.readChar();
		    	regPassagem.codPassagem   = pesqPas.readUTF();
		    	regPassagem.codVoo   = pesqPas.readUTF();
		    	regPassagem.nomeCiaAerea      = pesqPas.readUTF();
		    	regPassagem.nomePassageiro = pesqPas.readUTF();
		    	regPassagem.dataPartida  = pesqPas.readUTF();
		    	regPassagem.horaPartida   = pesqPas.readUTF();
		    	regPassagem.dataChegada  = pesqPas.readUTF();
		    	regPassagem.horaChegada = pesqPas.readUTF();
		    	regPassagem.pesoBagagem = pesqPas.readFloat();
		    	regPassagem.vlrPassagem = pesqPas.readFloat();
		    	regPassagem.taxaEmbarque = pesqPas.readFloat();
		    	regPassagem.vlrTotal = pesqPas.readFloat();
		    	
				if (pesqPassagem.equals(regPassagem.codPassagem) && regPassagem.ativo == 'S') {
					pesqPas.close();
					return posicaoCursorArquivo;
				}
			}
		}catch (EOFException e) {
			return -1; // registro n�o foi encontrado
		}catch (IOException e) { 
			System.out.println("Erro na abertura do arquivo  -  programa ser� finalizado");
			System.exit(0);
			return -1;
	 	}
	}

}
