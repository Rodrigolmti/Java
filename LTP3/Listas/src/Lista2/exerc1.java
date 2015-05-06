package Lista2;
import java.util.Scanner;


public class exerc1 {

	public static void main(String[] args){
		String texto=" ";
		Scanner input= new Scanner(System.in);
		System.out.println("Informe o texto");
		texto = input.nextLine();  
		 
		System.out.println(conta(texto));	 
}

     static public int conta(String texto){
    	 int conta = 0;
    	 
 		for( int i=0; i<texto.length(); i++ )  
 		{
 			  if( texto.charAt(i) == ' ' )  
 			  {
 				 conta++;
 			  }
 		}
 		return conta;	 	
	    }
}

