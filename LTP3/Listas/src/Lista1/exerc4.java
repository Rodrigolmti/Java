package Lista1;
import java.awt.font.NumericShaper.Range;
import java.util.Scanner;


public class exerc4 {

	
	public static void main(String[] args){
		int n;
		int max=1;
		int min=1;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o numero de repetiçoes :");
		n= input.nextInt();
		
		System.out.println("Informe o Maximo:");
		max = input.nextInt();

		System.out.println("Informe o Minimo:");
		min = input.nextInt();
		
		
		for(int i =1; i<n+1;i++)
		{
			System.out.println(i+">. "+(int) (Math.random()*range(max,min)));
		}
		
		input.close();
	}
	
	public static int range(int max,int min){
		int range  = (max - min)+1;
		return range;
	}
}
