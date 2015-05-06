package Lista1;


public class exerc2 {
	public static void main(String[] args){
		
		for(int i =1;i<4;i++)
		{	
			System.out.println("--- Rodando "+i+". ---");
			for(int j =1;j<11;j++)
			{
				System.out.println(j+">. "+(int) (Math.random()*6));
	
			}	
		}
	}
}
