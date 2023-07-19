package cursojava.lenguaje.basico.tipos.interfaces;

public interface Posicionable {
	
	public static final String FORMATO_POSICION = "GPS1";
	
	public abstract double getLat();
	
	public abstract double getLon();

}
