package cursojava.lenguaje.basico.referenciasmetodos;

import java.util.List;

public class ProbarReferenciasAMetodos {
	
	public static <T> void metodoEstatico(T dato) {
		System.out.printf("%s - %s%n", dato, dato.getClass());
	}
	
	public String convertirACadena(int valor) {
		return String.format("Cadena %d", valor);
	}
	
	public static void main(String[] args) {
		
		
		// JDK 8+
		
		// Sintacticamente indicar una referencia a un método de clase o instancia
		
		// 1. Métodos estáticos -> Tipo::nombredelMetodo
		
		List.of(10, 20).forEach(System.out::println);
		
		List.of(10, 20).forEach(ProbarReferenciasAMetodos::metodoEstatico);
		
		// 2. Métodos de instancia -> variableReferencia::nombreMetodo
		
		ProbarReferenciasAMetodos instancia = new ProbarReferenciasAMetodos();
		
		List.of(10, 20).stream().map(instancia::convertirACadena).forEach(System.out::println);
		
		// 3. Método de instancia de un tipo -> Tipo::nombreMetodo
		
		List.of(10, 20).stream().map(instancia::convertirACadena).map(String::toUpperCase).forEach(System.out::println);;
		
		
	}

}
