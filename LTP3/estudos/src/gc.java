import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class gc {

	public static void main(String[ ] args) {
		GregorianCalendar dta = new GregorianCalendar( );
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss,S").format(dta.getTime()));		// Data : 20/08/2006 21:24:25,468	
		GregorianCalendar dt = new GregorianCalendar(2006,8-1,30); // Cria um objeto com a data 30/08/2006
		dt.add (GregorianCalendar.DAY_OF_MONTH , 1); // 31/08/2006
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy").format(dt.getTime()));
		dt.add(GregorianCalendar.MONTH ,5); // 28/02/2007
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy").format(dt.getTime()));
		dt.add(GregorianCalendar.YEAR , 1); // 28/02/2008
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy").format(dt.getTime()));
		dt.set (2006,8-1,31);  // Alterar a data
		dt.add(GregorianCalendar.DAY_OF_MONTH , 1); // 01/09/2006
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy").format(dt.getTime()));
		dt.add(GregorianCalendar.MONTH , 6); // 01/03/2007
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy").format(dt.getTime()));
		dt.add(GregorianCalendar.YEAR , 1); // 01/03/2008
		System.out.println("Data : " + new SimpleDateFormat("dd/MM/yyyy").format(dt.getTime()));
	}
}