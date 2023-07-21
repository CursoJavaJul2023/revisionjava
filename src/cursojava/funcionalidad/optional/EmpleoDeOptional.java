package cursojava.funcionalidad.optional;

import java.util.Optional;

import cursojava.lenguaje.basico.tipos.clases.Cliente;

public class EmpleoDeOptional {
	
	public static Cliente buscarPorNif(String nif) {
		
		if(nif.startsWith("1")) {
			return new Cliente("Luis", "Pérez");
		}
		
		return null;		
	}
	
	public static Optional<Cliente> buscarPorNifConOptional(String nif) {
		
		if(nif.startsWith("1")) {
			return Optional.of(new Cliente("Luis", "Pérez"));
		}
		
		return Optional.empty();
	}
	
	public static void main(String[] args) {
		
		Cliente cliente = buscarPorNif("2020202");
		if(cliente != null) {
			
		}
		
		Optional<Cliente> optional = buscarPorNifConOptional("202020");
		
		if(optional.isPresent()) {
			Cliente encontrado = optional.get();
		}
		
		optional.ifPresent( System.out::println );
		
		optional.ifPresentOrElse( System.out::println, () -> System.out.println("Cliente no encontrado"));
		
		Cliente algo = optional.orElse(new Cliente("Por", "defecto"));
		
		
	}

}





