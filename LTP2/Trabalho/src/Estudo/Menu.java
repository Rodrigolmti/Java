package Estudo;
import java.util.*;

public class Menu {

	static String marcas [] = {"Dell" + "Lenovo" + "HP" + "Positivo" + "Asus"};
	static String processadores [] = {"Intel Core i3" + "Intel Core i5" + "Intel Core i7" + 
	"AMD Phenom II" + "AMD FX"};
	static int tamanhoTela [] = {12 + 13 + 14 + 15 + 17};
	static String ARQUIVO_EM_DISCO = "NOTEBOOK.DAT";
	
	public static void main(String[] args) {
		
	
	 Scanner leia = new Scanner (System.in);
	 byte opcao = -1;
	
	do {
			do {
				System.out.println("Registro do Notebook");
				System.out.println(" [1] INCLUIR NOTEBOOK ");  	
				System.out.println(" [2] ALTERAR NOTEBOOK ");
				System.out.println(" [3] CONSULTAR NOTEBOOK");
				System.out.println(" [4] EXCLUIR NOTEBOOK ");
				System.out.println(" [5] REGISTRO DE VENDA");
				System.out.println(" [0] SAIR");
				System.out.print("\nDigite a opção desejada: ");
				opcao = leia.nextByte();
				
				if (opcao < 1 || opcao > 5) {
					System.out.println("Opção informada inválida!");
				}  
			} while (opcao < 1 || opcao > 5);
			
			
			switch (opcao) {//Executa opções Menu;
			case 0 :
				System.out.println("Programa encerrado com sucesso!");
			case 1:
				Inclusao.incluir();
			case 2:
				Alteracao.alterar();
			case 3:
				Colsultar.colta();
			case 4:
				Exclusao.excluir();
			case 5:
				Venda.registrarVenda();
			} 
		} while (opcao != 0);
		leia.close();
	}	

}	