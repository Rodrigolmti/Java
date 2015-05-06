package Lista2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class exerc9 {

	public static void main(String[] args){
		
		String data;
		Scanner input = new Scanner(System.in);
		do{
		System.out.println("Favor informar a data como abaixo :");
		System.out.println("DD/MM/YYYY");
		
		data=input.nextLine();
		}while(!validaData(data));
		
		
		
		int dia= retornaDia(data);
		
		if((dia==7)||(dia==1))
		{
			
			System.out.println("Dia escolhido é Sabado ou Domingo : ");
			
		}
			System.out.println(pesquisarDiaSemana(dia));
	}
	
		public static boolean validaData(String data){
			
			if(data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$"))
			{
				return true;
			}			
			return false;
		}
	
	
		public static int retornaDia(String data){
			int diaDaSemana = 0;
			try{
			SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/mm/yyyy");  	
			Date hoje = sdfEntrada.parse(data);  
			GregorianCalendar gc = new GregorianCalendar();  
			gc.setTime(hoje);  
			diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);  
			}catch (Exception e){
				
				
			}
			return diaDaSemana;
		}

		 public static String pesquisarDiaSemana(int _diaSemana)  
		  {  
		    String diaSemana = null;  
		  
		    switch (_diaSemana)  
		    {  
		  
		    case 1:  
		    {  
		      diaSemana = "Domingo";  
		      break;  
		    }  
		    case 2:  
		    {  
		      diaSemana = "Segunda";  
		      break;  
		    }  
		    case 3:  
		    {  
		      diaSemana = "Terça";  
		      break;  
		    }  
		    case 4:  
		    {  
		      diaSemana = "Quarta";  
		      break;  
		    }  
		    case 5:  
		    {  
		      diaSemana = "Quinta";  
		      break;  
		    }  
		    case 6:  
		    {  
		      diaSemana = "Sexta";  
		      break;  
		    }  
		    case 7:  
		    {  
		      diaSemana = "Sábado";  
		      break;  
		    }  
		  
		    }  
		    return diaSemana;  
		  
		  }  	
}
