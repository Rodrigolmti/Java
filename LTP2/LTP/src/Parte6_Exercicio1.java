import java.util.*;
public class Parte6_Exercicio1 {
  public static void main(String[] args) {
	  String nome;
	  Scanner leia = new Scanner(System.in);
	  
	  System.out.print("Digite o nome: ");
	  nome = leia.nextLine();
	  
	  nome = eliminarEspacoEsquerda(nome);
	  nome = eliminarEspacoDireita(nome);
	  nome = eliminarEspacoEntre(nome);
	  nome = alterarPrimeiraLetraMaiusculo(nome);
	  
	  System.out.println(nome + "****");
  }
  
  public static String alterarPrimeiraLetraMaiusculo (String str) {
	  str = Character.toUpperCase( str.charAt(0) ) + str.substring(1);
	  for (int x=1; x < str.length() ; x++) {
		  if (str.charAt(x) == ' ') {
			  str = str.substring(0 , x+1) + 
					  Character.toUpperCase( str.charAt(x+1) ) +
						str.substring(x+2);
		  }
	  }  
	  return str;
  }
  
  public static String eliminarEspacoEsquerda (String str) {
	  while (str.charAt(0) == ' ') {
		  str = str.substring(1);
	  }
	  return str;
  }
  
  public static String eliminarEspacoDireita (String str) {
	  while (str.charAt( str.length() - 1 ) == ' ') {
		  str = str.substring(0, str.length() - 1);
	  }
	  return str;
  }
  
  public static String eliminarEspacoEntre (String str) {
	  while (str.contains("  ")) {
		  str = str.replace("  ", " ");
	  }
	  return str;
  }
  
  
}
