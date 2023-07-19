package cursojava.funcionalidad.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cursojava.lenguaje.basico.tipos.clases.Cliente;

public class ProbarEmpleoDeColecciones {
	
	public static void main(String[] args) {
		
		// usoBasicoMatrices();
		
		// Tipo más básico
		Collection<Integer> enteros = new ArrayList<Integer>();
		
		// Permiten acceder por posición
		List<Integer> listaEnteros = new ArrayList<Integer>(); // ArrayList, LinkedList, Vector
		
		// No permite duplicados
		Set<Integer> datos = new HashSet<Integer>(); // HashSet, TreeSet
		
		datos.add(10);
		datos.add(20);
		datos.add(10);
		
		datos.forEach(System.out::println);
		
		List.of(10, 20, 30);
		Set.of("Uno", "Dos");
		
		//////////////////////////////////////////////////////////////
		
		List<Integer> valores = new ArrayList<Integer>(List.of(10, 20, 30, 40));
		
		// Algoritmos para colecciones
		
		Collections.shuffle(valores);
		
		valores.forEach(System.out::println);
		
		//////////////////////////////////////////////////////////////
		
		Map<String, Cliente> tablaContactos = new HashMap<String, Cliente>(); // HashMap, TreeMap
		
		tablaContactos.put("1000000", new Cliente("Luis", "García"));
		
		Cliente cliente = tablaContactos.get("1000000");
		if(cliente != null) {
			
		}
		
		tablaContactos.keySet().forEach(System.out::println);
		tablaContactos.values().forEach(System.out::println);
		tablaContactos.entrySet().forEach(System.out::println);
		
	}

	public static void usoBasicoMatrices() {
		int[] matrizEnteros = new int[10];
		int[] valores = { 10, 20, 30, 40 };
		
		for (int i = 0; i < valores.length; i++) {
			int j = valores[i];			
		}
		
		for (int k : valores) {			
		}
		
		String[][] datos = {
				{ "uno", "dos", "tres" },
				{ "uno"  , "dos" }
		};
		
		// Algoritmos aplicables a matrices
		// Arrays.*
	}

}
