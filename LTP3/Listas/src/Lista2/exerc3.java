package Lista2;

import java.util.Scanner;

public class exerc3 {
	
	public static void main(String[] args){
		
		String palavra;
		int n;
		String slip;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Favor informar a palavra : ");
		palavra = input.nextLine();
		
		System.out.println("Quantas repetiçoes :");
		n = input.nextInt();
		
		slip = String.format("%0" + n + "d", 0).replace("0",palavra);
	
		System.out.println(repeat(palavra, n));
	
	}
	
		static public String repeat(String x,int y){
			 StringBuilder sb = new StringBuilder(); 
			for(int i =0; i<y;i++)
			{
				sb.append(x);				
			}
			
			return sb.toString();			
		}
}