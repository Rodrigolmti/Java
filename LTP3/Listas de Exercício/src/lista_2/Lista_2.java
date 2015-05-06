package lista_2;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.Console;
import utilitarios.LtpUtil;

public class Lista_2 {

	public static void main(String[] args) {
		int exercicioID = Console.readInt("----- MENU -----\n"
				+ "\n1  - Exerc�cio 1\n"
				+ "2  - Exerc�cio 2\n"
				+ "3  - Exerc�cio 3\n"
				+ "4  - Exerc�cio 4\n"
				+ "5  - Exerc�cio 5\n"
				+ "6  - Exerc�cio 6\n"
				+ "7  - Exerc�cio 7\n"
				+ "8  - Exerc�cio 8\n"
				+ "9  - Exerc�cio 9\n"
				+ "10 - Exerc�cio 10\n"
				+ "0  - Sair\n"
				+ "\nDigite o exerc�cio desejado: ");
		
		switch(exercicioID){
			case 1:
				  System.out.println("// 1- RECEBER UM TEXTO E RETORNAR QUANTAS PALAVRAS TEM O TEXTO. \n");
				  String texto =  Console.readLine("Digite o texto: ");
				  int nPalavras = contPalavras(texto);
				  System.out.println("N�mero de palavras: " + nPalavras);
				break;
			case 2:
				 System.out.println("// 2- RECEBER UMA PLACA DE VE�CULO, VALIDAR E RETORNAR TRUE PARA A PLACA V�LIDA E FALSE PARA PLACA INV�LIDA. \n");
				 String placa = Console.readLine("Digite a placa do ve�culo: ");
				 System.out.println(validarPlaca(placa)?"Placa V�lida":"Placa N�o V�lida");
				break;
			case 3:
				 System.out.println("// 3- RECEBER UM TEXTO E UM N� INTEIRO N E RETORNAR UMA STRING COM N COPIAS DO TEXTO. \n");
				 String textoRepet = Console.readLine("Digite o texto: ");
				 int nRepet = Console.readInt("Digite o n�mero: ");
				 repeteTexto(textoRepet,nRepet);
				break;
			case 4:
				System.out.println("// 4- PARA RECEBER UM TEXTO E RETORNAR O TEXTO PADRONIZADO SEM ESPA�OS NAS EXTREMIDADES E ESPA�OS EXCESSIVOS \n");
				String textoPadronizado = Console.readLine("Digite o texto: ");
				System.out.println("Texto sem espa�os: " + padronizarTexto(textoPadronizado));
				break;
			case 5:
				System.out.println("// 5- RECEBER UM TEXTO E UMA PALAVRA,  PESQUISAR NO TEXTO A PALAVRA E RETORNAR UM  ARRAYLIST COM AS POSI��ES DA PALAVRA NO TEXTO \n");
				ArrayList<Integer> pos = new ArrayList<Integer>();

				String texto5 = Console.readLine("Digite o texto: ");
				String palavra = Console.readLine("Digite a palavra: ");
				
				
				System.out.println(buscarPosicoes(pos, palavra, texto5));
				break;
			case 6:
				System.out.println("// 6- RECEBER UMA DATA E RETORNAR UM TEXTO COM COM O DIA  DA SEMANA DA DATA \n");
				String texto6 = Console.readLine("Data: ");
				if (texto6.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
					String[] aux = texto6.split("/");
					
					GregorianCalendar data = new GregorianCalendar(
							Integer.parseInt(aux[2]), 
							Integer.parseInt(aux[1]) - 1, 
							Integer.parseInt(aux[0]));
					
					System.out.println("Dia da Semana: " + diaSemana(data));
				} else { System.out.println("Data inv�lida."); }
				break;
			case 7:
				System.out.println("// 7- RECEBER DUAS DATAS E RETORNAR UM INTEIRO COM A DIFEREN�A DAS DATAS EM DIAS \n");
				String data1 = Console.readLine("Digite a primeira data: ");
				String data2 = Console.readLine("Digite a segunda data: ");
				GregorianCalendar d1 = new GregorianCalendar();
				GregorianCalendar d2 = new GregorianCalendar();
				if (LtpUtil.validarData(data1, d1) &&
					LtpUtil.validarData(data2, d2) &&
					d2.compareTo(d1)>0) {
					System.out.println("Diferen�a em dias : " +
					       difDatas(d1,d2));
				} else { System.out.println("Datas inv�lidas."); }
				break;
			case 8:
				System.out.println("// 8- RECEBER O M�S E O ANO E RETORNAR UM ARRAYLIST COM AS DATAS DO MES/ANO \n");
				int mes, ano = 0;
				while (true) {
					mes = Console.readInt("M�s: ");
					if (mes >= 1 && mes <= 12) break;
					else System.out.println("M�s inv�lido.");
				}
				while (true) {
					ano = Console.readInt("Ano: ");
					if (ano > 0) break;
					else System.out.println("Ano inv�lido.");
				}
				
				for (GregorianCalendar objData : calendarioMensal(mes,ano)) {
					System.out.println(LtpUtil.formatarData(objData, "dd/MM/yyyy EEEE"));
				}
				break;
			case 9:
				System.out.println("// 9- RECEBER UMA DATA COM A FINALIDADE DE ALTERAR A DATA PARA SEGUNDA-FEIRA SE O DIA DA SEMANA DA DATA RECEBIDA FOR S�BADO OU DOMINGO \n");
				String texto9 = Console.readLine("Data: ");
				if (texto9.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
					String[] aux = texto9.split("/");
					GregorianCalendar data = new GregorianCalendar(
							Integer.parseInt(aux[2]), 
							Integer.parseInt(aux[1]) - 1, 
							Integer.parseInt(aux[0]));
					System.out.println("Dia da Semana: " + diaSemana(data));
					ajustarDataFinalSemana(data);
					System.out.println("Dia da Semana: " + diaSemana(data));
				} else { System.out.println("Data inv�lida."); }
				break;	
			case 10:
				System.out.println("// 10- LISTAR TODOS OS DOMINGOS COMPREENDIDOS ENTRE A DATA INICIAL E A DATA FINAL INFORMADOS COM PAR�METROS \n");
				String texto10 = Console.readLine("Digite a primeira data: ");
				String texto11 = Console.readLine("Digite a segunda data: ");
					String[] dt1 = texto10.split("/");
					GregorianCalendar date1 = new GregorianCalendar(
							Integer.parseInt(dt1[2]), 
							Integer.parseInt(dt1[1]) - 1, 
							Integer.parseInt(dt1[0]));

					String[] dt2 = texto11.split("/");
					GregorianCalendar date2 = new GregorianCalendar(
							Integer.parseInt(dt2[2]), 
							Integer.parseInt(dt2[1]) - 1, 
							Integer.parseInt(dt2[0]));
				ArrayList<GregorianCalendar> calDomingos = listarDomingos(date1,date2);
				for (GregorianCalendar objData : calDomingos) {
					System.out.println(LtpUtil.formatarData(objData, "dd/MM/yyyy EEEE"));
				}
				
				break;
			case 0:
				System.out.println("\nPrograma encerrado.");
				break;
			default:
				System.out.println("\nOp��o inv�lida!");
				break;	
		}
		

	}
	
