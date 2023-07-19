package cursojava.lenguaje.basico.tipos.interfaces;

import java.util.UUID;

public interface Catalogable {
	
	public abstract String[] getPalabrasClave();
	
	public abstract String getIdUnico();
	
	// JDK8+
	
	public default String generarIdUnico() {
		
		return UUID.randomUUID().toString();
	}

}
