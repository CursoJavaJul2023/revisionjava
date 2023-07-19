package cursojava.lenguaje.basico.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProbarEmpleoDeExpresionesLambda {
	
	public static <T> Collection<T> filtrar(Collection<T> datos, Filtro<T> filtro) {
		
		Collection<T> resultado = new ArrayList<T>();
		
		for (T dato : datos) {
			if(filtro.comprobar(dato)) {
				resultado.add(dato);
			}			
		}		
		
		return resultado;
	}
	
	
	public static <T> T buscarPrimero(Collection<T> datos, Predicate<T> condicion) {
		
		for (T dato : datos) {
			if(condicion.test(dato)) {
				return dato;
			}			
		}
		
		return null;
	}
	
	public static <T> void procesar(Collection<T> datos, Consumer<T> operacion) {
		
		for (T dato : datos) {
			operacion.accept(dato);
		}
	}
	
	public static <T> void incorporar(Collection<T> datos, Supplier<T> generador) {
		
		datos.add(generador.get());
	}
	
	public static <T, R> Collection<R> transformar(Collection<T> datos, Function<T, R> transformacion) {
		
		Collection<R> resultado = new ArrayList<R>();
		
		for (T dato : datos) {
			resultado.add(
				transformacion.apply(dato)
			);			
		}
		
		return resultado;		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {		
		
		// necesidadDeExpresionLambda();
		
		List<Integer> datos = List.of(10, 20, 30, 40);
		
		filtrar(datos, v -> v >= 20 && v <=30 ).forEach( e -> System.out.println(e) );
		
		filtrar(datos, v -> v >= 20 && v <=30 ).forEach( System.out::println );
		
		
		///////////////////////////////////////////////////////////////////////
		
		Integer primero = buscarPrimero(List.of(1, 2, 3, 4), (v) -> v > 2);
		if(primero != null) {
			System.out.println("Primero: " + primero);
		}
		
		/////////////////////////////////////////////////////////////////////////
		
		procesar(List.of(10, 20, 30, 40), (v) -> {
			System.out.printf("Valor: %d - Cuadrado: %d%n", v, v * v);
		});
		
		////////////////////////////////////////////////////////////////////////
		
		List<Integer> listaDatos = new ArrayList<Integer>(List.of(10, 20));
		
		incorporar(listaDatos, () -> (int)(System.currentTimeMillis() % 1000000));
		
		listaDatos.forEach(System.out::println);
		
		////////////////////////////////////////////////////////////////////////////
		
		transformar(List.of(10, 20, 30, 40), v -> v * v)
			.forEach(System.out::println);
		
		//////////////////////////////////////////////////////////////////////////
		
		Thread hilo = new Thread(
			() -> {
				System.out.println("Mensaje desde el hilo");
			}
		);
		
		hilo.start();
		hilo.join();
		
	}

	public static void necesidadDeExpresionLambda() {
		String[] nombres = new String[] { "Alberto", "Pedro", "Juan" };
		
		// Arrays.sort(nombres, new ComparadorPorLongitud());
		
//		Arrays.sort(nombres, new Comparator<String>() {
//				@Override
//				public int compare(String o1, String o2) {
//					
//					return o1.length() - o2.length();
//				}
//		});
		
		Comparator<String> compararPorLongitud = (s1, s2) -> s1.length() - s2.length();
		
		Arrays.sort(nombres, compararPorLongitud);
		
		Arrays.sort(nombres, (s1, s2) -> s1.length() - s2.length() );
		
		Arrays.sort(nombres, (s1, s2) -> {					
				return s1.length() - s2.length();				
			}
		);
		
		for (String n : nombres) {
			System.out.println(n);
		}
	}

}

class ComparadorPorLongitud implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		return o1.length() - o2.length();
	}
	
}
