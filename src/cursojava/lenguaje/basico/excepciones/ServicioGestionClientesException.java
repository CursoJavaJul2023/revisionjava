package cursojava.lenguaje.basico.excepciones;

import cursojava.lenguaje.basico.tipos.enumeraciones.TipoError;

public class ServicioGestionClientesException extends Exception {
// public class ServicioGestionClientesException extends RuntimeException {

	private TipoError datos;
	private Object info;

	public ServicioGestionClientesException(TipoError datos, String message, Throwable cause, Object info) {
		super(message, cause);
		this.datos = datos;
	}

	public ServicioGestionClientesException(TipoError datos,String message, Object info) {
		super(message);
		this.datos = datos;
		this.info = info;
	}

	public TipoError getDatos() {
		return datos;
	}

	public Object getInfo() {
		return info;
	}
	
}