	private static ArrayList<GregorianCalendar> listarDomingos(
			GregorianCalendar d1a, GregorianCalendar d2a) {
		ArrayList<GregorianCalendar> domingos = new ArrayList<>();
		GregorianCalendar dataAux = (GregorianCalendar)d1a.clone();
		
		while (dataAux.compareTo(d2a) <= 0) {
			if (dataAux.get(GregorianCalendar.DAY_OF_WEEK) == 1) {
				domingos.add((GregorianCalendar)dataAux.clone());
			}
			dataAux.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		return domingos;
	}

	private static void ajustarDataFinalSemana(GregorianCalendar data) {
		switch (data.get(GregorianCalendar.DAY_OF_WEEK)) {
			case 1: // Domingo
				data.add(GregorianCalendar.DAY_OF_MONTH, 1);
				break;
	
			case 7: // S�bado
				data.add(GregorianCalendar.DAY_OF_MONTH, 2);
				break;
		}
		
	}

	private static GregorianCalendar[] calendarioMensal(int mes,int ano) {
		int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		GregorianCalendar aux = new GregorianCalendar(ano, mes-1, 1);
		if (aux.isLeapYear(ano)) diasMes[1]=29;
		
		GregorianCalendar[] datas = new GregorianCalendar[diasMes[mes-1]];
		
		for (int i = 0; i < datas.length; i++) {
			datas[i] = new GregorianCalendar(ano, mes-1,i+1);
		}
		
		return datas;
	}
	private static long difDatas(GregorianCalendar d1, GregorianCalendar d2) {
		long aux = d2.getTimeInMillis() - d1.getTimeInMillis();
		return aux/(24*60*60*1000);
	}

	private static String diaSemana(GregorianCalendar data) {
		String[] nomeDia = {"Domingo","Segunda-Feira","Ter�a-Feira","Quarta-Feira","Quinta-Feira","Sexta-Feira","S�bado"};
		return nomeDia[data.get(GregorianCalendar.DAY_OF_WEEK)-1];
	}

	private static ArrayList<Integer> buscarPosicoes(ArrayList<Integer> pos, 
			String palavra, String texto5) {
		int posicao;
		String aux = texto5;

		for (int i = 0; i < texto5.length(); i++) {

			posicao = aux.indexOf(palavra);
			aux = aux.substring( (aux.indexOf(palavra) + palavra.length()) , aux.length() );
			if (posicao < 0) 
				break;
			pos.add(posicao);
		}
		
		return pos;
	}

	private static String padronizarTexto(String texto) {
		String textoPadronizado = texto.trim();
		
		while(textoPadronizado.contains("  ")){
			textoPadronizado = textoPadronizado.replaceAll("  ", " ");
		}
		
		return textoPadronizado;
	}

	private static void repeteTexto(String texto, int n) {
		for(int x = 0; x < n; x++){
			System.out.print(texto + " ");
		}
		
	}

	private static boolean validarPlaca(String placa) {
		return placa.matches("[A-Z]{3}\\d{4}"); // 3 OCORR�NCIAS A-Z - 4 OCORR�NCIAS DE INTEIROS
	}

	private static int contPalavras(String texto) {
		String textoSemEspacos = texto.trim();
		
		if(textoSemEspacos.isEmpty()) return 0;
		
		int cont = 1;
		
		for(int x=0; x < textoSemEspacos.length(); x++){
			if(textoSemEspacos.charAt(x) == ' ' && textoSemEspacos.charAt(x+1) != ' ') cont++;
		}
		
		return cont;
	}
}
