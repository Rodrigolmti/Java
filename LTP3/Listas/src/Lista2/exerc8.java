package Lista2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class exerc8 {

	public static void main(String[] args) {

		String data;
		ArrayList<String> datas = new ArrayList<String>();

		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Favor informar a data  como abaixo mes e ano :");
			System.out.println("MM/YYYY");

			data = input.nextLine();

		} while (!validaData(data));

		System.out.println(dataMeses(data));
	}

	public static boolean validaData(String data) {

		if (data.matches("^(\\d{2}\\/\\d{4})$"))
		{
			return true;
		}
		return false;
	}
	
	public static ArrayList<String> dataMeses(String data){
		ArrayList<String> datas = new ArrayList<String>();

		String dia ="01/";
			//	dia = dia.concat(data);
		SimpleDateFormat spdf = new SimpleDateFormat("mm/yyyy");
		Date dt=null;
	
		try{
			dt = spdf.parse(data);
		}
		catch(Exception e){
		}
		
		
		GregorianCalendar GrCal = new GregorianCalendar();
		GrCal.setTime(dt);

		for(int i = 1; i < (int) GrCal.getMaximum(GregorianCalendar.DAY_OF_MONTH)+1;i++)
		{
			datas.add(Integer.toString(i).concat("/").concat(data));
		}
		
		return datas;	
	}
}
