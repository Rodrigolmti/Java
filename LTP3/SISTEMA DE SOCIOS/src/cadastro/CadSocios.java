package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import dados.Socio;

public class CadSocios {
	
	public static ArrayList<Socio> listaSocios = new ArrayList<Socio>();
	
	public static void incluirSocio(Socio objSocio) {
		listaSocios.add(objSocio);
	}
	
	public static void excluirSocio(Socio objSocio) {
		listaSocios.remove(objSocio);
	}
	
	public static Socio pesqSocioCpf(String cpf) {
		for (Socio objSocio : listaSocios) {
			if (objSocio.getCpf().equals(cpf)) {
				return objSocio;
			}
		}
		return null;
	}
	
	public static ArrayList<Socio> pesqSocioNome(String nome) {
		ArrayList<Socio> resposta = new ArrayList<Socio>();
		for (Socio objSocio : listaSocios) {
			if (objSocio.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resposta.add(objSocio);
			}
		}
		// CLASSIFICAR A LISTA RESPOSTA PELO NOME DO SOCIO
		Collections.sort(resposta, new SocioPorNome());
		return resposta;
		
	}
	
	public static ArrayList<Socio> pesqSocioPeriodo(
			GregorianCalendar dt1, GregorianCalendar dt2) {
		
		ArrayList<Socio> resposta = new ArrayList<Socio>();
		for (Socio objSocio : listaSocios) {
			if (objSocio.getEntrada().compareTo(dt1) >= 0 &&
				objSocio.getEntrada().compareTo(dt2) <=0 ) {
				resposta.add(objSocio);
			}
		}
		Collections.sort(resposta, new SocioPorData());
		return resposta;
	}
}

class SocioPorNome implements Comparator<Socio> {

	@Override
	public int compare(Socio o1, Socio o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome());
	}
	
}

class SocioPorData implements Comparator<Socio> {

	@Override
	public int compare(Socio o1, Socio o2) {
		// TODO Auto-generated method stub
		return o1.getEntrada().compareTo(o2.getEntrada());
	}
	
}











