package Lista2;

import java.util.ArrayList;

public class exerc5 {

	public static void main(String[] args) {

		ArrayList<Integer> posi = new ArrayList<Integer>();

		String frase = "teste de procurar palavra no texto palavra e retornar para um array";
		String palaProcurada = "palavra";
		
		System.out.println(buscaIndice(posi, palaProcurada, frase));
	}

	public static ArrayList<Integer> buscaIndice(ArrayList<Integer> posi,
			String palaProcurada, String frase) {
		int posicao;
		String aux = frase;

		for (int i = 0; i < frase.length(); i++) 
		{

			posicao = aux.indexOf(palaProcurada);
			aux = aux.substring(
					aux.indexOf(palaProcurada) + palaProcurada.length(),
					aux.length());
			if (posicao < 0) 
			{
				break;
			}
			posi.add(posicao);

		}

		return posi;
	}
}
