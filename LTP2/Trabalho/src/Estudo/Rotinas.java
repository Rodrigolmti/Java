package Estudo;

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
		
	
		public static boolean consistirMarca (String marca) {//Valida marcas!
			for (int i=0; i <= Menu.marcas.length - 1; i++) {
				if (marca.equals(Menu.marcas[i])) {
					return true;
				}
			}
			System.out.println("Marca informada inválida!");
			return false;
				
		}
		
		public static boolean consistirProcessador (String processador) {//Valida processador!
			for (int i=0; i<= Menu.processadores.length -1; i++) {
				if (processador.equals(Menu.processadores[i])) {
					return true;
				}
			}
			System.out.println("Processador informado inválido!");
			return false;
		}
		
		public static boolean consistirTamanhoTela (int tamanhoTela) {//Valida tamnhoTela!
			for (int i = 0; i <= Menu.tamanhoTela.length -1; i++) {
				if (tamanhoTela == Menu.tamanhoTela[i]) {
					return true;
				}
			}
			System.out.println("Tamanho de tela inválido!");
			return false;
		}
		
		
		public static long pesquiNotebook (String arquivo, Notebook regNotebook, String pesqNotebook) {
		long posicaoCursosArquivo = 0;
		
		try {
			RandomAccessFile pesqNot = new RandomAccessFile (arquivo, pesqNotebook "rw");
		}
			
			
			
		}
		
		
		
		
	}
}
