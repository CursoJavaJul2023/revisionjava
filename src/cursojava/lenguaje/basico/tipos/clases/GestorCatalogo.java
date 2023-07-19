package cursojava.lenguaje.basico.tipos.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import cursojava.lenguaje.basico.tipos.interfaces.Catalogable;

public class GestorCatalogo implements Iterable<Catalogable> {
	
	private static GestorCatalogo laInstancia;
	
	private Map<String, Catalogable> catalogo = new HashMap<String, Catalogable>();
	
	private GestorCatalogo() {
	}
	
	public static GestorCatalogo getGestorCatalogo() {
		
		if(laInstancia == null) {
			laInstancia = new GestorCatalogo();
		}
		
		return laInstancia;
	}
	
	public Catalogable buscarPorIdUnico(String id) {
		return catalogo.get(id);
	}
	
	public List<Catalogable> buscarPorPalabraClave(String clave) {
		
		ArrayList<Catalogable> encontrado = new ArrayList<Catalogable>();
		
		for (Catalogable catalogable : catalogo.values()) {
			for (String palabraClave : catalogable.getPalabrasClave()) {
				if(palabraClave.equals(clave)) {
					encontrado.add(catalogable);
					break;
				}				
			}			
		}
		
		return encontrado;		
	}
	
	public void almacenar(Catalogable objeto) {
		catalogo.put(objeto.getIdUnico(), objeto);
	}

	@Override
	public Iterator<Catalogable> iterator() {		
		return catalogo.values().iterator();
	}

}




