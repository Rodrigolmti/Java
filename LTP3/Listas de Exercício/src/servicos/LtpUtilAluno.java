package servicos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LtpUtilAluno {
	
	/**
	 * Método validarCPF - Validação do DV do CPF
	 * @param cpf  String com o CPF
	 * @return true para CPF com dv correto
	 * @author Telmo Júnior
	 */
	public static boolean validarCPF(String cpf) {

		int sm, i, r, num;
		if (cpf.matches("^(\\d{11})?")) {

			char dig10, dig11;
			// calcula o 1 digito verificador do CPF
			sm = 0;
			for (i = 0; i < 9; i++) {
				num = (int) cpf.charAt(i) - 48; 								
				sm = sm + (num * (10 - i));
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			
			// calcula o 2 digito verificador do CPF
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
	
	/**
	 * Método validarCNPJ - Validação do DV do CNPJ
	 * @param cnpj String com o CNPJ
	 * @return true para CNPJ com dv correto
	 * @author Telmo Júnior
	 */
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
	
	/**
	 * Método validarEmail - Validação básica de E-mail
	 * @param email String com a E-mail
	 * @return true para E-Mail válido
	 * @author Telmo Júnior
	 */
	public static boolean validarEmail(String email) {

		if (email.matches("\\w+@\\w+\\.\\w{2,3}")) {
			return true;
		}
		return false;

	}
	
	/**
	 * Método validaData - Validação básica de Data
	 * @param s String com a Data
	 * @return true para data válida ou false para data inválida
	 * @author Telmo Júnior
	 */
	public static boolean validaData(String data) {

		if (data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$")) {
			return true;
		}
		return false;
	}
	
	/**
	 * validarData verifica se o conteúdo da String representa um data válida
	 * @param s - String com a data
	 * @param dt referência a um objeto da classe GregorianCalendar para receber a data válida
	 * @return true para data válida ou false para data inválida
	 * @author Telmo Júnior
	 */
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


	/**
	 * Método formatarMilisegundos - Formatar o horário
	 * @param miliseg - representa as horas em milisegundos
	 * @return um String formatado com hhh:mm:ss
	 * @author Telmo Júnior
	 */	
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
