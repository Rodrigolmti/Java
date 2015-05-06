package servicos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LtpUtilAluno {

	public static boolean validarCPF(String cpf) {

		int sm, i, r, num;
		if (cpf.matches("^(\\d{11})?")) {

			char dig10, dig11;
			// calcula o 1o. digito verificador do CPF
			sm = 0;
			for (i = 0; i < 9; i++) {
				num = (int) cpf.charAt(i) - 48; // transforma o caracter '0' no
												// inteiro 0
				sm = sm + (num * (10 - i));
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;

			for (i = 0; i < 10; i++) {
				num = (int) cpf.charAt(i) - 48;
				sm = sm + (num * (11 - i));
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {

				return true;
			} else
				return false;
		}

		return false;

	}

	public static boolean validarCNPJ(String cnpj) {

		int sm, i, r, num, peso;
		if (cnpj.matches("^(\\d{14})?")) {

			char dig13, dig14;
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
				return (true);
			else
				return (false);

		}

		return false;

	}

	public static boolean validarEmail(String email) {

		if (email.matches("\\w+@\\w+\\.\\w{2,3}")) {
			return true;
		}
		return false;

	}

	public static boolean validarPlaca(String placa) {

		if (placa.matches("^(\\[A-Z]{3}\\-\\d[]4)$")) {
			return true;
		}
		return false;

	}
	
	public static boolean validaData(String data) {

		if (data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$")) {
			return true;
		}
		return false;
	}

	public static boolean validarData(String s, GregorianCalendar dt) {
		if (validaData(s)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			Date dt1 = null;			
			dt = new GregorianCalendar();
			dt.setLenient(false);
			
			try {
				dt1 = sdf.parse(s);

			} catch (Exception e) {
				// TODO: handle exception
			}
			dt.setTime(dt1);
			try {
				
			
				 if (dt.get(GregorianCalendar.DAY_OF_MONTH) != dt.get(Calendar.DAY_OF_MONTH)) {
				      return false;
				    }
				    else if (dt.get(GregorianCalendar.MONTH) != dt.get(Calendar.MONTH)) {
				    	return false;
				    }
				    else if (dt.get(GregorianCalendar.YEAR) != dt.get(Calendar.YEAR)) {
				    	return false;
				    }				return true;
				    
			} catch (Exception e) {
				return false;

			}

		}
		return false;

	}

	public static String formatarMilissegundos(double miliseg) {

		String ftHoras;
		double segundos;
		double minutos;
		double horas;
		 segundos = (miliseg / 1000) % 60;
		minutos = (miliseg / 60000) % 60;
		horas =  miliseg / 3600000;

		ftHoras = (String.format("%3.2f/%2.2f/%2.2f", horas, minutos, segundos));

		return ftHoras;
	}

}
