package cursojava.lenguaje.basico.lambdas;

@FunctionalInterface
public interface Filtro<T> {	
	
	boolean comprobar(T valor);

}
