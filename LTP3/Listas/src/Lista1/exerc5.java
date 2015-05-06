package Lista1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class exerc5 {
		public static void main(String[] args){
			
		    List<Integer> lista = new ArrayList<Integer>();  
	        Integer valor;  
	  
	        while(lista.size() < 6) {  
	            valor = (int) (Math.random() * 60);  
	            if(!lista.contains(valor)) 
	            {  
	                lista.add(valor);  
	            }  
	        }  
	          Collections.sort(lista);
	        
	        for(int n : lista) 
	        {  
	            System.out.print(n + " ");  
	        }  
	    }  	
}

