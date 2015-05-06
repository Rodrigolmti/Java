
public class galinha {
	
	public int ovos;
	public static int ovosDaGranja;
	
	public galinha botar() {
		this.ovos++;
		galinha.ovosDaGranja++;
		return this;
	}
}
